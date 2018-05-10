package com.reddit.datalibrary.frontpage.data.model;

import com.reddit.frontpage.domain.model.Subreddit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/RecommendedCategoryEnvelope;", "", "icon", "", "color", "subreddits", "Lcom/reddit/datalibrary/frontpage/data/model/ListingEnvelope;", "Lcom/reddit/frontpage/domain/model/Subreddit;", "(Ljava/lang/String;Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/data/model/ListingEnvelope;)V", "getColor", "()Ljava/lang/String;", "getIcon", "getSubreddits", "()Lcom/reddit/datalibrary/frontpage/data/model/ListingEnvelope;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RecommendedCategoryEnvelope.kt */
public final class RecommendedCategoryEnvelope {
    private final String color;
    private final String icon;
    private final ListingEnvelope<Subreddit> subreddits;

    public static /* synthetic */ RecommendedCategoryEnvelope copy$default(RecommendedCategoryEnvelope recommendedCategoryEnvelope, String str, String str2, ListingEnvelope listingEnvelope, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recommendedCategoryEnvelope.icon;
        }
        if ((i & 2) != 0) {
            str2 = recommendedCategoryEnvelope.color;
        }
        if ((i & 4) != 0) {
            listingEnvelope = recommendedCategoryEnvelope.subreddits;
        }
        return recommendedCategoryEnvelope.copy(str, str2, listingEnvelope);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.color;
    }

    public final ListingEnvelope<Subreddit> component3() {
        return this.subreddits;
    }

    public final RecommendedCategoryEnvelope copy(String str, String str2, ListingEnvelope<Subreddit> listingEnvelope) {
        Intrinsics.b(str, "icon");
        Intrinsics.b(str2, "color");
        Intrinsics.b(listingEnvelope, "subreddits");
        return new RecommendedCategoryEnvelope(str, str2, listingEnvelope);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RecommendedCategoryEnvelope) {
                RecommendedCategoryEnvelope recommendedCategoryEnvelope = (RecommendedCategoryEnvelope) obj;
                if (Intrinsics.a(this.icon, recommendedCategoryEnvelope.icon) && Intrinsics.a(this.color, recommendedCategoryEnvelope.color) && Intrinsics.a(this.subreddits, recommendedCategoryEnvelope.subreddits)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.icon;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.color;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ListingEnvelope listingEnvelope = this.subreddits;
        if (listingEnvelope != null) {
            i = listingEnvelope.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RecommendedCategoryEnvelope(icon=");
        stringBuilder.append(this.icon);
        stringBuilder.append(", color=");
        stringBuilder.append(this.color);
        stringBuilder.append(", subreddits=");
        stringBuilder.append(this.subreddits);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public RecommendedCategoryEnvelope(String str, String str2, ListingEnvelope<Subreddit> listingEnvelope) {
        Intrinsics.b(str, "icon");
        Intrinsics.b(str2, "color");
        Intrinsics.b(listingEnvelope, "subreddits");
        this.icon = str;
        this.color = str2;
        this.subreddits = listingEnvelope;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getColor() {
        return this.color;
    }

    public final ListingEnvelope<Subreddit> getSubreddits() {
        return this.subreddits;
    }
}
