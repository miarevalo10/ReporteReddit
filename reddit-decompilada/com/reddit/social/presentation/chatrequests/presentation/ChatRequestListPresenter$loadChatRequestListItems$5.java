package com.reddit.social.presentation.chatrequests.presentation;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import com.reddit.social.presentation.chatrequests.ChatRequestListContract.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestListPresenter.kt */
final class ChatRequestListPresenter$loadChatRequestListItems$5<T> implements Consumer<Throwable> {
    final /* synthetic */ ChatRequestListPresenter f29639a;

    ChatRequestListPresenter$loadChatRequestListItems$5(ChatRequestListPresenter chatRequestListPresenter) {
        this.f29639a = chatRequestListPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Throwable th = (Throwable) obj;
        ChatRequestListPresenter.m30661a(this.f29639a).mo7502a(null);
        View a = ChatRequestListPresenter.m30661a(this.f29639a);
        String f = Util.m24027f((int) C1761R.string.chat_error_load_requests);
        Intrinsics.m26843a((Object) f, "Util.getString(R.string.chat_error_load_requests)");
        a.mo7501a(f);
        Timber.e(th.getMessage(), new Object[0]);
    }
}
