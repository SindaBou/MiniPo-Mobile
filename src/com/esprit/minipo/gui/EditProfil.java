/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.capture.Capture;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.esprit.minipo.MyApplication;
import com.esprit.minipo.entites.Usere;
import com.esprit.minipo.services.BCrypt;
import com.esprit.minipo.services.ServiceUser;
import com.esprit.minipo.utils.StaticVariables;
import java.util.ArrayList;
import java.util.Hashtable;
import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author ASUS
 */
public class EditProfil extends com.codename1.ui.Form {
    private Resources theme=MyApplication.theme;
    private Usere user;

    String img;
    private String imgPath;
    String Imagecode ;
    private FileUploader file;
    String fileNameInServer;
    public ArrayList<Usere> users;
    
    private static Form backForm;
    
   /* public EditProfil(com.codename1.ui.util.Resources resourceObjectInstance, String firstname,String lastname,String adresse,String Tel,String username,String email,String image) {
        
        
        this(com.codename1.ui.util.Resources.getGlobalResources());
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(adresse);
        System.out.println(Tel);
        System.out.println(username);
        System.out.println(email);
        System.out.println(image);
        user=ServiceUser.getInstance().getUserProfil();
        System.out.println(user.getFirstname());
        gui_Text_Field_1.setText(user.getFirstname());
        gui_Text_Field_2.setText(lastname);
        gui_Text_Field_3.setText(adresse);
        gui_Text_Field_4.setText(Tel);
        gui_Text_Field_5.setText(username);
        gui_Text_Field_6.setText(email);
        path.setText(image);
        
           
    }*/
    
    public EditProfil(com.codename1.ui.util.Resources resourceObjectInstance, Form f) {
        EditProfil.backForm=f;
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("EditTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "EditTitle", 3.5f);
         Hashtable themeData = MyApplication.theme.getTheme("Theme");
         UIManager.getInstance().setThemeProps(themeData);
         //Display.getInstance().getCurrent().refreshTheme();
          
        FontImage m = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, "Back", 4.9f);
        
        getToolbar().addCommandToLeftBar("", m, e -> EditProfil.backForm.showBack());
        getContentPane().setUIID(" Modifier profil");
        user=ServiceUser.getInstance().getUserProfil();
        System.out.println(user.getFirstname());
        gui_Text_Field_1.setText(user.getFirstname());
        gui_Text_Field_2.setText(user.getLastname());
        gui_Text_Field_3.setText(user.getAdresse());
        gui_Text_Field_4.setText(user.getTel());
        gui_Text_Field_5.setText(user.getUsername());
        gui_Text_Field_6.setText(user.getEmail());
       // gui_Text_Field_7.setText(user.getPassword());
       if(user.getImage().equals("null")) {
           path.setText("Upload Image");
           path.getAllStyles().setFgColor(0xA9A9A9);
       }else{
           path.setText(user.getImage());
       }
       
      
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
        getToolbar().addCommandToLeftBar("", mat, e -> new SplashForm(theme).show());
        getContentPane().setUIID(" Modifier profil");
        user=ServiceUser.getInstance().getUserProfil();
        System.out.println(user.getFirstname());
        gui_Text_Field_1.setText(user.getFirstname());
        gui_Text_Field_2.setText(user.getLastname());
        gui_Text_Field_3.setText(user.getAdresse());
        gui_Text_Field_4.setText(user.getTel());
        gui_Text_Field_5.setText(user.getUsername());
        gui_Text_Field_6.setText(user.getEmail());
       // gui_Text_Field_7.setText(user.getPassword());
        path.setText(user.getImage());
      
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
    private com.codename1.ui.Label path = new com.codename1.ui.Label(".");
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private TableLayout fullNameLayout = new TableLayout(2, 2);
    private Container containerImage=new Container(fullNameLayout);
   // private com.codename1.ui.TextField gui_Text_Field_8 = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    Style loginStyle = gui_Text_Field_2.getAllStyles();
    Style loginStyle1 = gui_Text_Field_1.getAllStyles();
    Style loginStyle2 = gui_Text_Field_3.getAllStyles();
    Style loginStyle3 = gui_Text_Field_4.getAllStyles();
    Style loginStyle4 = gui_Text_Field_5.getAllStyles();
    Style loginStyle5 = gui_Text_Field_6.getAllStyles();
    Style loginStyle6 = gui_Text_Field_7.getAllStyles();
    Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
  //  Style btnStyle = gui_Button_1.getAllStyles();

    public EditProfil() {
      
    }
    
    
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_1.addActionListener(callback);
        gui_Button_2.addActionListener(callback);
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
             if(sourceComponent == gui_Button_2) {
                onButton_2ActionEvent(ev);
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
        //gui_Container_1.addComponent(gui_Component_Group_1);
        //gui_Component_Group_1.setName("Component_Group_1");
        gui_Container_1.addComponent(gui_Text_Field_1);
        gui_Container_1.addComponent(gui_Text_Field_2);
        gui_Container_1.addComponent(gui_Text_Field_3);
        gui_Container_1.addComponent(gui_Text_Field_4);
        gui_Container_1.addComponent(gui_Text_Field_5);
        gui_Container_1.addComponent(gui_Text_Field_6);
        gui_Container_1.addComponent(gui_Text_Field_7);
        //gui_Container_1.addComponent(path);
        gui_Container_1.addComponent(containerImage);
        gui_Container_1.addComponent(gui_Button_1);
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
      //  addComponent( gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Button_1.setText("Modifier");
      //  gui_Button_1.setUIID("CenterLabel");
      // gui_Button_1.setUIID("Button1");
        gui_Button_1.setName("Button_1");
        
        
        TextField Password = new TextField("", "Password", 20, TextField.PASSWORD);
        
        
        loginStyle.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xffffff).
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
        loginStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
        loginStyle.setMargin(Component.BOTTOM, 3);
        
        loginStyle1.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xffffff).
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
        loginStyle1.setMarginUnit(Style.UNIT_TYPE_DIPS);
        loginStyle1.setMargin(Component.BOTTOM, 3);
        
        loginStyle2.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xffffff).
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
        loginStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
        loginStyle2.setMargin(Component.BOTTOM, 3);
        
        loginStyle3.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xffffff).
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
        loginStyle3.setMarginUnit(Style.UNIT_TYPE_DIPS);
        loginStyle3.setMargin(Component.BOTTOM, 3);
        
        loginStyle4.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xffffff).
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
        loginStyle4.setMarginUnit(Style.UNIT_TYPE_DIPS);
        loginStyle4.setMargin(Component.BOTTOM, 3);
        
        loginStyle5.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xffffff).
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
        loginStyle5.setMarginUnit(Style.UNIT_TYPE_DIPS);
        loginStyle5.setMargin(Component.BOTTOM, 3);
        
        loginStyle6.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xffffff).
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
        loginStyle6.setMarginUnit(Style.UNIT_TYPE_DIPS);
        loginStyle6.setMargin(Component.BOTTOM, 3);
        
        
        Style btnStyle = gui_Button_1.getAllStyles();
        btnStyle.setBorder(RoundRectBorder.create().
        
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStroke));
        //btnStyle.setBgColor(0xfcddce);
        
        gui_Button_1.setPreferredSize(new Dimension(50,150));
        gui_Button_2.setUIID("btnImage");
        gui_Button_2.setMaterialIcon(FontImage.MATERIAL_ADD_A_PHOTO);
        gui_Button_2.setPreferredSize(new Dimension(150,150));
        
        
        containerImage.add(fullNameLayout.createConstraint().widthPercentage(85),path)
                        .add(fullNameLayout.createConstraint().widthPercentage(15),gui_Button_2);
       
        
        gui_Text_Field_2.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE,Font.STYLE_PLAIN , Font.SIZE_LARGE));
        gui_Text_Field_3.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE,Font.STYLE_PLAIN , Font.SIZE_LARGE));
        gui_Text_Field_1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE,Font.STYLE_PLAIN , Font.SIZE_LARGE));
        gui_Text_Field_4.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE,Font.STYLE_PLAIN , Font.SIZE_LARGE));
        gui_Text_Field_5.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE,Font.STYLE_PLAIN , Font.SIZE_LARGE));
        gui_Text_Field_6.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE,Font.STYLE_PLAIN , Font.SIZE_LARGE));
        gui_Text_Field_7.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE,Font.STYLE_PLAIN , Font.SIZE_LARGE));
        
        String phoneConstraint = "^[0-9]";
        Validator v = new Validator();
        v.addConstraint(gui_Text_Field_1, new LengthConstraint(4)).
        addConstraint(gui_Text_Field_2, new LengthConstraint(4)).
        addConstraint(gui_Text_Field_5, new LengthConstraint(4)).
        addConstraint(gui_Text_Field_7, new LengthConstraint(1)).
        addConstraint(gui_Text_Field_3, new LengthConstraint(4)).
        addConstraint(gui_Text_Field_6, RegexConstraint.validEmail()).
        addConstraint(gui_Text_Field_4, new RegexConstraint(phoneConstraint, "Please enter a valid phone number"));
        v.addSubmitButtons(gui_Button_1);

        
             
    }
       
       public void onButton_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        String pass = gui_Text_Field_7.getText();
        String hashed = BCrypt.hashpw(pass, StaticVariables.SALT);
        Usere u = new Usere( gui_Text_Field_1.getText(),gui_Text_Field_2.getText(),gui_Text_Field_3.getText(),gui_Text_Field_4.getText(),gui_Text_Field_5.getText(),gui_Text_Field_6.getText(),hashed,fileNameInServer);
        users=ServiceUser.getInstance().getAllUsers();
        String password = this.gui_Text_Field_7.getText();
        boolean res=false;
        int i=0;
          
        while(res==false && i<users.size()){
        String crypted = users.get(i).getPassword();
        
        if((BCrypt.checkpw(password,crypted))&( ServiceUser.getInstance().UpdateUser(u))){
            
            
        Dialog.show("Success","Modification Validée",new Command("OK"));
        res=true;
        
        }else{
             
             i++;
             Dialog.show("ERROR", "Echec de la modification", new Command("OK"));
        }
       
            // new RegistrationForm().show();}
     }
     }
       
      public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
       
            try {
                    imgPath = Capture.capturePhoto();
                    System.out.println(imgPath);
                    String link=imgPath.toString();
                    int pod=link.indexOf("/",2);
                    String news=link.substring(pod + 2, link.length());
                    System.out.println(""+news);
                    FileUploader fu = new FileUploader("http://localhost:82/Minipo/Minipo/web/uploads/");
                    fileNameInServer = fu.upload(news);
                    path.setText(fileNameInServer);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }  
    
           
           
        
    
    
}
