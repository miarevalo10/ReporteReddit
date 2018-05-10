package com.reddit.frontpage.presentation.carousel.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.domain.model.LinkType;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import paperparcel.TypeAdapter;
import paperparcel.internal.EnumAdapter;
import paperparcel.internal.ParcelableAdapter;
import paperparcel.internal.StaticAdapters;

final class PaperParcelLinkCarouselItemPresentationModel {
    static final TypeAdapter<LinkType> f20357a = new EnumAdapter(LinkType.class);
    static final TypeAdapter<LinkPresentationModel> f20358b = new ParcelableAdapter();
    static final Creator<LinkCarouselItemPresentationModel> f20359c = new C18071();

    static class C18071 implements Creator<LinkCarouselItemPresentationModel> {
        C18071() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LinkCarouselItemPresentationModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            return new LinkCarouselItemPresentationModel((String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readLong(), (LinkType) PaperParcelLinkCarouselItemPresentationModel.f20357a.a(parcel2), (LinkPresentationModel) PaperParcelLinkCarouselItemPresentationModel.f20358b.a(parcel2), parcel.readInt() == 1);
        }
    }

    private PaperParcelLinkCarouselItemPresentationModel() {
    }

    static void writeToParcel(LinkCarouselItemPresentationModel linkCarouselItemPresentationModel, Parcel parcel, int i) {
        StaticAdapters.x.a(linkCarouselItemPresentationModel.f28072a, parcel, i);
        StaticAdapters.x.a(linkCarouselItemPresentationModel.f28073b, parcel, i);
        StaticAdapters.x.a(linkCarouselItemPresentationModel.f28074c, parcel, i);
        StaticAdapters.x.a(linkCarouselItemPresentationModel.f28075d, parcel, i);
        parcel.writeInt(linkCarouselItemPresentationModel.f28076e);
        StaticAdapters.x.a(linkCarouselItemPresentationModel.f28077f, parcel, i);
        StaticAdapters.x.a(linkCarouselItemPresentationModel.f28078g, parcel, i);
        StaticAdapters.x.a(linkCarouselItemPresentationModel.f28079h, parcel, i);
        StaticAdapters.x.a(linkCarouselItemPresentationModel.f28080i, parcel, i);
        parcel.writeLong(linkCarouselItemPresentationModel.f28081j);
        f20357a.a(linkCarouselItemPresentationModel.f28082k, parcel, i);
        f20358b.a(linkCarouselItemPresentationModel.f28083l, parcel, i);
        parcel.writeInt(linkCarouselItemPresentationModel.f28084m);
    }
}
