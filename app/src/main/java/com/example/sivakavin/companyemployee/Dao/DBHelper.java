package com.example.sivakavin.companyemployee.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sivakavin on 8/6/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String TAG = "DBHelper";

    //Database_creation
    private static final String DATABASE_NAME = "companies.db";
    private static final int DATABASE_VERSION = 1;

    // columns of the companies table
    public static final String TABLE_COMPANIES = "companies";
    public static final String COLUMN_COMPANY_ID = "_id";
    public static final String COLUMN_COMPANY_NAME = "company_name";
    public static final String COLUMN_COMPANY_ADDRESS = "address";
    public static final String COLUMN_COMPANY_WEBSITE = "website";
    public static final String COLUMN_COMPANY_PHONE_NUMBER = "phone_number";

    // SQL statement of the companies table creation
    private static final String SQL_CREATE_TABLE_COMPANIES = "CREATE TABLE " + TABLE_COMPANIES + "("
            + COLUMN_COMPANY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_COMPANY_NAME + " TEXT NOT NULL, "
            + COLUMN_COMPANY_ADDRESS + " TEXT NOT NULL, "
            + COLUMN_COMPANY_WEBSITE + " TEXT NOT NULL, "
            + COLUMN_COMPANY_PHONE_NUMBER + " TEXT NOT NULL "
            +");";

    public DBHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL(SQL_CREATE_TABLE_COMPANIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         Log.w(TAG,"Upgrading the database from version " + oldVersion + " to "+ newVersion);
         db.execSQL("DROP TABLE IF EXITS "+TABLE_COMPANIES);
         onCreate(db);
    }
}
