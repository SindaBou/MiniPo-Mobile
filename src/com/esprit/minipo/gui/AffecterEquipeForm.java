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
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.minipo.entites.Affectation;
import com.esprit.minipo.entites.Employe;
import com.esprit.minipo.entites.Equipe;
import com.esprit.minipo.services.ServiceAffectation;
import com.esprit.minipo.services.ServiceEmploye;
import com.esprit.minipo.services.ServiceEquipe;
import java.util.ArrayList;

/**
 *
 * @author hafed
 */
public class AffecterEquipeForm extends Form{
    
    public AffecterEquipeForm(Form previous) {
        
        setTitle("Affecter Employe");
        setLayout(BoxLayout.y());
        
        
        ComboBox cnom = new ComboBox();
        ComboBox cequipe = new ComboBox();
        
        ArrayList<Equipe> emp=new ArrayList<Equipe>();
        emp=ServiceEquipe.getInstance().getAllEq();
        for(int i=0;i<emp.size();i++){
            cequipe.addItem(emp.get(i).getNomeq());
        }
        ArrayList<Employe> val=new ArrayList<Employe>();
        val=ServiceEmploye.getInstance().getAllEmp();
        for(int i=0;i<val.size();i++){
            cnom.addItem(val.get(i).getNom());
        }
        
        Button btnValider = new Button("Add task");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                    try {
                        Affectation t = new Affectation(cnom.getSelectedItem().toString(),cequipe.getSelectedItem().toString());
                        if( ServiceAffectation.getInstance().addAff(t))
                            Dialog.show("Success",cnom.getSelectedItem().toString() + " a été ajouté avec succès",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
            }
        });
        
        addAll(cnom,cequipe,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new AffectationForm().showBack());
                
    }
}
