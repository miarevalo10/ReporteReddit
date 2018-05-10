package com.reddit.social.presentation.presentationobjects;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.TypeAdapter;
import paperparcel.internal.EnumAdapter;
import paperparcel.internal.StaticAdapters;
import paperparcel.internal.Utils;

final class PaperParcelContactData {
    static final TypeAdapter<UserStatus> f22458a = new EnumAdapter(UserStatus.class);
    static final Creator<ContactData> f22459b = new C19451();

    static class C19451 implements Creator<ContactData> {
        C19451() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ContactData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ContactData((String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), parcel.readInt() == 1, (UserStatus) PaperParcelContactData.f22458a.a(parcel), (Boolean) Utils.a(parcel, StaticAdapters.b), (Integer) Utils.a(parcel, StaticAdapters.a), (Long) Utils.a(parcel, StaticAdapters.e));
        }
    }

    private PaperParcelContactData() {
    }

    static void writeToParcel(ContactData contactData, Parcel parcel, int i) {
        StaticAdapters.x.a(contactData.f29927a, parcel, i);
        StaticAdapters.x.a(contactData.f29928b, parcel, i);
        StaticAdapters.x.a(contactData.f29929c, parcel, i);
        parcel.writeInt(contactData.f29930d);
        f22458a.a(contactData.f29931e, parcel, i);
        Utils.a(contactData.f29932f, parcel, i, StaticAdapters.b);
        Utils.a(contactData.f29933g, parcel, i, StaticAdapters.a);
        Utils.a(contactData.f29934h, parcel, i, StaticAdapters.e);
    }
}
