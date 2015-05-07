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
    /*
        public long insertData(String name, String password){
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put(DuyHelper.NAME, name);
            contentValues.put(DuyHelper.PASSWORD, password);
            long id = db.insert(DuyHelper.TABLE_NAME,null,contentValues);
            return id;
        }

    */
    public long insert_friend(String name){
        Log.d("Duy", "Enter insert function");
        Log.d("Duy", "Enter insert function "+name +"");
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DuyHelper.FRIEND_NAME, name);
        long id = db.insert(DuyHelper.FRIEND_TABLE,null,contentValues);

        Log.d("Duy", "Exist insert function");
        return id;

    }

    public long insert_event(String name, String date, String time){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DuyHelper.EVENT_NAME, name);
        contentValues.put(DuyHelper.EVENT_DATE, date);
        contentValues.put(DuyHelper.EVENT_TIME, time);
        long id = db.insert(DuyHelper.All_EVENT_TABLE,null,contentValues);
        return id;
    }


    public long insert_link_EventFriend (int friend_id, int event_id){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DuyHelper.EVENT_NAME_FK, event_id);
        contentValues.put(DuyHelper.FRIEND_NAME_FK, friend_id);
        long id = db.insert(DuyHelper.ONE_EVENT_TABLE,null,contentValues);
        return id;
    }



    static class DuyHelper  extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION= 7;
        private static final String DATABASE_NAME= "Groupal1";
        private static final String FRIEND_TABLE= "friends";
        private static final String All_EVENT_TABLE= "allevent";
        private static final String ONE_EVENT_TABLE= "oneevent";

        //FRIEND TABLE

        private static final String FRIEND_NAME="friendname";


        //ALL EVENT TABLE

        private static final String EVENT_NAME="eventname";
        private static final String EVENT_DATE="eventdate";
        private static final String EVENT_TIME="eventtime";

        //ONE EVENT TABLE
        private static final String EVENT_NAME_FK="eventname_fk";
        private static final String FRIEND_NAME_FK="friendname_fk";




        private static final String CREATE_TABLE1="CREATE TABLE "+FRIEND_TABLE+"( id INTEGER PRIMARY KEY AUTOINCREMENT, "+FRIEND_NAME+" VARCHAR(20));";
        private static final String CREATE_TABLE2="CREATE TABLE "+All_EVENT_TABLE+" ( id INTEGER PRIMARY KEY AUTOINCREMENT, "+EVENT_NAME+" VARCHAR(20), "+EVENT_DATE+" VARCHAR(8),  "+EVENT_TIME+" VARCHAR(4));";

        private static final String CREATE_TABLE3="CREATE TABLE "+ONE_EVENT_TABLE+" ( id INTEGER PRIMARY KEY AUTOINCREMENT, "+EVENT_NAME_FK+" INTEGER, "+FRIEND_NAME_FK+" INTEGER," +
                " FOREIGN KEY (`"+EVENT_NAME_FK+"`) REFERENCES "+All_EVENT_TABLE+"(id) ON DELETE NO ACTION ON UPDATE CASCADE, " +
                "FOREIGN KEY (`"+FRIEND_NAME_FK+"`) REFERENCES "+FRIEND_TABLE+"(id) ON DELETE NO ACTION ON UPDATE CASCADE  );";


        // private static final String CREATE_INDEX="ALTER TABLE "+ONE_EVENT_TABLE+" CREATE INDEX PINSE
        //  private static final String MAKE_FK="ALTER TABLE "+ONE_EVENT_TABLE+" ADD CONSTRAINT Event_con FOREIGN KEY (`"+EVENT_NAME_FK+"`) REFERENCES `"+DATABASE_NAME+"`.`"+All_EVENT_TABLE+"`(`id`) ON DELETE NO ACTION ON UPDATE CASCADE;";
        //   private static final String MAKE_FK2=" ALTER TABLE "+ONE_EVENT_TABLE+" ADD CONSTRAINT Friend_con FOREIGN KEY (`"+FRIEND_NAME_FK+"`) REFERENCES `"+DATABASE_NAME+"`.`"+FRIEND_TABLE+"`(`id`) ON DELETE NO ACTION ON UPDATE CASCADE;";


        // private static final String CREATE_ALL_TABLE= " "+CREATE_TABLE1+" "+CREATE_TABLE2+" "+CREATE_TABLE3+" "+MAKE_FK+" ";

    /*    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ( "+UID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                " "+NAME+" VARCHAR(255)," +
                " "+PASSWORD+" VARCHAR(255));";

      */

        private static final String DROP_TABLE="DROP TABLE IF EXISTS "+FRIEND_TABLE+"";
        private static final String  DROP_TABLE2="DROP TABLE IF EXISTS "+All_EVENT_TABLE+"";
        private static final String DROP_TABLE3="DROP TABLE IF EXISTS "+ONE_EVENT_TABLE+"";
        private Context context;

        public DuyHelper(Context context){
            super(context, DATABASE_NAME , null, DATABASE_VERSION);
            this.context=context;
            Log.d("Duy", "enter constructor");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d("Duy","enter creation table");
            try {
                db.execSQL(CREATE_TABLE1);
                db.execSQL(CREATE_TABLE2);
                db.execSQL(CREATE_TABLE3);
                //     db.execSQL(MAKE_FK);
                //      db.execSQL(MAKE_FK2);
                Message.message(context, "Table create");
            } catch (SQLException e) {
                Message.message(context, "Error on creatation");
                Message.message(context, ""+e);
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d("Duy","enter update");
            try {
                db.execSQL(DROP_TABLE);
                db.execSQL(DROP_TABLE2);
                db.execSQL(DROP_TABLE3);
                onCreate(db);
                Message.message(context, "Table update");
            } catch (SQLException e) {
                Message.message(context, "Error on update");
                Message.message(context, ""+e);
            }
        }

    }
}