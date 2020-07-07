package com.example.menuspickers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int year,month,day;
    int hr,min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.share:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Hello");
                intent.setType("text/plain");
                intent=Intent.createChooser(intent,"share via");
                startActivity(intent);
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.dail:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this,item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void alert(View view) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Alert !!!!");
        dialog.setMessage("Are you want to go back or stay here");
        dialog.setIcon(R.mipmap.setting_icon);
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    public void date(View view) {
       Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month= c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this, "You selected "+ day+ "/" + (month+1) + "/" + year, Toast.LENGTH_SHORT).show();

            }
        },year,month,day);
        dpd.show();

    }
    public void time(View view) {
        Calendar c =  Calendar.getInstance();
        hr = c.get(Calendar.HOUR_OF_DAY);
        min =c.get(Calendar.MINUTE);
        TimePickerDialog tpd = new  TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                Toast.makeText(MainActivity.this, "your time selected" + hr +"-" + min , Toast.LENGTH_SHORT).show();

            }
        },hr,min,true);
        tpd.show();
    }
}
