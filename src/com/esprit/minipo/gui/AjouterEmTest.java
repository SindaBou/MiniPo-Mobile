/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.esprit.minipo.entites.Conge;
import com.esprit.minipo.entites.Employe;
import com.esprit.minipo.services.ServiceConge;
import com.esprit.minipo.services.ServiceEmploye;

/**
 *
 * @author hafed
 */
public class AjouterEmTest extends Form {
     public AjouterEmTest(Form previous) {
    Form val = new Form("Demande Conge");
    TableLayout tl;
    int spanButton = 2;
    if(Display.getInstance().isTablet()) {
        tl = new TableLayout(7, 2);
    } else {
        tl = new TableLayout(14, 1);
        spanButton = 1;
    }
    tl.setGrowHorizontally(true);
    val.setLayout(tl);

    val.addComponent(new Label("Type"));
    TextField tftype = new TextField();
    val.addComponent(tftype);

    val.addComponent(new Label("Nombre de jours"));

    Container creditCardContainer = new Container(new GridLayout(1, 4));
    TextField tfnbr = new TextField();
    tfnbr.setConstraint(TextArea.NUMERIC);
    creditCardContainer.addComponent(tfnbr);
    val.addComponent(creditCardContainer);
    
    
    val.addComponent(new Label("Date de debut"));
    Picker datedebut = new Picker();
    datedebut.setType(Display.PICKER_TYPE_DATE);
    val.addComponent(datedebut);
    
    val.addComponent(new Label("Date de fin"));
    Picker datedfin = new Picker();
    val.addComponent(datedfin);
    
    val.addComponent(new Label("Adresse"));
    TextField tfinfo = new TextField();
    val.addComponent(tfinfo);

    Button submit = new Button("Enregistrer");
    TableLayout.Constraint cn = tl.createConstraint();
    cn.setHorizontalSpan(spanButton);
    cn.setHorizontalAlign(Component.RIGHT);
    val.addComponent(cn, submit);

    Validator v = new Validator();
            v.addConstraint(tftype, new LengthConstraint(2)).
            addConstraint(tfnbr, new LengthConstraint(2)).
            addConstraint(tfinfo, new LengthConstraint(2));



    v.addSubmitButtons(submit);
           
    submit.addActionListener(new ActionListener() {
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
    
    
        
        
        addAll(val);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new AgentRHForm().showBack());
                
    }
     private void automoveToNext(final TextField current, final TextField next) {
    current.addDataChangeListener(new DataChangedListener() {
        public void dataChanged(int type, int index) {
            if(current.getText().length() == 5) {
                Display.getInstance().stopEditing(current);
                String val = current.getText();
                current.setText(val.substring(0, 4));
                next.setText(val.substring(4));
                Display.getInstance().editString(next, 5, current.getConstraint(), next.getText());
            }
        }
    });        
}
}
