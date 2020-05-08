/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.minipo.entites.Articles;
import com.esprit.minipo.entites.User;
import com.esprit.minipo.gui.SignInForm;
import com.esprit.minipo.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class ServiceBlog {
    public ArrayList<Articles> tasks;
     public ArrayList<User> User;
    public User client;
    
    public static ServiceBlog instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
    public static ServiceBlog getInstance() {
        if (instance == null) {
            instance = new ServiceBlog();
        }
        return instance;
    }
     public ServiceBlog() {
        req = new ConnectionRequest();
    }
    
    
    
   
    
}
