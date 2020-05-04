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
import com.esprit.minipo.entites.Commande;
import com.esprit.minipo.gui.SignInForm;
import com.esprit.minipo.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceCommande {

    public ArrayList<Commande> tasks;
    
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
    
    
    
  public ArrayList<Commande> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
               // Task t = new Task();
                Commande c= new Commande();
                
               float idcmd = Float.parseFloat(obj.get("idcmd").toString());
                c.setIdcmd((int)idcmd);
                
                c.setRefC(obj.get("refc").toString());
                
                c.setTotal(Float.parseFloat(obj.get("total").toString()));
                
                c.setEtatcmd(obj.get("etatc").toString());
                
                float id = Float.parseFloat(obj.get("id").toString());
                c.setIdcmd((int)id);
                
               
                
                tasks.add(c);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
  
  public ArrayList<Commande> getAllCmd(){
       int idUser = SignInForm.idUser;
        
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
}
