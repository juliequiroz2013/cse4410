package example.com.tabs;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class LinkFriendToEvent extends ActionBarActivity {
    EditText FriendID,EventID;
    DuyDatabaseAdapter duyHelper;
    TextView FriendDisplayLink;
    TextView EventDisplayLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_friend_to_event);

        FriendDisplayLink = (TextView) findViewById(R.id.FriendDisplayLink);
        EventDisplayLink = (TextView) findViewById(R.id.EventDisplayLink);

        FriendID = (EditText) findViewById(R.id. FriendID);
        EventID = (EditText) findViewById(R.id. EventID);

        duyHelper = new DuyDatabaseAdapter(this);
        printallfriend();
        printallevent();
    }

    private void printallevent() {
        String data = duyHelper.getalleventDUY();
        EventDisplayLink.setText(data);
    }

    public void printallfriend(){


        String data = duyHelper.getallfriendDUY();
        FriendDisplayLink.setText(data);

    }
    public void Addfriendtoevent(View v){
        Integer FID = Integer.valueOf(FriendID.getText().toString());
        Integer EID = Integer.valueOf(EventID.getText().toString());
        Log.d("Duy","FID "+ FID);
        Log.d("Duy","EID "+ EID);
        long id = duyHelper.insert_friend_eventDUY(FID, EID);
        if (id < 0) {
            Message.message(this, "Insert was not success");
        } else {
            Message.message(this, "Insert success");
        }
    }

}
