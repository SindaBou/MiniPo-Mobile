/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.services;

import com.esprit.minipo.utils.Statics;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.minipo.entites.ProduitClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yacin
 */
public class ServiceProduitClient {
    
      public ArrayList<ProduitClient> Produits;
    
    public static ServiceProduitClient instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceProduitClient() {
         req = new ConnectionRequest();
    }

    public static ServiceProduitClient getInstance() {
        if (instance == null) {
            instance = new ServiceProduitClient();
        }
        return instance;
    }

  
    public ArrayList<ProduitClient> parseTasks(String jsonText){
        try {
            Produits=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                ProduitClient Pt = new ProduitClient();
                float id = Float.parseFloat(obj.get("idprod").toString());
                Pt.setId((int)id);
                Pt.setCategorie(obj.get("nom").toString());
                Pt.setDescription(obj.get("description").toString());
                Pt.setDesignation(obj.get("designation").toString());
                Pt.setPhoto(obj.get("photo").toString());
                float qu = Float.parseFloat(obj.get("qtestock").toString());
                float px = Float.parseFloat(obj.get("prix").toString());
                Pt.setPrix((int)px);
                Pt.setQtestock((int)qu);
              //  t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
               // t.setName(obj.get("name").toString());
                Produits.add(Pt);
            }
            
            
        } catch (IOException ex) {
            
        }
        return Produits;
    }
    
    public ArrayList<ProduitClient> getAllProducts(){
        String url = Statics.BASE_URL+"/afficheProduitmobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Produits = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Produits;
    }
}
