package com.reddit.social.util;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.social.data.session.ChatConnectionManager;
import com.reddit.datalibrary.social.data.session.ChatConnectionManager.Companion;
import com.reddit.datalibrary.social.model.ChatEnabled;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "chatEnabled", "Lcom/reddit/datalibrary/social/model/ChatEnabled;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatUtil.kt */
final class ChatUtilKt$checkUserOptedIntoChat$1 extends Lambda implements Function1<ChatEnabled, Unit> {
    final /* synthetic */ boolean f37594a = false;

    ChatUtilKt$checkUserOptedIntoChat$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ChatEnabled chatEnabled = (ChatEnabled) obj;
        Object a = FrontpageSettings.a();
        Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
        a.f(chatEnabled.getEnabled());
        if (this.f37594a && chatEnabled.getEnabled() != null) {
            obj = ChatConnectionManager.f19854b;
            Companion.m21751a(this.f37594a);
        }
        return Unit.f25273a;
    }
}
