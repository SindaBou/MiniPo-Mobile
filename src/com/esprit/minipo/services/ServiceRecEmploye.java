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
import com.esprit.minipo.entites.ReclamationsEmploye;
import com.esprit.minipo.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceRecEmploye {

    public ArrayList<ReclamationsEmploye> tasks;
    
    public static ServiceRecEmploye instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceRecEmploye() {
         req = new ConnectionRequest();
    }

    public static ServiceRecEmploye getInstance() {
        if (instance == null) {
            instance = new ServiceRecEmploye();
        }
        return instance;
    }
    
    
    
  public ArrayList<ReclamationsEmploye> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
               // Task t = new Task();
                ReclamationsEmploye c= new ReclamationsEmploye();
                
                /*float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
                t.setName(obj.get("name").toString());*/
                
                float idremp = Float.parseFloat(obj.get("idremp").toString());
                c.setIdRemp((int)idremp);
                float id = Float.parseFloat(obj.get("id").toString());
                c.setId((int)id);
                float idcatrecemp = Float.parseFloat(obj.get("idcatrecemp").toString());
                c.setIdcatrecemp((int)idcatrecemp);
                c.setNom(obj.get("nom").toString());
                c.setObjet(obj.get("objet").toString());
                c.setDescription(obj.get("description").toString());
                c.setReponse(obj.get("reponse").toString());
                c.setEtatRemp(obj.get("etatremp").toString());
                c.setImage(obj.get("image").toString());
                
                tasks.add(c);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
   public boolean addRec(ReclamationsEmploye r ) {
        String url = Statics.BASE_URL + "recemp?idcatrecemp=" + r.getIdcatrecemp() + "&objet=" + r.getObjet()+ "&description=" + r.getDescription() + "&id=" + r.getId();
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
   public boolean ModifierRecEmploye(int idremp, String description ) {
        String url = Statics.BASE_URL + "recupdateemp/"+idremp+"?description=" + description ;
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
  
  public ArrayList<ReclamationsEmploye> getAllRecEmploye(int id){
        String url = Statics.BASE_URL+"recemp/all/"+id;
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
