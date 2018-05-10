package com.reddit.frontpage.ui.carousel;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewAnimator;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel;
import com.reddit.frontpage.presentation.listing.model.ImageLinkPreviewPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.LinkThumbnailView;
import com.reddit.frontpage.ui.carousel.LinkCarouselItemViewHolder.WhenMappings;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ShapedIconView;
import com.reddit.frontpage.widgets.SubscribeToggleIcon;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000bH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRR\u0010\t\u001a:\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nj\u0004\u0018\u0001`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015RR\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nj\u0004\u0018\u0001`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015RR\u0010\u0019\u001a:\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nj\u0004\u0018\u0001`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006&"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/LinkCarouselAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/ui/carousel/LinkCarouselItemViewHolder;", "()V", "items", "", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselItemPresentationModel;", "getItems", "()Ljava/util/List;", "onClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "carouselItemPosition", "item", "", "Lcom/reddit/frontpage/ui/carousel/LinkCarouselItemClickListener;", "getOnClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onHeaderClickListener", "getOnHeaderClickListener", "setOnHeaderClickListener", "onSubscribeListener", "getOnSubscribeListener", "setOnSubscribeListener", "getItemCount", "getItemId", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkCarouselAdapter.kt */
public final class LinkCarouselAdapter extends Adapter<LinkCarouselItemViewHolder> {
    Function2<? super Integer, ? super LinkCarouselItemPresentationModel, Unit> f28916a;
    Function2<? super Integer, ? super LinkCarouselItemPresentationModel, Unit> f28917b;
    Function2<? super Integer, ? super LinkCarouselItemPresentationModel, Unit> f28918c;
    final List<LinkCarouselItemPresentationModel> f28919f = new ArrayList();

    public final /* synthetic */ ViewHolder m29969a(ViewGroup viewGroup, int i) {
        Intrinsics.m26847b(viewGroup, "parent");
        return (ViewHolder) new LinkCarouselItemViewHolder(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.item_link_carousel, false));
    }

    public final /* synthetic */ void m29970a(ViewHolder viewHolder, int i) {
        LinkCarouselItemViewHolder linkCarouselItemViewHolder = (LinkCarouselItemViewHolder) viewHolder;
        Intrinsics.m26847b(linkCarouselItemViewHolder, "holder");
        LinkCarouselItemPresentationModel linkCarouselItemPresentationModel = (LinkCarouselItemPresentationModel) this.f28919f.get(i);
        Function2 function2 = this.f28916a;
        Function2 function22 = this.f28917b;
        Function2 function23 = this.f28918c;
        Intrinsics.m26847b(linkCarouselItemPresentationModel, "item");
        linkCarouselItemViewHolder.f28923p = linkCarouselItemPresentationModel;
        if (function22 != null) {
            Object obj = linkCarouselItemViewHolder.c;
            Intrinsics.m26843a(obj, "itemView");
            obj.setOnClickListener(new C1880xa041a181(new LinkCarouselItemViewHolder$bind$1(linkCarouselItemViewHolder, function22, linkCarouselItemPresentationModel)));
        }
        if ((StringsKt__StringsJVMKt.m41943a((CharSequence) linkCarouselItemPresentationModel.f28074c) ^ 1) == 0 || !linkCarouselItemPresentationModel.f28084m) {
            Object obj2 = linkCarouselItemViewHolder.c;
            Intrinsics.m26843a(obj2, "itemView");
            obj2 = obj2.findViewById(C1761R.id.subreddit_header);
            Intrinsics.m26843a(obj2, "itemView.subreddit_header");
            ViewsKt.m24109d(obj2);
        } else {
            Object obj3 = linkCarouselItemViewHolder.c;
            Intrinsics.m26843a(obj3, "itemView");
            obj3 = obj3.findViewById(C1761R.id.subreddit_header);
            Intrinsics.m26843a(obj3, "itemView.subreddit_header");
            ViewsKt.m24107c(obj3);
            View view = linkCarouselItemViewHolder.c;
            ShapedIconView shapedIconView = (ShapedIconView) view.findViewById(C1761R.id.subreddit_icon);
            LinkCarouselItemPresentationModel linkCarouselItemPresentationModel2 = linkCarouselItemViewHolder.f28923p;
            if (linkCarouselItemPresentationModel2 == null) {
                Intrinsics.m26844a("item");
            }
            String str = linkCarouselItemPresentationModel2.f28074c;
            LinkCarouselItemPresentationModel linkCarouselItemPresentationModel3 = linkCarouselItemViewHolder.f28923p;
            if (linkCarouselItemPresentationModel3 == null) {
                Intrinsics.m26844a("item");
            }
            String str2 = linkCarouselItemPresentationModel3.f28073b;
            LinkCarouselItemPresentationModel linkCarouselItemPresentationModel4 = linkCarouselItemViewHolder.f28923p;
            if (linkCarouselItemPresentationModel4 == null) {
                Intrinsics.m26844a("item");
            }
            Util.m23985a(shapedIconView, str, str2, linkCarouselItemPresentationModel4.f28077f);
            Object obj4 = (ShapedIconView) view.findViewById(C1761R.id.subreddit_icon);
            Intrinsics.m26843a(obj4, "subreddit_icon");
            ((View) obj4).setOnClickListener(new C1880xa041a181(new LinkCarouselItemViewHolder$bindHeader$$inlined$apply$lambda$1(linkCarouselItemViewHolder, function23, function2)));
            TextView textView = (TextView) view.findViewById(C1761R.id.subreddit_name);
            linkCarouselItemPresentationModel2 = linkCarouselItemViewHolder.f28923p;
            if (linkCarouselItemPresentationModel2 == null) {
                Intrinsics.m26844a("item");
            }
            str = SubredditUtil.m23934e(linkCarouselItemPresentationModel2.f28074c);
            Intrinsics.m26843a((Object) str, "SubredditUtil.formatWithBoldHtml(subredditName)");
            TextViewsKt.m24097a(textView, str);
            textView.setOnClickListener(new C1880xa041a181(new LinkCarouselItemViewHolder$bindHeader$$inlined$apply$lambda$2(linkCarouselItemViewHolder, function23, function2)));
            textView = (TextView) view.findViewById(C1761R.id.subreddit_metadata);
            linkCarouselItemPresentationModel2 = linkCarouselItemViewHolder.f28923p;
            if (linkCarouselItemPresentationModel2 == null) {
                Intrinsics.m26844a("item");
            }
            textView.setText(linkCarouselItemPresentationModel2.f28075d);
            textView.setOnClickListener(new C1880xa041a181(new LinkCarouselItemViewHolder$bindHeader$$inlined$apply$lambda$3(linkCarouselItemViewHolder, function23, function2)));
            LinkCarouselItemPresentationModel linkCarouselItemPresentationModel5 = linkCarouselItemViewHolder.f28923p;
            if (linkCarouselItemPresentationModel5 == null) {
                Intrinsics.m26844a("item");
            }
            String str3 = linkCarouselItemPresentationModel5.f28074c;
            linkCarouselItemPresentationModel2 = linkCarouselItemViewHolder.f28923p;
            if (linkCarouselItemPresentationModel2 == null) {
                Intrinsics.m26844a("item");
            }
            obj4 = SubredditUtil.m23911a(str3, linkCarouselItemPresentationModel2.f28076e);
            linkCarouselItemPresentationModel2 = linkCarouselItemViewHolder.f28923p;
            if (linkCarouselItemPresentationModel2 == null) {
                Intrinsics.m26844a("item");
            }
            Intrinsics.m26843a(obj4, "subscribed");
            linkCarouselItemPresentationModel2.f28076e = obj4.booleanValue();
            SubscribeToggleIcon subscribeToggleIcon = (SubscribeToggleIcon) view.findViewById(C1761R.id.subscribe_toggle);
            View view2 = subscribeToggleIcon;
            ViewsKt.m24103a(view2, function2 != null);
            subscribeToggleIcon.setSubscribe(obj4);
            view2.setOnClickListener(new C1880xa041a181(new LinkCarouselItemViewHolder$bindHeader$$inlined$apply$lambda$4(obj4, linkCarouselItemViewHolder, function23, function2)));
        }
        View view3;
        LinkCarouselItemPresentationModel linkCarouselItemPresentationModel6;
        LinkCarouselItemPresentationModel linkCarouselItemPresentationModel7;
        switch (WhenMappings.f21127a[linkCarouselItemPresentationModel.f28082k.ordinal()]) {
            case 1:
                linkCarouselItemViewHolder.m29975z();
                break;
            case 2:
            case 3:
                view3 = linkCarouselItemViewHolder.c;
                obj3 = (ViewAnimator) view3.findViewById(C1761R.id.main_content);
                Intrinsics.m26843a(obj3, "main_content");
                obj3.setDisplayedChild(2);
                obj3 = (TextView) view3.findViewById(C1761R.id.video_link_title);
                Intrinsics.m26843a(obj3, "video_link_title");
                linkCarouselItemPresentationModel6 = linkCarouselItemViewHolder.f28923p;
                if (linkCarouselItemPresentationModel6 == null) {
                    Intrinsics.m26844a("item");
                }
                obj3.setText(linkCarouselItemPresentationModel6.f28078g);
                LinkThumbnailView linkThumbnailView = (LinkThumbnailView) view3.findViewById(C1761R.id.video_layout);
                linkCarouselItemPresentationModel7 = linkCarouselItemViewHolder.f28923p;
                if (linkCarouselItemPresentationModel7 == null) {
                    Intrinsics.m26844a("item");
                }
                linkThumbnailView.m23026a(linkCarouselItemPresentationModel7.f28083l, linkCarouselItemViewHolder.f28921a, linkCarouselItemViewHolder.f28922b);
                break;
            default:
                ImageLinkPreviewPresentationModel imageLinkPreviewPresentationModel = linkCarouselItemPresentationModel.f28083l.f33954G;
                if (imageLinkPreviewPresentationModel != null) {
                    List list = imageLinkPreviewPresentationModel.f28429a;
                    if (list != null && (list.isEmpty() ^ 1) == 1) {
                        view3 = linkCarouselItemViewHolder.c;
                        LinkThumbnailView linkThumbnailView2 = (LinkThumbnailView) view3.findViewById(C1761R.id.link_thumbnail);
                        linkCarouselItemPresentationModel6 = linkCarouselItemViewHolder.f28923p;
                        if (linkCarouselItemPresentationModel6 == null) {
                            Intrinsics.m26844a("item");
                        }
                        linkThumbnailView2.m23026a(linkCarouselItemPresentationModel6.f28083l, linkCarouselItemViewHolder.f28921a, linkCarouselItemViewHolder.f28922b);
                        obj3 = (ViewAnimator) view3.findViewById(C1761R.id.main_content);
                        Intrinsics.m26843a(obj3, "main_content");
                        obj3.setDisplayedChild(1);
                        obj2 = (TextView) view3.findViewById(C1761R.id.media_link_title);
                        Intrinsics.m26843a(obj2, "media_link_title");
                        linkCarouselItemPresentationModel7 = linkCarouselItemViewHolder.f28923p;
                        if (linkCarouselItemPresentationModel7 == null) {
                            Intrinsics.m26844a("item");
                        }
                        obj2.setText(linkCarouselItemPresentationModel7.f28078g);
                        break;
                    }
                }
                linkCarouselItemViewHolder.m29975z();
                break;
        }
        Object obj5 = (TextView) linkCarouselItemViewHolder.c.findViewById(C1761R.id.metadata);
        Intrinsics.m26843a(obj5, "metadata");
        obj5.setText((CharSequence) linkCarouselItemPresentationModel.f28080i);
    }

    public final long m29968a(int i) {
        return ((LinkCarouselItemPresentationModel) this.f28919f.get(i)).f28081j;
    }

    public final int m29967a() {
        return this.f28919f.size();
    }
}
