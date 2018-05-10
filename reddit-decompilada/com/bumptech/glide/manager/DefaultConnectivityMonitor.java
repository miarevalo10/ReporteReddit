package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener;
import com.bumptech.glide.util.Preconditions;

final class DefaultConnectivityMonitor implements ConnectivityMonitor {
    final ConnectivityListener f16736a;
    boolean f16737b;
    private final Context f16738c;
    private boolean f16739d;
    private final BroadcastReceiver f16740e = new C02771(this);

    class C02771 extends BroadcastReceiver {
        final /* synthetic */ DefaultConnectivityMonitor f3579a;

        C02771(DefaultConnectivityMonitor defaultConnectivityMonitor) {
            this.f3579a = defaultConnectivityMonitor;
        }

        public void onReceive(Context context, Intent intent) {
            intent = this.f3579a.f16737b;
            this.f3579a.f16737b = DefaultConnectivityMonitor.m17037a(context);
            if (intent != this.f3579a.f16737b) {
                if (Log.isLoggable("ConnectivityMonitor", 3) != null) {
                    intent = new StringBuilder("connectivity changed, isConnected: ");
                    intent.append(this.f3579a.f16737b);
                    Log.d("ConnectivityMonitor", intent.toString());
                }
                this.f3579a.f16736a.mo870a(this.f3579a.f16737b);
            }
        }
    }

    public final void mo873c() {
    }

    DefaultConnectivityMonitor(Context context, ConnectivityListener connectivityListener) {
        this.f16738c = context.getApplicationContext();
        this.f16736a = connectivityListener;
    }

    @SuppressLint({"MissingPermission"})
    static boolean m17037a(Context context) {
        try {
            context = ((ConnectivityManager) Preconditions.m3217a((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            if (context == null || context.isConnected() == null) {
                return null;
            }
            return true;
        } catch (Context context2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", context2);
            }
            return true;
        }
    }

    public final void mo871a() {
        if (!this.f16739d) {
            this.f16737b = m17037a(this.f16738c);
            try {
                this.f16738c.registerReceiver(this.f16740e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f16739d = true;
            } catch (Throwable e) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register", e);
                }
            }
        }
    }

    public final void mo872b() {
        if (this.f16739d) {
            this.f16738c.unregisterReceiver(this.f16740e);
            this.f16739d = false;
        }
    }
}
