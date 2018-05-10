package com.instabug.library.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import com.instabug.library.core.eventbus.coreeventbus.C0655a;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Network;
import com.instabug.library.network.worker.fetcher.InstabugFeaturesFetcherService;
import com.instabug.library.network.worker.uploader.InstabugSessionUploaderService;
import com.instabug.library.util.InstabugSDKLogger;

public class InstabugNetworkReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        InstabugSDKLogger.m8356d(this, "Network state changed");
        if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null) {
            InstabugSDKLogger.m8356d(this, "ActiveNetwork not equal null, checking local cache");
            context.startService(new Intent(context, InstabugSessionUploaderService.class));
            context.startService(new Intent(context, InstabugFeaturesFetcherService.class));
            C0655a.m8155a(new SDKCoreEvent(Network.TYPE_NETWORK, Network.VALUE_ACTIVATED));
        }
    }
}
