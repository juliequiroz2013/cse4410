package example.com.tabs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "example.com.tabs.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onBackPressed() {
        // kill app if backed out from login page
        android.os.Process.killProcess(android.os.Process.myPid());
        //finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    public void confirmLogin(View view){
        //  wrong username/password message
        TextView textView = new TextView(this);
        textView.setTextSize(30);
        textView.setBackgroundColor(getResources().getColor(R.color.light_green));
        textView.setTextColor(getResources().getColor(R.color.white));
        textView.setText("Wrong Username or Password");


        // check username and password
        //Intent intent = new Intent(this, tabs.class);
        EditText editTextUser = (EditText) findViewById(R.id.input_username);
        String userName = editTextUser.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
        if(!userName.equals("test"))
        {
             //  set text view as activity layout - wrong username
            setContentView(textView);
        }
        else
        {
            // check password
            EditText editTextPass = (EditText) findViewById(R.id.input_password);
            String userPass = editTextPass.getText().toString();

            if(!userPass.equals("password"))
            {
                //  set text view as activity layout - wrong password
                setContentView(textView);
            }
            else
            {
                // log user name
                SharedPreferenceData.setUserName(this, userName);
                // exit login
                finish();
            }
        }
    }
}
