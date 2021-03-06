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
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.esprit.minipo.entites.Commandes;
import com.esprit.minipo.entites.User;
import com.esprit.minipo.gui.SignInForm;
import com.esprit.minipo.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceCommande {

    public ArrayList<Commandes> tasks;
    
    public static ServiceCommande instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceCommande() {
         req = new ConnectionRequest();
    }

    public static ServiceCommande getInstance() {
        if (instance == null) {
            instance = new ServiceCommande();
        }
        return instance;
    }
    
    
    
  public ArrayList<Commandes> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
               // Task t = new Task();
                Commandes c= new Commandes();
                //User u=new User();
                //u.setId((int)Float.parseFloat(obj.get("id").toString()));
                
                float idcmd = Float.parseFloat(obj.get("idcmd").toString());
                c.setIdcmd((int)idcmd);
                
                c.setRefC(obj.get("refc").toString());
                
                c.setTotal(Float.parseFloat(obj.get("total").toString()));
                
                c.setEtatcmd(obj.get("etatc").toString());
                
                float id = Float.parseFloat(obj.get("id").toString());
                c.setId((int)id);
                
                c.setNom(obj.get("firstname").toString());
                c.setPrenom(obj.get("lastname").toString());
                
                String pattern = "dd/MM/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date((((Double)((Map<String, Object>)obj.get("datec")).get("timestamp")).longValue()*1000)));                
                c.setDatec(date);
                
                c.setEtatl(obj.get("etatl").toString());
                
                
                tasks.add(c);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
  
  public ArrayList<Commandes> getAllCmd(){
        
        int idUser=SignInForm.idUser;
        
        String url = Statics.BASE_URL+"/mobile/client/MesCommandes/"+idUser;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                tasks = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(tasks);
        return tasks;
    }
  
  public boolean validerCmd (String dest) {
        
        int id=SignInForm.idUser;
        
        String url = Statics.BASE_URL + "/mobile/client/validerCmd/" +
                id + "/" +
                dest ;
        
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
  
  
  public boolean deleteCmd(int idcmd) {
        
        int id=SignInForm.idUser;
        
        String url = Statics.BASE_URL + "/mobile/client/DeleteCommande/" +
                 idcmd +"/"+id;
        
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
  
  
  
  

}
