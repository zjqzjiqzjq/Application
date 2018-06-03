package com.example.application.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.application.bean.UserBean;
import com.example.application.sqlite.SQLiteHelper;

/**
 * Created by Administrator on 2018/6/3/003.
 */

public class DBUtils {
    private static DBUtils instance = null;
    private static SQLiteHelper helper;
    private static SQLiteDatabase db ;

    public DBUtils(Context context){
        helper = new SQLiteHelper(context);
        db = helper.getWritableDatabase();
    }

    public static DBUtils getInstance(Context context){
        if(instance == null){
            instance = new DBUtils(context);
        }
        return instance;
    }

    public void saveUserInfo(UserBean bean){
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName",bean.userName);
        contentValues.put("sex",bean.sex);
        contentValues.put("qq",bean.qq);
        db.insert(SQLiteHelper.U_USERINFO,null,contentValues);
    }

    public  UserBean getUserInfo(String userName){
        String sql = "SELECT * FROM " + SQLiteHelper.U_USERINFO + " WHERE userName=?";
        Cursor cursor = db.rawQuery(sql,new String[]{userName});
        UserBean userBean = null;
        while (cursor.moveToNext()){
            userBean = new UserBean();
            userBean.userName = cursor.getString(cursor.getColumnIndex("userName"));
            userBean.sex = cursor.getString(cursor.getColumnIndex("sex"));
            userBean.qq = cursor.getString(cursor.getColumnIndex("qq"));  ////

        }
        cursor.close();
        return userBean;
    }
    public  void updateUserInfo(String key, String value, String userName){
        ContentValues contentValues = new ContentValues();
        contentValues.put(key, value);
        db.update(SQLiteHelper.U_USERINFO,contentValues, "userName=?",new String[]{userName});
    }
}
