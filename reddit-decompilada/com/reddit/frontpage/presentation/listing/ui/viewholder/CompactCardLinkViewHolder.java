package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.CompactLinkView;
import com.reddit.frontpage.presentation.listing.ui.view.LinkHeader;
import com.reddit.frontpage.presentation.listing.ui.view.LinkHeaderView;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0010H\u0014J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/CompactCardLinkViewHolder;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "itemView", "Landroid/view/View;", "lastClickPosition", "Lcom/reddit/frontpage/ui/listener/Consumer;", "", "(Landroid/view/View;Lcom/reddit/frontpage/ui/listener/Consumer;)V", "bodyView", "Lcom/reddit/frontpage/presentation/listing/ui/view/CompactLinkView;", "bindLink", "", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "setSubscribeHeader", "showDisplaySubscribeHeader", "", "updateLinkFlairVisibility", "visible", "updateReadStatus", "alpha", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CompactCardLinkViewHolder.kt */
public final class CompactCardLinkViewHolder extends LinkViewHolder {
    public static final Companion f36876a = new Companion();
    private final CompactLinkView f36877b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/CompactCardLinkViewHolder$Companion;", "", "()V", "create", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/CompactCardLinkViewHolder;", "parent", "Landroid/view/ViewGroup;", "lastClickPosition", "Lcom/reddit/frontpage/ui/listener/Consumer;", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CompactCardLinkViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static CompactCardLinkViewHolder m23044a(ViewGroup viewGroup, Consumer<Integer> consumer) {
            Intrinsics.m26847b(viewGroup, "parent");
            Intrinsics.m26847b(consumer, "lastClickPosition");
            return new CompactCardLinkViewHolder(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.item_compact_card_link, false), consumer);
        }
    }

    public static final CompactCardLinkViewHolder m37258a(ViewGroup viewGroup, Consumer<Integer> consumer) {
        return Companion.m23044a(viewGroup, consumer);
    }

    private CompactCardLinkViewHolder(View view, final Consumer<Integer> consumer) {
        super(view);
        Object obj = (CompactLinkView) view.findViewById(C1761R.id.link_card_body);
        Intrinsics.m26843a(obj, "itemView.link_card_body");
        this.f36877b = obj;
        view.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                this.f36877b.getLinkHeaderView().m24134b();
                return true;
            }
        });
        this.f36877b.setViewMediaClickListener(new OnClickListener() {
            public final void onClick(View view) {
                view = this.f34045r;
                if (view != null) {
                    view.mo4828a(this.m34773O());
                }
                consumer.mo4813a(Integer.valueOf(this.d()));
            }
        });
    }

    public final void mo6963a(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        super.mo6963a(linkPresentationModel);
        this.f36877b.m22975a(linkPresentationModel);
    }

    protected final void mo6967b(boolean z) {
        this.f36877b.setShowLinkFlair(z);
    }

    protected final void mo6962a(int i) {
        this.f36877b.setTitleAlpha(i);
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
