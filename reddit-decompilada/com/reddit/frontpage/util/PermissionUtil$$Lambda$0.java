package com.reddit.frontpage.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

final /* synthetic */ class PermissionUtil$$Lambda$0 implements OnClickListener {
    private final Activity f21777a;

    PermissionUtil$$Lambda$0(Activity activity) {
        this.f21777a = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f21777a.startActivity(new Intent().setAction("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", this.f21777a.getPackageName(), null)));
    }
}
