package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.frontpage.presentation.listing.ui.view.LinkFooterView.OnModerateListener;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"com/reddit/frontpage/presentation/listing/common/PresentationListingAdapter$configure$2", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView$OnModerateListener;", "(Lcom/reddit/frontpage/presentation/listing/common/PresentationListingAdapter;Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;)V", "onApprove", "", "onDistinguishChanged", "setDistinguished", "", "onLockCommentsChanged", "setLockComments", "onMarkNsfwChanged", "setNsfw", "onMarkSpoilerChanged", "setSpoiler", "onRemove", "onRemoveAsSpam", "onStickyChanged", "setStickyPost", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PresentationListingAdapter.kt */
public final class PresentationListingAdapter$configure$2 implements OnModerateListener {
    final /* synthetic */ PresentationListingAdapter f28271a;
    final /* synthetic */ LinkViewHolder f28272b;

    PresentationListingAdapter$configure$2(PresentationListingAdapter presentationListingAdapter, LinkViewHolder linkViewHolder) {
        this.f28271a = presentationListingAdapter;
        this.f28272b = linkViewHolder;
    }

    public final void mo4831a() {
        this.f28271a.mo6937a((ViewHolder) this.f28272b, (Function1) new PresentationListingAdapter$configure$2$onMarkNsfwChanged$1(this));
    }

    public final void mo4832b() {
        this.f28271a.mo6937a((ViewHolder) this.f28272b, (Function1) new PresentationListingAdapter$configure$2$onMarkSpoilerChanged$1(this));
    }

    public final void mo4833c() {
        this.f28271a.mo6937a((ViewHolder) this.f28272b, (Function1) new PresentationListingAdapter$configure$2$onLockCommentsChanged$1(this));
    }

    public final void mo4834d() {
        this.f28271a.mo6937a((ViewHolder) this.f28272b, (Function1) new PresentationListingAdapter$configure$2$onStickyChanged$1(this));
    }

    public final void mo4835e() {
        this.f28271a.mo6937a((ViewHolder) this.f28272b, (Function1) new PresentationListingAdapter$configure$2$onRemove$1(this));
    }

    public final void mo4836f() {
        this.f28271a.mo6937a((ViewHolder) this.f28272b, (Function1) new PresentationListingAdapter$configure$2$onRemoveAsSpam$1(this));
    }

    public final void mo4837g() {
        this.f28271a.mo6937a((ViewHolder) this.f28272b, (Function1) new PresentationListingAdapter$configure$2$onApprove$1(this));
    }

    public final void mo4838h() {
        this.f28271a.mo6937a((ViewHolder) this.f28272b, (Function1) new PresentationListingAdapter$configure$2$onDistinguishChanged$1(this));
    }
}
