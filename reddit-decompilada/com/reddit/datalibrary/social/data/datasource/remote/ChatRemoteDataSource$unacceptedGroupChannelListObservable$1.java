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
final class ChatRemoteDataSource$unacceptedGroupChannelListObservable$1 extends Lambda implements Function1<ObservableEmitter<List<? extends GroupChannel>>, Unit> {
    final /* synthetic */ ChatRemoteDataSource f36308a;
    final /* synthetic */ boolean f36309b;
    final /* synthetic */ String f36310c;

    ChatRemoteDataSource$unacceptedGroupChannelListObservable$1(ChatRemoteDataSource chatRemoteDataSource, boolean z, String str) {
        this.f36308a = chatRemoteDataSource;
        this.f36309b = z;
        this.f36310c = str;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        boolean z;
        GroupChannelListQuery g;
        ObservableEmitter observableEmitter = (ObservableEmitter) obj;
        Intrinsics.m26847b(observableEmitter, "e");
        if (this.f36308a.f33470j != null && this.f36308a.f33474n.isEmpty() == null && this.f36309b == null && this.f36308a.f33480t != null) {
            if (StringsKt__StringsJVMKt.m41946a((String) this.f36308a.f33480t, this.f36310c, true) != null) {
                z = null;
                g = this.f36308a.f33470j;
                if (g != null) {
                    ChatRemoteDataSource.m34293a(this.f36308a, observableEmitter, g, this.f36308a.f33474n, z, MemberState.INVITED);
                }
                return Unit.f25273a;
            }
        }
        ChatRemoteDataSource chatRemoteDataSource = this.f36308a;
        g = GroupChannel.m30964i();
        g.m24925a(this.f36308a.f33465e);
        g.m24924a();
        g.m24926a(MemberState.INVITED);
        chatRemoteDataSource.f33470j = g;
        this.f36308a.f33480t = this.f36310c;
        z = true;
        g = this.f36308a.f33470j;
        if (g != null) {
            ChatRemoteDataSource.m34293a(this.f36308a, observableEmitter, g, this.f36308a.f33474n, z, MemberState.INVITED);
        }
        return Unit.f25273a;
    }
}
