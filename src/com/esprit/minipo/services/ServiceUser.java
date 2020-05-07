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
public class ServiceUser {
               
    public ArrayList<User> User;
    public User client;
    public static ServiceUser instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceUser() {
         req = new ConnectionRequest();
    }

    public static ServiceUser getInstance() {
        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
    } 


    
    public boolean addUser(User u){
        
        String url = Statics.BASE_URL + "/user/adduserJson?username=" + u.getUsername() + "&email=" + u.getEmail() + "&password=" +u.getPassword()+ "&tel" + u.getTel() +"&adresse=" +u.getAdresse()+ "&firstname=" + u.getFirstname()+ "&lastname=" + u.getLastname();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>()
        {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);            }
            
        }
        ); 
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    public ArrayList<User> parseUser(String jsonText){
        try {
            User =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                User t = new User();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
               // t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
               // t.setName(obj.get("name").toString());
               t.setUsername(obj.get("username").toString());
               
               t.setPassword(obj.get("password").toString());
               t.setRoles(obj.get("roles").toString());
                User.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return User;
    }
    
    public ArrayList<User> getAllUsers(){
        String url = Statics.BASE_URL+"/user/userJson";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                User = parseUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return User;
    }

     public User parseProfilUser(String jsonText){
        try {
            client =new User();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                User clt = new User();
                float id = Float.parseFloat(obj.get("id").toString());
                clt.setId((int)id);
               // t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
               // t.setName(obj.get("name").toString());
               client.setFirstname(obj.get("firstname").toString());
               //System.out.println(obj.get("firstname"));
               client.setLastname(obj.get("lastname").toString());
               client.setEmail(obj.get("email").toString());
               client.setTel(obj.get("tel").toString());
               client.setAdresse(obj.get("adresse").toString());
               client.setUsername(obj.get("username").toString());
               client.setPassword(obj.get("password").toString());
            // clt.setUsername(obj.get("username").toString());
               
               
             //  clt.setPassword(obj.get("password").toString());
              // clt.setRoles(obj.get("roles").toString());
               
            }
            
            
        } catch (IOException ex) {
            
        }
        return client;
    }
     
    public User getUserProfil(){
        int idUser = SignInForm.idUser;
        String url = Statics.BASE_URL+"/user/ShowUserProfil/"+idUser;
        req.setUrl(url);
        req.setPost(false);
         req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                client = parseProfilUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return client;
    }
    
   public boolean UpdateUser(User u){
        int idUser = SignInForm.idUser;
        String url = Statics.BASE_URL + "/user/updateuserJson/" +idUser+ "?username=" + u.getUsername() + "&email=" + u.getEmail() + "&password=" +u.getPassword()+ "&tel" + u.getTel() +"&adresse=" +u.getAdresse()+ "&firstname=" + u.getFirstname()+ "&lastname=" + u.getLastname();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>()
        {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);            }
            
        }
        ); 
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }


  
   
    
   
    
    
    
}
