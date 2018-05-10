package com.reddit.social.presentation.messaginglist.content;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.reddit.android.view.WrappedWidthTextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.CustomLayoutPropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"adminMessageContent", "Lcom/reddit/social/presentation/messaginglist/content/AdminMessageContent;", "Landroid/view/ViewGroup;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: Admin.kt */
public final class AdminKt {
    public static final AdminMessageContent m24720a(ViewGroup viewGroup) {
        Intrinsics.m26847b(viewGroup, "$receiver");
        Object context = viewGroup.getContext();
        Intrinsics.m26843a(context, "context");
        WrappedWidthTextView wrappedWidthTextView = new WrappedWidthTextView(context, null, 0, 6, null);
        wrappedWidthTextView.setLayoutParams(new LayoutParams(CustomLayoutPropertiesKt.m28401b(), CustomLayoutPropertiesKt.m28401b()));
        TextView textView = wrappedWidthTextView;
        TextViewsKt.m24095a(textView, (int) C1761R.style.TextAppearance.RedditBase.Title);
        return new AdminMessageContent(textView);
    }
}
