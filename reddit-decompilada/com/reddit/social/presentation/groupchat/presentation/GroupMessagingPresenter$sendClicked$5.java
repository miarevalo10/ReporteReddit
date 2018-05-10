package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.frontpage.util.Util;
import com.sendbird.android.UserMessage;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$sendClicked$5<T> implements Consumer<Throwable> {
    final /* synthetic */ GroupMessagingPresenter f29781a;
    final /* synthetic */ BehaviorSubject f29782b;
    final /* synthetic */ String f29783c;

    GroupMessagingPresenter$sendClicked$5(GroupMessagingPresenter groupMessagingPresenter, BehaviorSubject behaviorSubject, String str) {
        this.f29781a = groupMessagingPresenter;
        this.f29782b = behaviorSubject;
        this.f29783c = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        Throwable th = (Throwable) obj;
        GroupMessagingPresenter groupMessagingPresenter = this.f29781a;
        Object obj2 = this.f29782b;
        Intrinsics.m26843a(obj2, "tempMessage");
        GroupMessagingPresenter.m30779a(groupMessagingPresenter, (UserMessage) obj2.m38179b());
        if ((StringsKt__StringsJVMKt.m41943a((CharSequence) GroupMessagingPresenter.m30774a(this.f29781a).mo7561c()) ^ 1) != 0) {
            GroupMessagingPresenter.m30774a(this.f29781a).mo7568g();
        }
        Timber.c(th, "Failed to send message", new Object[0]);
        if (this.f29781a.m30793k() != null) {
            String str = null;
            if (this.f29781a.f29814t != null) {
                str = String.valueOf(Util.m23952a(this.f29781a.f29814t));
            }
            this.f29781a.m30819h().m24475b(this.f29783c, Kind.POST, this.f29781a.f29813s, str, this.f29781a.f29812r);
            return;
        }
        this.f29781a.m30819h().m24475b(this.f29783c, "text", null, null, null);
    }
}
