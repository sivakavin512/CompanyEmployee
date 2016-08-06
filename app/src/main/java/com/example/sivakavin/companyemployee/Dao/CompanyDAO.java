package com.example.sivakavin.companyemployee.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sivakavin.companyemployee.Model.Company;

/**
 * Created by sivakavin on 8/6/2016.
 */
public class CompanyDAO {
    public static final String TAG = "CompanyDAO";

    //Database Field
    private SQLiteDatabase mdb;
    private DBHelper dbHelper;
    private Context context;
    private String[] mAllColumns={DBHelper.COLUMN_COMPANY_ID,
            DBHelper.COLUMN_COMPANY_NAME, DBHelper.COLUMN_COMPANY_ADDRESS,
            DBHelper.COLUMN_COMPANY_WEBSITE,
            DBHelper.COLUMN_COMPANY_PHONE_NUMBER };
    Company company=new Company();


    //Construtor of CompanyDAO
    public CompanyDAO(Context context){
        this.context=context;
        dbHelper=new DBHelper(context);
        try {
            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException on openning database " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void open() throws SQLException {
        mdb=dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public Company CreateCompany(String name,String address,String website,String phonenumber ){

        //Value Added in Database Through ContentValue Method
        ContentValues values=new ContentValues();
        values.put(dbHelper.COLUMN_COMPANY_NAME,name);
        values.put(DBHelper.COLUMN_COMPANY_ADDRESS, address);
        values.put(DBHelper.COLUMN_COMPANY_WEBSITE, website);
        values.put(DBHelper.COLUMN_COMPANY_PHONE_NUMBER, phonenumber);
        long insert_id=mdb.insert(dbHelper.TABLE_COMPANIES,null,values);

        //Some Extra Methods
        Cursor cursor=mdb.query(dbHelper.TABLE_COMPANIES,mAllColumns,dbHelper.COLUMN_COMPANY_ID+ " = "+insert_id,null,null,null,null);
        cursor.moveToFirst();
        Company newCompany=cursorToCompany(cursor);
        return newCompany;
    }

    protected Company cursorToCompany(Cursor cursor) {
        Company company = new Company();
        company.setmId(cursor.getLong(0));
        company.setmName(cursor.getString(1));
        company.setmAddress(cursor.getString(2));
        company.setmWebsite(cursor.getString(3));
        company.setmPhoneNumber(cursor.getString(4));
        return company;
    }
}
