package com.example.duy.tryout;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {
    EditText user_name,password;
    DuyDatabaseAdtapter duyHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_name= (EditText) findViewById(R.id.Reg_email);
        password=(EditText) findViewById(R.id.Reg_password);

        duyHelper = new DuyDatabaseAdtapter(this);

    }


    public void addUser(View v){
        String user =  user_name.getText().toString();
        String pass = password.getText().toString();

        long id = duyHelper.insertData(user, pass);
        if(id<0){
            Message.message(this,"Uness");
            Log.d("Duy", "Nope");
        }
        else{
            Message.message(this,"Yus");
            Log.d("Duy", "Fuck");
        }


    }

}
