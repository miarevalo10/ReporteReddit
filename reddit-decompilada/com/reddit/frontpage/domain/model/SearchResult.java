package com.reddit.frontpage.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/domain/model/SearchResult;", "", "query", "", "items", "", "Lcom/reddit/frontpage/domain/model/SearchResultItem;", "after", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAfter", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getQuery", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SearchResults.kt */
public final class SearchResult {
    private final String after;
    private final List<SearchResultItem> items;
    private final String query;

    public static /* synthetic */ SearchResult copy$default(SearchResult searchResult, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchResult.query;
        }
        if ((i & 2) != 0) {
            list = searchResult.items;
        }
        if ((i & 4) != 0) {
            str2 = searchResult.after;
        }
        return searchResult.copy(str, list, str2);
    }

    public final String component1() {
        return this.query;
    }

    public final List<SearchResultItem> component2() {
        return this.items;
    }

    public final String component3() {
        return this.after;
    }

    public final SearchResult copy(String str, List<? extends SearchResultItem> list, String str2) {
        Intrinsics.m26847b(str, "query");
        Intrinsics.m26847b(list, "items");
        return new SearchResult(str, list, str2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SearchResult) {
                SearchResult searchResult = (SearchResult) obj;
                if (Intrinsics.m26845a(this.query, searchResult.query) && Intrinsics.m26845a(this.items, searchResult.items) && Intrinsics.m26845a(this.after, searchResult.after)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.query;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List list = this.items;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.after;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SearchResult(query=");
        stringBuilder.append(this.query);
        stringBuilder.append(", items=");
        stringBuilder.append(this.items);
        stringBuilder.append(", after=");
        stringBuilder.append(this.after);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SearchResult(String str, List<? extends SearchResultItem> list, String str2) {
        Intrinsics.m26847b(str, "query");
        Intrinsics.m26847b(list, "items");
        this.query = str;
        this.items = list;
        this.after = str2;
    }

    public final String getQuery() {
        return this.query;
    }

    public final List<SearchResultItem> getItems() {
        return this.items;
    }

    public /* synthetic */ SearchResult(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        this(str, list, str2);
    }

    public final String getAfter() {
        return this.after;
    }
}
