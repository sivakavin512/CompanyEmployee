package com.example.sivakavin.companyemployee.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sivakavin.companyemployee.R;

public class ListCompaniesActivity extends Activity implements View.OnClickListener {

    private ListView mListviewCompanies;
    private TextView mTxtEmptyListCompanies;
    private ImageButton mBtnAddCompany;

    public static final int REQUEST_CODE_ADD_COMPANY = 40;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_companies);

        //initize the all views
        initView();
    }

    private void initView() {
        this.mListviewCompanies = (ListView) findViewById(R.id.list_companies);
        this.mTxtEmptyListCompanies = (TextView) findViewById(R.id.empty_list_company);
        this.mBtnAddCompany = (ImageButton) findViewById(R.id.btn_add_company);
        this.mBtnAddCompany.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add_company:
                Intent addcompany=new Intent(this,AddCompanyActivity.class);
                startActivityForResult(addcompany,REQUEST_CODE_ADD_COMPANY);
                break;
            default:
                break;
        }
    }
}
