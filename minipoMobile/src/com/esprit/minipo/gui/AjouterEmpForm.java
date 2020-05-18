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
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.NumericConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.esprit.minipo.entites.Employe;
import com.esprit.minipo.services.ServiceEmploye;


/**
 *
 * @author hafed
 */
public class AjouterEmpForm extends BaseAgentRHForm11 {

    Form current;
            
    public AjouterEmpForm(Form previous) {
    
        current=this;
        setTitle("Ajouter Employe");
    //Form val = new Form("Ajouter Employe");
    TableLayout tl;
    int spanButton = 2;
    if(Display.getInstance().isTablet()) {
        tl = new TableLayout(7, 2);
    } else {
        tl = new TableLayout(14, 1);
        spanButton = 1;
    }
    tl.setGrowHorizontally(true);
    setLayout(tl);

    addComponent(new Label("Nom"));
    TextField firstName = new TextField();
    addComponent(firstName);

    addComponent(new Label("Prenom"));
    TextField surname = new TextField();
    addComponent(surname);
    
    addComponent(new Label("Adresse"));
    TextField adresse = new TextField();
    addComponent(adresse);

    addComponent(new Label("E-Mail"));
    TextField email = new TextField();
    email.setConstraint(TextArea.EMAILADDR);
    addComponent(email);

    addComponent(new Label("Telephone"));
    TextField phone = new TextField();
    phone.setConstraint(TextArea.PHONENUMBER);
    addComponent(phone);
    
//    val.addComponent(new Label("Salaire"));
//    TextField salaire = new TextField();
//    salaire.setConstraint(TextArea.NUMERIC);
//    val.addComponent(salaire);

    addComponent(new Label("Salaire"));

    Container creditCardContainer = new Container(new GridLayout(1, 4));
    TextField salaire = new TextField();
    salaire.setConstraint(TextArea.NUMERIC);
    creditCardContainer.addComponent(salaire);
    addComponent(creditCardContainer);

    Button submit = new Button("Enregistrer");
    TableLayout.Constraint cn = tl.createConstraint();
    cn.setHorizontalSpan(spanButton);
    cn.setHorizontalAlign(Component.RIGHT);
    addComponent(cn, submit);

    String phoneConstraint = "^[0-9]{8}";
    String isString = "^[a-zA-Z]+$";
    String adress = "^[A-Z a-z 0-9]+$";
    String salair = "^[0-9]";
    Validator v = new Validator();
            v.addConstraint(firstName,new RegexConstraint(isString, "enter a valid nom")).
            addConstraint(surname, new RegexConstraint(isString, "enter a valid prenom")).
            addConstraint(adresse,new RegexConstraint(adress, "enter a valid adresse")).
            addConstraint(email, RegexConstraint.validEmail()).
            addConstraint(phone, new RegexConstraint(phoneConstraint, "Please enter a valid phone number")).
            addConstraint(salaire, new RegexConstraint(salair, "enter a valid salaire"));



    v.addSubmitButtons(submit);
           
    
    submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((firstName.getText().length()==0)||(surname.getText().length()==0)||(adresse.getText().length()==0)||!(phone.getText().length()==8)||(email.getText().length()==0)||(salaire.getText().length()==0)
                        
                        )
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                
                else
                {
                    try {
                        Employe t = new Employe(firstName.getText(),surname.getText(),adresse.getText(),phone.getText(),email.getText(),salaire.getText());
                        if( ServiceEmploye.getInstance().addEmploye(t))
                            Dialog.show("Success",firstName.getText()+" a été ajouté avec succès",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
    
        
        
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new AgentRHForm().showBack());
                
    }
    
}
