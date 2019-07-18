package com.example.electricscooter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import de.nitri.gauge.Gauge;

public class TestTwoActivity extends AppCompatActivity {

    Gauge gauge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_two);

        gauge = (Gauge) findViewById(R.id.gauge);

    }
}
