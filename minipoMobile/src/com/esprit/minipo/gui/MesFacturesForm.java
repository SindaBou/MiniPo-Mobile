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
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.esprit.minipo.entites.Commande;
import com.esprit.minipo.entites.Facture;
import com.esprit.minipo.entites.ListeFact;
import com.esprit.minipo.services.ServiceCommande;
import com.esprit.minipo.services.ServiceFacture;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class MesFacturesForm extends BaseForm {
    
    private ArrayList<ListeFact> cmd=new ArrayList<ListeFact>();
    private static Form backForm;

    public MesFacturesForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }
    
    
    
    public MesFacturesForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        cmd=ServiceFacture.getInstance().getMesFact();
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Factures", "Title"),
                        new Label(String.valueOf(cmd.size()), "InboxNumber")
                )
        );
        
        installSidemenu(resourceObjectInstance);
        
       // getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm(resourceObjectInstance, this).show();}); 
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        //gui_Label_5.setShowEvenIfBlank(true);
    //    gui_Label_6.setShowEvenIfBlank(true);
        //gui_Label_7.setShowEvenIfBlank(true);
        //gui_Label_8.setShowEvenIfBlank(true);
        //gui_Label_9.setShowEvenIfBlank(true);
        
        /*gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setEditable(false);
        gui_Text_Area_1_1.setRows(2);
        gui_Text_Area_1_1.setColumns(100);
        gui_Text_Area_1_1.setEditable(false);
        gui_Text_Area_1_2.setRows(2);
        gui_Text_Area_1_2.setColumns(100);
        gui_Text_Area_1_2.setEditable(false);
        gui_Text_Area_1_3.setRows(2);
        gui_Text_Area_1_3.setColumns(100);
        gui_Text_Area_1_3.setEditable(false);
        gui_Text_Area_1_4.setRows(2);
        gui_Text_Area_1_4.setColumns(100);
        gui_Text_Area_1_4.setEditable(false);*/
        
    }
    public MesFacturesForm(com.codename1.ui.util.Resources resourceObjectInstance,Form f) {
        MesFacturesForm.backForm=f;
        initGuiBuilderComponents(resourceObjectInstance);
        cmd=ServiceFacture.getInstance().getMesFact();
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Factures", "Title"),
                        new Label(String.valueOf(cmd.size()), "InboxNumber")
                )
        );
        
        installSidemenu(resourceObjectInstance);
        
       // getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm(resourceObjectInstance, this).show();}); 
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});

    //    gui_Label_5.setShowEvenIfBlank(true);
    //    gui_Label_6.setShowEvenIfBlank(true);
    //    gui_Label_7.setShowEvenIfBlank(true);
    //    gui_Label_8.setShowEvenIfBlank(true);
    //    gui_Label_9.setShowEvenIfBlank(true);
        
       /* gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setEditable(false);
        gui_Text_Area_1_1.setRows(2);
        gui_Text_Area_1_1.setColumns(100);
        gui_Text_Area_1_1.setEditable(false);
        gui_Text_Area_1_2.setRows(2);
        gui_Text_Area_1_2.setColumns(100);
        gui_Text_Area_1_2.setEditable(false);
        gui_Text_Area_1_3.setRows(2);
        gui_Text_Area_1_3.setColumns(100);
        gui_Text_Area_1_3.setEditable(false);
        gui_Text_Area_1_4.setRows(2);
        gui_Text_Area_1_4.setColumns(100);
        gui_Text_Area_1_4.setEditable(false);*/
        
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 ;
    private com.codename1.ui.Container gui_Container_2 ;
    private com.codename1.ui.Label gui_Label_1 ;
    private com.codename1.ui.Container gui_Container_4 ;
    private com.codename1.ui.Label gui_Label_4 ;
    private com.codename1.ui.Container gui_Container_3 ;
    private com.codename1.ui.Container gui_Container_5 ;
    private com.codename1.ui.Label gui_Label_3;
    private com.codename1.ui.Label gui_Label_2 ;
    private com.codename1.ui.TextArea gui_Text_Area_1 ;
    private com.codename1.ui.Label gui_Label_6 ;
    //private com.codename1.ui.Container gui_Container_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.ui.Container gui_Container_2_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_1_1 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_4_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_4_1 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_3_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
//    private com.codename1.ui.Label gui_Label_3_1 = new com.codename1.ui.Label();
//    private com.codename1.ui.Label gui_Label_2_1 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_1;
//    private com.codename1.ui.Label gui_Label_7 ;
//    private com.codename1.ui.Container gui_Container_1_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.ui.Container gui_Container_2_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_1_2 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_4_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_4_2 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_3_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
//    private com.codename1.ui.Label gui_Label_3_2 = new com.codename1.ui.Label();
//    private com.codename1.ui.Label gui_Label_2_2 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_2 ;
//    private com.codename1.ui.Label gui_Label_8 ;
//    private com.codename1.ui.Container gui_Container_1_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.ui.Container gui_Container_2_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_1_3 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_4_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_4_3 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_3_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
//    private com.codename1.ui.Label gui_Label_3_3 = new com.codename1.ui.Label();
//    private com.codename1.ui.Label gui_Label_2_3 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_3 ;
//    private com.codename1.ui.Label gui_Label_9;
//    private com.codename1.ui.Container gui_Container_1_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.ui.Container gui_Container_2_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_1_4 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_4_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_4_4 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_3_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
//    private com.codename1.ui.Label gui_Label_3_4 = new com.codename1.ui.Label();
//    private com.codename1.ui.Label gui_Label_2_4 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_4;
//    private com.codename1.ui.Label gui_Label_5 ;
    
    private Container entetec ;
    
    private com.codename1.ui.Container gui_Container_6 ;
    private com.codename1.ui.Container gui_Container_7 ;
    private com.codename1.ui.Container gui_Container_global ;
    private com.codename1.ui.Label gui_Label_11;
    private com.codename1.ui.Button closeButton ;

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
      setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
      setTitle("InboxForm");
      setName("InboxForm");
      
      entetec=new Container(BoxLayout.x());
      entetec.setUIID("DesignEnTete");
      Label back=new Label();
      FontImage iconB = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, "Back", 4.9f);
      back.setIcon(iconB);
      Label title=new Label("Mes Factures");
      entetec.add(back).add(title);
      
       back.addPointerPressedListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
               // new MesRecClientForm().show();
               MesFacturesForm.backForm.showBack();
            }
        });
      
      addComponent(entetec);
            
     // ArrayList<ListeFact> cmd=new ArrayList<ListeFact>();
      cmd=ServiceFacture.getInstance().getMesFact();
      
      if(cmd.isEmpty()){
             
            
            Container container_c=new Container(BoxLayout.y());
            Container container_cc=new Container(new FlowLayout(CENTER));
            container_cc.setUIID("PanVide");
            container_cc.getAllStyles().setMargin(70, 0, 0, 0);
             
            //FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_ADD_SHOPPING_CART, "Panier est Vide", 30.0f);
            //Image mat = resourceObjectInstance.getImage("bill_black.png");
            Image mat = resourceObjectInstance.getImage("bill.png");
            mat.scale(500,500);
            Label vide=new Label();
            vide.setIcon(mat);
            vide.getAllStyles().setAlignment(CENTER);
            vide.getAllStyles().setMargin(170, 150, 170, 150);
            
            Label lab=new Label("Vous n'avez pas du facture");
            lab.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_SMALL));
            lab.getAllStyles().setAlignment(CENTER);
            lab.getAllStyles().setMargin(0, 70, 10, 10);
            
            Button btn=new Button("COMMENCEZ VOS ACHATS");
        
            btn.setPreferredSize(new Dimension(50,110));
            Style btnStyle = btn.getAllStyles();
            Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
            btnStyle.setBorder(RoundRectBorder.create().
            strokeColor(0).
            strokeOpacity(50).
            stroke(borderStroke));
          
            container_cc.add(vide);
            container_c./*add(entetec).*/add(container_cc).add(lab).add(btn);
            addComponent(container_c); 
            
            btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new AllProduitsForm(resourceObjectInstance).show();
                
            }
            });
            
        }
        else{
      
      for(int i=0;i<cmd.size();i++){
            
            //**********creation*********
            //gui_Container_global = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout(RIGHT));
            gui_Container_global = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
            gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
            gui_Label_1 = new com.codename1.ui.Label();
            gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
            gui_Label_4 = new com.codename1.ui.Label();
            gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
            gui_Label_3 = new com.codename1.ui.Label();
            gui_Label_2 = new com.codename1.ui.Label();
            gui_Text_Area_1 = new com.codename1.ui.TextArea();
            gui_Label_6 = new com.codename1.ui.Label();
            gui_Text_Area_1_1 = new com.codename1.ui.TextArea();
    //        gui_Label_7 = new com.codename1.ui.Label();
            gui_Text_Area_1_2 = new com.codename1.ui.TextArea();
    //        gui_Label_8 = new com.codename1.ui.Label();
            gui_Text_Area_1_3 = new com.codename1.ui.TextArea();
    //        gui_Label_9 = new com.codename1.ui.Label();
            gui_Text_Area_1_4 = new com.codename1.ui.TextArea();
    //        gui_Label_5 = new com.codename1.ui.Label();
            
            gui_Container_5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            gui_Label_11 = new com.codename1.ui.Label();
            gui_Container_6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout(RIGHT));
            gui_Container_7 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout(LEFT));
            //************remplisage************   
            
            //addComponent(gui_Container_1);
            addComponent(gui_Container_global);
            
           // gui_Container_global.addComponent(gui_Container_1);
            //gui_Container_global.add(gui_Container_1);

            gui_Container_1.setName("Container_1");
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2);
            gui_Container_2.setName("Container_2");
            gui_Container_2.addComponent(gui_Label_1);
            gui_Label_1.setText(cmd.get(i).getDateFact());
            gui_Label_1.setUIID("DateLabel");
            gui_Label_1.setName("Label_1");
            gui_Label_1.getAllStyles().setMargin(50,0,0,90);
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4);
            gui_Container_4.setName("Container_4");
            ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
            gui_Container_4.addComponent(gui_Label_4);
            
            gui_Container_2.setName("Container_2");
            gui_Container_4.setName("Container_4");
            
            gui_Label_2.setText(String.valueOf(cmd.get(i).getRefc()));
            gui_Label_2.setUIID("Label");
            gui_Label_2.setName("Label_2");
 
            gui_Label_4.setUIID("Padding2");
            gui_Label_4.setName("Label_4");
            gui_Label_4.getAllStyles().setMargin(50,0 ,70, 0);
            
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
            gui_Container_3.setName("Container_3");
            gui_Container_3.addComponent(gui_Label_3);
            gui_Container_3.addComponent(gui_Label_2);
            gui_Container_1.add(com.codename1.ui.layouts.BorderLayout.SOUTH,gui_Container_5);
            
            gui_Label_3.setText("FactX"+cmd.get(i).getIdFact());
            gui_Label_3.setName("Label_3");
            gui_Label_3.setUIID("desgLabel");
            
            gui_Label_3.getAllStyles().setMargin(50,0,0,0);
            
            gui_Container_7.addComponent(gui_Label_6);
            gui_Container_7.getStyle().setMargin(0,0,100,0);
            gui_Label_6.setText(cmd.get(i).getEtatFact());
            gui_Label_6.setUIID("Label");
            gui_Label_6.setName("Text_Area_1");
            gui_Label_6.getStyle().setMargin(0,50,90,0);
            
            
            gui_Container_6.addComponent(gui_Label_11);
            gui_Label_11.setText(cmd.get(i).getTotal()+"TND");
            gui_Label_11.setUIID("Label");
            gui_Label_11.setName("gui_Label_11");
            gui_Label_11.getStyle().setMargin(0, 50, 0, 90);
            gui_Container_6.setName("Container_5");
            
                  if(cmd.get(i).getEtatFact().equals("Non Payee")){
                
                Image img = resourceObjectInstance.getImage("label_round-selected.png");
                img.scale(50, 50);
                gui_Label_4.setIcon(img);
                
                
                gui_Label_6.getAllStyles().setFgColor(0xf4753f);
                gui_Label_11.getAllStyles().setFgColor(0xf4753f);
  
            }
            else if(cmd.get(i).getEtatFact().equals("Payee")){
                
                Image img = resourceObjectInstance.getImage("label_round.png");
                img.scale(50, 50);
                gui_Label_4.setIcon(img);
                
                gui_Label_6.getStyle().setFgColor(0x006400);
                gui_Label_11.getStyle().setFgColor(0x006400);
              
            }
                    
            gui_Container_5.addComponent(com.codename1.ui.layouts.BorderLayout.WEST , gui_Container_7);
            gui_Container_5.addComponent(com.codename1.ui.layouts.BorderLayout.EAST , gui_Container_6);
            
            
            ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
            gui_Container_3.setName("Container_3");
            int idcmd=cmd.get(i).getIdcmd();
            System.out.println(idcmd);

            gui_Container_global.addComponent(gui_Container_1);
           
            
            gui_Container_1.setUIID("LayaoutBoxY");
            //gui_Container_1.getAllStyles().setMargin(0,20,, RIGHT), TOP);
        }
    }
      
//        addComponent(gui_Container_1_1);
//        gui_Container_1_1.setName("Container_1_1");
//        gui_Container_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2_1);
//        gui_Container_2_1.setName("Container_2_1");
//        gui_Container_2_1.addComponent(gui_Label_1_1);
//        gui_Label_1_1.setText("8:23 PM");
//        gui_Label_1_1.setUIID("SmallFontLabel");
//        gui_Label_1_1.setName("Label_1_1");
//        gui_Container_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4_1);
//        gui_Container_4_1.setName("Container_4_1");
//        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_1.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
//        gui_Container_4_1.addComponent(gui_Label_4_1);
//        gui_Label_4_1.setUIID("Padding2");
//        gui_Label_4_1.setName("Label_4_1");
//        gui_Label_4_1.setIcon(resourceObjectInstance.getImage("label_round-selected.png"));
//        gui_Container_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3_1);
//        gui_Container_3_1.setName("Container_3_1");
//        gui_Container_3_1.addComponent(gui_Label_3_1);
//        gui_Container_3_1.addComponent(gui_Label_2_1);
//        gui_Container_3_1.addComponent(gui_Text_Area_1_1);
//        gui_Label_3_1.setText("Massdrop");
//        gui_Label_3_1.setName("Label_3_1");
//        gui_Label_2_1.setText("We Are Just Getting Started");
//        gui_Label_2_1.setUIID("RedLabel");
//        gui_Label_2_1.setName("Label_2_1");
//        gui_Text_Area_1_1.setText("Tenkara Rod Co Teton Package Made possible by the Ultralight community...");
//        gui_Text_Area_1_1.setUIID("SmallFontLabel");
//        gui_Text_Area_1_1.setName("Text_Area_1_1");
//        gui_Container_2_1.setName("Container_2_1");
//        gui_Container_4_1.setName("Container_4_1");
//        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_1.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
//        gui_Container_3_1.setName("Container_3_1");
//        addComponent(gui_Label_7);
//        addComponent(gui_Container_1_2);
//        gui_Container_1_2.setName("Container_1_2");
//        gui_Container_1_2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2_2);
//        gui_Container_2_2.setName("Container_2_2");
//        gui_Container_2_2.addComponent(gui_Label_1_2);
//        gui_Label_1_2.setText("Yesterday");
//        gui_Label_1_2.setUIID("SmallFontLabel");
//        gui_Label_1_2.setName("Label_1_2");
//        gui_Container_1_2.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4_2);
//        gui_Container_4_2.setName("Container_4_2");
//        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_2.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
//        gui_Container_4_2.addComponent(gui_Label_4_2);
//        gui_Label_4_2.setUIID("Padding2");
//        gui_Label_4_2.setName("Label_4_2");
//        gui_Label_4_2.setIcon(resourceObjectInstance.getImage("label_round.png"));
//        gui_Container_1_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3_2);
//        gui_Container_3_2.setName("Container_3_2");
//        gui_Container_3_2.addComponent(gui_Label_3_2);
//        gui_Container_3_2.addComponent(gui_Label_2_2);
//        gui_Container_3_2.addComponent(gui_Text_Area_1_2);
//        gui_Label_3_2.setText("Product Hunt");
//        gui_Label_3_2.setName("Label_3_2");
//        gui_Label_2_2.setText("Our favorite GIF apps");
//        gui_Label_2_2.setUIID("RedLabel");
//        gui_Label_2_2.setName("Label_2_2");
//        gui_Text_Area_1_2.setText("We know that you spend a lot of time admiring the hard work of GIF-makers the world over. ");
//        gui_Text_Area_1_2.setUIID("SmallFontLabel");
//        gui_Text_Area_1_2.setName("Text_Area_1_2");
//        gui_Container_2_2.setName("Container_2_2");
//        gui_Container_4_2.setName("Container_4_2");
//        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_2.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
//        gui_Container_3_2.setName("Container_3_2");
//        addComponent(gui_Label_8);
//        addComponent(gui_Container_1_3);
//        gui_Container_1_3.setName("Container_1_3");
//        gui_Container_1_3.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2_3);
//        gui_Container_2_3.setName("Container_2_3");
//        gui_Container_2_3.addComponent(gui_Label_1_3);
//        gui_Label_1_3.setText("Mar 12");
//        gui_Label_1_3.setUIID("SmallFontLabel");
//        gui_Label_1_3.setName("Label_1_3");
//        gui_Container_1_3.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4_3);
//        gui_Container_4_3.setName("Container_4_3");
//        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_3.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
//        gui_Container_4_3.addComponent(gui_Label_4_3);
//        gui_Label_4_3.setUIID("Padding2");
//        gui_Label_4_3.setName("Label_4_3");
//        gui_Label_4_3.setIcon(resourceObjectInstance.getImage("label_round.png"));
//        gui_Container_1_3.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3_3);
//        gui_Container_3_3.setName("Container_3_3");
//        gui_Container_3_3.addComponent(gui_Label_3_3);
//        gui_Container_3_3.addComponent(gui_Label_2_3);
//        gui_Container_3_3.addComponent(gui_Text_Area_1_3);
//        gui_Label_3_3.setText("MightyDeals");
//        gui_Label_3_3.setName("Label_3_3");
//        gui_Label_2_3.setText("Vintage Design: 600+ Retro Vector Illustrations and Objects");
//        gui_Label_2_3.setUIID("RedLabel");
//        gui_Label_2_3.setName("Label_2_3");
//        gui_Text_Area_1_3.setText("With just a little imagery, an ordinary project can transform into something extraordinary! ");
//        gui_Text_Area_1_3.setUIID("SmallFontLabel");
//        gui_Text_Area_1_3.setName("Text_Area_1_3");
//        gui_Container_2_3.setName("Container_2_3");
//        gui_Container_4_3.setName("Container_4_3");
//        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_3.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
//        gui_Container_3_3.setName("Container_3_3");
//        addComponent(gui_Label_9);
//        addComponent(gui_Container_1_4);
//        gui_Container_1_4.setName("Container_1_4");
//        gui_Container_1_4.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2_4);
//        gui_Container_2_4.setName("Container_2_4");
//        gui_Container_2_4.addComponent(gui_Label_1_4);
//        gui_Label_1_4.setText("Mar 08");
//        gui_Label_1_4.setUIID("SmallFontLabel");
//        gui_Label_1_4.setName("Label_1_4");
//        gui_Container_1_4.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4_4);
//        gui_Container_4_4.setName("Container_4_4");
//        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
//        gui_Container_4_4.addComponent(gui_Label_4_4);
//        gui_Label_4_4.setUIID("Padding2");
//        gui_Label_4_4.setName("Label_4_4");
//        gui_Label_4_4.setIcon(resourceObjectInstance.getImage("label_round.png"));
//        gui_Container_1_4.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3_4);
//        gui_Container_3_4.setName("Container_3_4");
//        gui_Container_3_4.addComponent(gui_Label_3_4);
//        gui_Container_3_4.addComponent(gui_Label_2_4);
//        gui_Container_3_4.addComponent(gui_Text_Area_1_4);
//        gui_Label_3_4.setText("Twitter");
//        gui_Label_3_4.setName("Label_3_4");
//        gui_Label_2_4.setText("Popular tweets this week");
//        gui_Label_2_4.setUIID("RedLabel");
//        gui_Label_2_4.setName("Label_2_4");
//        gui_Text_Area_1_4.setText("Hi Adrian, there is a new announcement for you from Oxford Learning  Lab. Hello we completly...");
//        gui_Text_Area_1_4.setUIID("SmallFontLabel");
//        gui_Text_Area_1_4.setName("Text_Area_1_4");
//        gui_Container_2_4.setName("Container_2_4");
//        gui_Container_4_4.setName("Container_4_4");
//        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
//        gui_Container_3_4.setName("Container_3_4");
//        addComponent(gui_Label_5);
//        gui_Container_1.setName("Container_1");
//        gui_Label_6.setText("");
//        gui_Label_6.setUIID("Separator");
//        gui_Label_6.setName("Label_6");
//        gui_Container_1_1.setName("Container_1_1");
//        gui_Label_7.setText("");
//        gui_Label_7.setUIID("Separator");
//        gui_Label_7.setName("Label_7");
//        gui_Container_1_2.setName("Container_1_2");
//        gui_Label_8.setText("");
//        gui_Label_8.setUIID("Separator");
//        gui_Label_8.setName("Label_8");
//        gui_Container_1_3.setName("Container_1_3");
//        gui_Label_9.setText("");
//        gui_Label_9.setUIID("Separator");
//        gui_Label_9.setName("Label_9");
//        gui_Container_1_4.setName("Container_1_4");
//        gui_Label_5.setText("");
//        gui_Label_5.setUIID("Separator");
//        gui_Label_5.setName("Label_5");
    }// </editor-fold>
  
//-- DON'T EDIT ABOVE THIS LINE!!!
}
