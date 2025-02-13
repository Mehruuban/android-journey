package com.mehru.dtabaseexa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.security.PublicKey;
import java.util.ArrayList;

public class DBHelper  extends SQLiteOpenHelper  {

    private static final String DATA_BASE = "ContactDB";
    private static final int DATABASE_VERSION = 1 ;
    private static final String CONTACT_TABLE = "contacts";
    private  static final String KEY_ID = "id";
    private static final String KEY_NAME = "Name";
    private static final String KEY_CONTACT_NO = "ContactNo";

    public DBHelper( Context context) {
        super(context, DATA_BASE, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("Create Table "+ CONTACT_TABLE +
                        "(" + KEY_ID + "Integer PRIMARY KEY AUTOINCREMENT," + KEY_NAME + "TEXT," + KEY_CONTACT_NO + "TEXT" + ")" );


        //to open database
        SQLiteDatabase database1 = this.getWritableDatabase();
        // to close database
        database1.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        database.execSQL("DROP TABLE IF EXISTS " +CONTACT_TABLE);

        onCreate(database);

    }

      // To insert data in database
    public void addContacts (String Name, String ContactNo)  {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME ,Name);
        values.put(KEY_CONTACT_NO,ContactNo);

        database.insert(CONTACT_TABLE ,null,values);

    }

    //fetch the data from SQLite database
    public ArrayList<contactModel> fetchContact (){
        SQLiteDatabase database = this.getReadableDatabase();
       Cursor cursor = database.rawQuery("SELECT * FROM " + CONTACT_TABLE,null );

    }


}
