package com.delatowebs.posadaspremia;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by matias on 23/04/15.
 */
public class TabletRepository {
    private DBHelper dbHelper;

    public TabletRepository(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Tablet tablet) {
        // TODO Auto-generated method stub

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Tablet.KEY_ID_TABLET, tablet.getIdTablet());
        



        // Inserting Row
        long tablet_Id = db.insert(Tablet.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) tablet_Id;
    }

    public void update(Tablet tablet) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Tablet.KEY_ID_TABLET, tablet.getIdTablet());
        

        db.update(Tablet.TABLE, values, Tablet.KEY_ID + "=" + tablet.getId(), null);
        db.close(); // Closing database connection
    }

    public int getFirstTablet(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Tablet.KEY_ID +
                " FROM " + Tablet.TABLE
                + " ORDER BY "+Tablet.KEY_ID+" DESC LIMIT 1;" ;


        int tablet_id =0;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                tablet_id =cursor.getInt(cursor.getColumnIndex(Tablet.KEY_ID));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return tablet_id;
    }

    public Tablet getTabletById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Tablet.KEY_ID + "," +
                Tablet.KEY_ID_TABLET +
                " FROM " + Tablet.TABLE + " WHERE " +
                Tablet.KEY_ID + "=" + Id;


        int iCount =0;
        Tablet tablet = new Tablet();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                tablet.setId(cursor.getInt(cursor.getColumnIndex(Tablet.KEY_ID)));
                tablet.setIdTablet(cursor.getInt(cursor.getColumnIndex(Tablet.KEY_ID_TABLET)));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return tablet;
    }
}
