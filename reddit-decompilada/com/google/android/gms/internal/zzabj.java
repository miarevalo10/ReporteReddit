package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzn;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;

@zzzv
public final class zzabj extends zzbfm {
    public static final Creator<zzabj> CREATOR = new zzabl();
    private ParcelFileDescriptor f17469a;
    private Parcelable f17470b;
    private boolean f17471c;

    public zzabj(ParcelFileDescriptor parcelFileDescriptor) {
        this.f17469a = parcelFileDescriptor;
        this.f17470b = null;
        this.f17471c = true;
    }

    public zzabj(zzbfq com_google_android_gms_internal_zzbfq) {
        this.f17469a = null;
        this.f17470b = com_google_android_gms_internal_zzbfq;
        this.f17471c = false;
    }

    private final ParcelFileDescriptor m17703a() {
        if (this.f17469a == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.f17470b.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                this.f17469a = m17704a(marshall);
            } finally {
                obtain.recycle();
            }
        }
        return this.f17469a;
    }

    private static <T> ParcelFileDescriptor m17704a(byte[] bArr) {
        Throwable e;
        Closeable autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new zzabk(autoCloseOutputStream, bArr)).start();
                return createPipe[0];
            } catch (IOException e2) {
                e = e2;
                zzakb.m5367b("Error transporting the ad response", e);
                zzbs.m4490i().m13246a(e, "LargeParcelTeleporter.pipeData.2");
                zzn.m4907a(autoCloseOutputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            autoCloseOutputStream = null;
            zzakb.m5367b("Error transporting the ad response", e);
            zzbs.m4490i().m13246a(e, "LargeParcelTeleporter.pipeData.2");
            zzn.m4907a(autoCloseOutputStream);
            return null;
        }
    }

    public final <T extends zzbfq> T m17705a(Creator<T> creator) {
        Creator creator2;
        if (this.f17471c) {
            if (this.f17469a == null) {
                zzakb.m5368c("File descriptor is empty, returning null.");
                return null;
            }
            byte[] autoCloseInputStream = new AutoCloseInputStream(this.f17469a);
            Closeable dataInputStream = new DataInputStream(autoCloseInputStream);
            try {
                autoCloseInputStream = new byte[dataInputStream.readInt()];
                boolean z = false;
                dataInputStream.readFully(autoCloseInputStream, z, autoCloseInputStream.length);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(autoCloseInputStream, z, autoCloseInputStream.length);
                    obtain.setDataPosition(z);
                    this.f17470b = (zzbfq) creator2.createFromParcel(obtain);
                    this.f17471c = z;
                } finally {
                    obtain.recycle();
                }
            } catch (IOException e) {
                creator2 = e;
                autoCloseInputStream = "Could not read from parcel file descriptor";
                zzakb.m5367b(autoCloseInputStream, creator2);
                return null;
            } finally {
                zzn.m4907a(dataInputStream);
            }
        }
        return (zzbfq) this.f17470b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        m17703a();
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5544a(parcel, 2, this.f17469a, i);
        zzbfp.m5537a(parcel, a);
    }
}
