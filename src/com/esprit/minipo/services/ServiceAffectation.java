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
import com.esprit.minipo.entites.Affectation;
import com.esprit.minipo.entites.Equipe;
import static com.esprit.minipo.services.ServiceEquipe.instance;
import com.esprit.minipo.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hafed
 */
public class ServiceAffectation {
    public ArrayList<Affectation> tasks;
    
    public static ServiceAffectation instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceAffectation() {
         req = new ConnectionRequest();
    }

    public static ServiceAffectation getInstance() {
        if (instance == null) {
            instance = new ServiceAffectation();
        }
        return instance;
    }
    
    public boolean addAff(Affectation e) {
        String url = Statics.BASE_URL + "/affEquipe?nom="+ e.getNom()+ "&equipe=" + e.getNomEq();
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
    public ArrayList<Affectation> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
               // Task t = new Task();
                Affectation e= new Affectation();
                
                /*float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
                t.setName(obj.get("name").toString());*/
                
                float id = Float.parseFloat(obj.get("idaffect").toString());
                
                e.setIdaff((int)id);
                e.setNom(obj.get("nom").toString());
                e.setNomEq(obj.get("nomeq").toString());
               
                
                tasks.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
  
  public ArrayList<Affectation> getAllAff(){
        String url = Statics.BASE_URL+"/Aff/allaff";
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
