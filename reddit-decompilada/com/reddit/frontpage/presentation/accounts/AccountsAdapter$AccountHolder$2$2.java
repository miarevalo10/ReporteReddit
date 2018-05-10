package com.reddit.frontpage.presentation.accounts;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.MarginLayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountsAdapter.kt */
final class AccountsAdapter$AccountHolder$2$2 implements OnLayoutChangeListener {
    final /* synthetic */ View f20316a;

    AccountsAdapter$AccountHolder$2$2(View view) {
        this.f20316a = view;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        view = new Rect();
        this.f20316a.getHitRect(view);
        i = this.f20316a.getLayoutParams();
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) i;
        view.left += marginLayoutParams.leftMargin;
        view.right += marginLayoutParams.rightMargin;
        i = this.f20316a.getParent();
        if ((i instanceof View) == 0) {
            i = 0;
        }
        View view2 = (View) i;
        if (view2 != null) {
            view2.setTouchDelegate(new TouchDelegate(view, this.f20316a));
        }
    }
}
