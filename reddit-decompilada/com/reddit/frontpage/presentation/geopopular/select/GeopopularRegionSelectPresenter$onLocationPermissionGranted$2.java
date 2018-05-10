package com.reddit.frontpage.presentation.geopopular.select;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectPresenter.GeocodeAddressFilterResult.Error;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectPresenter.GeocodeAddressFilterResult.Success;
import com.reddit.frontpage.util.Util;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "event", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeocodeAddressFilterResult;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectPresenter.kt */
final class GeopopularRegionSelectPresenter$onLocationPermissionGranted$2<T> implements Consumer<GeocodeAddressFilterResult> {
    final /* synthetic */ GeopopularRegionSelectPresenter f28248a;

    GeopopularRegionSelectPresenter$onLocationPermissionGranted$2(GeopopularRegionSelectPresenter geopopularRegionSelectPresenter) {
        this.f28248a = geopopularRegionSelectPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        GeocodeAddressFilterResult geocodeAddressFilterResult = (GeocodeAddressFilterResult) obj;
        if (geocodeAddressFilterResult instanceof Success) {
            this.f28248a.f33864a.mo7349b(((Success) geocodeAddressFilterResult).f28241a);
            return;
        }
        if ((geocodeAddressFilterResult instanceof Error) != null) {
            Timber.e("LocationDataProvider.publishLocation(): lastLocation is null", new Object[0]);
            obj = this.f28248a.f33864a;
            String f = Util.m24027f((int) C1761R.string.error_current_location);
            Intrinsics.m26843a((Object) f, "Util.getString(R.string.error_current_location)");
            obj.mo7346a(f);
        }
    }
}
