package sgrapp.co.ke.sgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by felix.ojiem on 8/29/2017.
 */

public class CallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
       String dialedNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);

        if(dialedNumber.equals("*345#"))
        {
            setResultData(null);
            Intent appIntent = new Intent(context, MainActivity.class);
            appIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(appIntent);
        }
    }
}