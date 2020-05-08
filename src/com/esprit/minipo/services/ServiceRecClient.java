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
import com.esprit.minipo.entites.Commande;
import com.esprit.minipo.entites.ReclamationClient;
import com.esprit.minipo.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author bhk
 */
public class ServiceRecClient implements Constraint {

    public ArrayList<ReclamationClient> tasks;
    
    public static ServiceRecClient instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    private int length;
    private String errorMessage;

    private ServiceRecClient() {
         req = new ConnectionRequest();
    }

    public static ServiceRecClient getInstance() {
        if (instance == null) {
            instance = new ServiceRecClient();
        }
        return instance;
    }
    
    
    
  public ArrayList<ReclamationClient> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
               // Task t = new Task();
                ReclamationClient c= new ReclamationClient();
                
                /*float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
                t.setName(obj.get("name").toString());*/
                
                float idr = Float.parseFloat(obj.get("idr").toString());
                c.setIdR((int)idr);
                float id = Float.parseFloat(obj.get("id").toString());
                c.setId((int)id);
                float idcatrec = Float.parseFloat(obj.get("idcatrec").toString());
                c.setIdcatrec((int)idcatrec);
                c.setNom(obj.get("nom").toString());
                c.setObjet(obj.get("objet").toString());
                c.setDescription(obj.get("description").toString());
                c.setReponse(obj.get("reponse").toString());
                c.setEtatr(obj.get("etatr").toString());
                c.setImage(obj.get("image").toString());
                
                tasks.add(c);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
   public boolean addRec(ReclamationClient r ) {
        String url = Statics.BASE_URL + "rec?idcatrec=" + r.getIdcatrec() + "&objet=" + r.getObjet()+ "&description=" + r.getDescription() + "&id=" + r.getId()+"&image="+r.getImage();
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
   public boolean ModifierRec(int idr, String description ) {
        String url = Statics.BASE_URL + "recupdate/"+idr+"?description=" + description ;
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
  
  public ArrayList<ReclamationClient> getAllRecClient(int id){
        ReclamationClient r=new ReclamationClient();
         //id=45;
        String url = Statics.BASE_URL+"rec/all/"+id;
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
  public ArrayList<ReclamationClient> getRecClientBYidr(int idr){
        ReclamationClient r=new ReclamationClient();
         //id=45;
        String url = Statics.BASE_URL+"rec/all/"+idr;
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

    public ServiceRecClient(int length, String errorMessage) {
        this.length = length;
        this.errorMessage = errorMessage;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    @Override
    public boolean isValid(Object value) {
        return value != null && value.toString().length() <= length;
    }

    @Override
    public String getDefaultFailMessage() {
         if(errorMessage == null) {
            if(length == 1) {
                return "A value is required"; 
            }
            return "Input must be at least " + length + " characters";
        }
        return errorMessage;
    }
}
