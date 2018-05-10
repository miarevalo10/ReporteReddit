package com.reddit.datalibrary.frontpage.redditauth.api.errors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/reddit/datalibrary/frontpage/redditauth/api/errors/GenericError;", "", "message", "", "error", "", "(Ljava/lang/String;I)V", "getError", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GenericError.kt */
public final class GenericError {
    public final String f10847a;
    private final int f10848b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GenericError) {
            GenericError genericError = (GenericError) obj;
            if (Intrinsics.a(this.f10847a, genericError.f10847a)) {
                if (this.f10848b == genericError.f10848b) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f10847a;
        return ((str != null ? str.hashCode() : 0) * 31) + this.f10848b;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("GenericError(message=");
        stringBuilder.append(this.f10847a);
        stringBuilder.append(", error=");
        stringBuilder.append(this.f10848b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
