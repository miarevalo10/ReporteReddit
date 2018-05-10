package com.reddit.frontpage.di.component;

import android.content.Context;
import com.reddit.frontpage.presentation.postoption.PostOptionsContract.Parameters;
import com.reddit.frontpage.presentation.postoption.PostOptionsContract.View;
import com.reddit.frontpage.presentation.postoption.PostOptionsScreen;
import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/component/PostOptionsComponent;", "", "inject", "", "view", "Lcom/reddit/frontpage/presentation/postoption/PostOptionsScreen;", "Builder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PostOptionsComponent.kt */
public interface PostOptionsComponent {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/di/component/PostOptionsComponent$Builder;", "", "build", "Lcom/reddit/frontpage/di/component/PostOptionsComponent;", "context", "Lkotlin/Lazy;", "Landroid/content/Context;", "params", "Lcom/reddit/frontpage/presentation/postoption/PostOptionsContract$Parameters;", "userComponent", "component", "Lcom/reddit/frontpage/di/component/UserComponent;", "view", "Lcom/reddit/frontpage/presentation/postoption/PostOptionsContract$View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: PostOptionsComponent.kt */
    public interface Builder {
        Builder mo4719a(UserComponent userComponent);

        Builder mo4720a(Parameters parameters);

        Builder mo4721a(View view);

        Builder mo4722a(Lazy<? extends Context> lazy);

        PostOptionsComponent mo4723a();
    }

    void mo4724a(PostOptionsScreen postOptionsScreen);
}
