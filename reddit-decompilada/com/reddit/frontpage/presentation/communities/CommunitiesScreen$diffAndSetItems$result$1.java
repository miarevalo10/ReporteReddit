package com.reddit.frontpage.presentation.communities;

import android.support.v7.util.DiffUtil.Callback;
import com.reddit.frontpage.presentation.communities.model.CommunityListItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"com/reddit/frontpage/presentation/communities/CommunitiesScreen$diffAndSetItems$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "(Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitiesScreen.kt */
public final class CommunitiesScreen$diffAndSetItems$result$1 extends Callback {
    final /* synthetic */ CommunitiesScreen f28123a;
    final /* synthetic */ List f28124b;
    final /* synthetic */ List f28125c;

    CommunitiesScreen$diffAndSetItems$result$1(CommunitiesScreen communitiesScreen, List list, List list2) {
        this.f28123a = communitiesScreen;
        this.f28124b = list;
        this.f28125c = list2;
    }

    public final boolean m29477a(int i, int i2) {
        this.f28123a.m40578w();
        return CommunitiesPresenter.m34619a((CommunityListItem) this.f28124b.get(i), (CommunityListItem) this.f28125c.get(i2));
    }

    public final int m29476a() {
        return this.f28123a.m40556O().m29467a();
    }

    public final int m29478b() {
        return this.f28125c.size();
    }

    public final boolean m29479b(int i, int i2) {
        this.f28123a.m40578w();
        return CommunitiesPresenter.m34625b((CommunityListItem) this.f28124b.get(i), (CommunityListItem) this.f28125c.get(i2));
    }
}
