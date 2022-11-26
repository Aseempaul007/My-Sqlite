package com.example.mysqlite.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.mysqlite.modelClass.ModelDataClass;

public class MyAdapter extends ArrayAdapter<ModelDataClass> {
    Context context;


    public MyAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context=context;

    }
}
