package com.example.thongle.lab03_2.dbase_users;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thongle on 14/04/2017.
 */

public class UsersBaseHelper extends SQLiteOpenHelper {
    private static final String USERS_DATABASE_NAME = "UsersBase.db";
    private static final int USERS_DATABASE_VERSION = 1;
    private static final String USERS_DATABASE_CREATE = "create table " + UsersDbSchema.UsersTable.NAME + "(" + UsersDbSchema.UsersTable.Colunms.KEY_ID + " integer primary key autoincrement, " + UsersDbSchema.UsersTable.Colunms.KEY_NAME + " text not null" + ")";

    public UsersBaseHelper(Context context) {
        super(context, USERS_DATABASE_NAME, null, USERS_DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USERS_DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
