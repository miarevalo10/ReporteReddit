package com.bumptech.glide.manager;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener;

public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {
    public final ConnectivityMonitor mo1005a(Context context, ConnectivityListener connectivityListener) {
        Object obj = ContextCompat.m713a(context, "android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : null;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", obj != null ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return obj != null ? new DefaultConnectivityMonitor(context, connectivityListener) : new NullConnectivityMonitor();
    }
}
