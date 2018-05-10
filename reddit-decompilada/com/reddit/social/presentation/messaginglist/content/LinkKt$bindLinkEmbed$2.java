package com.reddit.social.presentation.messaginglist.content;

import android.view.View;
import com.reddit.social.presentation.messaginglist.MessageContentClickListener;
import com.reddit.social.presentation.presentationobjects.LinkContentMessageData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: Link.kt */
final class LinkKt$bindLinkEmbed$2 extends Lambda implements Function1<View, Boolean> {
    final /* synthetic */ MessageContentClickListener f37579a;
    final /* synthetic */ LinkContentMessageData f37580b;

    LinkKt$bindLinkEmbed$2(MessageContentClickListener messageContentClickListener, LinkContentMessageData linkContentMessageData) {
        this.f37579a = messageContentClickListener;
        this.f37580b = linkContentMessageData;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = this.f37579a;
        if (obj != null) {
            obj.mo5202a(this.f37580b);
        }
        return Boolean.valueOf(true);
    }
}
