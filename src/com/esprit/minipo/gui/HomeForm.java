/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form{
Form current;
    public HomeForm() {
        current=this;
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAddTask = new Button("Add Task");
        Button btnListTasks = new Button("List Tasks");
        
        //btnAddTask.addActionListener(e-> new AddTaskForm(current).show());
        //btnListTasks.addActionListener(e-> new ListTasksForm(current).show());
        //btnListTasks.addActionListener(e-> new ListCmdForm(current).show());
        addAll(btnAddTask,btnListTasks);
        
        Dialog.show("sssssss","ccccccccccccccccc", "ok","Cancel");
        
        
        
    }
    
    
}
