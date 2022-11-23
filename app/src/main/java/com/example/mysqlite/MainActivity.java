package com.example.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        databaseHelper.insertData("Aseem Paul","8287371704");
        databaseHelper.insertData("Anu Paul","8287376604");
        databaseHelper.insertData("Bull Paul","8447371704");
        databaseHelper.insertData("Suar Paul","8288871704");
        databaseHelper.insertData("Babbu Paul","8200371704");


    }
}