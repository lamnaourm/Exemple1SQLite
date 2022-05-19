package com.example.exemple1sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new MyDB(this);

        Student s1 = new Student(1,"SSSSS","HHHHH");
        Student s2 = new Student(1,"AAAAA","BBBBB");
        Student s3 = new Student(1,"CCCCC","FFFFFF");
        if(MyDB.insert_etudiant(db.getWritableDatabase(),s1)==-1)
            Toast.makeText(this, "INSERT Echoue", Toast.LENGTH_SHORT).show();

        MyDB.insert_etudiant(db.getWritableDatabase(),s2);
        MyDB.insert_etudiant(db.getWritableDatabase(),s3);

    }
}