package com.example.sivakavin.companyemployee.Presentation;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by sivakavin on 8/6/2016.
 */
public class Message {

    public void ToastMessage(Context context,String message){
        Toast.makeText(context,""+message,Toast.LENGTH_LONG).show();
    }
}
