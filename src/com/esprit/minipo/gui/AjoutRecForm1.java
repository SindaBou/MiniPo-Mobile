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
import com.codename1.components.ScaleImageLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.io.Util;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.ImageIO;
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
public class AjoutRecForm1 extends BaseForm {
final String pc="probleme de compte";
        final String pcmd="probleme de commande";
        final String autre="autre";
        public int idcatrec=0;
        public int id=45;
        String Imagecode ;
        private FileUploader file;
        String fileNameInServer;
        private String imgPath;
    public AjoutRecForm1() {
        
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public AjoutRecForm1(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
         getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        setTitle("Envoyer Une Reclamation");
        setLayout(BoxLayout.y());
         tfObjet = new TextField("","Objet");
         taDescription= new TextArea(10, 15);
         taDescription.setHint("Description");
          path = new TextField();
         imgBtn = new Button("parcourir ");
         imgBtn.setMaterialIcon(FontImage.MATERIAL_CLOUD_UPLOAD);
        Button btnValider = new Button("Envoyer");
        ComboBox c= new ComboBox("categorie");
        c.addItem(pc);
        c.addItem(pcmd);
        c.addItem(autre);
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
                    FileUploader fu = new FileUploader("http://localhost:82/MiniPo-web/web/uploads/");
                    fileNameInServer = fu.upload(news);
                    path.setText(fileNameInServer);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        /*imgBtn.addActionListener(e -> {
            Display.getInstance().openGallery(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    if (ev != null && ev.getSource() != null) {
                       String path = (String) ev.getSource();
                        System.out.println(path.substring(7));
                        Image img = null;
                        image.setText(path.substring(7));//image heya just label nsob feha fel path
                        try {
                            img = Image.createImage(FileSystemStorage.getInstance().openInputStream(path));
                            System.out.println(img);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }, Display.GALLERY_IMAGE);
        });*/
           /*   Container imageC = new Container(new BoxLayout(BoxLayout.X_AXIS));
       Label  imageL= new Label("Image:");
       TextField  imageT= new TextField("",13);
         imageT.setEditable(false);
       Button  addImage= new Button("...");
         addImage.addActionListener(e->{
             String filePath = Capture.capturePhoto();
             Image img = null;
             if (filePath != null) {
            try {
                img = Image.createImage(filePath);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
         
            ImageIO imgIO = ImageIO.getImageIO();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
                 try {
                     imgIO.save(img, out, ImageIO.FORMAT_JPEG, 1);
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 }
            byte[] ba = out.toByteArray();
             Imagecode = Base64.encode(ba);
                imageT.setText(Imagecode);
             //imageT.setText((new  ArticleService()).uploadImage(Imagecode));
                }
        
         });
         imageC.add(imageL);
         imageC.add(imageT);
         imageC.add(addImage);
        */
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfObjet.getText().length()==0)||(taDescription.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    
                         switch (c.getSelectedItem().toString()) {
                    case pc:
                        idcatrec=1;
                         break;
                    case pcmd:
                        idcatrec=2;
                        break;
                    case autre:
                        idcatrec=3;
                         break;}
                        
                        ReclamationClient r = new ReclamationClient(idcatrec, tfObjet.getText(),taDescription.getText(),id,fileNameInServer);
                        if( ServiceRecClient.getInstance().addRec(r)){
                            Dialog.show("Success","Reclamation envoyee avec succés",new Command("OK"));
                         /*String myURL = "https://rest.nexmo.com/sms/json?api_key=4f3be2fc&api_secret=9ipalAypbzNudeVl&to=21698327784" + "&from=Minipo&text=Reclamation Envoyee avec succés";
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
                
                
            }
        });
 
         
        
        addAll(c,tfObjet,taDescription,path,imgBtn,btnValider);
        //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

            
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    private com.codename1.ui.ComboBox c = new com.codename1.ui.ComboBox();
    private com.codename1.ui.TextField tfObjet = new com.codename1.ui.TextField();
    private com.codename1.ui.TextArea taDescription = new com.codename1.ui.TextArea();
    private com.codename1.ui.TextField path=new com.codename1.ui.TextField();
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
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, c);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, tfObjet);
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
