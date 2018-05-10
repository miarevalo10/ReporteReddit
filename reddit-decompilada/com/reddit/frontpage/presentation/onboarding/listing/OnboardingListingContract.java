package com.reddit.frontpage.presentation.onboarding.listing;

import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.presentation.listing.common.ListingLinkActions;
import com.reddit.frontpage.presentation.listing.common.ListingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u0000 \u00022\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingContract;", "", "Companion", "Parameters", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingListingContract.kt */
public interface OnboardingListingContract {
    public static final Companion f20952a = Companion.f20949a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingContract$Companion;", "", "()V", "SOURCE_PAGE", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingListingContract.kt */
    public static final class Companion {
        static final /* synthetic */ Companion f20949a = new Companion();

        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingContract$Parameters;", "", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "refresh", "", "(Lcom/reddit/frontpage/domain/model/SubredditCategory;Z)V", "getCategory", "()Lcom/reddit/frontpage/domain/model/SubredditCategory;", "getRefresh", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingListingContract.kt */
    public static final class Parameters {
        final SubredditCategory f20950a;
        final boolean f20951b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Parameters) {
                Parameters parameters = (Parameters) obj;
                if (Intrinsics.m26845a(this.f20950a, parameters.f20950a)) {
                    if (this.f20951b == parameters.f20951b) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            SubredditCategory subredditCategory = this.f20950a;
            int hashCode = (subredditCategory != null ? subredditCategory.hashCode() : 0) * 31;
            int i = this.f20951b;
            if (i != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Parameters(category=");
            stringBuilder.append(this.f20950a);
            stringBuilder.append(", refresh=");
            stringBuilder.append(this.f20951b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Parameters(SubredditCategory subredditCategory, boolean z) {
            Intrinsics.m26847b(subredditCategory, "category");
            this.f20950a = subredditCategory;
            this.f20951b = z;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "Lcom/reddit/frontpage/presentation/listing/common/ListingActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingLinkActions;", "onLinkVisible", "", "position", "", "onLoadErrorClicked", "onSubscribeClicked", "onVoteChanged", "direction", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface Presenter extends BasePresenter, ListingLinkActions {
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingContract$View;", "Lcom/reddit/frontpage/presentation/listing/common/ListingView;", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingLinkPresentationModel;", "hideLoading", "", "hideLoadingMore", "notifyLoadMoreError", "showContentListView", "showEmptyListView", "showLoading", "showLoadingMore", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingListingContract.kt */
    public interface View extends ListingView<OnboardingLinkPresentationModel> {
        void Z_();

        void mo7677a();

        void mo7678b();

        void mo7679c();

        void mo7680d();

        void mo7681e();
    }
}
