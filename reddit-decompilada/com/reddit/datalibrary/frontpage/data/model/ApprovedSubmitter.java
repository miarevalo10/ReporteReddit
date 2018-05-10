package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/ApprovedSubmitter;", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsUserModel;", "username", "", "atUtc", "", "id", "accountIcon", "reason", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountIcon", "()Ljava/lang/String;", "getAtUtc", "()J", "getId", "getReason", "getUsername", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ApprovedSubmitter.kt */
public final class ApprovedSubmitter implements ModToolsUserModel {
    @Json(a = "accountIcon")
    private final String accountIcon;
    @Json(a = "approvedAtUTC")
    private final long atUtc;
    @Json(a = "id")
    private final String id;
    @Json(a = "reason")
    private final String reason;
    @Json(a = "username")
    private final String username;

    public static /* synthetic */ ApprovedSubmitter copy$default(ApprovedSubmitter approvedSubmitter, String str, long j, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = approvedSubmitter.getUsername();
        }
        if ((i & 2) != 0) {
            j = approvedSubmitter.getAtUtc();
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str2 = approvedSubmitter.getId();
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = approvedSubmitter.getAccountIcon();
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = approvedSubmitter.getReason();
        }
        return approvedSubmitter.copy(str, j2, str5, str6, str4);
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

    public final ApprovedSubmitter copy(String str, long j, String str2, String str3, String str4) {
        Intrinsics.b(str, "username");
        Intrinsics.b(str2, "id");
        return new ApprovedSubmitter(str, j, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApprovedSubmitter) {
            ApprovedSubmitter approvedSubmitter = (ApprovedSubmitter) obj;
            if (Intrinsics.a(getUsername(), approvedSubmitter.getUsername())) {
                return ((getAtUtc() > approvedSubmitter.getAtUtc() ? 1 : (getAtUtc() == approvedSubmitter.getAtUtc() ? 0 : -1)) == 0) && Intrinsics.a(getId(), approvedSubmitter.getId()) && Intrinsics.a(getAccountIcon(), approvedSubmitter.getAccountIcon()) && Intrinsics.a(getReason(), approvedSubmitter.getReason());
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
        if (id != null) {
            i = id.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ApprovedSubmitter(username=");
        stringBuilder.append(getUsername());
        stringBuilder.append(", atUtc=");
        stringBuilder.append(getAtUtc());
        stringBuilder.append(", id=");
        stringBuilder.append(getId());
        stringBuilder.append(", accountIcon=");
        stringBuilder.append(getAccountIcon());
        stringBuilder.append(", reason=");
        stringBuilder.append(getReason());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ApprovedSubmitter(String str, long j, String str2, String str3, String str4) {
        Intrinsics.b(str, "username");
        Intrinsics.b(str2, "id");
        this.username = str;
        this.atUtc = j;
        this.id = str2;
        this.accountIcon = str3;
        this.reason = str4;
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
}
