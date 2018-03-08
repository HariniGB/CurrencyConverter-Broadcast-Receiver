package balakrishnan.harini.assignment3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    String convertedAmount;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        convertedAmount = intent.getStringExtra("Converted Amount");
        String log = "Action: " + intent.getAction() + "\n" +
                "Converted Amount: " + convertedAmount + "\n";
        Log.d( "MyReceiver",log);
        Toast.makeText(context, log, Toast.LENGTH_LONG).show();

//        Send the received data from MyBroadcastReceiver class to the MainActivity class
        Intent i = new Intent("MyReceiver");
        i.putExtra("Converted Amount", convertedAmount);
        context.sendBroadcast(i);
    }
}
