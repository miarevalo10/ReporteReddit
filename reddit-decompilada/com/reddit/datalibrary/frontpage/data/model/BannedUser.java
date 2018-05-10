package com.reddit.datalibrary.frontpage.data.model;

import com.google.android.gms.ads.AdRequest;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jcodec.codecs.mpeg12.MPEGConst;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012¨\u00066"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/BannedUser;", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsUserModel;", "username", "", "atUtc", "", "banMessage", "bannedBy", "reason", "duration", "postId", "id", "modNote", "accountIcon", "commentId", "subredditId", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountIcon", "()Ljava/lang/String;", "getAtUtc", "()J", "getBanMessage", "getBannedBy", "getCommentId", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "getModNote", "getPostId", "getReason", "getSubredditId", "getUsername", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/reddit/datalibrary/frontpage/data/model/BannedUser;", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BannedUser.kt */
public final class BannedUser implements ModToolsUserModel {
    @Json(a = "accountIcon")
    private final String accountIcon;
    @Json(a = "bannedAtUTC")
    private final long atUtc;
    @Json(a = "banMessage")
    private final String banMessage;
    @Json(a = "bannedBy")
    private final String bannedBy;
    @Json(a = "commentId")
    private final String commentId;
    @Json(a = "duration")
    private final Long duration;
    @Json(a = "id")
    private final String id;
    @Json(a = "modNote")
    private final String modNote;
    @Json(a = "post")
    private final String postId;
    @Json(a = "reason")
    private final String reason;
    @Json(a = "subredditId")
    private final String subredditId;
    @Json(a = "username")
    private final String username;

    public static /* synthetic */ BannedUser copy$default(BannedUser bannedUser, String str, long j, String str2, String str3, String str4, Long l, String str5, String str6, String str7, String str8, String str9, String str10, int i, Object obj) {
        BannedUser bannedUser2 = bannedUser;
        int i2 = i;
        return bannedUser2.copy((i2 & 1) != 0 ? bannedUser2.getUsername() : str, (i2 & 2) != 0 ? bannedUser2.getAtUtc() : j, (i2 & 4) != 0 ? bannedUser2.banMessage : str2, (i2 & 8) != 0 ? bannedUser2.bannedBy : str3, (i2 & 16) != 0 ? bannedUser2.getReason() : str4, (i2 & 32) != 0 ? bannedUser2.duration : l, (i2 & 64) != 0 ? bannedUser2.postId : str5, (i2 & 128) != 0 ? bannedUser2.getId() : str6, (i2 & 256) != 0 ? bannedUser2.modNote : str7, (i2 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? bannedUser2.getAccountIcon() : str8, (i2 & 1024) != 0 ? bannedUser2.commentId : str9, (i2 & MPEGConst.CODE_END) != 0 ? bannedUser2.subredditId : str10);
    }

    public final String component1() {
        return getUsername();
    }

    public final String component10() {
        return getAccountIcon();
    }

    public final String component11() {
        return this.commentId;
    }

    public final String component12() {
        return this.subredditId;
    }

    public final long component2() {
        return getAtUtc();
    }

    public final String component3() {
        return this.banMessage;
    }

    public final String component4() {
        return this.bannedBy;
    }

    public final String component5() {
        return getReason();
    }

    public final Long component6() {
        return this.duration;
    }

    public final String component7() {
        return this.postId;
    }

    public final String component8() {
        return getId();
    }

    public final String component9() {
        return this.modNote;
    }

    public final BannedUser copy(String str, long j, String str2, String str3, String str4, Long l, String str5, String str6, String str7, String str8, String str9, String str10) {
        String str11 = str;
        Intrinsics.b(str11, "username");
        String str12 = str2;
        Intrinsics.b(str12, "banMessage");
        String str13 = str3;
        Intrinsics.b(str13, "bannedBy");
        String str14 = str4;
        Intrinsics.b(str14, "reason");
        String str15 = str6;
        Intrinsics.b(str15, "id");
        String str16 = str7;
        Intrinsics.b(str16, "modNote");
        String str17 = str10;
        Intrinsics.b(str17, "subredditId");
        return new BannedUser(str11, j, str12, str13, str14, l, str5, str15, str16, str8, str9, str17);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BannedUser) {
            BannedUser bannedUser = (BannedUser) obj;
            if (Intrinsics.a(getUsername(), bannedUser.getUsername())) {
                return ((getAtUtc() > bannedUser.getAtUtc() ? 1 : (getAtUtc() == bannedUser.getAtUtc() ? 0 : -1)) == 0) && Intrinsics.a(this.banMessage, bannedUser.banMessage) && Intrinsics.a(this.bannedBy, bannedUser.bannedBy) && Intrinsics.a(getReason(), bannedUser.getReason()) && Intrinsics.a(this.duration, bannedUser.duration) && Intrinsics.a(this.postId, bannedUser.postId) && Intrinsics.a(getId(), bannedUser.getId()) && Intrinsics.a(this.modNote, bannedUser.modNote) && Intrinsics.a(getAccountIcon(), bannedUser.getAccountIcon()) && Intrinsics.a(this.commentId, bannedUser.commentId) && Intrinsics.a(this.subredditId, bannedUser.subredditId);
            }
        }
    }

    public final int hashCode() {
        String username = getUsername();
        int i = 0;
        int hashCode = (username != null ? username.hashCode() : 0) * 31;
        long atUtc = getAtUtc();
        hashCode = (hashCode + ((int) (atUtc ^ (atUtc >>> 32)))) * 31;
        String str = this.banMessage;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.bannedBy;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = getReason();
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.duration;
        hashCode = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        str = this.postId;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = getId();
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.modNote;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = getAccountIcon();
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.commentId;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.subredditId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("BannedUser(username=");
        stringBuilder.append(getUsername());
        stringBuilder.append(", atUtc=");
        stringBuilder.append(getAtUtc());
        stringBuilder.append(", banMessage=");
        stringBuilder.append(this.banMessage);
        stringBuilder.append(", bannedBy=");
        stringBuilder.append(this.bannedBy);
        stringBuilder.append(", reason=");
        stringBuilder.append(getReason());
        stringBuilder.append(", duration=");
        stringBuilder.append(this.duration);
        stringBuilder.append(", postId=");
        stringBuilder.append(this.postId);
        stringBuilder.append(", id=");
        stringBuilder.append(getId());
        stringBuilder.append(", modNote=");
        stringBuilder.append(this.modNote);
        stringBuilder.append(", accountIcon=");
        stringBuilder.append(getAccountIcon());
        stringBuilder.append(", commentId=");
        stringBuilder.append(this.commentId);
        stringBuilder.append(", subredditId=");
        stringBuilder.append(this.subredditId);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public BannedUser(String str, long j, String str2, String str3, String str4, Long l, String str5, String str6, String str7, String str8, String str9, String str10) {
        Intrinsics.b(str, "username");
        Intrinsics.b(str2, "banMessage");
        Intrinsics.b(str3, "bannedBy");
        Intrinsics.b(str4, "reason");
        Intrinsics.b(str6, "id");
        Intrinsics.b(str7, "modNote");
        Intrinsics.b(str10, "subredditId");
        this.username = str;
        this.atUtc = j;
        this.banMessage = str2;
        this.bannedBy = str3;
        this.reason = str4;
        this.duration = l;
        this.postId = str5;
        this.id = str6;
        this.modNote = str7;
        this.accountIcon = str8;
        this.commentId = str9;
        this.subredditId = str10;
    }

    public final String getUsername() {
        return this.username;
    }

    public final long getAtUtc() {
        return this.atUtc;
    }

    public final String getBanMessage() {
        return this.banMessage;
    }

    public final String getBannedBy() {
        return this.bannedBy;
    }

    public final String getReason() {
        return this.reason;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getModNote() {
        return this.modNote;
    }

    public final String getAccountIcon() {
        return this.accountIcon;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getSubredditId() {
        return this.subredditId;
    }
}
