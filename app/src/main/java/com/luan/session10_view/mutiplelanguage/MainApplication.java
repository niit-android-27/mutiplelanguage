package com.luan.session10_view.mutiplelanguage;

import android.app.Application;
import android.content.res.Configuration;

import java.util.Locale;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Locale locale = new Locale("vi");
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        //configuration.locale(locale);
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
    }
}
