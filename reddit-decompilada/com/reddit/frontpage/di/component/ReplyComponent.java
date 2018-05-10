package com.reddit.frontpage.di.component;

import com.reddit.frontpage.presentation.detail.LinkReplyFragment;
import com.reddit.frontpage.presentation.detail.ReplyContract.Parameters;
import com.reddit.frontpage.presentation.detail.ReplyContract.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/component/ReplyComponent;", "", "inject", "", "fragment", "Lcom/reddit/frontpage/presentation/detail/LinkReplyFragment;", "Builder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ReplyComponent.kt */
public interface ReplyComponent {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\nH'¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/di/component/ReplyComponent$Builder;", "", "build", "Lcom/reddit/frontpage/di/component/ReplyComponent;", "params", "Lcom/reddit/frontpage/presentation/detail/ReplyContract$Parameters;", "userComponent", "component", "Lcom/reddit/frontpage/di/component/UserComponent;", "view", "Lcom/reddit/frontpage/presentation/detail/ReplyContract$View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ReplyComponent.kt */
    public interface Builder {
        Builder mo4731a(UserComponent userComponent);

        Builder mo4732a(Parameters parameters);

        Builder mo4733a(View view);

        ReplyComponent mo4734a();
    }

    void mo4735a(LinkReplyFragment linkReplyFragment);
}
