package com.example.thongle.lab03_2;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thongle.lab03_2.dbase_users.UsersBaseAdapter;
import com.example.thongle.lab03_2.dbase_users.UsersDbSchema.UsersTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thongle on 11/04/2017.
 */

public class UsersManagementAcitivity extends AppCompatActivity {
    private ListView listView_users;
    private TextView textView_users;
    private List<String> list_users;
    private ArrayAdapter<String> arrayAdapter_users;
    private Cursor cursor;
    private UsersBaseAdapter usersBaseAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView_users = (ListView) findViewById(R.id.listview_item);
        textView_users = (TextView) findViewById(R.id.txtv_list);

        usersBaseAdapter = new UsersBaseAdapter(this);
        usersBaseAdapter.deleteAllUsers();
        for(int i = 0; i<= 20; i++){
            usersBaseAdapter.addUser("Hoang Khanh " + i);
        }
        list_users = getAllData();
        showAllData();
    }
    public List<String> getAllData(){
        List<String> users = new ArrayList<>();
        cursor = usersBaseAdapter.getAllUsers();
        while(cursor.moveToNext()){
            users.add(cursor.getString(cursor.getColumnIndex(UsersTable.Colunms.KEY_NAME)));
        }
        return users;
    }
    public void showAllData(){
        textView_users.setText(R.string.users);
        arrayAdapter_users = new ArrayAdapter<String>(UsersManagementAcitivity.this, R.layout.item_list, list_users);
        listView_users.setAdapter(arrayAdapter_users);
    }
}
