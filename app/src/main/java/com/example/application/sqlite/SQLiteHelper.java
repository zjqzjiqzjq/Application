package com.example.application.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018/6/3/003.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public static String DB_NAME = "bxg.db";
    public static final String U_USERINFO = "userinfo";
    public static final String U_VIDEO_PLAY_LISI="videoplaylist";

    public SQLiteHelper(Context context){
        super(context, DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + U_USERINFO +"("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"userName VARCHAR,"
                +"sex VARCHAR,"
                +"qq VARCHAR"
                +")");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + U_VIDEO_PLAY_LISI +"("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"userName VARCHAR,"
                +"chapterId INT,"
                +"videoId INT,"
                +"videoPath VARCHAR,"
                +"title VARCHAR,"
                +"secondTitle VARCHAR"
                +")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + U_USERINFO);
        db.execSQL("DROP TABLE IF EXISTS " + U_VIDEO_PLAY_LISI);
        onCreate(db);
    }
}
