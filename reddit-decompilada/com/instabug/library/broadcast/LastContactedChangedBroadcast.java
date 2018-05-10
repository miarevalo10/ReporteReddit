package com.instabug.library.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.instabug.library.util.InstabugSDKLogger;

public class LastContactedChangedBroadcast extends BroadcastReceiver {
    public static final String LAST_CONTACTED_AT = "last_contacted_at";
    public static final String LAST_CONTACTED_CHANGED = "User last contact at changed";
    private C0646a mLastContactedMonitor;

    public interface C0646a {
    }

    public LastContactedChangedBroadcast(C0646a c0646a) {
        this.mLastContactedMonitor = c0646a;
    }

    public void onReceive(Context context, Intent intent) {
        InstabugSDKLogger.m8360v(this, " - onReceive");
    }
}
