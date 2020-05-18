/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.ui.Form;

/**
 *
 * @author hafed
 */
public class Barchartform extends Form{
    public Barchartform(){
       
     add(new SalesBarChart().execute());
    }
}
