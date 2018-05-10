package com.reddit.social.presentation.chatrequests.view;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/view/MemberViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "icon", "Landroid/widget/ImageView;", "name", "Landroid/widget/TextView;", "karmaAndAge", "nsfwLabel", "blockedLabel", "(Landroid/view/View;Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V", "getBlockedLabel", "()Landroid/widget/TextView;", "getIcon", "()Landroid/widget/ImageView;", "getKarmaAndAge", "getName", "getNsfwLabel", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MemberViewHolder.kt */
public final class MemberViewHolder extends ViewHolder {
    final ImageView f29685a;
    final TextView f29686b;
    final TextView f29687p;
    final TextView f29688q;
    final TextView f29689r;

    public MemberViewHolder(View view, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(imageView, "icon");
        Intrinsics.m26847b(textView, "name");
        Intrinsics.m26847b(textView2, "karmaAndAge");
        Intrinsics.m26847b(textView3, "nsfwLabel");
        Intrinsics.m26847b(textView4, "blockedLabel");
        super(view);
        this.f29685a = imageView;
        this.f29686b = textView;
        this.f29687p = textView2;
        this.f29688q = textView3;
        this.f29689r = textView4;
    }
}
