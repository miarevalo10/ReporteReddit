package com.reddit.frontpage.presentation.geopopular;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Routing.NavigationAware;
import com.reddit.frontpage.widgets.ScreenContainer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectActivity;", "Lcom/reddit/frontpage/BaseActivity;", "Lcom/reddit/frontpage/nav/Routing$NavigationAware;", "Lcom/reddit/frontpage/presentation/geopopular/ActionBarProvider;", "()V", "actionBar", "Landroid/support/v7/app/ActionBar;", "getActionBar", "()Landroid/support/v7/app/ActionBar;", "router", "Lcom/bluelinelabs/conductor/Router;", "getActiveRouter", "getLayoutId", "", "getRootRouter", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectActivity.kt */
public final class GeopopularRegionSelectActivity extends BaseActivity implements NavigationAware, ActionBarProvider {
    private Router f40832d;
    private HashMap f40833h;

    public final View mo7727a(int i) {
        if (this.f40833h == null) {
            this.f40833h = new HashMap();
        }
        View view = (View) this.f40833h.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f40833h.put(Integer.valueOf(i), view);
        return view;
    }

    public final int mo7724d() {
        return C1761R.layout.activity_geopopular_region_select;
    }

    public final ActionBar mo7784a() {
        ActionBar b = b();
        if (b == null) {
            Intrinsics.m26842a();
        }
        return b;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar a = mo7784a();
        a.a(true);
        a.b(true);
        Object a2 = Conductor.a(this, (ScreenContainer) mo7727a(C1761R.id.controller_container), bundle);
        Intrinsics.m26843a(a2, "Conductor.attachRouter(t…iner, savedInstanceState)");
        this.f40832d = a2;
        bundle = this.f40832d;
        if (bundle == null) {
            Intrinsics.m26844a("router");
        }
        if (bundle.n() == null) {
            bundle = Nav.m22599l();
            Router router = this.f40832d;
            if (router == null) {
                Intrinsics.m26844a("router");
            }
            router.d(RouterTransaction.a((Controller) bundle).a(Routing.m22615a()).b(Routing.m22615a()));
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void onBackPressed() {
        Router router = this.f40832d;
        if (router == null) {
            Intrinsics.m26844a("router");
        }
        if (!router.i()) {
            super.onBackPressed();
        }
    }

    public final Router mo7778g() {
        Router router = this.f40832d;
        if (router == null) {
            Intrinsics.m26844a("router");
        }
        return router;
    }

    public final Router mo7779h() {
        Router router = this.f40832d;
        if (router == null) {
            Intrinsics.m26844a("router");
        }
        return router;
    }
}
