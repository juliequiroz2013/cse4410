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


public class DisplayEvent extends Activity {



    DuyDatabaseAdapter duyHelper;
    TextView EventDisplay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_event);

        EventDisplay = (TextView) findViewById(R.id.EventDisplay);
        duyHelper = new DuyDatabaseAdapter(this);
        printeventdatabase();

    }


    public void printeventdatabase(){
        String data = duyHelper.getalleventDUY();
        EventDisplay.setText(data);

    }

}
