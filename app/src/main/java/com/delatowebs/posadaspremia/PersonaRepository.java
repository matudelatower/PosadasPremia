package com.delatowebs.posadaspremia;

/**
 * Created by matias on 15/04/15.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

public class PersonaRepository {
    private DBHelper dbHelper;

    public PersonaRepository(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Persona persona) {
        // TODO Auto-generated method stub

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Persona.KEY_razon_social, persona.getRazonSocial());
        values.put(Persona.KEY_documento, persona.getDocumento());
        values.put(Persona.KEY_cuit, persona.getCuit());
        values.put(Persona.KEY_fisica, persona.getFisica());
        values.put(Persona.KEY_documento_a_verificar, persona.getDocumentoAVerificar());
        values.put(Persona.KEY_domicilio, persona.getDomicilio());
        values.put(Persona.KEY_nro_partida, persona.getNroPartida());



        // Inserting Row
        long persona_Id = db.insert(Persona.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) persona_Id;
    }

    public void delete(int persona_Id) {
        //int persona_Id = getFirstPersona();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Persona.TABLE, Persona.KEY_ID + "=" + persona_Id, null);
        db.close(); // Closing database connection
    }

    public void update(Persona persona) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Persona.KEY_razon_social, persona.getRazonSocial());
        values.put(Persona.KEY_documento, persona.getDocumento());
        values.put(Persona.KEY_cuit, persona.getCuit());
        values.put(Persona.KEY_fisica, persona.getFisica());
        values.put(Persona.KEY_documento_a_verificar, persona.getDocumentoAVerificar());
        values.put(Persona.KEY_domicilio, persona.getDomicilio());
        values.put(Persona.KEY_nro_partida, persona.getNroPartida());

        db.update(Persona.TABLE, values, Persona.KEY_ID + "=" + persona.getId(), null);
        db.close(); // Closing database connection
    }

    public ArrayList getAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Persona.KEY_ID + "," +
                Persona.KEY_razon_social + "," +
                Persona.KEY_documento + "," +
                Persona.KEY_cuit + "," +
                Persona.KEY_fisica + "," +
                Persona.KEY_documento_a_verificar + "," +
                Persona.KEY_domicilio + "," +
                Persona.KEY_nro_partida +
                " FROM " + Persona.TABLE;

        ArrayList personaList =new ArrayList();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                personaList.add(cursor.getString(cursor.getColumnIndex(Persona.KEY_ID)) + "_"
                        + cursor.getString(cursor.getColumnIndex(Persona.KEY_razon_social)));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return personaList;

    }

    public ArrayList<HashMap<String, String>>  getPersonaList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Persona.KEY_ID + "," +
                Persona.KEY_razon_social + "," +
                Persona.KEY_documento + "," +
                Persona.KEY_cuit + "," +
                Persona.KEY_fisica + "," +
                Persona.KEY_documento_a_verificar + "," +
                Persona.KEY_domicilio + "," +
                Persona.KEY_nro_partida +
                " FROM " + Persona.TABLE;

        //Persona persona = new Persona();
        ArrayList<HashMap<String, String>> personaList = new ArrayList<HashMap<String, String>>();


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> persona = new HashMap<String, String>();
                persona.put("id", cursor.getString(cursor.getColumnIndex(Persona.KEY_ID)));
                persona.put("name", cursor.getString(cursor.getColumnIndex(Persona.KEY_razon_social)));
                personaList.add(persona);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return personaList;

    }

    public Persona getPersonaById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Persona.KEY_ID + "," +
                Persona.KEY_razon_social + "," +
                Persona.KEY_documento + "," +
                Persona.KEY_cuit + "," +
                Persona.KEY_fisica + "," +
                Persona.KEY_documento_a_verificar + "," +
                Persona.KEY_domicilio + "," +
                Persona.KEY_nro_partida +
                " FROM " + Persona.TABLE
                + " WHERE " +
                Persona.KEY_ID + "=" + Id;


        int iCount =0;
        Persona persona = new Persona();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                persona.setId(cursor.getInt(cursor.getColumnIndex(Persona.KEY_ID)));
                persona.setRazonSocial(cursor.getString(cursor.getColumnIndex(Persona.KEY_razon_social)));
                persona.setDocumento(cursor.getString(cursor.getColumnIndex(Persona.KEY_documento)));
                persona.setCuit(cursor.getString(cursor.getColumnIndex(Persona.KEY_cuit)));
                persona.setDomicilio(cursor.getString(cursor.getColumnIndex(Persona.KEY_domicilio)));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return persona;
    }

    private int getFirstPersona(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Persona.KEY_ID +
                " FROM " + Persona.TABLE
                + " LIMIT 1;" ;


        int persona_Id =0;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                persona_Id =cursor.getInt(cursor.getColumnIndex(Persona.KEY_ID));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return persona_Id;
    }

    private int getLastPersona(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Persona.KEY_ID +
                " FROM " + Persona.TABLE
                + " ORDER BY " +
                Persona.KEY_ID + " DESC ";
        //" DESC LIMIT 1;" ;


        int persona_Id =0;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                persona_Id =cursor.getInt(cursor.getColumnIndex(Persona.KEY_ID));
                break;
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return persona_Id;
    }











}

