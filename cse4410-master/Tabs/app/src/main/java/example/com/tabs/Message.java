package example.com.tabs;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Duy on 5/1/2015.
 */
public class Message {
    public static void message(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
