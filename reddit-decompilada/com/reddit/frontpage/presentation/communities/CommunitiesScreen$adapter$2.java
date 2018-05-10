package com.reddit.frontpage.presentation.communities;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$CommunitiesAdapter;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesScreen.kt */
final class CommunitiesScreen$adapter$2 extends Lambda implements Function0<CommunitiesAdapter> {
    final /* synthetic */ CommunitiesScreen f36447a;

    CommunitiesScreen$adapter$2(CommunitiesScreen communitiesScreen) {
        this.f36447a = communitiesScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new CommunitiesAdapter(this.f36447a);
    }
}
