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
import com.codename1.ui.validation.Constraint;
import com.esprit.minipo.entites.CategorieReclamation;
import com.esprit.minipo.entites.CategorieReclamationEmp;
import com.esprit.minipo.entites.Commande;
import com.esprit.minipo.entites.ReclamationClient;
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
public class ServiceRecCategEmploye {

    public ArrayList<CategorieReclamationEmp> tasks;
    
    public static ServiceRecCategEmploye instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    private int length;
    private String errorMessage;

    private ServiceRecCategEmploye() {
         req = new ConnectionRequest();
    }

    public static ServiceRecCategEmploye getInstance() {
        if (instance == null) {
            instance = new ServiceRecCategEmploye();
        }
        return instance;
    }
    
    
    
  public ArrayList<CategorieReclamationEmp> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
               // Task t = new Task();
                CategorieReclamationEmp c= new CategorieReclamationEmp();
                
                /*float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
                t.setName(obj.get("name").toString());*/
                
               
                
                c.setNom(obj.get("nom").toString());
                
                tasks.add(c);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
  
  
  
  public ArrayList<CategorieReclamationEmp> getAllCategorieClient(){
        CategorieReclamationEmp r=new CategorieReclamationEmp();
         //id=45;
        String url = Statics.BASE_URL+"/recCategorieEmploye";
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
