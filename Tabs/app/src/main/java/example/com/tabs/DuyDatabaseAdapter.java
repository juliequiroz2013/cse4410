package example.com.tabs;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Duy on 5/1/2015.
 */
public class DuyDatabaseAdapter{
    DuyHelper helper;

    public DuyDatabaseAdapter(Context context){
        helper = new DuyHelper(context);
    }

    public long insertData(String name, String password){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DuyHelper.NAME, name);
        contentValues.put(DuyHelper.PASSWORD, password);
        long id = db.insert(DuyHelper.TABLE_NAME,null,contentValues);
        return id;
    }






    static class DuyHelper  extends SQLiteOpenHelper {
        private static final String DATABASE_NAME= "Groupaldb";
        private static final String TABLE_NAME= "Usertb";
        private static final int DATABASE_VERSION= 12;
        private static final String UID = "Id";
        private static final String NAME="Name";
        private static final String PASSWORD="Password";
        private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ( "+UID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                " "+NAME+" VARCHAR(255)," +
                " "+PASSWORD+" VARCHAR(255));";
        private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME+"";
        private Context context;

        public DuyHelper(Context context){
            super(context, DATABASE_NAME , null, DATABASE_VERSION);
            this.context=context;
            Log.d("Duy", "enter con1");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d("Duy","enter cre");
            try {
                db.execSQL(CREATE_TABLE);
                Message.message(context, "Table create");
            } catch (SQLException e) {
                Message.message(context, ""+e);
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d("Duy","enter update");
            try {
                db.execSQL(DROP_TABLE);
                onCreate(db);
                Message.message(context, "Table update");
            } catch (SQLException e) {
                Message.message(context, ""+e);
            }
        }

    }
}
