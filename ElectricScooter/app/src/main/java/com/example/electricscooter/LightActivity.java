package com.example.electricscooter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LightActivity extends AppCompatActivity {

    ImageButton btnBack;
    Button btnLightOn,btnLightOff ;
    private SharedPreferences myPrefs;
    private static final String PREFS_NAME = "myPrfsFile";
    Integer stateOfButton, wartosc; // 0 - light off  **** 1- light on




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        //btnBack();
        lightOnOff();

    }

    private void lightOnOff() {
        btnLightOff = findViewById(R.id.scan);
        btnLightOn = findViewById(R.id.off);

        // get data back
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);

        if (prefs.contains("message")){
            String message = prefs.getString("message", "not found");
            wartosc = prefs.getInt("stateOfButton", 0);
        }else{
            wartosc = 0;
        }

        if (wartosc.intValue()== 0) {
            btnLightOn.setVisibility(View.INVISIBLE);
            btnLightOff.setVisibility(View.VISIBLE);
        } else if (wartosc.intValue() == 1){
            btnLightOn.setVisibility(View.VISIBLE);
            btnLightOff.setVisibility(View.INVISIBLE);
        }

        btnLightOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnLightOn.setVisibility(View.VISIBLE);
                btnLightOff.setVisibility(View.INVISIBLE);

                myPrefs = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = myPrefs.edit();
                stateOfButton = 1;
                editor.putInt("stateOfButton", stateOfButton);
                //editor.putString("message", "btnOFF");
                editor.commit();
            }
        });

        btnLightOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnLightOn.setVisibility(View.INVISIBLE);
                btnLightOff.setVisibility(View.VISIBLE);
                myPrefs = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = myPrefs.edit();
                stateOfButton = 0;
                editor.putInt("stateOfButton", stateOfButton);
                //editor.putString("message", "btnON");
                editor.commit();

            }
        });

    }
    public void btnBack(){
        btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LightActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
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
            //TODO tutaj po usunieciu finish zapamiętuje stan
            finish();

        }
        return super.onKeyDown(keyCode, event);
    }

}
