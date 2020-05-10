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
import com.esprit.minipo.entites.Conge;
import com.esprit.minipo.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hafed
 */
public class ServiceConge {
    public ArrayList<Conge> tasks;
    
    public static ServiceConge instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceConge() {
         req = new ConnectionRequest();
    }

    public static ServiceConge getInstance() {
        if (instance == null) {
            instance = new ServiceConge();
        }
        return instance;
    }
    
    
    public ArrayList<Conge> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
               // Task t = new Task();
                Conge e= new Conge();
                
                /*float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
                t.setName(obj.get("name").toString());*/
                
                float id = Float.parseFloat(obj.get("idcon").toString());
                float nb = Float.parseFloat(obj.get("nbrjrs").toString());
                
                e.setIdcon((int)id);
                e.setType(obj.get("type").toString());
                e.setDatedebut(obj.get("datedebut").toString());
                e.setDatefin(obj.get("datefin").toString());
                e.setDerscription(obj.get("description").toString());
                e.setFirstname(obj.get("firstname").toString());
                e.setLastname(obj.get("lastname").toString());
                e.setEtatc((String) obj.get("etat"));
                e.setNbrjrs((int)nb);
               
                
                tasks.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
    public boolean addConge(Conge e) {
        int id = 44;
        String url = Statics.BASE_URL + "/ajoutConge?type="+ e.getType()+ "&date_debut=" + e.getDatedebut()+ "&date_fin=" + e.getDatefin()+ "&nbrjrs=" + e.getNbrjrs()+ "&info_comp="+e.getDescription()+ "&id="+id ;
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
  
  public ArrayList<Conge> getAllConge(){
        String url = Statics.BASE_URL+"/con/conge";
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
        
        return tasks;
    }
  public ArrayList<Conge> getEmpConge(int id){
        String url = Statics.BASE_URL+"/Emp/EmpConge/"+id;
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
        
        return tasks;
    }
      public boolean AccepterConge(int id) {
        String url = Statics.BASE_URL + "/Accepterconge/" + id  ;
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
