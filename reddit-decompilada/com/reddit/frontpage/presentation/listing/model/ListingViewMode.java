package com.reddit.frontpage.presentation.listing.model;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "", "(Ljava/lang/String;I)V", "toString", "", "CARD", "COMPACT", "GALLERY", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingViewMode.kt */
public enum ListingViewMode {
    ;

    public final String toString() {
        String name = name();
        if (name == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        Object toLowerCase = name.toLowerCase();
        Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        return toLowerCase;
    }
}
