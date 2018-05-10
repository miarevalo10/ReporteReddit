package com.reddit.frontpage.ui.carousel;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.domain.model.Karma;
import paperparcel.TypeAdapter;
import paperparcel.internal.ParcelableAdapter;

final class PaperParcelKarmaCarouselItemPresentationModel {
    static final TypeAdapter<Karma> f21132a = new ParcelableAdapter();
    static final Creator<KarmaCarouselItemPresentationModel> f21133b = new C18811();

    static class C18811 implements Creator<KarmaCarouselItemPresentationModel> {
        C18811() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new KarmaCarouselItemPresentationModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new KarmaCarouselItemPresentationModel((Karma) PaperParcelKarmaCarouselItemPresentationModel.f21132a.a(parcel), parcel.readInt());
        }
    }

    private PaperParcelKarmaCarouselItemPresentationModel() {
    }

    static void writeToParcel(KarmaCarouselItemPresentationModel karmaCarouselItemPresentationModel, Parcel parcel, int i) {
        f21132a.a(karmaCarouselItemPresentationModel.f34223b, parcel, i);
        parcel.writeInt(karmaCarouselItemPresentationModel.f34224c);
    }
}
