package com.reddit.social.presentation.messaginglist.content;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.reddit.frontpage.C1761R;
import com.reddit.social.presentation.presentationobjects.SnoomojiImageMessageData;
import com.reddit.social.util.ChatUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.DimensionsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0006¨\u0006\u0007"}, d2 = {"bind", "", "Lcom/reddit/social/presentation/messaginglist/content/SnoomojiImageMessageContent;", "messageData", "Lcom/reddit/social/presentation/presentationobjects/SnoomojiImageMessageData;", "snoomojiImageMessageContent", "Landroid/view/ViewGroup;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: SnoomojiImage.kt */
public final class SnoomojiImageKt {
    public static final SnoomojiImageMessageContent m24732a(ViewGroup viewGroup) {
        Intrinsics.m26847b(viewGroup, "$receiver");
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ScaleType.CENTER_CROP);
        viewGroup = DimensionsKt.m28408a(viewGroup.getContext(), C1761R.dimen.snoomoji_chat_icon_dimen);
        imageView.setLayoutParams(new LayoutParams(viewGroup, viewGroup));
        return new SnoomojiImageMessageContent(imageView);
    }

    public static final void m24733a(SnoomojiImageMessageContent snoomojiImageMessageContent, SnoomojiImageMessageData snoomojiImageMessageData) {
        Intrinsics.m26847b(snoomojiImageMessageContent, "$receiver");
        Intrinsics.m26847b(snoomojiImageMessageData, "messageData");
        snoomojiImageMessageContent.f29922b.setImageDrawable(ChatUtilKt.m24749a(snoomojiImageMessageData.f29962a));
    }
}
