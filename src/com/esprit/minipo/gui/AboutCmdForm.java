/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;
import com.esprit.minipo.entites.AboutCmd;
import com.esprit.minipo.entites.Panier;
import com.esprit.minipo.services.ServiceCommande;
import com.esprit.minipo.services.ServiceLigneCommande;
import java.util.ArrayList;
import javafx.scene.image.ImageView;

/**
 *
 * @author bhk
 */
public class AboutCmdForm extends BaseForm{
    
    private EncodedImage placeHolder;
    
    private ArrayList<AboutCmd> pan=new ArrayList<AboutCmd>();
    
     /*public AboutCmdForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }*/
     
    
    Form current;

    public AboutCmdForm(com.codename1.ui.util.Resources resourceObjectInstance ,int idcmd) {
    
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        
        current=this;
        
        setTitle("Detail Commande");
        setLayout(BoxLayout.y());
        initGuiBuilderComponents(resourceObjectInstance, idcmd);
        
    }
    
     private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance, int idcmd) {

        pan=ServiceLigneCommande.getInstance().aboutCmd(idcmd);

        Container globc=new Container(BoxLayout.yCenter());
        Container panc=new Container(BoxLayout.y());
        
        for(int i=0;i<pan.size();i++){
           
            Container container_1=new Container(BoxLayout.x());
            container_1.setUIID("LayaoutBoxY");
            Container container_2=new Container(BoxLayout.y());
            Container container_3=new Container(BoxLayout.y());
            container_3.setUIID("MarginLabelPan");
            Container container_4=new Container(BoxLayout.x());
            container_4.setUIID("MarginLabelPan");
            Container container_sup=new Container(BoxLayout.x());
            Container container_mod=new Container(BoxLayout.x());
            
            

           
            
            SpanLabel des=new SpanLabel();
            des.setText(pan.get(i).getDesignation());
            Label prix=new Label(String.valueOf(pan.get(i).getQte()+"X"
                    +String.valueOf(pan.get(i).getPrix())));
            
            container_3.add(des).add(prix);
            container_3.getAllStyles().setMargin(50,0, 0,0);
            
            container_2.add(container_3).add(container_4);
            
            placeHolder = EncodedImage.createFromImage(resourceObjectInstance.getImage("panier.png"), false);
            String url="http://localhost:82/Minipo/Minipo/web/assetsC/img/products/"+pan.get(i).getPhoto();
            Image img1 = URLImage.createToStorage(placeHolder, url, url, URLImage.RESIZE_SCALE);
            ImageViewer mm=new ImageViewer(img1);
            mm.setUIID("MarginImage");
            mm.setPreferredSize(new Dimension(300,300));
            container_1.add(mm).add(container_2);

            panc.add(container_1);

        } 
                
        Container entetec=new Container(BoxLayout.x());
        entetec.setUIID("DesignEnTete");
        Label back=new Label();
        FontImage iconB = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, "Back", 4.9f);
        back.setIcon(iconB);
        Label title=new Label(pan.get(0).getRefc());
        entetec.add(back).add(title);
        
        
        Container totalc=new Container(BoxLayout.x());
        totalc.setUIID("LayaoutBoxY");
        Label img2=new Label("Total:"
           + "                       ");
        img2.setUIID("MarginImage");
        Label tot=new Label(String.valueOf(pan.get(0).getTotal()));
        tot.setUIID("MarginTotal");
        totalc.add(img2).add(tot);
        
        
        Container container_1=new Container(BoxLayout.x());
        
        
        Label labEt=new Label("Etat: ");
        labEt.getAllStyles().setMargin(50,50,100,0);
        labEt.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_SMALL));
        Label labdat=new Label("Date: ");
        labdat.getAllStyles().setMargin(50, 50, 0,0);
        labdat.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_SMALL));
       
        Label etat=new Label(pan.get(0).getEtatc());
        etat.getAllStyles().setMargin(50,50,0,10);
        Label date=new Label((pan.get(0).getDatec()));
        date.getAllStyles().setMargin(50, 50, 0, 50);
        
        if(pan.get(0).getEtatc().equals("Acceptee")){
            etat.getAllStyles().setFgColor(0x006400);
        }else if (pan.get(0).getEtatc().equals("Validee")){
            etat.getAllStyles().setFgColor(0xFF0000);
        }else{
            etat.getAllStyles().setFgColor(0xf4753f);
        }
        
        
        container_1.setUIID("LayaoutBoxY");        
        container_1.add(labEt).add(etat).add(labdat).add(date);
        
        
        
        Button Reclamer=new Button("Reclamer");
        
        Reclamer.setPreferredSize(new Dimension(50,110));
        Style btnStyle = Reclamer.getAllStyles();
        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        btnStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStroke));
        
        
        //Reclamer.setSize(new Dimension(400,600));
                
        globc.add(entetec).add(container_1).add(panc).add(totalc).add(Reclamer);
        addComponent(globc);
        
        
    }
     
    
}
