package com.reddit.frontpage.ui.inbox;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionAction;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionsDialog;
import java.util.ArrayList;
import java.util.List;

final /* synthetic */ class InboxListingScreen$InboxAdapter$$Lambda$0 implements OnClickListener {
    private final InboxAdapter f21237a;
    private final Context f21238b;
    private final String f21239c;
    private final MessageThread f21240d;

    InboxListingScreen$InboxAdapter$$Lambda$0(InboxAdapter inboxAdapter, Context context, String str, MessageThread messageThread) {
        this.f21237a = inboxAdapter;
        this.f21238b = context;
        this.f21239c = str;
        this.f21240d = messageThread;
    }

    public final void onClick(View view) {
        view = this.f21237a;
        Context context = this.f21238b;
        String str = this.f21239c;
        MessageThread messageThread = this.f21240d;
        List arrayList = new ArrayList();
        arrayList.add(new ListOptionAction(view.f28995a.am_().getString(C1761R.string.action_report), Integer.valueOf(C1761R.drawable.ic_icon_report), new InboxListingScreen$InboxAdapter$$Lambda$2(context, str, messageThread)));
        arrayList.add(new ListOptionAction(view.f28995a.am_().getString(C1761R.string.action_block), Integer.valueOf(C1761R.drawable.ic_icon_ban_new), new InboxListingScreen$InboxAdapter$$Lambda$3(view, str)));
        new ListOptionsDialog(view.f28995a.am_(), arrayList, (byte) 0).show();
    }
}
