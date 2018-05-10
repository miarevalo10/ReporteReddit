package com.reddit.frontpage.presentation.common.ui.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"com/reddit/frontpage/presentation/common/ui/view/RedditBottomSheetDialog$wrapInRedditBottomSheet$2", "Landroid/view/View$OnAttachStateChangeListener;", "()V", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditBottomSheetDialog.kt */
public final class RedditBottomSheetDialog$wrapInRedditBottomSheet$2 implements OnAttachStateChangeListener {
    public final void onViewDetachedFromWindow(View view) {
    }

    RedditBottomSheetDialog$wrapInRedditBottomSheet$2() {
    }

    public final void onViewAttachedToWindow(View view) {
        Intrinsics.m26847b(view, "v");
        view = view.getParent();
        if (!(view instanceof View)) {
            view = null;
        }
        view = view;
        if (view != null) {
            view.setBackgroundColor(0);
        }
    }
}
