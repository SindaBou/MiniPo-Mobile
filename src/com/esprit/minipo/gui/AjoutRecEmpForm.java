/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.minipo.entites.ReclamationClient;
import com.esprit.minipo.entites.ReclamationsEmploye;
import com.esprit.minipo.services.ServiceRecClient;
import com.esprit.minipo.services.ServiceRecEmploye;
import com.codename1.capture.Capture;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import java.io.IOException;
import java.util.Date;
import rest.file.uploader.tn.FileUploader;


/**
 *
 * @author bhk
 */
public class AjoutRecEmpForm extends BaseEmployeForm1{
        final String pc="probleme de compte";
        //final String pcmd="probleme de commande";
        final String autre="autre";
        public int idcatrec=0;
        public int id=44;
        private FileUploader file;
        String fileNameInServer;
        private String imgPath;
    public AjoutRecEmpForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
         getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        setTitle("Envoyer une Reclamation");
        setLayout(BoxLayout.y());
        TextField tfObjet = new TextField("","Objet");
        TextArea taDescription= new TextArea(10, 10);
        taDescription.setHint("Description");
        Button btnValider = new Button("Envoyer");
        path = new TextField();
        imgBtn = new Button("parcourir ");
        imgBtn.setMaterialIcon(FontImage.MATERIAL_CLOUD_UPLOAD);
        ComboBox c= new ComboBox();
        c.addItem(pc);
        //c.addItem(pcmd);
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
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfObjet.getText().length()==0)||(taDescription.getText().length()==0))
                    Dialog.show("Alert", "Veuillez remplir tous les champs", new Command("OK"));
                else
                {
                    try {
                         switch (c.getSelectedItem().toString()) {
                    case pc:
                        idcatrec=1;
                         break;
                    /*case pcmd:
                        idcatrec=2;
                        break;*/
                    case autre:
                        idcatrec=3;
                         break;}
                        
                        ReclamationsEmploye r = new ReclamationsEmploye(id,idcatrec, tfObjet.getText(),taDescription.getText(),fileNameInServer);
                        if( ServiceRecEmploye.getInstance().addRec(r)){
                            Dialog.show("Success","Reclamation Envoyée",new Command("OK"));
                             ToastBar.Status status = ToastBar.getInstance().createStatus();
                             status.setMessage("Reclamation envoyée");
                             status.show();
                           new MesRecEmpForm().show();
                        }
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(c,tfObjet,taDescription,path ,imgBtn,btnValider);
        //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    private com.codename1.ui.TextField path=new com.codename1.ui.TextField();
    private com.codename1.ui.Button imgBtn = new com.codename1.ui.Button();
    
    
}
