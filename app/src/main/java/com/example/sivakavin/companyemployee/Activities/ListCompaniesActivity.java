package com.example.sivakavin.companyemployee.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sivakavin.companyemployee.Adapters.ListCompaniesAdapter;
import com.example.sivakavin.companyemployee.Dao.CompanyDAO;
import com.example.sivakavin.companyemployee.Model.Company;
import com.example.sivakavin.companyemployee.R;

import java.util.ArrayList;
import java.util.List;

public class ListCompaniesActivity extends Activity implements View.OnClickListener {

    private ListView mListviewCompanies;
    private TextView mTxtEmptyListCompanies;
    private ImageButton mBtnAddCompany;

    private CompanyDAO mCompanyDAO;
    private List<Company> mListCompanies;
    private ListCompaniesAdapter adapter;
    public static final int REQUEST_CODE_ADD_COMPANY = 40;
    public static final String EXTRA_ADDED_COMPANY = "extra_key_added_company";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_companies);

        //initize the all views
        initView();


        //Fill the listview
        this.mCompanyDAO=new CompanyDAO(this);
        mListCompanies=mCompanyDAO.getAllCompanies();
        if(mListCompanies != null && !mListCompanies.isEmpty()){
             adapter=new ListCompaniesAdapter(this,mListCompanies);
             mListviewCompanies.setAdapter(adapter);
            mTxtEmptyListCompanies.setVisibility(View.INVISIBLE);
        }else{
                mListviewCompanies.setVisibility(View.INVISIBLE);
                mTxtEmptyListCompanies.setVisibility(View.VISIBLE);
        }
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

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_CODE_ADD_COMPANY){
            if(requestCode == RESULT_OK){
                // add the added company to the listCompanies and refresh the listView
                if(data != null){
                    Company createdCompany= (Company) data.getSerializableExtra(EXTRA_ADDED_COMPANY);
                    if(createdCompany != null) {
                        if(mListCompanies == null)
                            mListCompanies = new ArrayList<Company>();
                        mListCompanies.add(createdCompany);

                        if(adapter == null) {
                            if(mListviewCompanies.getVisibility() != View.VISIBLE) {
                                //Visiblity Changing here
                                mListviewCompanies.setVisibility(View.VISIBLE);
                                mTxtEmptyListCompanies.setVisibility(View.GONE);
                            }

                            adapter = new ListCompaniesAdapter(this, mListCompanies);
                            mListviewCompanies.setAdapter(adapter);
                        }
                        else {
                            adapter.setItems(mListCompanies);
                            adapter.notifyDataSetChanged();
                            adapter.notifyDataSetInvalidated();
                        }
                    }
                }
            }else {
                super.onActivityResult(requestCode, resultCode, data);
            }

        }
    }
}
