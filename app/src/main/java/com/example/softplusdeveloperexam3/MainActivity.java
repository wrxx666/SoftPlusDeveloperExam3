package com.example.softplusdeveloperexam3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_ENTRANCE_COUNT = "entranceCount";
    SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast toast = Toast.makeText(getApplicationContext(),
                                "It's a third entrance",
                                        Toast.LENGTH_LONG);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSettings.edit();
        int entranceCount = mSettings.getInt(APP_PREFERENCES_ENTRANCE_COUNT,0);
        editor.apply();
        if (entranceCount == 2){
            toast.show();
        }
        entranceCount++;
        editor.putInt(APP_PREFERENCES_ENTRANCE_COUNT,entranceCount);
        editor.commit();

    }
}