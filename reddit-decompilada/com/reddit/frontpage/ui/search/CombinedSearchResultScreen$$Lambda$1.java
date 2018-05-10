package com.reddit.frontpage.ui.search;

import kotlin.jvm.functions.Function1;

final /* synthetic */ class CombinedSearchResultScreen$$Lambda$1 implements Function1 {
    private final CombinedSearchResultScreen f34450a;

    CombinedSearchResultScreen$$Lambda$1(CombinedSearchResultScreen combinedSearchResultScreen) {
        this.f34450a = combinedSearchResultScreen;
    }

    public final Object mo6492a(Object obj) {
        boolean z = true;
        if (((Integer) obj).intValue() < this.f34450a.f39303v.m30371a() - 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
