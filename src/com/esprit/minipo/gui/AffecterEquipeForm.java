/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
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
        
        Container container=new Container(BoxLayout.y());
        
        ComboBox cnom = new ComboBox();
        //**************design Cbx Nom************
        Style cStyle = cnom.getAllStyles();
        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        cStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStroke));
        cStyle.setBgColor(0xccff);
        cStyle.setBgTransparency(255);
        cStyle.setBackgroundGradientRelativeX(0xf4753f);
        cStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
        cStyle.setMargin(Component.BOTTOM, 3);
        //***************************************
       
        ComboBox cequipe = new ComboBox();
        
         //**************design Cbx Equipe************
        Style eqStyle = cequipe.getAllStyles();
        Stroke borderStrokeeq = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        eqStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStrokeeq));
        eqStyle.setBgColor(0xccff);
        eqStyle.setBgTransparency(255);
        eqStyle.setBackgroundGradientRelativeX(0xf4753f);
        eqStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
        eqStyle.setMargin(Component.BOTTOM, 3);
        //***************************************
        
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
        
        Button btnValider = new Button("Enregistrer");
        
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
        
        container.addAll(cnom,cequipe,btnValider);
        
         //*******design container Layer*******
        Style boxStyle = container.getAllStyles();
        boxStyle.setBgTransparency(255);
        boxStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
        boxStyle.setPaddingUnit(Style.UNIT_TYPE_DIPS);
        boxStyle.setMargin(4, 3, 3, 3);
        boxStyle.setPadding(2, 2, 2, 2);
        //***********************************
        
        addComponent(container);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new AffectationForm().showBack());
                
    }
}
