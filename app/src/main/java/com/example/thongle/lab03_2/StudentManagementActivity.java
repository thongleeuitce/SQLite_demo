package com.example.thongle.lab03_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thongle.lab03_2.model.Student;
import com.example.thongle.lab03_2.dbase_students.StudentsBaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thongle on 11/04/2017.
 */

public class StudentManagementActivity extends AppCompatActivity {
    private ListView listView_students;
    private TextView textView_students;
    private StudentsBaseAdapter studentsBaseAdapter;
    private List<Student> list_students = new ArrayList<>();
    private ArrayAdapter<Student> arrayAdapter_students;
    private Button button_update;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView_students = (ListView) findViewById(R.id.listview_item);
        textView_students = (TextView) findViewById(R.id.txtv_list);
        button_update = (Button) findViewById(R.id.btn_update);
        textView_students.setText(R.string.students);
        button_update.setVisibility(View.VISIBLE);

        studentsBaseAdapter = new StudentsBaseAdapter(this);
        studentsBaseAdapter.deleteAllStudent();
        addStudents();
        showData();
    }
    public void addStudents(){
        studentsBaseAdapter.addStudent(new Student(1, "Le Van Thong", "KTMT2014"));
        studentsBaseAdapter.addStudent(new Student(2, "Vu Hoang Khanh", "KTMT2014"));
        studentsBaseAdapter.addStudent(new Student(3, "Nguyen Manh Thao", "MTCL2014"));
        studentsBaseAdapter.addStudent(new Student(4, "Tran Vinh Phuc", "MTCL2014"));
        studentsBaseAdapter.addStudent(new Student(5, "Bui Van Xung", "KTMT2013"));
        studentsBaseAdapter.addStudent(new Student(6, "Nguyen Phuc Thinh", "KTMT2013"));
        studentsBaseAdapter.addStudent(new Student(7, "Ton Bao Khuyen", "KTMT2013"));
        studentsBaseAdapter.addStudent(new Student(8, "Nguyen Manh Cuong", "KTMT2013"));
        studentsBaseAdapter.addStudent(new Student(9, "Le Chi Bao", "KTMT2015"));
        studentsBaseAdapter.addStudent(new Student(10, "Vuong Gia Phu", "MTCL2014"));
    }
    public void showData(){
        list_students = studentsBaseAdapter.getAllStudents();
        arrayAdapter_students = new ArrayAdapter<Student>(StudentManagementActivity.this, R.layout.item_list, list_students);
        listView_students.setAdapter(arrayAdapter_students);
    }
}
