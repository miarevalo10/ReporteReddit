package com.reddit.social.domain.usecases;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.social.util.ChatUtilKt;
import com.sendbird.android.GroupChannel;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002j\u0002`\u00060\u00012\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "it", "Lcom/sendbird/android/GroupChannel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: LoadInviteUseCase.kt */
final class LoadInviteUseCase$load$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ LoadInviteUseCase f29590a;

    public LoadInviteUseCase$load$1(LoadInviteUseCase loadInviteUseCase) {
        this.f29590a = loadInviteUseCase;
    }

    public final /* synthetic */ Object apply(Object obj) {
        GroupChannel groupChannel = (GroupChannel) obj;
        Intrinsics.m26847b(groupChannel, "it");
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29590a.f22307a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        return chatDataRepositoryContract.mo4515a(ChatUtilKt.m24752a(groupChannel));
    }
}
