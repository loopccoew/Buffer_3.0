package com.example.cumminsnavigator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String printFloor = intent.getStringExtra(MainActivity.M1);

        TextView textGetFloor = findViewById(R.id.getFloor);
        textGetFloor .setText(printFloor);

        String printPath = intent.getStringExtra(MainActivity.M2);

        TextView textGetPath = findViewById(R.id.getPath);
        textGetPath.setText(printPath);
    }
}