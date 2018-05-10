package com.reddit.frontpage.di.module;

import android.content.Context;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.presentation.carousel.ColorGenerator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class GeneratorModule_CarouselColorGeneratorFactory implements Factory<ColorGenerator> {
    private final GeneratorModule f33567a;
    private final Provider<Context> f33568b;
    private final Provider<FrontpageSettings> f33569c;

    private GeneratorModule_CarouselColorGeneratorFactory(GeneratorModule generatorModule, Provider<Context> provider, Provider<FrontpageSettings> provider2) {
        this.f33567a = generatorModule;
        this.f33568b = provider;
        this.f33569c = provider2;
    }

    public static GeneratorModule_CarouselColorGeneratorFactory m34482a(GeneratorModule generatorModule, Provider<Context> provider, Provider<FrontpageSettings> provider2) {
        return new GeneratorModule_CarouselColorGeneratorFactory(generatorModule, provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return (ColorGenerator) Preconditions.m26013a(GeneratorModule.m22338a((Context) this.f33568b.get(), (FrontpageSettings) this.f33569c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
