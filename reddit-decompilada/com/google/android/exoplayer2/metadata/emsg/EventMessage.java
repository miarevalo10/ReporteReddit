package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class EventMessage implements Entry {
    public static final Creator<EventMessage> CREATOR = new C03931();
    public final String f13222a;
    public final String f13223b;
    public final long f13224c;
    public final long f13225d;
    public final byte[] f13226e;
    private int f13227f;

    static class C03931 implements Creator<EventMessage> {
        C03931() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EventMessage[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr) {
        this.f13222a = str;
        this.f13223b = str2;
        this.f13224c = j;
        this.f13225d = j2;
        this.f13226e = bArr;
    }

    EventMessage(Parcel parcel) {
        this.f13222a = parcel.readString();
        this.f13223b = parcel.readString();
        this.f13224c = parcel.readLong();
        this.f13225d = parcel.readLong();
        this.f13226e = parcel.createByteArray();
    }

    public final int hashCode() {
        if (this.f13227f == 0) {
            int i = 0;
            int hashCode = (527 + (this.f13222a != null ? this.f13222a.hashCode() : 0)) * 31;
            if (this.f13223b != null) {
                i = this.f13223b.hashCode();
            }
            this.f13227f = (31 * (((((hashCode + i) * 31) + ((int) (this.f13224c ^ (this.f13224c >>> 32)))) * 31) + ((int) (this.f13225d ^ (this.f13225d >>> 32))))) + Arrays.hashCode(this.f13226e);
        }
        return this.f13227f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                EventMessage eventMessage = (EventMessage) obj;
                return this.f13224c == eventMessage.f13224c && this.f13225d == eventMessage.f13225d && Util.m4313a(this.f13222a, eventMessage.f13222a) && Util.m4313a(this.f13223b, eventMessage.f13223b) && Arrays.equals(this.f13226e, eventMessage.f13226e) != null;
            }
        }
        return false;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13222a);
        parcel.writeString(this.f13223b);
        parcel.writeLong(this.f13224c);
        parcel.writeLong(this.f13225d);
        parcel.writeByteArray(this.f13226e);
    }
}
