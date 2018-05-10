package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import java.util.List;
import org.parceler.Parcels;
import org.parceler.converter.NullableParcelConverter;

public class AutoParcelConverter extends NullableParcelConverter<List<?>> {
    public final /* synthetic */ void mo6867a(Object obj, Parcel parcel) {
        parcel.writeParcelable(Parcels.m28672a((List) obj), 0);
    }

    public final /* synthetic */ Object mo6866a(Parcel parcel) {
        return (List) Parcels.m28673a(parcel.readParcelable(getClass().getClassLoader()));
    }
}
