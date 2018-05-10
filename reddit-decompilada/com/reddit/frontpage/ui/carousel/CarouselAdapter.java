package com.reddit.frontpage.ui.carousel;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.util.ImageUtil;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ShapedIconView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010$\u001a\u00020\u0013H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0018\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0018\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000RR\u0010\u0011\u001a:\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012j\u0004\u0018\u0001`\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dRR\u0010\u001e\u001a:\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012j\u0004\u0018\u0001`\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dRR\u0010!\u001a:\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012j\u0004\u0018\u0001`\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d¨\u0006."}, d2 = {"Lcom/reddit/frontpage/ui/carousel/CarouselAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/ui/carousel/GeneralCarouselItemViewHolder;", "layout", "Lcom/reddit/frontpage/ui/carousel/CarouselItemLayout;", "(Lcom/reddit/frontpage/ui/carousel/CarouselItemLayout;)V", "cardWidth", "", "getCardWidth", "()D", "setCardWidth", "(D)V", "items", "", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "getItems", "()Ljava/util/List;", "onClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "carouselItemPosition", "item", "", "Lcom/reddit/frontpage/ui/carousel/CarouselItemClickListener;", "getOnClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onDismissListener", "getOnDismissListener", "setOnDismissListener", "onSubscribeListener", "getOnSubscribeListener", "setOnSubscribeListener", "getItemCount", "getItemId", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CarouselAdapter.kt */
public final class CarouselAdapter extends Adapter<GeneralCarouselItemViewHolder> {
    double f28900a;
    Function2<? super Integer, ? super ICarouselItemPresentationModel, Unit> f28901b;
    Function2<? super Integer, ? super ICarouselItemPresentationModel, Unit> f28902c;
    Function2<? super Integer, ? super ICarouselItemPresentationModel, Unit> f28903f;
    final List<ICarouselItemPresentationModel> f28904g = ((List) new ArrayList());
    private final CarouselItemLayout f28905h;

    public final /* synthetic */ ViewHolder m29955a(ViewGroup viewGroup, int i) {
        Intrinsics.m26847b(viewGroup, "parent");
        viewGroup = ViewGroupsKt.m24100a(viewGroup, this.f28905h.getLayoutFile(), false);
        viewGroup.getLayoutParams().width = (int) this.f28900a;
        return (ViewHolder) new GeneralCarouselItemViewHolder(viewGroup);
    }

    public final /* synthetic */ void m29956a(ViewHolder viewHolder, int i) {
        Object obj;
        String a;
        GeneralCarouselItemViewHolder generalCarouselItemViewHolder = (GeneralCarouselItemViewHolder) viewHolder;
        Intrinsics.m26847b(generalCarouselItemViewHolder, "holder");
        ICarouselItemPresentationModel iCarouselItemPresentationModel = (ICarouselItemPresentationModel) this.f28904g.get(i);
        Function2 function2 = this.f28901b;
        Function2 function22 = this.f28902c;
        Function2 function23 = this.f28903f;
        Intrinsics.m26847b(iCarouselItemPresentationModel, "item");
        if (function2 == null) {
            obj = generalCarouselItemViewHolder.c;
            Intrinsics.m26843a(obj, "itemView");
            obj = (ImageView) obj.findViewById(C1761R.id.dismiss_button);
            Intrinsics.m26843a(obj, "itemView.dismiss_button");
            ViewsKt.m24109d((View) obj);
        } else {
            Object obj2 = generalCarouselItemViewHolder.c;
            Intrinsics.m26843a(obj2, "itemView");
            ((ImageView) obj2.findViewById(C1761R.id.dismiss_button)).setOnClickListener(new GeneralCarouselItemViewHolder$bind$1(generalCarouselItemViewHolder, function2, iCarouselItemPresentationModel));
        }
        if (function22 == null) {
            obj = generalCarouselItemViewHolder.c;
            Intrinsics.m26843a(obj, "itemView");
            obj = (ViewSwitcher) obj.findViewById(C1761R.id.subscribe_viewswitcher);
            Intrinsics.m26843a(obj, "itemView.subscribe_viewswitcher");
            ViewsKt.m24109d((View) obj);
        } else {
            obj = generalCarouselItemViewHolder.c;
            Intrinsics.m26843a(obj, "itemView");
            obj = (ViewSwitcher) obj.findViewById(C1761R.id.subscribe_viewswitcher);
            Intrinsics.m26843a(obj, "itemView.subscribe_viewswitcher");
            ViewsKt.m24107c((View) obj);
            obj = generalCarouselItemViewHolder.c;
            Intrinsics.m26843a(obj, "itemView");
            ((ViewSwitcher) obj.findViewById(C1761R.id.subscribe_viewswitcher)).setOnClickListener(new GeneralCarouselItemViewHolder$bind$2(generalCarouselItemViewHolder, function22, iCarouselItemPresentationModel));
        }
        if (function23 != null) {
            generalCarouselItemViewHolder.c.setOnClickListener(new GeneralCarouselItemViewHolder$bind$3(generalCarouselItemViewHolder, function23, iCarouselItemPresentationModel));
        }
        generalCarouselItemViewHolder.f28915b = iCarouselItemPresentationModel;
        if (StringsKt__StringsKt.m42452a((CharSequence) iCarouselItemPresentationModel.mo6435b(), (CharSequence) "u/")) {
            a = StringsKt__StringsJVMKt.m41942a(iCarouselItemPresentationModel.mo6435b(), "u/", "u_");
        } else {
            a = StringsKt__StringsJVMKt.m41942a(iCarouselItemPresentationModel.mo6435b(), "r/", "");
        }
        obj = SubredditUtil.m23911a(a, iCarouselItemPresentationModel.mo6444k());
        Intrinsics.m26843a(obj, "subscribed");
        iCarouselItemPresentationModel.mo6434a(obj.booleanValue());
        generalCarouselItemViewHolder.m29966b(obj.booleanValue());
        if (!iCarouselItemPresentationModel.mo6445l()) {
            obj = generalCarouselItemViewHolder.c;
            Intrinsics.m26843a(obj, "itemView");
            obj = (TextView) obj.findViewById(C1761R.id.description);
            Intrinsics.m26843a(obj, "itemView.description");
            ViewsKt.m24109d((View) obj);
        }
        if (!iCarouselItemPresentationModel.mo6446m()) {
            obj = generalCarouselItemViewHolder.c;
            Intrinsics.m26843a(obj, "itemView");
            obj = (TextView) obj.findViewById(C1761R.id.metadata);
            Intrinsics.m26843a(obj, "itemView.metadata");
            ViewsKt.m24109d((View) obj);
        }
        viewHolder = generalCarouselItemViewHolder.c;
        TextView textView = (TextView) viewHolder.findViewById(C1761R.id.title);
        Intrinsics.m26843a((Object) textView, "title");
        TextViewsKt.m24097a(textView, iCarouselItemPresentationModel.mo6439f());
        obj = (TextView) viewHolder.findViewById(C1761R.id.stats);
        Intrinsics.m26843a(obj, "stats");
        obj.setText(iCarouselItemPresentationModel.mo6440g());
        obj = (TextView) viewHolder.findViewById(C1761R.id.description);
        Intrinsics.m26843a(obj, "description");
        obj.setText(iCarouselItemPresentationModel.mo6441h());
        obj = (TextView) viewHolder.findViewById(C1761R.id.metadata);
        Intrinsics.m26843a(obj, "metadata");
        obj.setText(iCarouselItemPresentationModel.mo6442i());
        ((ImageView) viewHolder.findViewById(C1761R.id.banner)).setBackgroundColor(iCarouselItemPresentationModel.mo6443j());
        ImageUtil.m23725b(viewHolder.getContext(), iCarouselItemPresentationModel.mo6436c(), (ImageView) viewHolder.findViewById(C1761R.id.banner));
        Util.m23981a((ShapedIconView) viewHolder.findViewById(C1761R.id.avatar), iCarouselItemPresentationModel.mo6437d(), Integer.valueOf(iCarouselItemPresentationModel.mo6443j()), iCarouselItemPresentationModel.mo6438e());
        View view = (ViewSwitcher) viewHolder.findViewById(C1761R.id.subscribe_viewswitcher);
        obj = (TextView) view.findViewById(C1761R.id.unsubscribedTextView);
        Intrinsics.m26843a(obj, "unsubscribedTextView");
        obj.setText(iCarouselItemPresentationModel.mo6449p());
        Object obj3 = (TextView) view.findViewById(C1761R.id.subscribedTextView);
        Intrinsics.m26843a(obj3, "subscribedTextView");
        obj3.setText(iCarouselItemPresentationModel.mo6448o());
    }

    public CarouselAdapter(CarouselItemLayout carouselItemLayout) {
        Intrinsics.m26847b(carouselItemLayout, "layout");
        this.f28905h = carouselItemLayout;
    }

    public final long m29954a(int i) {
        return ((ICarouselItemPresentationModel) this.f28904g.get(i)).mo6447n();
    }

    public final int m29953a() {
        return this.f28904g.size();
    }
}
