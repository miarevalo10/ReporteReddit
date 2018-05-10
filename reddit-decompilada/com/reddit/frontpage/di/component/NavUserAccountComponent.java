package com.reddit.frontpage.di.component;

import com.reddit.frontpage.presentation.navdrawer.RedditNavHeaderContract.View;
import com.reddit.frontpage.presentation.navdrawer.RedditNavHeaderPresenter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/di/component/NavUserAccountComponent;", "", "navHeaderPresenter", "Lcom/reddit/frontpage/presentation/navdrawer/RedditNavHeaderPresenter;", "Builder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: NavUserAccountComponent.kt */
public interface NavUserAccountComponent {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/di/component/NavUserAccountComponent$Builder;", "", "build", "Lcom/reddit/frontpage/di/component/NavUserAccountComponent;", "userComponent", "component", "Lcom/reddit/frontpage/di/component/UserComponent;", "view", "Lcom/reddit/frontpage/presentation/navdrawer/RedditNavHeaderContract$View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: NavUserAccountComponent.kt */
    public interface Builder {
        Builder mo4690a(UserComponent userComponent);

        Builder mo4691a(View view);

        NavUserAccountComponent mo4692a();
    }

    RedditNavHeaderPresenter mo4693b();
}
