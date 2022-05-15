package com.example.cumminsnavigator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String M1 = "com.example.DropDown.TRY";
    public static final String M2 = "com.example.DropDown.TRY1";
    String sourceValue, destValue, destRoomValue;

    ArrayList<String> build = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Source Spinner
        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.BuildingList));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);

        mySpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sourceValue = String.valueOf(parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Destination Room Spinner
        Spinner mySpinner3 = (Spinner) findViewById(R.id.spinnerRoom);
        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Roomlist));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter3);

        mySpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                destRoomValue = String.valueOf(parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View view){
        Intent intent = new Intent(this, MainActivity2.class);

        MakeMap ob1 = new MakeMap();
        ob1.create();
        ob1.addRooms();

        int snum = ob1.getBuildingNum(sourceValue);
        ArrayList d_dest = ob1.getBuilding(destRoomValue);
        String printPath = ob1.dijkstra(snum,(int)d_dest.get(2));
        String printFloor = "Room " + destRoomValue + " is in " + d_dest.get(0) + " Floor: " + d_dest.get(1);
        intent.putExtra(M1,printFloor);
        intent.putExtra(M2,printPath);
        startActivity(intent);
    }
}