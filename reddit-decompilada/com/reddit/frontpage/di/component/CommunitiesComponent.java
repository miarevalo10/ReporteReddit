package com.reddit.frontpage.di.component;

import android.content.Context;
import com.reddit.frontpage.presentation.communities.CommunitiesContract.View;
import com.reddit.frontpage.presentation.communities.CommunitiesNavigator;
import com.reddit.frontpage.presentation.communities.CommunitiesScreen;
import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/component/CommunitiesComponent;", "", "inject", "", "screen", "Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;", "Builder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitiesComponent.kt */
public interface CommunitiesComponent {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH'J\u0012\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\nH'J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH'¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/di/component/CommunitiesComponent$Builder;", "", "build", "Lcom/reddit/frontpage/di/component/CommunitiesComponent;", "context", "Lkotlin/Lazy;", "Landroid/content/Context;", "navigator", "Lcom/reddit/frontpage/presentation/communities/CommunitiesNavigator;", "sourcePage", "", "userComponent", "component", "Lcom/reddit/frontpage/di/component/UserComponent;", "view", "Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesComponent.kt */
    public interface Builder {
        Builder mo4640a(UserComponent userComponent);

        Builder mo4641a(View view);

        Builder mo4642a(CommunitiesNavigator communitiesNavigator);

        Builder mo4643a(String str);

        Builder mo4644a(Lazy<? extends Context> lazy);

        CommunitiesComponent mo4645a();
    }

    void mo4646a(CommunitiesScreen communitiesScreen);
}
