package com.example.duy.tryout;

import android.widget.Toast;
import android.content.Context;
/**
 * Created by Duy on 4/30/2015.
 */
public class Message {
    public static void message(Context context, String message)
    {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
