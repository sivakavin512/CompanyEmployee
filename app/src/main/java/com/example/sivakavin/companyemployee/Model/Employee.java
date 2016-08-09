package com.example.sivakavin.companyemployee.Model;

import java.io.Serializable;

/**
 * Created by sivakavin on 8/9/2016.
 */
public class Employee implements Serializable{
    //Debugging Common Tag
    public static final String TAG="Employee";

    //Variable to generate getter and Setter Methods
    private long mId;
    private String mFirstName;
    private String mLastName;
    private String mAddress;
    private String mPhoneNumber;
    private String mEmail;
    private double mSalary;
    private Company mCompany;

    public Employee(){}

    public Employee(String firstName, String lastName, String address, String phoneNumber, String email, double salary) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
        this.mAddress = address;
        this.mPhoneNumber = phoneNumber;
        this.mEmail = email;
        this.mSalary = salary;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public double getmSalary() {
        return mSalary;
    }

    public void setmSalary(double mSalary) {
        this.mSalary = mSalary;
    }

    public Company getmCompany() {
        return mCompany;
    }

    public void setmCompany(Company mCompany) {
        this.mCompany = mCompany;
    }


}
