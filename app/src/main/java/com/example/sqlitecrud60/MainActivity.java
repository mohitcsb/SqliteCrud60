package com.example.sqlitecrud60;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText id, name, email;
    Button save,showall;
    MyOpenHelper openHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        save = findViewById(R.id.save);
        showall = findViewById(R.id.showall);

        openHelper = new MyOpenHelper(getApplicationContext());
    }

    public void save(View v) {
        Student student = new Student(Integer.parseInt(id.getText().toString()), name.getText().toString(), email.getText().toString());
        openHelper.doSave(student);
    }

    public void showAll(View v) {
        Intent i = new Intent(this,ShowallActivity.class);
        startActivity(i);

    }


}