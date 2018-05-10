package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class CredentialPickerConfig extends zzbfm implements ReflectedParcelable {
    public static final Creator<CredentialPickerConfig> CREATOR = new zzc();
    private int f17209a;
    private final boolean f17210b;
    private final boolean f17211c;
    @Deprecated
    private final boolean f17212d;
    private final int f17213e;

    public static class Builder {
        private boolean f5686a = false;
        private boolean f5687b = true;
        private int f5688c = 1;

        public final CredentialPickerConfig m4574a() {
            return new CredentialPickerConfig();
        }
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3, int i2) {
        this.f17209a = i;
        this.f17210b = z;
        this.f17211c = z2;
        z = true;
        if (i < 2) {
            int i3;
            this.f17212d = z3;
            if (z3) {
                i3 = 3;
            }
            this.f17213e = i3;
            return;
        }
        if (i2 != 3) {
            z = false;
        }
        this.f17212d = z;
        this.f17213e = i2;
    }

    private CredentialPickerConfig(Builder builder) {
        this(2, builder.f5686a, builder.f5687b, false, builder.f5688c);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        boolean z = true;
        zzbfp.m5547a(parcel, 1, this.f17210b);
        zzbfp.m5547a(parcel, 2, this.f17211c);
        if (this.f17213e != 3) {
            z = false;
        }
        zzbfp.m5547a(parcel, 3, z);
        zzbfp.m5540a(parcel, 4, this.f17213e);
        zzbfp.m5540a(parcel, 1000, this.f17209a);
        zzbfp.m5537a(parcel, i);
    }
}
