package com.reddit.social.presentation.messaginglist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.social.presentation.messaginglist.content.AdminKt;
import com.reddit.social.presentation.messaginglist.content.ImageFileKt;
import com.reddit.social.presentation.messaginglist.content.LinkKt;
import com.reddit.social.presentation.messaginglist.content.RedditImageKt;
import com.reddit.social.presentation.messaginglist.content.SnoomojiGifKt;
import com.reddit.social.presentation.messaginglist.content.SnoomojiImageKt;
import com.reddit.social.presentation.messaginglist.content.TextKt;
import com.reddit.social.presentation.presentationobjects.MessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"messageContent", "Lcom/reddit/social/presentation/messaginglist/MessageContentViewHolder;", "Landroid/view/ViewGroup;", "viewType", "Lcom/reddit/social/presentation/presentationobjects/MessageType;", "setBackground", "", "Landroid/view/View;", "isSelf", "", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: MessageContent.kt */
public final class MessageContentKt {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f22384a;

        static {
            int[] iArr = new int[MessageType.values().length];
            f22384a = iArr;
            iArr[MessageType.f22444a.ordinal()] = 1;
            f22384a[MessageType.f22452i.ordinal()] = 2;
            f22384a[MessageType.f22447d.ordinal()] = 3;
            f22384a[MessageType.f22448e.ordinal()] = 4;
            f22384a[MessageType.f22450g.ordinal()] = 5;
            f22384a[MessageType.f22453j.ordinal()] = 6;
            f22384a[MessageType.f22454k.ordinal()] = 7;
            f22384a[MessageType.f22451h.ordinal()] = 8;
            f22384a[MessageType.f22446c.ordinal()] = 9;
            f22384a[MessageType.f22445b.ordinal()] = 10;
            f22384a[MessageType.f22449f.ordinal()] = 11;
        }
    }

    public static final MessageContentViewHolder m24709a(ViewGroup viewGroup, MessageType messageType) {
        Intrinsics.m26847b(viewGroup, "$receiver");
        Intrinsics.m26847b(messageType, "viewType");
        switch (WhenMappings.f22384a[messageType.ordinal()]) {
            case 1:
                return TextKt.m24734a(viewGroup);
            case 2:
                return AdminKt.m24720a(viewGroup);
            case 3:
                return (MessageContentViewHolder) new Stub();
            case 4:
                return (MessageContentViewHolder) new Stub();
            case 5:
                return (MessageContentViewHolder) new Stub();
            case 6:
                return SnoomojiImageKt.m24732a(viewGroup);
            case 7:
                return SnoomojiGifKt.m24731a(viewGroup);
            case 8:
                return LinkKt.m24724a(viewGroup);
            case 9:
                return (MessageContentViewHolder) new Stub();
            case 10:
                return ImageFileKt.m24721a(viewGroup);
            case 11:
                return RedditImageKt.m24727a(viewGroup);
            default:
                return (MessageContentViewHolder) new Stub();
        }
    }

    public static final void m24710a(View view, boolean z) {
        Intrinsics.m26847b(view, "$receiver");
        int i = z ? true : true;
        Context context = view.getContext();
        Intrinsics.m26843a((Object) context, "context");
        view.setBackground(ResourcesUtil.m22723b(context, i));
    }
}
