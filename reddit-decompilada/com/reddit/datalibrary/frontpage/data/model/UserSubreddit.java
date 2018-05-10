package com.reddit.datalibrary.frontpage.data.model;

import com.google.android.gms.ads.AdRequest;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import org.jcodec.codecs.mpeg12.MPEGConst;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b=\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006¢\u0006\u0002\u0010\u001bJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0011HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/Jø\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020\u00062\b\u0010N\u001a\u0004\u0018\u00010OHÖ\u0003J\t\u0010P\u001a\u00020\u0011HÖ\u0001J\t\u0010Q\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0016\u0010\u0014\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010#R\u0016\u0010\u0012\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010#R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0016\u0010\u001a\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b1\u0010/R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b2\u0010/R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b3\u0010/R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b4\u0010/¨\u0006R"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/UserSubreddit;", "Lcom/reddit/datalibrary/frontpage/data/model/RedditModel;", "kindWithId", "", "bannerImg", "userIsBanned", "", "description", "userIsMuted", "displayName", "headerImg", "title", "userIsModerator", "over18", "iconImg", "displayNamePrefixed", "subscribers", "", "isDefaultIcon", "keyColor", "isDefaultBanner", "url", "userIsContributor", "publicDescription", "subredditType", "userIsSubscriber", "showInDefaultSubreddits", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/String;Ljava/lang/String;IZLjava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Z)V", "getBannerImg", "()Ljava/lang/String;", "getDescription", "getDisplayName", "getDisplayNamePrefixed", "getHeaderImg", "getIconImg", "()Z", "getKeyColor", "getKindWithId", "getOver18", "getPublicDescription", "getShowInDefaultSubreddits", "getSubredditType", "getSubscribers", "()I", "getTitle", "getUrl", "getUserIsBanned", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUserIsContributor", "getUserIsModerator", "getUserIsMuted", "getUserIsSubscriber", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/String;Ljava/lang/String;IZLjava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Z)Lcom/reddit/datalibrary/frontpage/data/model/UserSubreddit;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserSubreddit.kt */
public final class UserSubreddit implements RedditModel {
    @Json(a = "banner_img")
    private final String bannerImg;
    @Json(a = "description")
    private final String description;
    @Json(a = "display_name")
    private final String displayName;
    @Json(a = "display_name_prefixed")
    private final String displayNamePrefixed;
    @Json(a = "header_img")
    private final String headerImg;
    @Json(a = "icon_img")
    private final String iconImg;
    @Json(a = "is_default_banner")
    private final boolean isDefaultBanner;
    @Json(a = "is_default_icon")
    private final boolean isDefaultIcon;
    @Json(a = "key_color")
    private final String keyColor;
    @Json(a = "name")
    private final String kindWithId;
    @Json(a = "over_18")
    private final boolean over18;
    @Json(a = "public_description")
    private final String publicDescription;
    @Json(a = "default_set")
    private final boolean showInDefaultSubreddits;
    @Json(a = "subreddit_type")
    private final String subredditType;
    @Json(a = "subscribers")
    private final int subscribers;
    @Json(a = "title")
    private final String title;
    @Json(a = "url")
    private final String url;
    @Json(a = "user_is_banned")
    private final Boolean userIsBanned;
    @Json(a = "user_is_contributor")
    private final Boolean userIsContributor;
    @Json(a = "user_is_moderator")
    private final Boolean userIsModerator;
    @Json(a = "user_is_muted")
    private final Boolean userIsMuted;
    @Json(a = "user_is_subscriber")
    private final Boolean userIsSubscriber;

    public static /* synthetic */ UserSubreddit copy$default(UserSubreddit userSubreddit, String str, String str2, Boolean bool, String str3, Boolean bool2, String str4, String str5, String str6, Boolean bool3, boolean z, String str7, String str8, int i, boolean z2, String str9, boolean z3, String str10, Boolean bool4, String str11, String str12, Boolean bool5, boolean z4, int i2, Object obj) {
        String str13;
        boolean z5;
        UserSubreddit userSubreddit2 = userSubreddit;
        int i3 = i2;
        String kindWithId = (i3 & 1) != 0 ? userSubreddit.getKindWithId() : str;
        String str14 = (i3 & 2) != 0 ? userSubreddit2.bannerImg : str2;
        Boolean bool6 = (i3 & 4) != 0 ? userSubreddit2.userIsBanned : bool;
        String str15 = (i3 & 8) != 0 ? userSubreddit2.description : str3;
        Boolean bool7 = (i3 & 16) != 0 ? userSubreddit2.userIsMuted : bool2;
        String str16 = (i3 & 32) != 0 ? userSubreddit2.displayName : str4;
        String str17 = (i3 & 64) != 0 ? userSubreddit2.headerImg : str5;
        String str18 = (i3 & 128) != 0 ? userSubreddit2.title : str6;
        Boolean bool8 = (i3 & 256) != 0 ? userSubreddit2.userIsModerator : bool3;
        boolean z6 = (i3 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? userSubreddit2.over18 : z;
        String str19 = (i3 & 1024) != 0 ? userSubreddit2.iconImg : str7;
        String str20 = (i3 & MPEGConst.CODE_END) != 0 ? userSubreddit2.displayNamePrefixed : str8;
        int i4 = (i3 & 4096) != 0 ? userSubreddit2.subscribers : i;
        boolean z7 = (i3 & 8192) != 0 ? userSubreddit2.isDefaultIcon : z2;
        String str21 = (i3 & 16384) != 0 ? userSubreddit2.keyColor : str9;
        if ((i3 & 32768) != 0) {
            str13 = str21;
            z5 = userSubreddit2.isDefaultBanner;
        } else {
            str13 = str21;
            z5 = z3;
        }
        return userSubreddit2.copy(kindWithId, str14, bool6, str15, bool7, str16, str17, str18, bool8, z6, str19, str20, i4, z7, str13, z5, (65536 & i3) != 0 ? userSubreddit2.url : str10, (131072 & i3) != 0 ? userSubreddit2.userIsContributor : bool4, (262144 & i3) != 0 ? userSubreddit2.publicDescription : str11, (524288 & i3) != 0 ? userSubreddit2.subredditType : str12, (1048576 & i3) != 0 ? userSubreddit2.userIsSubscriber : bool5, (i3 & 2097152) != 0 ? userSubreddit2.showInDefaultSubreddits : z4);
    }

    public final String component1() {
        return getKindWithId();
    }

    public final boolean component10() {
        return this.over18;
    }

    public final String component11() {
        return this.iconImg;
    }

    public final String component12() {
        return this.displayNamePrefixed;
    }

    public final int component13() {
        return this.subscribers;
    }

    public final boolean component14() {
        return this.isDefaultIcon;
    }

    public final String component15() {
        return this.keyColor;
    }

    public final boolean component16() {
        return this.isDefaultBanner;
    }

    public final String component17() {
        return this.url;
    }

    public final Boolean component18() {
        return this.userIsContributor;
    }

    public final String component19() {
        return this.publicDescription;
    }

    public final String component2() {
        return this.bannerImg;
    }

    public final String component20() {
        return this.subredditType;
    }

    public final Boolean component21() {
        return this.userIsSubscriber;
    }

    public final boolean component22() {
        return this.showInDefaultSubreddits;
    }

    public final Boolean component3() {
        return this.userIsBanned;
    }

    public final String component4() {
        return this.description;
    }

    public final Boolean component5() {
        return this.userIsMuted;
    }

    public final String component6() {
        return this.displayName;
    }

    public final String component7() {
        return this.headerImg;
    }

    public final String component8() {
        return this.title;
    }

    public final Boolean component9() {
        return this.userIsModerator;
    }

    public final UserSubreddit copy(String str, String str2, Boolean bool, String str3, Boolean bool2, String str4, String str5, String str6, Boolean bool3, boolean z, String str7, String str8, int i, boolean z2, String str9, boolean z3, String str10, Boolean bool4, String str11, String str12, Boolean bool5, boolean z4) {
        String str13 = str;
        Intrinsics.b(str13, "kindWithId");
        String str14 = str3;
        Intrinsics.b(str14, "description");
        String str15 = str4;
        Intrinsics.b(str15, "displayName");
        String str16 = str6;
        Intrinsics.b(str16, "title");
        String str17 = str7;
        Intrinsics.b(str17, "iconImg");
        String str18 = str8;
        Intrinsics.b(str18, "displayNamePrefixed");
        Intrinsics.b(str9, "keyColor");
        Intrinsics.b(str10, UpdateFragment.FRAGMENT_URL);
        Intrinsics.b(str11, "publicDescription");
        Intrinsics.b(str12, "subredditType");
        return new UserSubreddit(str13, str2, bool, str14, bool2, str15, str5, str16, bool3, z, str17, str18, i, z2, str9, z3, str10, bool4, str11, str12, bool5, z4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserSubreddit) {
            UserSubreddit userSubreddit = (UserSubreddit) obj;
            if (Intrinsics.a(getKindWithId(), userSubreddit.getKindWithId()) && Intrinsics.a(this.bannerImg, userSubreddit.bannerImg) && Intrinsics.a(this.userIsBanned, userSubreddit.userIsBanned) && Intrinsics.a(this.description, userSubreddit.description) && Intrinsics.a(this.userIsMuted, userSubreddit.userIsMuted) && Intrinsics.a(this.displayName, userSubreddit.displayName) && Intrinsics.a(this.headerImg, userSubreddit.headerImg) && Intrinsics.a(this.title, userSubreddit.title) && Intrinsics.a(this.userIsModerator, userSubreddit.userIsModerator)) {
                if ((this.over18 == userSubreddit.over18) && Intrinsics.a(this.iconImg, userSubreddit.iconImg) && Intrinsics.a(this.displayNamePrefixed, userSubreddit.displayNamePrefixed)) {
                    if (this.subscribers == userSubreddit.subscribers) {
                        if ((this.isDefaultIcon == userSubreddit.isDefaultIcon) && Intrinsics.a(this.keyColor, userSubreddit.keyColor)) {
                            if ((this.isDefaultBanner == userSubreddit.isDefaultBanner) && Intrinsics.a(this.url, userSubreddit.url) && Intrinsics.a(this.userIsContributor, userSubreddit.userIsContributor) && Intrinsics.a(this.publicDescription, userSubreddit.publicDescription) && Intrinsics.a(this.subredditType, userSubreddit.subredditType) && Intrinsics.a(this.userIsSubscriber, userSubreddit.userIsSubscriber)) {
                                if (this.showInDefaultSubreddits == userSubreddit.showInDefaultSubreddits) {
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
        String str = this.bannerImg;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Boolean bool = this.userIsBanned;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        str = this.description;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        bool = this.userIsMuted;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        str = this.displayName;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.headerImg;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.title;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        bool = this.userIsModerator;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        int i2 = this.over18;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str = this.iconImg;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.displayNamePrefixed;
        hashCode = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.subscribers) * 31;
        i2 = this.isDefaultIcon;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str = this.keyColor;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        i2 = this.isDefaultBanner;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str = this.url;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        bool = this.userIsContributor;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        str = this.publicDescription;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.subredditType;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        bool = this.userIsSubscriber;
        if (bool != null) {
            i = bool.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.showInDefaultSubreddits;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("UserSubreddit(kindWithId=");
        stringBuilder.append(getKindWithId());
        stringBuilder.append(", bannerImg=");
        stringBuilder.append(this.bannerImg);
        stringBuilder.append(", userIsBanned=");
        stringBuilder.append(this.userIsBanned);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", userIsMuted=");
        stringBuilder.append(this.userIsMuted);
        stringBuilder.append(", displayName=");
        stringBuilder.append(this.displayName);
        stringBuilder.append(", headerImg=");
        stringBuilder.append(this.headerImg);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", userIsModerator=");
        stringBuilder.append(this.userIsModerator);
        stringBuilder.append(", over18=");
        stringBuilder.append(this.over18);
        stringBuilder.append(", iconImg=");
        stringBuilder.append(this.iconImg);
        stringBuilder.append(", displayNamePrefixed=");
        stringBuilder.append(this.displayNamePrefixed);
        stringBuilder.append(", subscribers=");
        stringBuilder.append(this.subscribers);
        stringBuilder.append(", isDefaultIcon=");
        stringBuilder.append(this.isDefaultIcon);
        stringBuilder.append(", keyColor=");
        stringBuilder.append(this.keyColor);
        stringBuilder.append(", isDefaultBanner=");
        stringBuilder.append(this.isDefaultBanner);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", userIsContributor=");
        stringBuilder.append(this.userIsContributor);
        stringBuilder.append(", publicDescription=");
        stringBuilder.append(this.publicDescription);
        stringBuilder.append(", subredditType=");
        stringBuilder.append(this.subredditType);
        stringBuilder.append(", userIsSubscriber=");
        stringBuilder.append(this.userIsSubscriber);
        stringBuilder.append(", showInDefaultSubreddits=");
        stringBuilder.append(this.showInDefaultSubreddits);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public UserSubreddit(String str, String str2, Boolean bool, String str3, Boolean bool2, String str4, String str5, String str6, Boolean bool3, boolean z, String str7, String str8, int i, boolean z2, String str9, boolean z3, String str10, Boolean bool4, String str11, String str12, Boolean bool5, boolean z4) {
        String str13 = str;
        String str14 = str3;
        String str15 = str4;
        String str16 = str6;
        String str17 = str7;
        String str18 = str8;
        String str19 = str9;
        String str20 = str10;
        String str21 = str11;
        String str22 = str12;
        Intrinsics.b(str13, "kindWithId");
        Intrinsics.b(str14, "description");
        Intrinsics.b(str15, "displayName");
        Intrinsics.b(str16, "title");
        Intrinsics.b(str17, "iconImg");
        Intrinsics.b(str18, "displayNamePrefixed");
        Intrinsics.b(str19, "keyColor");
        Intrinsics.b(str20, UpdateFragment.FRAGMENT_URL);
        Intrinsics.b(str21, "publicDescription");
        Intrinsics.b(str22, "subredditType");
        this.kindWithId = str13;
        this.bannerImg = str2;
        this.userIsBanned = bool;
        this.description = str14;
        this.userIsMuted = bool2;
        this.displayName = str15;
        this.headerImg = str5;
        this.title = str16;
        this.userIsModerator = bool3;
        this.over18 = z;
        this.iconImg = str17;
        this.displayNamePrefixed = str18;
        this.subscribers = i;
        this.isDefaultIcon = z2;
        this.keyColor = str19;
        this.isDefaultBanner = z3;
        this.url = str20;
        this.userIsContributor = bool4;
        this.publicDescription = str21;
        this.subredditType = str22;
        this.userIsSubscriber = bool5;
        this.showInDefaultSubreddits = z4;
    }

    public final String getKindWithId() {
        return this.kindWithId;
    }

    public final String getBannerImg() {
        return this.bannerImg;
    }

    public final Boolean getUserIsBanned() {
        return this.userIsBanned;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Boolean getUserIsMuted() {
        return this.userIsMuted;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getHeaderImg() {
        return this.headerImg;
    }

    public final String getTitle() {
        return this.title;
    }

    public /* synthetic */ UserSubreddit(String str, String str2, Boolean bool, String str3, Boolean bool2, String str4, String str5, String str6, Boolean bool3, boolean z, String str7, String str8, int i, boolean z2, String str9, boolean z3, String str10, Boolean bool4, String str11, String str12, Boolean bool5, boolean z4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        Boolean valueOf;
        int i3 = i2;
        if ((i3 & 256) != 0) {
            valueOf = Boolean.valueOf(true);
        } else {
            valueOf = bool3;
        }
        this(str, str2, bool, str3, bool2, str4, str5, str6, valueOf, z, str7, str8, i, z2, str9, z3, str10, bool4, str11, str12, (i3 & 1048576) != 0 ? Boolean.valueOf(false) : bool5, z4);
    }

    public final Boolean getUserIsModerator() {
        return this.userIsModerator;
    }

    public final boolean getOver18() {
        return this.over18;
    }

    public final String getIconImg() {
        return this.iconImg;
    }

    public final String getDisplayNamePrefixed() {
        return this.displayNamePrefixed;
    }

    public final int getSubscribers() {
        return this.subscribers;
    }

    public final boolean isDefaultIcon() {
        return this.isDefaultIcon;
    }

    public final String getKeyColor() {
        return this.keyColor;
    }

    public final boolean isDefaultBanner() {
        return this.isDefaultBanner;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Boolean getUserIsContributor() {
        return this.userIsContributor;
    }

    public final String getPublicDescription() {
        return this.publicDescription;
    }

    public final String getSubredditType() {
        return this.subredditType;
    }

    public final Boolean getUserIsSubscriber() {
        return this.userIsSubscriber;
    }

    public final boolean getShowInDefaultSubreddits() {
        return this.showInDefaultSubreddits;
    }
}
