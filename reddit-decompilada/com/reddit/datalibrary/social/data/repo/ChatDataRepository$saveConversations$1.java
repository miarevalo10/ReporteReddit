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
final class ChatDataRepository$saveConversations$1 extends Lambda implements Function1<List<? extends GroupChannel>, Unit> {
    final /* synthetic */ ChatDataRepository f36319a;
    final /* synthetic */ String f36320b;

    ChatDataRepository$saveConversations$1(ChatDataRepository chatDataRepository, String str) {
        this.f36319a = chatDataRepository;
        this.f36320b = str;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        List list = (List) obj;
        Intrinsics.m26847b(list, "groupChannels");
        ChatDiscDataSource a = this.f36319a.m28781a();
        String str = this.f36320b;
        Intrinsics.m26847b(str, "userId");
        Intrinsics.m26847b(list, "groupChannels");
        HandlerThread handlerThread = new HandlerThread("SaveGroupChannelsHandler");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new ChatDiscDataSource$saveAcceptedGroupChannels$1(a, str, list));
        return Unit.f25273a;
    }
}
