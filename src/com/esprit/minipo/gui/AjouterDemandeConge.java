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
import com.codename1.ui.spinner.Picker;
import com.esprit.minipo.entites.Conge;
import com.esprit.minipo.services.ServiceConge;

/**
 *
 * @author hafed
 */
public class AjouterDemandeConge extends Form{
    public AjouterDemandeConge(Form previous) {
        
        setTitle("Demande Conge");
        setLayout(BoxLayout.y());
        
        TextField tftype = new TextField("","Type");
        TextField tfnbr = new TextField("","nombre de jour");
        TextField tfinfo = new TextField("","Description");
        Picker datedebut = new Picker();
        Picker datedfin = new Picker();
        Button btnValider = new Button("Enregistrer");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tftype.getText().length()==0)||(tfnbr.getText().length()==0)||(tfinfo.getText().length()==0)||(datedebut.getText().length()==0)||(datedfin.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Conge t = new Conge(tftype.getText(),datedebut.getText(),datedfin.getText(),Integer.parseInt(tfnbr.getText()),tfinfo.getText());
                        
                        if( ServiceConge.getInstance().addConge(t))
                            Dialog.show("Success"," a été ajouté avec succès",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tftype,datedebut,datedfin,tfnbr,tfinfo,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new EmployeForm().showBack());
                
    }
}
