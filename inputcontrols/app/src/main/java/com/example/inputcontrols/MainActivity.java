package com.example.inputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_name,et_mobile, et_mail,et_password;
    TextView tv;
    CheckBox  ch_java ,ch_and, ch_python;
    RadioButton r_male ,r_female;
    Spinner sp_dis,sp_man;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name= findViewById(R.id.name);
        et_mobile= findViewById(R.id.mobile);
        et_mail= findViewById(R.id.email);
        et_password= findViewById(R.id.password);
        tv = findViewById(R.id.text);
        sp_dis = findViewById(R.id.spinner);
        sp_man= findViewById(R.id.spinner2);
        ch_and = findViewById(R.id.c);
        ch_java = findViewById(R.id.java);
        ch_python  = findViewById(R.id.python);
        r_female =findViewById(R.id.Female);
        r_male = findViewById(R.id.male);

        ArrayAdapter<CharSequence> district = ArrayAdapter.createFromResource(this,R.array.districts,android.R.layout.simple_spinner_item);
        sp_dis.setAdapter(district);

        sp_dis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 1:
                        ArrayAdapter<CharSequence> andis = ArrayAdapter.createFromResource(
                                MainActivity.this,R.array.Aanthpur_mandals,android.R.layout.simple_spinner_item);
                        sp_man.setAdapter(andis);
                        break;
                    case 2:
                        ArrayAdapter<CharSequence> nlrman = ArrayAdapter.createFromResource(MainActivity.this,R.array.nellore_mandals,android.R.layout.simple_spinner_item);
                        sp_man.setAdapter(nlrman);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void submit(View view) {
        String name = et_name.getText().toString();
        String mobile  = et_mobile.getText().toString();
        String mail= et_mail.getText().toString();
        String  password  = et_password.getText().toString();
        if(r_male.isChecked()){
            gender=r_male.getText().toString();
        }
        if(r_female.isChecked()){
            gender=r_female.getText().toString();
        }
        StringBuilder  builder = new StringBuilder();
        if(ch_and.isChecked()){
            builder.append(ch_and.getText().toString());
        }
        if(ch_java.isChecked()){
           builder.append(ch_java.getText().toString());
        }
        if(ch_python.isChecked()){
            builder.append(ch_python.getText().toString());
        }
        tv.setText(name+"\n"+mobile+"\n"+mail+"\n"+ password+"\n"+builder+"\n"+gender);
    }
}
