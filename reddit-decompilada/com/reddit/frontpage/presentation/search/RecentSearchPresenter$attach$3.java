package com.reddit.frontpage.presentation.search;

import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "test"}, k = 3, mv = {1, 1, 9})
/* compiled from: RecentSearchPresenter.kt */
final class RecentSearchPresenter$attach$3<T> implements Predicate<String> {
    public static final RecentSearchPresenter$attach$3 f28783a = new RecentSearchPresenter$attach$3();

    RecentSearchPresenter$attach$3() {
    }

    public final /* synthetic */ boolean test(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "it");
        return ((CharSequence) str).length() == null ? true : null;
    }
}
