package com.reddit.frontpage.ui.inbox;

import android.content.DialogInterface;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

final /* synthetic */ class InboxListingScreen$InboxAdapter$$Lambda$3 implements Function1 {
    private final InboxAdapter f34292a;
    private final String f34293b;

    InboxListingScreen$InboxAdapter$$Lambda$3(InboxAdapter inboxAdapter, String str) {
        this.f34292a = inboxAdapter;
        this.f34293b = str;
    }

    public final Object mo6492a(Object obj) {
        InboxAdapter inboxAdapter = this.f34292a;
        String str = this.f34293b;
        ((DialogInterface) obj).dismiss();
        obj = RedditAlertDialog.m23315a(inboxAdapter.f28995a.am_(), str, new InboxListingScreen$InboxAdapter$$Lambda$4(inboxAdapter, str));
        obj.f21113a.b(C1761R.string.option_no, null);
        obj.m23323a();
        return Unit.f25273a;
    }
}
