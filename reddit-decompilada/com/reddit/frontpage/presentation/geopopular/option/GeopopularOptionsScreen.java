package com.reddit.frontpage.presentation.geopopular.option;

import android.content.Context;
import android.os.Bundle;
import com.reddit.datalibrary.frontpage.data.provider.LocationPermissionRequestProvider;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerGeopopularOptionsComponent;
import com.reddit.frontpage.di.module.GeopopularOptionsViewModule;
import com.reddit.frontpage.presentation.common.ui.view.RedditBottomSheetDialog;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectActivity;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionContract.Navigator;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionContract.View;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.widgets.GeopopularOptionItemView;
import de.greenrobot.event.EventBus;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001aH\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u001aH\u0016R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionsScreen;", "Lcom/reddit/frontpage/presentation/common/ui/view/RedditBottomSheetDialog;", "Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$View;", "Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$Navigator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "locationPermissionRequestProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/LocationPermissionRequestProvider;", "getLocationPermissionRequestProvider", "()Lcom/reddit/datalibrary/frontpage/data/provider/LocationPermissionRequestProvider;", "setLocationPermissionRequestProvider", "(Lcom/reddit/datalibrary/frontpage/data/provider/LocationPermissionRequestProvider;)V", "presenter", "Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionsPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionsPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionsPresenter;)V", "screen", "Lcom/reddit/frontpage/ui/BaseScreen;", "getScreen", "()Lcom/reddit/frontpage/ui/BaseScreen;", "setScreen", "(Lcom/reddit/frontpage/ui/BaseScreen;)V", "clearSelections", "", "navigateToGeopopularRegionSelect", "notifyRegionSelect", "select", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setGlobalOption", "setOtherOption", "name", "", "showError", "message", "showLocationPermissionRequest", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularOptionsScreen.kt */
public final class GeopopularOptionsScreen extends RedditBottomSheetDialog implements Navigator, View {
    @Inject
    public GeopopularOptionsPresenter f39101d;
    public LocationPermissionRequestProvider f39102e;
    public BaseScreen f39103f;

    public GeopopularOptionsScreen(Context context) {
        Intrinsics.m26847b(context, "context");
        super(context, false);
    }

    public final GeopopularOptionsPresenter m38956e() {
        GeopopularOptionsPresenter geopopularOptionsPresenter = this.f39101d;
        if (geopopularOptionsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return geopopularOptionsPresenter;
    }

    public final void m38949a(LocationPermissionRequestProvider locationPermissionRequestProvider) {
        Intrinsics.m26847b(locationPermissionRequestProvider, "<set-?>");
        this.f39102e = locationPermissionRequestProvider;
    }

    public final void m38951a(BaseScreen baseScreen) {
        Intrinsics.m26847b(baseScreen, "<set-?>");
        this.f39103f = baseScreen;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DaggerGeopopularOptionsComponent.m29132a().m22102a(FrontpageApplication.m28875k()).m22103a(new GeopopularOptionsViewModule(this, this)).m22104a().mo4661a(this);
        setContentView((int) C1761R.layout.geopopular_options);
        ((GeopopularOptionItemView) findViewById(C1761R.id.global_option)).setOnClickListener(new GeopopularOptionsScreen$onCreate$1(this));
        ((GeopopularOptionItemView) findViewById(C1761R.id.location_option)).setOnClickListener(new GeopopularOptionsScreen$onCreate$2(this));
        ((GeopopularOptionItemView) findViewById(C1761R.id.other_option)).setOnClickListener(new GeopopularOptionsScreen$onCreate$3(this));
        bundle = this.f39101d;
        if (bundle == null) {
            Intrinsics.m26844a("presenter");
        }
        bundle.attach();
    }

    public final void mo7176b() {
        Object obj = (GeopopularOptionItemView) findViewById(C1761R.id.global_option);
        Intrinsics.m26843a(obj, "global_option");
        obj.setSelected(true);
    }

    public final void mo7177b(String str) {
        Intrinsics.m26847b(str, "name");
        Object obj = (GeopopularOptionItemView) findViewById(C1761R.id.other_option);
        Intrinsics.m26843a(obj, "other_option");
        obj.setSelected(true);
        ((GeopopularOptionItemView) findViewById(C1761R.id.other_option)).setRegion(str);
    }

    public final void mo7179d() {
        LocationPermissionRequestProvider locationPermissionRequestProvider = this.f39102e;
        if (locationPermissionRequestProvider == null) {
            Intrinsics.m26844a("locationPermissionRequestProvider");
        }
        GeopopularOptionsPresenter geopopularOptionsPresenter = this.f39101d;
        if (geopopularOptionsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        if (geopopularOptionsPresenter == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.data.provider.LocationPermissionRequestListener");
        }
        locationPermissionRequestProvider.a(geopopularOptionsPresenter);
    }

    public final void a_(String str) {
        Intrinsics.m26847b(str, "message");
        BaseScreen baseScreen = this.f39103f;
        if (baseScreen == null) {
            Intrinsics.m26844a("screen");
        }
        baseScreen.mo7204a((CharSequence) str);
        dismiss();
    }

    public final void mo7174a(GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
        Intrinsics.m26847b(geopopularRegionSelectFilter, "select");
        EventBus.getDefault().postSticky(geopopularRegionSelectFilter);
        dismiss();
    }

    public final void mo7178c() {
        Object obj = (GeopopularOptionItemView) findViewById(C1761R.id.global_option);
        Intrinsics.m26843a(obj, "global_option");
        obj.setSelected(false);
        obj = (GeopopularOptionItemView) findViewById(C1761R.id.location_option);
        Intrinsics.m26843a(obj, "location_option");
        obj.setSelected(false);
        obj = (GeopopularOptionItemView) findViewById(C1761R.id.other_option);
        Intrinsics.m26843a(obj, "other_option");
        obj.setSelected(false);
    }

    public final void mo7173a() {
        Object context = getContext();
        Intrinsics.m26843a(context, "context");
        AnkoInternals.m28422a(context, GeopopularRegionSelectActivity.class, new Pair[0]);
        dismiss();
    }
}
