package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 82\u00020\u0001:\u00018Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\t\u0010(\u001a\u00020\u0010HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\rHÆ\u0003J\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00103\u001a\u00020\u00102\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\tHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\"\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b#\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018¨\u00069"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v2/KarmaItem;", "Lpaperparcel/PaperParcelable;", "iconImage", "", "bannerImage", "subredditName", "subredditDisplayNamePrefixed", "keyColor", "linkKarma", "", "commentKarma", "subscribers", "iconSize", "", "bannerSize", "isSubscribed", "", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III[I[IZLjava/lang/String;)V", "getBannerImage", "()Ljava/lang/String;", "getBannerSize", "()[I", "getCommentKarma", "()I", "getIconImage", "getIconSize", "()Z", "setSubscribed", "(Z)V", "getKeyColor", "getLinkKarma", "getName", "getSubredditDisplayNamePrefixed", "subredditId", "getSubredditId", "getSubredditName", "getSubscribers", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: KarmaItem.kt */
public final class KarmaItem implements PaperParcelable {
    public static final Creator<KarmaItem> CREATOR = PaperParcelKarmaItem.CREATOR;
    public static final Companion Companion = new Companion();
    final String bannerImage;
    final int[] bannerSize;
    final int commentKarma;
    final String iconImage;
    final int[] iconSize;
    boolean isSubscribed;
    final String keyColor;
    final int linkKarma;
    final String name;
    final String subredditDisplayNamePrefixed;
    final String subredditName;
    final int subscribers;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v2/KarmaItem$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/KarmaItem;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: KarmaItem.kt */
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
        if (obj instanceof KarmaItem) {
            KarmaItem karmaItem = (KarmaItem) obj;
            if (Intrinsics.m26845a(this.iconImage, karmaItem.iconImage) && Intrinsics.m26845a(this.bannerImage, karmaItem.bannerImage) && Intrinsics.m26845a(this.subredditName, karmaItem.subredditName) && Intrinsics.m26845a(this.subredditDisplayNamePrefixed, karmaItem.subredditDisplayNamePrefixed) && Intrinsics.m26845a(this.keyColor, karmaItem.keyColor)) {
                if (this.linkKarma == karmaItem.linkKarma) {
                    if (this.commentKarma == karmaItem.commentKarma) {
                        if ((this.subscribers == karmaItem.subscribers) && Intrinsics.m26845a(this.iconSize, karmaItem.iconSize) && Intrinsics.m26845a(this.bannerSize, karmaItem.bannerSize)) {
                            return (this.isSubscribed == karmaItem.isSubscribed) && Intrinsics.m26845a(this.name, karmaItem.name);
                        }
                    }
                }
            }
        }
    }

    public final int hashCode() {
        String str = this.iconImage;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bannerImage;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.subredditName;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.subredditDisplayNamePrefixed;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.keyColor;
        hashCode = (((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.linkKarma) * 31) + this.commentKarma) * 31) + this.subscribers) * 31;
        int[] iArr = this.iconSize;
        hashCode = (hashCode + (iArr != null ? Arrays.hashCode(iArr) : 0)) * 31;
        iArr = this.bannerSize;
        hashCode = (hashCode + (iArr != null ? Arrays.hashCode(iArr) : 0)) * 31;
        int i2 = this.isSubscribed;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str2 = this.name;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("KarmaItem(iconImage=");
        stringBuilder.append(this.iconImage);
        stringBuilder.append(", bannerImage=");
        stringBuilder.append(this.bannerImage);
        stringBuilder.append(", subredditName=");
        stringBuilder.append(this.subredditName);
        stringBuilder.append(", subredditDisplayNamePrefixed=");
        stringBuilder.append(this.subredditDisplayNamePrefixed);
        stringBuilder.append(", keyColor=");
        stringBuilder.append(this.keyColor);
        stringBuilder.append(", linkKarma=");
        stringBuilder.append(this.linkKarma);
        stringBuilder.append(", commentKarma=");
        stringBuilder.append(this.commentKarma);
        stringBuilder.append(", subscribers=");
        stringBuilder.append(this.subscribers);
        stringBuilder.append(", iconSize=");
        stringBuilder.append(Arrays.toString(this.iconSize));
        stringBuilder.append(", bannerSize=");
        stringBuilder.append(Arrays.toString(this.bannerSize));
        stringBuilder.append(", isSubscribed=");
        stringBuilder.append(this.isSubscribed);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public KarmaItem(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int[] iArr, int[] iArr2, boolean z, String str6) {
        Intrinsics.m26847b(str, "iconImage");
        Intrinsics.m26847b(str2, "bannerImage");
        Intrinsics.m26847b(str3, "subredditName");
        Intrinsics.m26847b(str4, "subredditDisplayNamePrefixed");
        Intrinsics.m26847b(str5, "keyColor");
        Intrinsics.m26847b(iArr, "iconSize");
        Intrinsics.m26847b(iArr2, "bannerSize");
        Intrinsics.m26847b(str6, "name");
        this.iconImage = str;
        this.bannerImage = str2;
        this.subredditName = str3;
        this.subredditDisplayNamePrefixed = str4;
        this.keyColor = str5;
        this.linkKarma = i;
        this.commentKarma = i2;
        this.subscribers = i3;
        this.iconSize = iArr;
        this.bannerSize = iArr2;
        this.isSubscribed = z;
        this.name = str6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }
}
