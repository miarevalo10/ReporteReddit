package com.reddit.frontpage.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/domain/model/LinkSearchResultItem;", "Lcom/reddit/frontpage/domain/model/SearchResultItem;", "link", "Lcom/reddit/frontpage/domain/model/Link;", "(Lcom/reddit/frontpage/domain/model/Link;)V", "getLink", "()Lcom/reddit/frontpage/domain/model/Link;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SearchResults.kt */
public final class LinkSearchResultItem extends SearchResultItem {
    private final Link link;

    public static /* synthetic */ LinkSearchResultItem copy$default(LinkSearchResultItem linkSearchResultItem, Link link, int i, Object obj) {
        if ((i & 1) != 0) {
            link = linkSearchResultItem.link;
        }
        return linkSearchResultItem.copy(link);
    }

    public final Link component1() {
        return this.link;
    }

    public final LinkSearchResultItem copy(Link link) {
        Intrinsics.m26847b(link, "link");
        return new LinkSearchResultItem(link);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LinkSearchResultItem) {
                if (Intrinsics.m26845a(this.link, ((LinkSearchResultItem) obj).link)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Link link = this.link;
        return link != null ? link.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkSearchResultItem(link=");
        stringBuilder.append(this.link);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public LinkSearchResultItem(Link link) {
        Intrinsics.m26847b(link, "link");
        super();
        this.link = link;
    }

    public final Link getLink() {
        return this.link;
    }
}
