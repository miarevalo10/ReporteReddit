package com.reddit.datalibrary.social.data.datasource.local;

import com.sendbird.android.GroupChannel;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/sendbird/android/GroupChannel;", "test"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDiscDataSource.kt */
final class ChatDiscDataSource$getGroupChannel$2<T> implements Predicate<GroupChannel> {
    final /* synthetic */ String f27257a;

    ChatDiscDataSource$getGroupChannel$2(String str) {
        this.f27257a = str;
    }

    public final /* synthetic */ boolean test(Object obj) {
        GroupChannel groupChannel = (GroupChannel) obj;
        Intrinsics.m26847b(groupChannel, "it");
        return Intrinsics.m26845a(groupChannel.m24870d(), this.f27257a);
    }
}
