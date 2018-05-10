package com.reddit.frontpage.util;

import android.widget.ImageView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: AvatarUtil.kt */
final class AvatarUtilKt$setAvatar$1 implements Runnable {
    final /* synthetic */ ImageView f21702a;

    AvatarUtilKt$setAvatar$1(ImageView imageView) {
        this.f21702a = imageView;
    }

    public final void run() {
        this.f21702a.setImageBitmap(AvatarUtilKt.m23656a(this.f21702a));
    }
}
