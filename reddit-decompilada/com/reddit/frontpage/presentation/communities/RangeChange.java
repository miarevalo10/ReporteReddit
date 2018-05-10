package com.reddit.frontpage.presentation.communities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/RangeChange;", "", "type", "Lcom/reddit/frontpage/presentation/communities/RangeChangeType;", "startPosition", "", "numItems", "(Lcom/reddit/frontpage/presentation/communities/RangeChangeType;II)V", "getNumItems", "()I", "getStartPosition", "getType", "()Lcom/reddit/frontpage/presentation/communities/RangeChangeType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Section.kt */
public final class RangeChange {
    public static final Companion f20456a = new Companion();
    private static final RangeChange f20457e = new RangeChange(RangeChangeType.f20461a, -1, -1);
    private final RangeChangeType f20458b;
    private final int f20459c;
    private final int f20460d;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/RangeChange$Companion;", "", "()V", "NONE", "Lcom/reddit/frontpage/presentation/communities/RangeChange;", "getNONE", "()Lcom/reddit/frontpage/presentation/communities/RangeChange;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Section.kt */
    public static final class Companion {
        private Companion() {
        }

        public static RangeChange m22792a() {
            return RangeChange.f20457e;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RangeChange) {
            RangeChange rangeChange = (RangeChange) obj;
            if (Intrinsics.m26845a(this.f20458b, rangeChange.f20458b)) {
                if (this.f20459c == rangeChange.f20459c) {
                    if (this.f20460d == rangeChange.f20460d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        RangeChangeType rangeChangeType = this.f20458b;
        return ((((rangeChangeType != null ? rangeChangeType.hashCode() : 0) * 31) + this.f20459c) * 31) + this.f20460d;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RangeChange(type=");
        stringBuilder.append(this.f20458b);
        stringBuilder.append(", startPosition=");
        stringBuilder.append(this.f20459c);
        stringBuilder.append(", numItems=");
        stringBuilder.append(this.f20460d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public RangeChange(RangeChangeType rangeChangeType, int i, int i2) {
        Intrinsics.m26847b(rangeChangeType, "type");
        this.f20458b = rangeChangeType;
        this.f20459c = i;
        this.f20460d = i2;
    }
}
