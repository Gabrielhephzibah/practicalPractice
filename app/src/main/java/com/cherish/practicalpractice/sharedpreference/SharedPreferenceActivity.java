package com.cherish.practicalpractice.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.cherish.practicalpractice.R;

public class SharedPreferenceActivity extends AppCompatActivity {
    private  SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefernce);
        sharedPreferences = getSharedPreferences("com.cherish.practicalpractice", MODE_PRIVATE);

        //****************** Save to SharedPreference ***************//
        SharedPreferences.Editor preferences = sharedPreferences.edit();
        preferences.putInt("number", 3);
        preferences.putString("name", "Water");
        preferences.apply();

        //************** Get from Shared Preference ***************

        String getName = sharedPreferences.getString("name", null);

        int getNumber = sharedPreferences.getInt("number", 0);



       //*********** To Delete all data  from SharedPreference ****************
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();



    }


}