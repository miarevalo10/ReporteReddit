package com.reddit.social.presentation.messaginglist;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/TypingIndicatorViewHolder;", "Lcom/reddit/social/presentation/messaginglist/BaseMessageViewHolder;", "view", "Landroid/view/View;", "textView", "Landroid/widget/TextView;", "(Landroid/view/View;Landroid/widget/TextView;)V", "getTextView", "()Landroid/widget/TextView;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TypingIndicatorViewHolder.kt */
public final class TypingIndicatorViewHolder extends BaseMessageViewHolder {
    final TextView f34598a;

    public TypingIndicatorViewHolder(View view, TextView textView) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(textView, "textView");
        super(view);
        this.f34598a = textView;
    }
}
