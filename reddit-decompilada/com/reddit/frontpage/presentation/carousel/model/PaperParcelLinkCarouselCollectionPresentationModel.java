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
import paperparcel.internal.Utils;

final class PaperParcelLinkCarouselCollectionPresentationModel {
    static final TypeAdapter<LinkCarouselItemPresentationModel> f20352a = new ParcelableAdapter();
    static final TypeAdapter<List<LinkCarouselItemPresentationModel>> f20353b = new ListAdapter(f20352a);
    static final TypeAdapter<DiscoveryUnit> f20354c = new ParcelableAdapter();
    static final TypeAdapter<CarouselCollectionStateKey> f20355d = new ParcelableAdapter();
    static final Creator<LinkCarouselCollectionPresentationModel> f20356e = new C18061();

    static class C18061 implements Creator<LinkCarouselCollectionPresentationModel> {
        C18061() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LinkCarouselCollectionPresentationModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            return new LinkCarouselCollectionPresentationModel((String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (Integer) Utils.a(parcel2, StaticAdapters.a), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, parcel.readInt() == 1, (List) PaperParcelLinkCarouselCollectionPresentationModel.f20353b.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readLong(), parcel.readInt(), (DiscoveryUnit) PaperParcelLinkCarouselCollectionPresentationModel.f20354c.a(parcel2), (CarouselCollectionStateKey) PaperParcelLinkCarouselCollectionPresentationModel.f20355d.a(parcel2));
        }
    }

    private PaperParcelLinkCarouselCollectionPresentationModel() {
    }

    static void writeToParcel(LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel, Parcel parcel, int i) {
        StaticAdapters.x.a(linkCarouselCollectionPresentationModel.f36365b, parcel, i);
        StaticAdapters.x.a(linkCarouselCollectionPresentationModel.f36366c, parcel, i);
        Utils.a(linkCarouselCollectionPresentationModel.f36367d, parcel, i, StaticAdapters.a);
        StaticAdapters.x.a(linkCarouselCollectionPresentationModel.f36368e, parcel, i);
        StaticAdapters.x.a(linkCarouselCollectionPresentationModel.f36369f, parcel, i);
        StaticAdapters.x.a(linkCarouselCollectionPresentationModel.f36370g, parcel, i);
        StaticAdapters.x.a(linkCarouselCollectionPresentationModel.f36371h, parcel, i);
        parcel.writeInt(linkCarouselCollectionPresentationModel.f36372i);
        parcel.writeInt(linkCarouselCollectionPresentationModel.f36373j);
        f20353b.a(linkCarouselCollectionPresentationModel.f36374k, parcel, i);
        StaticAdapters.x.a(linkCarouselCollectionPresentationModel.f36375l, parcel, i);
        parcel.writeLong(linkCarouselCollectionPresentationModel.f36376m);
        parcel.writeInt(linkCarouselCollectionPresentationModel.getListableType());
        f20354c.a(linkCarouselCollectionPresentationModel.f36377n, parcel, i);
        f20355d.a(linkCarouselCollectionPresentationModel.f36378o, parcel, i);
    }
}
