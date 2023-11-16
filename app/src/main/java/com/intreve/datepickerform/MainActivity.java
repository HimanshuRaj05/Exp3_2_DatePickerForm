package com.intreve.datepickerform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText etFirstName, etLastName;
    TextView tvDate;

    String selectedDate="";

    RadioGroup radioGroup;
    AppCompatButton btnDate, btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName=findViewById(R.id.etFirstName);
        etLastName=findViewById(R.id.etLastName);
        tvDate=findViewById(R.id.tvDate);
        radioGroup=findViewById(R.id.radioGroup);
        btnDate=findViewById(R.id.btnDate);
        btnContinue=findViewById(R.id.btnContinue);



        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                final Calendar c= Calendar.getInstance();

                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int day=c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog= new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        selectedDate="";
                        if(i2<10){
                            selectedDate+="0"+i2+"/";
                        }

                        else{
                            selectedDate+=i2+"/";
                        }


                        if(i1<10){
                            selectedDate+="0"+(i1+1)+"/";
                        }

                        else{
                            selectedDate+=(i1+1)+"/";
                        }

                        selectedDate+=i;

                        tvDate.setText(selectedDate);



                    }


                },year, month, day);



                dialog.show();
                // tvDate.setText(selectedDate);


            }
        });



        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName=etFirstName.getText().toString();
                String lastName=etLastName.getText().toString();
                String gender="";

                int rbId=-1;

                rbId=radioGroup.getCheckedRadioButtonId();

                switch (rbId){
                    case R.id.rbMale:
                        gender="Male";
                        break;

                    case R.id.rbFemale:
                        gender="Female";
                        break;

                    default:
                        gender="Undefined";

                }

                String toastString="User: "+firstName+" "+lastName+"\n"+"Gender: "+gender;

                Toast.makeText(MainActivity.this, toastString, Toast.LENGTH_SHORT).show();



            }
        });








    }
}