package com.reddit.frontpage.ui.carousel;

import android.support.v7.util.DiffUtil.Callback;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"com/reddit/frontpage/ui/carousel/CarouselViewHolder$diffAndSetOnView$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CarouselViewHolder.kt */
public final class CarouselViewHolder$diffAndSetOnView$result$1 extends Callback {
    final /* synthetic */ List f28911a;
    final /* synthetic */ List f28912b;

    CarouselViewHolder$diffAndSetOnView$result$1(List list, List list2) {
        this.f28911a = list;
        this.f28912b = list2;
    }

    public final boolean m29963a(int i, int i2) {
        return Intrinsics.m26845a((ICarouselItemPresentationModel) this.f28911a.get(i), (ICarouselItemPresentationModel) this.f28912b.get(i2));
    }

    public final int m29962a() {
        return this.f28911a.size();
    }

    public final int m29964b() {
        return this.f28912b.size();
    }

    public final boolean m29965b(int i, int i2) {
        return Intrinsics.m26845a((ICarouselItemPresentationModel) this.f28911a.get(i), (ICarouselItemPresentationModel) this.f28912b.get(i2));
    }
}
