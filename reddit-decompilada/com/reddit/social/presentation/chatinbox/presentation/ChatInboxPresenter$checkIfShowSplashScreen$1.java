package com.reddit.social.presentation.chatinbox.presentation;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.social.model.ChatEnabled;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "chatEnabled", "Lcom/reddit/datalibrary/social/model/ChatEnabled;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatInboxPresenter.kt */
final class ChatInboxPresenter$checkIfShowSplashScreen$1 extends Lambda implements Function1<ChatEnabled, Unit> {
    final /* synthetic */ ChatInboxPresenter f37505a;

    ChatInboxPresenter$checkIfShowSplashScreen$1(ChatInboxPresenter chatInboxPresenter) {
        this.f37505a = chatInboxPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ChatEnabled chatEnabled = (ChatEnabled) obj;
        Object a = FrontpageSettings.a();
        Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
        a.f(chatEnabled.getEnabled());
        if (chatEnabled.getEnabled() != null) {
            this.f37505a.m30632h();
        } else {
            this.f37505a.m30640e().m24471a("view", "opt_in");
            ChatInboxPresenter.m30626a(this.f37505a).mo7498e();
        }
        return Unit.f25273a;
    }
}
