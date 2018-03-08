package balakrishnan.harini.currencyconvertion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by harinibalakrishnan on 2/25/18.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    String amount_data;
    String convert;

    @Override
    public void onReceive(Context context, Intent intent) {
        amount_data = intent.getStringExtra("Dollar Amount");
        convert = intent.getStringExtra("Convert To");

        String log = "Action: " + intent.getAction() + "\n" +
                "Dollar Amount: " + amount_data + "\n" +
                "Convert To: " + convert + "\n";

        Log.d( "MyBroadcastReceiver",log);

        Toast.makeText(context, log, Toast.LENGTH_LONG).show();

//        Send the received data from MyBroadcastReceiver class to the MainActivity class
        Intent i = new Intent("MyBroadcastReceiver");
        i.putExtra("Dollar Amount",amount_data);
        i.putExtra("Convert To",convert);
        context.sendBroadcast(i);
    }
}
