package com.reddit.android.view;

import android.text.Layout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.FloatRef;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: WrappedWidthTextView.kt */
final class WrappedWidthTextView$getMaxLineWidth$1 extends Lambda implements Function1<Integer, Boolean> {
    final /* synthetic */ FloatRef f19333a;
    final /* synthetic */ Layout f19334b;

    WrappedWidthTextView$getMaxLineWidth$1(FloatRef floatRef, Layout layout) {
        this.f19333a = floatRef;
        this.f19334b = layout;
        super(1);
    }

    public final /* synthetic */ Object m20599a(Object obj) {
        return Boolean.valueOf(this.f19334b.getLineWidth(((Number) obj).intValue()) > this.f19333a.a ? true : null);
    }
}
