package com.reddit.social.presentation.chatinbox.presentation;

import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "chatInboxItems", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatInboxPresenter.kt */
final class ChatInboxPresenter$loadInboxScreen$4 extends Lambda implements Function1<List<? extends ChatInboxItem>, Unit> {
    final /* synthetic */ ChatInboxPresenter f37506a;

    ChatInboxPresenter$loadInboxScreen$4(ChatInboxPresenter chatInboxPresenter) {
        this.f37506a = chatInboxPresenter;
        super(1);
    }

    public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
        ChatInboxPresenter.m30626a(this.f37506a).mo7492a((List) obj, false);
        return Unit.f25273a;
    }
}
