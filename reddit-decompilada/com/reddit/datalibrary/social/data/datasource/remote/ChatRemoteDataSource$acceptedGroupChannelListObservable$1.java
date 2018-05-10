package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.GroupChannel;
import com.sendbird.android.GroupChannel.MemberState;
import com.sendbird.android.GroupChannelListQuery;
import io.reactivex.ObservableEmitter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "e", "Lio/reactivex/ObservableEmitter;", "", "Lcom/sendbird/android/GroupChannel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$acceptedGroupChannelListObservable$1 extends Lambda implements Function1<ObservableEmitter<List<? extends GroupChannel>>, Unit> {
    final /* synthetic */ ChatRemoteDataSource f36261a;
    final /* synthetic */ boolean f36262b;
    final /* synthetic */ String f36263c;

    ChatRemoteDataSource$acceptedGroupChannelListObservable$1(ChatRemoteDataSource chatRemoteDataSource, boolean z, String str) {
        this.f36261a = chatRemoteDataSource;
        this.f36262b = z;
        this.f36263c = str;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        boolean z;
        GroupChannelListQuery d;
        ObservableEmitter observableEmitter = (ObservableEmitter) obj;
        Intrinsics.m26847b(observableEmitter, "e");
        if (this.f36261a.f33469i != null && this.f36261a.f33473m.isEmpty() == null && this.f36262b == null && this.f36261a.f33479s != null) {
            if (StringsKt__StringsJVMKt.m41946a((String) this.f36261a.f33479s, this.f36263c, true) != null) {
                z = null;
                d = this.f36261a.f33469i;
                if (d != null) {
                    ChatRemoteDataSource.m34293a(this.f36261a, observableEmitter, d, this.f36261a.f33473m, z, MemberState.JOINED);
                }
                return Unit.f25273a;
            }
        }
        ChatRemoteDataSource chatRemoteDataSource = this.f36261a;
        d = GroupChannel.m30964i();
        d.m24925a(this.f36261a.f33465e);
        d.m24924a();
        d.m24926a(MemberState.JOINED);
        chatRemoteDataSource.f33469i = d;
        this.f36261a.f33479s = this.f36263c;
        z = true;
        d = this.f36261a.f33469i;
        if (d != null) {
            ChatRemoteDataSource.m34293a(this.f36261a, observableEmitter, d, this.f36261a.f33473m, z, MemberState.JOINED);
        }
        return Unit.f25273a;
    }
}
