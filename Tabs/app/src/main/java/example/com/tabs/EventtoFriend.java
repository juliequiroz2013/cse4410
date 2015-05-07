package example.com.tabs;


import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EventtoFriend extends Activity {

    EditText PartyID;
    DuyDatabaseAdapter duyHelper;
    TextView PartyList,PeepInParty,FriendList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventto_friend);

        PartyList = (TextView) findViewById(R.id.PartyList);
        PeepInParty = (TextView) findViewById(R.id.PeepInParty);
        FriendList = (TextView) findViewById(R.id.FriendList);
        PartyID = (EditText) findViewById(R.id.PartyID);

        duyHelper = new DuyDatabaseAdapter(this);

        printallevent();
        printallfriend();
    }
    private void printallevent() {
        String data = duyHelper.getalleventDUY();
        PartyList.setText(data);
    }

    public void PrintPartyInfo(View v){
        Integer PID = Integer.valueOf(PartyID.getText().toString());
        String data = duyHelper.geteventinfoDUY(PID);
        PeepInParty.setText(data);

    }
    public void printallfriend(){


        String data = duyHelper.getallfriendDUY();
        FriendList.setText(data);

    }

}
