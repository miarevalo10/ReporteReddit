package com.reddit.frontpage.presentation.geopopular.option;

import android.location.Address;
import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressEvent;
import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressEvent.Error;
import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressEvent.Result;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import io.reactivex.functions.BiConsumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "event", "Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressEvent;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularOptionsPresenter.kt */
final class GeopopularOptionsPresenter$fetchAddress$1<T1, T2> implements BiConsumer<GeocodedAddressEvent, Throwable> {
    final /* synthetic */ GeopopularOptionsPresenter f28239a;

    GeopopularOptionsPresenter$fetchAddress$1(GeopopularOptionsPresenter geopopularOptionsPresenter) {
        this.f28239a = geopopularOptionsPresenter;
    }

    public final /* synthetic */ void mo4825a(Object obj, Object obj2) {
        GeocodedAddressEvent geocodedAddressEvent = (GeocodedAddressEvent) obj;
        if ((geocodedAddressEvent instanceof Result) != null) {
            GeopopularOptionsPresenter.m34673a(this.f28239a, (Address) CollectionsKt___CollectionsKt.m41430d((List) ((Result) geocodedAddressEvent).a));
            return;
        }
        if ((geocodedAddressEvent instanceof Error) != null) {
            Timber.e("LocationDataProvider.publishLocation(): lastLocation is null", new Object[null]);
            obj = this.f28239a.f33857a;
            obj2 = Util.m24027f((int) C1761R.string.error_current_location);
            Intrinsics.m26843a(obj2, "Util.getString(R.string.error_current_location)");
            obj.a_(obj2);
        }
    }
}
