package com.example.thongle.lab03_2.dbase_users;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by thongle on 14/04/2017.
 */

public class UsersBaseAdapter {
    private Context mcontext;
    private SQLiteDatabase sqLiteDatabase;

    public UsersBaseAdapter(Context context){
        mcontext = context.getApplicationContext();
        sqLiteDatabase = new UsersBaseHelper(mcontext).getWritableDatabase();
    }
    public void addUser(String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put(UsersDbSchema.UsersTable.Colunms.KEY_NAME, name);
        sqLiteDatabase.insert(UsersDbSchema.UsersTable.NAME, null, contentValues);
    }
    public boolean deleteAllUsers(){
        return sqLiteDatabase.delete(UsersDbSchema.UsersTable.NAME, null, null) > 0;
    }
    public Cursor getAllUsers(){
        return sqLiteDatabase.query(UsersDbSchema.UsersTable.NAME, new String[]{UsersDbSchema.UsersTable.Colunms.KEY_ID, UsersDbSchema.UsersTable.Colunms.KEY_NAME}, null, null, null, null, null);
    }
}
