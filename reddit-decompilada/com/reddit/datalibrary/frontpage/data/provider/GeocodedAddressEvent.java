package com.reddit.datalibrary.frontpage.data.provider;

import android.location.Address;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressEvent;", "", "()V", "Error", "Result", "Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressEvent$Error;", "Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressEvent$Result;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeocodedAddressProvider.kt */
public abstract class GeocodedAddressEvent {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressEvent$Error;", "Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressEvent;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeocodedAddressProvider.kt */
    public static final class Error extends GeocodedAddressEvent {
        public static final Error f16238a = new Error();

        private Error() {
            super();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressEvent$Result;", "Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressEvent;", "result", "", "Landroid/location/Address;", "(Ljava/util/List;)V", "getResult", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeocodedAddressProvider.kt */
    public static final class Result extends GeocodedAddressEvent {
        public final List<Address> f16239a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Result) {
                    if (Intrinsics.a(this.f16239a, ((Result) obj).f16239a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            List list = this.f16239a;
            return list != null ? list.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Result(result=");
            stringBuilder.append(this.f16239a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Result(List<? extends Address> list) {
            Intrinsics.b(list, "result");
            super();
            this.f16239a = list;
        }
    }

    private GeocodedAddressEvent() {
    }
}
