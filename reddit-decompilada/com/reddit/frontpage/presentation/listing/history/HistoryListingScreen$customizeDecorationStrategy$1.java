package com.reddit.frontpage.presentation.listing.history;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: HistoryListingScreen.kt */
final class HistoryListingScreen$customizeDecorationStrategy$1 extends Lambda implements Function1<Integer, Boolean> {
    public static final HistoryListingScreen$customizeDecorationStrategy$1 f36684a = new HistoryListingScreen$customizeDecorationStrategy$1();

    HistoryListingScreen$customizeDecorationStrategy$1() {
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