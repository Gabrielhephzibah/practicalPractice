package com.cherish.practicalpractice.workmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cherish.practicalpractice.R;

public class BlurActivity extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur);
        image = findViewById(R.id.image);
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(Constants.KEY_IMAGE_URI);
        Glide.with(this).load(imageUrl).into(image);


    }
}