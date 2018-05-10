package com.reddit.frontpage.di.module;

import android.content.Context;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class FormatterModule_AccountFormatterFactory implements Factory<AccountFormatter> {
    private final FormatterModule f33552a;
    private final Provider<Context> f33553b;

    private FormatterModule_AccountFormatterFactory(FormatterModule formatterModule, Provider<Context> provider) {
        this.f33552a = formatterModule;
        this.f33553b = provider;
    }

    public static FormatterModule_AccountFormatterFactory m34477a(FormatterModule formatterModule, Provider<Context> provider) {
        return new FormatterModule_AccountFormatterFactory(formatterModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (AccountFormatter) Preconditions.m26013a(FormatterModule.m22333a((Context) this.f33553b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
