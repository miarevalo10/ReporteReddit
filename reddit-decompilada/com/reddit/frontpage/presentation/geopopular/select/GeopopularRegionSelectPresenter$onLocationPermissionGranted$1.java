package com.reddit.frontpage.presentation.geopopular.select;

import android.location.Address;
import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressEvent;
import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressEvent.Error;
import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressEvent.Result;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectPresenter.GeocodeAddressFilterResult.Success;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeocodeAddressFilterResult;", "kotlin.jvm.PlatformType", "event", "Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressEvent;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectPresenter.kt */
final class GeopopularRegionSelectPresenter$onLocationPermissionGranted$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ GeopopularRegionSelectPresenter f28247a;

    GeopopularRegionSelectPresenter$onLocationPermissionGranted$1(GeopopularRegionSelectPresenter geopopularRegionSelectPresenter) {
        this.f28247a = geopopularRegionSelectPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        GeocodedAddressEvent geocodedAddressEvent = (GeocodedAddressEvent) obj;
        Intrinsics.m26847b(geocodedAddressEvent, "event");
        if (geocodedAddressEvent instanceof Result) {
            final GeopopularRegionSelectFilter geopopularRegionSelectFilter = (GeopopularRegionSelectFilter) GeopopularRegionSelectPresenter.m34681a(this.f28247a, (Address) CollectionsKt___CollectionsKt.m41430d((List) ((Result) geocodedAddressEvent).a)).f25267a;
            return this.f28247a.f33870h.m22467a(geopopularRegionSelectFilter).toSingle(new Callable<Success>() {
                public final /* synthetic */ Object call() {
                    return new Success(geopopularRegionSelectFilter);
                }
            });
        } else if ((geocodedAddressEvent instanceof Error) != null) {
            Timber.e("LocationDataProvider.publishLocation(): lastLocation is null", new Object[0]);
            return Single.just(GeocodeAddressFilterResult.Error.f28240a);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
