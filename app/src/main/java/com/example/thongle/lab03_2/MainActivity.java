package com.example.thongle.lab03_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button_users_management;
    private Button button_student_management;
    private Button button_contact_management;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_contact_management = (Button) findViewById(R.id.btn_contact_management);
        button_users_management = (Button) findViewById(R.id.btn_users_management);
        button_student_management = (Button) findViewById(R.id.btn_student_management);

        button_contact_management.setOnClickListener(this);
        button_users_management.setOnClickListener(this);
        button_student_management.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_users_management:
                Intent intent = new Intent(this, UsersManagementAcitivity.class);
                startActivity(intent);
                break;
            case R.id.btn_student_management:
                Intent intent1 = new Intent(this, StudentManagementActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_contact_management:
                Intent intent2 = new Intent(this, ContactManagementActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
