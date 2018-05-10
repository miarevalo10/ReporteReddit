package com.reddit.frontpage.di.component;

import android.app.Activity;
import android.content.Context;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingContract.Parameters;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingContract.View;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingScreen;
import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/component/OnboardingListingViewComponent;", "", "inject", "", "screen", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen;", "Builder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingListingViewComponent.kt */
public interface OnboardingListingViewComponent {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H'J\b\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\u0003\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H'J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH'J\u0012\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H'¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/di/component/OnboardingListingViewComponent$Builder;", "", "activity", "context", "Lkotlin/Lazy;", "Landroid/app/Activity;", "build", "Lcom/reddit/frontpage/di/component/OnboardingListingViewComponent;", "Landroid/content/Context;", "params", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingContract$Parameters;", "sourcePage", "", "userComponent", "component", "Lcom/reddit/frontpage/di/component/UserComponent;", "view", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingContract$View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingListingViewComponent.kt */
    public interface Builder {
        Builder mo4702a(UserComponent userComponent);

        Builder mo4703a(Parameters parameters);

        Builder mo4704a(View view);

        Builder mo4705a(String str);

        Builder mo4706a(Lazy<? extends Context> lazy);

        OnboardingListingViewComponent mo4707a();

        Builder mo4708b(Lazy<? extends Activity> lazy);
    }

    void mo4709a(OnboardingListingScreen onboardingListingScreen);
}
