package com.example.duy.tryout;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Duy on 4/30/2015.
 */
/*
public class MyDBHandler extends SQLiteOpenHelper {

    private static final String DATAVASE_NAME= "Groupaldb";
    private static final String DATAVASE_TABLE= "Usertb";
    private static final int DATABASE_VERSION= 1;
    private static final String UID = "Id";
    private static final String Name="Name";
    private static final String CREATE_TABLE="CREATE TABLE"+DATAVASE_NAME+"("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Name+" VARCHAR(255));";
    private static final String DROP_TABLE="DROP TABLE "+TBName+"IF EXISTS";
    private Context context;

    public DuyHelper (Context context){
        super(context, DBNAME , null, DBVERSION);
        this.context=context;
        Message.message(context, "contruct was call");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);

        } catch (SQLException e) {
            Log.d("Duy", "fail to create table");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (SQLException e) {
        }
    }
}
*/
