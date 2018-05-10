package com.reddit.frontpage.presentation.common.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/TexturedBackground;", "", "()V", "TEXTURED_BACKGROUND_ALPHA", "", "load", "", "context", "Landroid/content/Context;", "keyColor", "background", "Landroid/widget/ImageView;", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TexturedBackground.kt */
public final class TexturedBackground {
    public static final TexturedBackground f20386a = new TexturedBackground();

    private TexturedBackground() {
    }

    public static final void m22745a(Context context, String str, ImageView imageView) {
        Object obj;
        int i;
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(imageView, "background");
        CharSequence charSequence = str;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                obj = null;
                if (obj == null) {
                    i = ResourcesUtil.m22740i(context, C1761R.attr.rdt_active_color);
                } else {
                    i = Color.parseColor(str);
                }
                m22744a(context, i, imageView);
            }
        }
        obj = 1;
        if (obj == null) {
            i = Color.parseColor(str);
        } else {
            i = ResourcesUtil.m22740i(context, C1761R.attr.rdt_active_color);
        }
        m22744a(context, i, imageView);
    }

    public static final void m22744a(Context context, int i, ImageView imageView) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(imageView, "background");
        context = ContextCompat.a(context, C1761R.drawable.textured_background);
        if (context == null) {
            Intrinsics.m26842a();
        }
        context = context.mutate();
        context.setTint(i);
        context.setTintMode(Mode.OVERLAY);
        context.setAlpha(77);
        imageView.setBackgroundColor(i);
        imageView.setImageDrawable(context);
    }
}
