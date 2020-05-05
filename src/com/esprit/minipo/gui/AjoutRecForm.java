/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.minipo.entites.ReclamationClient;
import com.esprit.minipo.services.ServiceRecClient;
import java.io.IOException;


/**
 *
 * @author bhk
 */
public class AjoutRecForm  extends BaseForm{
        final String pc="probleme de compte";
        final String pcmd="probleme de commande";
        final String autre="autre";
        public int idcatrec=0;
        public int id=45;
        String img;
    public AjoutRecForm(Form previous) {
        
        setTitle("Envoyer Une Reclamation");
        setLayout(BoxLayout.y());
        TextField tfObjet = new TextField("","Objet");
        TextArea taDescription= new TextArea(10, 15);
        TextField image = new TextField();
        Button imgBtn = new Button("parcourir image");
        Button btnValider = new Button("Add task");
        ComboBox c= new ComboBox("categorie");
        c.addItem(pc);
        c.addItem(pcmd);
        c.addItem(autre);
        imgBtn.addActionListener(e -> {
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
        });
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfObjet.getText().length()==0)||(taDescription.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
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
                        
                        ReclamationClient r = new ReclamationClient(idcatrec, tfObjet.getText(),taDescription.getText(),45,img);
                        if( ServiceRecClient.getInstance().addRec(r))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(c,tfObjet,taDescription,image,imgBtn,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
    
}
