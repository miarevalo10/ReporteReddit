package com.reddit.frontpage.presentation.listing.util;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/util/Size;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkPreviewUtil.kt */
public final class Size {
    final int f20856a;
    final int f20857b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.f20856a == size.f20856a) {
                if (this.f20857b == size.f20857b) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f20856a * 31) + this.f20857b;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Size(width=");
        stringBuilder.append(this.f20856a);
        stringBuilder.append(", height=");
        stringBuilder.append(this.f20857b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Size(int i, int i2) {
        this.f20856a = i;
        this.f20857b = i2;
    }
}
