package com.reddit.frontpage.presentation.geopopular.select;

import android.support.v7.widget.SearchView.OnQueryTextListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectScreen$onCreateOptionsMenu$1$1", "Landroid/support/v7/widget/SearchView$OnQueryTextListener;", "(Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectScreen$onCreateOptionsMenu$1;)V", "onQueryTextChange", "", "newText", "", "onQueryTextSubmit", "query", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectScreen.kt */
public final class C2303xb9991918 implements OnQueryTextListener {
    final /* synthetic */ GeopopularRegionSelectScreen f28252a;

    public final boolean m29535a(String str) {
        Intrinsics.m26847b(str, "query");
        return false;
    }

    C2303xb9991918(GeopopularRegionSelectScreen geopopularRegionSelectScreen) {
        this.f28252a = geopopularRegionSelectScreen;
    }

    public final boolean m29536b(String str) {
        Intrinsics.m26847b(str, "newText");
        this.f28252a.f40018A.onNext(str);
        return true;
    }
}
