package com.reddit.frontpage.video.mpdparser.data.model;

import com.google.android.exoplayer2.source.dash.manifest.Representation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u00020\u00068VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\f8VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/video/mpdparser/data/model/ExoRepresentation;", "Lcom/reddit/frontpage/video/mpdparser/data/model/SimpleRepresentation;", "representation", "Lcom/google/android/exoplayer2/source/dash/manifest/Representation;", "(Lcom/google/android/exoplayer2/source/dash/manifest/Representation;)V", "baseUrl", "", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "format", "Lcom/reddit/frontpage/video/mpdparser/data/model/Format;", "getFormat", "()Lcom/reddit/frontpage/video/mpdparser/data/model/Format;", "setFormat", "(Lcom/reddit/frontpage/video/mpdparser/data/model/Format;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ExoDashManifest.kt */
public final class ExoRepresentation extends SimpleRepresentation {
    private Format f34498a;
    private String f34499b = "";
    private final Representation f34500c;

    public ExoRepresentation(Representation representation) {
        Intrinsics.m26847b(representation, "representation");
        this.f34500c = representation;
        Object obj = this.f34500c.c;
        Intrinsics.m26843a(obj, "representation.format");
        this.f34498a = (Format) new ExoFormat(obj);
    }

    public final Format mo5051a() {
        Object obj = this.f34500c.c;
        Intrinsics.m26843a(obj, "representation.format");
        return new ExoFormat(obj);
    }

    public final String mo5052b() {
        Object obj = this.f34500c.d;
        Intrinsics.m26843a(obj, "representation.baseUrl");
        return obj;
    }
}
