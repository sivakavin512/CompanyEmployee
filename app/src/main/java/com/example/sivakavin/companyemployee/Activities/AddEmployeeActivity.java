package com.example.sivakavin.companyemployee.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.sivakavin.companyemployee.R;

/**
 * Created by sivakavin on 8/9/2016.
 */
public class AddEmployeeActivity extends Activity implements View.OnClickListener {
    public static final String TAG = "AddEmployeeActivity";

    EditText firstname,lastname,address,email,phone,salary;
    Spinner compant_list;
    Button adding_emp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        //inlitize the view
        firstname= (EditText) findViewById(R.id.txt_first_name);
        lastname= (EditText) findViewById(R.id.txt_last_name);
        address= (EditText) findViewById(R.id.txt_address);
        email= (EditText) findViewById(R.id.txt_email);
        phone= (EditText) findViewById(R.id.txt_phone_number);
        salary= (EditText) findViewById(R.id.txt_salary);
        compant_list= (Spinner) findViewById(R.id.spinner_companies);
        adding_emp= (Button) findViewById(R.id.btn_add_emp);

        adding_emp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add_emp:

                break;
        }
    }
}
