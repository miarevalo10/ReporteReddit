package com.reddit.datalibrary.social.data.datasource.local;

import com.reddit.social.util.ChatSerializer;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDiscDataSource.kt */
final class ChatDiscDataSource$saveUnacceptedGroupChannels$1 implements Runnable {
    final /* synthetic */ ChatDiscDataSource f19846a;
    final /* synthetic */ String f19847b;
    final /* synthetic */ List f19848c;

    public ChatDiscDataSource$saveUnacceptedGroupChannels$1(ChatDiscDataSource chatDiscDataSource, String str, List list) {
        this.f19846a = chatDiscDataSource;
        this.f19847b = str;
        this.f19848c = list;
    }

    public final void run() {
        ChatSerializer.m24740a(this.f19847b, this.f19848c, this.f19846a.f33459b);
    }
}
