package com.reddit.frontpage.presentation.carousel.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey;
import java.util.List;
import paperparcel.TypeAdapter;
import paperparcel.internal.ListAdapter;
import paperparcel.internal.ParcelableAdapter;
import paperparcel.internal.StaticAdapters;

final class PaperParcelGeneralCarouselCollectionPresentationModel {
    static final TypeAdapter<ICarouselItemPresentationModel> f20347a = new ParcelableAdapter();
    static final TypeAdapter<List<ICarouselItemPresentationModel>> f20348b = new ListAdapter(f20347a);
    static final TypeAdapter<DiscoveryUnit> f20349c = new ParcelableAdapter();
    static final TypeAdapter<CarouselCollectionStateKey> f20350d = new ParcelableAdapter();
    static final Creator<GeneralCarouselCollectionPresentationModel> f20351e = new C18051();

    static class C18051 implements Creator<GeneralCarouselCollectionPresentationModel> {
        C18051() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GeneralCarouselCollectionPresentationModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GeneralCarouselCollectionPresentationModel((String) StaticAdapters.x.a(parcel), parcel.readInt() == 1, parcel.readInt() == 1, (List) PaperParcelGeneralCarouselCollectionPresentationModel.f20348b.a(parcel), (String) StaticAdapters.x.a(parcel), parcel.readLong(), parcel.readInt() == 1, parcel.readInt(), (DiscoveryUnit) PaperParcelGeneralCarouselCollectionPresentationModel.f20349c.a(parcel), (CarouselCollectionStateKey) PaperParcelGeneralCarouselCollectionPresentationModel.f20350d.a(parcel));
        }
    }

    private PaperParcelGeneralCarouselCollectionPresentationModel() {
    }

    static void writeToParcel(GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel, Parcel parcel, int i) {
        StaticAdapters.x.a(generalCarouselCollectionPresentationModel.f36354b, parcel, i);
        parcel.writeInt(generalCarouselCollectionPresentationModel.f36355c);
        parcel.writeInt(generalCarouselCollectionPresentationModel.f36356d);
        f20348b.a(generalCarouselCollectionPresentationModel.f36357e, parcel, i);
        StaticAdapters.x.a(generalCarouselCollectionPresentationModel.f36358f, parcel, i);
        parcel.writeLong(generalCarouselCollectionPresentationModel.f36359g);
        parcel.writeInt(generalCarouselCollectionPresentationModel.f36360h);
        parcel.writeInt(generalCarouselCollectionPresentationModel.getListableType());
        f20349c.a(generalCarouselCollectionPresentationModel.f36361i, parcel, i);
        f20350d.a(generalCarouselCollectionPresentationModel.f36362j, parcel, i);
    }
}
