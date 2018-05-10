package com.reddit.frontpage.redditauth_private.ui;

import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import com.reddit.frontpage.RedditThemedActivity;

public class AccountAuthenticatorActivity extends RedditThemedActivity {
    Bundle f40738a = null;
    private AccountAuthenticatorResponse f40739b = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f40739b = (AccountAuthenticatorResponse) getIntent().getParcelableExtra("accountAuthenticatorResponse");
        if (this.f40739b != null) {
            this.f40739b.onRequestContinued();
        }
    }

    public void finish() {
        if (this.f40739b != null) {
            if (this.f40738a != null) {
                this.f40739b.onResult(this.f40738a);
            } else {
                this.f40739b.onError(4, "canceled");
            }
            this.f40739b = null;
        }
        super.finish();
    }
}
