package com.example.thongle.lab03_2.dbase_students;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thongle.lab03_2.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thongle on 14/04/2017.
 */

public class StudentsBaseAdapter {
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public StudentsBaseAdapter(Context m_context){
        this.context = m_context.getApplicationContext();
        sqLiteDatabase = new StudentsBaseHelper(context).getWritableDatabase();
    }
    public void addStudent(Student student){
        ContentValues contentValues = new ContentValues();
        contentValues.put(StudentDbSchema.StudentsTable.Colunms.KEY_ID, student.getId());
        contentValues.put(StudentDbSchema.StudentsTable.Colunms.KEY_NAME, student.getName());
        contentValues.put(StudentDbSchema.StudentsTable.Colunms.KEY_CLASS, student.getClassname());
        sqLiteDatabase.insert(StudentDbSchema.StudentsTable.NAME, null, contentValues);
    }
    public Student getStudent(int m_id){
        Cursor cursor = sqLiteDatabase.query(StudentDbSchema.StudentsTable.NAME, new String[]{StudentDbSchema.StudentsTable.Colunms.KEY_ID, StudentDbSchema.StudentsTable.Colunms.KEY_NAME, StudentDbSchema.StudentsTable.Colunms.KEY_CLASS}, StudentDbSchema.StudentsTable.Colunms.KEY_ID + "=?", new String[]{String.valueOf(m_id)}, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Student student = new Student(cursor.getColumnIndex(StudentDbSchema.StudentsTable.Colunms.KEY_ID), String.valueOf(cursor.getColumnIndex(StudentDbSchema.StudentsTable.Colunms.KEY_NAME)), String.valueOf(cursor.getColumnIndex(StudentDbSchema.StudentsTable.Colunms.KEY_CLASS)));
        return  student;
    }
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(StudentDbSchema.StudentsTable.NAME, null, null, null, null, null, null, null);
        if (cursor == null)
            return null;
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            students.add(new Student(cursor.getInt(cursor.getColumnIndex(StudentDbSchema.StudentsTable.Colunms.KEY_ID)), cursor.getString(cursor.getColumnIndex(StudentDbSchema.StudentsTable.Colunms.KEY_NAME)), cursor.getString(cursor.getColumnIndex(StudentDbSchema.StudentsTable.Colunms.KEY_CLASS))));
            cursor.moveToNext();
        }
        return students;
    }
    public boolean deleteStudent(Student student){
        Cursor cursor = sqLiteDatabase.query(StudentDbSchema.StudentsTable.NAME, new String[]{StudentDbSchema.StudentsTable.Colunms.KEY_ID, StudentDbSchema.StudentsTable.Colunms.KEY_NAME, StudentDbSchema.StudentsTable.Colunms.KEY_CLASS}, StudentDbSchema.StudentsTable.Colunms.KEY_ID + "=?", new String[]{String.valueOf(student.getId())}, null, null, null);
        if(cursor == null)
            return false;
        sqLiteDatabase.delete(StudentDbSchema.StudentsTable.NAME, StudentDbSchema.StudentsTable.Colunms.KEY_ID + "=?", new String[]{String.valueOf(student.getId())});
        return true;
    }
    public void deleteAllStudent(){
        sqLiteDatabase.delete(StudentDbSchema.StudentsTable.NAME, null, null);
    }
}
