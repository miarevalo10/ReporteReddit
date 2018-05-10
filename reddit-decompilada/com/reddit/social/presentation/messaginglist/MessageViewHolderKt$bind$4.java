package com.reddit.social.presentation.messaginglist;

import android.view.View;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.social.presentation.presentationobjects.MessageData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessageViewHolder.kt */
final class MessageViewHolderKt$bind$4 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ MessageViewHolder f37567a;
    final /* synthetic */ MessageData f37568b;

    MessageViewHolderKt$bind$4(MessageViewHolder messageViewHolder, MessageData messageData) {
        this.f37567a = messageViewHolder;
        this.f37568b = messageData;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = this.f37567a.c;
        Intrinsics.m26843a(obj, "itemView");
        Routing.m22619a(obj.getContext(), Nav.m22594j(this.f37568b.f22432e));
        return Unit.f25273a;
    }
}
