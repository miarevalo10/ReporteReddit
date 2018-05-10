package com.birbit.android.jobqueue.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.birbit.android.jobqueue.network.NetworkEventProvider.Listener;

public class NetworkUtilImpl implements NetworkEventProvider, NetworkUtil {
    private Listener f12208a;

    class C02521 extends BroadcastReceiver {
        final /* synthetic */ NetworkUtilImpl f3011a;

        C02521(NetworkUtilImpl networkUtilImpl) {
            this.f3011a = networkUtilImpl;
        }

        public void onReceive(Context context, Intent intent) {
            this.f3011a.m11081b(context);
        }
    }

    class C02543 extends BroadcastReceiver {
        final /* synthetic */ NetworkUtilImpl f3014a;

        C02543(NetworkUtilImpl networkUtilImpl) {
            this.f3014a = networkUtilImpl;
        }

        public void onReceive(Context context, Intent intent) {
            this.f3014a.m11081b(context);
        }
    }

    public NetworkUtilImpl(Context context) {
        context = context.getApplicationContext();
        if (VERSION.SDK_INT >= 21) {
            if (VERSION.SDK_INT >= 23) {
                context.registerReceiver(new C02543(this), new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED"));
            }
            ((ConnectivityManager) context.getSystemService("connectivity")).registerNetworkCallback(new Builder().addCapability(12).addCapability(13).build(), new NetworkCallback(this) {
                final /* synthetic */ NetworkUtilImpl f3013b;

                public void onAvailable(Network network) {
                    this.f3013b.m11081b(context);
                }
            });
            return;
        }
        BroadcastReceiver c02521 = new C02521(this);
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        }
        context.registerReceiver(c02521, intentFilter);
    }

    final void m11081b(Context context) {
        if (this.f12208a != null) {
            Listener listener = this.f12208a;
            mo824a(context);
            listener.mo804a();
        }
    }

    public final void mo825a(Listener listener) {
        this.f12208a = listener;
    }

    public final int mo824a(Context context) {
        int i;
        if (VERSION.SDK_INT >= 23) {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager.isDeviceIdleMode() && !powerManager.isIgnoringBatteryOptimizations(context.getPackageName())) {
                i = 1;
                if (i != 0) {
                    return 0;
                }
                context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (context == null) {
                    return 0;
                }
                if (context.getType() != 1) {
                    if (context.getType() == 9) {
                        return 1;
                    }
                }
                return 2;
            }
        }
        i = 0;
        if (i != 0) {
            return 0;
        }
        context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context == null) {
            return 0;
        }
        if (context.getType() != 1) {
            if (context.getType() == 9) {
                return 1;
            }
        }
        return 2;
    }
}
