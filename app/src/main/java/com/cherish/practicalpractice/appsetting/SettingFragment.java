package com.cherish.practicalpractice.appsetting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceFragmentCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cherish.practicalpractice.R;



public class SettingFragment extends PreferenceFragmentCompat {



    public SettingFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences, rootKey);
    }


}