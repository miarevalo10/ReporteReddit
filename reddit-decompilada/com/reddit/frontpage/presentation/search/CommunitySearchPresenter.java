package com.reddit.frontpage.presentation.search;

import com.reddit.frontpage.presentation.common.DisposablePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$CommunitySearchItemComparable;", "()V", "areItemContentsEqual", "", "first", "Lcom/reddit/frontpage/presentation/search/CommunitySearchItem;", "second", "areItemsEqual", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitySearchPresenter.kt */
public abstract class CommunitySearchPresenter extends DisposablePresenter {
    public static boolean m34868a(CommunitySearchItem communitySearchItem, CommunitySearchItem communitySearchItem2) {
        Intrinsics.m26847b(communitySearchItem, "first");
        Intrinsics.m26847b(communitySearchItem2, "second");
        return Intrinsics.m26845a((Object) communitySearchItem, (Object) communitySearchItem2);
    }

    public static boolean m34869b(CommunitySearchItem communitySearchItem, CommunitySearchItem communitySearchItem2) {
        Intrinsics.m26847b(communitySearchItem, "first");
        Intrinsics.m26847b(communitySearchItem2, "second");
        return Intrinsics.m26845a((Object) communitySearchItem, (Object) communitySearchItem2);
    }
}
