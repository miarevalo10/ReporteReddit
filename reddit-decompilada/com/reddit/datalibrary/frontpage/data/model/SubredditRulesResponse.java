package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÂ\u0003J)\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/SubredditRulesResponse;", "", "rules", "", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditRule;", "siteRules", "", "(Ljava/util/List;Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "getAllRules", "getSubredditRules", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditRulesResponse.kt */
public final class SubredditRulesResponse {
    @Json(a = "rules")
    private final List<SubredditRule> rules;
    @Json(a = "site_rules")
    private final List<String> siteRules;

    private final List<SubredditRule> component1() {
        return this.rules;
    }

    private final List<String> component2() {
        return this.siteRules;
    }

    public static /* synthetic */ SubredditRulesResponse copy$default(SubredditRulesResponse subredditRulesResponse, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = subredditRulesResponse.rules;
        }
        if ((i & 2) != 0) {
            list2 = subredditRulesResponse.siteRules;
        }
        return subredditRulesResponse.copy(list, list2);
    }

    public final SubredditRulesResponse copy(List<SubredditRule> list, List<String> list2) {
        Intrinsics.b(list, "rules");
        Intrinsics.b(list2, "siteRules");
        return new SubredditRulesResponse(list, list2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SubredditRulesResponse) {
                SubredditRulesResponse subredditRulesResponse = (SubredditRulesResponse) obj;
                if (Intrinsics.a(this.rules, subredditRulesResponse.rules) && Intrinsics.a(this.siteRules, subredditRulesResponse.siteRules)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List list = this.rules;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List list2 = this.siteRules;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SubredditRulesResponse(rules=");
        stringBuilder.append(this.rules);
        stringBuilder.append(", siteRules=");
        stringBuilder.append(this.siteRules);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SubredditRulesResponse(List<SubredditRule> list, List<String> list2) {
        Intrinsics.b(list, "rules");
        Intrinsics.b(list2, "siteRules");
        this.rules = list;
        this.siteRules = list2;
    }

    public final List<String> getAllRules() {
        Iterable<SubredditRule> iterable = this.rules;
        Collection arrayList = new ArrayList(CollectionsKt.b(iterable));
        for (SubredditRule shortName : iterable) {
            arrayList.add(shortName.getShortName());
        }
        return CollectionsKt.b((List) arrayList, this.siteRules);
    }

    public final List<SubredditRule> getSubredditRules() {
        return this.rules;
    }
}
