package com.reddit.frontpage.domain.repository;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey;
import paperparcel.internal.StaticAdapters;

final class PaperParcelPreferenceRepository_CarouselCollectionStateKey {
    static final Creator<CarouselCollectionStateKey> f20259a = new C18011();

    static class C18011 implements Creator<CarouselCollectionStateKey> {
        C18011() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CarouselCollectionStateKey[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CarouselCollectionStateKey((String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel));
        }
    }

    private PaperParcelPreferenceRepository_CarouselCollectionStateKey() {
    }

    static void writeToParcel(CarouselCollectionStateKey carouselCollectionStateKey, Parcel parcel, int i) {
        StaticAdapters.x.a(carouselCollectionStateKey.f27954a, parcel, i);
        StaticAdapters.x.a(carouselCollectionStateKey.f27955b, parcel, i);
        StaticAdapters.x.a(carouselCollectionStateKey.f27956c, parcel, i);
    }
}
