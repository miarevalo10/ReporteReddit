package com.reddit.social.presentation.groupchat.view;

import android.widget.Toast;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsScreen.kt */
final class MessagingSettingsScreen$showUserReportDialog$3<T> implements Consumer<Throwable> {
    final /* synthetic */ MessagingSettingsScreen f29875a;

    MessagingSettingsScreen$showUserReportDialog$3(MessagingSettingsScreen messagingSettingsScreen) {
        this.f29875a = messagingSettingsScreen;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (Throwable) obj;
        StringBuilder stringBuilder = new StringBuilder("Report user error: ");
        Intrinsics.m26843a(obj, "error");
        stringBuilder.append(obj.getLocalizedMessage());
        Timber.e(stringBuilder.toString(), new Object[0]);
        Toast.makeText(this.f29875a.am_(), "Whoops. Something went wrong and the user could not be reported.", 1).show();
    }
}
