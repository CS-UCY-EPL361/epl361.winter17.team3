package com.team3.bra;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Alternation of the BroadcastReceiver class that receives and handles
 * broadcast intents sent by sendBroadcast(Intent). This class is specifically
 * for receiving the accept or ignore choice from the notification that was sent
 * to a waiter.
 *
 */
public class ActionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Order o = (Order) intent.getSerializableExtra("order");
        Waiter w = Waiter.myWaiter;

        NotificationManager nm = (NotificationManager) w.getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(o.getId());

        String action = intent.getAction();
        if (action.equals("Accept")) {
            w.setSelectedOrder(o);
            w.acceptNot(null);
        }
        Intent it = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        context.sendBroadcast(it);
    }

}