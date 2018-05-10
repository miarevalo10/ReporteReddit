package com.reddit.frontpage.presentation.carousel.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.domain.model.Subreddit;
import paperparcel.TypeAdapter;
import paperparcel.internal.ParcelableAdapter;
import paperparcel.internal.StaticAdapters;

final class PaperParcelSubredditCarouselItemPresentationModel {
    static final TypeAdapter<Subreddit> f20360a = new ParcelableAdapter();
    static final Creator<SubredditCarouselItemPresentationModel> f20361b = new C18081();

    static class C18081 implements Creator<SubredditCarouselItemPresentationModel> {
        C18081() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SubredditCarouselItemPresentationModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SubredditCarouselItemPresentationModel((Subreddit) PaperParcelSubredditCarouselItemPresentationModel.f20360a.a(parcel), (String) StaticAdapters.x.a(parcel), parcel.readInt(), parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1);
        }
    }

    private PaperParcelSubredditCarouselItemPresentationModel() {
    }

    static void writeToParcel(SubredditCarouselItemPresentationModel subredditCarouselItemPresentationModel, Parcel parcel, int i) {
        f20360a.a(subredditCarouselItemPresentationModel.f33784b, parcel, i);
        StaticAdapters.x.a(subredditCarouselItemPresentationModel.f33785c, parcel, i);
        parcel.writeInt(subredditCarouselItemPresentationModel.f33786d);
        parcel.writeInt(subredditCarouselItemPresentationModel.f33787e);
        parcel.writeInt(subredditCarouselItemPresentationModel.f33788f);
        parcel.writeInt(subredditCarouselItemPresentationModel.f33789g);
    }
}
