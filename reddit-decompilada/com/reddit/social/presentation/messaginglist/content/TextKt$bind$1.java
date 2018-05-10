package com.reddit.social.presentation.messaginglist.content;

import android.view.View;
import com.reddit.social.presentation.messaginglist.MessageContentClickListener;
import com.reddit.social.presentation.presentationobjects.TextMessageData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: Text.kt */
final class TextKt$bind$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ MessageContentClickListener f37588a;
    final /* synthetic */ TextMessageData f37589b;

    TextKt$bind$1(MessageContentClickListener messageContentClickListener, TextMessageData textMessageData) {
        this.f37588a = messageContentClickListener;
        this.f37589b = textMessageData;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = this.f37588a;
        if (obj != null) {
            obj.mo5203b(this.f37589b);
        }
        return Unit.f25273a;
    }
}
