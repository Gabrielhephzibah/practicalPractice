package com.cherish.practicalpractice.debugging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cherish.practicalpractice.R;
import com.cherish.practicalpractice.customview.CustomViewActivity;

public class BreakPointActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button additionBtn, subtractBtn, divisionBtn, multiplyBtn;
    EditText firstNumber, secondNumber;
    Spinner spinner;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break_point);
        additionBtn = findViewById(R.id.addBtn);
        subtractBtn = findViewById(R.id.subtractBtn);
        divisionBtn = findViewById(R.id.divisionBtn);
        multiplyBtn = findViewById(R.id.multiplyBtn);
        next = findViewById(R.id.nextBtn);
        spinner = findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }else {
            Log.i("Spinner", "Spinner is null");
        }

        // Create ArrayAdapter using the string array and default
        // spinner layout.
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this, R.array.labels_array,
                        android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }else
        {
            Log.i("Spinner Two", "Spinner is null");
        }

        firstNumber = findViewById(R.id.firstEdit);
        secondNumber = findViewById(R.id.secondEdit);

        additionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOne = firstNumber.getText().toString();
                String numberTwo = secondNumber.getText().toString();
                if (TextUtils.isEmpty(numberOne)){
                    firstNumber.setError("please input a number");
                    firstNumber.requestFocus();
                }else if (TextUtils.isEmpty(numberTwo)){
                    secondNumber.setError("please input a number");
                    secondNumber.requestFocus();
                }else {
                 int result  =  addNumber(Integer.parseInt(numberOne) , Integer.parseInt(numberTwo));
                    Toast.makeText(BreakPointActivity.this, String.valueOf(result), Toast.LENGTH_LONG).show();
//                    int result = Integer.parseInt(numberOne) + Integer.parseInt(numberTwo);
//                    Toast.makeText(BreakPointActivity.this,String.valueOf(result), Toast.LENGTH_LONG).show();


                }

            }
        });


        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOne = firstNumber.getText().toString();
                String numberTwo = secondNumber.getText().toString();
                if (TextUtils.isEmpty(numberOne)){
                    firstNumber.setError("please input a number");
                    firstNumber.requestFocus();
                }else if (TextUtils.isEmpty(numberTwo)){
                    secondNumber.setError("please input a number");
                    secondNumber.requestFocus();
                }else {
                  int result =  subtractNumber(Integer.parseInt(numberOne) , Integer.parseInt(numberTwo));

//                    int result = Integer.parseInt(numberOne) - Integer.parseInt(numberTwo);
                   Toast.makeText(BreakPointActivity.this,String.valueOf(result), Toast.LENGTH_LONG).show();
                }
            }
        });

        divisionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOne = firstNumber.getText().toString();
                String numberTwo = secondNumber.getText().toString();
                if (TextUtils.isEmpty(numberOne)){
                    firstNumber.setError("please input a number");
                    firstNumber.requestFocus();
                }else if (TextUtils.isEmpty(numberTwo)){
                    secondNumber.setError("please input a number");
                    secondNumber.requestFocus();
                }else {
                 int result =  divideNumber(Integer.parseInt(numberOne) , Integer.parseInt(numberTwo));
//                    int result = Integer.parseInt(numberOne) / Integer.parseInt(numberTwo);
                   Toast.makeText(BreakPointActivity.this,String.valueOf(result), Toast.LENGTH_LONG).show();

                }
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOne = firstNumber.getText().toString();
                String numberTwo = secondNumber.getText().toString();
                if (TextUtils.isEmpty(numberOne)){
                    firstNumber.setError("please input a number");
                    firstNumber.requestFocus();
                }else if (TextUtils.isEmpty(numberTwo)){
                    secondNumber.setError("please input a number");
                    secondNumber.requestFocus();
                }else {
                    int result = multiplyNumber(Integer.parseInt(numberOne) , Integer.parseInt(numberTwo));
//                    int result = Integer.parseInt(numberOne) * Integer.parseInt(numberTwo);
                    Toast.makeText(BreakPointActivity.this,String.valueOf(result), Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    public  int  addNumber(int firstNumber, int secondNumber){
        int result = firstNumber+ secondNumber;
        return  result;

    }

    public  int  subtractNumber(int firstNumber, int secondNumber){
        int resultSubtract = firstNumber - secondNumber;
        return  resultSubtract;

    }

    public  int  divideNumber(int firstNumber, int secondNumber){
        int resultDivide = firstNumber / secondNumber;
        return  resultDivide;

    }

    public  int  multiplyNumber(int firstNumber, int secondNumber){
        int resultMultiply = firstNumber * secondNumber;
        return  resultMultiply;

    }

    public void onNext(View view) {
        Intent intent = new Intent(getApplicationContext(), CustomViewActivity.class);
        startActivity(intent);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}