package com.example.android.quizapp;


import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.app.ListActivity;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.button;
import static android.R.attr.level;


public class MainActivity extends AppCompatActivity{
    Button btn_start;
    Button btn_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (Button) findViewById(R.id.btn_start);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        List<String> level = new ArrayList<>();

        level.add("Beginner");
        level.add("Intermediate");
        level.add("Advanced");

        ArrayAdapter<String> spAdapter= new ArrayAdapter<String>(this,R.layout.spinner_item,level);

        spAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(spAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("msg","Welcome");
                startActivity(intent);
            }
        });

    }







}
