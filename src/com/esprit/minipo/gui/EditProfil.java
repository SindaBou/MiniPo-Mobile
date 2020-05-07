/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.minipo.MyApplication;
import com.esprit.minipo.entites.User;
import com.esprit.minipo.services.ServiceUser;
import java.util.Hashtable;

/**
 *
 * @author ASUS
 */
public class EditProfil extends com.codename1.ui.Form {
    private Resources theme=UIManager.initFirstTheme("/theme");
    private User user;

    public EditProfil(com.codename1.ui.util.Resources resourceObjectInstance, String firstname,String lastname,String adresse,String Tel,String username,String email) {
        
        
        this(com.codename1.ui.util.Resources.getGlobalResources());
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(adresse);
        System.out.println(Tel);
        System.out.println(username);
        System.out.println(email);
        user=ServiceUser.getInstance().getUserProfil();
        System.out.println(user.getFirstname());
        gui_Text_Field_1.setText(user.getFirstname());
        gui_Text_Field_2.setText(lastname);
        gui_Text_Field_3.setText(adresse);
        gui_Text_Field_4.setText(Tel);
        gui_Text_Field_5.setText(username);
        gui_Text_Field_6.setText(email);
        
           
    }
    
    
    
    
  public EditProfil(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("EditTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "EditTitle", 3.5f);
         Hashtable themeData = MyApplication.theme.getTheme("Theme");
         UIManager.getInstance().setThemeProps(themeData);
         //Display.getInstance().getCurrent().refreshTheme();
        getToolbar().addCommandToLeftBar("", mat, e -> new SplashForm().show());
        getContentPane().setUIID(" Modifier profil");
        user=ServiceUser.getInstance().getUserProfil();
        System.out.println(user.getFirstname());
        gui_Text_Field_1.setText(user.getFirstname());
        gui_Text_Field_2.setText(user.getLastname());
        gui_Text_Field_3.setText(user.getAdresse());
        gui_Text_Field_4.setText(user.getTel());
        gui_Text_Field_5.setText(user.getUsername());
        gui_Text_Field_6.setText(user.getEmail());
        gui_Text_Field_7.setText(user.getPassword());
      
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
   // private com.codename1.ui.TextField gui_Text_Field_8 = new com.codename1.ui.TextField();
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
        setTitle("Modifier profil");
        setName("Modifier profil");
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
      //  gui_Component_Group_1.addComponent(gui_Text_Field_8);
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
        
    //    gui_Text_Field_8.setHint("confirmer mot de passe");
        //gui_Text_Field_8.setHint("password");
      //  gui_Text_Field_8.setName("Text_Field_8");
      //  gui_Text_Field_8.setConstraint(TextField.PASSWORD);
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Button_1.setText("Modifier");
        gui_Button_1.setUIID("CenterLabel");
        gui_Button_1.setName("Button_1");
        
        
        TextField Password = new TextField("", "Password", 20, TextField.PASSWORD);
             
    }
       
       public void onButton_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        User u = new User( gui_Text_Field_1.getText(),gui_Text_Field_2.getText(),gui_Text_Field_3.getText(),gui_Text_Field_4.getText(),gui_Text_Field_5.getText(),gui_Text_Field_6.getText(),gui_Text_Field_7.getText());
        
        //if( ServiceUser.getInstance().UpdateUser(id, gui_Text_Field_1.getText(),gui_Text_Field_2.getText(),gui_Text_Field_3.getText(),gui_Text_Field_4.getText(),gui_Text_Field_5.getText(),gui_Text_Field_6.getText()))
        if( ServiceUser.getInstance().UpdateUser(u)) {                   
        Dialog.show("Success","Connection accepted",new Command("OK"));
        }else{
             Dialog.show("ERROR", "Server error", new Command("OK"));}
            // new RegistrationForm().show();}
     }
       
       
    
           
           
        
    
    
}
