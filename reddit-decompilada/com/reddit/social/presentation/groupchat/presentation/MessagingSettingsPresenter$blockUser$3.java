package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import com.reddit.social.presentation.groupchat.ChatSettingsContract.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsPresenter.kt */
final class MessagingSettingsPresenter$blockUser$3<T> implements Consumer<Throwable> {
    final /* synthetic */ MessagingSettingsPresenter f29826a;

    MessagingSettingsPresenter$blockUser$3(MessagingSettingsPresenter messagingSettingsPresenter) {
        this.f29826a = messagingSettingsPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Throwable th = (Throwable) obj;
        View b = MessagingSettingsPresenter.m30830b(this.f29826a);
        String f = Util.m24027f((int) C1761R.string.chat_error_user_block);
        Intrinsics.m26843a((Object) f, "Util.getString(R.string.chat_error_user_block)");
        b.mo7573a(f);
        StringBuilder stringBuilder = new StringBuilder("Blocking sendbird user error: ");
        stringBuilder.append(th);
        Timber.e(stringBuilder.toString(), new Object[0]);
    }
}
