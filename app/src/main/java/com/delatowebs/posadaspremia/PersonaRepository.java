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
        values.put(Persona.KEY_DOCUMENTO, persona.getDocumento());
        values.put(Persona.KEY_CUIT, persona.getCuit());
        values.put(Persona.KEY_APELLIDO, persona.getApellido());
        values.put(Persona.KEY_NOMBRE, persona.getNombre());
        values.put(Persona.KEY_TIPO_DOC, persona.getTipoDocumento());
        values.put(Persona.KEY_FECHA_NACIMIENTO, persona.getFechaNacimiento());
        values.put(Persona.KEY_SEXO, persona.getSexo());
        values.put(Persona.KEY_ESTADO_CIVIL, persona.getEstadoCivil());
        values.put(Persona.KEY_EMAIL, persona.getEmail());
        values.put(Persona.KEY_TEL_PRINCIPAL, persona.getTelPrincipal());
        values.put(Persona.KEY_TEL_SECUNDARIO, persona.getTelSecundario());
        values.put(Persona.KEY_DIRECCION, persona.getDireccion());
        values.put(Persona.KEY_NUMERO, persona.getNumero());
        values.put(Persona.KEY_DEPARTAMENTO, persona.getDepartamento());
        values.put(Persona.KEY_PISO, persona.getPiso());
        values.put(Persona.KEY_CUESTIONARIO, persona.getCuestionario());
        values.put(Persona.KEY_CREADO_POR, persona.getCreadoPor());
        values.put(Persona.KEY_ACTUALIZADO, persona.getActualizado());



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

        values.put(Persona.KEY_DOCUMENTO, persona.getDocumento());
        values.put(Persona.KEY_CUIT, persona.getCuit());
        values.put(Persona.KEY_APELLIDO, persona.getApellido());
        values.put(Persona.KEY_NOMBRE, persona.getNombre());
        values.put(Persona.KEY_TIPO_DOC, persona.getTipoDocumento());
        values.put(Persona.KEY_FECHA_NACIMIENTO, persona.getFechaNacimiento());
        values.put(Persona.KEY_SEXO, persona.getSexo());
        values.put(Persona.KEY_ESTADO_CIVIL, persona.getEstadoCivil());
        values.put(Persona.KEY_EMAIL, persona.getEmail());
        values.put(Persona.KEY_TEL_PRINCIPAL, persona.getTelPrincipal());
        values.put(Persona.KEY_TEL_SECUNDARIO, persona.getTelSecundario());
        values.put(Persona.KEY_DIRECCION, persona.getDireccion());
        values.put(Persona.KEY_NUMERO, persona.getNumero());
        values.put(Persona.KEY_DEPARTAMENTO, persona.getDepartamento());
        values.put(Persona.KEY_PISO, persona.getPiso());
        values.put(Persona.KEY_CUESTIONARIO, persona.getCuestionario());
        values.put(Persona.KEY_CREADO_POR, persona.getCreadoPor());
        values.put(Persona.KEY_ACTUALIZADO, persona.getActualizado());

        db.update(Persona.TABLE, values, Persona.KEY_ID + "=" + persona.getId(), null);
        db.close(); // Closing database connection
    }

    public ArrayList getAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Persona.KEY_ID + "," +
                Persona.KEY_DOCUMENTO + "," +
                Persona.KEY_CUIT + "," +
                Persona.KEY_APELLIDO + "," +
                Persona.KEY_NOMBRE + "," +
                Persona.KEY_TIPO_DOC + "," +
                Persona.KEY_FECHA_NACIMIENTO + "," +
                Persona.KEY_SEXO + "," +
                Persona.KEY_ESTADO_CIVIL + "," +
                Persona.KEY_EMAIL + "," +
                Persona.KEY_TEL_PRINCIPAL + "," +
                Persona.KEY_TEL_SECUNDARIO + "," +
                Persona.KEY_DIRECCION + "," +
                Persona.KEY_NUMERO + "," +
                Persona.KEY_DEPARTAMENTO + "," +
                Persona.KEY_PISO + "," +
                Persona.KEY_CUESTIONARIO + "," +
                Persona.KEY_CREADO_POR + "," +
                Persona.KEY_ACTUALIZADO +
                " FROM " + Persona.TABLE;

        ArrayList personaList =new ArrayList();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                personaList.add(cursor.getString(cursor.getColumnIndex(Persona.KEY_ID)) + "_"
                        + cursor.getString(cursor.getColumnIndex(Persona.KEY_DOCUMENTO)));

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
                Persona.KEY_DOCUMENTO + "," +
                Persona.KEY_CUIT + "," +
                Persona.KEY_APELLIDO + "," +
                Persona.KEY_NOMBRE + "," +
                Persona.KEY_TIPO_DOC + "," +
                Persona.KEY_FECHA_NACIMIENTO + "," +
                Persona.KEY_SEXO + "," +
                Persona.KEY_ESTADO_CIVIL + "," +
                Persona.KEY_EMAIL + "," +
                Persona.KEY_TEL_PRINCIPAL + "," +
                Persona.KEY_TEL_SECUNDARIO + "," +
                Persona.KEY_DIRECCION + "," +
                Persona.KEY_NUMERO + "," +
                Persona.KEY_DEPARTAMENTO + "," +
                Persona.KEY_PISO + "," +
                Persona.KEY_CUESTIONARIO + "," +
                Persona.KEY_CREADO_POR + "," +
                Persona.KEY_ACTUALIZADO +
                " FROM " + Persona.TABLE;


        //Persona persona = new Persona();
        ArrayList<HashMap<String, String>> personaList = new ArrayList<HashMap<String, String>>();


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> persona = new HashMap<String, String>();
                persona.put("id", cursor.getString(cursor.getColumnIndex(Persona.KEY_ID)));
                persona.put("documento", cursor.getString(cursor.getColumnIndex(Persona.KEY_DOCUMENTO)));
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
                Persona.KEY_DOCUMENTO + "," +
                Persona.KEY_CUIT + "," +
                Persona.KEY_APELLIDO + "," +
                Persona.KEY_NOMBRE + "," +
                Persona.KEY_TIPO_DOC + "," +
                Persona.KEY_FECHA_NACIMIENTO + "," +
                Persona.KEY_SEXO + "," +
                Persona.KEY_ESTADO_CIVIL + "," +
                Persona.KEY_EMAIL + "," +
                Persona.KEY_TEL_PRINCIPAL + "," +
                Persona.KEY_TEL_SECUNDARIO + "," +
                Persona.KEY_DIRECCION + "," +
                Persona.KEY_NUMERO + "," +
                Persona.KEY_DEPARTAMENTO + "," +
                Persona.KEY_PISO + "," +
                Persona.KEY_CUESTIONARIO + "," +
                Persona.KEY_CREADO_POR + "," +
                Persona.KEY_ACTUALIZADO +
                " FROM " + Persona.TABLE + " WHERE " +
                Persona.KEY_ID + "=" + Id;


        int iCount =0;
        Persona persona = new Persona();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                persona.setId(cursor.getInt(cursor.getColumnIndex(Persona.KEY_ID)));
                persona.setDocumento(cursor.getString(cursor.getColumnIndex(Persona.KEY_DOCUMENTO)));
                persona.setCuit(cursor.getString(cursor.getColumnIndex(Persona.KEY_CUIT)));
                persona.setApellido(cursor.getString(cursor.getColumnIndex(Persona.KEY_APELLIDO)));
                persona.setNombre(cursor.getString(cursor.getColumnIndex(Persona.KEY_NOMBRE)));
                persona.setTipoDocumento(cursor.getString(cursor.getColumnIndex(Persona.KEY_TIPO_DOC)));
                persona.setFechaNacimiento(cursor.getString(cursor.getColumnIndex(Persona.KEY_FECHA_NACIMIENTO)));
                persona.setSexo(cursor.getString(cursor.getColumnIndex(Persona.KEY_SEXO)));
                persona.setEstadoCivil(cursor.getString(cursor.getColumnIndex(Persona.KEY_ESTADO_CIVIL)));
                persona.setEmail(cursor.getString(cursor.getColumnIndex(Persona.KEY_EMAIL)));
                persona.setTelPrincipal(cursor.getString(cursor.getColumnIndex(Persona.KEY_TEL_PRINCIPAL)));
                persona.setTelSecundario(cursor.getString(cursor.getColumnIndex(Persona.KEY_TEL_SECUNDARIO)));
                persona.setDireccion(cursor.getString(cursor.getColumnIndex(Persona.KEY_DIRECCION)));
                persona.setNumero(cursor.getString(cursor.getColumnIndex(Persona.KEY_NUMERO)));
                persona.setDepartamento(cursor.getString(cursor.getColumnIndex(Persona.KEY_DEPARTAMENTO)));
                persona.setPiso(cursor.getString(cursor.getColumnIndex(Persona.KEY_PISO)));
                persona.setCuestionario(cursor.getString(cursor.getColumnIndex(Persona.KEY_CUESTIONARIO)));
                persona.setCreadoPor(cursor.getString(cursor.getColumnIndex(Persona.KEY_CREADO_POR)));
                persona.setActualizado(cursor.getString(cursor.getColumnIndex(Persona.KEY_ACTUALIZADO)));

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

