package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.TextView;
import com.twitter.sdk.android.core.C2061R;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import io.fabric.sdk.android.Fabric;

public class ShareEmailActivity extends Activity {
    ShareEmailController f23933a;
    private TwitterSession f23934b;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2061R.layout.tw__activity_share_email);
        try {
            bundle = getIntent();
            ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelableExtra("result_receiver");
            if (resultReceiver == null) {
                throw new IllegalArgumentException("ResultReceiver must not be null. This activity should not be started directly.");
            }
            long longExtra = bundle.getLongExtra("session_id", -1);
            bundle = TwitterCore.m31719a();
            TwitterCore.m31720c();
            TwitterSession twitterSession = (TwitterSession) bundle.f30693a.mo5464a(longExtra);
            if (twitterSession == null) {
                StringBuilder stringBuilder = new StringBuilder("No TwitterSession for id:");
                stringBuilder.append(longExtra);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.f23934b = twitterSession;
            this.f23933a = new ShareEmailController(new ShareEmailClient(this.f23934b), resultReceiver);
            TextView textView = (TextView) findViewById(C2061R.id.tw__share_email_desc);
            PackageManager packageManager = getPackageManager();
            textView.setText(getResources().getString(C2061R.string.tw__share_email_desc, new Object[]{packageManager.getApplicationLabel(getApplicationInfo()), this.f23934b.f30704c}));
        } catch (Bundle bundle2) {
            Fabric.m26243b().mo5568c("Twitter", "Failed to create ShareEmailActivity.", bundle2);
            finish();
        }
    }

    public void onClickNotNow(View view) {
        this.f23933a.m25855b();
        finish();
    }

    public void onClickAllow(View view) {
        this.f23933a.m25853a();
        finish();
    }

    public void onBackPressed() {
        this.f23933a.m25855b();
        super.onBackPressed();
    }
}
