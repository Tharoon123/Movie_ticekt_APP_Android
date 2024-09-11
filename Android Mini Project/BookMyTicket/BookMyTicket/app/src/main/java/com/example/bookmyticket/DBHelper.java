package com.example.bookmyticket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public static final String DBNAME="moviedb.db";

    public DBHelper(Context context) {

        super(context, "moviedb.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE login (username TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS login");

    }






    public boolean insertLoginData(String username, String password){

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);

        long result=db.insert("login", null, contentValues);

        if (result==-1){
            return false;
        }else {
            return true;
        }


    }

    public Boolean checkUserName(String un){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM login WHERE username = ?", new String[] {un});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }

    }

    public Boolean checkUnPw(String un,String pw){


        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM login WHERE username = ? and password = ? ", new String[] {un,pw});
        if (cursor.getCount()>0){
            Log.v("dbUsernamePassword",un + pw);
            return true;
        }else {
            return false;
        }
    }




}
