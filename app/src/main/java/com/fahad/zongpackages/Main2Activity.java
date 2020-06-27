package com.fahad.zongpackages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    Cursor c = null;
    List<product> list;
    RecyclerView RC;
    LinearLayoutManager manager;
    adrapter adp;
    String typeselection;
    ConstraintLayout back;
    TextView txt;
    int BBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt = findViewById(R.id.textView22);
        back = findViewById(R.id.back0);

        RC = findViewById(R.id.vvvvvv);
        manager = new LinearLayoutManager(this);
        RC.setLayoutManager(manager);


        list = new ArrayList<>();

        DatabaseHelper myDbHelper = new DatabaseHelper(this);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }


        Intent intent = getIntent();
        typeselection = intent.getStringExtra("Key2");


                switch (typeselection)
                {
                    case "ALL IN ONE":
                        c = myDbHelper.query("zongallinone", null, null, null, null, null, null);
                        txt.setText("Zong All in One");
                        break;

                    case "CALL":
                        c = myDbHelper.query("zongcall", null, null, null, null, null, null);
                        txt.setText("Zong Call");
                        break;

                    case "MESSAGE":
                        c = myDbHelper.query("zongmessage", null, null, null, null, null, null);
                        txt.setText("Zong Message");
                        break;

                    case "INTERNET":
                        c = myDbHelper.query("zonginternet", null, null, null, null, null, null);
                        txt.setText("Zong Internet");
                        break;

                    case "BROADBAND":
                        c = myDbHelper.query("zongbroadband", null, null, null, null, null, null);
                        txt.setText("Zong Broadband");
                        break;
                }


        if (c.moveToFirst()) {
            do {
                list.add(new product(c.getString(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7)));
            } while (c.moveToNext());
        }

        adp = new adrapter(Main2Activity.this,list);
        RC.setAdapter(adp);


    }


}