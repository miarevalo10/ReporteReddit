package com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit.SurfaceParameters;
import paperparcel.internal.StaticAdapters;
import paperparcel.internal.Utils;

final class PaperParcelDiscoveryUnit_SurfaceParameters {
    static final Creator<SurfaceParameters> CREATOR = new C09521();

    static class C09521 implements Creator<SurfaceParameters> {
        C09521() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SurfaceParameters[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SurfaceParameters((Boolean) Utils.a(parcel, StaticAdapters.b));
        }
    }

    private PaperParcelDiscoveryUnit_SurfaceParameters() {
    }

    static void writeToParcel(SurfaceParameters surfaceParameters, Parcel parcel, int i) {
        Utils.a(surfaceParameters.show_if_subscribed, parcel, i, StaticAdapters.b);
    }
}
