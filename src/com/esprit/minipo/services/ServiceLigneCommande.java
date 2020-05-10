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
import com.esprit.minipo.entites.AboutCmd;
import com.esprit.minipo.entites.Commande;
import com.esprit.minipo.entites.LigneCommande;
import com.esprit.minipo.entites.Panier;
import com.esprit.minipo.entites.User;
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
public class ServiceLigneCommande {

    public ArrayList<Panier> tasks;
    
    public ArrayList<AboutCmd> cmd;
    
    public static ServiceLigneCommande instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceLigneCommande() {
         req = new ConnectionRequest();
    }

    public static ServiceLigneCommande getInstance() {
        if (instance == null) {
            instance = new ServiceLigneCommande();
        }
        return instance;
    }
    
    
    
  public ArrayList<Panier> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<Panier>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
               // Task t = new Task();
                Panier pan=new Panier();
                
                float idlc = Float.parseFloat(obj.get("idlc").toString());
                pan.setIdLc((int)idlc);
                
                pan.setPhoto(obj.get("photo").toString());
                
                pan.setDesignation(obj.get("designation").toString());
                
                float prix = Float.parseFloat(obj.get("prix").toString());
                pan.setPrix(prix);
                
                float qte = Float.parseFloat(obj.get("qte").toString());
                pan.setQte((int)qte);
                
                pan.setSubtotal(Float.parseFloat(obj.get("subtotal").toString()));
                
                pan.setTotal(Float.parseFloat(obj.get("total").toString()));
                
                float idcmd = Float.parseFloat(obj.get("idcmd").toString());
                pan.setIdcmd((int)idcmd);
                
                tasks.add(pan);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
  
  public ArrayList<Panier> getMonPanier(){
        
        int idUser=45;
        
        String url = Statics.BASE_URL+"/mobile/client/MonPanier/"+idUser;
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
  
  
  public boolean addLc(int idProd, int qted) {
        
        int id=45;
        
        String url = Statics.BASE_URL + "/mobile/client/createLC/" +
                 idProd + "/" +
                id + "/" +
                qted ;
        
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


  public ArrayList<AboutCmd> parseCmds(String jsonText){
        try {
            cmd=new ArrayList<AboutCmd>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
               // Task t = new Task();
                AboutCmd pan=new AboutCmd();
                
                float idlc = Float.parseFloat(obj.get("idlc").toString());
                pan.setIdLc((int)idlc);
                pan.setPhoto(obj.get("photo").toString());
                pan.setDesignation(obj.get("designation").toString());
                float prix = Float.parseFloat(obj.get("prix").toString());
                pan.setPrix(prix);
                float qte = Float.parseFloat(obj.get("qte").toString());
                pan.setQte((int)qte);
                pan.setSubtotal(Float.parseFloat(obj.get("subtotal").toString()));
                pan.setTotal(Float.parseFloat(obj.get("total").toString()));
                float idcmd = Float.parseFloat(obj.get("idcmd").toString());
                pan.setIdLc((int)idcmd);
                pan.setRefc(obj.get("refc").toString());
                pan.setEtatc(obj.get("etatc").toString());
                
                String pattern = "dd/MM/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date((((Double)((Map<String, Object>)obj.get("datec")).get("timestamp")).longValue()*1000)));
                
                pan.setDatec(date);
                System.out.println();
                cmd.add(pan);
            }
            
            
        } catch (IOException ex) {
            
        }
        return cmd;
    }
  
  public ArrayList<AboutCmd> aboutCmd(int idcmd){
        
        //int idUser=45;
        
        String url = Statics.BASE_URL+"/mobile/client/aboutCmd/"+idcmd;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cmd = parseCmds(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(cmd);
        return cmd;
    }
  
public boolean deleteLc(int idLc) {
        
        int id=45;
        
        String url = Statics.BASE_URL + "/mobile/client/deleteLC/" +
                 idLc + "/" +
                id ;
        
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

/* public boolean updateLc(int idLc,int qted) {
        
        int id=45;
        
        String url = Statics.BASE_URL + "/mobile/client/updateLC/" +
                idLc + "/" +
                id +"/" +
                qted ;
        
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
    }*/
  
  
  
  
}
