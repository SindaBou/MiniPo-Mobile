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
    public AjoutRecEmpForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
         getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        setTitle("Envoyer une Reclamation");
        setLayout(BoxLayout.y());
        TextField tfObjet = new TextField("","Objet");
        TextArea taDescription= new TextField("", "Description");
        Button btnValider = new Button("Envoyer");
         ComboBox c= new ComboBox();
        c.addItem(pc);
        //c.addItem(pcmd);
        c.addItem(autre);
        
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
                        
                        ReclamationsEmploye r = new ReclamationsEmploye(id,idcatrec, tfObjet.getText(),taDescription.getText());
                        if( ServiceRecEmploye.getInstance().addRec(r)){
                            Dialog.show("Success","Reclamation Envoyée",new Command("OK"));
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
        
        addAll(c,tfObjet,taDescription,btnValider);
        //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
    
}
