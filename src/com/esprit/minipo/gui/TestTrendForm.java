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

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;
import com.esprit.minipo.entites.Articles;
import com.esprit.minipo.services.ServiceBlog;
import java.util.ArrayList;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class TestTrendForm extends BaseForm {
    private ArrayList<Articles> blog=new ArrayList<Articles>();
    private EncodedImage placeHolder;
    

    public TestTrendForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public TestTrendForm(com.codename1.ui.util.Resources resourceObjectInstance,String image,String titre,String description) {
        initGuiBuilderComponents(resourceObjectInstance);
         getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
         getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
        //image1
        ScaleImageLabel sl = new ScaleImageLabel(resourceObjectInstance.getImage("skate-park.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        gui_imageContainer1.add(BorderLayout.CENTER, sl);
        //omage2
        sl = new ScaleImageLabel(resourceObjectInstance.getImage("bridge.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        gui_imageContainer2.add(BorderLayout.CENTER, sl);
        
        installSidemenu(resourceObjectInstance);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        
        FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_LOCATION_ON);
        gui_LA.setIconPosition(BorderLayout.EAST);

        FontImage.setMaterialIcon(gui_newYork, FontImage.MATERIAL_LOCATION_ON);
        gui_newYork.setIconPosition(BorderLayout.EAST);
        
        gui_Text_Area_2.setRows(2);
        gui_Text_Area_2.setColumns(100);
        gui_Text_Area_2.setGrowByContent(false);
        gui_Text_Area_2.setEditable(false);
        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setGrowByContent(false);
        gui_Text_Area_1.setEditable(false);
        
        //String url="http://localhost:82/MiniPo-web/web/uploads/post/"+image;
        //   Image image1=URLImage.createToStorage(placeHolder, url, url,URLImage.RESIZE_SCALE);
        
           
    }
    
    
   public TestTrendForm(com.codename1.ui.util.Resources resourceObjectInstance) {
       String image = null;
        initGuiBuilderComponents(resourceObjectInstance);
        
         getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
         getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
        //image1
        
       /* for(int i=0;i<blog.size();i++){ 
        ScaleImageLabel sl = new ScaleImageLabel(resourceObjectInstance.getImage("bridge.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        gui_imageContainer1.add(BorderLayout.CENTER, sl);
        }*/
        //omage2
      /*  sl = new ScaleImageLabel(resourceObjectInstance.getImage("bridge.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        gui_imageContainer2.add(BorderLayout.CENTER, sl);*/
        
        installSidemenu(resourceObjectInstance);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        
        FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_LOCATION_ON);
        gui_LA.setIconPosition(BorderLayout.EAST);

        FontImage.setMaterialIcon(gui_newYork, FontImage.MATERIAL_LOCATION_ON);
        gui_newYork.setIconPosition(BorderLayout.EAST);
         
        gui_Text_Area_2.setRows(2);
        gui_Text_Area_2.setColumns(100);
        gui_Text_Area_2.setGrowByContent(false);
        gui_Text_Area_2.setEditable(false);
        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setGrowByContent(false);
        gui_Text_Area_1.setEditable(false);
        
        
        
        
        
        
        
    }
    

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 ;
    private com.codename1.components.MultiButton gui_Multi_Button_1 ;
    private com.codename1.components.MultiButton gui_LA ;
    private com.codename1.ui.Container gui_imageContainer1;
    private com.codename1.ui.Container gui_Container_2 ;
    private com.codename1.ui.TextArea gui_Text_Area_1 ;
    private com.codename1.ui.Button gui_Button_1 ;
    private com.codename1.ui.Label gui_separator1;
    private com.codename1.ui.Container gui_null_1_1 ;
    private com.codename1.components.MultiButton gui_null_1_1_1 ;
    private com.codename1.components.MultiButton gui_newYork;
    private com.codename1.ui.Container gui_imageContainer2 ;
    private com.codename1.ui.Container gui_Container_3;
    private com.codename1.ui.TextArea gui_Text_Area_2 ;
    private com.codename1.ui.Button gui_Button_2;
    private com.codename1.ui.Label gui_Label_1_1_1;

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Blogs");
        setName("TrendingForm");
        blog=ServiceBlog.getInstance().getAllBlog();
        
         
        
     
       
        
       for(int i=0;i<blog.size();i++){ 
       
       //Creation
       
        gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Multi_Button_1 = new com.codename1.components.MultiButton();
        gui_LA = new com.codename1.components.MultiButton();
        gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Text_Area_1 = new com.codename1.ui.TextArea();
        gui_Button_1 = new com.codename1.ui.Button();
        gui_separator1 = new com.codename1.ui.Label();
        gui_null_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_null_1_1_1 = new com.codename1.components.MultiButton();
        gui_newYork = new com.codename1.components.MultiButton();
        gui_imageContainer2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Text_Area_2 = new com.codename1.ui.TextArea();
        gui_Button_2 = new com.codename1.ui.Button();
        gui_Label_1_1_1 = new com.codename1.ui.Label();
       
       //Remplissage
        gui_Container_1.setName("Container_1");
        gui_Multi_Button_1.setUIID("Label");
        gui_Multi_Button_1.setName("Multi_Button_1");
        gui_Multi_Button_1.setIcon(resourceObjectInstance.getImage("contact-c.png"));
        gui_Multi_Button_1.setPropertyValue("line1", blog.get(i).getTitre());
        gui_Multi_Button_1.setPropertyValue("line2", "");
        gui_Multi_Button_1.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_1.setPropertyValue("uiid2", "RedLabel");
        gui_LA.setUIID("Label");
        gui_LA.setName("LA");
        gui_LA.setPropertyValue("line1", "");
        gui_LA.setPropertyValue("line2", "");
        gui_LA.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
        gui_LA.setPropertyValue("uiid2", "RedLabelRight");
        
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
         
         gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_1);
         gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST,gui_Button_1);
         gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
         gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1);
         gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_LA);
        
        ScaleImageLabel sl = new ScaleImageLabel(resourceObjectInstance.getImage("bridge.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        gui_imageContainer1.add(BorderLayout.CENTER, sl);
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
        
        gui_Container_1.setName("Container_1");
        gui_imageContainer1.setName("imageContainer1");
        gui_separator1.setUIID("Separator");
        gui_separator1.setName("separator1");
        gui_null_1_1.setName("null_1_1");
        //gui_imageContainer2.setName("imageContainer2");
        gui_Label_1_1_1.setUIID("Separator");
        gui_Label_1_1_1.setName("Label_1_1_1");
        
        
        
         addComponent(gui_Container_1);
         addComponent(gui_imageContainer1);
         addComponent(gui_separator1);
         addComponent(gui_Label_1_1_1);
       }
        
        
        
        
        
        
        
        
       
        
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

    @Override
    protected boolean isCurrentTrending() {
        return true;
    }
}

        
        
        
        
        
        
        


        
        