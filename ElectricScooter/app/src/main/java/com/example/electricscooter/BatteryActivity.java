package com.example.electricscooter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class BatteryActivity extends AppCompatActivity{

    ImageButton btnBack;
    ImageView batteryfull, batteryeighty, batteryfifty, batterytwenty ;
    Button btntwenty, btneighty, btnfull, btnfifty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        batteryfull = (ImageView) findViewById(R.id.batteryfull);
        batteryeighty = (ImageView) findViewById(R.id.batteryeighty);
        batteryfifty = (ImageView) findViewById(R.id.batteryfifty);
        batterytwenty = (ImageView) findViewById(R.id.batterytwenty);

        btntwenty = (Button) findViewById(R.id.btntwenty);
        btnfifty = (Button) findViewById(R.id.btnfifty);
        btneighty = (Button) findViewById(R.id.btneighty);
        btnfull = (Button) findViewById(R.id.btnfull);

        batterytwenty.setVisibility(View.INVISIBLE);
        batteryfifty.setVisibility(View.INVISIBLE);
        batteryeighty.setVisibility(View.INVISIBLE);
        batteryfull.setVisibility(View.INVISIBLE);


        //btnBack();

        btntwenty();
        btnfifty();
        btneighty();
        btnfull();

    }

    public void btntwenty(){
        btntwenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                batterytwenty.setVisibility(View.VISIBLE);
                batteryfifty.setVisibility(View.INVISIBLE);
                batteryeighty.setVisibility(View.INVISIBLE);
                batteryfull.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void btnfifty(){
        btnfifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                batterytwenty.setVisibility(View.INVISIBLE);
                batteryfifty.setVisibility(View.VISIBLE);
                batteryeighty.setVisibility(View.INVISIBLE);
                batteryfull.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void btneighty(){
        btneighty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                batterytwenty.setVisibility(View.INVISIBLE);
                batteryfifty.setVisibility(View.INVISIBLE);
                batteryeighty.setVisibility(View.VISIBLE);
                batteryfull.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void btnfull(){
        btnfull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                batterytwenty.setVisibility(View.INVISIBLE);
                batteryfifty.setVisibility(View.INVISIBLE);
                batteryeighty.setVisibility(View.INVISIBLE);
                batteryfull.setVisibility(View.VISIBLE);
            }
        });

    }


    public void btnBack(){
        btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BatteryActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    // Powracanie do poprzedniego Activity za pomocą przycisku na telefonie
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
