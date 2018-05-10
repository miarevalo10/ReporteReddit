package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.CompactLinkView;
import com.reddit.frontpage.presentation.listing.ui.view.LinkHeader;
import com.reddit.frontpage.presentation.listing.ui.view.LinkHeaderView;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0014J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/CrossPostCompactCardLinkViewHolder;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "cardBodyView", "Lcom/reddit/frontpage/presentation/listing/ui/view/CompactLinkView;", "getCardBodyView", "()Lcom/reddit/frontpage/presentation/listing/ui/view/CompactLinkView;", "cardBodyView$delegate", "Lkotlin/Lazy;", "bindLink", "", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "setSubscribeHeader", "showDisplaySubscribeHeader", "", "updateLinkFlairVisibility", "visible", "updateReadStatus", "alpha", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CrossPostCompactCardLinkViewHolder.kt */
public final class CrossPostCompactCardLinkViewHolder extends LinkViewHolder {
    static final /* synthetic */ KProperty[] f36879a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostCompactCardLinkViewHolder.class), "cardBodyView", "getCardBodyView()Lcom/reddit/frontpage/presentation/listing/ui/view/CompactLinkView;"))};
    public static final Companion f36880b = new Companion();
    private final Lazy f36881x;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/CrossPostCompactCardLinkViewHolder$Companion;", "", "()V", "create", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/CrossPostCompactCardLinkViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CrossPostCompactCardLinkViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static CrossPostCompactCardLinkViewHolder m23045a(ViewGroup viewGroup) {
            Intrinsics.m26847b(viewGroup, "parent");
            return new CrossPostCompactCardLinkViewHolder(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.item_cross_post_compact_card, false));
        }
    }

    public static final CrossPostCompactCardLinkViewHolder m37264a(ViewGroup viewGroup) {
        return Companion.m23045a(viewGroup);
    }

    private final CompactLinkView m37265v() {
        return (CompactLinkView) this.f36881x.mo5678b();
    }

    private CrossPostCompactCardLinkViewHolder(View view) {
        super(view);
        this.f36881x = LazyKt.m26777a(new CrossPostCompactCardLinkViewHolder$cardBodyView$2(view));
        Context context = view.getContext();
        view.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                this.m37265v().getLinkHeaderView().m24134b();
                return true;
            }
        });
        view = m37265v();
        view.setViewMediaClickListener(new C1836x7ae49a5e(this, context));
        view.setCrossPostEmbedOnClickListener(new C1837x7ae49a5f(this, context));
        view.setCrossPostThumbnailOnClickListener(new C1838x7ae49a60(this, context));
    }

    public final void mo6963a(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        super.mo6963a(linkPresentationModel);
        m37265v().m22975a(linkPresentationModel);
    }

    protected final void mo6962a(int i) {
        m37265v().setTitleAlpha(i);
    }

    protected final void mo6967b(boolean z) {
        m37265v().setShowLinkFlair(z);
    }

    public final void mo6973c(boolean z) {
        Object obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        z = obj.findViewById(C1761R.id.link_header);
        if (z) {
            m34778a((LinkHeader) (LinkHeaderView) z);
            m34771M().setShowOverflow(false);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.ui.view.LinkHeaderView");
    }
}
