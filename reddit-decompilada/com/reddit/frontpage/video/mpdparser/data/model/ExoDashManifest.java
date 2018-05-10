package com.reddit.frontpage.video.mpdparser.data.model;

import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\b8VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/video/mpdparser/data/model/ExoDashManifest;", "Lcom/reddit/frontpage/video/mpdparser/data/model/SimpleManifest;", "exoDashManifest", "Lcom/google/android/exoplayer2/source/dash/manifest/DashManifest;", "(Lcom/google/android/exoplayer2/source/dash/manifest/DashManifest;)V", "getExoDashManifest", "()Lcom/google/android/exoplayer2/source/dash/manifest/DashManifest;", "periodCount", "", "getPeriodCount", "()I", "setPeriodCount", "(I)V", "getPeriod", "Lcom/reddit/frontpage/video/mpdparser/data/model/Period;", "index", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ExoDashManifest.kt */
public final class ExoDashManifest extends SimpleManifest {
    private final DashManifest f34496a;

    public ExoDashManifest(DashManifest dashManifest) {
        Intrinsics.m26847b(dashManifest, "exoDashManifest");
        this.f34496a = dashManifest;
    }

    public final int mo5048a() {
        return this.f34496a.a();
    }

    public final Period mo5049a(int i) {
        Object a = this.f34496a.a(i);
        Intrinsics.m26843a(a, "exoDashManifest.getPeriod(index)");
        return new ExoPeriod(a);
    }
}
