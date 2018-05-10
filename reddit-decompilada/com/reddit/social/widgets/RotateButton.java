package com.reddit.social.widgets;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/social/widgets/RotateButton;", "Landroid/support/v7/widget/AppCompatImageButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fullRotation", "initialRotation", "rotationDuration", "init", "", "rotate", "isRotated", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RotateButton.kt */
public final class RotateButton extends AppCompatImageButton {
    int f34600a;
    int f34601b;
    int f34602c;

    public RotateButton(Context context, AttributeSet attributeSet) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet);
        m35431a(context, attributeSet);
    }

    public RotateButton(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i);
        m35431a(context, attributeSet);
    }

    private final void m35431a(Context context, AttributeSet attributeSet) {
        int i = C1761R.styleable.RotateButton;
        context = context.obtainStyledAttributes(attributeSet, i, 0, 0);
        try {
            this.f34600a = context.getInteger(0, 0);
            i = 1;
            this.f34601b = this.f34600a + context.getInteger(1, 0);
            this.f34602c = context.getInteger(2, 0);
            setRotation((float) this.f34600a);
            attributeSet = new Object[i];
            attributeSet[0] = Integer.valueOf(this.f34600a);
            Timber.b("initialRotation = %d", attributeSet);
            attributeSet = new Object[i];
            attributeSet[0] = Integer.valueOf(this.f34601b);
            Timber.b("fullRotation = %d", attributeSet);
        } finally {
            context.recycle();
        }
    }
}
