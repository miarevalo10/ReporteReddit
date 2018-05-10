package com.reddit.social.domain.usecases;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.frontpage.FrontpageApplication;
import javax.inject.Inject;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\t\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u000bj\u0002`\u000f0\n2\u0006\u0010\u0010\u001a\u00020\fH\u0007R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/reddit/social/domain/usecases/LoadInviteUseCase;", "", "()V", "chatDataRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "getChatDataRepository", "()Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "setChatDataRepository", "(Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;)V", "load", "Lio/reactivex/Observable;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "channelUrl", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LoadInviteUseCase.kt */
public final class LoadInviteUseCase {
    @Inject
    public ChatDataRepositoryContract f22307a;

    public LoadInviteUseCase() {
        FrontpageApplication.m28878n().mo5083a(this);
    }
}
