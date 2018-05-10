package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\fJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006HÂ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006!"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/ApprovedSubmittersResponse;", "", "approvedSubmitterIds", "", "", "approvedSubmittersMap", "", "Lcom/reddit/datalibrary/frontpage/data/model/ApprovedSubmitter;", "token", "allUsersLoaded", "", "subredditId", "(Ljava/util/List;Ljava/util/Map;Ljava/lang/String;ZLjava/lang/String;)V", "getAllUsersLoaded", "()Z", "getApprovedSubmitterIds", "()Ljava/util/List;", "approvedSubmitters", "getApprovedSubmitters", "getSubredditId", "()Ljava/lang/String;", "getToken", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ApprovedSubmittersResponse.kt */
public final class ApprovedSubmittersResponse {
    @Json(a = "allUsersLoaded")
    private final boolean allUsersLoaded;
    @Json(a = "approvedSubmitterIds")
    private final List<String> approvedSubmitterIds;
    @Json(a = "approvedSubmitters")
    private final Map<String, ApprovedSubmitter> approvedSubmittersMap;
    @Json(a = "subredditId")
    private final String subredditId;
    @Json(a = "after")
    private final String token;

    private final Map<String, ApprovedSubmitter> component2() {
        return this.approvedSubmittersMap;
    }

    public static /* synthetic */ ApprovedSubmittersResponse copy$default(ApprovedSubmittersResponse approvedSubmittersResponse, List list, Map map, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = approvedSubmittersResponse.approvedSubmitterIds;
        }
        if ((i & 2) != 0) {
            map = approvedSubmittersResponse.approvedSubmittersMap;
        }
        Map map2 = map;
        if ((i & 4) != 0) {
            str = approvedSubmittersResponse.token;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            z = approvedSubmittersResponse.allUsersLoaded;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str2 = approvedSubmittersResponse.subredditId;
        }
        return approvedSubmittersResponse.copy(list, map2, str3, z2, str2);
    }

    public final List<String> component1() {
        return this.approvedSubmitterIds;
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

    public final ApprovedSubmittersResponse copy(List<String> list, Map<String, ApprovedSubmitter> map, String str, boolean z, String str2) {
        Intrinsics.b(list, "approvedSubmitterIds");
        Intrinsics.b(map, "approvedSubmittersMap");
        Intrinsics.b(str2, "subredditId");
        return new ApprovedSubmittersResponse(list, map, str, z, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApprovedSubmittersResponse) {
            ApprovedSubmittersResponse approvedSubmittersResponse = (ApprovedSubmittersResponse) obj;
            if (Intrinsics.a(this.approvedSubmitterIds, approvedSubmittersResponse.approvedSubmitterIds) && Intrinsics.a(this.approvedSubmittersMap, approvedSubmittersResponse.approvedSubmittersMap) && Intrinsics.a(this.token, approvedSubmittersResponse.token)) {
                return (this.allUsersLoaded == approvedSubmittersResponse.allUsersLoaded) && Intrinsics.a(this.subredditId, approvedSubmittersResponse.subredditId);
            }
        }
    }

    public final int hashCode() {
        List list = this.approvedSubmitterIds;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Map map = this.approvedSubmittersMap;
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
        StringBuilder stringBuilder = new StringBuilder("ApprovedSubmittersResponse(approvedSubmitterIds=");
        stringBuilder.append(this.approvedSubmitterIds);
        stringBuilder.append(", approvedSubmittersMap=");
        stringBuilder.append(this.approvedSubmittersMap);
        stringBuilder.append(", token=");
        stringBuilder.append(this.token);
        stringBuilder.append(", allUsersLoaded=");
        stringBuilder.append(this.allUsersLoaded);
        stringBuilder.append(", subredditId=");
        stringBuilder.append(this.subredditId);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ApprovedSubmittersResponse(List<String> list, Map<String, ApprovedSubmitter> map, String str, boolean z, String str2) {
        Intrinsics.b(list, "approvedSubmitterIds");
        Intrinsics.b(map, "approvedSubmittersMap");
        Intrinsics.b(str2, "subredditId");
        this.approvedSubmitterIds = list;
        this.approvedSubmittersMap = map;
        this.token = str;
        this.allUsersLoaded = z;
        this.subredditId = str2;
    }

    public final List<String> getApprovedSubmitterIds() {
        return this.approvedSubmitterIds;
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

    public final List<ApprovedSubmitter> getApprovedSubmitters() {
        return CollectionsKt.n(this.approvedSubmittersMap.values());
    }
}
