/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
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
public class InfoProdForm extends BaseForm{
    
    private EncodedImage placeHolder;
  
  
    
    public InfoProdForm() {
        
        //this(com.codename1.ui.util.Resources.getGlobalResources());
    }
     
    
    Form current;

    public InfoProdForm(com.codename1.ui.util.Resources resourceObjectInstance ,
            String description , String designation , float px , String photo , int idProd) {
    
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        
        current=this;
        setTitle("Test Panier");
        setLayout(BoxLayout.y());
        initGuiBuilderComponents(resourceObjectInstance ,description , designation , px , photo , idProd );
        
    }
    
     private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance ,
             String description , String designation , float px , String photo ,int idProd) {
        
         
        
       /* Container container_1=new Container(BoxLayout.y());
        Container container_2=new Container(BoxLayout.x());
        Container container_3=new Container(BoxLayout.y());
        Container container_4=new Container(new FlowLayout());
        Container container_5=new Container(new FlowLayout());
        
        
        placeHolder = EncodedImage.createFromImage(resourceObjectInstance.getImage("panier.png"), false);
        //String url="http://localhost:82/Minipo/Minipo/web/assetsC/img/products/"+photo;
        Image img = URLImage.createToStorage(placeHolder, photo, photo, URLImage.RESIZE_SCALE);
        
        SpanLabel desg=new SpanLabel(designation);
        
        Label prix=new Label(String.valueOf(px));
        
        container_3.add(desg).add(prix);
        
        container_2.add(img).add(container_3);
        
        //SpanLabel desc = new SpanLabel(description);
        //container_4.add(desc);
        
        Label q=new Label("Qte:");
        TextField Txt_qte=new TextField();
        Txt_qte.setColumns(4);
        Button ajouter=new Button("Ajouter au panier");
        container_5.add(q).add(Txt_qte).add(ajouter);
        
        container_1.addAll(container_2,container_4,container_5);
        
        addComponent(container_1);*/
       //*************************************************************************
       /*Container container_1=new Container(BoxLayout.y());
       Container container_3=new Container(BoxLayout.y());
       Container container_2=new Container(BoxLayout.x());
       Container container_4=new Container(BoxLayout.x());
       
       Label q=new Label("Qte:");
       TextField Txt_qte=new TextField();
       Txt_qte.setColumns(4);
       container_4.add(q).add(Txt_qte);
       
       SpanLabel desg=new SpanLabel(designation);
       Label prix=new Label(String.valueOf(px));
       container_3.add(desg).add(prix).add(container_4);
       
        placeHolder = EncodedImage.createFromImage(resourceObjectInstance.getImage("panier.png"), false);
        //String url="http://localhost:82/Minipo/Minipo/web/assetsC/img/products/"+photo;
        Image img = URLImage.createToStorage(placeHolder, photo, photo, URLImage.RESIZE_SCALE);
        container_2.add(img).add(container_3);
        
        Button ajouter=new Button("Ajouter au panier");
        container_1.add(container_2).add(ajouter);
        addComponent(container_1);*/
       
       
       Container container_1=new Container(BoxLayout.y());
       Container container_2=new Container(BoxLayout.x());
       container_2.setUIID("DesignEnTete");
       Container container_3=new Container(BoxLayout.y());
       container_3.setUIID("ContainerInfoProd");
       Container container_4=new Container(BoxLayout.x());
       container_4.setUIID("MarginImage");
       Container container_5=new Container(BoxLayout.y());
       Container container_5_1 =new Container(new FlowLayout(CENTER, CENTER));
       Container container_6=new Container(new FlowLayout(RIGHT));
       container_6.setUIID("MarginQteIB");
       
       Label q=new Label("Quantité:");
       TextField Txt_qte=new TextField();
       Txt_qte.setColumns(1);
       Txt_qte.setUIID("TxtQte");
       FontImage iconp = FontImage.createMaterial(FontImage.MATERIAL_ADD_SHOPPING_CART, "Back", 4.9f);
       Button ajouter=new Button();
       ajouter.setIcon(iconp);
       ajouter.setUIID("ButtonCard");
       ajouter.setPreferredSize(new Dimension(150,150));
       
       
       
       container_6.add(q).add(Txt_qte).add(ajouter);
       
       
       SpanLabel desg=new SpanLabel(designation);
       desg.setUIID("DesgLabel");
       Label prix=new Label(String.valueOf(px)+".0TND");
       //prix.setUIID("RedLabel");GetStartedRedArrow
       prix.setUIID("PrixLabel");
       container_5.add(desg).add(prix);
       container_5_1.add(container_5);
       
       
       placeHolder = EncodedImage.createFromImage(resourceObjectInstance.getImage("panier.png"), false);
      // String url="http://localhost:82/Minipo/Minipo/web/assetsC/img/products/"+photo;
         System.out.println(photo);
       Image img = URLImage.createToStorage(placeHolder, photo,photo, URLImage.RESIZE_SCALE);
       ImageViewer mm=new ImageViewer(img);
       mm.setPreferredSize(new Dimension(400,400));
       
       
       container_4.add(mm).add(container_5_1);
       
       
               
       SpanLabel desc=new SpanLabel(description);
       desc.setUIID("MarginImage");
       container_3.add(container_4).add(desc).add(container_6);
       
       
        
        Label back=new Label();
        FontImage iconB = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, "Back", 3.0f);
        back.setIcon(iconB);
        Label title=new Label("Panier");
        container_2.add(back).add(title);
        
        container_1.add(container_2).add(container_3);
        addComponent(container_1);
        
        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                if (Txt_qte.getText().length()==0)
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        if( ServiceLigneCommande.getInstance().addLc(idProd,
                            Integer.parseInt(Txt_qte.getText()))){
                            new PanierForm().show();
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "quantity must be a number", new Command("OK"));
                    }
                    
                }   
            
            
            }
       

        
    });
}
    
    
}
