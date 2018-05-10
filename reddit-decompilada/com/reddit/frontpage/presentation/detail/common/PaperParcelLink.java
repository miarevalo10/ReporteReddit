package com.reddit.frontpage.presentation.detail.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.domain.model.Link;
import paperparcel.TypeAdapter;
import paperparcel.internal.ParcelableAdapter;

final class PaperParcelLink {
    static final TypeAdapter<Link> f20507a = new ParcelableAdapter();
    static final Creator<Link> f20508b = new C18141();

    static class C18141 implements Creator<Link> {
        C18141() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Link[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Link((Link) PaperParcelLink.f20507a.a(parcel));
        }
    }

    private PaperParcelLink() {
    }

    static void writeToParcel(Link link, Parcel parcel, int i) {
        f20507a.a(link.f33844a, parcel, i);
    }
}
