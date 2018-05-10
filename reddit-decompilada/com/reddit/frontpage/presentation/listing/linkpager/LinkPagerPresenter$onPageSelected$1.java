package com.reddit.frontpage.presentation.listing.linkpager;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.frontpage.domain.model.Link;
import io.reactivex.functions.Action;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPagerPresenter.kt */
final class LinkPagerPresenter$onPageSelected$1 implements Action {
    final /* synthetic */ LinkPagerPresenter f28424a;
    final /* synthetic */ int f28425b;
    final /* synthetic */ Link f28426c;

    LinkPagerPresenter$onPageSelected$1(LinkPagerPresenter linkPagerPresenter, int i, Link link) {
        this.f28424a = linkPagerPresenter;
        this.f28425b = i;
        this.f28426c = link;
    }

    public final void run() {
        this.f28424a.f33934c.set(this.f28425b, Link.copy$default(this.f28426c, null, null, 0, null, null, null, 0, null, 0, 0, 0, null, null, null, null, null, null, null, null, null, false, 0, false, false, null, null, null, null, null, null, null, null, false, null, null, null, false, false, false, false, false, false, false, false, false, null, null, false, false, false, null, false, false, null, null, null, null, null, false, false, null, null, null, true, -1, RedditJobManager.f10810d, null));
    }
}
