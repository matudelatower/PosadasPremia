package com.delatowebs.posadaspremia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    private static final int DATABASE_VERSION = 4;

    // Database Name
    private static final String DATABASE_NAME = "padron.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_STUDENT = "CREATE TABLE " + Persona.TABLE  + "("
                + Persona.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Persona.KEY_razon_social + " TEXT, "
                + Persona.KEY_documento + " TEXT, "
                + Persona.KEY_cuit + " TEXT, "
                + Persona.KEY_fisica + " TEXT, "
                + Persona.KEY_documento_a_verificar + " TEXT, "
                + Persona.KEY_domicilio + " TEXT, "
                + Persona.KEY_nro_partida + " TEXT )";

        db.execSQL(CREATE_TABLE_STUDENT);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone
        db.execSQL("DROP TABLE IF EXISTS " + Persona.TABLE);

        // Create tables again
        onCreate(db);

    }

}