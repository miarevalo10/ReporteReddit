package com.reddit.frontpage.redditauth_private.account;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon.Builder;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder;
import timber.log.Timber;

public class ForgotPasswordService extends IntentService {
    private static final String f21011a = "ForgotPasswordService";

    public ForgotPasswordService() {
        super(f21011a);
    }

    protected void onHandleIntent(Intent intent) {
        intent = intent.getStringExtra("username");
        if (!TextUtils.isEmpty(intent)) {
            Builder builder = new Builder(Uri.parse("https://www.reddit.com/"));
            builder.a = Config.b;
            try {
                new RequestBuilder(builder.a(), Object.class).a(1).a("api/password").b("name", intent).b("api_type", "json").b();
            } catch (Intent intent2) {
                Timber.c(intent2, "Unable to submit forgot password request", new Object[0]);
            }
        }
    }
}
