package com.reddit.frontpage.util;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/util/Connectivity;", "", "isConnected", "", "isUnmetered", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: NetworkUtil.kt */
public final class Connectivity {
    public final boolean f21708a;
    final boolean f21709b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Connectivity) {
            Connectivity connectivity = (Connectivity) obj;
            if (this.f21708a == connectivity.f21708a) {
                if (this.f21709b == connectivity.f21709b) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f21708a;
        int i2 = 1;
        if (i != 0) {
            i = 1;
        }
        i *= 31;
        boolean z = this.f21709b;
        if (!z) {
            i2 = z;
        }
        return i + i2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Connectivity(isConnected=");
        stringBuilder.append(this.f21708a);
        stringBuilder.append(", isUnmetered=");
        stringBuilder.append(this.f21709b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Connectivity(boolean z, boolean z2) {
        this.f21708a = z;
        this.f21709b = z2;
    }
}
