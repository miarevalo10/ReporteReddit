package com.reddit.android.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.FloatRef;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0014¨\u0006\u0011"}, d2 = {"Lcom/reddit/android/view/WrappedWidthTextView;", "Landroid/support/v7/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getMaxLineWidth", "", "layout", "Landroid/text/Layout;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: WrappedWidthTextView.kt */
public final class WrappedWidthTextView extends AppCompatTextView {
    public WrappedWidthTextView(Context context) {
        this(context, null, 0, 6, null);
    }

    public WrappedWidthTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ WrappedWidthTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public WrappedWidthTextView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.b(context, "context");
        super(context, attributeSet, i);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getLayout() != 0) {
            i = getLayout();
            Intrinsics.a(i, "layout");
            i2 = new FloatRef();
            i2.a = 0.0f;
            Iterator a = SequencesKt.a(CollectionsKt.t(RangesKt.b(0, i.getLineCount())), new WrappedWidthTextView$getMaxLineWidth$1(i2, i)).a();
            while (a.hasNext()) {
                i2.a = i.getLineWidth(((Number) a.next()).intValue());
            }
            setMeasuredDimension((((int) Math.ceil((double) i2.a)) + getCompoundPaddingStart()) + getCompoundPaddingEnd(), getMeasuredHeight());
        }
    }
}
