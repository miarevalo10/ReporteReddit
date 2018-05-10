package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class FormatterModule_SubredditFormatterFactory implements Factory<NumberFormatter> {
    private final FormatterModule f33554a;

    private FormatterModule_SubredditFormatterFactory(FormatterModule formatterModule) {
        this.f33554a = formatterModule;
    }

    public static FormatterModule_SubredditFormatterFactory m34478a(FormatterModule formatterModule) {
        return new FormatterModule_SubredditFormatterFactory(formatterModule);
    }

    public final /* synthetic */ Object get() {
        return (NumberFormatter) Preconditions.m26013a(FormatterModule.m22334a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
