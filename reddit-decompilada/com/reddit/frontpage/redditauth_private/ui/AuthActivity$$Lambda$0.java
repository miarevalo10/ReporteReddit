package com.reddit.frontpage.redditauth_private.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.TextView;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ClickEventBuilder;
import com.reddit.frontpage.redditauth_private.account.ForgotPasswordService;

final /* synthetic */ class AuthActivity$$Lambda$0 implements OnClickListener {
    private final AuthActivity f21013a;
    private final TextView f21014b;

    AuthActivity$$Lambda$0(AuthActivity authActivity, TextView textView) {
        this.f21013a = authActivity;
        this.f21014b = textView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface = this.f21013a;
        i = this.f21014b;
        ClickEventBuilder b = AppAnalytics.m21858b();
        b.f19954a = "forgotpassword";
        b.f19955b = "sendresetemail";
        b.m21825a();
        Intent intent = new Intent(dialogInterface, ForgotPasswordService.class);
        intent.putExtra("username", i.getText().toString());
        dialogInterface.startService(intent);
    }
}
