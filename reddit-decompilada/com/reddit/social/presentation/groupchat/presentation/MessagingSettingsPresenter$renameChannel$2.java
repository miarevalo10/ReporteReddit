package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsPresenter.kt */
final class MessagingSettingsPresenter$renameChannel$2<T> implements Consumer<Throwable> {
    final /* synthetic */ MessagingSettingsPresenter f29834a;

    MessagingSettingsPresenter$renameChannel$2(MessagingSettingsPresenter messagingSettingsPresenter) {
        this.f29834a = messagingSettingsPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Timber.e(((Throwable) obj).getMessage(), new Object[0]);
        MessagingSettingsPresenter.m30830b(this.f29834a).mo7589h();
        obj = MessagingSettingsPresenter.m30830b(this.f29834a);
        String f = Util.m24027f((int) C1761R.string.chat_error_rename_channel);
        Intrinsics.m26843a((Object) f, "Util.getString(R.string.chat_error_rename_channel)");
        obj.mo7573a(f);
    }
}
