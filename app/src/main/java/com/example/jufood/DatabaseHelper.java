package com.example.jufood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Login.db",null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table users(username TEXT primary key,email TEXT,password TEXT,confimpass TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
       MyDB.execSQL("drop table if exists users");
    }
    public Boolean InsertData(String username,String email,String pass,String conf_pass){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",pass);
        contentValues.put("confimpass",conf_pass);
        long result = MyDB.insert("users",null,contentValues);
        if(result == -1) return false;
        else return true;
    }

    public  Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username = ?",new String[] {username});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public  Boolean checkusernamePass(String username,String pass){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username = ? and password = ?",new String[] {username,pass});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean updateData(String username, String email, String pass,String conf_pass) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", pass);
        contentValues.put("confimpass", conf_pass);

        int result = MyDB.update("users", contentValues, "username = ?", new String[]{username});

        if (result > 0)
            return true;
        else
            return false;
    }

    public Cursor getUserInfo(String username) {
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE username=?", new String[]{username});
        return cursor;
    }

}
