package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\fJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006HÂ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006!"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/BannedUsersResponse;", "", "bannedUserIds", "", "", "bannedUsersMap", "", "Lcom/reddit/datalibrary/frontpage/data/model/BannedUser;", "token", "allUsersLoaded", "", "subredditId", "(Ljava/util/List;Ljava/util/Map;Ljava/lang/String;ZLjava/lang/String;)V", "getAllUsersLoaded", "()Z", "getBannedUserIds", "()Ljava/util/List;", "bannedUsers", "getBannedUsers", "getSubredditId", "()Ljava/lang/String;", "getToken", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BannedUsersResponse.kt */
public final class BannedUsersResponse {
    @Json(a = "allUsersLoaded")
    private final boolean allUsersLoaded;
    @Json(a = "bannedUserIds")
    private final List<String> bannedUserIds;
    @Json(a = "bannedUsers")
    private final Map<String, BannedUser> bannedUsersMap;
    @Json(a = "subredditId")
    private final String subredditId;
    @Json(a = "after")
    private final String token;

    private final Map<String, BannedUser> component2() {
        return this.bannedUsersMap;
    }

    public static /* synthetic */ BannedUsersResponse copy$default(BannedUsersResponse bannedUsersResponse, List list, Map map, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = bannedUsersResponse.bannedUserIds;
        }
        if ((i & 2) != 0) {
            map = bannedUsersResponse.bannedUsersMap;
        }
        Map map2 = map;
        if ((i & 4) != 0) {
            str = bannedUsersResponse.token;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            z = bannedUsersResponse.allUsersLoaded;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str2 = bannedUsersResponse.subredditId;
        }
        return bannedUsersResponse.copy(list, map2, str3, z2, str2);
    }

    public final List<String> component1() {
        return this.bannedUserIds;
    }

    public final String component3() {
        return this.token;
    }

    public final boolean component4() {
        return this.allUsersLoaded;
    }

    public final String component5() {
        return this.subredditId;
    }

    public final BannedUsersResponse copy(List<String> list, Map<String, BannedUser> map, String str, boolean z, String str2) {
        Intrinsics.b(list, "bannedUserIds");
        Intrinsics.b(map, "bannedUsersMap");
        Intrinsics.b(str2, "subredditId");
        return new BannedUsersResponse(list, map, str, z, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BannedUsersResponse) {
            BannedUsersResponse bannedUsersResponse = (BannedUsersResponse) obj;
            if (Intrinsics.a(this.bannedUserIds, bannedUsersResponse.bannedUserIds) && Intrinsics.a(this.bannedUsersMap, bannedUsersResponse.bannedUsersMap) && Intrinsics.a(this.token, bannedUsersResponse.token)) {
                return (this.allUsersLoaded == bannedUsersResponse.allUsersLoaded) && Intrinsics.a(this.subredditId, bannedUsersResponse.subredditId);
            }
        }
    }

    public final int hashCode() {
        List list = this.bannedUserIds;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Map map = this.bannedUsersMap;
        hashCode = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        String str = this.token;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        int i2 = this.allUsersLoaded;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str = this.subredditId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("BannedUsersResponse(bannedUserIds=");
        stringBuilder.append(this.bannedUserIds);
        stringBuilder.append(", bannedUsersMap=");
        stringBuilder.append(this.bannedUsersMap);
        stringBuilder.append(", token=");
        stringBuilder.append(this.token);
        stringBuilder.append(", allUsersLoaded=");
        stringBuilder.append(this.allUsersLoaded);
        stringBuilder.append(", subredditId=");
        stringBuilder.append(this.subredditId);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public BannedUsersResponse(List<String> list, Map<String, BannedUser> map, String str, boolean z, String str2) {
        Intrinsics.b(list, "bannedUserIds");
        Intrinsics.b(map, "bannedUsersMap");
        Intrinsics.b(str2, "subredditId");
        this.bannedUserIds = list;
        this.bannedUsersMap = map;
        this.token = str;
        this.allUsersLoaded = z;
        this.subredditId = str2;
    }

    public final List<String> getBannedUserIds() {
        return this.bannedUserIds;
    }

    public final String getToken() {
        return this.token;
    }

    public final boolean getAllUsersLoaded() {
        return this.allUsersLoaded;
    }

    public final String getSubredditId() {
        return this.subredditId;
    }

    public final List<BannedUser> getBannedUsers() {
        return CollectionsKt.n(this.bannedUsersMap.values());
    }
}
