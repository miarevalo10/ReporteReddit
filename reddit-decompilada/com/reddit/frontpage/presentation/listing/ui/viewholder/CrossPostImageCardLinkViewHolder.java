package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.SmallCardBodyView;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/CrossPostImageCardLinkViewHolder;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "cardBodyView", "Lcom/reddit/frontpage/presentation/listing/ui/view/SmallCardBodyView;", "getCardBodyView", "()Lcom/reddit/frontpage/presentation/listing/ui/view/SmallCardBodyView;", "cardBodyView$delegate", "Lkotlin/Lazy;", "bindLink", "", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "updateLinkFlairVisibility", "visible", "", "updateReadStatus", "alpha", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CrossPostImageCardLinkViewHolder.kt */
public final class CrossPostImageCardLinkViewHolder extends LinkViewHolder {
    static final /* synthetic */ KProperty[] f36883a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostImageCardLinkViewHolder.class), "cardBodyView", "getCardBodyView()Lcom/reddit/frontpage/presentation/listing/ui/view/SmallCardBodyView;"))};
    public static final Companion f36884b = new Companion();
    private final Lazy f36885x;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/CrossPostImageCardLinkViewHolder$Companion;", "", "()V", "create", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/CrossPostImageCardLinkViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CrossPostImageCardLinkViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static CrossPostImageCardLinkViewHolder m23046a(ViewGroup viewGroup) {
            Intrinsics.m26847b(viewGroup, "parent");
            return new CrossPostImageCardLinkViewHolder(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.item_xpost_image_card, false));
        }
    }

    public static final CrossPostImageCardLinkViewHolder m37270a(ViewGroup viewGroup) {
        return Companion.m23046a(viewGroup);
    }

    private final SmallCardBodyView m37271v() {
        return (SmallCardBodyView) this.f36885x.mo5678b();
    }

    private CrossPostImageCardLinkViewHolder(View view) {
        super(view);
        this.f36885x = LazyKt.m26777a(new CrossPostImageCardLinkViewHolder$cardBodyView$2(view));
        m37271v().setCrossPostPreviewOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                view = this.m34773O().am;
                if (view == null) {
                    Intrinsics.m26842a();
                }
                OnViewMediaListener onViewMediaListener = this.f34045r;
                if (onViewMediaListener != null) {
                    onViewMediaListener.mo4828a(view);
                }
            }
        });
        m37271v().setCrossPostEmbedOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                view = this.m34773O().am;
                if (view == null) {
                    Intrinsics.m26842a();
                }
                OnViewMediaListener onViewMediaListener = this.f34045r;
                if (onViewMediaListener != null) {
                    onViewMediaListener.mo4830c(view);
                }
            }
        });
    }

    public final void mo6963a(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        super.mo6963a(linkPresentationModel);
        m37271v().m23043a(linkPresentationModel);
    }

    protected final void mo6962a(int i) {
        m37271v().setTitleAlpha(i);
    }

    protected final void mo6967b(boolean z) {
        m37271v().setShowLinkFlair(z);
    }
}
