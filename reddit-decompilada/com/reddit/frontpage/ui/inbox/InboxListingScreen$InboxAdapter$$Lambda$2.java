package com.reddit.frontpage.ui.inbox;

import android.content.Context;
import android.content.DialogInterface;
import kotlin.jvm.functions.Function1;

final /* synthetic */ class InboxListingScreen$InboxAdapter$$Lambda$2 implements Function1 {
    private final Context f34289a;
    private final String f34290b;
    private final MessageThread f34291c;

    InboxListingScreen$InboxAdapter$$Lambda$2(Context context, String str, MessageThread messageThread) {
        this.f34289a = context;
        this.f34290b = str;
        this.f34291c = messageThread;
    }

    public final Object mo6492a(Object obj) {
        return InboxAdapter.m30049a(this.f34289a, this.f34290b, this.f34291c, (DialogInterface) obj);
    }
}
