package com.mehru.roomlibraryexa;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteOpenHelper;



@Database(entities = Expense.class,exportSchema = false,version = 1)
public  abstract  class DbHelper extends RoomDatabase {
    private static final String DB_NAME ="expenseDb";
    private static DbHelper instance;

    public static synchronized DbHelper getDB (Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context,DbHelper.class ,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
    }



}
