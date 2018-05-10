package com.reddit.social.presentation.groupchat.presentation;

import com.sendbird.android.BaseMessage;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u001a\u0010\u0004\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/sendbird/android/BaseMessage;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "it", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$fetchUsersData$1<T, R> implements Function<T, R> {
    final /* synthetic */ BaseMessage f29756a;
    final /* synthetic */ String f29757b;

    GroupMessagingPresenter$fetchUsersData$1(BaseMessage baseMessage, String str) {
        this.f29756a = baseMessage;
        this.f29757b = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Map map = (Map) obj;
        Intrinsics.m26847b(map, "it");
        return TuplesKt.m26780a(this.f29756a, map.get(this.f29757b));
    }
}
