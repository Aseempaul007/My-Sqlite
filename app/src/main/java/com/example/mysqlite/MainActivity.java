package com.example.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mysqlite.modelClass.ModelDataClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ModelDataClass> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ModelDataClass modelDataClass = new ModelDataClass();
        listView = findViewById(R.id.listiew);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
//
//        databaseHelper.insertData("Aseem Paul","8287371704");
//        databaseHelper.insertData("Anu Paul","8287376604");
//        databaseHelper.insertData("Bull Paul","8447371704");
//        databaseHelper.insertData("Suar Paul","8288871704");
//        databaseHelper.insertData("Babbu Paul","8200371704");
        arr = databaseHelper.showData();

        //ar.add(new ModelDataClass(1,"aseem","anu"));
        //ar = databaseHelper.showData();

//        ArrayAdapter<ModelDataClass> arrayAdapter = new ArrayAdapter(
//                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arr);


        //listView.setAdapter(arrayAdapter);
        modelDataClass.setId(2);
        databaseHelper.deleteData(5);

        for(int i=0;i<arr.size();i++){
            Log.d("Contacts_dekh","Id: " + arr.get(i).getId()+", Name: " + arr.get(i).getName()+" Mobile No :"+
                    arr.get(i).getMobileNumber());
        }

    }
}