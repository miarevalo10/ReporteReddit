package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.domain.model.Subreddit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/frontpage/domain/model/Subreddit;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CategoryLinksLoadData.kt */
final class CategoryLinksLoadData$build$1$multi$1 extends Lambda implements Function1<Subreddit, String> {
    public static final CategoryLinksLoadData$build$1$multi$1 f36334a = new CategoryLinksLoadData$build$1$multi$1();

    CategoryLinksLoadData$build$1$multi$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Subreddit subreddit = (Subreddit) obj;
        Intrinsics.m26847b(subreddit, "it");
        return subreddit.getDisplayName();
    }
}
