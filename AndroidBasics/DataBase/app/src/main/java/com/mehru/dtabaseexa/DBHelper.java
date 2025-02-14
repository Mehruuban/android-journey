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
    //private static Integer id;
    private  static final String KEY_ID = "id";
    private static final String KEY_NAME = "Name";
    private static final String KEY_CONTACT_NO = "ContactNo";

    public DBHelper( Context context) {
        super(context, DATA_BASE, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
//        database.execSQL("CREATE TABLE "+ CONTACT_TABLE +
//                        "(" + KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT ," + KEY_NAME + "TEXT," + KEY_CONTACT_NO + "TEXT" + ")" );
//
//
//        //to open database
//        SQLiteDatabase database1 = this.getWritableDatabase();
//        // to close database
//        database1.close();
        String CREATE_TABLE = "CREATE TABLE " + CONTACT_TABLE + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT, "
                + KEY_CONTACT_NO + " TEXT)";

        database.execSQL(CREATE_TABLE);

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

    // To fetch the data from SQLite database
    public ArrayList<contactModel> fetchContact (){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + CONTACT_TABLE,null );

        ArrayList<contactModel> arrayList  = new ArrayList<>();

        while (cursor.moveToNext()) {
            contactModel model = new contactModel();
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.ContactNo = cursor.getString(2);

            arrayList.add(model);

        }
        return arrayList;
    }

    //To update data

    public void updateContact (contactModel contactModel ){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CONTACT_NO,"2123456789");

        //values.put(KEY_CONTACT_NO, contactModel.ContactNo); //dynamic way

        database.update(CONTACT_TABLE,values,KEY_ID+"="+contactModel.id,null);
    }


    // To delete data

    public  void deleteContact (int id){
        SQLiteDatabase database =this.getWritableDatabase();

        database.delete(CONTACT_TABLE,KEY_ID+ "?",new String[]{String.valueOf(id)});
    }


}
