package com.example.mmcc.mymiddleproject.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 16-10-19.
 */

public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(Context context) {
        super(context, "mldn.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
