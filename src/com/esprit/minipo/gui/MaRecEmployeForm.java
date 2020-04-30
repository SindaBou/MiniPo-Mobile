/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.esprit.minipo.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.location.Geofence;
import com.codename1.location.LocationManager;
import com.codename1.notifications.LocalNotification;
import com.codename1.notifications.LocalNotificationCallback;
import com.codename1.push.Push;
import com.codename1.push.PushAction;
import com.codename1.push.PushActionCategory;
import com.codename1.push.PushActionsProvider;
import com.codename1.push.PushCallback;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.esprit.minipo.entites.ReclamationClient;
import com.esprit.minipo.services.ServiceRecClient;
import com.esprit.minipo.services.ServiceRecEmploye;
import java.io.IOException;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class MaRecEmployeForm extends BaseEmployeForm1 implements LocalNotificationCallback {
//final String pc="probleme de compte";
        //final String pcmd="probleme de commande";
        //final String autre="autre";
        //public int idcatrec=0;
        public int id=44;
        String notif="demo-notification";
        private EncodedImage placeHolder;
    public MaRecEmployeForm(com.codename1.ui.util.Resources resourceObjectInstance ,int idremp,String categorie,String objet,String description,String image,String etat,String reponse) {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
        
        System.out.println(idremp);
        System.out.println(categorie);
        System.out.println(description);
        System.out.println(objet);
        System.out.println(image);
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
         getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        setTitle("Ma Reclamation");
        setLayout(BoxLayout.y());
        LabelEtat.setText(etat);
        LabelEtat.setUIID("RedLabel");
        LabelEtat.setHeight(30);
        LabelEtat.setWidth(100);
        LabelCategorie.setText("Categorie");
        LabelDescription.setText("Description");
        LabelObjet.setText("Objet");
        tCategorie.setText(categorie);
        tCategorie.setUIID("BlackLabel");
         tfObjet.setText(objet);
         tfObjet.setUIID("BlackLabel");
         taDescription.setUIID("BlackLabel");
         taDescription.setText(description);
         Ldescription.setText(description);
         Ldescription.setUIID("BlackLabel");
         LReponse.setText(reponse);
         LReponse.setUIID("RedLabel");
            //Image img1=URLImage.createToStorage(placeHolder, "photo"+id, url);
            //Image img1=URLImage.createToStorage(placeHolder,url, url,URLImage.RESIZE_SCALE);
          //image = new TextField();
         //imgBtn = new Button("parcourir image");
        Button btnValider = new Button("Modifier");
        placeHolder = EncodedImage.createFromImage(resourceObjectInstance.getImage("panier.png"), false); // hethi t7otoha fel default package 
           String url="http://localhost:82/MiniPo-web/web/uploads/post/"+image;
           Image image1=URLImage.createToStorage(placeHolder, url, url,URLImage.RESIZE_SCALE);
        Container c =new Container(new FlowLayout(CENTER,CENTER));
        //gui_Container_1.add(btnValider);
        c.add(image1);
        if(etat.equals("non traiter")){
        addAll(LabelEtat,LabelCategorie,tCategorie,LabelObjet,tfObjet,LabelDescription,taDescription,c,btnValider);}
        if(etat.equals("traiter")){
        addAll(LabelEtat,LabelCategorie,tCategorie,LabelObjet,tfObjet,LabelDescription,Ldescription,c,LabelReponse,LReponse);}
        btnValider.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                //getPushActionCategories();
                if( ServiceRecEmploye.getInstance().ModifierRecEmploye(idremp,taDescription.getText())){
                       /*    LocalNotification n = new LocalNotification();
                          n.setId("demo-notification");
                          n.setAlertBody("It's time to take a break and look at me");
                          n.setAlertTitle("Break Time!");
                          n.setAlertSound("/notification_sound_beep-01a.mp3");
    // alert sound file name must begin with notification_sound
                         /* ToastBar.Status status = ToastBar.getInstance().createStatus();
                          status.setMessage("Hello world");
                          status.show();*/
                         
                         /* Display.getInstance().scheduleLocalNotification(
                                n,
                            System.currentTimeMillis() + 10 * 1000, // fire date/time
                            LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency);*/

                           new MesRecEmpForm( resourceObjectInstance).show();
                
                }
               
                
                
            }
        });
       
           
          
                         
        //gui_Container_1.add(tCategorie);
        //gui_Container_1.add(tfObjet);
        //gui_Container_1.add(taDescription);
       //gui_Container_1.add(image1)
       
        //c.add(c)
        //c.add(image1);
        
    }
    
    public MaRecEmployeForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
       
        //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
 public void localNotificationReceived(String notif) {
        System.out.println("Received local notification "+notif);
            }
//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    private com.codename1.ui.ComboBox c = new com.codename1.ui.ComboBox();
    private com.codename1.ui.Label LabelEtat = new com.codename1.ui.Label();
    private com.codename1.ui.Label LabelReponse = new com.codename1.ui.Label("Reponse");
    private com.codename1.ui.Label LReponse = new com.codename1.ui.Label();
    private com.codename1.ui.Label LabelCategorie = new com.codename1.ui.Label();
    private com.codename1.ui.Label tCategorie = new com.codename1.ui.Label();
    private com.codename1.ui.Label tfObjet = new com.codename1.ui.Label();
    private com.codename1.ui.Label Ldescription = new com.codename1.ui.Label();
    private com.codename1.ui.Label LabelObjet = new com.codename1.ui.Label();
    private com.codename1.ui.Label LabelDescription = new com.codename1.ui.Label();
   // private com.codename1.ui.TextField tCategorie = new com.codename1.ui.TextField();
    //private com.codename1.ui.TextField tfObjet = new com.codename1.ui.TextField();
    private com.codename1.ui.TextArea taDescription = new com.codename1.ui.TextArea();
    private com.codename1.ui.TextField image=new com.codename1.ui.TextField();
    private com.codename1.ui.Button imgBtn = new com.codename1.ui.Button();
    private com.codename1.ui.Button btnValider= new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_null_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.components.MultiButton gui_null_1_1_1 = new com.codename1.components.MultiButton();
    private com.codename1.components.MultiButton gui_newYork = new com.codename1.components.MultiButton();
    private com.codename1.ui.Container gui_imageContainer2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Envoyer une Reclamation");
        setName("AjoutRecForm1");
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, c);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, tfObjet);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, taDescription);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, image);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, imgBtn);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, btnValider);
        gui_Multi_Button_1.setUIID("Label");
        gui_Multi_Button_1.setName("Multi_Button_1");
        gui_Multi_Button_1.setIcon(resourceObjectInstance.getImage("contact-c.png"));
        gui_Multi_Button_1.setPropertyValue("line1", "Ami Koehler");
        gui_Multi_Button_1.setPropertyValue("line2", "@dropperidiot");
        gui_Multi_Button_1.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_1.setPropertyValue("uiid2", "RedLabel");
        addComponent(gui_separator1);
        addComponent(gui_null_1_1);
        gui_null_1_1.setName("null_1_1");
        gui_null_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_null_1_1_1);
        gui_null_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_newYork);
        gui_null_1_1_1.setUIID("Label");
        gui_null_1_1_1.setName("null_1_1_1");
        gui_null_1_1_1.setIcon(resourceObjectInstance.getImage("contact-b.png"));
        gui_null_1_1_1.setPropertyValue("line1", "Detra Mcmunn");
        gui_null_1_1_1.setPropertyValue("line2", "@dropperidiot");
        gui_null_1_1_1.setPropertyValue("uiid1", "Label");
        gui_null_1_1_1.setPropertyValue("uiid2", "RedLabel");
        gui_newYork.setUIID("Label");
        gui_newYork.setName("newYork");
        gui_newYork.setPropertyValue("line1", "15 minutes ago");
        gui_newYork.setPropertyValue("line2", "in New York");
        gui_newYork.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
        gui_newYork.setPropertyValue("uiid2", "RedLabelRight");
        addComponent(gui_imageContainer2);
        gui_imageContainer2.setName("imageContainer2");
        gui_imageContainer2.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_3);
        gui_Container_3.setName("Container_3");
        gui_Container_3.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_2);
        gui_Container_3.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Button_2);
        gui_Text_Area_2.setText("Griffith Observatory is a facility in Los Angeles, California sitting on the south-facing slope of Mount Hollywood in Los Angeles' Griffith Park.");
        gui_Text_Area_2.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_2.setName("Text_Area_2");
        gui_Button_2.setText("");
        gui_Button_2.setUIID("Label");
        gui_Button_2.setName("Button_2");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_2,"".charAt(0));
        gui_Container_3.setName("Container_3");
        addComponent(gui_Label_1_1_1);
        gui_Container_1.setName("Container_1");
       
        gui_separator1.setUIID("Separator");
        gui_separator1.setName("separator1");
        gui_null_1_1.setName("null_1_1");
        gui_imageContainer2.setName("imageContainer2");
        gui_Label_1_1_1.setUIID("Separator");
        gui_Label_1_1_1.setName("Label_1_1_1");
       
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

    @Override
    protected boolean isCurrentTrending() {
        return true;
    }

   

 

    
}
