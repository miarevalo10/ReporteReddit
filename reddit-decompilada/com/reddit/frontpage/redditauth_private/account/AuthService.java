package com.reddit.frontpage.redditauth_private.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AuthService extends Service {
    private AccountAuthenticator f21006a;

    public void onCreate() {
        super.onCreate();
        this.f21006a = new AccountAuthenticator(this);
    }

    public IBinder onBind(Intent intent) {
        return this.f21006a.getIBinder();
    }
}
