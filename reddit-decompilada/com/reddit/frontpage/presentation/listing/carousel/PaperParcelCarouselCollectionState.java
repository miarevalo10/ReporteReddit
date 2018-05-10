package com.reddit.frontpage.presentation.listing.carousel;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Set;
import paperparcel.TypeAdapter;
import paperparcel.internal.SetAdapter;
import paperparcel.internal.StaticAdapters;

final class PaperParcelCarouselCollectionState {
    static final TypeAdapter<Set<String>> f20566a = new SetAdapter(StaticAdapters.x);
    static final Creator<CarouselCollectionState> f20567b = new C18191();

    static class C18191 implements Creator<CarouselCollectionState> {
        C18191() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CarouselCollectionState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CarouselCollectionState((Set) PaperParcelCarouselCollectionState.f20566a.a(parcel));
        }
    }

    private PaperParcelCarouselCollectionState() {
    }

    static void writeToParcel(CarouselCollectionState carouselCollectionState, Parcel parcel, int i) {
        f20566a.a(carouselCollectionState.getDismissedItems(), parcel, i);
    }
}
