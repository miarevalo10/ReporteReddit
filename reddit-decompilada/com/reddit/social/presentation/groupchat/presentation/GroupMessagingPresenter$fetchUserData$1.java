package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.sendbird.android.BaseMessage;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a.\u0012\u0004\u0012\u00020\u0002\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\b0\u00010\u00012\u001a\u0010\t\u001a\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\bH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "Lcom/sendbird/android/BaseMessage;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$fetchUserData$1<T, R> implements Function<T, R> {
    final /* synthetic */ SentStatus f29754a;
    final /* synthetic */ BaseMessage f29755b;

    GroupMessagingPresenter$fetchUserData$1(SentStatus sentStatus, BaseMessage baseMessage) {
        this.f29754a = sentStatus;
        this.f29755b = baseMessage;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Map map = (Map) obj;
        Intrinsics.m26847b(map, "it");
        return TuplesKt.m26780a(this.f29754a, TuplesKt.m26780a(this.f29755b, map));
    }
}
