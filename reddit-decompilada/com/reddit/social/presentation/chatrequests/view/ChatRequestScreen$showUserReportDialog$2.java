package com.reddit.social.presentation.chatrequests.view;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestScreen.kt */
final class ChatRequestScreen$showUserReportDialog$2<T> implements Consumer<Object> {
    final /* synthetic */ ChatRequestScreen f29682a;

    ChatRequestScreen$showUserReportDialog$2(ChatRequestScreen chatRequestScreen) {
        this.f29682a = chatRequestScreen;
    }

    public final void accept(Object obj) {
        obj = this.f29682a;
        String f = Util.m24027f((int) C1761R.string.chat_success_user_report);
        Intrinsics.m26843a((Object) f, "Util.getString(R.string.chat_success_user_report)");
        obj.mo7241c(f);
    }
}
