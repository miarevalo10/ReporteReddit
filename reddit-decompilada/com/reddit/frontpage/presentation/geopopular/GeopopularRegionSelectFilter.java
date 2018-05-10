package com.reddit.frontpage.presentation.geopopular;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "", "filter", "", "displayName", "(Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getFilter", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectFilter.kt */
public final class GeopopularRegionSelectFilter {
    public static final Companion f20532c = new Companion();
    private static final GeopopularRegionSelectFilter f20533d = new GeopopularRegionSelectFilter("", "Global");
    public final String f20534a;
    public final String f20535b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter$Companion;", "", "()V", "DEFAULT", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "getDEFAULT", "()Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularRegionSelectFilter.kt */
    public static final class Companion {
        private Companion() {
        }

        public static GeopopularRegionSelectFilter m22843a() {
            return GeopopularRegionSelectFilter.f20533d;
        }
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof GeopopularRegionSelectFilter) {
                GeopopularRegionSelectFilter geopopularRegionSelectFilter = (GeopopularRegionSelectFilter) obj;
                if (Intrinsics.m26845a(this.f20534a, geopopularRegionSelectFilter.f20534a) && Intrinsics.m26845a(this.f20535b, geopopularRegionSelectFilter.f20535b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f20534a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f20535b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("GeopopularRegionSelectFilter(filter=");
        stringBuilder.append(this.f20534a);
        stringBuilder.append(", displayName=");
        stringBuilder.append(this.f20535b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public GeopopularRegionSelectFilter(String str, String str2) {
        Intrinsics.m26847b(str, "filter");
        Intrinsics.m26847b(str2, "displayName");
        this.f20534a = str;
        this.f20535b = str2;
    }
}
