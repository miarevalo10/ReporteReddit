package com.reddit.datalibrary.frontpage.data.model;

import com.google.android.gms.ads.AdRequest;
import com.raizlabs.android.dbflow.rx2.structure.BaseRXModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jcodec.codecs.mpeg12.MPEGConst;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\bZ\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u001bJ\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\rHÆ\u0003J\t\u0010Q\u001a\u00020\rHÆ\u0003J\t\u0010R\u001a\u00020\tHÆ\u0003J\t\u0010S\u001a\u00020\tHÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u00101J\t\u0010U\u001a\u00020\rHÆ\u0003J\t\u0010V\u001a\u00020\tHÆ\u0003J\t\u0010W\u001a\u00020\tHÆ\u0003J\t\u0010X\u001a\u00020\tHÆ\u0003J\t\u0010Y\u001a\u00020\rHÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u00101J\t\u0010]\u001a\u00020\u0005HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\tHÆ\u0003J\t\u0010`\u001a\u00020\tHÆ\u0003J\t\u0010a\u001a\u00020\tHÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010KJ\t\u0010c\u001a\u00020\tHÆ\u0003Jæ\u0001\u0010d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010eJ\u0013\u0010f\u001a\u00020\t2\b\u0010g\u001a\u0004\u0018\u00010hHÖ\u0003J\t\u0010i\u001a\u00020\rHÖ\u0001J\t\u0010j\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0010\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001e\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R\"\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R\u001e\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010+\"\u0004\b8\u0010-R\u001e\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001d\"\u0004\b:\u0010\u001fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010%\"\u0004\b<\u0010'R\u001e\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010!\"\u0004\b>\u0010#R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010+\"\u0004\b?\u0010-R\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010+\"\u0004\b@\u0010-R\u001e\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010+\"\u0004\bA\u0010-R\u001e\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010+\"\u0004\bB\u0010-R\u001e\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010+\"\u0004\bC\u0010-R\u001e\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010!\"\u0004\bE\u0010#R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001d\"\u0004\bG\u0010\u001fR\"\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\bH\u00101\"\u0004\bI\u00103R\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010N\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006k"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/AccountDataModel;", "Lcom/raizlabs/android/dbflow/rx2/structure/BaseRXModel;", "id", "", "accountId", "", "name", "createdUtc", "isEmployee", "", "isFriend", "isSuspended", "suspensionExpiration", "", "hideFromRobots", "linkKarma", "commentKarma", "isGold", "isMod", "hasVerifiedEmail", "inboxCount", "hasMail", "hasModMail", "hideAds", "goldCredits", "iconUrl", "showMyActiveCommunities", "(JLjava/lang/String;Ljava/lang/String;JZZZLjava/lang/Integer;ZIIZZLjava/lang/Boolean;IZZZILjava/lang/String;Ljava/lang/Boolean;)V", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "getCommentKarma", "()I", "setCommentKarma", "(I)V", "getCreatedUtc", "()J", "setCreatedUtc", "(J)V", "getGoldCredits", "setGoldCredits", "getHasMail", "()Z", "setHasMail", "(Z)V", "getHasModMail", "setHasModMail", "getHasVerifiedEmail", "()Ljava/lang/Boolean;", "setHasVerifiedEmail", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHideAds", "setHideAds", "getHideFromRobots", "setHideFromRobots", "getIconUrl", "setIconUrl", "getId", "setId", "getInboxCount", "setInboxCount", "setEmployee", "setFriend", "setGold", "setMod", "setSuspended", "getLinkKarma", "setLinkKarma", "getName", "setName", "getShowMyActiveCommunities", "setShowMyActiveCommunities", "getSuspensionExpiration", "()Ljava/lang/Integer;", "setSuspensionExpiration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;JZZZLjava/lang/Integer;ZIIZZLjava/lang/Boolean;IZZZILjava/lang/String;Ljava/lang/Boolean;)Lcom/reddit/datalibrary/frontpage/data/model/AccountDataModel;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountDataModel.kt */
public final class AccountDataModel extends BaseRXModel {
    private String accountId;
    private int commentKarma;
    private long createdUtc;
    private int goldCredits;
    private boolean hasMail;
    private boolean hasModMail;
    private Boolean hasVerifiedEmail;
    private boolean hideAds;
    private boolean hideFromRobots;
    private String iconUrl;
    private long id;
    private int inboxCount;
    private boolean isEmployee;
    private boolean isFriend;
    private boolean isGold;
    private boolean isMod;
    private boolean isSuspended;
    private int linkKarma;
    private String name;
    private Boolean showMyActiveCommunities;
    private Integer suspensionExpiration;

    public AccountDataModel() {
        this(0, null, null, 0, false, false, false, null, false, 0, 0, false, false, null, 0, false, false, false, 0, null, null, 2097151, null);
    }

    public static /* synthetic */ AccountDataModel copy$default(AccountDataModel accountDataModel, long j, String str, String str2, long j2, boolean z, boolean z2, boolean z3, Integer num, boolean z4, int i, int i2, boolean z5, boolean z6, Boolean bool, int i3, boolean z7, boolean z8, boolean z9, int i4, String str3, Boolean bool2, int i5, Object obj) {
        AccountDataModel accountDataModel2 = accountDataModel;
        int i6 = i5;
        return accountDataModel2.copy((i6 & 1) != 0 ? accountDataModel2.id : j, (i6 & 2) != 0 ? accountDataModel2.accountId : str, (i6 & 4) != 0 ? accountDataModel2.name : str2, (i6 & 8) != 0 ? accountDataModel2.createdUtc : j2, (i6 & 16) != 0 ? accountDataModel2.isEmployee : z, (i6 & 32) != 0 ? accountDataModel2.isFriend : z2, (i6 & 64) != 0 ? accountDataModel2.isSuspended : z3, (i6 & 128) != 0 ? accountDataModel2.suspensionExpiration : num, (i6 & 256) != 0 ? accountDataModel2.hideFromRobots : z4, (i6 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? accountDataModel2.linkKarma : i, (i6 & 1024) != 0 ? accountDataModel2.commentKarma : i2, (i6 & MPEGConst.CODE_END) != 0 ? accountDataModel2.isGold : z5, (i6 & 4096) != 0 ? accountDataModel2.isMod : z6, (i6 & 8192) != 0 ? accountDataModel2.hasVerifiedEmail : bool, (i6 & 16384) != 0 ? accountDataModel2.inboxCount : i3, (32768 & i6) != 0 ? accountDataModel2.hasMail : z7, (65536 & i6) != 0 ? accountDataModel2.hasModMail : z8, (131072 & i6) != 0 ? accountDataModel2.hideAds : z9, (262144 & i6) != 0 ? accountDataModel2.goldCredits : i4, (524288 & i6) != 0 ? accountDataModel2.iconUrl : str3, (i6 & 1048576) != 0 ? accountDataModel2.showMyActiveCommunities : bool2);
    }

    public final long component1() {
        return this.id;
    }

    public final int component10() {
        return this.linkKarma;
    }

    public final int component11() {
        return this.commentKarma;
    }

    public final boolean component12() {
        return this.isGold;
    }

    public final boolean component13() {
        return this.isMod;
    }

    public final Boolean component14() {
        return this.hasVerifiedEmail;
    }

    public final int component15() {
        return this.inboxCount;
    }

    public final boolean component16() {
        return this.hasMail;
    }

    public final boolean component17() {
        return this.hasModMail;
    }

    public final boolean component18() {
        return this.hideAds;
    }

    public final int component19() {
        return this.goldCredits;
    }

    public final String component2() {
        return this.accountId;
    }

    public final String component20() {
        return this.iconUrl;
    }

    public final Boolean component21() {
        return this.showMyActiveCommunities;
    }

    public final String component3() {
        return this.name;
    }

    public final long component4() {
        return this.createdUtc;
    }

    public final boolean component5() {
        return this.isEmployee;
    }

    public final boolean component6() {
        return this.isFriend;
    }

    public final boolean component7() {
        return this.isSuspended;
    }

    public final Integer component8() {
        return this.suspensionExpiration;
    }

    public final boolean component9() {
        return this.hideFromRobots;
    }

    public final AccountDataModel copy(long j, String str, String str2, long j2, boolean z, boolean z2, boolean z3, Integer num, boolean z4, int i, int i2, boolean z5, boolean z6, Boolean bool, int i3, boolean z7, boolean z8, boolean z9, int i4, String str3, Boolean bool2) {
        String str4 = str;
        Intrinsics.b(str4, "accountId");
        String str5 = str2;
        Intrinsics.b(str5, "name");
        Intrinsics.b(str3, "iconUrl");
        return new AccountDataModel(j, str4, str5, j2, z, z2, z3, num, z4, i, i2, z5, z6, bool, i3, z7, z8, z9, i4, str3, bool2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccountDataModel) {
            AccountDataModel accountDataModel = (AccountDataModel) obj;
            if ((this.id == accountDataModel.id) && Intrinsics.a(this.accountId, accountDataModel.accountId) && Intrinsics.a(this.name, accountDataModel.name)) {
                if (this.createdUtc == accountDataModel.createdUtc) {
                    if (this.isEmployee == accountDataModel.isEmployee) {
                        if (this.isFriend == accountDataModel.isFriend) {
                            if ((this.isSuspended == accountDataModel.isSuspended) && Intrinsics.a(this.suspensionExpiration, accountDataModel.suspensionExpiration)) {
                                if (this.hideFromRobots == accountDataModel.hideFromRobots) {
                                    if (this.linkKarma == accountDataModel.linkKarma) {
                                        if (this.commentKarma == accountDataModel.commentKarma) {
                                            if (this.isGold == accountDataModel.isGold) {
                                                if ((this.isMod == accountDataModel.isMod) && Intrinsics.a(this.hasVerifiedEmail, accountDataModel.hasVerifiedEmail)) {
                                                    if (this.inboxCount == accountDataModel.inboxCount) {
                                                        if (this.hasMail == accountDataModel.hasMail) {
                                                            if (this.hasModMail == accountDataModel.hasModMail) {
                                                                if (this.hideAds == accountDataModel.hideAds) {
                                                                    return (this.goldCredits == accountDataModel.goldCredits) && Intrinsics.a(this.iconUrl, accountDataModel.iconUrl) && Intrinsics.a(this.showMyActiveCommunities, accountDataModel.showMyActiveCommunities);
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
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.accountId;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.name;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        long j2 = this.createdUtc;
        i = (i + ((int) ((j2 >>> 32) ^ j2))) * 31;
        int i3 = this.isEmployee;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.isFriend;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.isSuspended;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        Integer num = this.suspensionExpiration;
        i = (i + (num != null ? num.hashCode() : 0)) * 31;
        i3 = this.hideFromRobots;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (((((i + i3) * 31) + this.linkKarma) * 31) + this.commentKarma) * 31;
        i3 = this.isGold;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.isMod;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        Boolean bool = this.hasVerifiedEmail;
        i = (((i + (bool != null ? bool.hashCode() : 0)) * 31) + this.inboxCount) * 31;
        i3 = this.hasMail;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.hasModMail;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.hideAds;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (((i + i3) * 31) + this.goldCredits) * 31;
        str = this.iconUrl;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        bool = this.showMyActiveCommunities;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return i + i2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AccountDataModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", accountId=");
        stringBuilder.append(this.accountId);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
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
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append(", showMyActiveCommunities=");
        stringBuilder.append(this.showMyActiveCommunities);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final void setAccountId(String str) {
        Intrinsics.b(str, "<set-?>");
        this.accountId = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.b(str, "<set-?>");
        this.name = str;
    }

    public final long getCreatedUtc() {
        return this.createdUtc;
    }

    public final void setCreatedUtc(long j) {
        this.createdUtc = j;
    }

    public final boolean isEmployee() {
        return this.isEmployee;
    }

    public final void setEmployee(boolean z) {
        this.isEmployee = z;
    }

    public final boolean isFriend() {
        return this.isFriend;
    }

    public final void setFriend(boolean z) {
        this.isFriend = z;
    }

    public final boolean isSuspended() {
        return this.isSuspended;
    }

    public final void setSuspended(boolean z) {
        this.isSuspended = z;
    }

    public final Integer getSuspensionExpiration() {
        return this.suspensionExpiration;
    }

    public final void setSuspensionExpiration(Integer num) {
        this.suspensionExpiration = num;
    }

    public final boolean getHideFromRobots() {
        return this.hideFromRobots;
    }

    public final void setHideFromRobots(boolean z) {
        this.hideFromRobots = z;
    }

    public final int getLinkKarma() {
        return this.linkKarma;
    }

    public final void setLinkKarma(int i) {
        this.linkKarma = i;
    }

    public final int getCommentKarma() {
        return this.commentKarma;
    }

    public final void setCommentKarma(int i) {
        this.commentKarma = i;
    }

    public final boolean isGold() {
        return this.isGold;
    }

    public final void setGold(boolean z) {
        this.isGold = z;
    }

    public final boolean isMod() {
        return this.isMod;
    }

    public final void setMod(boolean z) {
        this.isMod = z;
    }

    public final Boolean getHasVerifiedEmail() {
        return this.hasVerifiedEmail;
    }

    public final void setHasVerifiedEmail(Boolean bool) {
        this.hasVerifiedEmail = bool;
    }

    public final int getInboxCount() {
        return this.inboxCount;
    }

    public final void setInboxCount(int i) {
        this.inboxCount = i;
    }

    public final boolean getHasMail() {
        return this.hasMail;
    }

    public final void setHasMail(boolean z) {
        this.hasMail = z;
    }

    public final boolean getHasModMail() {
        return this.hasModMail;
    }

    public final void setHasModMail(boolean z) {
        this.hasModMail = z;
    }

    public final boolean getHideAds() {
        return this.hideAds;
    }

    public final void setHideAds(boolean z) {
        this.hideAds = z;
    }

    public final int getGoldCredits() {
        return this.goldCredits;
    }

    public final void setGoldCredits(int i) {
        this.goldCredits = i;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        Intrinsics.b(str, "<set-?>");
        this.iconUrl = str;
    }

    public /* synthetic */ AccountDataModel(long j, String str, String str2, long j2, boolean z, boolean z2, boolean z3, Integer num, boolean z4, int i, int i2, boolean z5, boolean z6, Boolean bool, int i3, boolean z7, boolean z8, boolean z9, int i4, String str3, Boolean bool2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        int i6 = i5;
        this((i6 & 1) != 0 ? 0 : j, (i6 & 2) != 0 ? "" : str, (i6 & 4) != 0 ? "" : str2, (i6 & 8) != 0 ? 0 : j2, (i6 & 16) != 0 ? false : z, (i6 & 32) != 0 ? false : z2, (i6 & 64) != 0 ? false : z3, (i6 & 128) != 0 ? null : num, (i6 & 256) != 0 ? false : z4, (i6 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? 0 : i, (i6 & 1024) != 0 ? 0 : i2, (i6 & MPEGConst.CODE_END) != 0 ? false : z5, (i6 & 4096) != 0 ? false : z6, (i6 & 8192) != 0 ? null : bool, (i6 & 16384) != 0 ? 0 : i3, (32768 & i6) != 0 ? false : z7, (65536 & i6) != 0 ? false : z8, (131072 & i6) != 0 ? false : z9, (262144 & i6) != 0 ? 0 : i4, (524288 & i6) != 0 ? "" : str3, (i6 & 1048576) != 0 ? null : bool2);
    }

    public final Boolean getShowMyActiveCommunities() {
        return this.showMyActiveCommunities;
    }

    public final void setShowMyActiveCommunities(Boolean bool) {
        this.showMyActiveCommunities = bool;
    }

    public AccountDataModel(long j, String str, String str2, long j2, boolean z, boolean z2, boolean z3, Integer num, boolean z4, int i, int i2, boolean z5, boolean z6, Boolean bool, int i3, boolean z7, boolean z8, boolean z9, int i4, String str3, Boolean bool2) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Intrinsics.b(str4, "accountId");
        Intrinsics.b(str5, "name");
        Intrinsics.b(str6, "iconUrl");
        this.id = j;
        this.accountId = str4;
        this.name = str5;
        this.createdUtc = j2;
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
        this.iconUrl = str6;
        this.showMyActiveCommunities = bool2;
    }
}
