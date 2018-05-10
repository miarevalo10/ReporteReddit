package com.reddit.frontpage.ui.submit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.common.collect.ObjectArrays;
import com.reddit.frontpage.util.PermissionUtil;
import com.reddit.frontpage.util.ShareType;

final /* synthetic */ class MediaSubmitScreen$$Lambda$2 implements OnClickListener {
    private final MediaSubmitScreen f21614a;

    MediaSubmitScreen$$Lambda$2(MediaSubmitScreen mediaSubmitScreen) {
        this.f21614a = mediaSubmitScreen;
    }

    public final void onClick(View view) {
        view = this.f21614a;
        PermissionUtil.m23861a(view.am_());
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) ObjectArrays.a(ShareType.f21796c.f21800e, ShareType.f21797d.f21800e, String.class));
        view.a(Intent.createChooser(intent, null), 2);
    }
}
