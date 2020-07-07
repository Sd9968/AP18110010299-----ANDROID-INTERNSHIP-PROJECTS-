package com.example.implicitex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cal(View view) {
        Uri ur = Uri.parse("tel:1255553");
        Intent i = new Intent(Intent.ACTION_DIAL,ur);
        startActivity(i);
    }
    public void loc(View view) {
        Uri ma = Uri.parse("geo:16.463549,80.5078");
        Intent i = new Intent(Intent.ACTION_VIEW,ma);
        startActivity(i);
    }
    public void url (View view) {
        Uri u = Uri.parse("https://www.google.com");
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }
}
