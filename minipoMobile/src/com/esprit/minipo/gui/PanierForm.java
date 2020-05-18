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
import com.esprit.minipo.entites.Panier;
import com.esprit.minipo.services.ServiceCommande;
import com.esprit.minipo.services.ServiceLigneCommande;
import java.util.ArrayList;
import javafx.scene.image.ImageView;

/**
 *
 * @author bhk
 */

public class PanierForm extends BaseForm{
    
    private static Form backForm ;
    private EncodedImage placeHolder;
    
    private ArrayList<Panier> pan=new ArrayList<Panier>();
    
    
    
    
    
    public PanierForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
        
    }
 
     
    
    Form current;
    
     public PanierForm(com.codename1.ui.util.Resources resourceObjectInstance , Form f) {
         
         
        PanierForm.backForm=f;
        
        pan=ServiceLigneCommande.getInstance().getMonPanier();
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Panier", "Title"),
                        new Label(String.valueOf(pan.size()), "InboxNumber")
                )
        );
        
        
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        
        current=this;
        setLayout(BoxLayout.y());
        initGuiBuilderComponents(resourceObjectInstance);
        
    }

    public PanierForm(com.codename1.ui.util.Resources resourceObjectInstance ) {
    
        pan=ServiceLigneCommande.getInstance().getMonPanier();
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Factures", "Title"),
                        new Label(String.valueOf(pan.size()), "InboxNumber")
                )
        );
        
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("panier.png"), e -> {new PanierForm().show();}); 
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logout6.png"), e -> {new SignInForm().show();});
        
        current=this;
        setTitle("Panier");
        setLayout(BoxLayout.y());
        initGuiBuilderComponents(resourceObjectInstance);
        
    }
    
     private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        pan=ServiceLigneCommande.getInstance().getMonPanier();
        
        if(pan.size()==0){
             
            
            Container container_c=new Container(BoxLayout.y());
            Container container_cc=new Container(new FlowLayout(CENTER));
            container_cc.setUIID("PanVide");
            container_cc.getAllStyles().setMargin(70, 0, 0, 0);
             
            //FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_ADD_SHOPPING_CART, "Panier est Vide", 30.0f);
            //Image mat = resourceObjectInstance.getImage("add_shopping_cart_black.png");
            Image mat = resourceObjectInstance.getImage("add_shopping_cart.png");
            mat.scale(500,500);
            Label vide=new Label();
            vide.setIcon(mat);
            vide.getAllStyles().setAlignment(CENTER);
            vide.getAllStyles().setMargin(110, 150, 110, 150);
            
            Label lab=new Label("Vous n'avez pas d'article dans le panier");
            lab.getAllStyles().setFont(Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_SMALL));
            lab.getAllStyles().setAlignment(CENTER);
            lab.getAllStyles().setMargin(0, 70, 10, 10);
            
            Button btn=new Button("COMMENCEZ VOS ACHATS");
        
            btn.setPreferredSize(new Dimension(50,110));
            Style btnStyle = btn.getAllStyles();
            Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
            btnStyle.setBorder(RoundRectBorder.create().
            strokeColor(0).
            strokeOpacity(50).
            stroke(borderStroke));
            
            Container entetec=new Container(BoxLayout.x());
            entetec.setUIID("DesignEnTete");
            Label back=new Label("Panier");
            FontImage iconB = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, "Back", 4.9f);
            back.setIcon(iconB);
            entetec.add(back);
            
            container_cc.add(vide);
            container_c.add(entetec).add(container_cc).add(lab).add(btn);
            addComponent(container_c); 
            
            btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new AllProduitsForm(resourceObjectInstance).show();
                
            }
            });
            back.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                PanierForm.backForm.show();
            }
           });
            
        }
        else{
        
  
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
            

            Button moins =new Button("-");
            moins.setUIID("plus");
            Button plus=new Button("+");
            plus.setUIID("plus");
            plus.getAllStyles().setMargin(0,0, 0, 20);
            TextField qte=new TextField();
            qte.setText(String.valueOf(pan.get(i).getQte()));
            qte.setUIID("TextField");
            qte.setColumns(1);
            FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_DELETE_OUTLINE, "Supprimer", 4.9f);
            Label sup=new Label("|Retirer");
            sup.setIcon(mat);
            

            container_4.add(sup).add(moins).add(qte).add(plus);
            container_4.getAllStyles().setMargin(20, 50,0,0);
            
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
            
           
            /*Container container_1=new Container(BoxLayout.x());
            
            Container container_2=new Container(BoxLayout.y());
            container_2.setUIID("LayaoutBoxY");
            
            Container container_3=new Container(BoxLayout.y());
            container_3.setUIID("MarginLabelPan");
            Container container_4=new Container(BoxLayout.x());
            container_4.setUIID("MarginLabelPan");
            Container container_sup=new Container(BoxLayout.x());
            Container container_mod=new Container(BoxLayout.x());
            
            Button moins =new Button("-");
            moins.setUIID("plus");
            Button plus=new Button("+");
            plus.setUIID("plus");
            TextField qte=new TextField();
            qte.setText(String.valueOf(pan.get(i).getQte()));
            qte.setUIID("TextField");
            qte.setColumns(1);
            FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_DELETE_OUTLINE, "Supprimer", 4.9f);
            Label sup=new Label(mat);
            Label supp=new Label("|Retirer");

            container_mod.add(moins).add(qte).add(plus);
            container_mod.setUIID("MarginTotal");
            container_sup.add(sup).add(supp);
            container_sup.setUIID("MarginImage");
            container_4.add(container_sup).add(container_mod);
            
           
            SpanLabel des=new SpanLabel();
            des.setText(pan.get(i).getDesignation());
            Label prix=new Label(String.valueOf(pan.get(i).getQte()+"X"
                    +String.valueOf(pan.get(i).getPrix())));
            
            container_3.add(des).add(prix);
            
            placeHolder = EncodedImage.createFromImage(resourceObjectInstance.getImage("panier.png"), false);
            String url="http://localhost:82/Minipo/Minipo/web/assetsC/img/products/"+pan.get(i).getPhoto();
            Image img1 = URLImage.createToStorage(placeHolder, url, url, URLImage.RESIZE_SCALE);
            ImageViewer mm=new ImageViewer(img1);
            mm.setUIID("MarginImage");
            mm.setPreferredSize(new Dimension(400,400));
            
            container_1.add(mm).add(container_3);

            container_2.add(container_1).add(container_4);
            
           panc.add(container_2);*/
            
           int idLc=pan.get(i).getIdLc();
            
           sup.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                   
                 if( ServiceLigneCommande.getInstance().deleteLc(idLc)){
                            new PanierForm().show();
                            Dialog.show("Success","Suppression avec success",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error",new Command("OK"));
                            
                }
            });
            
            int qt=pan.get(i).getQte();
            
            plus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    int k=0;
                    int quantite=Integer.parseInt(qte.getText());
                    if(qt==quantite){
                        k=qt+1;
                    }
                    else
                    {
                        k=qt+quantite;
                    }
                    
                    
                   
                    if( ServiceLigneCommande.getInstance().updateLc(idLc,k)){
                            new PanierForm().show();
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                }
            });
            
            moins.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    int k=0;
                    int quantite=Integer.parseInt(qte.getText());
                    if(qt==quantite){
                        k=qt-1;
                    }
                    else
                    {
                        k=qt-quantite;
                    }
                  
                    if( ServiceLigneCommande.getInstance().updateLc(idLc,k)){
                            new PanierForm().show();
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                }
            });
          
        }
        Container entetec=new Container(BoxLayout.x());
        entetec.setUIID("DesignEnTete");
        Label back=new Label();
        FontImage iconB = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, "Back", 4.9f);
        back.setIcon(iconB);
        Label title=new Label("Panier");
        entetec.add(back).add(title);
        
        back.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                PanierForm.backForm.show();
            }
           });
        
        Container totalc=new Container(BoxLayout.x());
        totalc.setUIID("LayaoutBoxY");
        Label img2=new Label("Total:"
           + "                       ");
        img2.setUIID("MarginImage");
        Label tot=new Label(String.valueOf(pan.get(0).getTotal()));
        tot.setUIID("MarginTotal");
        //table.add(img2).add(l2).add(q2).add(tot);
        totalc.add(img2).add(tot);
        
        Button val=new Button("Valider");
        val.setPreferredSize(new Dimension(50,110));
        Style btnStyle = val.getAllStyles();
        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        btnStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStroke));
        
        globc.add(entetec).add(panc).add(totalc).add(val);
        addComponent(globc);
        
        int idcmd=pan.get(0).getIdcmd();
        String refcmd=pan.get(0).getRefc();
        val.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             
                new CheckoutForm(resourceObjectInstance,idcmd,refcmd).show();

            }
        });
        
       
      
        }   
    }
    
    public Form getBackForm() {
        return backForm;
    }

    public void setF(Form backForm) {
        this.backForm = backForm;
    }
    
}
