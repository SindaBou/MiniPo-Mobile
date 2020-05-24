/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.minipo.entites.Employe;
import com.esprit.minipo.services.ServiceEmploye;
import java.util.ArrayList;

/**
 *
 * @author hafed
 */
public class ModifierEmployeForm extends Form{
    
    public ModifierEmployeForm(Form previous,int id, String nom, String prenom, String Adresse, String phone, String email , String salaire) {
        
        setTitle("Modification");
        setLayout(BoxLayout.y());
//        ArrayList<Employe> emp=new ArrayList<Employe>();
//        emp=ServiceEmploye.getInstance().getEmpID(id);
//        for(int i=0;i<emp.size();i++){
        TextField tfnom = new TextField(nom,"Nom");
        TextField tfprenom = new TextField(prenom,"Prenom");
        TextField tfadresse = new TextField(Adresse,"Adresse");
        TextField tftel = new TextField(phone,"Phone");
        TextField tfemail = new TextField(email,"Email");
        TextField tfsalaire= new TextField(salaire,"Salaire");
        
        Button btnValider = new Button("Enregistrer");
        Button btnSupp = new Button("Supprimer");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfnom.getText().length()==0)||(tfprenom.getText().length()==0)||(tfadresse.getText().length()==0)||(tftel.getText().length()==0)||(tfemail.getText().length()==0)||(tfsalaire.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                       
                        if( ServiceEmploye.getInstance().updateEmploye(id ,tfnom.getText(),tfprenom.getText(), tfadresse.getText(),tftel.getText(),tfemail.getText(),tfsalaire.getText() ))
                            Dialog.show("Success","La modification a été effectuée avec succès",new Command("OK"));
                            
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        btnSupp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                try {
                        
                        if( ServiceEmploye.getInstance().deleteEmploye(id))
                            
                            Dialog.show("Success","l'employe"+ nom +" est supprimé",new Command("OK"));
                            
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
            }
        });
        btnSupp.setUIID("ButtonSupp");
        
        addAll(tfnom,tfprenom,tfadresse,tftel,tfemail,tfsalaire,btnValider,btnSupp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new AgentRHForm().showBack());
//        }     
    }
}
