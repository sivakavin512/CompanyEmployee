package com.example.sivakavin.companyemployee.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.sivakavin.companyemployee.R;

/**
 * Created by sivakavin on 8/9/2016.
 */
public class ListEmployeesActivity extends Activity implements View.OnClickListener {


    public static final int request_code=50;
    ImageButton add_employee;
    ListView list_employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_emloyee);
        //initize the view objects
        add_employee= (ImageButton) findViewById(R.id.btn_add_employee);
        list_employee= (ListView) findViewById(R.id.list_employees);

        //Listener
        add_employee.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add_employee:
                Intent add_emp=new Intent(this,AddEmployeeActivity.class);
                startActivityForResult(add_emp,request_code);
                break;
        }
    }
}
