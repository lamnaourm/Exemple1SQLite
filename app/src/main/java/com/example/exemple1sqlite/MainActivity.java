package com.example.exemple1sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyDB db;
    EditText e1, e2;
    ListView lst;
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new MyDB(this);
        e1 = findViewById(R.id.enom);
        e2 = findViewById(R.id.eprenom);
        lst = findViewById(R.id.lst);


        ArrayList<Student> st = MyDB.getAllStudent(db.getReadableDatabase());


        ArrayList<String> listitems = new ArrayList<>();
        for(Student ss : st)
            listitems.add(ss.getNom() + " - " + ss.getPrenom());

        ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listitems);
        lst.setAdapter(ad);



      /*  Student s1 = new Student(1,"SSSSS","HHHHH");
        Student s2 = new Student(1,"AAAAA","BBBBB");
        Student s3 = new Student(1,"CCCCC","FFFFFF");
        if(MyDB.insert_etudiant(db.getWritableDatabase(),s1)==-1)
            Toast.makeText(this, "INSERT Echoue", Toast.LENGTH_SHORT).show();

        MyDB.insert_etudiant(db.getWritableDatabase(),s2);
        MyDB.insert_etudiant(db.getWritableDatabase(),s3);*/

    }

    public void inserer(View view) {
        if(e1.getText().toString().isEmpty()){
            Toast.makeText(this,"Nom vide", Toast.LENGTH_LONG).show();
            return;
        }
        if(e2.getText().toString().isEmpty()){
            Toast.makeText(this,"Nom vide", Toast.LENGTH_LONG).show();
            return;
        }

        Student st = new Student();
        st.setNom(e1.getText().toString());
        st.setPrenom(e2.getText().toString());

        if(MyDB.insert_etudiant(db.getWritableDatabase(),st)==-1){
            Toast.makeText(this, "Insertion echoue", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Insertion reussie", Toast.LENGTH_SHORT).show();
            ad.add(st.getNom() + " - " + st.getPrenom());
        }
    }
}