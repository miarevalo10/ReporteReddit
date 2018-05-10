package com.reddit.social.presentation.presentationobjects;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 02\u00020\u0001:\u00010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BC\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0012JZ\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\nH\u0016J\u0013\u0010(\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\nHÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001J\u0018\u0010-\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\nH\u0016R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u000f\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019¨\u00061"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/UserData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "userId", "", "username", "iconUrl", "karma", "", "createdUtc", "", "blocked", "", "isNsfw", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/Boolean;Ljava/lang/Boolean;)V", "getBlocked", "()Ljava/lang/Boolean;", "setBlocked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCreatedUtc", "()J", "getIconUrl", "()Ljava/lang/String;", "getKarma", "()I", "getUserId", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/Boolean;Ljava/lang/Boolean;)Lcom/reddit/social/presentation/presentationobjects/UserData;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserData.kt */
public final class UserData implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    public final String f22464a;
    public final String f22465b;
    public final String f22466c;
    public final int f22467d;
    public final long f22468e;
    public Boolean f22469f;
    public final Boolean f22470g;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/UserData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/reddit/social/presentation/presentationobjects/UserData;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserData.kt */
    public static final class CREATOR implements Creator<UserData> {
        private CREATOR() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Intrinsics.m26847b(parcel, "parcel");
            return new UserData(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return (Object[]) new UserData[i];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserData) {
            UserData userData = (UserData) obj;
            if (Intrinsics.m26845a(this.f22464a, userData.f22464a) && Intrinsics.m26845a(this.f22465b, userData.f22465b) && Intrinsics.m26845a(this.f22466c, userData.f22466c)) {
                if (this.f22467d == userData.f22467d) {
                    return ((this.f22468e > userData.f22468e ? 1 : (this.f22468e == userData.f22468e ? 0 : -1)) == 0) && Intrinsics.m26845a(this.f22469f, userData.f22469f) && Intrinsics.m26845a(this.f22470g, userData.f22470g);
                }
            }
        }
    }

    public final int hashCode() {
        String str = this.f22464a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f22465b;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f22466c;
        hashCode = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f22467d) * 31;
        long j = this.f22468e;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        Boolean bool = this.f22469f;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.f22470g;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("UserData(userId=");
        stringBuilder.append(this.f22464a);
        stringBuilder.append(", username=");
        stringBuilder.append(this.f22465b);
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.f22466c);
        stringBuilder.append(", karma=");
        stringBuilder.append(this.f22467d);
        stringBuilder.append(", createdUtc=");
        stringBuilder.append(this.f22468e);
        stringBuilder.append(", blocked=");
        stringBuilder.append(this.f22469f);
        stringBuilder.append(", isNsfw=");
        stringBuilder.append(this.f22470g);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public UserData(String str, String str2, String str3, int i, long j, Boolean bool, Boolean bool2) {
        Intrinsics.m26847b(str, "userId");
        Intrinsics.m26847b(str2, "username");
        this.f22464a = str;
        this.f22465b = str2;
        this.f22466c = str3;
        this.f22467d = i;
        this.f22468e = j;
        this.f22469f = bool;
        this.f22470g = bool2;
    }

    public UserData(Parcel parcel) {
        Intrinsics.m26847b(parcel, "parcel");
        Object readString = parcel.readString();
        Intrinsics.m26843a(readString, "parcel.readString()");
        Object readString2 = parcel.readString();
        Intrinsics.m26843a(readString2, "parcel.readString()");
        String readString3 = parcel.readString();
        int readInt = parcel.readInt();
        long readLong = parcel.readLong();
        Object readValue = parcel.readValue(Boolean.TYPE.getClassLoader());
        if (!(readValue instanceof Boolean)) {
            readValue = null;
        }
        Boolean bool = (Boolean) readValue;
        parcel = parcel.readValue(Boolean.TYPE.getClassLoader());
        if (!(parcel instanceof Boolean)) {
            parcel = null;
        }
        this(readString, readString2, readString3, readInt, readLong, bool, (Boolean) parcel);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "parcel");
        parcel.writeString(this.f22464a);
        parcel.writeString(this.f22465b);
        parcel.writeString(this.f22466c);
        parcel.writeInt(this.f22467d);
        parcel.writeLong(this.f22468e);
        parcel.writeValue(this.f22469f);
        parcel.writeValue(this.f22470g);
    }
}
