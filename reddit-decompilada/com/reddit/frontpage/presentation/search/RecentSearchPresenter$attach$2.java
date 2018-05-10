package com.reddit.frontpage.presentation.search;

import io.reactivex.functions.BiPredicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "previous", "", "current", "test"}, k = 3, mv = {1, 1, 9})
/* compiled from: RecentSearchPresenter.kt */
final class RecentSearchPresenter$attach$2<T1, T2> implements BiPredicate<String, String> {
    public static final RecentSearchPresenter$attach$2 f28782a = new RecentSearchPresenter$attach$2();

    RecentSearchPresenter$attach$2() {
    }

    public final /* synthetic */ boolean mo4928a(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        Intrinsics.m26847b(str, "previous");
        Intrinsics.m26847b(str2, "current");
        return str.length() == str2.length() ? true : null;
    }
}
