package com.cherish.practicalpractice.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cherish.practicalpractice.R;

public class CustomViewActivity extends AppCompatActivity {
    MyLovelyCustomView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        myView = findViewById(R.id.myView);
    }

    public void ChangeView(View view) {
        myView.setShapeColor(R.color.colorAccent);
        myView.setTextColor(R.color.colorPrimaryDark);
        myView.setShapeText("TOSIN");
    }

    public void goToNextPage(View view) {
        Intent intent = new Intent(getApplicationContext(), CompoundViewActivity.class);
        startActivity(intent);

    }
}