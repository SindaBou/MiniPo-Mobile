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

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.TextField;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.minipo.MyApplication;
import com.esprit.minipo.entites.User;
import com.esprit.minipo.services.BCrypt;
import com.esprit.minipo.services.ServiceUser;
import com.esprit.minipo.utils.StaticVariables;

//import com.esprit.minipo.services.service_bcrypt;

import java.util.Hashtable;




/**
 * GUI builder created Form
 *
 * @author Shai Almog
 */
public class RegistrationForm extends com.codename1.ui.Form {
         private Resources theme=UIManager.initFirstTheme("/theme");

    public RegistrationForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
           
    }
    
  public RegistrationForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
         Hashtable themeData = MyApplication.theme.getTheme("Theme");
         UIManager.getInstance().setThemeProps(themeData);
         //Display.getInstance().getCurrent().refreshTheme();
        getToolbar().addCommandToLeftBar("", mat, e -> new SplashForm().show());
        getContentPane().setUIID(" RegistrationForm");
    }
  
  //-- DON'T EDIT BELOW THIS LINE!!!
   private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_4 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_5 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_6 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_7 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_8 = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    
    
    
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_1.addActionListener(callback);

    } 
        class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }
            if(sourceComponent == gui_Button_1) {
                onButton_1ActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
        
       private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Registration");
        setName("RegistrationForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_1);
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Component_Group_1.addComponent(gui_Text_Field_3);
        gui_Component_Group_1.addComponent(gui_Text_Field_4);
        gui_Component_Group_1.addComponent(gui_Text_Field_5);
        gui_Component_Group_1.addComponent(gui_Text_Field_6);
        gui_Component_Group_1.addComponent(gui_Text_Field_7);
        gui_Component_Group_1.addComponent(gui_Text_Field_8);
        gui_Text_Field_1.setHint("Prenom");
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Text_Field_2.setHint("Nom");
        gui_Text_Field_2.setName("Text_Field_2");
        gui_Text_Field_3.setHint("Adresse");
        gui_Text_Field_3.setName("Text_Field_3");
        gui_Text_Field_4.setHint("Numero de telephone");
        gui_Text_Field_4.setName("Text_Field_4");
        gui_Text_Field_5.setHint("Non d'utilisateur");
        gui_Text_Field_5.setName("Text_Field_5");
        gui_Text_Field_6.setHint("Email");
        gui_Text_Field_6.setName("Text_Field_6");
        //TextField Password1 = new TextField("", "Password", 20, TextField.PASSWORD);
        gui_Text_Field_7.setHint("mot de passe");
        gui_Text_Field_7.setName("Text_Field_7");
        gui_Text_Field_7.setConstraint(TextField.PASSWORD);
        
        gui_Text_Field_8.setHint("confirmer mot de passe");
        //gui_Text_Field_8.setHint("password");
        gui_Text_Field_8.setName("Text_Field_8");
        gui_Text_Field_8.setConstraint(TextField.PASSWORD);
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Button_1.setText("Validate");
        gui_Button_1.setUIID("CenterLabel");
        gui_Button_1.setName("Button_1");
        
        TextField Password = new TextField("", "Password", 20, TextField.PASSWORD);
             
    }
       
       public void onButton_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
          
        //BCrypt
           //String pIcrypt = service_bcrypt.hashpw(pass,service_bcrypt.gensalt());
          String pass = gui_Text_Field_7.getText();
          
          String hashed = BCrypt.hashpw(pass, StaticVariables.SALT);
        //  String hashed = BCrypt.hashpw(pass,BCrypt.gensalt(pass,BCrypt.gensalt()));
          User u = new User( gui_Text_Field_1.getText(),gui_Text_Field_2.getText(),gui_Text_Field_3.getText(),gui_Text_Field_4.getText(),gui_Text_Field_5.getText(),gui_Text_Field_6.getText(),hashed);
        
                        if( ServiceUser.getInstance().addUser(u))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
         new RegistrationForm().show();
     }
       
    
    
    

}
