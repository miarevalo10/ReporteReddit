package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JR\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011¨\u0006#"}, d2 = {"Lcom/reddit/frontpage/domain/model/SubredditDetail;", "Lpaperparcel/PaperParcelable;", "kindWithId", "", "keyColor", "iconImage", "over18", "", "userIsModerator", "displayName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getIconImage", "getKeyColor", "getKindWithId", "getOver18", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUserIsModerator", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/reddit/frontpage/domain/model/SubredditDetail;", "equals", "other", "", "hashCode", "", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: Link.kt */
public final class SubredditDetail implements PaperParcelable {
    public static final Creator<SubredditDetail> CREATOR = PaperParcelSubredditDetail.CREATOR;
    public static final Companion Companion = new Companion();
    @Json(a = "display_name")
    private final String displayName;
    @Json(a = "icon_img")
    private final String iconImage;
    @Json(a = "key_color")
    private final String keyColor;
    @Json(a = "name")
    private final String kindWithId;
    private final Boolean over18;
    @Json(a = "user_is_moderator")
    private final Boolean userIsModerator;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/model/SubredditDetail$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/SubredditDetail;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Link.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static /* synthetic */ SubredditDetail copy$default(SubredditDetail subredditDetail, String str, String str2, String str3, Boolean bool, Boolean bool2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subredditDetail.kindWithId;
        }
        if ((i & 2) != 0) {
            str2 = subredditDetail.keyColor;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = subredditDetail.iconImage;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            bool = subredditDetail.over18;
        }
        Boolean bool3 = bool;
        if ((i & 16) != 0) {
            bool2 = subredditDetail.userIsModerator;
        }
        Boolean bool4 = bool2;
        if ((i & 32) != 0) {
            str4 = subredditDetail.displayName;
        }
        return subredditDetail.copy(str, str5, str6, bool3, bool4, str4);
    }

    public final String component1() {
        return this.kindWithId;
    }

    public final String component2() {
        return this.keyColor;
    }

    public final String component3() {
        return this.iconImage;
    }

    public final Boolean component4() {
        return this.over18;
    }

    public final Boolean component5() {
        return this.userIsModerator;
    }

    public final String component6() {
        return this.displayName;
    }

    public final SubredditDetail copy(String str, String str2, String str3, Boolean bool, Boolean bool2, String str4) {
        Intrinsics.m26847b(str, "kindWithId");
        Intrinsics.m26847b(str4, "displayName");
        return new SubredditDetail(str, str2, str3, bool, bool2, str4);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SubredditDetail) {
                SubredditDetail subredditDetail = (SubredditDetail) obj;
                if (Intrinsics.m26845a(this.kindWithId, subredditDetail.kindWithId) && Intrinsics.m26845a(this.keyColor, subredditDetail.keyColor) && Intrinsics.m26845a(this.iconImage, subredditDetail.iconImage) && Intrinsics.m26845a(this.over18, subredditDetail.over18) && Intrinsics.m26845a(this.userIsModerator, subredditDetail.userIsModerator) && Intrinsics.m26845a(this.displayName, subredditDetail.displayName)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.kindWithId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.keyColor;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.iconImage;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.over18;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.userIsModerator;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        str2 = this.displayName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SubredditDetail(kindWithId=");
        stringBuilder.append(this.kindWithId);
        stringBuilder.append(", keyColor=");
        stringBuilder.append(this.keyColor);
        stringBuilder.append(", iconImage=");
        stringBuilder.append(this.iconImage);
        stringBuilder.append(", over18=");
        stringBuilder.append(this.over18);
        stringBuilder.append(", userIsModerator=");
        stringBuilder.append(this.userIsModerator);
        stringBuilder.append(", displayName=");
        stringBuilder.append(this.displayName);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SubredditDetail(String str, String str2, String str3, Boolean bool, Boolean bool2, String str4) {
        Intrinsics.m26847b(str, "kindWithId");
        Intrinsics.m26847b(str4, "displayName");
        this.kindWithId = str;
        this.keyColor = str2;
        this.iconImage = str3;
        this.over18 = bool;
        this.userIsModerator = bool2;
        this.displayName = str4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final String getKindWithId() {
        return this.kindWithId;
    }

    public final String getKeyColor() {
        return this.keyColor;
    }

    public final String getIconImage() {
        return this.iconImage;
    }

    public final Boolean getOver18() {
        return this.over18;
    }

    public /* synthetic */ SubredditDetail(String str, String str2, String str3, Boolean bool, Boolean bool2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? Boolean.valueOf(false) : bool2, str4);
    }

    public final Boolean getUserIsModerator() {
        return this.userIsModerator;
    }

    public final String getDisplayName() {
        return this.displayName;
    }
}
