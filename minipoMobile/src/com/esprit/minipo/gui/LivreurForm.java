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
import com.codename1.ui.Command;
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
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.esprit.minipo.MyApplication;
import com.esprit.minipo.entites.Livraison;
import com.esprit.minipo.services.ServiceLivraison;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class LivreurForm extends BaseLivreurForm11 {

    public LivreurForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }

    public LivreurForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
        
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Livraison");
        setName("LivraisonForm");
        Container list = new Container(BoxLayout.y());
        list.setScrollableY(true);
        livraisons = ServiceLivraison.getInstance().getListLivraison();
        if(livraisons.size()==0){
         
            Dialog.show("Aucune Livraison","Vous n'avez pas de Livraison ",new Command("OK"));
            Label l= new Label("Vous n'avez pas de reclamation");
            add(l);
            
        }
        else{
        for (int i = 0; i < livraisons.size(); i++) {
            MultiButton mb = new MultiButton();
            
            //mb.setPreferredSize(new Dimension(300, 300));
            int index = i;
            mb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    System.out.println(livraisons.get(index).getIdliv());
                    /*LivraisonUpdateForm formToShow = new LivraisonUpdateForm(livraisons.get(index).getIdliv());
                    formToShow.setId(livraisons.get(index).getIdliv());
                    formToShow.show();*/
                    new TestLivraisonForm(resourceObjectInstance, livraisons.get(index).getIdliv()).show();
                }
            });
            mb.setUIID("Label");
            mb.setName("Multi_Button_1");
            if (livraisons.get(i).getEtatl().equals("livree")) {
                mb.setIcon(resourceObjectInstance.getImage("livimg.png"));
            } else if (livraisons.get(i).getEtatl().equals("refusee")) {
                mb.setIcon(resourceObjectInstance.getImage("livImgRefuse.png"));} 
            else {
                mb.setIcon(resourceObjectInstance.getImage("livImgEncours.png"));
            }
            mb.setPropertyValue("line1", livraisons.get(i).getMatriculeL());
            mb.setPropertyValue("line2", livraisons.get(i).getDateliv());
            mb.setPropertyValue("uiid1", "Label");
            mb.setPropertyValue("uiid2", "RedLabel");
            //gui_LA.setUIID("Label");
            //gui_LA.setName("LA");
            //gui_LA.setPropertyValue("line1", "3 minutes ago");
            //gui_LA.setPropertyValue("line2", "in Los Angeles");
            //gui_LA.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
            //gui_LA.setPropertyValue("uiid2", "RedLabelRight");
            list.add(mb);
            
            //************design container **************
       
                  Style boxStyle = mb.getAllStyles();
                  boxStyle.setBgTransparency(255);
//boxStyle.setBgColor(0xeeeeee);
                boxStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
                boxStyle.setPaddingUnit(Style.UNIT_TYPE_DIPS);
                boxStyle.setMargin(2, 2, 2, 2);
                boxStyle.setPadding(2, 2, 2, 2);
//*******************************************************************
            

        }
        
        }

        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");

        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, list);
        //gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_LA);

        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {
                                             Hashtable themeData = MyApplication.theme.getTheme("Theme");
                                             UIManager.getInstance().setThemeProps(themeData);    
                                              new SignInForm().show();});
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private ArrayList<Livraison> livraisons;
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

    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
