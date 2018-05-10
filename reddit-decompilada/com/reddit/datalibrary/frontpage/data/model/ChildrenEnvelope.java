package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B7\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/ChildrenEnvelope;", "T", "", "children", "", "Lcom/reddit/datalibrary/frontpage/data/model/Envelope;", "after", "", "before", "adDistance", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAdDistance", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAfter", "()Ljava/lang/String;", "getBefore", "getChildren", "()Ljava/util/List;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChildrenEnvelope.kt */
public final class ChildrenEnvelope<T> {
    @Json(a = "dist")
    private final Integer adDistance;
    private final String after;
    private final String before;
    private final List<Envelope<T>> children;

    public ChildrenEnvelope(List<? extends Envelope<? extends T>> list, String str, String str2, Integer num) {
        Intrinsics.b(list, "children");
        this.children = list;
        this.after = str;
        this.before = str2;
        this.adDistance = num;
    }

    public final List<Envelope<T>> getChildren() {
        return this.children;
    }

    public final String getAfter() {
        return this.after;
    }

    public final String getBefore() {
        return this.before;
    }

    public final Integer getAdDistance() {
        return this.adDistance;
    }
}
