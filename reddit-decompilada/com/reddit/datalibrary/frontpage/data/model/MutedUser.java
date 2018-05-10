package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/MutedUser;", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsUserModel;", "username", "", "atUtc", "", "id", "accountIcon", "reason", "mutedBy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountIcon", "()Ljava/lang/String;", "getAtUtc", "()J", "getId", "getMutedBy", "getReason", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MutedUser.kt */
public final class MutedUser implements ModToolsUserModel {
    @Json(a = "accountIcon")
    private final String accountIcon;
    @Json(a = "mutedAtUTC")
    private final long atUtc;
    @Json(a = "id")
    private final String id;
    @Json(a = "mutedBy")
    private final String mutedBy;
    @Json(a = "reason")
    private final String reason;
    @Json(a = "username")
    private final String username;

    public static /* synthetic */ MutedUser copy$default(MutedUser mutedUser, String str, long j, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mutedUser.getUsername();
        }
        if ((i & 2) != 0) {
            j = mutedUser.getAtUtc();
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str2 = mutedUser.getId();
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = mutedUser.getAccountIcon();
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = mutedUser.getReason();
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = mutedUser.mutedBy;
        }
        return mutedUser.copy(str, j2, str6, str7, str8, str5);
    }

    public final String component1() {
        return getUsername();
    }

    public final long component2() {
        return getAtUtc();
    }

    public final String component3() {
        return getId();
    }

    public final String component4() {
        return getAccountIcon();
    }

    public final String component5() {
        return getReason();
    }

    public final String component6() {
        return this.mutedBy;
    }

    public final MutedUser copy(String str, long j, String str2, String str3, String str4, String str5) {
        String str6 = str;
        Intrinsics.b(str6, "username");
        String str7 = str2;
        Intrinsics.b(str7, "id");
        String str8 = str5;
        Intrinsics.b(str8, "mutedBy");
        return new MutedUser(str6, j, str7, str3, str4, str8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MutedUser) {
            MutedUser mutedUser = (MutedUser) obj;
            if (Intrinsics.a(getUsername(), mutedUser.getUsername())) {
                return ((getAtUtc() > mutedUser.getAtUtc() ? 1 : (getAtUtc() == mutedUser.getAtUtc() ? 0 : -1)) == 0) && Intrinsics.a(getId(), mutedUser.getId()) && Intrinsics.a(getAccountIcon(), mutedUser.getAccountIcon()) && Intrinsics.a(getReason(), mutedUser.getReason()) && Intrinsics.a(this.mutedBy, mutedUser.mutedBy);
            }
        }
    }

    public final int hashCode() {
        String username = getUsername();
        int i = 0;
        int hashCode = (username != null ? username.hashCode() : 0) * 31;
        long atUtc = getAtUtc();
        hashCode = (hashCode + ((int) (atUtc ^ (atUtc >>> 32)))) * 31;
        String id = getId();
        hashCode = (hashCode + (id != null ? id.hashCode() : 0)) * 31;
        id = getAccountIcon();
        hashCode = (hashCode + (id != null ? id.hashCode() : 0)) * 31;
        id = getReason();
        hashCode = (hashCode + (id != null ? id.hashCode() : 0)) * 31;
        id = this.mutedBy;
        if (id != null) {
            i = id.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MutedUser(username=");
        stringBuilder.append(getUsername());
        stringBuilder.append(", atUtc=");
        stringBuilder.append(getAtUtc());
        stringBuilder.append(", id=");
        stringBuilder.append(getId());
        stringBuilder.append(", accountIcon=");
        stringBuilder.append(getAccountIcon());
        stringBuilder.append(", reason=");
        stringBuilder.append(getReason());
        stringBuilder.append(", mutedBy=");
        stringBuilder.append(this.mutedBy);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public MutedUser(String str, long j, String str2, String str3, String str4, String str5) {
        Intrinsics.b(str, "username");
        Intrinsics.b(str2, "id");
        Intrinsics.b(str5, "mutedBy");
        this.username = str;
        this.atUtc = j;
        this.id = str2;
        this.accountIcon = str3;
        this.reason = str4;
        this.mutedBy = str5;
    }

    public final String getUsername() {
        return this.username;
    }

    public final long getAtUtc() {
        return this.atUtc;
    }

    public final String getId() {
        return this.id;
    }

    public final String getAccountIcon() {
        return this.accountIcon;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getMutedBy() {
        return this.mutedBy;
    }
}
