package io.pello.android.connectivitycheck;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewStatus = (TextView) findViewById(R.id.textViewStatus);

    }

    public void checkConnectivity (View view) {
        String message = "";
        textViewStatus.setText("");

        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork.isConnectedOrConnecting();
        message = "Is connected";

        Log.d("PELLODEBUG", message);

        switch (activeNetwork.getType()) {
            case ConnectivityManager.TYPE_WIFI:
                message += "WIFI connection";
                    break;
            case ConnectivityManager.TYPE_BLUETOOTH:
                message += "BLUETOOTH connection";
                break;
            case ConnectivityManager.TYPE_ETHERNET:
                message += "ETHERNET connection";
                break;
            case ConnectivityManager.TYPE_WIMAX:
                message += "WIMAX connection";
                break;
            case ConnectivityManager.TYPE_DUMMY:
                message += "DUMMY connection";
                break;
            case ConnectivityManager.TYPE_MOBILE:
                message += "MOBILE connection";
                break;
            case ConnectivityManager.TYPE_MOBILE_DUN:
                message += "MOBILE DUN connection";
                break;
            default:
                    message += "Unknown connection";
                break;
        }

        message += "\nType: " + activeNetwork.getTypeName();
        message += "\nExtra Info: " + activeNetwork.getExtraInfo().toString();
        message += "\nDetailed State: " + activeNetwork.getDetailedState().toString();

        textViewStatus.setText(message);

    }
}
