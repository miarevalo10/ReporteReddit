package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] f16417a = new int[]{16842912};
    private boolean f16418b;

    class C09821 extends AccessibilityDelegateCompat {
        final /* synthetic */ CheckableImageButton f11065a;

        C09821(CheckableImageButton checkableImageButton) {
            this.f11065a = checkableImageButton;
        }

        public final void mo84a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo84a(view, accessibilityEvent);
            accessibilityEvent.setChecked(this.f11065a.isChecked());
        }

        public final void mo38a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo38a(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.m1326a(true);
            accessibilityNodeInfoCompat.f1523a.setChecked(this.f11065a.isChecked());
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ViewCompat.m1220a((View) this, new C09821(this));
    }

    public void setChecked(boolean z) {
        if (this.f16418b != z) {
            this.f16418b = z;
            refreshDrawableState();
            sendAccessibilityEvent(true);
        }
    }

    public boolean isChecked() {
        return this.f16418b;
    }

    public void toggle() {
        setChecked(this.f16418b ^ 1);
    }

    public int[] onCreateDrawableState(int i) {
        if (this.f16418b) {
            return mergeDrawableStates(super.onCreateDrawableState(i + f16417a.length), f16417a);
        }
        return super.onCreateDrawableState(i);
    }
}
