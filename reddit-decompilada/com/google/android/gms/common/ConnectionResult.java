package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class ConnectionResult extends zzbfm {
    public static final Creator<ConnectionResult> CREATOR = new zzb();
    public static final ConnectionResult f17256a = new ConnectionResult(0);
    public final int f17257b;
    public final PendingIntent f17258c;
    public final String f17259d;
    private int f17260e;

    public ConnectionResult(int i) {
        this(i, null, (byte) 0);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f17260e = i;
        this.f17257b = i2;
        this.f17258c = pendingIntent;
        this.f17259d = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, (byte) 0);
    }

    private ConnectionResult(int i, PendingIntent pendingIntent, byte b) {
        this(1, i, pendingIntent, null);
    }

    static String m17582a(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder stringBuilder = new StringBuilder(31);
                        stringBuilder.append("UNKNOWN_ERROR_CODE(");
                        stringBuilder.append(i);
                        stringBuilder.append(")");
                        return stringBuilder.toString();
                }
        }
    }

    public final boolean m17583a() {
        return (this.f17257b == 0 || this.f17258c == null) ? false : true;
    }

    public final boolean m17584b() {
        return this.f17257b == 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f17257b == connectionResult.f17257b && zzbg.m4806a(this.f17258c, connectionResult.f17258c) && zzbg.m4806a(this.f17259d, connectionResult.f17259d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f17257b), this.f17258c, this.f17259d});
    }

    public final String toString() {
        return zzbg.m4805a(this).m4807a("statusCode", m17582a(this.f17257b)).m4807a("resolution", this.f17258c).m4807a("message", this.f17259d).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17260e);
        zzbfp.m5540a(parcel, 2, this.f17257b);
        zzbfp.m5544a(parcel, 3, this.f17258c, i);
        zzbfp.m5545a(parcel, 4, this.f17259d);
        zzbfp.m5537a(parcel, a);
    }
}
