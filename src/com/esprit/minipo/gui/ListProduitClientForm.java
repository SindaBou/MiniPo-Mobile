/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.minipo.MyApplication;
import static com.esprit.minipo.MyApplication.theme;

import com.esprit.minipo.entites.ProduitClient;

import com.esprit.minipo.services.ServiceProduitClient;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class ListProduitClientForm extends BaseForm {
   
    
   
    private ArrayList<ProduitClient> prod=new ArrayList<ProduitClient>();
        
    private EncodedImage placeHolder;
    
    private static Form backForm;
    
    Form current;
    
    public ListProduitClientForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
        
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }
    
    public ListProduitClientForm(com.codename1.ui.util.Resources resourceObjectInstance, Form f) {
        
        ListProduitClientForm.backForm=f;
        current=this;
        initGuiBuilderComponents(resourceObjectInstance);
        prod=ServiceProduitClient.getInstance().getAllProducts();
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Produits", "Title"),
                        new Label(String.valueOf(prod.size()), "InboxNumber")
                )
        );
        
       
        
       // getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
        gui_Label_5.setShowEvenIfBlank(true);
        gui_Label_6.setShowEvenIfBlank(true);
        gui_Label_7.setShowEvenIfBlank(true);
        gui_Label_8.setShowEvenIfBlank(true);
        gui_Label_9.setShowEvenIfBlank(true);
        
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
    
    
    public ListProduitClientForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        current=this;
        initGuiBuilderComponents(resourceObjectInstance);
        prod=ServiceProduitClient.getInstance().getAllProducts();
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Produits", "Title"),
                        new Label(String.valueOf(prod.size()), "InboxNumber")
                )
        );
        
       // installSidemenu(resourceObjectInstance);
        
       // getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
       // getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm(resourceObjectInstance, this).show();}); 
        //getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        gui_Label_5.setShowEvenIfBlank(true);
        gui_Label_6.setShowEvenIfBlank(true);
        gui_Label_7.setShowEvenIfBlank(true);
        gui_Label_8.setShowEvenIfBlank(true);
        gui_Label_9.setShowEvenIfBlank(true);
        
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
    private com.codename1.ui.Label gui_Label_3;
    private com.codename1.ui.Label gui_Label_2 ;
    private com.codename1.ui.TextArea gui_Text_Area_1 ;
    private com.codename1.ui.Label gui_Label_6 ;
    
    //private com.codename1.ui.Container gui_Container_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.ui.Container gui_Container_2_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_1_1 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_4_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_4_1 = new com.codename1.ui.Label();
//   
//    private com.codename1.ui.Label gui_Label_3_1 = new com.codename1.ui.Label();
//    private com.codename1.ui.Label gui_Label_2_1 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_1;
    private com.codename1.ui.Label gui_Label_7 ;
//    private com.codename1.ui.Container gui_Container_1_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.ui.Container gui_Container_2_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_1_2 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_4_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_4_2 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_3_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
//    private com.codename1.ui.Label gui_Label_3_2 = new com.codename1.ui.Label();
//    private com.codename1.ui.Label gui_Label_2_2 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_2 ;
    private com.codename1.ui.Label gui_Label_8 ;
//    private com.codename1.ui.Container gui_Container_1_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.ui.Container gui_Container_2_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_1_3 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_4_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_4_3 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_3_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
//    private com.codename1.ui.Label gui_Label_3_3 = new com.codename1.ui.Label();
//    private com.codename1.ui.Label gui_Label_2_3 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_3 ;
    private com.codename1.ui.Label gui_Label_9;
//    private com.codename1.ui.Container gui_Container_1_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.ui.Container gui_Container_2_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_1_4 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_4_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
//    private com.codename1.ui.Label gui_Label_4_4 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_Container_3_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
//    private com.codename1.ui.Label gui_Label_3_4 = new com.codename1.ui.Label();
//    private com.codename1.ui.Label gui_Label_2_4 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_4;
    private com.codename1.ui.Label gui_Label_5 ;
    private Container entetec ;
    
 
    private SpanLabel gui_Label_desgn;

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
  private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
      
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("InboxForm");
        setName("InboxForm");
        
        entetec=new Container(BoxLayout.x());
        entetec.setUIID("DesignEnTete");
        //Label back=new Label();
        //FontImage iconB = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, "Back", 4.9f);
        //back.setIcon(iconB);
        Label title=new Label("Produits");
        entetec./*add(back).*/add(title);
        addComponent(entetec);
        
       /*back.addPointerPressedListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
              
            Command [] cmds = new Command[2];
            
            cmds[0] = new Command("Ok"){
            public void actionPerformed(ActionEvent evt) {

                ok=new SignInForm();
            } 
                };
                cmds[1] = new Command("Cancel") {
                    public void actionPerformed(ActionEvent evt) {
                        cancel=new AllProduitsForm();
                    }
                };
                Dialog.show("Title","Vous voulez vraiment deconnecter", cmds);
                cancel.showBack();
            }
        });*/
        
        prod=ServiceProduitClient.getInstance().getAllProducts();
        for(int i=0;i<prod.size();i++){
            
            //**********creation*********
            gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
            gui_Label_1 = new com.codename1.ui.Label();
            gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
            //gui_Label_4 = new com.codename1.ui.Label();
            gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
            gui_Label_3 = new com.codename1.ui.Label();
            gui_Label_2 = new com.codename1.ui.Label();
            gui_Text_Area_1 = new com.codename1.ui.TextArea();
            gui_Label_6 = new com.codename1.ui.Label();
            gui_Text_Area_1_1 = new com.codename1.ui.TextArea();
            gui_Label_7 = new com.codename1.ui.Label();
            gui_Text_Area_1_2 = new com.codename1.ui.TextArea();
            gui_Label_8 = new com.codename1.ui.Label();
            gui_Text_Area_1_3 = new com.codename1.ui.TextArea();
            gui_Label_9 = new com.codename1.ui.Label();
            gui_Text_Area_1_4 = new com.codename1.ui.TextArea();
            gui_Label_5 = new com.codename1.ui.Label();
            gui_Label_desgn = new SpanLabel();
            
            //************remplisage************   
            
            addComponent(gui_Container_1);

            gui_Container_1.setName("Container_1");
            /*gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2);
            gui_Container_2.setName("Container_2");
            gui_Container_2.addComponent(gui_Label_1);
            gui_Label_1.setText(String.valueOf(prod.get(i).getPrix()+"TND"));
            gui_Label_1.setUIID("PrixLabel");
            gui_Label_1.setName("Label_1");*/
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4);
            gui_Container_4.setName("Container_4");
            ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
            
            
            /*gui_Label_4.setUIID("Padding2");
            gui_Label_4.setName("Label_4");
            gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round.png"));*/
            
            placeHolder = EncodedImage.createFromImage(resourceObjectInstance.getImage("panier.png"), false);
           
            String url="http://localhost/Minipottt/Minipo/Minipo/web/assetsC/img/products/"+prod.get(i).getPhoto();
            Image img1 = URLImage.createToStorage(placeHolder, url, url, URLImage.RESIZE_SCALE);
            ImageViewer mm=new ImageViewer(img1);
            mm.setPreferredSize(new Dimension(400,400));
            
            gui_Container_4.add(mm);
            
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
            gui_Container_3.setName("Container_3");
            gui_Container_3.addComponent(gui_Label_desgn);
            gui_Container_3.addComponent(gui_Label_2);
            gui_Container_3.addComponent(gui_Text_Area_1);
            gui_Label_desgn.setText(prod.get(i).getDesignation());
            gui_Label_desgn.setName("Label_3");
            gui_Label_2.setText(String.valueOf(prod.get(i).getPrix()+"TND"));
            gui_Label_2.setUIID("PrixLabel");
            gui_Label_2.setName("Label_2");
            gui_Text_Area_1.setText("");
            gui_Text_Area_1.setUIID("SmallFontLabel");
            gui_Text_Area_1.setName("Text_Area_1");
            gui_Container_2.setName("Container_2");
            gui_Container_4.setName("Container_4");
            ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
            gui_Container_3.setName("Container_3");
            addComponent(gui_Label_6);
            
            int idProd=prod.get(i).getId();
            String desc=prod.get(i).getDescription();
            String desg=gui_Label_desgn.getText();
            float prix= prod.get(i).getPrix();
            int qte=prod.get(i).getQtestock();
            
            gui_Label_2.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new InfoProdForm(resourceObjectInstance ,desc ,desg,prix ,url,idProd,qte,current).show();
            }
        });
        
            gui_Container_1.setLeadComponent(gui_Label_2);
            
            
        }
        
  
    }// </editor-fold>
  
    
  
//-- DON'T EDIT ABOVE THIS LINE!!!
}
