/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.minipo.services.ServiceCommande;
import com.esprit.minipo.services.ServiceRecClient;
import com.esprit.minipo.services.ServiceRecEmploye;

/**
 *
 * @author bhk
 */
public class ListRecEmpForm extends Form{

    public ListRecEmpForm(Form previous) {
        setTitle("List reclamation");
        
        SpanLabel sp = new SpanLabel();
        //sp.setText(ServiceTask.getInstance().getAllTasks().toString());
        sp.setText(ServiceRecEmploye.getInstance().getAllCmd().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
    
}
