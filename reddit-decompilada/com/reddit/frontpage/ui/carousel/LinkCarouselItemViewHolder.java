package com.reddit.frontpage.ui.carousel;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewAnimator;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.LinkType;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001(B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007JÔ\u0001\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2@\b\u0002\u0010\u0017\u001a:\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0018j\u0004\u0018\u0001`\u001c2@\b\u0002\u0010\u001d\u001a:\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0018j\u0004\u0018\u0001`\u001c2@\b\u0002\u0010\u001e\u001a:\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0018j\u0004\u0018\u0001`\u001cJ\u0001\u0010\u001f\u001a\u00020\u00162>\u0010\u0017\u001a:\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0018j\u0004\u0018\u0001`\u001c2>\u0010\u001e\u001a:\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0018j\u0004\u0018\u0001`\u001cH\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\u0006\u0010#\u001a\u00020\u0016J\u0006\u0010$\u001a\u00020\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016J\b\u0010'\u001a\u00020\u0016H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/LinkCarouselItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Lcom/reddit/frontpage/ui/carousel/CarouselItemViewHolder;", "Lcom/reddit/frontpage/ui/carousel/CarouselRecyclerView$ViewAttachListener;", "Lcom/reddit/frontpage/presentation/common/ui/Pausable;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "carouselItemId", "", "getCarouselItemId", "()Ljava/lang/String;", "item", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselItemPresentationModel;", "getItem", "()Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselItemPresentationModel;", "setItem", "(Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselItemPresentationModel;)V", "mediaHeight", "", "mediaWidth", "bind", "", "onSubscribeListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "carouselItemPosition", "Lcom/reddit/frontpage/ui/carousel/LinkCarouselItemClickListener;", "onClickListener", "onHeaderClickListener", "bindHeader", "bindMediaLink", "bindTextLink", "bindVideoLink", "onEnterFocus", "onExitFocus", "onPause", "onViewAttached", "onViewDetached", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkCarouselItemViewHolder.kt */
public final class LinkCarouselItemViewHolder extends ViewHolder implements CarouselItemViewHolder {
    public static final Companion f28920q = new Companion();
    final int f28921a = Util.m24012d((int) C1761R.dimen.link_carousel_item_width);
    final int f28922b = Util.m24012d((int) C1761R.dimen.link_carousel_media_height);
    public LinkCarouselItemPresentationModel f28923p;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/LinkCarouselItemViewHolder$Companion;", "", "()V", "DISPLAY_CHILD_MEDIA_LINK", "", "DISPLAY_CHILD_TEXT_LINK", "DISPLAY_CHILD_VIDEO_LINK", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkCarouselItemViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f21127a;
        public static final /* synthetic */ int[] f21128b;
        public static final /* synthetic */ int[] f21129c;

        static {
            int[] iArr = new int[LinkType.values().length];
            f21127a = iArr;
            iArr[LinkType.SELF.ordinal()] = 1;
            f21127a[LinkType.VIDEO.ordinal()] = 2;
            f21127a[LinkType.SUBMITTED_VIDEO.ordinal()] = 3;
            iArr = new int[LinkType.values().length];
            f21128b = iArr;
            iArr[LinkType.VIDEO.ordinal()] = 1;
            f21128b[LinkType.SUBMITTED_VIDEO.ordinal()] = 2;
            iArr = new int[LinkType.values().length];
            f21129c = iArr;
            iArr[LinkType.VIDEO.ordinal()] = 1;
            f21129c[LinkType.SUBMITTED_VIDEO.ordinal()] = 2;
        }
    }

    public static void m29971x() {
    }

    public static void m29972y() {
    }

    public LinkCarouselItemViewHolder(View view) {
        Intrinsics.m26847b(view, "view");
        super(view);
    }

    public final String ac_() {
        LinkCarouselItemPresentationModel linkCarouselItemPresentationModel = this.f28923p;
        if (linkCarouselItemPresentationModel == null) {
            Intrinsics.m26844a("item");
        }
        return linkCarouselItemPresentationModel.f28072a;
    }

    public final LinkCarouselItemPresentationModel m29973v() {
        LinkCarouselItemPresentationModel linkCarouselItemPresentationModel = this.f28923p;
        if (linkCarouselItemPresentationModel == null) {
            Intrinsics.m26844a("item");
        }
        return linkCarouselItemPresentationModel;
    }

    public final void m29974w() {
        LinkCarouselItemPresentationModel linkCarouselItemPresentationModel = this.f28923p;
        if (linkCarouselItemPresentationModel == null) {
            Intrinsics.m26844a("item");
        }
        LinkType linkType = linkCarouselItemPresentationModel.f28082k;
        int[] iArr = WhenMappings.f21129c;
        linkType.ordinal();
    }

    final void m29975z() {
        View view = this.c;
        Object obj = (ViewAnimator) view.findViewById(C1761R.id.main_content);
        Intrinsics.m26843a(obj, "main_content");
        obj.setDisplayedChild(0);
        obj = (TextView) view.findViewById(C1761R.id.text_link_title);
        Intrinsics.m26843a(obj, "text_link_title");
        LinkCarouselItemPresentationModel linkCarouselItemPresentationModel = this.f28923p;
        if (linkCarouselItemPresentationModel == null) {
            Intrinsics.m26844a("item");
        }
        obj.setText(linkCarouselItemPresentationModel.f28078g);
        obj = (TextView) view.findViewById(C1761R.id.text_link_body);
        Intrinsics.m26843a(obj, "text_link_body");
        linkCarouselItemPresentationModel = this.f28923p;
        if (linkCarouselItemPresentationModel == null) {
            Intrinsics.m26844a("item");
        }
        obj.setText(linkCarouselItemPresentationModel.f28079h);
        obj = (TextView) view.findViewById(C1761R.id.text_link_body);
        Intrinsics.m26843a(obj, "text_link_body");
        ViewsKt.m24102a((View) obj, (Function0) new LinkCarouselItemViewHolder$bindTextLink$1$1(view));
    }
}
