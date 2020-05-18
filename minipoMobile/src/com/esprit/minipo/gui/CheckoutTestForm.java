/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
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
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;
import com.esprit.minipo.entites.Panier;
import com.esprit.minipo.services.ServiceCommande;
import com.esprit.minipo.services.ServiceLigneCommande;
import java.util.ArrayList;
import javafx.scene.image.ImageView;

/**
 *
 * @author bhk
 */
public class CheckoutTestForm extends BaseForm{

    
   /* public CheckoutForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }*/
     
    
    Form current;

    public CheckoutTestForm(com.codename1.ui.util.Resources resourceObjectInstance , int idcmd) {
    
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        
        current=this;
        setTitle("Test Panier");
        setLayout(new FlowLayout(CENTER,CENTER));
        initGuiBuilderComponents(resourceObjectInstance,idcmd);
        
    }
    
     private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance, int idcmd) {
        
        int id=45;
        
        Container container_1=new Container(BoxLayout.y());
        SpanLabel l=new SpanLabel("Veuillez saisir une destination pour votre commande svp :  ");
        
        AutoCompleteTextField TA_dest = new
        AutoCompleteTextField("Short", "Shock", "Sholder", "Shrek");
        TA_dest.setMinimumElementsShownInPopup(5);

        
        //TextArea TA_dest = new TextArea();
        TA_dest.setUIID("des");
        Button liv=new Button("Livrer");
        
        liv.setPreferredSize(new Dimension(50,110));
        Style btnStyle = liv.getAllStyles();
        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        btnStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStroke));
        
        container_1.add(l).add(TA_dest).add(liv);
        //container_1.setUIID("ContainerCheckout");
        addComponent(container_1);
        
        
        
      /*  liv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String dest= TA_dest.getText();
                System.out.println(dest);
             if (TA_dest.getText().length()==0)
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    
                        if( ServiceCommande.getInstance().validerCmd(dest)){
                            new AboutCmdForm(resourceObjectInstance, idcmd).show();
                            Dialog.show("Success","la commande à été valider avec success",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                   
                    
                }      
            
            }
        });*/
        
        
        
        
       
    }
    
    
}
