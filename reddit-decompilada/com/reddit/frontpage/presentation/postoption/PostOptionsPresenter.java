package com.reddit.frontpage.presentation.postoption;

import com.reddit.frontpage.domain.model.PostPermissions;
import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.presentation.postoption.PostOptionsContract.Parameters;
import com.reddit.frontpage.presentation.postoption.PostOptionsContract.View;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/postoption/PostOptionsPresenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "Lcom/reddit/frontpage/presentation/postoption/PostOptionsContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/postoption/PostOptionsContract$View;", "params", "Lcom/reddit/frontpage/presentation/postoption/PostOptionsContract$Parameters;", "postOptionsNavigator", "Lcom/reddit/frontpage/presentation/postoption/PostOptionsNavigator;", "(Lcom/reddit/frontpage/presentation/postoption/PostOptionsContract$View;Lcom/reddit/frontpage/presentation/postoption/PostOptionsContract$Parameters;Lcom/reddit/frontpage/presentation/postoption/PostOptionsNavigator;)V", "attach", "", "detach", "onImageSelected", "onLinkSelected", "onTextSelected", "onVideoSelected", "setupOptionsForSubreddit", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PostOptionsPresenter.kt */
public final class PostOptionsPresenter implements BasePresenter {
    public static final Companion f28732c = new Companion();
    final Parameters f28733a;
    final PostOptionsNavigator f28734b;
    private final View f28735d;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/postoption/PostOptionsPresenter$Companion;", "", "()V", "DEFAULT_DESTINATION", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: PostOptionsPresenter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final void destroy() {
    }

    public final void detach() {
    }

    @Inject
    public PostOptionsPresenter(View view, Parameters parameters, PostOptionsNavigator postOptionsNavigator) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(parameters, "params");
        Intrinsics.m26847b(postOptionsNavigator, "postOptionsNavigator");
        this.f28735d = view;
        this.f28733a = parameters;
        this.f28734b = postOptionsNavigator;
    }

    public final void attach() {
        if (this.f28733a.f20958a == null) {
            this.f28735d.mo6977a("Reddit", null);
            this.f28735d.mo6976a();
            return;
        }
        this.f28735d.mo6977a(this.f28733a.f20958a.getDisplayNamePrefixed(), this.f28733a.f20958a.getKeyColor());
        PostPermissions postPermissions = this.f28733a.f20958a.getPostPermissions();
        this.f28735d.mo6978a(postPermissions.getLinks());
        this.f28735d.mo6979b(postPermissions.getImages());
        this.f28735d.mo6980c(postPermissions.getVideos());
        this.f28735d.mo6981d(postPermissions.getText());
    }
}
