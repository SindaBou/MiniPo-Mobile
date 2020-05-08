package com.esprit.minipo;


import com.codename1.background.BackgroundFetch;
import com.esprit.minipo.gui.*;
import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.services.RSSService;
import com.codename1.notifications.LocalNotificationCallback;
import com.codename1.push.Push;
import com.codename1.push.PushAction;
import com.codename1.push.PushActionCategory;
import com.codename1.push.PushActionsProvider;
import com.codename1.push.PushCallback;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.util.Callback;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication implements BackgroundFetch {

    private Form current;
    public static Resources theme;
    private Resources baseEmp;
    List<Map> records;

    public Resources getTheme() {
        return theme;
    }

    public void setTheme(Resources theme) {
        this.theme = theme;
    }
    
    

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);
        
        
        theme = UIManager.initFirstTheme("/theme"); 
        
        // baseEmp = UIManager.initFirstTheme("/theme");
        // theme = UIManager.initFirstTheme("/theme_1");
        
         
         //theme = UIManager.initNamedTheme("/theme_1","Theme");
         //baseEmp = UIManager.initNamedTheme("/theme","baseEmp");
         

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
        Display d = Display.getInstance();
       Hashtable themeData = theme.getTheme("Theme");
       UIManager.getInstance().setThemeProps(themeData);
      
       new SplashForm().show();
       //new AjoutRecForm1().show();
      //new AjoutRecEmpForm().show();
      //new StatsForm(theme).show();
      //new InboxForm(theme).show();
      //new DetailsForm(theme).show(); 
      //new WalkthruForm(theme).show();
      //new TrendingForm(theme).show();
      //new InboxForm(theme).show();
      //new BaseAgentRHForm11().show();
      //new EmployerForm(baseEmp).show();
      //new HomeForm().show();
      //new HomeFormRec().show();
      
     
               
    }
    
    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }

    

    @Override
    public void performBackgroundFetch(long deadline, Callback<Boolean> onComplete) {
 RSSService rss = new RSSService("http://rss.slashdot.org/Slashdot/slashdotMain");
        NetworkManager.getInstance().addToQueueAndWait(rss);
        records = rss.getResults();
        System.out.println(records);
        onComplete.onSucess(Boolean.TRUE);    }


    

}
