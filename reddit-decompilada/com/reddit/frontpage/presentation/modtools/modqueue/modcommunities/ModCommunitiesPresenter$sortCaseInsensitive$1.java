package com.reddit.frontpage.presentation.modtools.modqueue.modcommunities;

import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "first", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "kotlin.jvm.PlatformType", "second", "compare"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModCommunitiesPresenter.kt */
final class ModCommunitiesPresenter$sortCaseInsensitive$1<T> implements Comparator<CommunityPresentationModel> {
    public static final ModCommunitiesPresenter$sortCaseInsensitive$1 f20911a = new ModCommunitiesPresenter$sortCaseInsensitive$1();

    ModCommunitiesPresenter$sortCaseInsensitive$1() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return String.CASE_INSENSITIVE_ORDER.compare(((CommunityPresentationModel) obj).f20473e, ((CommunityPresentationModel) obj2).f20473e);
    }
}
