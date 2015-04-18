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
    private static final String DATABASE_NAME = "registro.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_STUDENT = "CREATE TABLE " + Persona.TABLE  + "("
                + Persona.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Persona.KEY_DOCUMENTO + " TEXT, "
                + Persona.KEY_CUIT + " TEXT, "
                + Persona.KEY_APELLIDO + " TEXT, "
                + Persona.KEY_NOMBRE + " TEXT, "
                + Persona.KEY_TIPO_DOC + " TEXT, "
                + Persona.KEY_FECHA_NACIMIENTO + " TEXT, "
                + Persona.KEY_SEXO + " TEXT, "
                + Persona.KEY_ESTADO_CIVIL + " TEXT, "
                + Persona.KEY_EMAIL + " TEXT, "
                + Persona.KEY_TEL_PRINCIPAL + " TEXT, "
                + Persona.KEY_TEL_SECUNDARIO + " TEXT,"
                + Persona.KEY_DIRECCION + " TEXT,"
                + Persona.KEY_NUMERO + " TEXT,"
                + Persona.KEY_DEPARTAMENTO + " TEXT,"
                + Persona.KEY_PISO + " TEXT,"
                + Persona.KEY_CUESTIONARIO + " TEXT,"
                + Persona.KEY_CREADO_POR + " TEXT,"
                + Persona.KEY_ACTUALIZADO + " TEXT )";

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