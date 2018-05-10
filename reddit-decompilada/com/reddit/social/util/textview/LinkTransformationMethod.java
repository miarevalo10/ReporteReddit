package com.reddit.social.util.textview;

import android.graphics.Rect;
import android.text.Spannable;
import android.text.method.TransformationMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;
import com.reddit.frontpage.widgets.span.UrlToNativeWebViewSpan;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J0\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/reddit/social/util/textview/LinkTransformationMethod;", "Landroid/text/method/TransformationMethod;", "()V", "getTransformation", "", "source", "view", "Landroid/view/View;", "onFocusChanged", "", "sourceText", "focused", "", "direction", "", "previouslyFocusedRect", "Landroid/graphics/Rect;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkTransformationMethod.kt */
public final class LinkTransformationMethod implements TransformationMethod {
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(charSequence, "sourceText");
        Intrinsics.m26847b(rect, "previouslyFocusedRect");
    }

    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        Intrinsics.m26847b(charSequence, "source");
        Intrinsics.m26847b(view, "view");
        if (!(view instanceof TextView)) {
            return charSequence;
        }
        TextView textView = (TextView) view;
        Linkify.addLinks(textView, 1);
        if (textView.getText() != null) {
            if (textView.getText() instanceof Spannable) {
                charSequence = textView.getText();
                if (charSequence == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.text.Spannable");
                }
                Spannable spannable = (Spannable) charSequence;
                int i = 0;
                URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, textView.length(), URLSpan.class);
                int length = uRLSpanArr.length;
                while (i < length) {
                    Object obj = uRLSpanArr[i];
                    int spanStart = spannable.getSpanStart(obj);
                    int spanEnd = spannable.getSpanEnd(obj);
                    Intrinsics.m26843a(obj, "span");
                    String url = obj.getURL();
                    spannable.removeSpan(obj);
                    spannable.setSpan(new UrlToNativeWebViewSpan(url), spanStart, spanEnd, 33);
                    i++;
                }
                return spannable;
            }
        }
        return charSequence;
    }
}
