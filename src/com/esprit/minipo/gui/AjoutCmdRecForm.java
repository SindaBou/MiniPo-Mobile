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

import com.codename1.capture.Capture;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.FloatingHint;
import com.codename1.components.ScaleImageLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.io.Util;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.validation.GroupConstraint;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.util.Base64;
import com.esprit.minipo.entites.ReclamationClient;
import com.esprit.minipo.services.ServiceRecClient;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import rest.file.uploader.tn.FileUploader;



/**
 * GUI builder created Form
 *
 * @author shai
 */
public class AjoutCmdRecForm extends BaseForm {
final String pc="probleme de compte";
        final String pcmd="probleme de commande";
        final String autre="autre";
        public int idcatrec=0;
        public int id=SignInForm.idUser;
        //public int idcmd=1;
        //String refC="123456";
        String Imagecode ;
        private FileUploader file;
        String fileNameInServer;
        private String imgPath;

        
    public AjoutCmdRecForm(com.codename1.ui.util.Resources resourceObjectInstance,int idcmd,String refC , String etatl) {
        
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        System.out.println(idcmd);
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
         getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        setTitle("Envoyer Une Reclamation");
        setLayout(BoxLayout.y());
        TextModeLayout tl = new TextModeLayout(2, 2);
        TextComponent tfObjet = new TextComponent().label("objet");
        
        tfObjet.putClientProperty("goButton", Boolean.TRUE);

        TextComponent taDescription = new TextComponent().label("Description").multiline(true);
        taDescription.rows(5);
        TableLayout fullNameLayout = new TableLayout(2, 2);
        
        //Container c2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        //Container c3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container CONTAINER=new Container(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
        Container container=new Container(tl);
        Container containerImage=new Container(fullNameLayout);
        //c2.add(tfObjet);
        //c3.add(taDescription);
        
       
         //tfObjet = new TextField("","Objet");
         //taDescription= new TextArea(10, 15);
         //taDescription.setHint("Description");
          path = new Label(".");
         
         imgBtn = new Button();
         imgBtn.setUIID("btnImage");
         imgBtn.setMaterialIcon(FontImage.MATERIAL_ADD_A_PHOTO);
        imgBtn.setPreferredSize(new Dimension(150,150));
         Button cancel = new Button("Cancel"); 
         //fullNameLayout.setWidthPercentage(20);
          containerImage.add(fullNameLayout.createConstraint().widthPercentage(85),path)
                        .add(fullNameLayout.createConstraint().widthPercentage(15),imgBtn);
        Button btnValider = new Button("Envoyer");
        btnValider.setPreferredSize(new Dimension(50,110)); 
        tCategorie.setText("Probleme de commande ");
        LabelCategorie.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        tCategorie.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_SMALL));
        tCategorie.getAllStyles().setFgColor(0x000000);
        tRefc.setText(refC);
        LabelRefC.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        tRefc.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_SMALL));
        tRefc.getAllStyles().setFgColor(0x000000);
        Validator val = new Validator();
        val.addConstraint(tfObjet,new GroupConstraint(new LengthConstraint(2,"trop court"),new ServiceRecClient(5,"trop long")));
        val.addConstraint(taDescription, new LengthConstraint(2,"trop court"));
        //val.addConstraint(price, new NumericConstraint(true));
       /* Container box = BoxLayout.encloseY(
        c,
        tfObjet,
        taDescription,
        path,
        imgBtn,
            GridLayout.encloseIn(2, cancel, btnValider));*/
      
container.add(LabelCategorie).add(tCategorie).add(LabelRefC).add(tRefc).add(tl.createConstraint().widthPercentage(49), tfObjet).
        add(tl.createConstraint().widthPercentage(1), createSeparator()).
        add(tl.createConstraint().horizontalSpan(50), taDescription)
        .add(containerImage).add(btnValider);
 //************************
/* Style btnImageStyle = imgBtn.getAllStyles();
Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
btnImageStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStroke));*/
//*********************
Style btnStyle = btnValider.getAllStyles();
Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
btnStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStroke));
//*******************
//CONTAINER.add(container);
Style cStyle = c.getAllStyles();
//Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
cStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStroke));
cStyle.setBgColor(0xfcddce);
cStyle.setBgTransparency(255);
cStyle.setBackgroundGradientRelativeX(0xf4753f);
cStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
cStyle.setMargin(Component.BOTTOM, 3);
//******************
Style loginStyle = tfObjet.getAllStyles();
//Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
loginStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
loginStyle.setBgColor(0xffffff);
loginStyle.setBgTransparency(255);
loginStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
loginStyle.setMargin(Component.BOTTOM, 3);
//**********************************
Style passwordStyle = taDescription.getAllStyles();
passwordStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
passwordStyle.setBgColor(0xffffff);
passwordStyle.setBgTransparency(255);

        Button closeButton = new Button();
        closeButton.setPreferredSize(new Dimension(40,40));
Style closeStyle = closeButton.getAllStyles();
closeStyle.setFgColor(0xffffff);
closeStyle.setBgTransparency(0);
closeStyle.setPaddingUnit(Style.UNIT_TYPE_DIPS);
closeStyle.setPadding(3, 3, 3, 3);
//closeStyle.setBorder(RoundBorder.create().shadowOpacity(100));
FontImage.setMaterialIcon(closeButton, FontImage.MATERIAL_CANCEL);

Container layers = LayeredLayout.encloseIn(container, FlowLayout.encloseRight());
Style boxStyle = container.getUnselectedStyle();
boxStyle.setBgTransparency(255);
//boxStyle.setBgColor(0xeeeeee);
boxStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
boxStyle.setPaddingUnit(Style.UNIT_TYPE_DIPS);
boxStyle.setMargin(4, 3, 3, 3);
boxStyle.setPadding(2, 2, 2, 2);
        //gui_Container_3.add(tl.createConstraint().widthPercentage(60),tfObjet);
        imgBtn.addPointerPressedListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    imgPath = Capture.capturePhoto();
                    System.out.println(imgPath);
                    String link=imgPath.toString();
                    int pod=link.indexOf("/",2);
                    String news=link.substring(pod + 2, link.length());
                    System.out.println(""+news);
                    FileUploader fu = new FileUploader("http://localhost:82/Minipo/Minipo/web/uploads/");
                    fileNameInServer = fu.upload(news);
                    path.setText(fileNameInServer);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfObjet.getText().length()==0)||(taDescription.getText().length()==0)){
                    Dialog.show("Alert", "Veuillez remplir tous les champs.", new Command("OK"));
                    //tfObjet.textComponentErrorColor("");


                }
                
                else{
                    if(taDescription.getText().length()<5)
                    Dialog.show("Alert", "Description trop courte", new Command("OK"));
                else
                {
                    
                       
                        ReclamationClient r = new ReclamationClient(2, tfObjet.getText(),taDescription.getText(),id,fileNameInServer,idcmd);
                        System.out.println(r.toString());
                        if( ServiceRecClient.getInstance().addRecCmd(r)){
                            Dialog.show("Success","Reclamation envoyee avec succés",new Command("OK"));
                            
                       /*  String myURL = "https://rest.nexmo.com/sms/json?api_key=4f3be2fc&api_secret=9ipalAypbzNudeVl&to=21698327784" + "&from=Minipo&text=Reclamation Envoyee avec succés";
                ConnectionRequest cntRqst = new ConnectionRequest() {
                    protected void readResponse(InputStream in) throws IOException {
                    }

                    @Override
                    protected void postResponse() {
                        Dialog.show("SMS", "Un SMS vous a été envoyé ", "OK", null);

                    }
                };
                cntRqst.setUrl(myURL);
                NetworkManager.getInstance().addToQueue(cntRqst);*/
                new MesRecClientForm().show();
            }
            
                        
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    
                    
                }
                
                
            }}
        });
 
        // container.add(tl.createConstraint().widthPercentage(60), tfObjet);
        Container entetec=new Container(BoxLayout.x());
        entetec.setUIID("DesignEnTete");
        Label back=new Label();
        FontImage iconB = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, "Supprimer", 4.9f);
        back.setIcon(iconB);
        Label title=new Label("Reclamation");
        entetec.add(back).add(title);
        add(entetec);
        add( layers);
         back.addPointerPressedListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                new AboutCmdForm(resourceObjectInstance, idcmd , etatl).show();
            }
        });
        //addComponent(tl.createConstraint().widthPercentage(60), tfObjet);
        //addAll(c,container,containerImage,btnValider);
        //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

            
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    private com.codename1.ui.ComboBox c = new com.codename1.ui.ComboBox();
    private com.codename1.ui.Label LabelCategorie = new com.codename1.ui.Label("Categorie : ");
    private com.codename1.ui.Label tCategorie = new com.codename1.ui.Label();
    private com.codename1.ui.Label LabelRefC = new com.codename1.ui.Label("Reference:");
    private com.codename1.ui.Label tRefc = new com.codename1.ui.Label();
    private com.codename1.ui.TextField tfObjet = new com.codename1.ui.TextField();
    private com.codename1.ui.TextArea taDescription = new com.codename1.ui.TextArea();
    private com.codename1.ui.Label path=new com.codename1.ui.Label();
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
   private com.codename1.ui.Container gui_audio = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));



// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Envoyer une Reclamation");
        setName("AjoutRecForm1");
        //addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, c);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, tfObjet);
        //gui_Container_1.addComponent(tl.createConstraint().widthPercentage(60), tfObjet);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, taDescription);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, path);
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
       /* gui_null_1_1_1.setUIID("Label");
        gui_null_1_1_1.setName("null_1_1_1");
        gui_null_1_1_1.setIcon(resourceObjectInstance.getImage("contact-b.png"));
        gui_null_1_1_1.setPropertyValue("line1", "Detra Mcmunn");
        gui_null_1_1_1.setPropertyValue("line2", "@dropperidiot");
        gui_null_1_1_1.setPropertyValue("uiid1", "Label");
        gui_null_1_1_1.setPropertyValue("uiid2", "RedLabel");*/
        //gui_newYork.setUIID("Label");
        //gui_newYork.setName("newYork");
        //gui_newYork.setPropertyValue("line1", "15 minutes ago");
        //gui_newYork.setPropertyValue("line2", "in New York");
        //gui_newYork.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
        //gui_newYork.setPropertyValue("uiid2", "RedLabelRight");
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
    private Label createSeparator() {
    Label sep = new Label();
    sep.setUIID("Separator");
    // the separator line  is implemented in the theme using padding and background color, by default labels
    // are hidden when they have no content, this method disables that behavior
    sep.setShowEvenIfBlank(true);
    return sep;
}
}
