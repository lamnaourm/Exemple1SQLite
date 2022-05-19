package com.example.exemple1sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDB extends SQLiteOpenHelper {

    public final static String NOM_DB = "student.db";
    public final static String TABLE_NAME = "student";
    public final static String COL1 = "ID";
    public final static String COL2 = "NOM";
    public final static String COL3 = "PRENOM";

    public MyDB(Context c) {
        super(c, NOM_DB, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TABLE_NAME + " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COL2 + " TEXT, " + COL3 + " TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE " + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public static long insert_etudiant(SQLiteDatabase sqLiteDatabase, Student s){

        ContentValues c = new ContentValues();
        c.put(COL2,s.getNom());
        c.put(COL3,s.getPrenom());
        return  sqLiteDatabase.insert(TABLE_NAME,null,c);
    }
}