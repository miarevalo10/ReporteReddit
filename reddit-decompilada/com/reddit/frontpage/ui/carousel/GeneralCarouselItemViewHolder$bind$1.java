package com.reddit.frontpage.ui.carousel;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeneralCarouselItemViewHolder.kt */
final class GeneralCarouselItemViewHolder$bind$1 implements OnClickListener {
    final /* synthetic */ GeneralCarouselItemViewHolder f21118a;
    final /* synthetic */ Function2 f21119b;
    final /* synthetic */ ICarouselItemPresentationModel f21120c;

    GeneralCarouselItemViewHolder$bind$1(GeneralCarouselItemViewHolder generalCarouselItemViewHolder, Function2 function2, ICarouselItemPresentationModel iCarouselItemPresentationModel) {
        this.f21118a = generalCarouselItemViewHolder;
        this.f21119b = function2;
        this.f21120c = iCarouselItemPresentationModel;
    }

    public final void onClick(View view) {
        this.f21119b.mo6497a(Integer.valueOf(this.f21118a.d()), this.f21120c);
    }
}
