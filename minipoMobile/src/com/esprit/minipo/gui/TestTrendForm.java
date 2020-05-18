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
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import static com.esprit.minipo.MyApplication.theme;
import com.esprit.minipo.entites.Articles;
import com.esprit.minipo.services.ServiceBlog;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class TestTrendForm extends BaseForm {
    private ArrayList<Articles> blog=new ArrayList<Articles>();
    private EncodedImage placeHolder;
    private String name;
    private String imageURL;
    public static int idBlog ;
    
    public static Form backForm;
    

    public TestTrendForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public TestTrendForm(com.codename1.ui.util.Resources resourceObjectInstance,Form f) {
        TestTrendForm.backForm=f;
        initGuiBuilderComponents(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm(resourceObjectInstance, this).show();}); 
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
        installSidemenu(resourceObjectInstance);
        
        
        FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_LOCATION_ON);
        gui_LA.setIconPosition(BorderLayout.EAST);

        FontImage.setMaterialIcon(gui_newYork, FontImage.MATERIAL_LOCATION_ON);
        gui_newYork.setIconPosition(BorderLayout.EAST);     
    }
    
    public TestTrendForm(com.codename1.ui.util.Resources resourceObjectInstance,String titre,String description,Form f) {
        this.backForm=f;
        initGuiBuilderComponents(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm(resourceObjectInstance, this).show();}); 
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
        installSidemenu(resourceObjectInstance);
        
        
        FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_LOCATION_ON);
        gui_LA.setIconPosition(BorderLayout.EAST);

        FontImage.setMaterialIcon(gui_newYork, FontImage.MATERIAL_LOCATION_ON);
        gui_newYork.setIconPosition(BorderLayout.EAST);     
    }
    
    public TestTrendForm(com.codename1.ui.util.Resources resourceObjectInstance,String titre,String description) {
        
        initGuiBuilderComponents(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm(resourceObjectInstance, this).show();}); 
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
        installSidemenu(resourceObjectInstance);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        
        FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_LOCATION_ON);
        gui_LA.setIconPosition(BorderLayout.EAST);

        FontImage.setMaterialIcon(gui_newYork, FontImage.MATERIAL_LOCATION_ON);
        gui_newYork.setIconPosition(BorderLayout.EAST);     
    }
    
    
   public TestTrendForm(com.codename1.ui.util.Resources resourceObjectInstance) {
       String image = null;
        initGuiBuilderComponents(resourceObjectInstance);
        
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
      
        
        installSidemenu(resourceObjectInstance);
        
        
        FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_LOCATION_ON);
        gui_LA.setIconPosition(BorderLayout.EAST);

        FontImage.setMaterialIcon(gui_newYork, FontImage.MATERIAL_LOCATION_ON);
        gui_newYork.setIconPosition(BorderLayout.EAST);
     
    }
   
   
    
    
    
    
    
    

//-- DON'T EDIT BELOW THIS LINE!!!
    //private com.codename1.ui.Container gui_Container_1 ;
    private com.codename1.components.MultiButton gui_Multi_Button_1 ;
    private com.codename1.components.MultiButton gui_LA ;
    private com.codename1.ui.Container gui_imageContainer1;
    private com.codename1.ui.Container gui_Container_2 ;
    private com.codename1.ui.Label gui_Text_Area_1 ;
    private com.codename1.ui.Button gui_Button_1 ;
    private com.codename1.ui.Label gui_separator1;
    private com.codename1.ui.Container gui_null_1_1 ;
    private com.codename1.components.MultiButton gui_null_1_1_1 ;
    private com.codename1.components.MultiButton gui_newYork;
    private com.codename1.ui.Container gui_imageContainer2 ;
    private com.codename1.ui.Container gui_Container_3;
    private com.codename1.ui.Label gui_Text_Area_2 ;
    private com.codename1.ui.Button gui_Button_2;
    private com.codename1.ui.Label gui_Label_1_1_1;

    private com.codename1.ui.Container entetec;
    
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Blogs");
        setName("TrendingForm");
        entetec=new Container(BoxLayout.x());
        entetec.setUIID("DesignEnTete");
        Label back=new Label();
        FontImage iconB = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, "Back", 4.9f);
        back.setIcon(iconB);
        Label title=new Label("Blogs");
        entetec.add(back).add(title);
        addComponent(entetec);
        
        back.addPointerPressedListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
               // new MesRecClientForm().show();
               TestTrendForm.backForm.showBack();
            }
        });
       blog=ServiceBlog.getInstance().getAllBlog();
       for(int i=0;i<blog.size();i++){
           String titre=blog.get(i).getTitre();
           String description = blog.get(i).getDescription();
           String image = blog.get(i).getImagename();
       
       //Creation
       
        //gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Multi_Button_1 = new com.codename1.components.MultiButton();
        gui_LA = new com.codename1.components.MultiButton();
        gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Text_Area_1 = new com.codename1.ui.Label();
        gui_Button_1 = new com.codename1.ui.Button();
        gui_separator1 = new com.codename1.ui.Label();
        gui_null_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_null_1_1_1 = new com.codename1.components.MultiButton();
        gui_newYork = new com.codename1.components.MultiButton();
        gui_imageContainer2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Text_Area_2 = new com.codename1.ui.Label();
        gui_Button_2 = new com.codename1.ui.Button();
        gui_Label_1_1_1 = new com.codename1.ui.Label();
       
       //Remplissage
        //gui_Container_1.setName("Container_1");
        //gui_Multi_Button_1.setUIID("Label");
        gui_Multi_Button_1.setName("Multi_Button_1");
        //gui_Multi_Button_1.setIcon(resourceObjectInstance.getImage("contact-c.png"));
        gui_Multi_Button_1.setPropertyValue("line1", blog.get(i).getTitre());
        gui_Multi_Button_1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_LARGE));
       // gui_Multi_Button_1.setPropertyValue("line2", "");
       // gui_Multi_Button_1.setPropertyValue("uiid1", "Label");
       // gui_Multi_Button_1.setPropertyValue("uiid2", "RedLabel");
        
       /* gui_LA.setUIID("Label");
        gui_LA.setName("LA");
        gui_LA.setPropertyValue("line1", "");
        gui_LA.setPropertyValue("line2", "");
        gui_LA.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
        gui_LA.setPropertyValue("uiid2", "RedLabelRight");*/
        
        gui_imageContainer1.setName("imageContainer1");
        
        gui_Container_2.setName("Container_2");
       
        //paragrahe
        
        gui_Text_Area_1.setText(blog.get(i).getDescription());
        gui_Text_Area_1.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_1.setName("Text_Area_1");
        gui_Button_1.setText("");
        gui_Button_1.setUIID("Label");
        gui_Button_1.setName("Button_1");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_1,"".charAt(0));
        gui_Container_2.setName("Container_2");
         
      //  gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_1);
      //  gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST,gui_Button_1);
        gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
         //gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1);
         //gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_LA);
        Container container=new Container(BoxLayout.y());
        TableLayout fullNameLayout = new TableLayout(2, 2);
        Container container2=new Container(fullNameLayout);
        container2.add(fullNameLayout.createConstraint().widthPercentage(85),gui_Text_Area_1).add(gui_Button_1);
        
        placeHolder = EncodedImage.createFromImage(resourceObjectInstance.getImage("Point_d_interrogation.jpg"), false); // hethi t7otoha fel default package 
           String url="http://localhost:82/Minipo/Minipo/web/uploads/post/"+image;
           Image image1=URLImage.createToStorage(placeHolder, url, url,URLImage.RESIZE_SCALE);
           
           ImageViewer img=new ImageViewer(image1);
        container.add(gui_Multi_Button_1).add(img).add(container2);
        
        //ScaleImageLabel sl = new ScaleImageLabel(resourceObjectInstance.getImage("bridge.jpg"));
         //String image= blog.get(i).getImagename();
         
          // img.setSwipePlaceholder(Image.createImage(5, 5));
           img.setPreferredSize(new Dimension(400,400));
       // image1.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
       // gui_imageContainer1.add( img);
        //************design container layer**************
        Container layers = LayeredLayout.encloseIn(container, FlowLayout.encloseRight());
                  Style boxStyle = container.getUnselectedStyle();
                  boxStyle.setBgTransparency(255);
//boxStyle.setBgColor(0xeeeeee);
                boxStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
                boxStyle.setPaddingUnit(Style.UNIT_TYPE_DIPS);
                boxStyle.setMargin(3, 3, 3, 3);
               boxStyle.setPadding(2, 2, 2, 2);
               // boxStyle.setPaddingBottom(0);
//*******************************************************************
       /*
        addComponent(gui_null_1_1);gui_Text_Area_1);
        gui_Container_2.add(
        gui_null_1_1.setName("null_1_1");
        gui_null_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_null_1_1_1);
        gui_null_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_newYork);
        gui_null_1_1_1.setUIID("Label");
        gui_null_1_1_1.setName("null_1_1_1");
        gui_null_1_1_1.setIcon(resourceObjectInstance.getImage("contact-b.png"));
        gui_null_1_1_1.setPropertyValue("line1", "Detra Mcmunn");
        gui_null_1_1_1.setPropertyValue("line2", "@dropperidiot");
        gui_null_1_1_1.setPropertyValue("uiid1", "Label");
        gui_null_1_1_1.setPropertyValue("uiid2", "RedLabel");
        gui_newYork.setUIID("Label");
        gui_newYork.setName("newYork");
        gui_newYork.setPropertyValue("line1", "15 minutes ago");
        gui_newYork.setPropertyValue("line2", "in New York");
        gui_newYork.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
        gui_newYork.setPropertyValue("uiid2", "RedLabelRight");
        addComponent(gui_imageContainer2);
        gui_imageContainer2.setName("imageContainer2");
        gui_imageContainer2.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_3);
        gui_Container_3.setName("Container_3");
        gui_Container_3.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_2);
        gui_Container_3.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Button_2);
        gui_Text_Area_2.setText("Griffith Observatory is a facility in Los Angeles, California sitting on the south-facing slope of Mount Hollywood in Los Angeles' Griffith Park.");
        gui_Text_Area_2.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_2.setName("Text_Area_2");
        gui_Button_2.setText("");
        gui_Button_2.setUIID("Label");
        gui_Button_2.setName("Button_2");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_2,"".charAt(0));
        */gui_Container_3.setName("Container_3");
        
        //gui_Container_1.setName("Container_1");
        gui_imageContainer1.setName("imageContainer1");
     //   gui_separator1.setUIID("Separator");
      //  gui_separator1.setName("separator1");
        gui_null_1_1.setName("null_1_1");
        //gui_imageContainer2.setName("imageContainer2");
       // gui_Label_1_1_1.setUIID("Separator");
        gui_Label_1_1_1.setName("Label_1_1_1");
        
        
        
         addComponent(layers);
       //  addComponent(gui_imageContainer1);
         //addComponent(gui_separator1);
        // addComponent(gui_Label_1_1_1);
        
         gui_Button_1.addPointerPressedListener(new ActionListener() {
                @Override
               
                public void actionPerformed(ActionEvent evt) {
                //com.codename1.ui.util.Resources resourceObjectInstance = null;
                    //this
                     Hashtable themeData = theme.getTheme("Theme");
         blog=ServiceBlog.getInstance().getAllBlog();
         //idBlog=blog.get(i).getId();
         UIManager.getInstance().setThemeProps(themeData);
         new ShowMoreBlog(resourceObjectInstance,titre,description,image).show();}

             
                

            
        });
        
       
    }
        
        
        
        
       }
        
    /**
     *
     * @param ev
     */
   
        
        
        
        
        
        
       
        
    // </editor-fold>
    
    

//-- DON'T EDIT ABOVE THIS LINE!!!

    @Override
    protected boolean isCurrentTrending() {
        return true;
    }
}
//gui_Button_1
        
        
        
        
        
        
        


        
        