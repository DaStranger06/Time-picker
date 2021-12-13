package com.siamsoft.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        EditText ex1 = (EditText)findViewById(R.id.et1);
        EditText ex2 = (EditText)findViewById(R.id.et2);




        String value1 = getIntent().getExtras().getString("timepickerdata1");

        ex1.setText(value1);


        String value2 = getIntent().getExtras().getString("timepickerdata2");

        ex2.setText(value2);
    }
}