/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.esprit.minipo.entites.Conge;
import com.esprit.minipo.services.ServiceConge;
import java.util.ArrayList;

/**
 *
 * @author hafed
 */
public class BilanForm extends BaseAgentRHForm11{
    
    Form current;
    public BilanForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }
    
    
    //constructeur contenu
    public BilanForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        int sum=0 ;
        ArrayList<Conge> emp=new ArrayList<Conge>();
        emp=ServiceConge.getInstance().getAllConge();
        for(int i=0;i<emp.size();i++){
            if(emp.get(i).getEtatc() == "false"){
            sum++;
            }
        }
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Bilan", "Title"),
                        new Label(sum+"", "InboxNumber")
                )
        );
        
        installSidemenu(resourceObjectInstance);
        
       // getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
         getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        gui_Label_5.setShowEvenIfBlank(true);
        gui_Label_6.setShowEvenIfBlank(true);
        gui_Label_7.setShowEvenIfBlank(true);
        gui_Label_8.setShowEvenIfBlank(true);
        gui_Label_9.setShowEvenIfBlank(true);
        
        gui_Text_Area_1.setRows(2);
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
        gui_Text_Area_1_4.setEditable(false);
        
//        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
//        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
//        rb.uiid(true);
//        fab.bindFabToContainer(getContentPane());
//        fab.addActionListener(e -> {
//            new AjouterEmpForm(current).show();
//            fab.setUIID("FloatingActionButtonClose");
//            Image oldImage = fab.getIcon();
//            FontImage image = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "FloatingActionButton", 3.8f);
//            fab.setIcon(image);
//            Dialog popup = new Dialog();
//            popup.setDialogUIID("Container");
//            popup.setLayout(new LayeredLayout());
//            
//            Button c1 = new Button(resourceObjectInstance.getImage("contact-a.png"));
//            Button c2 = new Button(resourceObjectInstance.getImage("contact-b.png"));
//            Button c3 = new Button(resourceObjectInstance.getImage("contact-c.png"));
//            Button trans = new Button(" ");
//            trans.setUIID("Container");
//            c1.setUIID("Container");
//            c2.setUIID("Container");
//            c3.setUIID("Container");
//            Style c1s = c1.getAllStyles();
//            Style c2s = c2.getAllStyles();
//            Style c3s = c3.getAllStyles();
//            
//            c1s.setMarginUnit(Style.UNIT_TYPE_DIPS);
//            c2s.setMarginUnit(Style.UNIT_TYPE_DIPS);
//            c3s.setMarginUnit(Style.UNIT_TYPE_DIPS);
//
//            c1s.setMarginBottom(16);
//            c1s.setMarginLeft(12);
//            c1s.setMarginRight(3);
//
//            c2s.setMarginLeft(4);
//            c2s.setMarginTop(5);
//            c2s.setMarginBottom(10);
//            c3s.setMarginRight(14);
//            
//            c3s.setMarginTop(12);
//            c3s.setMarginRight(16);
//
//            popup.add(trans).
//                    add(FlowLayout.encloseIn(c1)).
//                    add(FlowLayout.encloseIn(c2)).
//                    add(FlowLayout.encloseIn(c3));
//            
//            ActionListener a = ee -> popup.dispose();
//            
//            trans.addActionListener(a);
//            c1.addActionListener(a);
//            c2.addActionListener(a);
//            c3.addActionListener(a);
//            
//            popup.setTransitionInAnimator(CommonTransitions.createEmpty());
//            popup.setTransitionOutAnimator(CommonTransitions.createEmpty());
//            popup.setDisposeWhenPointerOutOfBounds(true);
//            int t = AgentRHForm.this.getTintColor();
//            AgentRHForm.this.setTintColor(0);
//            popup.showPopupDialog(new Rectangle(AgentRHForm.this.getWidth() - 10, AgentRHForm.this.getHeight() - 10, 10, 10));
//            AgentRHForm.this.setTintColor(t);
//            fab.setUIID("FloatingActionButton");
//            fab.setIcon(oldImage);
//        });
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
    private com.codename1.ui.Label gui_Label_20 ;
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
    private com.codename1.ui.Button btnValider ;


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
//        Button btnValider = new Button("Accepter");
        ArrayList<Conge> emp=new ArrayList<Conge>();
        emp=ServiceConge.getInstance().getAllConge();
        for(int i=0;i<emp.size();i++){
            int id = emp.get(i).getIdcon();
            if(emp.get(i).getEtatc() == "false"){
            
         //creation
          gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
         gui_Label_1 = new com.codename1.ui.Label();
         gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
         gui_Label_4 = new com.codename1.ui.Label();
         gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
         gui_Label_3 = new com.codename1.ui.Label();
         gui_Label_2 = new com.codename1.ui.Label();
         gui_Label_20 = new com.codename1.ui.Label();
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
        btnValider = new com.codename1.ui.Button();
         //remplisage   
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("InboxForm");
        setName("InboxForm");
        addComponent(gui_Container_1);

        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2);
        gui_Container_2.setName("Container_2");
        gui_Container_2.addComponent(gui_Label_1);
        gui_Label_1.setText(emp.get(i).getNbrjrs()+"");
        gui_Label_1.setUIID("SmallFontLabel");
        gui_Label_1.setName("Label_1");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4);
        gui_Container_4.setName("Container_4");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_4.addComponent(gui_Label_4);
        gui_Label_4.setUIID("Padding2");
        gui_Label_4.setName("Label_4");
        gui_Label_4.setIcon(resourceObjectInstance.getImage("label_round.png"));
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
        gui_Container_3.setName("Container_3");
        gui_Container_3.addComponent(gui_Label_3);
        gui_Container_3.addComponent(gui_Label_2);
        gui_Container_3.addComponent(gui_Label_20);
        gui_Container_3.addComponent(gui_Text_Area_1);
        gui_Container_3.addComponent(btnValider);
        
        gui_Label_3.setText(emp.get(i).getFirstname()+" "+emp.get(i).getLastname());
        gui_Label_3.setName("Label_3");
        gui_Label_2.setText("Date de debut :  " + emp.get(i).getDatedebut());
        gui_Label_2.setUIID("RedLabel");
        gui_Label_2.setName("Label_2");
        
        gui_Label_20.setText("Date de fin :  " + emp.get(i).getDatefin());
        gui_Label_20.setUIID("RedLabel");
        gui_Label_20.setName("Label_2");
        
//        gui_Label_6.setText("");
//        gui_Label_6.setUIID("Separator");
//        gui_Label_6.setName("Label_6");
        btnValider.setText("Accepter");
        btnValider.setUIID("ButtonValiderConge");
        
        btnValider.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                  try {
                        
                        if( ServiceConge.getInstance().AccepterConge(id))
                            Dialog.show("Success","La demande a été accepté",new Command("OK"));
                        
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
              }
        });
        
        gui_Text_Area_1.setText(emp.get(i).getDescription());
        gui_Text_Area_1.setUIID("SmallFontLabel");
        gui_Text_Area_1.setName("Text_Area_1");
        gui_Container_2.setName("Container_2");
        gui_Container_4.setName("Container_4");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        gui_Container_3.setName("Container_3");
         addComponent(gui_Label_6);
        }
        }
//      
//       addComponent(gui_Container_1_1);
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
    
    /**
 * Creates a renderer for the specified colors.
 */
private DefaultRenderer buildCategoryRenderer(int[] colors) {
    DefaultRenderer renderer = new DefaultRenderer();
    renderer.setLabelsTextSize(15);
    renderer.setLegendTextSize(15);
    renderer.setMargins(new int[]{20, 30, 15, 0});
    for (int color : colors) {
        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(color);
        renderer.addSeriesRenderer(r);
    }
    return renderer;
}

/**
 * Builds a category series using the provided values.
 *
 * @param titles the series titles
 * @param values the values
 * @return the category series
 */
protected CategorySeries buildCategoryDataset(String title, double[] values) {
    CategorySeries series = new CategorySeries(title);
    int k = 0;
    for (double value : values) {
        series.add("Project " + ++k, value);
    }

    return series;
}

public Form createPieChartForm() {
    // Generate the values
    double[] values = new double[]{12, 14, 11, 10, 19};

    // Set up the renderer
    int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
    DefaultRenderer renderer = buildCategoryRenderer(colors);
    renderer.setZoomButtonsVisible(true);
    renderer.setZoomEnabled(true);
    renderer.setChartTitleTextSize(20);
    renderer.setDisplayValues(true);
    renderer.setShowLabels(true);
    SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
    r.setGradientEnabled(true);
    r.setGradientStart(0, ColorUtil.BLUE);
    r.setGradientStop(0, ColorUtil.GREEN);
    r.setHighlighted(true);

    // Create the chart ... pass the values and renderer to the chart object.
    PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);

    // Wrap the chart in a Component so we can add it to a form
    ChartComponent c = new ChartComponent(chart);

    // Create a form and show it.
    Form f = new Form("Budget", new BorderLayout());
    f.add(BorderLayout.CENTER, c);
    return f;

}
}
