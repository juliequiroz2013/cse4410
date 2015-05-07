package example.com.tabs;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 5/6/2015.
 */
public class viewFriends extends Activity{
    DuyDatabaseAdapter duyHelper;
    String allMyFriends = "";
    ListView friendListView;
    ArrayList<String> friendArrayList;
    ArrayAdapter<String> friendArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_friends);

        duyHelper = new DuyDatabaseAdapter(this);
        friendListView = (ListView) findViewById(R.id.list_view_friends);
        friendArrayList = new ArrayList<String>();
        //friendArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friendArrayList);
        /*allMyFriends = duyHelper.getallfriend();
        TextView friendsText = (TextView) findViewById(R.id.friendsTextView);
        friendsText.setText(allMyFriends);*/
        displayAllFriends();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayAllFriends () {
        //TextView friendsText = (TextView) findViewById(R.id.friendsTextView);
        //duyHelper.deleteFriend("David Inguanzo");

        SQLiteDatabase db = duyHelper.helper.getWritableDatabase();
        String[] col = {"friendname"};
        Cursor cursor = db.query("friends", col, null, null, null, null, null);
        //StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            int index1 = cursor.getColumnIndex("friendname");
            String name = cursor.getString(index1);
            //buffer.append("Name: "+name+"\n");
            //friendsText.setText(name);
            //friendArrayList.add(name);
            allMyFriends+=name+"\n";
        }
        //allMyFriends = duyHelper.getallfriend();
        TextView friendsText = (TextView) findViewById(R.id.friendsTextView);
        friendsText.setText(allMyFriends);
        //friendArrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_view_friends, friendArrayList);
        //friendListView.setAdapter(friendArrayAdapter);
    }
}
