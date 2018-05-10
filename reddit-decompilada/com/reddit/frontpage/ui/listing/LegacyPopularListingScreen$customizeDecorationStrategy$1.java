package com.reddit.frontpage.ui.listing;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "position", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacyPopularListingScreen.kt */
final class LegacyPopularListingScreen$customizeDecorationStrategy$1 extends Lambda implements Function1<Integer, Boolean> {
    public static final LegacyPopularListingScreen$customizeDecorationStrategy$1 f37268a = new LegacyPopularListingScreen$customizeDecorationStrategy$1();

    LegacyPopularListingScreen$customizeDecorationStrategy$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        boolean z = true;
        if (((Number) obj).intValue() <= 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
