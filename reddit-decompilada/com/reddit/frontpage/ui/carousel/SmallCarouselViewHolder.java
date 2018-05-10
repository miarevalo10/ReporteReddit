package com.reddit.frontpage.ui.carousel;

import android.view.ViewGroup;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012@\u0010\b\u001a<\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tj\u0002`\u0011¢\u0006\u0002\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/SmallCarouselViewHolder;", "Lcom/reddit/frontpage/ui/carousel/CarouselViewHolder;", "parent", "Landroid/view/ViewGroup;", "screenWidth", "", "attachToRoot", "", "onCarouselImpression", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "listablePosition", "", "", "positionsSeen", "", "Lcom/reddit/frontpage/ui/carousel/CarouselImpressionListener;", "(Landroid/view/ViewGroup;IZLkotlin/jvm/functions/Function2;)V", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SmallCarouselViewHolder.kt */
public final class SmallCarouselViewHolder extends CarouselViewHolder {
    public static final Companion f37244b = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jd\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2@\u0010\u000b\u001a<\u0012\u0013\u0012\u00110\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\fj\u0002`\u0014H\u0007¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/SmallCarouselViewHolder$Companion;", "", "()V", "create", "Lcom/reddit/frontpage/ui/carousel/SmallCarouselViewHolder;", "parent", "Landroid/view/ViewGroup;", "screenWidth", "", "attachToRoot", "", "onCarouselImpression", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "listablePosition", "", "", "positionsSeen", "", "Lcom/reddit/frontpage/ui/carousel/CarouselImpressionListener;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SmallCarouselViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static SmallCarouselViewHolder m23328a(ViewGroup viewGroup, int i, boolean z, Function2<? super Integer, ? super Set<String>, Unit> function2) {
            Intrinsics.m26847b(viewGroup, "parent");
            Intrinsics.m26847b(function2, "onCarouselImpression");
            return new SmallCarouselViewHolder(viewGroup, i, z, function2);
        }
    }

    public static final SmallCarouselViewHolder m37570a(ViewGroup viewGroup, int i, Function2<? super Integer, ? super Set<String>, Unit> function2) {
        return Companion.m23328a(viewGroup, i, false, function2);
    }

    public SmallCarouselViewHolder(ViewGroup viewGroup, int i, boolean z, Function2<? super Integer, ? super Set<String>, Unit> function2) {
        Intrinsics.m26847b(viewGroup, "parent");
        Intrinsics.m26847b(function2, "onCarouselImpression");
        super(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.layout_carousel, z), i, CarouselItemLayout.SMALL, function2, 16);
    }
}
