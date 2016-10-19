package com.example.mmcc.mymiddleproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.tech.IsoDep;

/**
 * Created by Administrator on 16-10-19.
 */

public class DBManager {
    private DBHelper helper;
    private DBManager(Context context){
        helper = new DBHelper(context);
    }

    public static DBManager dbManager;
    public static DBManager getInstance(Context context){
        if(dbManager==null)
        {
            dbManager = new DBManager(context);
        }
        return dbManager;
    }

    public boolean insert(String tableName, ContentValues values){
        SQLiteDatabase db = helper.getReadableDatabase();
        long insert = db.insert(tableName, null, values);
        if(insert!=-1)
        {
            db.close();
            return true;
        }
        return false;
    }
    //whereClause:  "id=? and name=?" whereArgs: new String[]{"1","cc"}
    public void delete(String tableName,String whereClause,String[] whereArgs){
        SQLiteDatabase db = helper.getReadableDatabase();
        db.delete(tableName,whereClause,whereArgs);
        db.close();
    }
    public void clear(String tableName){
        SQLiteDatabase db = helper.getReadableDatabase();
        db.delete(tableName,null,null);
        db.close();
    }
    public void update(String tableName,ContentValues values,String whereClause,String[] whereArgs){
        SQLiteDatabase db = helper.getReadableDatabase();
        db.update(tableName,values,whereClause,whereArgs);
        db.close();
    }

    public Cursor query(String tableName,String[] columns,String selection,String[] selectionArgs){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(tableName,columns,selection,selectionArgs,null,null,null);
        return cursor;
    }

    public Cursor queryAll(String tableName){
      return query(tableName,null,null,null);
    }

    /**
     * 查找第几页的数据，一般情况下，本地只存储第一页，将最新的网络数据
     * 保存到数据库里
     * @param tableName 表名
     * @param page 第几页
     * @return
     */
    public Cursor queryPage(String tableName,int page){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = queryAll(tableName);
        int count = cursor.getCount(); //得到总条数
        int perPage = 5;//每页5条数据
        int pageCount = count/perPage;  //得到页数

        String sql = "";
        int mid = count%perPage; //最后不够五条数据的也算一页
        if(mid!=0)
        {
            pageCount++;  //说明没除尽，页数需要再加一页
        }
        if(page<pageCount)
        {
            int i = perPage*(page-1);
            //表示查询 从下标i开始查询，查perPage(5)条数据
            sql = "select * from "+tableName+" limit "+i+","+perPage;
        }else if (page==pageCount){ //如果取最后一页的数据
            int i = perPage*(page-1);
            //从最后一页开始取，取剩下的条数
            sql = "select * from "+tableName+" limit "+i+","+(count-i);
        }
        Cursor cursor1 = db.rawQuery(sql,null);
        return cursor1;

    }
}
