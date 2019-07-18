package com.example.electricscooter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MainActivity extends AppCompatActivity {

    CircleMenu circleMenu;
    Handler h = new Handler();
    Integer BTonOff=1; // ON- 1 OFF-0
    TextView nakladka, nakladka2, nakladka3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sprawdzenieOnOffBT();
        circleMenu();


    }

    public void circleMenu(){

        circleMenu = (CircleMenu) findViewById(R.id.circleMenu);
        circleMenu.setMainMenu(Color.parseColor("#3741ff"), R.drawable.scooterr, R.drawable.remove)
                .addSubMenu(Color.parseColor("#3741ff"), R.drawable.btt)
                .addSubMenu(Color.parseColor("#3741ff"), R.drawable.lightt)
                .addSubMenu(Color.parseColor("#3741ff"), R.drawable.bookt)
                .addSubMenu(Color.parseColor("#3741ff"), R.drawable.battery)
                .addSubMenu(Color.parseColor("#3741ff"), R.drawable.speedt)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {

                        if (index == 0){
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    openBTActivity();
                                }
                            }, 1050);
                        }

                        if (index == 1){
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    openLightActivity();
                                }
                            }, 1050);
                        }

                        if (index == 2){
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    openBookActivity();
                                }
                            }, 1050);
                        }

                        if (index == 3){
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    openBatteryActivity();
                                }
                            }, 1050);
                        }

                        if (index == 4){
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    openSpeedActivity();
                                }
                            }, 1050);
                        }

                        //Toast.makeText(getApplicationContext(),"You selected = "+ names[index] + index, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void openBTActivity(){
        Intent intent = new Intent(this, BTActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);        finish();
    }

    public void openLightActivity(){
        Intent intent = new Intent(this, LightActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
        finish();
    }

    public void openBookActivity(){
        Intent intent = new Intent(this, TestTwoActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
        finish();
    }

    public void openBatteryActivity(){
        Intent intent = new Intent(this, BatteryActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
        finish();
    }

    public void openSpeedActivity(){
        Intent intent = new Intent(this, SpeedActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
        finish();
    }

    public void sprawdzenieOnOffBT(){
        nakladka = (TextView) findViewById(R.id.nakladka);
        nakladka2 = (TextView) findViewById(R.id.nakladka2);
        nakladka3 = (TextView) findViewById(R.id.nakladka3);
        if (BTonOff.intValue() == 1){
            nakladka.setVisibility(View.INVISIBLE);
            nakladka2.setVisibility(View.INVISIBLE);
            nakladka3.setVisibility(View.INVISIBLE);
        } else if (BTonOff.intValue() == 0) {
            nakladka.setVisibility(View.VISIBLE);
            nakladka2.setVisibility(View.VISIBLE);
            nakladka3.setVisibility(View.VISIBLE);
        }
    }



}
