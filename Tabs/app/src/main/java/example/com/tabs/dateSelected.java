package example.com.tabs;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.widget.Spinner;


public class dateSelected extends Activity {
    EditText eventName, time;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selected);

        Bundle bundle = getIntent().getExtras();
        date = bundle.getString("date");
        TextView dateText = (TextView) findViewById(R.id.dateSelect);
        dateText.setText(date);

        eventName= (EditText) findViewById(R.id.eventName);
        time=(EditText) findViewById(R.id.time);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_date_selected, menu);
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


    public void sendEvent(View button){
        //do click handling here
        final EditText eventField = (EditText) findViewById(R.id.eventName);
        String name = eventField.getText().toString();

        final Spinner timeSpinner = (Spinner) findViewById(R.id.SpinnerTime);
        String timeType = timeSpinner.getSelectedItem().toString();

//        final EditText feedbackField = (EditText) findViewById(R.id.EditTextFeedbackBody);
//        String feedback = feedbackField.getText().toString();

        finish();
    }
}
