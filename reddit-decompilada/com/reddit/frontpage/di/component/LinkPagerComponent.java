package com.reddit.frontpage.di.component;

import android.app.Activity;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.Parameters;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.View;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerScreen;
import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/component/LinkPagerComponent;", "", "inject", "", "screen", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerScreen;", "Builder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkPagerComponent.kt */
public interface LinkPagerComponent {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/di/component/LinkPagerComponent$Builder;", "", "activity", "Lkotlin/Lazy;", "Landroid/app/Activity;", "build", "Lcom/reddit/frontpage/di/component/LinkPagerComponent;", "params", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$Parameters;", "userComponent", "component", "Lcom/reddit/frontpage/di/component/UserComponent;", "view", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkPagerComponent.kt */
    public interface Builder {
        Builder mo4678a(UserComponent userComponent);

        Builder mo4679a(Parameters parameters);

        Builder mo4680a(View view);

        Builder mo4681a(Lazy<? extends Activity> lazy);

        LinkPagerComponent mo4682a();
    }

    void mo4683a(LinkPagerScreen linkPagerScreen);
}
