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
import com.esprit.minipo.entites.Usere;
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
     public ArrayList<Usere> User;
    public Usere client;
    
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
    
    
    public ArrayList<Articles> parseBlog(String jsonText){
        try {
             tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                
                Articles t = new Articles();
                float ida = Float.parseFloat(obj.get("ida").toString());
                t.setIdA((int)ida);
                t.setTitre(obj.get("titre").toString());
                t.setImagename(obj.get("imageName").toString());
                t.setDescription(obj.get("description").toString());
              //System.out.println(obj.get("description").toString());
                System.out.println(t);
                tasks.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
    
    public ArrayList<Articles> getAllBlog(){
        String url = Statics.BASE_URL+"/mobile/ListBlogClient";
        req.setUrl(url);
            System.out.println(req.getUrl());
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                tasks = parseBlog(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
   
    
}
