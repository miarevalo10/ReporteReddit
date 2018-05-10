package com.reddit.frontpage.video.mpdparser.data.model;

import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/video/mpdparser/data/model/ExoAdaptationSet;", "Lcom/reddit/frontpage/video/mpdparser/data/model/SimpleAdaptationSet;", "adaptationSet", "Lcom/google/android/exoplayer2/source/dash/manifest/AdaptationSet;", "(Lcom/google/android/exoplayer2/source/dash/manifest/AdaptationSet;)V", "representations", "", "Lcom/reddit/frontpage/video/mpdparser/data/model/Representation;", "getRepresentations", "()Ljava/util/List;", "setRepresentations", "(Ljava/util/List;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ExoDashManifest.kt */
public final class ExoAdaptationSet extends SimpleAdaptationSet {
    private final AdaptationSet f34495a;

    public ExoAdaptationSet(AdaptationSet adaptationSet) {
        Intrinsics.m26847b(adaptationSet, "adaptationSet");
        this.f34495a = adaptationSet;
    }

    public final List<Representation> mo5047a() {
        Object obj = this.f34495a.c;
        Intrinsics.m26843a(obj, "adaptationSet.representations");
        Iterable<Object> iterable = (Iterable) obj;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Object obj2 : iterable) {
            Intrinsics.m26843a(obj2, "it");
            arrayList.add(new ExoRepresentation(obj2));
        }
        return (List) arrayList;
    }
}
