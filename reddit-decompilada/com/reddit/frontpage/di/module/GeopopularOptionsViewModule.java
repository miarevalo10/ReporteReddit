package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressProvider;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionContract.Navigator;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionContract.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/di/module/GeopopularOptionsViewModule;", "", "view", "Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$View;", "navigator", "Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$Navigator;", "(Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$View;Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$Navigator;)V", "getNavigator", "()Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$Navigator;", "getView", "()Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$View;", "geocodedAddressProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressProvider;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularOptionsViewModule.kt */
public final class GeopopularOptionsViewModule {
    final View f20235a;
    final Navigator f20236b;

    public GeopopularOptionsViewModule(View view, Navigator navigator) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(navigator, "navigator");
        this.f20235a = view;
        this.f20236b = navigator;
    }

    public static GeocodedAddressProvider m22339a() {
        return new GeocodedAddressProvider();
    }
}
