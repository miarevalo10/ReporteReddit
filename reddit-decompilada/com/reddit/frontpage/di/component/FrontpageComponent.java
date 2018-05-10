package com.reddit.frontpage.di.component;

import android.app.Activity;
import android.content.Context;
import com.reddit.frontpage.presentation.listing.FrontpageListingScreen;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingContract.Parameters;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingContract.View;
import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/component/FrontpageComponent;", "", "inject", "", "screen", "Lcom/reddit/frontpage/presentation/listing/FrontpageListingScreen;", "Builder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FrontpageComponent.kt */
public interface FrontpageComponent {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H'J\b\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\u0003\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H'J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH'J\u0012\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H'¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/di/component/FrontpageComponent$Builder;", "", "activity", "context", "Lkotlin/Lazy;", "Landroid/app/Activity;", "build", "Lcom/reddit/frontpage/di/component/FrontpageComponent;", "Landroid/content/Context;", "params", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingContract$Parameters;", "sourcePage", "", "userComponent", "component", "Lcom/reddit/frontpage/di/component/UserComponent;", "view", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingContract$View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: FrontpageComponent.kt */
    public interface Builder {
        Builder mo4653a(UserComponent userComponent);

        Builder mo4654a(Parameters parameters);

        Builder mo4655a(View view);

        Builder mo4656a(String str);

        Builder mo4657a(Lazy<? extends Activity> lazy);

        FrontpageComponent mo4658a();

        Builder mo4659b(Lazy<? extends Context> lazy);
    }

    void mo4660a(FrontpageListingScreen frontpageListingScreen);
}
