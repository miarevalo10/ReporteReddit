package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/SubredditRule;", "", "shortName", "", "descriptionHtml", "(Ljava/lang/String;Ljava/lang/String;)V", "getDescriptionHtml", "()Ljava/lang/String;", "getShortName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditRulesResponse.kt */
public final class SubredditRule {
    @Json(a = "description_html")
    private final String descriptionHtml;
    @Json(a = "short_name")
    private final String shortName;

    public static /* synthetic */ SubredditRule copy$default(SubredditRule subredditRule, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subredditRule.shortName;
        }
        if ((i & 2) != 0) {
            str2 = subredditRule.descriptionHtml;
        }
        return subredditRule.copy(str, str2);
    }

    public final String component1() {
        return this.shortName;
    }

    public final String component2() {
        return this.descriptionHtml;
    }

    public final SubredditRule copy(String str, String str2) {
        Intrinsics.b(str, "shortName");
        return new SubredditRule(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SubredditRule) {
                SubredditRule subredditRule = (SubredditRule) obj;
                if (Intrinsics.a(this.shortName, subredditRule.shortName) && Intrinsics.a(this.descriptionHtml, subredditRule.descriptionHtml)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.shortName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.descriptionHtml;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SubredditRule(shortName=");
        stringBuilder.append(this.shortName);
        stringBuilder.append(", descriptionHtml=");
        stringBuilder.append(this.descriptionHtml);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SubredditRule(String str, String str2) {
        Intrinsics.b(str, "shortName");
        this.shortName = str;
        this.descriptionHtml = str2;
    }

    public final String getShortName() {
        return this.shortName;
    }

    public final String getDescriptionHtml() {
        return this.descriptionHtml;
    }
}
