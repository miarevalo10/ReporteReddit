package com.reddit.frontpage.presentation.listing.common;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "index", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditModeratorLinkActions.kt */
final class RedditModeratorLinkActions$getValidLinkPresentationPosition$1 extends Lambda implements Function1<Integer, Boolean> {
    final /* synthetic */ List f36592a;

    RedditModeratorLinkActions$getValidLinkPresentationPosition$1(List list) {
        this.f36592a = list;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = ((Number) obj).intValue();
        obj = (obj < null || obj > CollectionsKt__CollectionsKt.m26787a(this.f36592a)) ? null : true;
        return Boolean.valueOf(obj);
    }
}
