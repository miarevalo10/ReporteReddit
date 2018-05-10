package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ThingReportModule_ViewFactory implements Factory<View> {
    private final ThingReportModule f33666a;

    private ThingReportModule_ViewFactory(ThingReportModule thingReportModule) {
        this.f33666a = thingReportModule;
    }

    public static ThingReportModule_ViewFactory m34533a(ThingReportModule thingReportModule) {
        return new ThingReportModule_ViewFactory(thingReportModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33666a.f20254a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
