package example.com.tabs;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class RegisterFolk extends Activity {
    EditText user_name,password;
    DuyDatabaseAdapter duyHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_folk);

        user_name= (EditText) findViewById(R.id.Reg_email);

        duyHelper = new DuyDatabaseAdapter(this);

    }


    public void addUser(View v){
        String user =  user_name.getText().toString();

        long id = duyHelper.insert_friend(user);
        if(id<0){
            Message.message(this,"Insert was not success");
            Log.d("Duy", "Not able to insert");
        }
        else{
            Message.message(this,"Insert success");
            Log.d("Duy", "Insert great now yall");
            finish();
        }


    }

}
