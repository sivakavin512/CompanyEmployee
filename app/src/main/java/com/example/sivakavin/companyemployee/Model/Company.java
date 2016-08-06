package com.example.sivakavin.companyemployee.Model;

import java.io.Serializable;

/**
 * Created by sivakavin on 8/6/2016.
 */
public class Company implements Serializable {
     public static final String TAG="Employee";

     private long mId;
     private String mName;
     private String mAddress;
     private String mPhoneNumber;
     private String mWebsite;

    //Construtor methods
    public Company(){}

    public  Company(String name,String address,String phonenum,String website){
        this.mName=name;
        this.mAddress=address;
        this.mPhoneNumber=phonenum;
        this.mWebsite=website;
    }


   //Getter and Setter method for Company
    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
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

    public String getmWebsite() {
        return mWebsite;
    }

    public void setmWebsite(String mWebsite) {
        this.mWebsite = mWebsite;
    }

}
