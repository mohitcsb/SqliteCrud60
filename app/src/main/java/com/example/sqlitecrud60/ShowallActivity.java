package com.example.sqlitecrud60;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShowallActivity extends AppCompatActivity {

    List<Student> list;
    TextView tv;
    Button back;
    ListView listView;
    MyOpenHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showall);


        back = findViewById(R.id.button);


        listView = findViewById(R.id.simpleListView);
        helper = new MyOpenHelper(getApplicationContext());

        list = helper.allStudents();

        MyAdapter adapter = new MyAdapter(getApplicationContext(), list);

        listView.setAdapter(adapter);
    }

    public void goBack(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}