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


/**
 *
 * @author hafed
 */
public class AjouterEmpForm extends Form {
    
    public AjouterEmpForm(Form previous) {
        
        setTitle("Ajouter un nouveau employe");
        setLayout(BoxLayout.y());
        
        TextField tfnom = new TextField("","Nom");
        TextField tfprenom = new TextField("","Prenom");
        TextField tfadresse = new TextField("","Adresse");
        TextField tftel = new TextField("","phone");
        TextField tfemail = new TextField("","email");
        TextField tfsalaire= new TextField("", "salaire");
        Button btnValider = new Button("Add task");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfnom.getText().length()==0)||(tfprenom.getText().length()==0)||(tfadresse.getText().length()==0)||(tftel.getText().length()==0)||(tfemail.getText().length()==0)||(tfsalaire.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Employe t = new Employe(tfnom.getText(),tfprenom.getText(),tfadresse.getText(),tftel.getText(),tfemail.getText(),tfsalaire.getText());
                        if( ServiceEmploye.getInstance().addEmploye(t))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfnom,tfprenom,tfadresse,tftel,tfemail,tfsalaire,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new AgentRHForm().showBack());
                
    }
    
}
