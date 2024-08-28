package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{

    // Datenbankname und Version
    public static final String DATABASE_NAME = "quiz.db";
    public static final int DATABASE_VERSION = 2;

    // Tabellen und Spaltennamen
    public static final String TABLE_ANSWER = "answer";
    public static final String TABLE_SA = "submittedansware";
    public static final String TABLE_COM = "compare";

    // Spalten für answer-Tabelle
    public static final String COL_ANS_1 = "ID";
    public static final String COL_ANS_2 = "ans";

    // Spalten für submittedansware-Tabelle
    public static final String COL_SA_1 = "ID";
    public static final String COL_SA_2 = "sa";

    // Spalten für compare-Tabelle
    public static final String COL_COM_1 = "ID";
    public static final String COL_COM_2 = "value";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Erstellen der Tabellen
        db.execSQL("CREATE TABLE " + TABLE_ANSWER + " (" +
                COL_ANS_1 + " INTEGER PRIMARY KEY, " +
                COL_ANS_2 + " TEXT)");

        db.execSQL("CREATE TABLE " + TABLE_COM + " (" +
                COL_COM_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_COM_2 + " TEXT)");

        db.execSQL("CREATE TABLE " + TABLE_SA + " (" +
                COL_SA_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_SA_2 + " TEXT)");

        // Beispielhafte Datensätze einfügen
        db.execSQL("INSERT INTO " + TABLE_ANSWER + " (" + COL_ANS_1 + ", " + COL_ANS_2 + ") VALUES (1, 'Antike')");
        db.execSQL("INSERT INTO " + TABLE_ANSWER + " (" + COL_ANS_1 + ", " + COL_ANS_2 + ") VALUES (2, 'Salvador Dali')");
        db.execSQL("INSERT INTO " + TABLE_ANSWER + " (" + COL_ANS_1 + ", " + COL_ANS_2 + ") VALUES (3, 'Barock')");
        db.execSQL("INSERT INTO " + TABLE_ANSWER + " (" + COL_ANS_1 + ", " + COL_ANS_2 + ") VALUES (4, 'Caspar David Friedrich')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Upgrade-Logik, z.B. alte Tabellen löschen und neu erstellen
        Log.d("DatabaseHelper", "onUpgrade called: oldVersion=" + oldVersion + " newVersion=" + newVersion);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANSWER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SA);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Downgrade-Logik, ähnlich wie bei einem Upgrade
        Log.d("DatabaseHelper", "onDowngrade called: oldVersion=" + oldVersion + " newVersion=" + newVersion);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANSWER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SA);
        onCreate(db);
    }
}

