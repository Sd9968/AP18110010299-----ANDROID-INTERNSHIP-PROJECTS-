package com.example.counterreset;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    int a = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.count);
    }
    @SuppressLint("SetTextI18n")
    public void inc(View v){
        a++;
        tv.setText(" "+a);

    }
    @SuppressLint("SetTextI18n")
    public void dec(View v){
        a--;
        tv.setText(" "+a);

    }

    public void toa(View v) {
        Toast.makeText(this, "hi ", Toast.LENGTH_SHORT).show();
    }
    @SuppressLint("SetTextI18n")
    public void res(View v) {
        a=0;
        tv.setText(" "+a);
    }
}
