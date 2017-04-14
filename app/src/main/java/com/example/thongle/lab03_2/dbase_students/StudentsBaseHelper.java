package com.example.thongle.lab03_2.dbase_students;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thongle on 14/04/2017.
 */

public class StudentsBaseHelper extends SQLiteOpenHelper {
    private static final String STUDENTS_DATABASE_NAME = "StudentsBase.db";
    private static final int STUDENtS_DATABASE_VERSION = 1;
    private static final String STUDENtS_DATABASE_CREATE = "create table " + StudentDbSchema.StudentsTable.NAME + "(" + StudentDbSchema.StudentsTable.Colunms.KEY_ID + " integer primary key," + StudentDbSchema.StudentsTable.Colunms.KEY_NAME + " text," + StudentDbSchema.StudentsTable.Colunms.KEY_CLASS + " text" + ")";

    public StudentsBaseHelper(Context context) {
        super(context, STUDENTS_DATABASE_NAME, null, STUDENtS_DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(STUDENtS_DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
