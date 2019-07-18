package com.example.electricscooter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.location.GpsStatus;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import com.marcinmoskala.arcseekbar.ArcSeekBar;

import de.nitri.gauge.Gauge;

public class SpeedActivity extends AppCompatActivity{

    ImageButton btnBack;
    TextView tvSpeed, tvKm,tv;
    ArcSeekBar gradientSeekBar;
    private LocationManager lm;
    private LocationListener ll;
    String result;
    double mySpeed, maxSpeed;
    private final String Speed = null;
    Gauge gauge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        //btnBack();

        gradientSeekBar = (ArcSeekBar) findViewById(R.id.gradientSeekBar);
        int[] colorArrays = getResources().getIntArray(R.array.gradient);
        gradientSeekBar.setProgressGradient(colorArrays);

        tvSpeed = (TextView) findViewById(R.id.tvSpeed);
        tvKm = (TextView) findViewById(R.id.tvKm);
        gauge = (Gauge) findViewById(R.id.gauge);

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/exo-medium.ttf");
        tvSpeed.setTypeface(myCustomFont);
        tvKm.setTypeface(myCustomFont);

        maxSpeed = mySpeed = 0;

        lm = (LocationManager) getSystemService
                (Context.LOCATION_SERVICE);
        ll = new SpeedoActionListener();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(SpeedActivity.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.INTERNET}, 1);
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);

//        try {
//            gradientSeekBar.setProgress(25);
//        }catch (Exception e){
//            Log.i("BLAD", String.valueOf(e));
//        }
    }

    public void btnBack(){
        btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpeedActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


    private class SpeedoActionListener implements LocationListener
    {
        @Override
        public void onLocationChanged(Location location) {
            if(location!=null) {
                if(location.hasSpeed()){

                    mySpeed = location.getSpeed();
                    mySpeed = (mySpeed*3.634449);
                    result = String.format("%.0f", mySpeed);

                    tvSpeed.setText(result);

                    try {
                        gradientSeekBar.setProgress((int) mySpeed);
                        gauge.setValue((float)mySpeed);
                    }catch (Exception e){
                        Log.i("BLAD", String.valueOf(e));
                    }

                }
            }
            Log.i(Speed, "working3 ");
        }

        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle
                extras) {
            // TODO Auto-generated method stub

        }
    }

    // Powracanie do poprzedniego Activity za pomocą przycisku na telefonie
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            Intent intent = new Intent(SpeedActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }



}