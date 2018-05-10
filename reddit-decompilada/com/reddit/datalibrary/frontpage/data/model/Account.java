package com.reddit.datalibrary.frontpage.data.model;

import com.google.android.gms.ads.AdRequest;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jcodec.codecs.mpeg12.MPEGConst;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b8\b\b\u0018\u00002\u00020\u0001B½\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u001cJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010&J\t\u0010;\u001a\u00020\fHÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\t\u0010?\u001a\u00020\fHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010&J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\t\u0010E\u001a\u00020\bHÆ\u0003J\t\u0010F\u001a\u00020\bHÆ\u0003J\t\u0010G\u001a\u00020\bHÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00103J\t\u0010I\u001a\u00020\bHÆ\u0003J\t\u0010J\u001a\u00020\fHÆ\u0003Jè\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020\b2\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020\fHÖ\u0001J\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000f\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0017\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0016\u0010\u0014\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0015\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0016\u0010\u0016\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0016\u0010\r\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0016\u0010\u001a\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0016\u0010\u0013\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010#R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010#R\u0016\u0010\u0010\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010#R\u0016\u0010\u0011\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010#R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010#R\u0016\u0010\u000e\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u001a\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b/\u0010&R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+¨\u0006Q"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/Account;", "", "id", "", "username", "createdUtc", "", "isEmployee", "", "isFriend", "isSuspended", "suspensionExpiration", "", "hideFromRobots", "linkKarma", "commentKarma", "isGold", "isMod", "hasVerifiedEmail", "inboxCount", "hasMail", "hasModMail", "hideAds", "goldCredits", "subreddit", "Lcom/reddit/datalibrary/frontpage/data/model/UserSubreddit;", "iconUrl", "showMyActiveCommunities", "(Ljava/lang/String;Ljava/lang/String;JZZZLjava/lang/Integer;ZIIZZLjava/lang/Boolean;IZZZILcom/reddit/datalibrary/frontpage/data/model/UserSubreddit;Ljava/lang/String;Ljava/lang/Boolean;)V", "getCommentKarma", "()I", "getCreatedUtc", "()J", "getGoldCredits", "getHasMail", "()Z", "getHasModMail", "getHasVerifiedEmail", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHideAds", "getHideFromRobots", "getIconUrl", "()Ljava/lang/String;", "getId", "getInboxCount", "getLinkKarma", "getShowMyActiveCommunities", "getSubreddit", "()Lcom/reddit/datalibrary/frontpage/data/model/UserSubreddit;", "getSuspensionExpiration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUsername", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;JZZZLjava/lang/Integer;ZIIZZLjava/lang/Boolean;IZZZILcom/reddit/datalibrary/frontpage/data/model/UserSubreddit;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/reddit/datalibrary/frontpage/data/model/Account;", "equals", "other", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Account.kt */
public final class Account {
    @Json(a = "comment_karma")
    private final int commentKarma;
    @Json(a = "created_utc")
    private final long createdUtc;
    @Json(a = "gold_creddits")
    private final int goldCredits;
    @Json(a = "has_mail")
    private final boolean hasMail;
    @Json(a = "has_mod_mail")
    private final boolean hasModMail;
    @Json(a = "has_verified_email")
    private final Boolean hasVerifiedEmail;
    @Json(a = "hide_ads")
    private final boolean hideAds;
    @Json(a = "hide_from_robots")
    private final boolean hideFromRobots;
    @Json(a = "icon_img")
    private final String iconUrl;
    private final String id;
    @Json(a = "inbox_count")
    private final int inboxCount;
    @Json(a = "is_employee")
    private final boolean isEmployee;
    @Json(a = "is_friend")
    private final boolean isFriend;
    @Json(a = "is_gold")
    private final boolean isGold;
    @Json(a = "is_mod")
    private final boolean isMod;
    @Json(a = "is_suspended")
    private final boolean isSuspended;
    @Json(a = "link_karma")
    private final int linkKarma;
    @Json(a = "pref_top_karma_subreddits")
    private final Boolean showMyActiveCommunities;
    @Json(a = "subreddit")
    private final UserSubreddit subreddit;
    @Json(a = "suspension_expiration_utc")
    private final Integer suspensionExpiration;
    @Json(a = "name")
    private final String username;

    public static /* synthetic */ Account copy$default(Account account, String str, String str2, long j, boolean z, boolean z2, boolean z3, Integer num, boolean z4, int i, int i2, boolean z5, boolean z6, Boolean bool, int i3, boolean z7, boolean z8, boolean z9, int i4, UserSubreddit userSubreddit, String str3, Boolean bool2, int i5, Object obj) {
        Account account2 = account;
        int i6 = i5;
        return account2.copy((i6 & 1) != 0 ? account2.id : str, (i6 & 2) != 0 ? account2.username : str2, (i6 & 4) != 0 ? account2.createdUtc : j, (i6 & 8) != 0 ? account2.isEmployee : z, (i6 & 16) != 0 ? account2.isFriend : z2, (i6 & 32) != 0 ? account2.isSuspended : z3, (i6 & 64) != 0 ? account2.suspensionExpiration : num, (i6 & 128) != 0 ? account2.hideFromRobots : z4, (i6 & 256) != 0 ? account2.linkKarma : i, (i6 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? account2.commentKarma : i2, (i6 & 1024) != 0 ? account2.isGold : z5, (i6 & MPEGConst.CODE_END) != 0 ? account2.isMod : z6, (i6 & 4096) != 0 ? account2.hasVerifiedEmail : bool, (i6 & 8192) != 0 ? account2.inboxCount : i3, (i6 & 16384) != 0 ? account2.hasMail : z7, (32768 & i6) != 0 ? account2.hasModMail : z8, (65536 & i6) != 0 ? account2.hideAds : z9, (131072 & i6) != 0 ? account2.goldCredits : i4, (262144 & i6) != 0 ? account2.subreddit : userSubreddit, (524288 & i6) != 0 ? account2.iconUrl : str3, (i6 & 1048576) != 0 ? account2.showMyActiveCommunities : bool2);
    }

    public final String component1() {
        return this.id;
    }

    public final int component10() {
        return this.commentKarma;
    }

    public final boolean component11() {
        return this.isGold;
    }

    public final boolean component12() {
        return this.isMod;
    }

    public final Boolean component13() {
        return this.hasVerifiedEmail;
    }

    public final int component14() {
        return this.inboxCount;
    }

    public final boolean component15() {
        return this.hasMail;
    }

    public final boolean component16() {
        return this.hasModMail;
    }

    public final boolean component17() {
        return this.hideAds;
    }

    public final int component18() {
        return this.goldCredits;
    }

    public final UserSubreddit component19() {
        return this.subreddit;
    }

    public final String component2() {
        return this.username;
    }

    public final String component20() {
        return this.iconUrl;
    }

    public final Boolean component21() {
        return this.showMyActiveCommunities;
    }

    public final long component3() {
        return this.createdUtc;
    }

    public final boolean component4() {
        return this.isEmployee;
    }

    public final boolean component5() {
        return this.isFriend;
    }

    public final boolean component6() {
        return this.isSuspended;
    }

    public final Integer component7() {
        return this.suspensionExpiration;
    }

    public final boolean component8() {
        return this.hideFromRobots;
    }

    public final int component9() {
        return this.linkKarma;
    }

    public final Account copy(String str, String str2, long j, boolean z, boolean z2, boolean z3, Integer num, boolean z4, int i, int i2, boolean z5, boolean z6, Boolean bool, int i3, boolean z7, boolean z8, boolean z9, int i4, UserSubreddit userSubreddit, String str3, Boolean bool2) {
        String str4 = str;
        Intrinsics.b(str4, "id");
        String str5 = str2;
        Intrinsics.b(str5, "username");
        Intrinsics.b(str3, "iconUrl");
        return new Account(str4, str5, j, z, z2, z3, num, z4, i, i2, z5, z6, bool, i3, z7, z8, z9, i4, userSubreddit, str3, bool2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Account) {
            Account account = (Account) obj;
            if (Intrinsics.a(this.id, account.id) && Intrinsics.a(this.username, account.username)) {
                if (this.createdUtc == account.createdUtc) {
                    if (this.isEmployee == account.isEmployee) {
                        if (this.isFriend == account.isFriend) {
                            if ((this.isSuspended == account.isSuspended) && Intrinsics.a(this.suspensionExpiration, account.suspensionExpiration)) {
                                if (this.hideFromRobots == account.hideFromRobots) {
                                    if (this.linkKarma == account.linkKarma) {
                                        if (this.commentKarma == account.commentKarma) {
                                            if (this.isGold == account.isGold) {
                                                if ((this.isMod == account.isMod) && Intrinsics.a(this.hasVerifiedEmail, account.hasVerifiedEmail)) {
                                                    if (this.inboxCount == account.inboxCount) {
                                                        if (this.hasMail == account.hasMail) {
                                                            if (this.hasModMail == account.hasModMail) {
                                                                if (this.hideAds == account.hideAds) {
                                                                    return (this.goldCredits == account.goldCredits) && Intrinsics.a(this.subreddit, account.subreddit) && Intrinsics.a(this.iconUrl, account.iconUrl) && Intrinsics.a(this.showMyActiveCommunities, account.showMyActiveCommunities);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.username;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.createdUtc;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        int i2 = this.isEmployee;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.isFriend;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.isSuspended;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        Integer num = this.suspensionExpiration;
        hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        i2 = this.hideFromRobots;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (((((hashCode + i2) * 31) + this.linkKarma) * 31) + this.commentKarma) * 31;
        i2 = this.isGold;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.isMod;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        Boolean bool = this.hasVerifiedEmail;
        hashCode = (((hashCode + (bool != null ? bool.hashCode() : 0)) * 31) + this.inboxCount) * 31;
        i2 = this.hasMail;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.hasModMail;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.hideAds;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (((hashCode + i2) * 31) + this.goldCredits) * 31;
        UserSubreddit userSubreddit = this.subreddit;
        hashCode = (hashCode + (userSubreddit != null ? userSubreddit.hashCode() : 0)) * 31;
        str2 = this.iconUrl;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        bool = this.showMyActiveCommunities;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Account(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", username=");
        stringBuilder.append(this.username);
        stringBuilder.append(", createdUtc=");
        stringBuilder.append(this.createdUtc);
        stringBuilder.append(", isEmployee=");
        stringBuilder.append(this.isEmployee);
        stringBuilder.append(", isFriend=");
        stringBuilder.append(this.isFriend);
        stringBuilder.append(", isSuspended=");
        stringBuilder.append(this.isSuspended);
        stringBuilder.append(", suspensionExpiration=");
        stringBuilder.append(this.suspensionExpiration);
        stringBuilder.append(", hideFromRobots=");
        stringBuilder.append(this.hideFromRobots);
        stringBuilder.append(", linkKarma=");
        stringBuilder.append(this.linkKarma);
        stringBuilder.append(", commentKarma=");
        stringBuilder.append(this.commentKarma);
        stringBuilder.append(", isGold=");
        stringBuilder.append(this.isGold);
        stringBuilder.append(", isMod=");
        stringBuilder.append(this.isMod);
        stringBuilder.append(", hasVerifiedEmail=");
        stringBuilder.append(this.hasVerifiedEmail);
        stringBuilder.append(", inboxCount=");
        stringBuilder.append(this.inboxCount);
        stringBuilder.append(", hasMail=");
        stringBuilder.append(this.hasMail);
        stringBuilder.append(", hasModMail=");
        stringBuilder.append(this.hasModMail);
        stringBuilder.append(", hideAds=");
        stringBuilder.append(this.hideAds);
        stringBuilder.append(", goldCredits=");
        stringBuilder.append(this.goldCredits);
        stringBuilder.append(", subreddit=");
        stringBuilder.append(this.subreddit);
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append(", showMyActiveCommunities=");
        stringBuilder.append(this.showMyActiveCommunities);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Account(String str, String str2, long j, boolean z, boolean z2, boolean z3, Integer num, boolean z4, int i, int i2, boolean z5, boolean z6, Boolean bool, int i3, boolean z7, boolean z8, boolean z9, int i4, UserSubreddit userSubreddit, String str3, Boolean bool2) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Intrinsics.b(str4, "id");
        Intrinsics.b(str5, "username");
        Intrinsics.b(str6, "iconUrl");
        this.id = str4;
        this.username = str5;
        this.createdUtc = j;
        this.isEmployee = z;
        this.isFriend = z2;
        this.isSuspended = z3;
        this.suspensionExpiration = num;
        this.hideFromRobots = z4;
        this.linkKarma = i;
        this.commentKarma = i2;
        this.isGold = z5;
        this.isMod = z6;
        this.hasVerifiedEmail = bool;
        this.inboxCount = i3;
        this.hasMail = z7;
        this.hasModMail = z8;
        this.hideAds = z9;
        this.goldCredits = i4;
        this.subreddit = userSubreddit;
        this.iconUrl = str6;
        this.showMyActiveCommunities = bool2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getUsername() {
        return this.username;
    }

    public final long getCreatedUtc() {
        return this.createdUtc;
    }

    public final boolean isEmployee() {
        return this.isEmployee;
    }

    public final boolean isFriend() {
        return this.isFriend;
    }

    public final boolean isSuspended() {
        return this.isSuspended;
    }

    public final Integer getSuspensionExpiration() {
        return this.suspensionExpiration;
    }

    public final boolean getHideFromRobots() {
        return this.hideFromRobots;
    }

    public final int getLinkKarma() {
        return this.linkKarma;
    }

    public final int getCommentKarma() {
        return this.commentKarma;
    }

    public final boolean isGold() {
        return this.isGold;
    }

    public final boolean isMod() {
        return this.isMod;
    }

    public final Boolean getHasVerifiedEmail() {
        return this.hasVerifiedEmail;
    }

    public final int getInboxCount() {
        return this.inboxCount;
    }

    public final boolean getHasMail() {
        return this.hasMail;
    }

    public final boolean getHasModMail() {
        return this.hasModMail;
    }

    public final boolean getHideAds() {
        return this.hideAds;
    }

    public final int getGoldCredits() {
        return this.goldCredits;
    }

    public final UserSubreddit getSubreddit() {
        return this.subreddit;
    }

    public /* synthetic */ Account(String str, String str2, long j, boolean z, boolean z2, boolean z3, Integer num, boolean z4, int i, int i2, boolean z5, boolean z6, Boolean bool, int i3, boolean z7, boolean z8, boolean z9, int i4, UserSubreddit userSubreddit, String str3, Boolean bool2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        int i6 = i5;
        this(str, str2, j, z, z2, z3, num, z4, i, i2, z5, z6, bool, (i6 & 8192) != 0 ? 0 : i3, z7, z8, z9, (131072 & i6) != 0 ? 0 : i4, (262144 & i6) != 0 ? null : userSubreddit, (i6 & 524288) != 0 ? "" : str3, bool2);
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final Boolean getShowMyActiveCommunities() {
        return this.showMyActiveCommunities;
    }
}
