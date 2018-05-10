package com.reddit.social.presentation.messaginglist.content;

import com.reddit.social.presentation.messaginglist.MessageContentClickListener;
import com.reddit.social.presentation.presentationobjects.TextMessageData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: Text.kt */
final class TextKt$bind$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MessageContentClickListener f37590a;
    final /* synthetic */ TextMessageData f37591b;

    TextKt$bind$2(MessageContentClickListener messageContentClickListener, TextMessageData textMessageData) {
        this.f37590a = messageContentClickListener;
        this.f37591b = textMessageData;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        MessageContentClickListener messageContentClickListener = this.f37590a;
        if (messageContentClickListener != null) {
            messageContentClickListener.mo5202a(this.f37591b);
        }
        return Unit.f25273a;
    }
}
