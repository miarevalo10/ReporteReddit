package com.reddit.frontpage.presentation.modtools.modqueue.modcommunities;

import android.support.v7.util.DiffUtil.Callback;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"com/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesScreen$diffAndSetCommunities$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "(Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesScreen;Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModCommunitiesScreen.kt */
public final class ModCommunitiesScreen$diffAndSetCommunities$result$1 extends Callback {
    final /* synthetic */ ModCommunitiesScreen f28678a;
    final /* synthetic */ List f28679b;
    final /* synthetic */ List f28680c;

    ModCommunitiesScreen$diffAndSetCommunities$result$1(ModCommunitiesScreen modCommunitiesScreen, List list, List list2) {
        this.f28678a = modCommunitiesScreen;
        this.f28679b = list;
        this.f28680c = list2;
    }

    public final boolean m29794a(int i, int i2) {
        this.f28678a.m40823w();
        return ModCommunitiesPresenter.m34808a((CommunityPresentationModel) this.f28679b.get(i), (CommunityPresentationModel) this.f28680c.get(i2));
    }

    public final int m29793a() {
        return this.f28678a.f40106x.m29787a();
    }

    public final int m29795b() {
        return this.f28680c.size();
    }

    public final boolean m29796b(int i, int i2) {
        this.f28678a.m40823w();
        return ModCommunitiesPresenter.m34810b((CommunityPresentationModel) this.f28679b.get(i), (CommunityPresentationModel) this.f28680c.get(i2));
    }
}
