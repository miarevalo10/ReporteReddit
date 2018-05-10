package com.reddit.frontpage.presentation.common;

import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u0017*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u0017B\u0015\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÂ\u0003J\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\u0016\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/common/LoopingDataSource;", "T", "", "loopedItems", "", "(Ljava/util/List;)V", "firstPosition", "", "getFirstPosition", "()I", "size", "getSize", "component1", "copy", "equals", "", "other", "get", "position", "(I)Ljava/lang/Object;", "hashCode", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LoopingDataSource.kt */
public final class LoopingDataSource<T> {
    public static final Companion f20381c = new Companion();
    public final int f20382a;
    public final List<T> f20383b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/common/LoopingDataSource$Companion;", "", "()V", "loops", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LoopingDataSource.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LoopingDataSource) {
                if (Intrinsics.m26845a(this.f20383b, ((LoopingDataSource) obj).f20383b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List list = this.f20383b;
        return list != null ? list.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LoopingDataSource(loopedItems=");
        stringBuilder.append(this.f20383b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public LoopingDataSource(List<? extends T> list) {
        Intrinsics.m26847b(list, "loopedItems");
        this.f20383b = list;
        this.f20382a = this.f20383b.size() * AbstractSpiCall.DEFAULT_TIMEOUT;
    }

    public /* synthetic */ LoopingDataSource() {
        this(CollectionsKt__CollectionsKt.m26790a());
    }

    public final T m22715a(int i) {
        if ((this.f20383b.isEmpty() ^ 1) != 0) {
            i %= this.f20383b.size();
        }
        return this.f20383b.get(i);
    }
}
