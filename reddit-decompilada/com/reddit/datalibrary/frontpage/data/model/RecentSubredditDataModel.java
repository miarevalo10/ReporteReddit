package com.reddit.datalibrary.frontpage.data.model;

import com.google.android.gms.ads.AdRequest;
import com.raizlabs.android.dbflow.rx2.structure.BaseRXModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import org.jcodec.codecs.mpeg12.MPEGConst;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\bF\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0002\u0010\u0018J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0014HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003JÍ\u0001\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0003HÆ\u0001J\u0013\u0010Y\u001a\u00020\u00142\b\u0010Z\u001a\u0004\u0018\u00010[HÖ\u0003J\t\u0010\\\u001a\u00020]HÖ\u0001J\t\u0010^\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 R\u001e\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001e\"\u0004\b:\u0010 R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001e\"\u0004\b<\u0010 R\u001e\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001a\"\u0004\b@\u0010\u001cR\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010 R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 ¨\u0006_"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/RecentSubredditDataModel;", "Lcom/raizlabs/android/dbflow/rx2/structure/BaseRXModel;", "id", "", "subredditId", "", "name", "username", "displayName", "displayNamePrefixed", "iconImg", "keyColor", "description", "publicDescription", "descriptionHtml", "url", "subscribers", "accountsActive", "bannerImg", "over18", "", "subredditType", "lastVisited", "createdUtc", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;ZLjava/lang/String;JJ)V", "getAccountsActive", "()J", "setAccountsActive", "(J)V", "getBannerImg", "()Ljava/lang/String;", "setBannerImg", "(Ljava/lang/String;)V", "getCreatedUtc", "setCreatedUtc", "getDescription", "setDescription", "getDescriptionHtml", "setDescriptionHtml", "getDisplayName", "setDisplayName", "getDisplayNamePrefixed", "setDisplayNamePrefixed", "getIconImg", "setIconImg", "getId", "setId", "getKeyColor", "setKeyColor", "getLastVisited", "setLastVisited", "getName", "setName", "getOver18", "()Z", "setOver18", "(Z)V", "getPublicDescription", "setPublicDescription", "getSubredditId", "setSubredditId", "getSubredditType", "setSubredditType", "getSubscribers", "setSubscribers", "getUrl", "setUrl", "getUsername", "setUsername", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RecentSubredditDataModel.kt */
public final class RecentSubredditDataModel extends BaseRXModel {
    private long accountsActive;
    private String bannerImg;
    private long createdUtc;
    private String description;
    private String descriptionHtml;
    private String displayName;
    private String displayNamePrefixed;
    private String iconImg;
    private long id;
    private String keyColor;
    private long lastVisited;
    private String name;
    private boolean over18;
    private String publicDescription;
    private String subredditId;
    private String subredditType;
    private long subscribers;
    private String url;
    private String username;

    public RecentSubredditDataModel() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, false, null, 0, 0, 524287, null);
    }

    public static /* synthetic */ RecentSubredditDataModel copy$default(RecentSubredditDataModel recentSubredditDataModel, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j2, long j3, String str12, boolean z, String str13, long j4, long j5, int i, Object obj) {
        String str14;
        long j6;
        RecentSubredditDataModel recentSubredditDataModel2 = recentSubredditDataModel;
        int i2 = i;
        long j7 = (i2 & 1) != 0 ? recentSubredditDataModel2.id : j;
        String str15 = (i2 & 2) != 0 ? recentSubredditDataModel2.subredditId : str;
        String str16 = (i2 & 4) != 0 ? recentSubredditDataModel2.name : str2;
        String str17 = (i2 & 8) != 0 ? recentSubredditDataModel2.username : str3;
        String str18 = (i2 & 16) != 0 ? recentSubredditDataModel2.displayName : str4;
        String str19 = (i2 & 32) != 0 ? recentSubredditDataModel2.displayNamePrefixed : str5;
        String str20 = (i2 & 64) != 0 ? recentSubredditDataModel2.iconImg : str6;
        String str21 = (i2 & 128) != 0 ? recentSubredditDataModel2.keyColor : str7;
        String str22 = (i2 & 256) != 0 ? recentSubredditDataModel2.description : str8;
        String str23 = (i2 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? recentSubredditDataModel2.publicDescription : str9;
        String str24 = (i2 & 1024) != 0 ? recentSubredditDataModel2.descriptionHtml : str10;
        String str25 = (i2 & MPEGConst.CODE_END) != 0 ? recentSubredditDataModel2.url : str11;
        if ((i2 & 4096) != 0) {
            str14 = str25;
            j6 = recentSubredditDataModel2.subscribers;
        } else {
            str14 = str25;
            j6 = j2;
        }
        return recentSubredditDataModel2.copy(j7, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str14, j6, (i2 & 8192) != 0 ? recentSubredditDataModel2.accountsActive : j3, (i2 & 16384) != 0 ? recentSubredditDataModel2.bannerImg : str12, (32768 & i2) != 0 ? recentSubredditDataModel2.over18 : z, (65536 & i2) != 0 ? recentSubredditDataModel2.subredditType : str13, (131072 & i2) != 0 ? recentSubredditDataModel2.lastVisited : j4, (i2 & 262144) != 0 ? recentSubredditDataModel2.createdUtc : j5);
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.publicDescription;
    }

    public final String component11() {
        return this.descriptionHtml;
    }

    public final String component12() {
        return this.url;
    }

    public final long component13() {
        return this.subscribers;
    }

    public final long component14() {
        return this.accountsActive;
    }

    public final String component15() {
        return this.bannerImg;
    }

    public final boolean component16() {
        return this.over18;
    }

    public final String component17() {
        return this.subredditType;
    }

    public final long component18() {
        return this.lastVisited;
    }

    public final long component19() {
        return this.createdUtc;
    }

    public final String component2() {
        return this.subredditId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.username;
    }

    public final String component5() {
        return this.displayName;
    }

    public final String component6() {
        return this.displayNamePrefixed;
    }

    public final String component7() {
        return this.iconImg;
    }

    public final String component8() {
        return this.keyColor;
    }

    public final String component9() {
        return this.description;
    }

    public final RecentSubredditDataModel copy(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j2, long j3, String str12, boolean z, String str13, long j4, long j5) {
        String str14 = str;
        Intrinsics.b(str14, "subredditId");
        String str15 = str2;
        Intrinsics.b(str15, "name");
        String str16 = str3;
        Intrinsics.b(str16, "username");
        String str17 = str4;
        Intrinsics.b(str17, "displayName");
        String str18 = str5;
        Intrinsics.b(str18, "displayNamePrefixed");
        String str19 = str7;
        Intrinsics.b(str19, "keyColor");
        String str20 = str8;
        Intrinsics.b(str20, "description");
        String str21 = str9;
        Intrinsics.b(str21, "publicDescription");
        String str22 = str11;
        Intrinsics.b(str22, UpdateFragment.FRAGMENT_URL);
        Intrinsics.b(str13, "subredditType");
        return new RecentSubredditDataModel(j, str14, str15, str16, str17, str18, str6, str19, str20, str21, str10, str22, j2, j3, str12, z, str13, j4, j5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecentSubredditDataModel) {
            RecentSubredditDataModel recentSubredditDataModel = (RecentSubredditDataModel) obj;
            if ((this.id == recentSubredditDataModel.id) && Intrinsics.a(this.subredditId, recentSubredditDataModel.subredditId) && Intrinsics.a(this.name, recentSubredditDataModel.name) && Intrinsics.a(this.username, recentSubredditDataModel.username) && Intrinsics.a(this.displayName, recentSubredditDataModel.displayName) && Intrinsics.a(this.displayNamePrefixed, recentSubredditDataModel.displayNamePrefixed) && Intrinsics.a(this.iconImg, recentSubredditDataModel.iconImg) && Intrinsics.a(this.keyColor, recentSubredditDataModel.keyColor) && Intrinsics.a(this.description, recentSubredditDataModel.description) && Intrinsics.a(this.publicDescription, recentSubredditDataModel.publicDescription) && Intrinsics.a(this.descriptionHtml, recentSubredditDataModel.descriptionHtml) && Intrinsics.a(this.url, recentSubredditDataModel.url)) {
                if (this.subscribers == recentSubredditDataModel.subscribers) {
                    if ((this.accountsActive == recentSubredditDataModel.accountsActive) && Intrinsics.a(this.bannerImg, recentSubredditDataModel.bannerImg)) {
                        if ((this.over18 == recentSubredditDataModel.over18) && Intrinsics.a(this.subredditType, recentSubredditDataModel.subredditType)) {
                            if (this.lastVisited == recentSubredditDataModel.lastVisited) {
                                if (this.createdUtc == recentSubredditDataModel.createdUtc) {
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
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.subredditId;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.name;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.username;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.displayName;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.displayNamePrefixed;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.iconImg;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.keyColor;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.description;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.publicDescription;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.descriptionHtml;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.url;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        long j2 = this.subscribers;
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        j2 = this.accountsActive;
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        str = this.bannerImg;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        int i3 = this.over18;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        str = this.subredditType;
        if (str != null) {
            i2 = str.hashCode();
        }
        i = (i + i2) * 31;
        long j3 = this.lastVisited;
        i = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        j3 = this.createdUtc;
        return i + ((int) ((j3 >>> 32) ^ j3));
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RecentSubredditDataModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", subredditId=");
        stringBuilder.append(this.subredditId);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", username=");
        stringBuilder.append(this.username);
        stringBuilder.append(", displayName=");
        stringBuilder.append(this.displayName);
        stringBuilder.append(", displayNamePrefixed=");
        stringBuilder.append(this.displayNamePrefixed);
        stringBuilder.append(", iconImg=");
        stringBuilder.append(this.iconImg);
        stringBuilder.append(", keyColor=");
        stringBuilder.append(this.keyColor);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", publicDescription=");
        stringBuilder.append(this.publicDescription);
        stringBuilder.append(", descriptionHtml=");
        stringBuilder.append(this.descriptionHtml);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", subscribers=");
        stringBuilder.append(this.subscribers);
        stringBuilder.append(", accountsActive=");
        stringBuilder.append(this.accountsActive);
        stringBuilder.append(", bannerImg=");
        stringBuilder.append(this.bannerImg);
        stringBuilder.append(", over18=");
        stringBuilder.append(this.over18);
        stringBuilder.append(", subredditType=");
        stringBuilder.append(this.subredditType);
        stringBuilder.append(", lastVisited=");
        stringBuilder.append(this.lastVisited);
        stringBuilder.append(", createdUtc=");
        stringBuilder.append(this.createdUtc);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getSubredditId() {
        return this.subredditId;
    }

    public final void setSubredditId(String str) {
        Intrinsics.b(str, "<set-?>");
        this.subredditId = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.b(str, "<set-?>");
        this.name = str;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(String str) {
        Intrinsics.b(str, "<set-?>");
        this.username = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        Intrinsics.b(str, "<set-?>");
        this.displayName = str;
    }

    public final String getDisplayNamePrefixed() {
        return this.displayNamePrefixed;
    }

    public final void setDisplayNamePrefixed(String str) {
        Intrinsics.b(str, "<set-?>");
        this.displayNamePrefixed = str;
    }

    public final String getIconImg() {
        return this.iconImg;
    }

    public final void setIconImg(String str) {
        this.iconImg = str;
    }

    public final String getKeyColor() {
        return this.keyColor;
    }

    public final void setKeyColor(String str) {
        Intrinsics.b(str, "<set-?>");
        this.keyColor = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.b(str, "<set-?>");
        this.description = str;
    }

    public final String getPublicDescription() {
        return this.publicDescription;
    }

    public final void setPublicDescription(String str) {
        Intrinsics.b(str, "<set-?>");
        this.publicDescription = str;
    }

    public final String getDescriptionHtml() {
        return this.descriptionHtml;
    }

    public final void setDescriptionHtml(String str) {
        this.descriptionHtml = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.b(str, "<set-?>");
        this.url = str;
    }

    public final long getSubscribers() {
        return this.subscribers;
    }

    public final void setSubscribers(long j) {
        this.subscribers = j;
    }

    public final long getAccountsActive() {
        return this.accountsActive;
    }

    public final void setAccountsActive(long j) {
        this.accountsActive = j;
    }

    public final String getBannerImg() {
        return this.bannerImg;
    }

    public final void setBannerImg(String str) {
        this.bannerImg = str;
    }

    public final boolean getOver18() {
        return this.over18;
    }

    public final void setOver18(boolean z) {
        this.over18 = z;
    }

    public final String getSubredditType() {
        return this.subredditType;
    }

    public final void setSubredditType(String str) {
        Intrinsics.b(str, "<set-?>");
        this.subredditType = str;
    }

    public /* synthetic */ RecentSubredditDataModel(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j2, long j3, String str12, boolean z, String str13, long j4, long j5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        int i2 = i;
        this((i2 & 1) != 0 ? 0 : j, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? "" : str7, (i2 & 256) != 0 ? "" : str8, (i2 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? "" : str9, (i2 & 1024) != 0 ? null : str10, (i2 & MPEGConst.CODE_END) != 0 ? "" : str11, (i2 & 4096) != 0 ? 0 : j2, (i2 & 8192) != 0 ? 0 : j3, (i2 & 16384) != 0 ? null : str12, (32768 & i2) != 0 ? false : z, (65536 & i2) != 0 ? "" : str13, (131072 & i2) != 0 ? System.currentTimeMillis() : j4, (i2 & 262144) != 0 ? System.currentTimeMillis() : j5);
    }

    public final long getLastVisited() {
        return this.lastVisited;
    }

    public final void setLastVisited(long j) {
        this.lastVisited = j;
    }

    public final long getCreatedUtc() {
        return this.createdUtc;
    }

    public final void setCreatedUtc(long j) {
        this.createdUtc = j;
    }

    public RecentSubredditDataModel(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j2, long j3, String str12, boolean z, String str13, long j4, long j5) {
        String str14 = str;
        String str15 = str2;
        String str16 = str3;
        String str17 = str4;
        String str18 = str5;
        String str19 = str7;
        String str20 = str8;
        String str21 = str9;
        String str22 = str11;
        String str23 = str13;
        Intrinsics.b(str14, "subredditId");
        Intrinsics.b(str15, "name");
        Intrinsics.b(str16, "username");
        Intrinsics.b(str17, "displayName");
        Intrinsics.b(str18, "displayNamePrefixed");
        Intrinsics.b(str19, "keyColor");
        Intrinsics.b(str20, "description");
        Intrinsics.b(str21, "publicDescription");
        Intrinsics.b(str22, UpdateFragment.FRAGMENT_URL);
        Intrinsics.b(str23, "subredditType");
        this.id = j;
        this.subredditId = str14;
        this.name = str15;
        this.username = str16;
        this.displayName = str17;
        this.displayNamePrefixed = str18;
        this.iconImg = str6;
        this.keyColor = str19;
        this.description = str20;
        this.publicDescription = str21;
        this.descriptionHtml = str10;
        this.url = str22;
        this.subscribers = j2;
        this.accountsActive = j3;
        this.bannerImg = str12;
        this.over18 = z;
        this.subredditType = str23;
        this.lastVisited = j4;
        this.createdUtc = j5;
    }
}
