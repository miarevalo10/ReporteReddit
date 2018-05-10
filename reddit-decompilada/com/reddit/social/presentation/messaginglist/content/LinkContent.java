package com.reddit.social.presentation.messaginglist.content;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.instabug.chat.model.Attachment;
import com.reddit.social.presentation.messaginglist.MessageContentViewHolder;
import com.reddit.social.widgets.ProportionalImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/content/LinkContent;", "Lcom/reddit/social/presentation/messaginglist/MessageContentViewHolder;", "linkView", "Landroid/view/View;", "rawMessage", "Landroid/widget/TextView;", "linkEmbedContainer", "Landroid/widget/LinearLayout;", "favicon", "Landroid/widget/ImageView;", "siteName", "title", "description", "image", "Lcom/reddit/social/widgets/ProportionalImageView;", "(Landroid/view/View;Landroid/widget/TextView;Landroid/widget/LinearLayout;Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Lcom/reddit/social/widgets/ProportionalImageView;)V", "getDescription", "()Landroid/widget/TextView;", "getFavicon", "()Landroid/widget/ImageView;", "getImage", "()Lcom/reddit/social/widgets/ProportionalImageView;", "getLinkEmbedContainer", "()Landroid/widget/LinearLayout;", "getLinkView", "()Landroid/view/View;", "getRawMessage", "getSiteName", "getTitle", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Link.kt */
public final class LinkContent extends MessageContentViewHolder {
    final View f29894b;
    final TextView f29895c;
    final LinearLayout f29896d;
    final ImageView f29897e;
    final TextView f29898f;
    final TextView f29899g;
    final TextView f29900h;
    final ProportionalImageView f29901i;

    public LinkContent(View view, TextView textView, LinearLayout linearLayout, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, ProportionalImageView proportionalImageView) {
        Intrinsics.m26847b(view, "linkView");
        Intrinsics.m26847b(textView, "rawMessage");
        Intrinsics.m26847b(linearLayout, "linkEmbedContainer");
        Intrinsics.m26847b(imageView, "favicon");
        Intrinsics.m26847b(textView2, "siteName");
        Intrinsics.m26847b(textView3, "title");
        Intrinsics.m26847b(textView4, "description");
        Intrinsics.m26847b(proportionalImageView, Attachment.TYPE_IMAGE);
        super(view);
        this.f29894b = view;
        this.f29895c = textView;
        this.f29896d = linearLayout;
        this.f29897e = imageView;
        this.f29898f = textView2;
        this.f29899g = textView3;
        this.f29900h = textView4;
        this.f29901i = proportionalImageView;
    }
}
