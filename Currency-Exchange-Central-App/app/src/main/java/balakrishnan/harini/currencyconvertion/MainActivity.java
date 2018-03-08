package balakrishnan.harini.currencyconvertion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView dollar;
    TextView convert_to;
    double currency = 0.0;
    String convertTo = "Euro";

    MyBroadcastReceiver br = new MyBroadcastReceiver();
    BroadcastReceiver br2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter("android.intent.action.MAIN");
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(br,filter);

        br2 = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle b = intent.getExtras();
                if (b != null) {
//                    To calculate the conversion amount for respective currecncy
                    currency = Double.parseDouble(b.getString("Dollar Amount"));
                    convertTo = b.getString("Convert To");

//                    Assign the input values to the TextView IDs on the screen of MainActivity
                    dollar = (TextView) findViewById(R.id.dollar_amount_value);
                    dollar.setText(b.getString("Dollar Amount"));
                    convert_to= (TextView) findViewById(R.id.convert_to_value);
                    convert_to.setText(convertTo);
                }
            }
        };
        this.registerReceiver(br2, new IntentFilter("MyBroadcastReceiver"));
    }

    public double calculateCurrencyConversion(double  input, String convertCurrencyTo){
        double convertedAmount = 0.0;

        switch (convertCurrencyTo){
            case "British Pound":
                convertedAmount = input * 0.71;
                break;
            case "Euro":
                convertedAmount = input * 0.81;
                break;
            case "Indian Rupee":
                convertedAmount = input * 64.39;
                break;
        }
        return convertedAmount;
    }

    public void onConversion(View v){
        Log.i("Values: ", String.valueOf(currency) + convertTo);
        String convertedAmount = String.valueOf(calculateCurrencyConversion(currency, convertTo));
        Intent intent = new Intent();
//       To identify which broadcast sends and make a particular receiver by matching this sender keyword
        intent.setAction("balakrishnan.harini.currencyconvertion");
//        To change the Android OS and make it compatible for all versions
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.putExtra("Converted Amount", convertedAmount);
        Log.i("Intent sent back: ",String.valueOf(intent.getExtras()));
        sendBroadcast(intent);
    }

    public void closeApp(View v){
        MainActivity.this.finish();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        this.unregisterReceiver(this.br);
        this.unregisterReceiver(this.br2);
    }
}