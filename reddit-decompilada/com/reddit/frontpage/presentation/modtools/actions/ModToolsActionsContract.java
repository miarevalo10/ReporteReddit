package com.reddit.frontpage.presentation.modtools.actions;

import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.presentation.modtools.util.ModToolsAction;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModToolsActionsContract.kt */
public interface ModToolsActionsContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsContract$View;", "", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "getSubreddit", "()Lcom/reddit/frontpage/domain/model/Subreddit;", "setSubreddit", "(Lcom/reddit/frontpage/domain/model/Subreddit;)V", "onItemClicked", "", "modAction", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModToolsActionsContract.kt */
    public interface View {
        void mo7372a(ModToolsAction modToolsAction);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "onModItemClicked", "", "modAction", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface Presenter extends BasePresenter {
    }
}
