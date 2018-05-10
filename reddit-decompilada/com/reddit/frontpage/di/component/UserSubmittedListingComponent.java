package com.reddit.frontpage.di.component;

import android.content.Context;
import com.reddit.frontpage.presentation.listing.submitted.UserSubmittedListingContract.View;
import com.reddit.frontpage.presentation.listing.submitted.UserSubmittedListingScreen;
import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/component/UserSubmittedListingComponent;", "", "inject", "", "screen", "Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingScreen;", "Builder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingComponent.kt */
public interface UserSubmittedListingComponent {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\u0012\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/di/component/UserSubmittedListingComponent$Builder;", "", "build", "Lcom/reddit/frontpage/di/component/UserSubmittedListingComponent;", "context", "Lkotlin/Lazy;", "Landroid/content/Context;", "sourcePage", "", "userComponent", "component", "Lcom/reddit/frontpage/di/component/UserComponent;", "view", "Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingContract$View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserSubmittedListingComponent.kt */
    public interface Builder {
        Builder mo4748a(UserComponent userComponent);

        Builder mo4749a(View view);

        Builder mo4750a(String str);

        Builder mo4751a(Lazy<? extends Context> lazy);

        UserSubmittedListingComponent mo4752a();
    }

    void mo4753a(UserSubmittedListingScreen userSubmittedListingScreen);
}
