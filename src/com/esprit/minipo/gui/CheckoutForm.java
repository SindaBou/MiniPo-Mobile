/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.processing.Result;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import com.esprit.minipo.entites.Panier;
import com.esprit.minipo.services.ServiceCommande;
import com.esprit.minipo.services.ServiceLigneCommande;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import javafx.scene.image.ImageView;

/**
 *
 * @author bhk
 */
public class CheckoutForm extends BaseForm{

    TextField apiKey = new TextField("AIzaSyAtE4EwLkp9pdY3KXEQszFg-tpsiUc6x1o");
    final DefaultListModel<String> options = new DefaultListModel<>();
    
   /* public CheckoutForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }*/
     
    
    Form current;
    
    public CheckoutForm(com.codename1.ui.util.Resources resourceObjectInstance , int idcmd, String refc) {
    
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm(resourceObjectInstance, current).show();}); 
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        
        current=this;
        setTitle("Checkout");
        setLayout(BoxLayout.y());
        initGuiBuilderComponents(resourceObjectInstance,idcmd,refc);
        
    }
    
     private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance, int idcmd ,String refc) {
        
        int id=SignInForm.idUser;
        
        //Container container_2=new Container(new FlowLayout(CENTER,CENTER));
        Container container_1=new Container(BoxLayout.yCenter());
        SpanLabel l=new SpanLabel("Veuillez saisir une destination pour votre commande svp :  ");
        
        AutoCompleteTextField TA_dest = new
        AutoCompleteTextField("Short", "Shock", "Sholder", "Shrek");
        TA_dest.setMinimumElementsShownInPopup(5);
        TA_dest.setUIID("des");
        
        Button liv=new Button("Livrer");
        
        liv.setPreferredSize(new Dimension(50,110));
        Style btnStyle = liv.getAllStyles();
        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        btnStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStroke));
        
        AutoCompleteTextField ac = new AutoCompleteTextField(options) {
			 @Override
			 protected boolean filter(String text) {
				 if(text.length() == 0) {
					return false;
				 }
				 String[] l = searchLocations(text);
				 if(l == null || l.length == 0) {
					return false;
				 }
				 options.removeAll();
				 for(String s : l) {
					options.addItem(s);
				 }
				 return true;
			}

		 };
		 ac.setMinimumElementsShownInPopup(5);
                 
                Container entetec=new Container(BoxLayout.x());
                entetec.setUIID("DesignEnTete");
                Label back=new Label();
                FontImage iconB = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, "Back", 4.9f);
                back.setIcon(iconB);
                Label title=new Label(refc);
                entetec.add(back).add(title);
                 
		 container_1.add(l).add(ac).add(liv);
                 addComponent(entetec);
                 addComponent(container_1);
                 
                  back.addPointerPressedListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            new PanierForm().showBack();
                        }
                    });
                 
		 //current.getToolbar().addCommandToRightBar("Get Key", null, e ->
		 //Display.getInstance().execute("https://developers.google.com/places/webservice/get-api-key"));
                 
                 Validator v = new Validator();
                 v.addConstraint(ac, new LengthConstraint(3));
                 v.addSubmitButtons(liv);
   
        liv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String dest= ac.getText();
                System.out.println(dest);
             if (ac.getText().length()==0)
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    
                        if( ServiceCommande.getInstance().validerCmd(dest)){
                            new AboutCmdForm(resourceObjectInstance, idcmd , "non livree" ).show();
                            Dialog.show("Success","la commande à été valider avec success",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                   
                    
                }      
            
            }
        });
     }
     
    String[] searchLocations(String text) {
			 try {
				 if(text.length() > 0) {
					 ConnectionRequest r = new ConnectionRequest();
					 r.setPost(false);
					 r.setUrl("https://maps.googleapis.com/maps/api/place/autocomplete/json");           
					 r.addArgument("key", apiKey.getText());
					 r.addArgument("input", text);
					 NetworkManager.getInstance().addToQueueAndWait(r);
					 Map<String,Object> result = new
					 JSONParser().parseJSON(new InputStreamReader(new
					 ByteArrayInputStream(r.getResponseData()), "UTF-8"));
					 String[] res = Result.fromContent(result).getAsStringArray("//description");
					 return res;
				 }
			 } catch(Exception err) {
				Log.e(err);
			 }
			 return null;
		}
    
        
    
    
}
