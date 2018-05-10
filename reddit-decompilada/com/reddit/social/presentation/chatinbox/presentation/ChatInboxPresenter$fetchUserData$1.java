package com.reddit.social.presentation.chatinbox.presentation;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a¾\u0001\u0012X\u0012V\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t \n**\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t\u0018\u00010\u00020\u0002 \n*^\u0012X\u0012V\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t \n**\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u001a\u0010\u000b\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\tH\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "Lcom/sendbird/android/GroupChannel;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "kotlin.jvm.PlatformType", "usersData", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatInboxPresenter.kt */
final class ChatInboxPresenter$fetchUserData$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ List f29598a;

    ChatInboxPresenter$fetchUserData$1(List list) {
        this.f29598a = list;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Map map = (Map) obj;
        Intrinsics.m26847b(map, "usersData");
        return Observable.just(new Pair(this.f29598a, map));
    }
}
