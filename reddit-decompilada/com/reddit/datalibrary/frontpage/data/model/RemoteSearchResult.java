package com.reddit.datalibrary.frontpage.data.model;

import com.reddit.frontpage.domain.model.SearchResultItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/RemoteSearchResult;", "", "items", "", "Lcom/reddit/frontpage/domain/model/SearchResultItem;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteSearchResult.kt */
public final class RemoteSearchResult {
    private final List<SearchResultItem> items;

    public static /* synthetic */ RemoteSearchResult copy$default(RemoteSearchResult remoteSearchResult, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = remoteSearchResult.items;
        }
        return remoteSearchResult.copy(list);
    }

    public final List<SearchResultItem> component1() {
        return this.items;
    }

    public final RemoteSearchResult copy(List<? extends SearchResultItem> list) {
        Intrinsics.b(list, "items");
        return new RemoteSearchResult(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RemoteSearchResult) {
                if (Intrinsics.a(this.items, ((RemoteSearchResult) obj).items)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List list = this.items;
        return list != null ? list.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RemoteSearchResult(items=");
        stringBuilder.append(this.items);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public RemoteSearchResult(List<? extends SearchResultItem> list) {
        Intrinsics.b(list, "items");
        this.items = list;
    }

    public final List<SearchResultItem> getItems() {
        return this.items;
    }
}
