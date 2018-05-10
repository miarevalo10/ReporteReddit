package com.reddit.frontpage.util.kotlin;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/reddit/frontpage/util/kotlin/ViewsKt$onLayout$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "onGlobalLayout", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Views.kt */
public final class ViewsKt$onLayout$1 implements OnGlobalLayoutListener {
    final /* synthetic */ View f21833a;
    final /* synthetic */ Function0 f21834b;

    ViewsKt$onLayout$1(View view, Function0 function0) {
        this.f21833a = view;
        this.f21834b = function0;
    }

    public final void onGlobalLayout() {
        this.f21833a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f21834b.invoke();
    }
}
