package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressProvider;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectContract.Navigator;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectContract.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/di/module/GeopopularRegionSelectViewModule;", "", "view", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract$View;", "navigator", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract$Navigator;", "(Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract$View;Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract$Navigator;)V", "geocodedAddressProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressProvider;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectViewModule.kt */
public final class GeopopularRegionSelectViewModule {
    final View f20237a;
    final Navigator f20238b;

    public GeopopularRegionSelectViewModule(View view, Navigator navigator) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(navigator, "navigator");
        this.f20237a = view;
        this.f20238b = navigator;
    }

    public static GeocodedAddressProvider m22340a() {
        return new GeocodedAddressProvider();
    }
}
