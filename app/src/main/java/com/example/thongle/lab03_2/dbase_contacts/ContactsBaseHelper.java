package com.example.thongle.lab03_2.dbase_contacts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.thongle.lab03_2.dbase_contacts.ContactsDbSchema.ContactsTable;

/**
 * Created by thongle on 15/04/2017.
 */

public class ContactsBaseHelper extends SQLiteOpenHelper {
    private static final String CONTACTS_DATABASE_NAME = "Contact.db";
    private static final int CONTACTS_DATABASE_VERSION = 1;
    private static final String CONTACTS_DATABASE_CREATE = "create table " + ContactsTable.NAME + "(" + ContactsTable.Colunms.KEY_ID + " integer primary key autoincrement," + ContactsTable.Colunms.KEY_NAME + " text," + ContactsTable.Colunms.KEY_PHONE_NUMBER + " text" + ")";

    public ContactsBaseHelper(Context context) {
        super(context, CONTACTS_DATABASE_NAME, null, CONTACTS_DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CONTACTS_DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
