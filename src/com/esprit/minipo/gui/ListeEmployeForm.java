/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.esprit.minipo.services.ServiceEmploye;

/**
 *
 * @author hafed
 */
public class ListeEmployeForm extends Form{
    
     public ListeEmployeForm(Form previous) {
        setTitle("List Employe");
        
        SpanLabel sp = new SpanLabel();
        //sp.setText(ServiceTask.getInstance().getAllTasks().toString());
        sp.setText(ServiceEmploye.getInstance().getAllEmp().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
}
