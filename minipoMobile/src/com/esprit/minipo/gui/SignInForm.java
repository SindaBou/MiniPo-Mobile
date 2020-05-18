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

import com.codename1.components.InfiniteProgress;
import com.codename1.io.AccessToken;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.social.FacebookConnect;
import com.codename1.social.Login;
import com.codename1.social.LoginCallback;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import com.esprit.minipo.MyApplication;
import com.esprit.minipo.entites.Usere;
import com.esprit.minipo.services.BCrypt;
import com.esprit.minipo.services.ServiceUser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.err;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * GUI builder created Form
 *
 * @author Shai Almog
 */
public class SignInForm extends com.codename1.ui.Form {
     public ArrayList<Usere> users;
     private Resources theme=MyApplication.theme;
      public static int idUser ;
      private Login login;
      private Form loginForm;
      
      private com.codename1.ui.util.Resources res;

    public SignInForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        res = com.codename1.ui.util.Resources.getGlobalResources();
    }
    
    public SignInForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        res = resourceObjectInstance;
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        // Hashtable themeData = MyApplication.theme.getTheme("Theme");
         //UIManager.getInstance().setThemeProps(themeData);
         //Display.getInstance().getCurrent().refreshTheme();
        getToolbar().addCommandToLeftBar("", mat, e -> new SplashForm(theme).show());
        getContentPane().setUIID("SignInForm");
        
        
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField("", "Username", 30, TextField.ANY);
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField("", "Mot de passe", 30, TextField.PASSWORD);
   private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_4 = new com.codename1.ui.Button();
     
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    Style loginStyle = gui_Text_Field_2.getAllStyles();
    Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
    Style passwordStyle = gui_Text_Field_1.getAllStyles();
    Style btnStyle = gui_Button_2.getAllStyles();
    Style btnStyle2 = gui_Button_4.getAllStyles();
    
    
    
   

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_2.addActionListener(callback);
        gui_Button_1.addActionListener(callback);
        gui_Button_4.addActionListener(callback);

    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.util.Resources resourceObjectInstance,com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button_2) {
                onButton_2ActionEvent(ev);
            }
            if(sourceComponent == gui_Button_1) {
                onButton_1ActionEvent(ev);
            }
           
            if(sourceComponent == gui_Button_4) {
                onButton_4ActionEvent(res,ev);
            }
        }

        public void dataChanged(int type, int index) {
        }

       
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Sign In");
        setName("SignInForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.getAllStyles().setMargin(100, 0, 0,0);
        gui_Container_1.addComponent(gui_Text_Field_2);
        gui_Container_1.addComponent(gui_Text_Field_1);
        gui_Text_Field_2.setName("Text_Field_2");
       // gui_Text_Field_2.setPreferredSize(new Dimension(100, 100));
       
        Image imgface=resourceObjectInstance.getImage("téléchargé.png");
        imgface.scale(1000 ,400);
        
        
        gui_Button_4.setIcon(imgface);
        gui_Button_4.setUIID("ButtonFace");
        gui_Button_4.setPreferredSize(new Dimension(100,200));
        gui_Button_4.getAllStyles().setMargin(10,0, 0,15);
        
        
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Container_1.addComponent(gui_Button_2);
        gui_Container_1.addComponent(gui_Button_4);
       
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        gui_Label_1.getAllStyles().setMargin(100,5, 0, 0);
        gui_Label_1.setIcon(resourceObjectInstance.getImage("logo-M-v1.png"));
       // gui_Label_1.setPreferredSize(new Dimension(40,40));
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("Connecter");
        gui_Button_2.setName("Button_2");
        
       
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Button_1.setText("Create New Account");
        gui_Button_1.setUIID("CenterLabel");
        gui_Button_1.setName("Button_1");
       
        //gui_Button_2.setUIID("Button1");
        ////Facebook
       // gui_Button_4.setText("Facebook");
        
        
        loginStyle.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xffffff).
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
        loginStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
        loginStyle.setMargin(Component.BOTTOM, 3);
        loginStyle.setMargin(Component.TOP, 5);
        
        
        passwordStyle.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xffffff).
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
        loginStyle.setMargin(Component.TOP, 3);
        loginStyle.setMargin(Component.BOTTOM, 5);
       
        btnStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStroke));
        btnStyle.setBgColor(0xf4753f);
        btnStyle.setMargin(5, 3, 0, 0);
        
        /*btnStyle2.setBorder(RoundRectBorder.create().
        
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStroke));
        btnStyle2.setBgColor(0xfcddce);*/
        
        
        
        gui_Text_Field_1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE,Font.STYLE_PLAIN , Font.SIZE_LARGE));
      
        gui_Text_Field_2.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE,Font.STYLE_PLAIN , Font.SIZE_LARGE));
        gui_Button_2.setPreferredSize(new Dimension(50,150));
     //   Validator v = new Validator();
      //  v.addConstraint(gui_Text_Field_2, new LengthConstraint(4)).
     //   addConstraint(gui_Text_Field_1, new LengthConstraint(4));
      //  v.addSubmitButtons(gui_Button_2);
        
       
        
        
    }// </editor-fold>te

//-- DON'T EDIT ABOVE THIS LINE!!!
    
     public void onButton_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
         
         Hashtable themeData = MyApplication.theme.getTheme("Theme");
         UIManager.getInstance().setThemeProps(themeData);
         new RegistrationForm(MyApplication.theme).show();
     }
     
     
     
     
     
     
     public void onButton_4ActionEvent(com.codename1.ui.util.Resources resourceObjectInstance,com.codename1.ui.events.ActionEvent ev) {
       /*  Hashtable themeData = theme.getTheme("Theme");
         UIManager.getInstance().setThemeProps(themeData);
         new ForgetPasswordForm().show();*/
       
                //create your own app identity on facebook follow the guide here:
                //facebook-login.html
                String clientId = "651570495685061";
                String redirectURI = "http://localhost/";
                String clientSecret = "9a081cbe520a454fdc16e118cb29821c";
                
                if(clientSecret.length() == 0){
                    System.err.println("create your own facebook app follow the guide here:");
                    System.err.println("http://www.codenameone.com/facebook-login.html");
                    return;
                }
                
                
                Login fb = FacebookConnect.getInstance();
                fb.setClientId(clientId);
                fb.setRedirectURI(redirectURI);
                fb.setClientSecret(clientSecret);
                login = fb;
                fb.setCallback(new LoginListener(LoginListener.FACEBOOK));
                if(!fb.isUserLoggedIn()){
                    fb.doLogin();
                }else{
                    showFacebookUser(resourceObjectInstance,fb.getAccessToken().getToken());
                }

        
     }
     
     
     
    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
      
          
        users=ServiceUser.getInstance().getAllUsers();
        
        users.get(0).getUsername().contains(this.gui_Text_Field_2.getText());
        boolean res=false;
        int i=0;
         if ((gui_Text_Field_1.getText().length()==0)||(gui_Text_Field_2.getText().length()==0))
                    Dialog.show("Alert", "Veuillez remplir les champs vides", new Command("OK"));
                else
         {
        while(res==false && i<users.size()){
            System.out.println(this.gui_Text_Field_1.getText());
            
        
           String password = this.gui_Text_Field_1.getText();
          
           String crypted = users.get(i).getPassword();

            if(BCrypt.checkpw(password,crypted) && 
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
        
            BaseForm f=new BaseForm();
            f.setImg((EncodedImage) theme.getImage("user.jpg"));
            f.setUrl("http://localhost:82/Minipo/Minipo/web/uploads/post/" +users.get(i).getImage());
            f.setNameuser(users.get(i).getUsername());
            
            BaseEmployeForm1 fe = new BaseEmployeForm1();
            fe.setImg((EncodedImage) theme.getImage("user.jpg"));
            fe.setUrl("http://localhost:82/Minipo/Minipo/web/uploads/post/" +users.get(i).getImage());
            fe.setNameuser(users.get(i).getUsername());
                
            BaseAgentRHForm11 rh=new BaseAgentRHForm11();
            rh.setImg((EncodedImage) theme.getImage("user.jpg"));
            rh.setUrl("http://localhost:82/Minipo/Minipo/web/uploads/post/" +users.get(i).getImage());
            rh.setNameuser(users.get(i).getUsername());
                
            BaseLivreurForm11 liv= new BaseLivreurForm11();
            liv.setImg((EncodedImage) theme.getImage("user.jpg"));
            liv.setUrl("http://localhost:82/Minipo/Minipo/web/uploads/post/" +users.get(i).getImage());
            liv.setNameuser(users.get(i).getUsername());

            
            if (users.get(i).getRoles().contains("ROLE_CLIENT")){

                Hashtable themeData = theme.getTheme("Theme");
                UIManager.getInstance().setThemeProps(themeData);
                new AllProduitsForm().show();
            }
             
            if (users.get(i).getRoles().contains("ROLE_EMPLOYE")){
            
                Hashtable themeData = theme.getTheme("BaseEmp");
                UIManager.getInstance().setThemeProps(themeData);
                new EmployeRhForm().show();
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
        
    }
        
    }
    
     private void showFacebookUser(com.codename1.ui.util.Resources resourceObjectInstance, String token){
       ConnectionRequest req = new ConnectionRequest();
        req.setPost(false);
        req.setUrl("https://graph.facebook.com/v2.3/me");
        req.addArgumentNoEncoding("access_token", token);
        InfiniteProgress ip = new InfiniteProgress();
        Dialog d = ip.showInifiniteBlocking();
        NetworkManager.getInstance().addToQueueAndWait(req);
        byte[] data = req.getResponseData();
        JSONParser parser = new JSONParser();
        Map map = null;
        try {
            map = parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(data), "UTF-8"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String name = (String) map.get("name");
        d.dispose();
        BaseForm f= new BaseForm();
        f.setImg((EncodedImage) theme.getImage("téléchargé.png"));
        f.setUrl("https://graph.facebook.com/v2.3/me/picture?access_token=" + token);
        f.setNameuser(name);
        Form InboxForm = new InboxForm (resourceObjectInstance , name, (EncodedImage) theme.getImage("téléchargé.png"), "https://graph.facebook.com/v2.3/me/picture?access_token=" + token);
        InboxForm .show();
    }
     public class LoginListener extends LoginCallback {

        public static final int FACEBOOK = 0;

      //  public static final int GOOGLE = 1;

        private int loginType;

        public LoginListener(int loginType) {
            this.loginType = loginType;
        }

        public void loginSuccessful() {

            try {
                AccessToken token = login.getAccessToken();
                if (loginType == FACEBOOK) {
                    showFacebookUser(res,token.getToken());
                } /*else if (loginType == GOOGLE) {
                    showGoogleUser(token.getToken());
                }*/

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void loginFailed(String errorMessage) {
            Dialog.show("Login Failed", errorMessage, "Ok", null);
        }
    }

}