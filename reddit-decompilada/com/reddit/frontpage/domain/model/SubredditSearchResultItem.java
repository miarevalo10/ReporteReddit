package com.reddit.frontpage.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/domain/model/SubredditSearchResultItem;", "Lcom/reddit/frontpage/domain/model/SearchResultItem;", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "(Lcom/reddit/frontpage/domain/model/Subreddit;)V", "getSubreddit", "()Lcom/reddit/frontpage/domain/model/Subreddit;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SearchResults.kt */
public final class SubredditSearchResultItem extends SearchResultItem {
    private final Subreddit subreddit;

    public static /* synthetic */ SubredditSearchResultItem copy$default(SubredditSearchResultItem subredditSearchResultItem, Subreddit subreddit, int i, Object obj) {
        if ((i & 1) != 0) {
            subreddit = subredditSearchResultItem.subreddit;
        }
        return subredditSearchResultItem.copy(subreddit);
    }

    public final Subreddit component1() {
        return this.subreddit;
    }

    public final SubredditSearchResultItem copy(Subreddit subreddit) {
        Intrinsics.m26847b(subreddit, "subreddit");
        return new SubredditSearchResultItem(subreddit);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SubredditSearchResultItem) {
                if (Intrinsics.m26845a(this.subreddit, ((SubredditSearchResultItem) obj).subreddit)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Subreddit subreddit = this.subreddit;
        return subreddit != null ? subreddit.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SubredditSearchResultItem(subreddit=");
        stringBuilder.append(this.subreddit);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SubredditSearchResultItem(Subreddit subreddit) {
        Intrinsics.m26847b(subreddit, "subreddit");
        super();
        this.subreddit = subreddit;
    }

    public final Subreddit getSubreddit() {
        return this.subreddit;
    }
}
