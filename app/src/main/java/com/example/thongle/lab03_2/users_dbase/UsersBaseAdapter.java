package com.example.thongle.lab03_2.users_dbase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.thongle.lab03_2.users_dbase.UsersDbSchema.UsersTable;
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
        contentValues.put(UsersTable.Colunms.KEY_NAME, name);
        sqLiteDatabase.insert(UsersTable.NAME, null, contentValues);
    }
    public boolean deleteAllUsers(){
        return sqLiteDatabase.delete(UsersTable.NAME, null, null) > 0;
    }
    public Cursor getAllUsers(){
        return sqLiteDatabase.query(UsersTable.NAME, new String[]{UsersTable.Colunms.KEY_ID, UsersTable.Colunms.KEY_NAME}, null, null, null, null, null);
    }
}
