package com.reddit.frontpage.presentation.communities;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.frontpage.presentation.carousel.model.CarouselItemPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.ui.carousel.LargeCarouselViewHolder;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "carouselItemPosition", "", "carouselItem", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "idsSeen", "", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesScreen.kt */
final class CommunitiesScreen$CommunitiesAdapter$onBindViewHolder$2 extends Lambda implements Function3<Integer, ICarouselItemPresentationModel, Set<? extends String>, Unit> {
    final /* synthetic */ CommunitiesAdapter f36428a;
    final /* synthetic */ ViewHolder f36429b;

    CommunitiesScreen$CommunitiesAdapter$onBindViewHolder$2(CommunitiesAdapter communitiesAdapter, ViewHolder viewHolder) {
        this.f36428a = communitiesAdapter;
        this.f36429b = viewHolder;
        super(3);
    }

    public final /* synthetic */ Object mo6509a(Object obj, Object obj2, Object obj3) {
        obj = ((Number) obj).intValue();
        ICarouselItemPresentationModel iCarouselItemPresentationModel = (ICarouselItemPresentationModel) obj2;
        Set set = (Set) obj3;
        Intrinsics.m26847b(iCarouselItemPresentationModel, "carouselItem");
        Intrinsics.m26847b(set, "idsSeen");
        this.f36428a.f28119b.m40578w().m34645a(((LargeCarouselViewHolder) this.f36429b).d(), obj, (CarouselItemPresentationModel) iCarouselItemPresentationModel, set);
        return Unit.f25273a;
    }
}
