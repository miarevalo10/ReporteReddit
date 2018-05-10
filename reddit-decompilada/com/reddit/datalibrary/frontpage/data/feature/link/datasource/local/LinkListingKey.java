package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.feature.common.Key;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LinkListingKey;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;", "path", "", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FileLinkDataSource.kt */
public final class LinkListingKey implements Key {
    private final String f16047a;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LinkListingKey) {
                if (Intrinsics.a(this.f16047a, ((LinkListingKey) obj).f16047a)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f16047a;
        return str != null ? str.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkListingKey(path=");
        stringBuilder.append(this.f16047a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public LinkListingKey(String str) {
        Intrinsics.b(str, "path");
        this.f16047a = str;
    }
}
