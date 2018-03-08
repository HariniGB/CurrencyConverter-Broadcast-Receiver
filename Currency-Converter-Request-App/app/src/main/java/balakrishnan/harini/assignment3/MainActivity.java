package balakrishnan.harini.assignment3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    Spinner convertTo;
    TextView convertedAmount;
    BroadcastReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle b = intent.getExtras();
                if (b != null) {
//                    Assign the input values to the TextView ID on the screen of MainActivity
                    convertedAmount = (TextView) findViewById(R.id.convertedAmount);
                    String display ="Dollar amount $" + amount.getText().toString() + " converted to "+  b.getString("Converted Amount") + " "+ convertTo.getSelectedItem().toString();
                    convertedAmount.setText(display);
                    Log.i("output: ",display);
                }
            }
        };
        this.registerReceiver(br, new IntentFilter("MyReceiver"));
    }

    public void onConvert(View v){
        amount = (EditText) findViewById(R.id.dollar_editText);
        convertTo = (Spinner) findViewById(R.id.spinner);

        Intent intent = new Intent();
//       To identify which broadcast sends and make a particular receiver by matching this sender keyword
        intent.setAction("balakrishnan.harini.assignment3");
//        To change the Android OS and make it compatible for all versions
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.putExtra("Dollar Amount", amount.getText().toString());
        intent.putExtra("Convert To", convertTo.getSelectedItem().toString());
        Log.i("Intent sent: ",String.valueOf(intent.getExtras()));
        sendBroadcast(intent);
    }

    public void closeApp(View v){
        MainActivity.this.finish();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        this.unregisterReceiver(this.br);
    }
}
