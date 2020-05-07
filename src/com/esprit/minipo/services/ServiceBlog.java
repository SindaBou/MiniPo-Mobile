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
import com.esprit.minipo.entites.Blog;
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
    public ArrayList<Blog> blog;
    public Blog blogs;
    public static ServiceBlog instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
    public static ServiceBlog getInstance() {
        if (instance == null) {
            instance = new ServiceBlog();
        }
        return instance;
    }
    
    public ArrayList<Blog> parseBlog(String jsonText){
        try {
           blog=new ArrayList<>();
           blogs = new Blog();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Blog b = new Blog();
                //float id = Float.parseFloat(obj.get("id").toString());
               // b.setId((int)id);
               // t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
                b.setImagename(obj.get("imagename").toString());
                b.setTitre(obj.get("titre").toString());
                b.setDescription(obj.get("description").toString());
                blog.add(b);
            }
            
            
        } catch (IOException ex) {
            
        }
        return blog;
    }
    
    public ArrayList<Blog> getAllBlog(){
        String url = Statics.BASE_URL+"/blog/ListBlogClient";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                blog = parseBlog(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return blog;
    }
    
   
    
}
