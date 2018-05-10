package com.reddit.frontpage.presentation.onboarding;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/OnboardingProgressView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "segments", "getSegments", "()I", "setSegments", "(I)V", "selectedSegments", "getSelectedSegments", "setSelectedSegments", "setupSegments", "", "updateSelected", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingProgressView.kt */
public final class OnboardingProgressView extends LinearLayout {
    private int f20938a;
    private int f20939b;

    public OnboardingProgressView(Context context) {
        this(context, null, 0, 6, null);
    }

    public OnboardingProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ OnboardingProgressView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public OnboardingProgressView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f20938a = 1;
        if (isInEditMode() != null) {
            setSegments(3);
            setSelectedSegments(1);
        }
        m23158a();
    }

    public final int getSegments() {
        return this.f20938a;
    }

    public final void setSegments(int i) {
        if (this.f20938a != i) {
            this.f20938a = i;
            m23158a();
            invalidate();
            requestLayout();
        }
    }

    public final int getSelectedSegments() {
        return this.f20939b;
    }

    public final void setSelectedSegments(int i) {
        if (this.f20939b != i) {
            this.f20939b = i;
            m23159b();
        }
    }

    private final void m23158a() {
        removeAllViews();
        int i = this.f20938a;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 != 0) {
                ViewGroupsKt.m24100a(this, C1761R.layout.onboarding_progress_spacer, true);
            }
            ViewGroupsKt.m24100a(this, C1761R.layout.onboarding_progress_segment, true);
        }
        m23159b();
    }

    private final void m23159b() {
        Iterable b = RangesKt___RangesKt.m32854b(0, getChildCount());
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b));
        Iterator it = b.iterator();
        while (it.hasNext()) {
            arrayList.add(getChildAt(((IntIterator) it).mo6663a()));
        }
        Collection arrayList2 = new ArrayList();
        Iterator it2 = ((List) arrayList).iterator();
        while (true) {
            int i = 1;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            Object obj = (View) next;
            Intrinsics.m26843a(obj, "it");
            if (obj.getId() != C1761R.id.progress_segment) {
                i = 0;
            }
            if (i != 0) {
                arrayList2.add(next);
            }
        }
        List list = (List) arrayList2;
        int size = list.size() - 1;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                obj = (View) list.get(i2);
                Intrinsics.m26843a(obj, "view");
                int i3 = i2 + 1;
                obj.setEnabled(i3 <= this.f20939b);
                if (i2 != size) {
                    i2 = i3;
                } else {
                    return;
                }
            }
        }
    }
}
