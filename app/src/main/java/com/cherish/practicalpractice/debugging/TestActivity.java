package com.cherish.practicalpractice.debugging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cherish.practicalpractice.R;

public class TestActivity extends AppCompatActivity {
    TextView newTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        newTest = findViewById(R.id.newText);
        newTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BreakPointActivity.class);
                startActivity(intent);
            }
        });
    }
}