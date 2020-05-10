/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.l10n.SimpleDateFormat;
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
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.esprit.minipo.entites.Conge;
import com.esprit.minipo.services.ServiceConge;
import java.util.Date;

/**
 *
 * @author hafed
 */
public class AjouterDemandeConge extends Form{
    public AjouterDemandeConge(Form previous) {
        
//        setTitle("Demande Conge");
//        setLayout(BoxLayout.y());
//        
//        TextField tftype = new TextField("","Type");
//        TextField tfnbr = new TextField("","nombre de jour");
//        TextField tfinfo = new TextField("","Description");
//        Picker datedebut = new Picker();
//        datedebut.setType(Display.PICKER_TYPE_DATE);
//        Picker datedfin = new Picker();
//        Button btnValider = new Button("Enregistrer");
//        
//        btnValider.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                if ((tftype.getText().length()==0)||(tfnbr.getText().length()==0)||(tfinfo.getText().length()==0)||(datedebut.getText().length()==0)||(datedfin.getText().length()==0))
//                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
//                else
//                {
//                    try {
//                        Conge t = new Conge(tftype.getText(),datedebut.getText(),datedfin.getText(),Integer.parseInt(tfnbr.getText()),tfinfo.getText());
//                        
//                        if( ServiceConge.getInstance().addConge(t))
//                            Dialog.show("Success"," a été ajouté avec succès",new Command("OK"));
//                        else
//                            Dialog.show("ERROR", "Server error", new Command("OK"));
//                    } catch (NumberFormatException e) {
//                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
//                    }
//                    
//                }
//                
//                
//            }
//        });
//        
//        addAll(tftype,datedebut,datedfin,tfnbr,tfinfo,btnValider);
//        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new EmployeForm().showBack());
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

    
    
    
    val.addComponent(new Label("Date de debut"));
    Picker datedebut = new Picker();
    String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    
   
        System.out.println(today);
     //   System.out.println(datepicked);
    
    val.addComponent(datedebut);
    
    
    
    
    val.addComponent(new Label("Date de fin"));
    Picker datedfin = new Picker();
    val.addComponent(datedfin);
    
    
    int nb = daysBetween(datedebut.getDate(),datedfin.getDate());
        System.out.println(nb);
    
    val.addComponent(new Label("Description"));
    TextField tfinfo = new TextField();
    val.addComponent(tfinfo);
    
    datedfin.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent evt) {
         int diffnb = daysBetween(datedebut.getDate(),datedfin.getDate());
         val.addComponent(new Label(diffnb+" jours"));
         Dialog.show("Alert", "vous avez choisi "+diffnb+" jours", new Command("OK"));
     }
    });
    
//    val.addComponent(new Label("Nombre de jours"));

//    Container creditCardContainer = new Container(new GridLayout(1, 4));
//    TextField tfnbr = new TextField();
//    tfnbr.setConstraint(TextArea.NUMERIC);
//    creditCardContainer.addComponent(tfnbr);
//    val.addComponent(creditCardContainer);

    Button submit = new Button("Enregistrer");
    TableLayout.Constraint cn = tl.createConstraint();
    cn.setHorizontalSpan(spanButton);
    cn.setHorizontalAlign(Component.RIGHT);
    val.addComponent(cn, submit);

    String isString = "^[a-zA-Z]+$";
    String Number = "^[0-9]";
    String descr = "^[A-Z a-z 0-9]+$";
    Validator v = new Validator();
            v.addConstraint(tftype, new RegexConstraint(isString, "enter a valid Type")).
//            addConstraint(tfnbr,new RegexConstraint(Number, "enter a valid number")).
            addConstraint(tfinfo, new RegexConstraint(descr, "enter a valid description"));


    
    v.addSubmitButtons(submit);
           
    submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int diffnb = daysBetween(datedebut.getDate(),datedfin.getDate());
                 String datepicked = new SimpleDateFormat("yyyy-MM-dd").format(datedebut.getDate());
                //get the other date into a string
                 boolean isInThePast = (today.compareTo(datepicked) > 0);
                 System.out.println(datepicked);
                 System.out.println(isInThePast);
                if(isInThePast==true){
                    Dialog.show("Alert", "choisir date superieur a date d'aujourd'hui", new Command("OK"));
                    }else{
                
                if ((tftype.getText().length()==0)||(tfinfo.getText().length()==0)||(datedebut.getText().length()==0)||(datedfin.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Conge t = new Conge(tftype.getText(),datedebut.getText(),datedfin.getText(),diffnb,tfinfo.getText());
                        
                        System.out.println(diffnb);
                        if( ServiceConge.getInstance().addConge(t))
                            Dialog.show("Success","La demande a été ajouté avec succès",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                }
            }
        });
    
    
        
        
        addAll(val);
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new EmployeForm().showBack());
                
    }
    public int daysBetween(Date d1, Date d2){
             return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
     }
}
