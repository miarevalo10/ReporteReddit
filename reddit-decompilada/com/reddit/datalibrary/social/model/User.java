package com.reddit.datalibrary.social.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0013H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/reddit/datalibrary/social/model/User;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "user_id", "", "nickname", "profile_url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNickname", "()Ljava/lang/String;", "getProfile_url", "getUser_id", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: User.kt */
public final class User implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName(a = "nickname")
    private final String nickname;
    @SerializedName(a = "profile_url")
    private final String profile_url;
    @SerializedName(a = "user_id")
    private final String user_id;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/datalibrary/social/model/User$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/datalibrary/social/model/User;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/reddit/datalibrary/social/model/User;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: User.kt */
    public static final class CREATOR implements Creator<User> {
        private CREATOR() {
        }

        public final User createFromParcel(Parcel parcel) {
            Intrinsics.m26847b(parcel, "parcel");
            return new User(parcel);
        }

        public final User[] newArray(int i) {
            return new User[i];
        }
    }

    public static /* synthetic */ User copy$default(User user, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = user.user_id;
        }
        if ((i & 2) != 0) {
            str2 = user.nickname;
        }
        if ((i & 4) != 0) {
            str3 = user.profile_url;
        }
        return user.copy(str, str2, str3);
    }

    public final String component1() {
        return this.user_id;
    }

    public final String component2() {
        return this.nickname;
    }

    public final String component3() {
        return this.profile_url;
    }

    public final User copy(String str, String str2, String str3) {
        return new User(str, str2, str3);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof User) {
                User user = (User) obj;
                if (Intrinsics.m26845a(this.user_id, user.user_id) && Intrinsics.m26845a(this.nickname, user.nickname) && Intrinsics.m26845a(this.profile_url, user.profile_url)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.user_id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nickname;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.profile_url;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("User(user_id=");
        stringBuilder.append(this.user_id);
        stringBuilder.append(", nickname=");
        stringBuilder.append(this.nickname);
        stringBuilder.append(", profile_url=");
        stringBuilder.append(this.profile_url);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public User(String str, String str2, String str3) {
        this.user_id = str;
        this.nickname = str2;
        this.profile_url = str3;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getProfile_url() {
        return this.profile_url;
    }

    public User(Parcel parcel) {
        Intrinsics.m26847b(parcel, "parcel");
        this(parcel.readString(), parcel.readString(), parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "parcel");
        parcel.writeString(this.user_id);
        parcel.writeString(this.nickname);
        parcel.writeString(this.profile_url);
    }
}
