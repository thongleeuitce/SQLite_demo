package com.example.thongle.lab03_2;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thongle.lab03_2.dbase_import.ImportBaseHelper;

import java.io.IOException;

/**
 * Created by thongle on 17/04/2017.
 */

public class ImportDbActivity extends AppCompatActivity {
    private SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        try {
            sqLiteDatabase = new ImportBaseHelper(this).getWritableDatabase();
            Toast.makeText(this, "Imported database", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
