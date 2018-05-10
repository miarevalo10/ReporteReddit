package com.reddit.frontpage;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import timber.log.Timber;

final /* synthetic */ class GoogleSignInActivity$$Lambda$1 implements OnClickListener {
    private final GoogleSignInActivity f19872a;

    GoogleSignInActivity$$Lambda$1(GoogleSignInActivity googleSignInActivity) {
        this.f19872a = googleSignInActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface = this.f19872a;
        i = Auth.h.silentSignIn(dialogInterface.f40544a);
        if (i.a()) {
            Timber.b("Got cached sign-in", new Object[0]);
            dialogInterface.m41952a((GoogleSignInResult) i.b());
            return;
        }
        if (dialogInterface.f40545b == null) {
            dialogInterface.f40545b = new ProgressDialog(dialogInterface);
            dialogInterface.f40545b.setMessage("Starting Google login...");
            dialogInterface.f40545b.setIndeterminate(true);
        }
        dialogInterface.f40545b.show();
        i.a(new GoogleSignInActivity$$Lambda$2(dialogInterface));
    }
}
