package com.reddit.social.presentation.messaginglist;

import android.view.View;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessageViewHolder.kt */
final class MessageViewHolderKt$bind$$inlined$let$lambda$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ MessageViewHolder f37564a;
    final /* synthetic */ HasMessageData f37565b;
    final /* synthetic */ MessageItemOnClickListener f37566c;

    MessageViewHolderKt$bind$$inlined$let$lambda$2(MessageViewHolder messageViewHolder, HasMessageData hasMessageData, MessageItemOnClickListener messageItemOnClickListener) {
        this.f37564a = messageViewHolder;
        this.f37565b = hasMessageData;
        this.f37566c = messageItemOnClickListener;
        super(1);
    }

    public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
        this.f37566c.mo5196a(this.f37565b);
        return Unit.f25273a;
    }
}
