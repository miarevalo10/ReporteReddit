package com.reddit.frontpage.presentation.common.ui;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/Features;", "", "()V", "frontpageListingScreenMvpEnabled", "", "popularListingScreenMvpEnabled", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Features.kt */
public final class Features {
    public static final Features f20385a = new Features();

    private Features() {
    }

    public static final boolean m22742a() {
        if (!FrontpageSettings.a().o()) {
            Object a = FrontpageSettings.a();
            Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
            a = a.t();
            Intrinsics.m26843a(a, "FrontpageSettings.getInstance().appConfig");
            if (!a.i()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean m22743b() {
        if (!FrontpageSettings.a().p()) {
            Object a = FrontpageSettings.a();
            Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
            a = a.t();
            Intrinsics.m26843a(a, "FrontpageSettings.getInstance().appConfig");
            if (!a.j()) {
                return false;
            }
        }
        return true;
    }
}
