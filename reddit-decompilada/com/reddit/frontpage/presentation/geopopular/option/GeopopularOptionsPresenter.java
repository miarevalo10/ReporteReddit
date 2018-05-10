package com.reddit.frontpage.presentation.geopopular.option;

import android.location.Address;
import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressProvider;
import com.reddit.datalibrary.frontpage.data.provider.LocationPermissionRequestListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Region;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.repository.RegionRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter.Companion;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionContract.Navigator;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionContract.View;
import com.reddit.frontpage.util.PermissionRepository;
import com.reddit.frontpage.util.Util;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B7\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionsPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$Presenter;", "Lcom/reddit/datalibrary/frontpage/data/provider/LocationPermissionRequestListener;", "view", "Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$View;", "geocodedAddressProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressProvider;", "regionRepository", "Lcom/reddit/frontpage/domain/repository/RegionRepository;", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "navigator", "Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$Navigator;", "permissionRepository", "Lcom/reddit/frontpage/util/PermissionRepository;", "(Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$View;Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressProvider;Lcom/reddit/frontpage/domain/repository/RegionRepository;Lcom/reddit/frontpage/domain/repository/PreferenceRepository;Lcom/reddit/frontpage/presentation/geopopular/option/GeopopularOptionContract$Navigator;Lcom/reddit/frontpage/util/PermissionRepository;)V", "regionOptions", "", "Lcom/reddit/frontpage/domain/model/Region;", "addressToRegion", "Lkotlin/Pair;", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "address", "Landroid/location/Address;", "attach", "", "fetchAddress", "notifyRegionSelect", "filter", "onGlobalOptionClicked", "onLocationOptionClicked", "onLocationPermissionDenied", "onLocationPermissionGranted", "onOtherOtherClicked", "receiveAddress", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularOptionsPresenter.kt */
public final class GeopopularOptionsPresenter extends DisposablePresenter implements LocationPermissionRequestListener {
    final View f33857a;
    final Navigator f33858b;
    private final List<Region> f33859c = ((List) new ArrayList());
    private final GeocodedAddressProvider f33860d;
    private final PreferenceRepository f33861e;
    private final PermissionRepository f33862f;

    @Inject
    public GeopopularOptionsPresenter(View view, GeocodedAddressProvider geocodedAddressProvider, RegionRepository regionRepository, PreferenceRepository preferenceRepository, Navigator navigator, PermissionRepository permissionRepository) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(geocodedAddressProvider, "geocodedAddressProvider");
        Intrinsics.m26847b(regionRepository, "regionRepository");
        Intrinsics.m26847b(preferenceRepository, "preferenceRepository");
        Intrinsics.m26847b(navigator, "navigator");
        Intrinsics.m26847b(permissionRepository, "permissionRepository");
        this.f33857a = view;
        this.f33860d = geocodedAddressProvider;
        this.f33861e = preferenceRepository;
        this.f33858b = navigator;
        this.f33862f = permissionRepository;
        Object subscribe = regionRepository.m22480a().subscribe((Consumer) new Consumer<List<? extends Region>>() {
            public final /* synthetic */ void accept(Object obj) {
                obj = (List) obj;
                List b = this.f33859c;
                Intrinsics.m26843a(obj, "regions");
                b.addAll((Collection) obj);
            }
        });
        Intrinsics.m26843a(subscribe, "regionRepository.getRegi…Options.addAll(regions) }");
        handleDispose(subscribe);
    }

    public final void attach() {
        Object subscribe = this.f33861e.m22472a().subscribe((Consumer) new GeopopularOptionsPresenter$attach$1(this));
        Intrinsics.m26843a(subscribe, "preferenceRepository.get…      }\n                }");
        handleDispose(subscribe);
    }

    public final void m34678c() {
        this.f33857a.mo7178c();
        Companion companion = GeopopularRegionSelectFilter.f20532c;
        m34672a(Companion.m22843a());
    }

    public final void m34679d() {
        this.f33857a.mo7178c();
        if (this.f33862f.m23859a()) {
            m34675e();
        } else {
            this.f33857a.mo7179d();
        }
    }

    public final void m34677b() {
        View view = this.f33857a;
        Object f = Util.m24027f((int) C1761R.string.error_current_location);
        Intrinsics.m26843a(f, "Util.getString(R.string.error_current_location)");
        view.a_(f);
    }

    public final void m34676a() {
        m34675e();
    }

    private final void m34672a(GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
        Object subscribe = this.f33861e.m22467a(geopopularRegionSelectFilter).subscribe();
        Intrinsics.m26843a(subscribe, "preferenceRepository.set…ilter(filter).subscribe()");
        handleDispose(subscribe);
        this.f33857a.mo7174a(geopopularRegionSelectFilter);
    }

    private final void m34675e() {
        Object subscribe = this.f33860d.a().subscribe((BiConsumer) new GeopopularOptionsPresenter$fetchAddress$1(this));
        Intrinsics.m26843a(subscribe, "geocodedAddressProvider.…      }\n                }");
        handleDispose(subscribe);
    }

    public static final /* synthetic */ void m34673a(GeopopularOptionsPresenter geopopularOptionsPresenter, Address address) {
        Object obj;
        Iterator it = geopopularOptionsPresenter.f33859c.iterator();
        do {
            Object obj2 = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
        } while (!StringsKt__StringsJVMKt.m41946a(((Region) obj).getId(), address.getCountryCode(), true));
        Region region = (Region) obj;
        if (region == null) {
            address = geopopularOptionsPresenter.f33857a;
            Object f = Util.m24027f((int) C1761R.string.geopopular_my_location_match_error);
            Intrinsics.m26843a(f, "Util.getString(R.string.…_my_location_match_error)");
            address.a_(f);
            Companion companion = GeopopularRegionSelectFilter.f20532c;
            address = new Pair(Companion.m22843a(), null);
        } else {
            for (Object next : region.getSubregions()) {
                if (StringsKt__StringsJVMKt.m41946a(((Region) next).getName(), address.getAdminArea(), true)) {
                    obj2 = next;
                    break;
                }
            }
            Region region2 = (Region) obj2;
            if (region2 == null) {
                address = new Pair(new GeopopularRegionSelectFilter(region.getId(), region.getName()), region);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(region.getId());
                stringBuilder.append('_');
                stringBuilder.append(region2.getId());
                address = new Pair(new GeopopularRegionSelectFilter(stringBuilder.toString(), region2.getName()), region2);
            }
        }
        geopopularOptionsPresenter.m34672a((GeopopularRegionSelectFilter) address.f25267a);
    }
}
