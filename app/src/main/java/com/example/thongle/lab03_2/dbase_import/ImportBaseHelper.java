package com.example.thongle.lab03_2.dbase_import;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by thongle on 17/04/2017.
 */

public class ImportBaseHelper extends SQLiteOpenHelper{
    private Context m_context;
    private static final String IMPORT_DB_NAME = "ImportDemo.db";
    private static final String IMPORT_DB_PATH = "/data/data/com.example.thongle.lab03_2/databases/";
    private static final int IMPORT_DB_VERSION = 1;
    public ImportBaseHelper(Context context) throws IOException {
        super(context, IMPORT_DB_NAME, null, IMPORT_DB_VERSION);
        m_context = context;
        this.getReadableDatabase();
        copydatabase();
    }
    private void copydatabase() throws IOException {

        InputStream myinput = m_context.getAssets().open(IMPORT_DB_NAME);

        String outfilename = IMPORT_DB_PATH + IMPORT_DB_NAME;

        OutputStream myoutput = new FileOutputStream(outfilename);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myinput.read(buffer))>0) {
            myoutput.write(buffer, 0, length);
        }
        //Close the streams
        myoutput.flush();
        myoutput.close();
        myinput.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
