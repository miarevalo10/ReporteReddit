package com.reddit.frontpage.presentation.modtools.modqueue.modcommunities;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.communities.Section;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection;
import com.reddit.frontpage.presentation.modtools.modqueue.modcommunities.ModCommunitiesContract.View;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000e*\b\u0012\u0004\u0012\u00020\f0\u000eH\u0002Jf\u0010\u001c\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \u001e*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e0\u000e \u001e*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \u001e*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e0\u000e\u0018\u00010\u001d0\u001d*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u000e0\u001d2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#H\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesContract$View;", "repository", "Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesContract$View;Lcom/reddit/frontpage/domain/repository/SubredditRepository;Lcom/reddit/common/rx/PostExecutionThread;)V", "defaultSection", "Lcom/reddit/frontpage/presentation/communities/Section;", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "sections", "", "username", "", "areCommunitiesTheSame", "", "first", "second", "areCommunityContentsTheSame", "attach", "", "loadCommunities", "onCommunityClicked", "item", "sortCaseInsensitive", "toOrderedPresentationList", "Lio/reactivex/Single;", "kotlin.jvm.PlatformType", "Lcom/reddit/frontpage/domain/model/Subreddit;", "section", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationSection;", "type", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModelType;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModCommunitiesPresenter.kt */
public final class ModCommunitiesPresenter extends DisposablePresenter {
    final View f34079a;
    private final String f34080b;
    private Section<CommunityPresentationModel> f34081c;
    private List<? extends Section<CommunityPresentationModel>> f34082d;
    private final SubredditRepository f34083e;
    private final PostExecutionThread f34084f;

    public static final /* synthetic */ Section m34804a(ModCommunitiesPresenter modCommunitiesPresenter) {
        modCommunitiesPresenter = modCommunitiesPresenter.f34081c;
        if (modCommunitiesPresenter == null) {
            Intrinsics.m26844a("defaultSection");
        }
        return modCommunitiesPresenter;
    }

    @Inject
    public ModCommunitiesPresenter(View view, SubredditRepository subredditRepository, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(subredditRepository, "repository");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        this.f34079a = view;
        this.f34083e = subredditRepository;
        this.f34084f = postExecutionThread;
        view = this.f34079a.mo7395a();
        if (view == null) {
            view = "Reddit for Android";
        }
        this.f34080b = view;
    }

    public static boolean m34808a(CommunityPresentationModel communityPresentationModel, CommunityPresentationModel communityPresentationModel2) {
        Intrinsics.m26847b(communityPresentationModel, "first");
        Intrinsics.m26847b(communityPresentationModel2, "second");
        return Intrinsics.m26845a((Object) communityPresentationModel, (Object) communityPresentationModel2);
    }

    public static boolean m34810b(CommunityPresentationModel communityPresentationModel, CommunityPresentationModel communityPresentationModel2) {
        Intrinsics.m26847b(communityPresentationModel, "first");
        Intrinsics.m26847b(communityPresentationModel2, "second");
        return Intrinsics.m26845a((Object) communityPresentationModel, (Object) communityPresentationModel2);
    }

    public final void attach() {
        Object map = this.f34083e.m22502d(this.f34080b).map(new ModCommunitiesPresenter$toOrderedPresentationList$1(this, CommunityPresentationModelType.f20485c, CommunityPresentationSection.f20493g));
        Intrinsics.m26843a(map, "moderated");
        map = SinglesKt.m24094b(map, this.f34084f).subscribe((Consumer) new ModCommunitiesPresenter$loadCommunities$1(this));
        Intrinsics.m26843a(map, "moderated\n              …nities)\n                }");
        handleDispose(map);
    }
}
