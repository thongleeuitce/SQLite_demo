package com.example.thongle.lab03_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thongle.lab03_2.dbase_contacts.ContactsBaseAdapter;
import com.example.thongle.lab03_2.dbase_students.StudentsBaseAdapter;
import com.example.thongle.lab03_2.model.Contact;
import com.example.thongle.lab03_2.model.Student;
import com.example.thongle.lab03_2.dbase_contacts.ContactsDbSchema.ContactsTable;

import java.util.ArrayList;

/**
 * Created by thongle on 11/04/2017.
 */

public class ContactsManagementActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener{
    private ListView listView_contacts;
    private TextView textView_contacts;
    private ContactsBaseAdapter contactsBaseAdapter;
    private ArrayList<Contact> list_contacts = new ArrayList<>();
    private ArrayAdapter<Contact> arrayAdapter_contacts;
    private Button button_update;
    private Button button_delete_all;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView_contacts = (ListView) findViewById(R.id.listview_item);
        textView_contacts = (TextView) findViewById(R.id.txtv_list);
        button_update = (Button) findViewById(R.id.btn_update);
        button_delete_all = (Button) findViewById(R.id.btn_delete_all);

        listView_contacts.setOnItemLongClickListener(this);
        button_update.setOnClickListener(this);
        button_delete_all.setOnClickListener(this);
        textView_contacts.setText(R.string.contacts);
        button_update.setVisibility(View.VISIBLE);
        button_delete_all.setVisibility(View.VISIBLE);

        contactsBaseAdapter = new ContactsBaseAdapter(this);
        contactsBaseAdapter.deleteAllContact();
        addContacts();
        showData();
    }
    public void addContacts(){
        contactsBaseAdapter.addContact(new Contact(1, "Le Van Thong", "01663246912"));
        contactsBaseAdapter.addContact(new Contact(2, "Vu Hoang Khanh", "92910128746"));
        contactsBaseAdapter.addContact(new Contact(3, "Nguyen Manh Thao", "3728237656"));
        contactsBaseAdapter.addContact(new Contact(4, "Tran Vinh Phuc", "23947562334"));
        contactsBaseAdapter.addContact(new Contact(5, "Bui Van Xung", "02384746425"));
        contactsBaseAdapter.addContact(new Contact(6, "Nguyen Phuc Thinh", "938374565562"));
        contactsBaseAdapter.addContact(new Contact(7, "Ton Bao Khuyen", "23764532334"));
        contactsBaseAdapter.addContact(new Contact(8, "Nguyen Manh Cuong", "03938372523"));
        contactsBaseAdapter.addContact(new Contact(9, "Le Chi Bao", "93847263845"));
        contactsBaseAdapter.addContact(new Contact(10, "Vuong Gia Phu", "230948475623"));
        contactsBaseAdapter.addContact(new Contact(11, "Le Van Tai", "095483726344"));
    }
    public void showData(){
        list_contacts = contactsBaseAdapter.getAllContacts();
        arrayAdapter_contacts = new ArrayAdapter<Contact>(ContactsManagementActivity.this, R.layout.item_list, list_contacts);
        listView_contacts.setAdapter(arrayAdapter_contacts);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_update:
                contactsBaseAdapter.updateContact(new Contact(3, "Tran Van A", "8239123824"));
                contactsBaseAdapter.updateContact(new Contact(4, "Tran Van B", "43294243554"));
                contactsBaseAdapter.updateContact(new Contact(5, "Tran Van C", "234242342842"));
                showData();
                break;
            case R.id.btn_delete_all:
                contactsBaseAdapter.deleteAllContact();
                showData();
        }
    }
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        if(contactsBaseAdapter.deleteContact(list_contacts.get(position)) == true)
            Toast.makeText(this, "Deleted contact " + position, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
        showData();
        return false;
    }
}
