package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006HÂ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003JY\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\f\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006&"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/ModeratorsResponse;", "", "moderatorIds", "", "", "moderatorsMap", "", "Lcom/reddit/datalibrary/frontpage/data/model/Moderator;", "token", "allUsersLoaded", "", "subredditId", "invitePending", "(Ljava/util/List;Ljava/util/Map;Ljava/lang/String;ZLjava/lang/String;Z)V", "getAllUsersLoaded", "()Z", "editableModerators", "getEditableModerators", "()Ljava/util/List;", "getInvitePending", "getModeratorIds", "moderators", "getModerators", "getSubredditId", "()Ljava/lang/String;", "getToken", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModeratorsResponse.kt */
public final class ModeratorsResponse {
    @Json(a = "allUsersLoaded")
    private final boolean allUsersLoaded;
    @Json(a = "invitePending")
    private final boolean invitePending;
    @Json(a = "moderatorIds")
    private final List<String> moderatorIds;
    @Json(a = "moderators")
    private final Map<String, Moderator> moderatorsMap;
    @Json(a = "subredditId")
    private final String subredditId;
    @Json(a = "after")
    private final String token;

    private final Map<String, Moderator> component2() {
        return this.moderatorsMap;
    }

    public static /* synthetic */ ModeratorsResponse copy$default(ModeratorsResponse moderatorsResponse, List list, Map map, String str, boolean z, String str2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = moderatorsResponse.moderatorIds;
        }
        if ((i & 2) != 0) {
            map = moderatorsResponse.moderatorsMap;
        }
        Map map2 = map;
        if ((i & 4) != 0) {
            str = moderatorsResponse.token;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            z = moderatorsResponse.allUsersLoaded;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            str2 = moderatorsResponse.subredditId;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            z2 = moderatorsResponse.invitePending;
        }
        return moderatorsResponse.copy(list, map2, str3, z3, str4, z2);
    }

    public final List<String> component1() {
        return this.moderatorIds;
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

    public final boolean component6() {
        return this.invitePending;
    }

    public final ModeratorsResponse copy(List<String> list, Map<String, Moderator> map, String str, boolean z, String str2, boolean z2) {
        Intrinsics.b(list, "moderatorIds");
        Intrinsics.b(map, "moderatorsMap");
        Intrinsics.b(str2, "subredditId");
        return new ModeratorsResponse(list, map, str, z, str2, z2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ModeratorsResponse) {
            ModeratorsResponse moderatorsResponse = (ModeratorsResponse) obj;
            if (Intrinsics.a(this.moderatorIds, moderatorsResponse.moderatorIds) && Intrinsics.a(this.moderatorsMap, moderatorsResponse.moderatorsMap) && Intrinsics.a(this.token, moderatorsResponse.token)) {
                if ((this.allUsersLoaded == moderatorsResponse.allUsersLoaded) && Intrinsics.a(this.subredditId, moderatorsResponse.subredditId)) {
                    if (this.invitePending == moderatorsResponse.invitePending) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        List list = this.moderatorIds;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Map map = this.moderatorsMap;
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
        hashCode = (hashCode + i) * 31;
        i = this.invitePending;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ModeratorsResponse(moderatorIds=");
        stringBuilder.append(this.moderatorIds);
        stringBuilder.append(", moderatorsMap=");
        stringBuilder.append(this.moderatorsMap);
        stringBuilder.append(", token=");
        stringBuilder.append(this.token);
        stringBuilder.append(", allUsersLoaded=");
        stringBuilder.append(this.allUsersLoaded);
        stringBuilder.append(", subredditId=");
        stringBuilder.append(this.subredditId);
        stringBuilder.append(", invitePending=");
        stringBuilder.append(this.invitePending);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ModeratorsResponse(List<String> list, Map<String, Moderator> map, String str, boolean z, String str2, boolean z2) {
        Intrinsics.b(list, "moderatorIds");
        Intrinsics.b(map, "moderatorsMap");
        Intrinsics.b(str2, "subredditId");
        this.moderatorIds = list;
        this.moderatorsMap = map;
        this.token = str;
        this.allUsersLoaded = z;
        this.subredditId = str2;
        this.invitePending = z2;
    }

    public final List<String> getModeratorIds() {
        return this.moderatorIds;
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

    public final boolean getInvitePending() {
        return this.invitePending;
    }

    public final List<Moderator> getModerators() {
        return CollectionsKt.n(this.moderatorsMap.values());
    }

    public final List<Moderator> getEditableModerators() {
        Collection arrayList = new ArrayList();
        for (Object next : CollectionsKt.n(this.moderatorsMap.values())) {
            if (((Moderator) next).getEditable()) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }
}
