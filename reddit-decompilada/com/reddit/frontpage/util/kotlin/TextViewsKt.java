package com.reddit.frontpage.util.kotlin;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.TextViewCompat;
import android.text.Html;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\b\u001a\u00020\t\u001a\u0014\u0010\n\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"isEllipsized", "", "Landroid/widget/TextView;", "setDrawableTintListCompat", "", "colorStateList", "Landroid/content/res/ColorStateList;", "setHtml", "html", "", "setTextAppearanceCompat", "resId", "", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: TextViews.kt */
public final class TextViewsKt {
    public static final void m24095a(TextView textView, int i) {
        Intrinsics.m26847b(textView, "$receiver");
        TextViewCompat.a(textView, i);
    }

    public static final void m24097a(TextView textView, String str) {
        Intrinsics.m26847b(textView, "$receiver");
        Intrinsics.m26847b(str, "html");
        if (VERSION.SDK_INT >= 24) {
            str = Html.fromHtml(str, 0);
        } else {
            str = Html.fromHtml(str);
        }
        textView.setText(str);
    }

    public static final void m24096a(TextView textView, ColorStateList colorStateList) {
        Intrinsics.m26847b(textView, "$receiver");
        Intrinsics.m26847b(colorStateList, "colorStateList");
        if (VERSION.SDK_INT < 24) {
            Object compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            Intrinsics.m26843a(compoundDrawablesRelative, "compoundDrawablesRelative");
            Object[] objArr = (Object[]) compoundDrawablesRelative;
            Object compoundDrawables = textView.getCompoundDrawables();
            Intrinsics.m26843a(compoundDrawables, "compoundDrawables");
            for (Drawable tintList : ArraysKt___ArraysKt.m36105e((Object[]) ArraysKt___ArraysKt.m36090a(objArr, (Object[]) compoundDrawables))) {
                tintList.setTintList(colorStateList);
            }
            return;
        }
        textView.setCompoundDrawableTintList(colorStateList);
    }

    public static final boolean m24098a(TextView textView) {
        Intrinsics.m26847b(textView, "$receiver");
        int ellipsisCount = textView.getLayout().getEllipsisCount(textView.getLineCount() - 1);
        if (textView.getLineCount() <= null || ellipsisCount <= 0) {
            return null;
        }
        return true;
    }
}
