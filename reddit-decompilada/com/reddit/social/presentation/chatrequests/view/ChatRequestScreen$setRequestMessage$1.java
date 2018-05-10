package com.reddit.social.presentation.chatrequests.view;

import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.LinkEmbedState;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestScreen.kt */
final class ChatRequestScreen$setRequestMessage$1<T> implements Consumer<Pair<? extends Long, ? extends LinkEmbedState>> {
    final /* synthetic */ ChatRequestScreen f29677a;
    final /* synthetic */ HasMessageData f29678b;

    ChatRequestScreen$setRequestMessage$1(ChatRequestScreen chatRequestScreen, HasMessageData hasMessageData) {
        this.f29677a = chatRequestScreen;
        this.f29678b = hasMessageData;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = this.f29677a.chatRequestMessage;
        if (obj == null) {
            Intrinsics.m26844a("chatRequestMessage");
        }
        obj.removeAllViews();
        this.f29677a.m41203a(this.f29678b, null);
    }
}
