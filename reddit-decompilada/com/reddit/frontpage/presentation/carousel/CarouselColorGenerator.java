package com.reddit.frontpage.presentation.carousel;

import android.content.Context;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/CarouselColorGenerator;", "Lcom/reddit/frontpage/presentation/carousel/ColorGenerator;", "context", "Landroid/content/Context;", "frontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "(Landroid/content/Context;Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;)V", "getColorForIndex", "", "index", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CarouselColorGenerator.kt */
public final class CarouselColorGenerator implements ColorGenerator {
    private final Context f28063a;
    private final FrontpageSettings f28064b;

    public CarouselColorGenerator(Context context, FrontpageSettings frontpageSettings) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(frontpageSettings, "frontpageSettings");
        this.f28063a = context;
        this.f28064b = frontpageSettings;
    }

    public final int mo4784a(int i) {
        int[] intArray = this.f28063a.getResources().getIntArray(this.f28064b.d() ? C1761R.array.night_mode_carousel_colors : C1761R.array.carousel_colors);
        return intArray[i % intArray.length];
    }
}
