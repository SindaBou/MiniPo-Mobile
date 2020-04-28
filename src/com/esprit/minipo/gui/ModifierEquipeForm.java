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
import com.esprit.minipo.entites.Equipe;
import com.esprit.minipo.services.ServiceEmploye;
import com.esprit.minipo.services.ServiceEquipe;

/**
 *
 * @author hafed
 */
public class ModifierEquipeForm extends Form{
    
    public ModifierEquipeForm(Form previous,int id, String nom, int nbr) {
        
        setTitle("Ajouter Equipe");
        setLayout(BoxLayout.y());
        
        TextField tfnom = new TextField(nom,"Nom equipe");
        TextField tfnombre = new TextField(""+nbr,"Nombre");
        
        Button btnValider = new Button("Add task");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfnom.getText().length()==0)||(tfnombre.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        
                        if( ServiceEquipe.getInstance().updateEquipe(id , tfnom.getText(),Integer.parseInt(tfnombre.getText())))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfnom,tfnombre,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new EquipeForm().showBack());
}
}