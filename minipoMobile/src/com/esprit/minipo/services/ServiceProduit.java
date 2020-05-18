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
import com.esprit.minipo.entites.Panier;
import com.esprit.minipo.entites.Produit;
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
public class ServiceProduit {

    public ArrayList<Produit> tasks;
    
    public static ServiceProduit instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceProduit() {
         req = new ConnectionRequest();
    }

    public static ServiceProduit getInstance() {
        if (instance == null) {
            instance = new ServiceProduit();
        }
        return instance;
    }
    
    
    
  public ArrayList<Produit> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<Produit>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                
                Produit p =new Produit();
                
                float idprod = Float.parseFloat(obj.get("idprod").toString());
                p.setIdprod((int)idprod);
                p.setPhoto(obj.get("photo").toString());
                p.setDesignation(obj.get("designation").toString());
                float prix = Float.parseFloat(obj.get("prix").toString());
                p.setPrix((int)prix);
                float qte = Float.parseFloat(obj.get("qtestock").toString());
                p.setQtestock((int)qte);
                p.setDescription(obj.get("description").toString());
                p.setNomc(obj.get("nom").toString());
                tasks.add(p);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
  
  public ArrayList<Produit> getAllProds(){
       
        String url = Statics.BASE_URL+"/mobile/client/allprod";
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
