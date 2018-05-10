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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/reddit/frontpage/domain/model/SubredditCategory;", "Lpaperparcel/PaperParcelable;", "id", "", "name", "color", "icon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getIcon", "getId", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: SubredditCategory.kt */
public final class SubredditCategory implements PaperParcelable {
    public static final Creator<SubredditCategory> CREATOR = PaperParcelSubredditCategory.CREATOR;
    public static final Companion Companion = new Companion();
    @Json(a = "category_color")
    private final String color;
    @Json(a = "category_icon")
    private final String icon;
    @Json(a = "category_id")
    private final String id;
    @Json(a = "category_name")
    private final String name;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/model/SubredditCategory$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SubredditCategory.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static /* synthetic */ SubredditCategory copy$default(SubredditCategory subredditCategory, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subredditCategory.id;
        }
        if ((i & 2) != 0) {
            str2 = subredditCategory.name;
        }
        if ((i & 4) != 0) {
            str3 = subredditCategory.color;
        }
        if ((i & 8) != 0) {
            str4 = subredditCategory.icon;
        }
        return subredditCategory.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.color;
    }

    public final String component4() {
        return this.icon;
    }

    public final SubredditCategory copy(String str, String str2, String str3, String str4) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(str2, "name");
        return new SubredditCategory(str, str2, str3, str4);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SubredditCategory) {
                SubredditCategory subredditCategory = (SubredditCategory) obj;
                if (Intrinsics.m26845a(this.id, subredditCategory.id) && Intrinsics.m26845a(this.name, subredditCategory.name) && Intrinsics.m26845a(this.color, subredditCategory.color) && Intrinsics.m26845a(this.icon, subredditCategory.icon)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.color;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.icon;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SubredditCategory(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", color=");
        stringBuilder.append(this.color);
        stringBuilder.append(", icon=");
        stringBuilder.append(this.icon);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SubredditCategory(String str, String str2, String str3, String str4) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(str2, "name");
        this.id = str;
        this.name = str2;
        this.color = str3;
        this.icon = str4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getColor() {
        return this.color;
    }

    public /* synthetic */ SubredditCategory(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != null) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        this(str, str2, str3, str4);
    }

    public final String getIcon() {
        return this.icon;
    }
}
