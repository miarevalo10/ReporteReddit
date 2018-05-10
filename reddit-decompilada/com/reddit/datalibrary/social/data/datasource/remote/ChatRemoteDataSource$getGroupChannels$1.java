package com.reddit.datalibrary.social.data.datasource.remote;

import com.reddit.social.analytics.ChatPerformanceAnalyticsContract;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.GroupChannel.MemberState;
import com.sendbird.android.GroupChannelListQuery.GroupChannelListQueryResultHandler;
import com.sendbird.android.SendBirdException;
import io.reactivex.ObservableEmitter;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u00032\u000e\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "list", "", "Lcom/sendbird/android/GroupChannel;", "kotlin.jvm.PlatformType", "", "e", "Lcom/sendbird/android/SendBirdException;", "onResult"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$getGroupChannels$1 implements GroupChannelListQueryResultHandler {
    final /* synthetic */ ChatRemoteDataSource f27279a;
    final /* synthetic */ MemberState f27280b;
    final /* synthetic */ UUID f27281c;
    final /* synthetic */ ObservableEmitter f27282d;
    final /* synthetic */ boolean f27283e;
    final /* synthetic */ List f27284f;

    ChatRemoteDataSource$getGroupChannels$1(ChatRemoteDataSource chatRemoteDataSource, MemberState memberState, UUID uuid, ObservableEmitter observableEmitter, boolean z, List list) {
        this.f27279a = chatRemoteDataSource;
        this.f27280b = memberState;
        this.f27281c = uuid;
        this.f27282d = observableEmitter;
        this.f27283e = z;
        this.f27284f = list;
    }

    public final void mo4491a(List<GroupChannel> list, SendBirdException sendBirdException) {
        ChatPerformanceAnalyticsContract chatPerformanceAnalyticsContract = this.f27279a.f33463c;
        if (chatPerformanceAnalyticsContract == null) {
            Intrinsics.m26844a("chatPerfAnalytics");
        }
        MemberState memberState = this.f27280b;
        Object obj = this.f27281c;
        Intrinsics.m26843a(obj, "uuid");
        chatPerformanceAnalyticsContract.mo5105b(memberState, obj);
        if (ChatRemoteDataSource.m34304b(this.f27282d, sendBirdException) == null) {
            if (this.f27283e != null) {
                this.f27284f.clear();
            }
            sendBirdException = this.f27284f;
            Intrinsics.m26843a((Object) list, "list");
            sendBirdException.addAll(list);
            this.f27282d.mo5641a((Object) this.f27284f);
            this.f27282d.aA_();
        }
    }
}
