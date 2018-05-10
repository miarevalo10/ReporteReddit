package com.reddit.frontpage.di.module;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.jvm.internal.Intrinsics;

public final class ApplicationModule_ApplicationSharedPreferencesFactory implements Factory<SharedPreferences> {
    private final ApplicationModule f33520a;

    private ApplicationModule_ApplicationSharedPreferencesFactory(ApplicationModule applicationModule) {
        this.f33520a = applicationModule;
    }

    public static ApplicationModule_ApplicationSharedPreferencesFactory m34461a(ApplicationModule applicationModule) {
        return new ApplicationModule_ApplicationSharedPreferencesFactory(applicationModule);
    }

    public final /* synthetic */ Object get() {
        Object defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f33520a.f20230a);
        Intrinsics.m26843a(defaultSharedPreferences, "PreferenceManager.getDef…dPreferences(application)");
        return (SharedPreferences) Preconditions.m26013a(defaultSharedPreferences, "Cannot return null from a non-@Nullable @Provides method");
    }
}
