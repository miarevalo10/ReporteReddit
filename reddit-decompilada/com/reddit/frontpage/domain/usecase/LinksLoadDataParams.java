package com.reddit.frontpage.domain.usecase;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/LinksLoadDataParams;", "Lcom/reddit/frontpage/domain/usecase/Params;", "username", "", "after", "(Ljava/lang/String;Ljava/lang/String;)V", "getAfter", "()Ljava/lang/String;", "getUsername", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinksLoadData.kt */
public final class LinksLoadDataParams implements Params {
    final String f28017a;
    final String f28018b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LinksLoadDataParams) {
                LinksLoadDataParams linksLoadDataParams = (LinksLoadDataParams) obj;
                if (Intrinsics.m26845a(this.f28017a, linksLoadDataParams.f28017a) && Intrinsics.m26845a(this.f28018b, linksLoadDataParams.f28018b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f28017a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f28018b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinksLoadDataParams(username=");
        stringBuilder.append(this.f28017a);
        stringBuilder.append(", after=");
        stringBuilder.append(this.f28018b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public LinksLoadDataParams(String str, String str2) {
        Intrinsics.m26847b(str, "username");
        this.f28017a = str;
        this.f28018b = str2;
    }
}
