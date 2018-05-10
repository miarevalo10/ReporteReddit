package com.reddit.frontpage.presentation.search;

import android.support.v7.util.DiffUtil.Callback;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"com/reddit/frontpage/presentation/search/CommunitySearchScreen$diffAndSetItems$diffResult$1", "Landroid/support/v7/util/DiffUtil$Callback;", "(Lcom/reddit/frontpage/presentation/search/CommunitySearchScreen;Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitySearchScreen.kt */
public final class CommunitySearchScreen$diffAndSetItems$diffResult$1 extends Callback {
    final /* synthetic */ CommunitySearchScreen f28759a;
    final /* synthetic */ List f28760b;
    final /* synthetic */ List f28761c;

    CommunitySearchScreen$diffAndSetItems$diffResult$1(CommunitySearchScreen communitySearchScreen, List list, List list2) {
        this.f28759a = communitySearchScreen;
        this.f28760b = list;
        this.f28761c = list2;
    }

    public final boolean m29864a(int i, int i2) {
        this.f28759a.m40916w();
        return CommunitySearchPresenter.m34868a((CommunitySearchItem) this.f28760b.get(i), (CommunitySearchItem) this.f28761c.get(i2));
    }

    public final int m29863a() {
        return this.f28760b.size();
    }

    public final int m29865b() {
        return this.f28761c.size();
    }

    public final boolean m29866b(int i, int i2) {
        this.f28759a.m40916w();
        return CommunitySearchPresenter.m34869b((CommunitySearchItem) this.f28760b.get(i), (CommunitySearchItem) this.f28761c.get(i2));
    }
}
