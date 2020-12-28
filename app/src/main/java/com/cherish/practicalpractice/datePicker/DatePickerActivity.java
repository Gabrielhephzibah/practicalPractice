package com.cherish.practicalpractice.datePicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.cherish.practicalpractice.R;
import com.cherish.practicalpractice.paging.PagingActivity;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {
    EditText editText;
    DatePickerDialog datePickerDialog;
    Button checkTime, nextPage;
    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        editText = findViewById(R.id.editText);
        checkTime = findViewById(R.id.checkTime);
        nextPage = findViewById(R.id.nextPage);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
              final   int day = cldr.get(Calendar.DAY_OF_MONTH);
               final int month = cldr.get(Calendar.MONTH);
                final int year = cldr.get(Calendar.YEAR);
                datePickerDialog = new DatePickerDialog(DatePickerActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int yearSelected, int monthSelected, int daySelected) {
                        editText.setText( daySelected + "/" + (monthSelected + 1) + "/" + yearSelected);
                    }
                }, year,month,day);
                datePickerDialog.show();
            }
        });


        checkTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final  Calendar calendar = Calendar.getInstance();
                final  int hour = calendar.get(Calendar.HOUR_OF_DAY);
                final int minute = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(DatePickerActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourSelected, int minutesSelected) {
                       editText.setText(hourSelected + ":" + minutesSelected);

                    }
                }, hour,minute,true);
                timePickerDialog.show();
            }
        });

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PagingActivity.class);
                startActivity(intent);
            }
        });
    }
}