package com.reddit.frontpage.video.mpdparser.data.model;

import com.google.android.exoplayer2.Format;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u00020\u00068VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/video/mpdparser/data/model/ExoFormat;", "Lcom/reddit/frontpage/video/mpdparser/data/model/Format;", "format", "Lcom/google/android/exoplayer2/Format;", "(Lcom/google/android/exoplayer2/Format;)V", "containerMimeType", "", "getContainerMimeType", "()Ljava/lang/String;", "setContainerMimeType", "(Ljava/lang/String;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ExoDashManifest.kt */
public final class ExoFormat implements Format {
    private String f29411a = "";
    private final Format f29412b;

    public ExoFormat(Format format) {
        Intrinsics.m26847b(format, "format");
        this.f29412b = format;
    }

    public final String mo5046a() {
        Object obj = this.f29412b.e;
        Intrinsics.m26843a(obj, "format.containerMimeType");
        return obj;
    }
}
