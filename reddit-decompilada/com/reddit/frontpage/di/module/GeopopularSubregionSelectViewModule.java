package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectContract.Navigator;
import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectContract.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/module/GeopopularSubregionSelectViewModule;", "", "view", "Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract$View;", "navigator", "Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract$Navigator;", "(Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract$View;Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract$Navigator;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularSubregionSelectViewModule.kt */
public final class GeopopularSubregionSelectViewModule {
    final View f20239a;
    final Navigator f20240b;

    public GeopopularSubregionSelectViewModule(View view, Navigator navigator) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(navigator, "navigator");
        this.f20239a = view;
        this.f20240b = navigator;
    }
}
