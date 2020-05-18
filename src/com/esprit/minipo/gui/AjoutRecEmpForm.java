/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.minipo.entites.ReclamationClient;
import com.esprit.minipo.entites.ReclamationsEmploye;
import com.esprit.minipo.services.ServiceRecClient;
import com.esprit.minipo.services.ServiceRecEmploye;
import com.codename1.capture.Capture;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextComponent;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.validation.GroupConstraint;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import com.esprit.minipo.MyApplication;
import com.esprit.minipo.entites.CategorieReclamationEmp;
import com.esprit.minipo.services.ServiceRecCategClient;
import com.esprit.minipo.services.ServiceRecCategEmploye;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import rest.file.uploader.tn.FileUploader;


/**
 *
 * @author bhk
 */
public class AjoutRecEmpForm extends BaseEmployeForm1{
    
        private static Form backForm ;
        
        Form current;
        
        final String pc="Probleme de compte";
        //final String pcmd="probleme de commande";
        final String autre="Autre";
        public int idcatrec=0;
        public int id=SignInForm.idUser;
        private FileUploader file;
        String fileNameInServer;
        private String imgPath;
        private com.codename1.ui.Label path=new com.codename1.ui.Label();
        private com.codename1.ui.Button imgBtn = new com.codename1.ui.Button();
        ArrayList<CategorieReclamationEmp> recClt=new ArrayList<CategorieReclamationEmp>();
        
        
        public AjoutRecEmpForm() {
        
        this(com.codename1.ui.util.Resources.getGlobalResources());
        }
        
        
        public AjoutRecEmpForm(com.codename1.ui.util.Resources resourceObjectInstance) {
            
            current=this;
            installSidemenu(resourceObjectInstance);
           // getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
            getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {
                                             Hashtable themeData = MyApplication.theme.getTheme("Theme");
                                             UIManager.getInstance().setThemeProps(themeData);    
                                              new SignInForm().show();});
            setTitle("Envoyer une Reclamation");
            setLayout(BoxLayout.y());
            initGuiBuilderComponents(resourceObjectInstance);
            
    }
        public AjoutRecEmpForm(com.codename1.ui.util.Resources resourceObjectInstance,Form f) {
            
            AjoutRecEmpForm.backForm=f;
            current=this;
        
            installSidemenu(resourceObjectInstance);
           // getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
            getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {
                                             Hashtable themeData = MyApplication.theme.getTheme("Theme");
                                             UIManager.getInstance().setThemeProps(themeData);    
                                              new SignInForm().show();});
            setTitle("Envoyer une Reclamation");
            setLayout(BoxLayout.y());
            initGuiBuilderComponents(resourceObjectInstance);
            
    }
   
   
     
// <editor-fold defaultstate="collapsed" desc="Generated Code">   
      private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
          
          TextModeLayout tl = new TextModeLayout(2, 2);
            TextComponent tfObjet = new TextComponent().label("objet");
            TextComponent taDescription = new TextComponent().label("Description").multiline(true);
            taDescription.rows(4);
            TableLayout fullNameLayout = new TableLayout(2, 2);
            Container CONTAINER=new Container(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
            Container container=new Container(tl);
            Container containerImage=new Container(fullNameLayout);
            Button btnValider = new Button("Envoyer");
            btnValider.setPreferredSize(new Dimension(50,110));
            path = new Label(".");
            imgBtn = new Button();
            imgBtn.setUIID("btnImage");
            imgBtn.setMaterialIcon(FontImage.MATERIAL_ADD_A_PHOTO);
            imgBtn.setPreferredSize(new Dimension(150,150));
            Button cancel = new Button("Cancel"); 
             //fullNameLayout.setWidthPercentage(20);
              containerImage.add(fullNameLayout.createConstraint().widthPercentage(85),path)
                            .add(fullNameLayout.createConstraint().widthPercentage(15),imgBtn);
            recClt=ServiceRecCategEmploye.getInstance().getAllCategorieClient();
            ComboBox c= new ComboBox("Categorie");
            for(int i=0;i<recClt.size();i++){

            c.addItem(recClt.get(i).getNom());}
            //c.addItem(pcmd);
            //c.addItem(autre);
            //c.setUIID("ComboBoxItem");
            Validator val = new Validator();
            //val.addConstraint(tfObjet, new ServiceRecClient(5,"trop long"));
            //val.addConstraint(tfObjet, new LengthConstraint(2,"trop court"));
            val.addConstraint(tfObjet,new GroupConstraint(new LengthConstraint(2,"trop court"),new ServiceRecClient(5,"trop long")));
            val.addConstraint(taDescription, new LengthConstraint(2,"trop court"));
            val.addSubmitButtons(btnValider);
            //***************************************************************************
            container.add(c).add(tl.createConstraint().widthPercentage(49), tfObjet).
            add(tl.createConstraint().widthPercentage(1), createSeparator()).
            add(tl.createConstraint().horizontalSpan(50), taDescription)
            .add(containerImage).add(btnValider);
     //************************
    /* Style btnImageStyle = imgBtn.getAllStyles();
    Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
    btnImageStyle.setBorder(RoundRectBorder.create().
            strokeColor(0).
            strokeOpacity(50).
            stroke(borderStroke));*/
    //*********************
             Style btnStyle = btnValider.getAllStyles();
             Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
             btnStyle.setBorder(RoundRectBorder.create().
             strokeColor(0).
             strokeOpacity(50).
             stroke(borderStroke));
    //*******************
    //CONTAINER.add(container);
          Style cStyle = c.getAllStyles();
    //Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
            cStyle.setBorder(RoundRectBorder.create().
            strokeColor(0).
            strokeOpacity(50).
            stroke(borderStroke));
            cStyle.setBgColor(0xccff);
            cStyle.setBgTransparency(255);
            cStyle.setBackgroundGradientRelativeX(0xf4753f);
            cStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
            cStyle.setMargin(Component.BOTTOM, 3);
    //******************
            Style loginStyle = tfObjet.getAllStyles();
    //Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
            loginStyle.setBorder(RoundRectBorder.create().
            strokeColor(0).
            strokeOpacity(120).
            stroke(borderStroke));
            loginStyle.setBgColor(0xffffff);
            loginStyle.setBgTransparency(255);
            loginStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
            loginStyle.setMargin(Component.BOTTOM, 3);
    //**********************************
             Style passwordStyle = taDescription.getAllStyles();
             passwordStyle.setBorder(RoundRectBorder.create().
            strokeColor(0).
            strokeOpacity(120).
            stroke(borderStroke));
            passwordStyle.setBgColor(0xffffff);
            passwordStyle.setBgTransparency(255);

            Button closeButton = new Button();
            closeButton.setPreferredSize(new Dimension(40,40));
            Style closeStyle = closeButton.getAllStyles();
            closeStyle.setFgColor(0xffffff);
            closeStyle.setBgTransparency(0);
            closeStyle.setPaddingUnit(Style.UNIT_TYPE_DIPS);
            closeStyle.setPadding(3, 3, 3, 3);
    //closeStyle.setBorder(RoundBorder.create().shadowOpacity(100));
            FontImage.setMaterialIcon(closeButton, FontImage.MATERIAL_CANCEL);

            Container layers = LayeredLayout.encloseIn(container, FlowLayout.encloseRight());
            Style boxStyle = container.getUnselectedStyle();
            boxStyle.setBgTransparency(255);
    //boxStyle.setBgColor(0xeeeeee);
            boxStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
            boxStyle.setPaddingUnit(Style.UNIT_TYPE_DIPS);
            boxStyle.setMargin(4, 3, 3, 3);
            boxStyle.setPadding(2, 2, 2, 2);
            //***************************************************************************
             imgBtn.addPointerPressedListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt) {
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
            });
            btnValider.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if ((tfObjet.getText().length()==0)||(taDescription.getText().length()==0))
                        Dialog.show("Alert", "Veuillez remplir tous les champs", new Command("OK"));
                    else
                    {
                        try {
                             switch (c.getSelectedItem().toString()) {
                        case pc:
                            idcatrec=1;
                             break;
                        /*case pcmd:
                            idcatrec=2;
                            break;*/
                        case autre:
                            idcatrec=3;
                             break;}

                            ReclamationsEmploye r = new ReclamationsEmploye(id,idcatrec, tfObjet.getText(),taDescription.getText(),fileNameInServer);
                            if( ServiceRecEmploye.getInstance().addRec(r)){
                                Dialog.show("Success","Reclamation Envoyée",new Command("OK"));
                                 ToastBar.Status status = ToastBar.getInstance().createStatus();
                                 status.setMessage("Reclamation envoyée");
                                 status.show();
                               new MesRecEmpForm(resourceObjectInstance, current).show();
                            }
                            else
                                Dialog.show("ERROR", "Server error", new Command("OK"));
                        } catch (NumberFormatException e) {
                            Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                        }

                    }


                }
            });
             Container entetec=new Container(BoxLayout.x());
            entetec.setUIID("DesignEnTete");
            Label back=new Label();
            FontImage iconB = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, "Supprimer", 4.9f);
            back.setIcon(iconB);
            Label title=new Label("Reclamation");
            entetec.add(back).add(title);
            add(entetec);
            add( layers);
             back.addPointerPressedListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt) {
                    AjoutRecEmpForm.backForm.showBack();
                }
            });
            //addAll(c,tfObjet,taDescription,path ,imgBtn,btnValider);
            //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

        
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
 private Label createSeparator() {
    Label sep = new Label();
    sep.setUIID("Separator");
    // the separator line  is implemented in the theme using padding and background color, by default labels
    // are hidden when they have no content, this method disables that behavior
    sep.setShowEvenIfBlank(true);
    return sep;
}
    
}
