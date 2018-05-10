package com.reddit.social.presentation.groupchat.view;

import com.reddit.datalibrary.frontpage.data.common.busevents.MessageEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.MessageEvent.Companion;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import de.greenrobot.event.EventBus;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsScreen.kt */
final class MessagingSettingsScreen$showUserReportDialog$2<T> implements Consumer<Object> {
    public static final MessagingSettingsScreen$showUserReportDialog$2 f29874a = new MessagingSettingsScreen$showUserReportDialog$2();

    MessagingSettingsScreen$showUserReportDialog$2() {
    }

    public final void accept(Object obj) {
        obj = EventBus.getDefault();
        Companion companion = MessageEvent.c;
        Object f = Util.m24027f((int) C1761R.string.chat_success_user_report);
        Intrinsics.m26843a(f, "Util.getString(R.string.chat_success_user_report)");
        obj.post(Companion.a(f));
    }
}
