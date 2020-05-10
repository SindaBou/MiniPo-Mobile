/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
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
public class PanierForm11 extends BaseForm{
    
    private EncodedImage placeHolder;
    
    private ArrayList<Panier> pan=new ArrayList<Panier>();
    
    public PanierForm11() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
     
    
    Form current;

    public PanierForm11(com.codename1.ui.util.Resources resourceObjectInstance) {
    
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
             Container container_cc=new Container(new FlowLayout(CENTER,CENTER));
             ImageViewer panier = new ImageViewer(resourceObjectInstance.getImage("logout.png"));
             Label lab=new Label("Panier vide");
             container_c.add(panier).add(lab);
             container_cc.add(container_c);
             addComponent(container_cc);
             
        }
        else{
        
        Label l=new Label("Produit");
        //Label p=new Label("Prix");
        Label q=new Label("Qte");
        //Label t=new Label("Subtotal");
        Label act=new Label("Action");
        //Contena
        Container table=new Container(new TableLayout(pan.size()+2,3));
       // table.add(l).add(q).add(t).add(act);
       table.add(l).add(q).add(act);
        
        for(int i=0;i<pan.size();i++){
            Container container_1=new Container(BoxLayout.x());
            Container container_2=new Container(BoxLayout.y());
            
            placeHolder = EncodedImage.createFromImage(resourceObjectInstance.getImage("panier.png"), false);
            String url="http://localhost:82/Minipo/Minipo/web/assetsC/img/products/"+pan.get(i).getPhoto();
            Image img1 = URLImage.createToStorage(placeHolder, url, url, URLImage.RESIZE_SCALE);
            SpanLabel des=new SpanLabel(pan.get(i).getDesignation());
            Label prix=new Label(String.valueOf(pan.get(i).getQte()+"X"
                    +String.valueOf(pan.get(i).getPrix())));
            
            container_2.add(des).add(prix);
            container_1.add(img1).add(container_2);
            
            TextField qte=new TextField(String.valueOf(pan.get(i).getQte()));
            qte.setColumns(3);
            qte.setHeight(5);
            //Label sub=new Label(String.valueOf(pan.get(i).getSubtotal()));
            Container cont=new Container(new FlowLayout());
            //Container cont=new Container(BoxLayout.x());
            FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_DELETE_OUTLINE, "Supprimer", 4.9f);
            FontImage m = FontImage.createMaterial(FontImage.MATERIAL_EDIT, "Modifier", 4.9f);
            //Button sup=new Button(mat);
            //Button mod=new Button("+");
            Label sup=new Label(mat);
            Label mod=new Label(m);
           //ImageViewer s=new ImageViewer(resourceObjectInstance.getImage("trash_24px.png"));
           cont.add(sup).add(mod);
            //table.add(img1).add(des).add(prix).add(qte).add(sub);
            //table.add(container_1).add(qte).add(sub).add(cont);
            table.add(container_1).add(qte).add(cont);
            int idLc=pan.get(i).getIdLc();
            
           /* sup.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                   
                 if( ServiceLigneCommande.getInstance().deleteLc(idLc)){
                            new PanierForm11().show();
                            Dialog.show("Success","Suppression avec success",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                }
            });
            
            mod.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    int quantite=Integer.parseInt(qte.getText());
                    if( ServiceLigneCommande.getInstance().updateLc(idLc,quantite)){
                            new PanierForm11().show();
                            Dialog.show("Success","modification avec success",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                }
            });
            
            
           /* mod.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    int quantite=Integer.parseInt(qte.getText());
                    if( ServiceLigneCommande.getInstance().updateLc(idLc,quantite)){
                            new PanierForm().show();
                            Dialog.show("Success","modification avec success",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                }
            });
            
            sup.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                        if( ServiceLigneCommande.getInstance().deleteLc(idLc)){
                            new PanierForm().show();
                            Dialog.show("Success","Suppression avec success",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));

                }
            });*/
        }
        Label img2=new Label("Total:");
        //Label l2=new Label(" ");
        //Label p2=new Label(" ");
        Label q2=new Label(" ");
        Label tot=new Label(String.valueOf(pan.get(0).getTotal()));
        //table.add(img2).add(l2).add(q2).add(tot);
        table.add(img2).add(q2).add(tot);
        Container container_3=new Container(new FlowLayout(CENTER));
        Button val=new Button("Valider");
        container_3.add(val);
        addComponent(table);
        addComponent(container_3);
        int idcmd=pan.get(0).getIdcmd();
        val.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             
                new CheckoutForm(resourceObjectInstance,idcmd).show();
            
            }
        });
      
        }   
    }
    
    
}
