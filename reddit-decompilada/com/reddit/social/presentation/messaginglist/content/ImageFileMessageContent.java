package com.reddit.social.presentation.messaginglist.content;

import android.widget.ImageView;
import com.reddit.social.presentation.messaginglist.MessageContentViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/content/ImageFileMessageContent;", "Lcom/reddit/social/presentation/messaginglist/MessageContentViewHolder;", "imageFile", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;)V", "getImageFile", "()Landroid/widget/ImageView;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ImageFile.kt */
public final class ImageFileMessageContent extends MessageContentViewHolder {
    final ImageView f29893b;

    public ImageFileMessageContent(ImageView imageView) {
        Intrinsics.m26847b(imageView, "imageFile");
        super(imageView);
        this.f29893b = imageView;
    }
}
