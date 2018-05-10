package com.reddit.frontpage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

final /* synthetic */ class GoogleSignInActivity$$Lambda$0 implements OnClickListener {
    private final GoogleSignInActivity f19871a;

    GoogleSignInActivity$$Lambda$0(GoogleSignInActivity googleSignInActivity) {
        this.f19871a = googleSignInActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f19871a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.reddit.frontpage&hl=en")));
    }
}
