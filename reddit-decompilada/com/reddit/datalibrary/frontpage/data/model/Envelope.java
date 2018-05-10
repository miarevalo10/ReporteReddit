package com.reddit.datalibrary.frontpage.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/Envelope;", "T", "", "data", "kind", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getKind", "()Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Envelope.kt */
public final class Envelope<T> {
    private final T data;
    private final String kind;

    public Envelope(T t, String str) {
        this.data = t;
        this.kind = str;
    }

    public final T getData() {
        return this.data;
    }

    public /* synthetic */ Envelope(Object obj, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            str = null;
        }
        this(obj, str);
    }

    public final String getKind() {
        return this.kind;
    }
}
