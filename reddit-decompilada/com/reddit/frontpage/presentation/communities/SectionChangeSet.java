package com.reddit.frontpage.presentation.communities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/SectionChangeSet;", "", "positionChanged", "", "rangeChange", "Lcom/reddit/frontpage/presentation/communities/RangeChange;", "(Ljava/lang/Integer;Lcom/reddit/frontpage/presentation/communities/RangeChange;)V", "getPositionChanged", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRangeChange", "()Lcom/reddit/frontpage/presentation/communities/RangeChange;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/reddit/frontpage/presentation/communities/RangeChange;)Lcom/reddit/frontpage/presentation/communities/SectionChangeSet;", "equals", "", "other", "hashCode", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Section.kt */
public final class SectionChangeSet {
    private final Integer f20465a;
    private final RangeChange f20466b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SectionChangeSet) {
                SectionChangeSet sectionChangeSet = (SectionChangeSet) obj;
                if (Intrinsics.m26845a(this.f20465a, sectionChangeSet.f20465a) && Intrinsics.m26845a(this.f20466b, sectionChangeSet.f20466b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Integer num = this.f20465a;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        RangeChange rangeChange = this.f20466b;
        if (rangeChange != null) {
            i = rangeChange.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SectionChangeSet(positionChanged=");
        stringBuilder.append(this.f20465a);
        stringBuilder.append(", rangeChange=");
        stringBuilder.append(this.f20466b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SectionChangeSet(Integer num, RangeChange rangeChange) {
        this.f20465a = num;
        this.f20466b = rangeChange;
    }

    private /* synthetic */ SectionChangeSet() {
        this(null, null);
    }
}
