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
import com.esprit.minipo.entites.Employe;
import com.esprit.minipo.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hafed
 */
public class ServiceEmploye {
    public ArrayList<Employe> tasks;
    
    public static ServiceEmploye instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceEmploye() {
         req = new ConnectionRequest();
    }

    public static ServiceEmploye getInstance() {
        if (instance == null) {
            instance = new ServiceEmploye();
        }
        return instance;
    }
    
    public boolean addEmploye(Employe e) {
        String url = Statics.BASE_URL + "/ajoutEmp?nom="+ e.getNom() + "&prenom=" + e.getPrenom()+ "&adresse=" + e.getAdresse()+ "&email=" + e.getEmail()+ "&tel=" + e.getTel()+ "&salaire=" + e.getSalaire();
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
    public boolean updateEmploye(int id, String nomemp , String prenomemp , String adresseemp , String adresse ,String email , String tel , String salaire) {
        String url = Statics.BASE_URL + "/updateEmp/" + id + "?nom="+ nomemp + "&prenom=" + prenomemp + "&adresse=" + adresseemp + "&email=" + email + "&tel=" + tel + "&salaire=" + salaire ;
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
    public boolean deleteEmploye(int id) {
        String url = Statics.BASE_URL + "/DeleteEmp/" + id  ;
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
    
    
    
  public ArrayList<Employe> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
               // Task t = new Task();
                Employe e= new Employe();
                
                /*float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
                t.setName(obj.get("name").toString());*/
                
                float id = Float.parseFloat(obj.get("id").toString());
                e.setIdemp((int)id);
                e.setNom(obj.get("lastname").toString());
                e.setPrenom(obj.get("firstname").toString());
                e.setAdresse(obj.get("adresse").toString());
                e.setTel(obj.get("tel").toString());
                e.setEmail(obj.get("email").toString());
                e.setSalaire(obj.get("salaire").toString());
                //e.setDate((Date) obj.get("date"));
                
                tasks.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
  
  
  
  public ArrayList<Employe> getEmpID(int id){
        String url = Statics.BASE_URL+"/Emp/EmpId/"+id+"";
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
  
  public ArrayList<Employe> getAllEmp(){
        String url = Statics.BASE_URL+"/Emp/allEmp";
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
