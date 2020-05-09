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
import com.esprit.minipo.entites.Facture;
import com.esprit.minipo.entites.ListeFact;
import com.esprit.minipo.entites.User;
import com.esprit.minipo.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceFacture {

    public ArrayList<ListeFact> tasks;
    
    public static ServiceFacture instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceFacture() {
         req = new ConnectionRequest();
    }

    public static ServiceFacture getInstance() {
        if (instance == null) {
            instance = new ServiceFacture();
        }
        return instance;
    }
    
    
    
  public ArrayList<ListeFact> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
               // Task t = new Task();
                
               ListeFact f= new ListeFact();

                float idfact = Float.parseFloat(obj.get("idfact").toString());
                f.setIdFact((int)idfact);
                f.setEtatFact(obj.get("etatf").toString());
                float id = Float.parseFloat(obj.get("idcmd").toString());
                f.setIdcmd((int)id);
                f.setRefc(obj.get("refc").toString());
                f.setTotal(Float.parseFloat(obj.get("total").toString()));
                tasks.add(f);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
  
  public ArrayList<ListeFact> getMesFact(){
        
        int idUser=45;
        
        String url = Statics.BASE_URL+"/mobile/client/MesFactures/"+idUser;
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
