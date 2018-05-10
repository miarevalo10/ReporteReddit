package com.reddit.datalibrary.social.data.datasource.local;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/sendbird/android/GroupChannel;", "kotlin.jvm.PlatformType", "it", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDiscDataSource.kt */
final class ChatDiscDataSource$getGroupChannel$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    public static final ChatDiscDataSource$getGroupChannel$1 f27256a = new ChatDiscDataSource$getGroupChannel$1();

    ChatDiscDataSource$getGroupChannel$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.m26847b(list, "it");
        return Observable.fromIterable(list);
    }
}
