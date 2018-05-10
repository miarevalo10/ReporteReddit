package com.reddit.datalibrary.social.data.repo;

import android.os.Handler;
import android.os.HandlerThread;
import com.reddit.datalibrary.social.data.datasource.local.ChatDiscDataSource;
import com.sendbird.android.GroupChannel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "groupChannels", "", "Lcom/sendbird/android/GroupChannel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDataRepository.kt */
final class ChatDataRepository$saveConversations$2 extends Lambda implements Function1<List<? extends GroupChannel>, Unit> {
    final /* synthetic */ ChatDataRepository f36321a;
    final /* synthetic */ String f36322b;

    ChatDataRepository$saveConversations$2(ChatDataRepository chatDataRepository, String str) {
        this.f36321a = chatDataRepository;
        this.f36322b = str;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        List list = (List) obj;
        Intrinsics.m26847b(list, "groupChannels");
        ChatDiscDataSource a = this.f36321a.m28781a();
        String str = this.f36322b;
        Intrinsics.m26847b(str, "userId");
        Intrinsics.m26847b(list, "groupChannels");
        HandlerThread handlerThread = new HandlerThread("SaveGroupChannelsHandler");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new ChatDiscDataSource$saveUnacceptedGroupChannels$1(a, str, list));
        return Unit.f25273a;
    }
}
