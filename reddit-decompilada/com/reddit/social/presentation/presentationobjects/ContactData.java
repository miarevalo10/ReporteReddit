package com.reddit.social.presentation.presentationobjects;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b'\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 92\u00020\u0001:\u00019BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00101\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0011Jh\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\fHÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\n\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016¨\u0006:"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/ContactData;", "Lpaperparcel/PaperParcelable;", "username", "", "iconUrl", "userId", "selected", "", "status", "Lcom/reddit/social/presentation/presentationobjects/UserStatus;", "isNsfw", "karma", "", "createdUtc", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/reddit/social/presentation/presentationobjects/UserStatus;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;)V", "getCreatedUtc", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setNsfw", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getKarma", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSelected", "()Z", "setSelected", "(Z)V", "getStatus", "()Lcom/reddit/social/presentation/presentationobjects/UserStatus;", "setStatus", "(Lcom/reddit/social/presentation/presentationobjects/UserStatus;)V", "getUserId", "setUserId", "getUsername", "setUsername", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/reddit/social/presentation/presentationobjects/UserStatus;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/reddit/social/presentation/presentationobjects/ContactData;", "equals", "other", "", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: ContactData.kt */
public final class ContactData implements PaperParcelable {
    public static final Creator<ContactData> CREATOR = PaperParcelContactData.f22459b;
    public static final Companion f29926i = new Companion();
    public String f29927a;
    public String f29928b;
    public String f29929c;
    public boolean f29930d;
    public UserStatus f29931e;
    public Boolean f29932f;
    public final Integer f29933g;
    public final Long f29934h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/ContactData$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ContactData.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContactData) {
            ContactData contactData = (ContactData) obj;
            if (Intrinsics.m26845a(this.f29927a, contactData.f29927a) && Intrinsics.m26845a(this.f29928b, contactData.f29928b) && Intrinsics.m26845a(this.f29929c, contactData.f29929c)) {
                return (this.f29930d == contactData.f29930d) && Intrinsics.m26845a(this.f29931e, contactData.f29931e) && Intrinsics.m26845a(this.f29932f, contactData.f29932f) && Intrinsics.m26845a(this.f29933g, contactData.f29933g) && Intrinsics.m26845a(this.f29934h, contactData.f29934h);
            }
        }
    }

    public final int hashCode() {
        String str = this.f29927a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f29928b;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f29929c;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        int i2 = this.f29930d;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        UserStatus userStatus = this.f29931e;
        hashCode = (hashCode + (userStatus != null ? userStatus.hashCode() : 0)) * 31;
        Boolean bool = this.f29932f;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Integer num = this.f29933g;
        hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Long l = this.f29934h;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ContactData(username=");
        stringBuilder.append(this.f29927a);
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.f29928b);
        stringBuilder.append(", userId=");
        stringBuilder.append(this.f29929c);
        stringBuilder.append(", selected=");
        stringBuilder.append(this.f29930d);
        stringBuilder.append(", status=");
        stringBuilder.append(this.f29931e);
        stringBuilder.append(", isNsfw=");
        stringBuilder.append(this.f29932f);
        stringBuilder.append(", karma=");
        stringBuilder.append(this.f29933g);
        stringBuilder.append(", createdUtc=");
        stringBuilder.append(this.f29934h);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ContactData(String str, String str2, String str3, boolean z, UserStatus userStatus, Boolean bool, Integer num, Long l) {
        Intrinsics.m26847b(str, "username");
        Intrinsics.m26847b(userStatus, "status");
        this.f29927a = str;
        this.f29928b = str2;
        this.f29929c = str3;
        this.f29930d = z;
        this.f29931e = userStatus;
        this.f29932f = bool;
        this.f29933g = num;
        this.f29934h = l;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public /* synthetic */ ContactData(String str, String str2, String str3, UserStatus userStatus, Boolean bool, Integer num, Long l, int i) {
        int i2 = i;
        this(str, str2, str3, false, (i2 & 16) != 0 ? UserStatus.f22477g : userStatus, (i2 & 32) != 0 ? null : bool, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? null : l);
    }

    public final void m30886a(UserStatus userStatus) {
        Intrinsics.m26847b(userStatus, "<set-?>");
        this.f29931e = userStatus;
    }
}
