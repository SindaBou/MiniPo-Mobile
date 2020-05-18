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

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.location.Geofence;
import com.codename1.location.LocationManager;
import com.codename1.notifications.LocalNotification;
import com.codename1.notifications.LocalNotificationCallback;
import com.codename1.push.Push;
import com.codename1.push.PushAction;
import com.codename1.push.PushActionCategory;
import com.codename1.push.PushActionsProvider;
import com.codename1.push.PushCallback;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import com.esprit.minipo.MyApplication;
import com.esprit.minipo.entites.Livraison;
import com.esprit.minipo.entites.ReclamationClient;
import com.esprit.minipo.services.ServiceLivraison;
import com.esprit.minipo.services.ServiceRecClient;
import com.esprit.minipo.services.ServiceRecEmploye;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;


/**
 * GUI builder created Form
 *
 * @author shai
 */
public class TestLivraisonForm extends BaseLivreurForm11  {
    
    
    public TestLivraisonForm(int id) {
        this(com.codename1.ui.util.Resources.getGlobalResources(), id);
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }

    
    public TestLivraisonForm(com.codename1.ui.util.Resources resourceObjectInstance ,int id) {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        livraison = ServiceLivraison.getInstance().getLivraison(id);
        System.out.println(livraison);
        System.out.println(id);
        
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {
                                             Hashtable themeData = MyApplication.theme.getTheme("Theme");
                                             UIManager.getInstance().setThemeProps(themeData);    
                                              new SignInForm().show();});
        setTitle("Livraison");
        setLayout(BoxLayout.y());
         
        LabelEtat.setText(livraison.getEtatl());
        LabelEtat.setHeight(30);
        LabelEtat.setWidth(100);
        
        if (livraison.getEtatl().equals("livree")){
            LabelEtat.getAllStyles().setFgColor(0x006400);
        
        }else if (livraison.getEtatl().equals("refusee")){
            LabelEtat.getAllStyles().setFgColor(0xf4753f);
            
        }
        else{
            LabelEtat.setUIID("RedLabel");
        }
        
       
        TableLayout table = new TableLayout(2, 2);
        Label date =new Label(livraison.getDateliv());
        date.getAllStyles().setAlignment(RIGHT);
        Container x= new Container(table);
         x.add(table.createConstraint().widthPercentage(65),LabelEtat).add(date);
        LabelEtat.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        LabelMatricule.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        tMatricule.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_SMALL));
        LabelDestination.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        tfDestination.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_SMALL));
        tMatricule.getAllStyles().setFgColor(0x000000);
        tfDestination.getAllStyles().setFgColor(0x000000);
        LabelMatricule.setText("Matricule");
        LabelDestination.setText("Destination");
        tMatricule.setText(livraison.getMatriculeL());
        tfDestination.setText(livraison.getDestination());
         
        
        TableLayout fullNameLayout = new TableLayout(7,1);
        TextModeLayout tl = new TextModeLayout(2, 2);
        Container composant =new Container(tl);
        
        ComboBox etat= new ComboBox("Etat");
        etat.addItem("livree");
        etat.addItem("refusee");
        etat.addItem("en cours");
        
        
        //etat.setUIID("ComboBoxItem");
       
        etat.addSelectionListener((oldSelected, newSelected) -> {
            System.out.println(newSelected);
            if (etat.getSelectedIndex() == 1) {
                ServiceLivraison.getInstance().updateEtat(id, "livree");
                new LivreurForm().show();
            } else if (newSelected == 2) {
                ServiceLivraison.getInstance().updateEtat(id, "refusee");
                new LivreurForm().show();
            }
        });
       
        
        composant.add(x)
                .add(fullNameLayout.createConstraint().widthPercentage(85),LabelMatricule)
                .add(tMatricule)
                .add(LabelDestination)
                .add(tfDestination)
                .add(etat);
               
          

        //**************design Cbx Etat************
        Style cStyle = etat.getAllStyles();
        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        cStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStroke));
        cStyle.setBgColor(0xccff);
        cStyle.setBgTransparency(255);
        cStyle.setBackgroundGradientRelativeX(0xf4753f);
        cStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
        cStyle.setMargin(Component.BOTTOM, 3);
        
        //*******design container Layer*******
        Container layers = LayeredLayout.encloseIn(composant, FlowLayout.encloseRight());
        Style boxStyle = composant.getUnselectedStyle();
        boxStyle.setBgTransparency(255);
        boxStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
        boxStyle.setPaddingUnit(Style.UNIT_TYPE_DIPS);
        boxStyle.setMargin(4, 3, 3, 3);
        boxStyle.setPadding(2, 2, 2, 2);
        //***********************************
        
        entetec=new Container(BoxLayout.x());
        entetec.setUIID("DesignEnTete");
        Label back=new Label();
        FontImage iconB = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, "Back", 4.9f);
        back.setIcon(iconB);
        Label title=new Label("Detail Livraison");
        entetec.add(back).add(title);
        //c.add(c)
        //c.add(image1);
        addAll(entetec,layers);
        back.addPointerPressedListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                new LivreurForm().show();
            }
        }); 
          
                         
        
    
    }
    
    public TestLivraisonForm(com.codename1.ui.util.Resources resourceObjectInstance) {
       
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private int id;
    private Livraison livraison;
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    private com.codename1.ui.ComboBox c = new com.codename1.ui.ComboBox();
    private com.codename1.ui.Label LabelEtat = new com.codename1.ui.Label();
    private com.codename1.ui.Label LabelMatricule = new com.codename1.ui.Label();
    private com.codename1.ui.Label tMatricule = new com.codename1.ui.Label();
    private com.codename1.ui.Label tfDestination = new com.codename1.ui.Label();
    private com.codename1.ui.Label LabelDestination = new com.codename1.ui.Label();
    private com.codename1.ui.Container entetec ;
    

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
  private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        System.out.println("test update:" + id);
        
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

}
