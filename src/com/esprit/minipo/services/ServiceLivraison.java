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
import com.esprit.minipo.entites.Livraison;
import com.esprit.minipo.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceLivraison {

    public ArrayList<Livraison> livraisons;
    public Livraison livraisonDetail;

    public static ServiceLivraison instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceLivraison() {
        req = new ConnectionRequest();
    }

    public static ServiceLivraison getInstance() {
        if (instance == null) {
            instance = new ServiceLivraison();
        }
        return instance;
    }

    public ArrayList<Livraison> parseLivraisons(String jsonText) {
        try {
            livraisons = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                // Task t = new Task();
                Livraison liv = new Livraison();

                /*float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
                t.setName(obj.get("name").toString());*/
                liv.setIdliv((int) Float.parseFloat(obj.get("idliv").toString()));
                liv.setDestination(obj.get("destination").toString());
                liv.setDateliv(obj.get("dateliv").toString());
                liv.setMatriculeL(obj.get("matriculel").toString());
                liv.setEtatl(obj.get("etatl").toString());

                livraisons.add(liv);
            }

        } catch (IOException ex) {

        }
        return livraisons;
    }

    public ArrayList<Livraison> getListLivraison() {
        String url = Statics.BASE_URL + "/api/livraison";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                livraisons = parseLivraisons(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(livraisons);
        return livraisons;
    }

    public Livraison getLivraison(int id) {
        String url = Statics.BASE_URL + "/api/livraison/detail";
        req.addArgument("id", "" + id);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                livraisonDetail = parseLivraisons(new String(req.getResponseData())).get(0);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(livraisonDetail);
        return livraisonDetail;
    }

    public void updateEtat(int id, String etat) {
        String url = Statics.BASE_URL + "/api/livraison/etat";
        req.setUrl(url);
        req.removeAllArguments();
        req.setRequestBody("{\n"
                + "	\"etatl\": \"" + etat + "\",\n"
                + "	\"id\": " + id + "\n"
                + "}");
        req.setPost(true);
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
}
