package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.AdRequest;
import com.reddit.datalibrary.frontpage.data.model.RedditModel;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011Bm\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u000fHÆ\u0003J\t\u0010\"\u001a\u00020\u000fHÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J{\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fHÆ\u0001J\u0013\u0010,\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u000bHÖ\u0001J\t\u00100\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00048\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\r\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0016\u0010\u0010\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001b¨\u00062"}, d2 = {"Lcom/reddit/frontpage/domain/model/Karma;", "Lcom/reddit/datalibrary/frontpage/data/model/RedditModel;", "Lpaperparcel/PaperParcelable;", "kindWithId", "", "iconUrl", "bannerUrl", "subreddit", "subredditPrefixed", "keyColor", "linkKarma", "", "commentKarmaCount", "subscriberCount", "over18", "", "userIsSubscriber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIZZ)V", "getBannerUrl", "()Ljava/lang/String;", "getCommentKarmaCount", "()I", "getIconUrl", "getKeyColor", "getKindWithId", "getLinkKarma", "getOver18", "()Z", "getSubreddit", "getSubredditPrefixed", "getSubscriberCount", "getUserIsSubscriber", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: Karma.kt */
public final class Karma implements RedditModel, PaperParcelable {
    public static final Creator<Karma> CREATOR = PaperParcelKarma.CREATOR;
    public static final Companion Companion = new Companion();
    @Json(a = "banner_img")
    private final String bannerUrl;
    @Json(a = "comment_karma")
    private final int commentKarmaCount;
    @Json(a = "icon_img")
    private final String iconUrl;
    @Json(a = "key_color")
    private final String keyColor;
    @Json(a = "name")
    private final String kindWithId;
    @Json(a = "link_karma")
    private final int linkKarma;
    @Json(a = "over_18")
    private final boolean over18;
    @Json(a = "sr")
    private final String subreddit;
    @Json(a = "sr_display_name_prefixed")
    private final String subredditPrefixed;
    @Json(a = "subscribers")
    private final int subscriberCount;
    @Json(a = "user_is_subscriber")
    private final boolean userIsSubscriber;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/model/Karma$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/Karma;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Karma.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static /* synthetic */ Karma copy$default(Karma karma, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        Karma karma2 = karma;
        int i5 = i4;
        return karma2.copy((i5 & 1) != 0 ? karma2.getKindWithId() : str, (i5 & 2) != 0 ? karma2.iconUrl : str2, (i5 & 4) != 0 ? karma2.bannerUrl : str3, (i5 & 8) != 0 ? karma2.subreddit : str4, (i5 & 16) != 0 ? karma2.subredditPrefixed : str5, (i5 & 32) != 0 ? karma2.keyColor : str6, (i5 & 64) != 0 ? karma2.linkKarma : i, (i5 & 128) != 0 ? karma2.commentKarmaCount : i2, (i5 & 256) != 0 ? karma2.subscriberCount : i3, (i5 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? karma2.over18 : z, (i5 & 1024) != 0 ? karma2.userIsSubscriber : z2);
    }

    public final String component1() {
        return getKindWithId();
    }

    public final boolean component10() {
        return this.over18;
    }

    public final boolean component11() {
        return this.userIsSubscriber;
    }

    public final String component2() {
        return this.iconUrl;
    }

    public final String component3() {
        return this.bannerUrl;
    }

    public final String component4() {
        return this.subreddit;
    }

    public final String component5() {
        return this.subredditPrefixed;
    }

    public final String component6() {
        return this.keyColor;
    }

    public final int component7() {
        return this.linkKarma;
    }

    public final int component8() {
        return this.commentKarmaCount;
    }

    public final int component9() {
        return this.subscriberCount;
    }

    public final Karma copy(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3, boolean z, boolean z2) {
        String str7 = str;
        Intrinsics.m26847b(str7, "kindWithId");
        String str8 = str2;
        Intrinsics.m26847b(str8, "iconUrl");
        String str9 = str4;
        Intrinsics.m26847b(str9, "subreddit");
        String str10 = str5;
        Intrinsics.m26847b(str10, "subredditPrefixed");
        return new Karma(str7, str8, str3, str9, str10, str6, i, i2, i3, z, z2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Karma) {
            Karma karma = (Karma) obj;
            if (Intrinsics.m26845a(getKindWithId(), karma.getKindWithId()) && Intrinsics.m26845a(this.iconUrl, karma.iconUrl) && Intrinsics.m26845a(this.bannerUrl, karma.bannerUrl) && Intrinsics.m26845a(this.subreddit, karma.subreddit) && Intrinsics.m26845a(this.subredditPrefixed, karma.subredditPrefixed) && Intrinsics.m26845a(this.keyColor, karma.keyColor)) {
                if (this.linkKarma == karma.linkKarma) {
                    if (this.commentKarmaCount == karma.commentKarmaCount) {
                        if (this.subscriberCount == karma.subscriberCount) {
                            if (this.over18 == karma.over18) {
                                if (this.userIsSubscriber == karma.userIsSubscriber) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String kindWithId = getKindWithId();
        int i = 0;
        int hashCode = (kindWithId != null ? kindWithId.hashCode() : 0) * 31;
        String str = this.iconUrl;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.bannerUrl;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.subreddit;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.subredditPrefixed;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.keyColor;
        if (str != null) {
            i = str.hashCode();
        }
        hashCode = (((((((hashCode + i) * 31) + this.linkKarma) * 31) + this.commentKarmaCount) * 31) + this.subscriberCount) * 31;
        i = this.over18;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.userIsSubscriber;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Karma(kindWithId=");
        stringBuilder.append(getKindWithId());
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append(", bannerUrl=");
        stringBuilder.append(this.bannerUrl);
        stringBuilder.append(", subreddit=");
        stringBuilder.append(this.subreddit);
        stringBuilder.append(", subredditPrefixed=");
        stringBuilder.append(this.subredditPrefixed);
        stringBuilder.append(", keyColor=");
        stringBuilder.append(this.keyColor);
        stringBuilder.append(", linkKarma=");
        stringBuilder.append(this.linkKarma);
        stringBuilder.append(", commentKarmaCount=");
        stringBuilder.append(this.commentKarmaCount);
        stringBuilder.append(", subscriberCount=");
        stringBuilder.append(this.subscriberCount);
        stringBuilder.append(", over18=");
        stringBuilder.append(this.over18);
        stringBuilder.append(", userIsSubscriber=");
        stringBuilder.append(this.userIsSubscriber);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Karma(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3, boolean z, boolean z2) {
        Intrinsics.m26847b(str, "kindWithId");
        Intrinsics.m26847b(str2, "iconUrl");
        Intrinsics.m26847b(str4, "subreddit");
        Intrinsics.m26847b(str5, "subredditPrefixed");
        this.kindWithId = str;
        this.iconUrl = str2;
        this.bannerUrl = str3;
        this.subreddit = str4;
        this.subredditPrefixed = str5;
        this.keyColor = str6;
        this.linkKarma = i;
        this.commentKarmaCount = i2;
        this.subscriberCount = i3;
        this.over18 = z;
        this.userIsSubscriber = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final String getKindWithId() {
        return this.kindWithId;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    public final String getSubreddit() {
        return this.subreddit;
    }

    public final String getSubredditPrefixed() {
        return this.subredditPrefixed;
    }

    public final String getKeyColor() {
        return this.keyColor;
    }

    public final int getLinkKarma() {
        return this.linkKarma;
    }

    public final int getCommentKarmaCount() {
        return this.commentKarmaCount;
    }

    public final int getSubscriberCount() {
        return this.subscriberCount;
    }

    public final boolean getOver18() {
        return this.over18;
    }

    public /* synthetic */ Karma(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3, boolean z, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        int i5 = i4;
        this(str, str2, (i5 & 4) != 0 ? null : str3, str4, str5, (i5 & 32) != 0 ? null : str6, (i5 & 64) != 0 ? 0 : i, (i5 & 128) != 0 ? 0 : i2, (i5 & 256) != 0 ? 0 : i3, z, (i5 & 1024) != 0 ? false : z2);
    }

    public final boolean getUserIsSubscriber() {
        return this.userIsSubscriber;
    }
}
