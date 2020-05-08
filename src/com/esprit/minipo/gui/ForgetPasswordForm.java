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
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.minipo.MyApplication;
import com.esprit.minipo.entites.User;
import com.esprit.minipo.services.ServiceUser;
import static java.lang.System.err;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * GUI builder created Form
 *
 * @author Shai Almog
 */
public class ForgetPasswordForm extends com.codename1.ui.Form {
     public ArrayList<User> users;
     private Resources theme=UIManager.initFirstTheme("/theme");
      public static int idUser ;

    public ForgetPasswordForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
           
    }
    
    public ForgetPasswordForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
         Hashtable themeData = MyApplication.theme.getTheme("Theme");
         UIManager.getInstance().setThemeProps(themeData);
        getToolbar().addCommandToLeftBar("", mat, e -> new SplashForm().show());
        getContentPane().setUIID("SignInForm");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
   // private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_2.addActionListener(callback);
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

           /* if(sourceComponent == gui_Button_2) {
                onButton_2ActionEvent(ev);
            }*/
            
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Changer mot de passe ?");
        setName("ForgetPasswordForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Component_Group_1.addComponent(gui_Text_Field_1);
        //USERNAME
        gui_Text_Field_2.setHint("Email");
        gui_Text_Field_2.setName("Text_Field_2");
        //PASSWORD
        gui_Text_Field_1.setHint("nouveau mot de passe");
        gui_Text_Field_1.setConstraint(TextField.PASSWORD);
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Container_1.addComponent(gui_Button_2);
        gui_Container_1.addComponent(gui_Button_3);
       
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("Valider");
        gui_Button_2.setName("Button_2");
        
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
       
        
        
        
        
    }// </editor-fold>te

//-- DON'T EDIT ABOVE THIS LINE!!!
    
   
    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
      
    int i =0;
        if(users.get(i).getEmail().equals(this.gui_Text_Field_2.getText()))
                { 
        User u = new User( gui_Text_Field_1.getText());
        
        //if( ServiceUser.getInstance().UpdateUser(id, gui_Text_Field_1.getText(),gui_Text_Field_2.getText(),gui_Text_Field_3.getText(),gui_Text_Field_4.getText(),gui_Text_Field_5.getText(),gui_Text_Field_6.getText()))
        if( ServiceUser.getInstance().UpdateUser(u)) {                   
        Dialog.show("Success","Connection accepted",new Command("OK"));
        }else{
             Dialog.show("ERROR", "Server error", new Command("OK"));}}}
     
  /*  public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        users=ServiceUser.getInstance().getAllUsers();
        
        users.get(0).getUsername().contains(this.gui_Text_Field_2.getText());
        boolean res=false;
        int i=0;
        while(res==false && i<users.size()){
            System.out.println(this.gui_Text_Field_1.getText());
            if(users.get(i).getPassword().equals(this.gui_Text_Field_1.getText()) && 
                users.get(i).getUsername().equals(this.gui_Text_Field_2.getText())){
                   res=true;
                   idUser=users.get(i).getId();
                   System.out.println(idUser);
            }
            else {
                i++;
            }
        }
        
        if(res==true){
        
            if (users.get(i).getRoles().contains("ROLE_CLIENT")){
                            
                Hashtable themeData = theme.getTheme("Theme");
                UIManager.getInstance().setThemeProps(themeData);
                new ClientForm().show();
            }
             
            if (users.get(i).getRoles().contains("ROLE_EMPLOYE")){
                Hashtable themeData = theme.getTheme("BaseEmp");
                UIManager.getInstance().setThemeProps(themeData);
                new EmployeForm().show();
            }
            if (users.get(i).getRoles().contains("ROLE_RH")){
                Hashtable themeData = theme.getTheme("BaseEmp");
                UIManager.getInstance().setThemeProps(themeData);
                new AgentRHForm().show();
            }
            if (users.get(i).getRoles().contains("ROLE_LIVREUR")){      
                Hashtable themeData = theme.getTheme("BaseEmp");
                UIManager.getInstance().setThemeProps(themeData);
                new LivreurForm().show();
            }
        
        }
        
        
            
     
       
        
    }*/

}
