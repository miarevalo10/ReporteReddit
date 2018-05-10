package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.GroupChannel;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Lcom/sendbird/android/Member;", "kotlin.jvm.PlatformType", "", "it", "Lcom/sendbird/android/GroupChannel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$typingStatusObservable$2<T, R> implements Function<T, R> {
    public static final ChatRemoteDataSource$typingStatusObservable$2 f27338a = new ChatRemoteDataSource$typingStatusObservable$2();

    ChatRemoteDataSource$typingStatusObservable$2() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        GroupChannel groupChannel = (GroupChannel) obj;
        Intrinsics.m26847b(groupChannel, "it");
        return groupChannel.m30991u();
    }
}
