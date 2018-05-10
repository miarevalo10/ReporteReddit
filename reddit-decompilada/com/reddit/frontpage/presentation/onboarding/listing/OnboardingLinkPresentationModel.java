package com.reddit.frontpage.presentation.onboarding.listing;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u000eHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingLinkPresentationModel;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "linkPresentationModel", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "subscriberCount", "", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "(Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;Ljava/lang/String;Lcom/reddit/frontpage/domain/model/SubredditCategory;)V", "getCategory", "()Lcom/reddit/frontpage/domain/model/SubredditCategory;", "getLinkPresentationModel", "()Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "listableType", "", "getListableType", "()I", "getSubscriberCount", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getUniqueID", "", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingLinkPresentationModel.kt */
public final class OnboardingLinkPresentationModel implements Listable {
    final LinkPresentationModel f34114a;
    final String f34115b;
    final SubredditCategory f34116c;
    private final int f34117d = 18;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof OnboardingLinkPresentationModel) {
                OnboardingLinkPresentationModel onboardingLinkPresentationModel = (OnboardingLinkPresentationModel) obj;
                if (Intrinsics.m26845a(this.f34114a, onboardingLinkPresentationModel.f34114a) && Intrinsics.m26845a(this.f34115b, onboardingLinkPresentationModel.f34115b) && Intrinsics.m26845a(this.f34116c, onboardingLinkPresentationModel.f34116c)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int getMinAndroidVersion() {
        return 0;
    }

    public final int hashCode() {
        LinkPresentationModel linkPresentationModel = this.f34114a;
        int i = 0;
        int hashCode = (linkPresentationModel != null ? linkPresentationModel.hashCode() : 0) * 31;
        String str = this.f34115b;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        SubredditCategory subredditCategory = this.f34116c;
        if (subredditCategory != null) {
            i = subredditCategory.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("OnboardingLinkPresentationModel(linkPresentationModel=");
        stringBuilder.append(this.f34114a);
        stringBuilder.append(", subscriberCount=");
        stringBuilder.append(this.f34115b);
        stringBuilder.append(", category=");
        stringBuilder.append(this.f34116c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public OnboardingLinkPresentationModel(LinkPresentationModel linkPresentationModel, String str, SubredditCategory subredditCategory) {
        Intrinsics.m26847b(linkPresentationModel, "linkPresentationModel");
        Intrinsics.m26847b(str, "subscriberCount");
        Intrinsics.m26847b(subredditCategory, "category");
        this.f34114a = linkPresentationModel;
        this.f34115b = str;
        this.f34116c = subredditCategory;
    }

    public final int getListableType() {
        return this.f34117d;
    }

    public final long getUniqueID() {
        return this.f34114a.getUniqueID();
    }
}
