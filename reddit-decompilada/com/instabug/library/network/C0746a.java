package com.instabug.library.network;

import android.app.IntentService;
import android.content.Intent;
import com.instabug.library.util.InstabugSDKLogger;

/* compiled from: InstabugBackgroundService */
public abstract class C0746a extends IntentService {
    protected abstract boolean mustHaveNetworkConnection();

    public abstract void runBackgroundTask() throws Exception;

    public C0746a() {
        super(C0746a.class.getSimpleName());
        setIntentRedelivery(true);
    }

    public void onCreate() {
        super.onCreate();
        StringBuilder stringBuilder = new StringBuilder("New ");
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" created");
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
    }

    protected void onHandleIntent(Intent intent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" started with intent ");
        stringBuilder.append(intent);
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
        if (!(mustHaveNetworkConnection() == null || NetworkManager.isOnline(this) == null)) {
            InstabugSDKLogger.m8360v(this, "Internet is good to go");
            try {
                intent = new StringBuilder("Starting ");
                intent.append(getClass().getSimpleName());
                intent.append(" task");
                InstabugSDKLogger.m8360v(this, intent.toString());
                runBackgroundTask();
            } catch (Intent intent2) {
                stringBuilder = new StringBuilder("An error occurred while doing ");
                stringBuilder.append(getClass().getSimpleName());
                stringBuilder.append("'s required task ");
                stringBuilder.append(intent2.getMessage());
                InstabugSDKLogger.m8358e(this, stringBuilder.toString(), intent2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" destroyed");
        InstabugSDKLogger.m8360v(this, stringBuilder.toString());
    }
}
