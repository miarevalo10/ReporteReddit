package com.reddit.datalibrary.social.data.datasource.local;

import com.reddit.social.util.ChatSerializer;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDiscDataSource.kt */
final class ChatDiscDataSource$saveMessages$1 implements Runnable {
    final /* synthetic */ String f19843a;
    final /* synthetic */ String f19844b;
    final /* synthetic */ List f19845c;

    ChatDiscDataSource$saveMessages$1(String str, String str2, List list) {
        this.f19843a = str;
        this.f19844b = str2;
        this.f19845c = list;
    }

    public final void run() {
        ChatSerializer.m24739a(this.f19843a, this.f19844b, this.f19845c);
    }
}
