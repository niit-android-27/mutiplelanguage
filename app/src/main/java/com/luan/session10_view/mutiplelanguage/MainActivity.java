package com.luan.session10_view.mutiplelanguage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Boolean isSetting = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Locale locale = new Locale("ja");
//        Configuration configuration = new Configuration();
//        configuration.setLocale(locale);
//        //configuration.locale(locale);
//        getBaseContext().getResources().
//                updateConfiguration(
//                        configuration,getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_main);
        Button btnSetting = (Button)findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSetting=true;
                Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //neu nguoi dung mo man hinh setting
        if(isSetting==true){
            SharedPreferences prefs= PreferenceManager
                    .getDefaultSharedPreferences(getApplicationContext());
            String languages = prefs.getString("languages", "en");
            Locale locale = new Locale(languages);
            Configuration configuration = new Configuration();
            configuration.setLocale(locale);
        //configuration.locale(locale);
            getBaseContext().getResources().
                updateConfiguration(
                        configuration,getBaseContext().getResources().getDisplayMetrics());
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
    }
}
