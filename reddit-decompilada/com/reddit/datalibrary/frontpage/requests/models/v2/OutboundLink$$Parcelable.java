package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import net.hockeyapp.android.UpdateFragment;
import org.parceler.IdentityCollection;
import org.parceler.InjectionUtil;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class OutboundLink$$Parcelable implements Parcelable, ParcelWrapper<OutboundLink> {
    public static final Creator<OutboundLink$$Parcelable> CREATOR = new C17491();
    private OutboundLink outboundLink$$0;

    /* compiled from: OutboundLink$$Parcelable */
    static class C17491 implements Creator<OutboundLink$$Parcelable> {
        C17491() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new OutboundLink$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new OutboundLink$$Parcelable(OutboundLink$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public OutboundLink$$Parcelable(OutboundLink outboundLink) {
        this.outboundLink$$0 = outboundLink;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.outboundLink$$0, parcel, i, new IdentityCollection());
    }

    public static void write(OutboundLink outboundLink, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) outboundLink);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) outboundLink));
        if (InjectionUtil.m28667a(OutboundLink.class, outboundLink, "created") == 0) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(((Long) InjectionUtil.m28667a(OutboundLink.class, outboundLink, "created")).longValue());
        }
        if (InjectionUtil.m28667a(OutboundLink.class, outboundLink, "expiration") == 0) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(((Long) InjectionUtil.m28667a(OutboundLink.class, outboundLink, "expiration")).longValue());
        }
        parcel.writeString((String) InjectionUtil.m28667a(OutboundLink.class, outboundLink, UpdateFragment.FRAGMENT_URL));
    }

    public OutboundLink getParcel() {
        return this.outboundLink$$0;
    }

    public static OutboundLink read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            Object obj;
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            OutboundLink outboundLink = new OutboundLink();
            identityCollection.m28661a(a, outboundLink);
            Object obj2 = null;
            if (parcel.readInt() < 0) {
                obj = null;
            } else {
                obj = Long.valueOf(parcel.readLong());
            }
            InjectionUtil.m28668a(OutboundLink.class, outboundLink, "created", obj);
            if (parcel.readInt() >= 0) {
                obj2 = Long.valueOf(parcel.readLong());
            }
            InjectionUtil.m28668a(OutboundLink.class, outboundLink, "expiration", obj2);
            InjectionUtil.m28668a(OutboundLink.class, outboundLink, UpdateFragment.FRAGMENT_URL, parcel.readString());
            identityCollection.m28661a(readInt, outboundLink);
            return outboundLink;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (OutboundLink) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
