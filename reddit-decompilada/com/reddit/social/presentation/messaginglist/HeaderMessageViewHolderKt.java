package com.reddit.social.presentation.messaginglist;

import android.content.Context;
import android.view.LayoutInflater;
import com.reddit.frontpage.C1761R;
import com.reddit.social.presentation.presentationobjects.HeaderMessageData;
import com.reddit.social.widgets.MembersLayout;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0006¨\u0006\u0007"}, d2 = {"bind", "", "Lcom/reddit/social/presentation/messaginglist/HeaderMessageViewHolder;", "messageData", "Lcom/reddit/social/presentation/presentationobjects/HeaderMessageData;", "headerMessage", "Landroid/content/Context;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: HeaderMessageViewHolder.kt */
public final class HeaderMessageViewHolderKt {
    public static final HeaderMessageViewHolder m24703a(Context context) {
        Intrinsics.m26847b(context, "$receiver");
        context = context.getSystemService("layout_inflater");
        if (context == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
        }
        Object inflate = ((LayoutInflater) context).inflate(C1761R.layout.chat_header_message, null);
        Object obj = (MembersLayout) inflate.findViewById(C1761R.id.chat_header_message_members);
        Intrinsics.m26843a(inflate, "view");
        Intrinsics.m26843a(obj, "membersLayout");
        return new HeaderMessageViewHolder(inflate, obj);
    }

    public static final void m24704a(HeaderMessageViewHolder headerMessageViewHolder, HeaderMessageData headerMessageData) {
        Intrinsics.m26847b(headerMessageViewHolder, "$receiver");
        Intrinsics.m26847b(headerMessageData, "messageData");
        headerMessageViewHolder.f34586a.setMembers(headerMessageData.f29935a);
    }
}
