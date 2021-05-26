package com.example.softplusdeveloperexam3;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_ENTRANCE_COUNT = "entranceCount";
    private final String LOG_TAG = "devExam3";
    Integer mIncrementedCounter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            Log.d(LOG_TAG, "Cold boot detected");
            SharedPreferences mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
            int entranceCount = mSettings.getInt(APP_PREFERENCES_ENTRANCE_COUNT, 0);
            if (entranceCount == 2) {
                Toast toast = Toast.makeText(this,
                        "It's a third entrance",
                        Toast.LENGTH_LONG);
                toast.show();
            }
            entranceCount++;
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putInt(APP_PREFERENCES_ENTRANCE_COUNT, entranceCount);
            editor.apply();
            mIncrementedCounter = entranceCount;
        } else {
            Log.d(LOG_TAG, "Activity restored");
            mIncrementedCounter = savedInstanceState.getInt("counter");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        if (mIncrementedCounter != null){
            outState.putInt("counter",mIncrementedCounter);
            Log.d(LOG_TAG, "current entrance count = "+ mIncrementedCounter);
        } else {
            Log.d(LOG_TAG, "Counter not stored");
        }
    }
}
