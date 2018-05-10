package com.reddit.frontpage.presentation.onboarding;

import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.presentation.common.BasePresenter;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000 \u00022\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/OnboardingContract;", "", "Companion", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingContract.kt */
public interface OnboardingContract {
    public static final Companion f20937a = Companion.f20936a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/OnboardingContract$Companion;", "", "()V", "DEFAULT_MIN_SUB_COUNT", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingContract.kt */
    public static final class Companion {
        static final /* synthetic */ Companion f20936a = new Companion();

        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000fH&¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/OnboardingContract$View;", "", "close", "", "disableSubscribeAll", "hideLoading", "notifyCategoryLoadError", "notifySubredditCountLoadError", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "setCategories", "categories", "", "showDone", "requiredSubscriptions", "", "showInProgress", "subscriptions", "showLoading", "showSubscribeAll", "showSubscribeInProgress", "showUnsubscribeAll", "updateSubredditCount", "count", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingContract.kt */
    public interface View {
        void V_();

        void W_();

        void X_();

        void mo7409a();

        void mo7410a(int i);

        void mo7411a(SubredditCategory subredditCategory);

        void mo7412a(SubredditCategory subredditCategory, int i);

        void mo7413a(List<SubredditCategory> list);

        void mo7414b();

        void mo7415c();

        void mo7416d();

        void mo7417e();

        void mo7418i();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/OnboardingContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "onCategorySelected", "", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "onDoneButtonClick", "onSubscribeAllClick", "onUnsubscribeAllClick", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface Presenter extends BasePresenter {
    }
}
