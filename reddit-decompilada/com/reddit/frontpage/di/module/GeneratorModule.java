package com.reddit.frontpage.di.module;

import android.content.Context;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.presentation.carousel.CarouselColorGenerator;
import com.reddit.frontpage.presentation.carousel.ColorGenerator;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/di/module/GeneratorModule;", "", "()V", "carouselColorGenerator", "Lcom/reddit/frontpage/presentation/carousel/ColorGenerator;", "context", "Landroid/content/Context;", "frontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeneratorModule.kt */
public final class GeneratorModule {
    @Singleton
    public static ColorGenerator m22338a(Context context, FrontpageSettings frontpageSettings) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(frontpageSettings, "frontpageSettings");
        return new CarouselColorGenerator(context, frontpageSettings);
    }
}
