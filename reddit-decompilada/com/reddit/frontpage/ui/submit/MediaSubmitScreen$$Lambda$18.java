package com.reddit.frontpage.ui.submit;

import android.net.Uri;
import com.reddit.frontpage.util.FileUtil;
import java.util.concurrent.Callable;

final /* synthetic */ class MediaSubmitScreen$$Lambda$18 implements Callable {
    private final Uri f21612a;

    MediaSubmitScreen$$Lambda$18(Uri uri) {
        this.f21612a = uri;
    }

    public final Object call() {
        return FileUtil.m23694a(this.f21612a);
    }
}
