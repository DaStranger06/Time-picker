package com.siamsoft.timepicker;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    TimePicker picker;
    Button btnGet;
    TextView tvw;


    TimePickerDialog pickerDialog;
    EditText eText;
    Button btnDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvw=(TextView)findViewById(R.id.textView1);
        picker=(TimePicker)findViewById(R.id.timePicker1);
        picker.setIs24HourView(true);
        btnGet=(Button)findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour, minute;
                String am_pm;
                if (Build.VERSION.SDK_INT >= 24 ){
                    hour = picker.getHour();
                    minute = picker.getMinute();
                }
                else{
                    hour = picker.getCurrentHour();
                    minute = picker.getCurrentMinute();
                }
                if(hour > 12) {
                    am_pm = "PM";
                    hour = hour - 12;
                }
                else
                {
                    am_pm="AM";
                }

                String tpdaata = (+ hour +":"+ minute+" "+am_pm);
                // tvw.setText("Selected Date: "+ hour +":"+ minute+" "+am_pm);
                tvw.setText(tpdaata);


                Intent intent = new Intent(getApplicationContext(), Second.class);
                intent.putExtra("timepickerdata1", tpdaata);
                startActivity(intent);





            }
        });

        //--2---------------time pick by click upon edit text
        eText=(EditText) findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                pickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                eText.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                pickerDialog.show();
            }
        });
        btnDialog=(Button)findViewById(R.id.button2);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String bb = eText.getText().toString();

                tvw.setText("Selected Time: "+ eText.getText());

                Intent intent1 = new Intent(getApplicationContext(), Second.class);
                intent1.putExtra("timepickerdata2", bb);

                startActivity(intent1);
            }
        });









    }



}
