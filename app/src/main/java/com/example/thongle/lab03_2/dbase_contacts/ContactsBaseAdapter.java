package com.example.thongle.lab03_2.dbase_contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.thongle.lab03_2.dbase_contacts.ContactsDbSchema.ContactsTable;
import com.example.thongle.lab03_2.model.Contact;
import com.example.thongle.lab03_2.model.Student;

import java.util.ArrayList;

/**
 * Created by thongle on 15/04/2017.
 */

public class ContactsBaseAdapter {
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public ContactsBaseAdapter(Context m_context){
        this.context = m_context.getApplicationContext();
        sqLiteDatabase = new ContactsBaseHelper(context).getWritableDatabase();
    }
    public void addContact(Contact contact){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactsTable.Colunms.KEY_ID, contact.getId());
        contentValues.put(ContactsTable.Colunms.KEY_NAME, contact.getName());
        contentValues.put(ContactsTable.Colunms.KEY_PHONE_NUMBER, contact.getPhone_number());
        sqLiteDatabase.insert(ContactsTable.NAME, null, contentValues);
    }
    public Contact getContact(int m_id){
        Cursor cursor = sqLiteDatabase.query(ContactsTable.NAME, new String[]{ContactsTable.Colunms.KEY_ID, ContactsTable.Colunms.KEY_NAME, ContactsTable.Colunms.KEY_PHONE_NUMBER}, ContactsTable.Colunms.KEY_ID + "=?", new String[]{String.valueOf(m_id)}, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Contact contact = new Contact(cursor.getInt(cursor.getColumnIndex(ContactsTable.Colunms.KEY_ID)), cursor.getString(cursor.getColumnIndex(ContactsTable.Colunms.KEY_NAME)), cursor.getString(cursor.getColumnIndex(ContactsTable.Colunms.KEY_PHONE_NUMBER)));
        return contact;
    }
    public ArrayList<Contact> getAllContacts(){
        ArrayList<Contact> contacts = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(ContactsTable.NAME, null, null, null, null, null, null, null);
        if (cursor == null)
            return null;
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            contacts.add(new Contact(cursor.getInt(cursor.getColumnIndex(ContactsTable.Colunms.KEY_ID)), cursor.getString(cursor.getColumnIndex(ContactsTable.Colunms.KEY_NAME)), cursor.getString(cursor.getColumnIndex(ContactsTable.Colunms.KEY_PHONE_NUMBER))));
            cursor.moveToNext();
        }
        return contacts;
    }
    public void updateContact(Contact contact){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactsTable.Colunms.KEY_NAME, contact.getName());
        contentValues.put(ContactsTable.Colunms.KEY_PHONE_NUMBER, contact.getPhone_number());
        Cursor cursor = sqLiteDatabase.query(ContactsTable.NAME, new String[]{ContactsTable.Colunms.KEY_ID}, ContactsTable.Colunms.KEY_ID + "=?", new String[]{String.valueOf(contact.getId())}, null, null, null);
        if (cursor == null){
            Toast.makeText(context, "not found contact " + contact.getId(), Toast.LENGTH_SHORT).show();
            return;
        }
        sqLiteDatabase.update(ContactsTable.NAME, contentValues, ContactsTable.Colunms.KEY_ID + "=?", new String[]{String.valueOf(contact.getId())});
    }
    public boolean deleteContact(Contact contact){
        Cursor cursor = sqLiteDatabase.query(ContactsTable.NAME, new String[]{ContactsTable.Colunms.KEY_ID, ContactsTable.Colunms.KEY_NAME, ContactsTable.Colunms.KEY_PHONE_NUMBER}, ContactsTable.Colunms.KEY_ID + "=?", new String[]{String.valueOf(contact.getId())}, null, null, null);
        if(cursor == null)
            return false;
        sqLiteDatabase.delete(ContactsTable.NAME, ContactsTable.Colunms.KEY_ID + "=?", new String[]{String.valueOf(contact.getId())});
        return true;
    }
    public void deleteAllContact(){
        sqLiteDatabase.delete(ContactsTable.NAME, null, null);
    }
}
