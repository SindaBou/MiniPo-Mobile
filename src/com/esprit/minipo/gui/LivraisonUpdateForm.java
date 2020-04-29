/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.esprit.minipo.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.esprit.minipo.entites.Livraison;
import com.esprit.minipo.services.ServiceLivraison;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class LivraisonUpdateForm extends BaseLivreurForm11 {

    public LivraisonUpdateForm(int id) {
        this(com.codename1.ui.util.Resources.getGlobalResources(), id);
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }

    public LivraisonUpdateForm(com.codename1.ui.util.Resources resourceObjectInstance, int id) {
        initGuiBuilderComponents(resourceObjectInstance);
        gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
        livraison = ServiceLivraison.getInstance().getLivraison(id);
        System.out.println(livraison);
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Livraison");
        setName("LivraisonForm");
        Container list = new Container(BoxLayout.y());
        list.setScrollableY(true);
        Label matricule = new Label("Matricule:");
        Label matriculeText = new Label(livraison.getMatriculeL());
        Container matriculeLayout = GridLayout.encloseIn(matricule, matriculeText);
        Label destination = new Label("Destination:  " + "  " + livraison.getDestination());
        Label date = new Label("Date:  " + "  " + livraison.getDateliv());
        Label etatt = new Label("Etat :");
        ComboBox etat = new ComboBox("livree", "refusee", "en cours");
        etat.setSelectedItem(livraison.getEtatl());
        etat.addSelectionListener((oldSelected, newSelected) -> {
            System.out.println(newSelected);
            if (newSelected == 0) {
                ServiceLivraison.getInstance().updateEtat(id, "livree");
            } else if (newSelected == 1) {
                ServiceLivraison.getInstance().updateEtat(id, "refusee");
            }
        });
        Container etatLayout = GridLayout.encloseIn(etatt, etat);
        list.add(matriculeLayout).add(destination).add(date).add(etatLayout);
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, list);
        //gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_LA);

        installSidemenu(resourceObjectInstance);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {
        });
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private int id;
    private Livraison livraison;
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    private com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
    private com.codename1.ui.Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_null_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.components.MultiButton gui_null_1_1_1 = new com.codename1.components.MultiButton();
    private com.codename1.components.MultiButton gui_newYork = new com.codename1.components.MultiButton();
    private com.codename1.ui.Container gui_imageContainer2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        System.out.println("test update:" + id);
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
