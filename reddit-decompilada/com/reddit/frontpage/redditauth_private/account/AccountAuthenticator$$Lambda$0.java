package com.reddit.frontpage.redditauth_private.account;

import android.widget.Toast;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;

final /* synthetic */ class AccountAuthenticator$$Lambda$0 implements Runnable {
    private final AccountAuthenticator f21004a;

    AccountAuthenticator$$Lambda$0(AccountAuthenticator accountAuthenticator) {
        this.f21004a = accountAuthenticator;
    }

    public final void run() {
        Toast.makeText(FrontpageApplication.f27402a, this.f21004a.f21005a.getString(C1761R.string.label_servers_down), 1).show();
    }
}
