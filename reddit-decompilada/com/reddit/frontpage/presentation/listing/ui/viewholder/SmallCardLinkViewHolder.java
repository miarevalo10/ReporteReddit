package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.SmallCardBodyView;
import com.reddit.frontpage.ui.listener.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0006H\u0014R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/SmallCardLinkViewHolder;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "itemView", "Landroid/view/View;", "lastClickPositionListener", "Lcom/reddit/frontpage/ui/listener/Consumer;", "", "(Landroid/view/View;Lcom/reddit/frontpage/ui/listener/Consumer;)V", "cardBodyView", "Lcom/reddit/frontpage/presentation/listing/ui/view/SmallCardBodyView;", "getCardBodyView", "()Lcom/reddit/frontpage/presentation/listing/ui/view/SmallCardBodyView;", "cardBodyView$delegate", "Lkotlin/Lazy;", "bindLink", "", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "updateLinkFlairVisibility", "visible", "", "updateReadStatus", "alpha", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SmallCardLinkViewHolder.kt */
public final class SmallCardLinkViewHolder extends LinkViewHolder {
    static final /* synthetic */ KProperty[] f36919a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SmallCardLinkViewHolder.class), "cardBodyView", "getCardBodyView()Lcom/reddit/frontpage/presentation/listing/ui/view/SmallCardBodyView;"))};
    public static final Companion f36920b = new Companion();
    private final Lazy f36921x;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/SmallCardLinkViewHolder$Companion;", "", "()V", "create", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/SmallCardLinkViewHolder;", "parent", "Landroid/view/ViewGroup;", "lastClickPositionListener", "Lcom/reddit/frontpage/ui/listener/Consumer;", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SmallCardLinkViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static SmallCardLinkViewHolder m23063a(ViewGroup viewGroup, Consumer<Integer> consumer) {
            Intrinsics.m26847b(viewGroup, "parent");
            Intrinsics.m26847b(consumer, "lastClickPositionListener");
            Object inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_small_card_link, viewGroup, false);
            Intrinsics.m26843a(inflate, "view");
            return new SmallCardLinkViewHolder(inflate, consumer);
        }
    }

    public static final SmallCardLinkViewHolder m37296a(ViewGroup viewGroup, Consumer<Integer> consumer) {
        return Companion.m23063a(viewGroup, consumer);
    }

    private final SmallCardBodyView m37297v() {
        return (SmallCardBodyView) this.f36921x.mo5678b();
    }

    private SmallCardLinkViewHolder(View view, final Consumer<Integer> consumer) {
        super(view);
        this.f36921x = LazyKt.m26777a(new SmallCardLinkViewHolder$cardBodyView$2(view));
        m37297v().setPreviewOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                view = this.f34045r;
                if (view != null) {
                    Consumer consumer = consumer;
                    if (consumer != null) {
                        consumer.mo4813a(Integer.valueOf(this.d()));
                    }
                    view.mo4828a(this.m34773O());
                }
            }
        });
    }

    public final void mo6963a(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        super.mo6963a(linkPresentationModel);
        m37297v().m23043a(linkPresentationModel);
    }

    protected final void mo6962a(int i) {
        m37297v().setTitleAlpha(i);
    }

    protected final void mo6967b(boolean z) {
        m37297v().setShowLinkFlair(z);
    }
}
