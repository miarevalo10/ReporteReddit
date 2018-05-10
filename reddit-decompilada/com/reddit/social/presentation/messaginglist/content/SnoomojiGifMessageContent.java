package com.reddit.social.presentation.messaginglist.content;

import android.content.res.Resources;
import com.reddit.social.presentation.messaginglist.MessageContentViewHolder;
import com.reddit.social.presentation.presentationobjects.SnoomojiGifMessageData;
import com.reddit.social.util.ChatUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b*\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/content/SnoomojiGifMessageContent;", "Lcom/reddit/social/presentation/messaginglist/MessageContentViewHolder;", "snooGif", "Lpl/droidsonroids/gif/GifImageView;", "(Lpl/droidsonroids/gif/GifImageView;)V", "getSnooGif", "()Lpl/droidsonroids/gif/GifImageView;", "bind", "", "messageData", "Lcom/reddit/social/presentation/presentationobjects/SnoomojiGifMessageData;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SnoomojiGif.kt */
public final class SnoomojiGifMessageContent extends MessageContentViewHolder {
    private final GifImageView f29921b;

    public SnoomojiGifMessageContent(GifImageView gifImageView) {
        Intrinsics.m26847b(gifImageView, "snooGif");
        super(gifImageView);
        this.f29921b = gifImageView;
    }

    public static void m30884a(SnoomojiGifMessageContent snoomojiGifMessageContent, SnoomojiGifMessageData snoomojiGifMessageData) {
        Intrinsics.m26847b(snoomojiGifMessageContent, "$receiver");
        Intrinsics.m26847b(snoomojiGifMessageData, "messageData");
        try {
            snoomojiGifMessageData = ChatUtilKt.m24758b(snoomojiGifMessageData.f29960a);
            Object context = snoomojiGifMessageContent.f29921b.getContext();
            Intrinsics.m26843a(context, "snooGif.context");
            Resources resources = context.getResources();
            if (snoomojiGifMessageData == null) {
                Intrinsics.m26842a();
            }
            snoomojiGifMessageContent.f29921b.setImageDrawable(new GifDrawable(resources, snoomojiGifMessageData.intValue()));
        } catch (SnoomojiGifMessageContent snoomojiGifMessageContent2) {
            snoomojiGifMessageContent2.printStackTrace();
        }
    }
}
