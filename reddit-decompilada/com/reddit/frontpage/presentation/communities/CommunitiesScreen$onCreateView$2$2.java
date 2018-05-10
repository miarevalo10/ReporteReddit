package com.reddit.frontpage.presentation.communities;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollItemIndicator;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollItemIndicator.Text;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "top", "<anonymous parameter 3>", "bottom", "<anonymous parameter 5>", "oldTop", "<anonymous parameter 7>", "oldBottom", "onLayoutChange"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesScreen.kt */
final class CommunitiesScreen$onCreateView$2$2 implements OnLayoutChangeListener {
    final /* synthetic */ FastScrollView f20454a;
    final /* synthetic */ int f20455b;

    CommunitiesScreen$onCreateView$2$2(FastScrollView fastScrollView, int i) {
        this.f20454a = fastScrollView;
        this.f20455b = i;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i2 != i6 || i4 != i8) {
            view = this.f20454a.getTopIconItemIndicators().size();
            this.f20454a.setShowIndicator((Function3) new Function3<FastScrollItemIndicator, Integer, Integer, Boolean>() {
                public final /* synthetic */ Object mo6509a(Object obj, Object obj2, Object obj3) {
                    FastScrollItemIndicator fastScrollItemIndicator = (FastScrollItemIndicator) obj;
                    obj2 = ((Number) obj2).intValue();
                    obj3 = ((Number) obj3).intValue();
                    Intrinsics.m26847b(fastScrollItemIndicator, "indicator");
                    boolean z = true;
                    if (obj3 * this.f20455b >= this.f20454a.getHeight() && (fastScrollItemIndicator instanceof Text) != null && (obj2 - view) % 2 == 1) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            });
        }
    }
}
