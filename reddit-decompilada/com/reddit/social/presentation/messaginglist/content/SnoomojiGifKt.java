package com.reddit.social.presentation.messaginglist.content;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.DimensionsKt;
import pl.droidsonroids.gif.GifImageView;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"snoomojiGifMessageContent", "Lcom/reddit/social/presentation/messaginglist/content/SnoomojiGifMessageContent;", "Landroid/view/ViewGroup;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: SnoomojiGif.kt */
public final class SnoomojiGifKt {
    public static final SnoomojiGifMessageContent m24731a(ViewGroup viewGroup) {
        Intrinsics.m26847b(viewGroup, "$receiver");
        GifImageView gifImageView = new GifImageView(viewGroup.getContext());
        viewGroup = DimensionsKt.m28408a(viewGroup.getContext(), C1761R.dimen.snoomoji_chat_icon_dimen);
        gifImageView.setLayoutParams(new LayoutParams(viewGroup, viewGroup));
        return new SnoomojiGifMessageContent(gifImageView);
    }
}
