package com.reddit.frontpage.di.component;

import com.reddit.frontpage.presentation.detail.EditContract.LinkParameters;
import com.reddit.frontpage.presentation.detail.EditContract.View;
import com.reddit.frontpage.presentation.detail.LinkEditFragment;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/component/LinkEditComponent;", "", "inject", "", "fragment", "Lcom/reddit/frontpage/presentation/detail/LinkEditFragment;", "Builder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkEditComponent.kt */
public interface LinkEditComponent {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\nH'¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/di/component/LinkEditComponent$Builder;", "", "build", "Lcom/reddit/frontpage/di/component/LinkEditComponent;", "params", "Lcom/reddit/frontpage/presentation/detail/EditContract$LinkParameters;", "userComponent", "component", "Lcom/reddit/frontpage/di/component/UserComponent;", "view", "Lcom/reddit/frontpage/presentation/detail/EditContract$View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkEditComponent.kt */
    public interface Builder {
        Builder mo4672a(UserComponent userComponent);

        Builder mo4673a(LinkParameters linkParameters);

        Builder mo4674a(View view);

        LinkEditComponent mo4675a();
    }

    void mo4676a(LinkEditFragment linkEditFragment);
}
