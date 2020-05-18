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

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import static com.esprit.minipo.MyApplication.theme;
import com.esprit.minipo.entites.Conge;
import static com.esprit.minipo.gui.BaseForm.url;
import com.esprit.minipo.services.ServiceConge;
import java.util.ArrayList;

/**
 * Utility methods common to forms e.g. for binding the side menu
 *
 * @author Shai Almog
 */
public class BaseEmployeForm1 extends Form {
   
   public static String url;
   public static String nameuser;
   public EncodedImage img= EncodedImage.createFromImage(theme.getImage("user.jpg"), false);
   
   
    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        BaseEmployeForm1.url = url;
    }

    public static String getNameuser() {
        return nameuser;
    }

    public static void setNameuser(String nameuser) {
        BaseEmployeForm1.nameuser = nameuser;
    }

    public EncodedImage getImg() {
        return img;
    }

    public void setImg(EncodedImage img) {
        this.img = img;
    }
    
    public void installSidemenu(Resources res) {
        Image selection = res.getImage("selection-in-sidemenu.png");
        
        Image inboxImage = null;
        if(isCurrentInbox()) inboxImage = selection;

        Image trendingImage = null;
        if(isCurrentTrending()) trendingImage = selection;
        
        Image calendarImage = null;
        if(isCurrentCalendar()) calendarImage = selection;
        
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        int id = SignInForm.idUser;
        ArrayList<Conge> emp=new ArrayList<Conge>();
        emp=ServiceConge.getInstance().getEmpConge(id);
        
        Button inboxButton = new Button("Demande Conge", inboxImage);
        inboxButton.setUIID("SideCommand");
        inboxButton.getAllStyles().setPaddingBottom(0);
        Container inbox = FlowLayout.encloseMiddle(inboxButton, 
                new Label(String.valueOf(emp.size()), "SideCommandNumber"));
        inbox.setLeadComponent(inboxButton);
        inbox.setUIID("SideCommand");
        inboxButton.addActionListener(e -> new EmployeRhForm(res).show());
        getToolbar().addComponentToSideMenu(inbox);
        
        //getToolbar().addCommandToSideMenu("Stats", statsImage, e -> new StatsForm(res).show());
        //getToolbar().addCommandToSideMenu("Calendar", calendarImage, e -> new CalendarForm(res).show());
        //getToolbar().addCommandToSideMenu("Gestion produit", null, e -> {});
        //getToolbar().addCommandToSideMenu("Gestion Categorie", null, e -> {});
        //getToolbar().addCommandToSideMenu("Gestion fournisseur", null, e -> {});
//        getToolbar().addCommandToSideMenu("Demande ", null, e -> {});
        //getToolbar().addCommandToSideMenu("Demande Conge", null, e -> {new EmployeRhForm(res).show();});
        getToolbar().addCommandToSideMenu("Reclamation",null, e -> {new AjoutRecEmpForm(res,this).show();});
        getToolbar().addCommandToSideMenu("Mes Reclamation",null, e -> {new MesRecEmpForm(res,this).show();});
        //getToolbar().addCommandToSideMenu("Blog", null, e -> {});
        
        // spacer
        System.out.println("image= "+this.img);
        System.out.println("username= "+this.nameuser);
        System.out.println("url= "+this.url);
        
        Image imageuser= URLImage.createToStorage(img,url,url,URLImage.RESIZE_SCALE);
        getToolbar().addComponentToSideMenu(new Label(imageuser, "SideCommand"));
       
        getToolbar().addComponentToSideMenu(new Label(this.nameuser, "SideCommandNoPad"));
       
        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
     
    }

        
    protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentTrending() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
}
