package com.example.sivakavin.companyemployee.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sivakavin.companyemployee.Dao.CompanyDAO;
import com.example.sivakavin.companyemployee.Model.Company;
import com.example.sivakavin.companyemployee.Presentation.Message;
import com.example.sivakavin.companyemployee.R;

/**
 * Created by sivakavin on 8/6/2016.
 */
public class AddCompanyActivity extends Activity implements View.OnClickListener {
    public static final String TAG = "AddCompanyActivity";

    private EditText mTxtCompanyName;
    private EditText mTxtAddress;
    private EditText mTxtPhoneNumber;
    private EditText mTxtWebsite;
    private Button mBtnAdd;
    Message message=new Message();

    private CompanyDAO mCompanyDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);
        initViews();
        this.mCompanyDAO=new CompanyDAO(this);
    }

    private void initViews() {
        this.mTxtCompanyName = (EditText) findViewById(R.id.txt_company_name);
        this.mTxtAddress = (EditText) findViewById(R.id.txt_address);
        this.mTxtPhoneNumber = (EditText) findViewById(R.id.txt_phone_number);
        this.mTxtWebsite = (EditText) findViewById(R.id.txt_website);
        this.mBtnAdd = (Button) findViewById(R.id.btn_add);
        this.mBtnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                Editable companyName = mTxtCompanyName.getText();
                Editable address = mTxtAddress.getText();
                Editable phoneNumber = mTxtPhoneNumber.getText();
                Editable website = mTxtWebsite.getText();

                if(!TextUtils.isEmpty(companyName) && !TextUtils.isEmpty(address) && !TextUtils.isEmpty(phoneNumber) && !TextUtils.isEmpty(website)){
                    //Add Company To Database
                    Company createCompany=mCompanyDAO.CreateCompany(companyName.toString(),address.toString(),phoneNumber.toString(),website.toString());
                    Log.d(TAG, "added company : "+ createCompany.getmName());

                    message.ToastMessage(this,"Sucessfully Inserted");
                }else{
                    message.ToastMessage(this,"One or More Field are empty");
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompanyDAO.close();
    }
}
