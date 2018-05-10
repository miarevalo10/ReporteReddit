package com.reddit.frontpage.ui.carousel;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ViewSwitcher;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005JÔ\u0001\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2@\b\u0002\u0010\u001c\u001a:\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001dj\u0004\u0018\u0001`\"2@\b\u0002\u0010#\u001a:\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001dj\u0004\u0018\u0001`\"2@\b\u0002\u0010$\u001a:\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001dj\u0004\u0018\u0001`\"R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/GeneralCarouselItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Lcom/reddit/frontpage/ui/carousel/CarouselItemViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "carouselItemId", "", "getCarouselItemId", "()Ljava/lang/String;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "item", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "getItem", "()Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "setItem", "(Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;)V", "subscribed", "", "getSubscribed", "()Z", "setSubscribed", "(Z)V", "bind", "", "onDismissListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "carouselItemPosition", "Lcom/reddit/frontpage/ui/carousel/CarouselItemClickListener;", "onSubscribeListener", "clickListener", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeneralCarouselItemViewHolder.kt */
public final class GeneralCarouselItemViewHolder extends ViewHolder implements CarouselItemViewHolder {
    public static final Companion f28913p = new Companion();
    boolean f28914a;
    public ICarouselItemPresentationModel f28915b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/GeneralCarouselItemViewHolder$Companion;", "", "()V", "DISPLAY_CHILD_SUBSCRIBED", "", "DISPLAY_CHILD_UNSUBSCRIBED", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeneralCarouselItemViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public GeneralCarouselItemViewHolder(View view) {
        Intrinsics.m26847b(view, "view");
        super(view);
    }

    public final String ac_() {
        ICarouselItemPresentationModel iCarouselItemPresentationModel = this.f28915b;
        if (iCarouselItemPresentationModel == null) {
            Intrinsics.m26844a("item");
        }
        return iCarouselItemPresentationModel.mo6433a();
    }

    public final void m29966b(boolean z) {
        Object obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        ViewSwitcher viewSwitcher = (ViewSwitcher) obj.findViewById(C1761R.id.subscribe_viewswitcher);
        viewSwitcher.setSelected(z ^ 1);
        viewSwitcher.setDisplayedChild(z);
        this.f28914a = z;
    }
}
