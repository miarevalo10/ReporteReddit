package com.reddit.frontpage.presentation.listing.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\f\u0010\u0019\u001a\u00020\u0014*\u00020\u000bH\u0002J\f\u0010\u001a\u001a\u00020\u0014*\u00020\u000bH\u0002R0\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/UserIndicatorsView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator;", "activeIndicators", "getActiveIndicators", "()Ljava/util/Set;", "setActiveIndicators", "(Ljava/util/Set;)V", "paddingView", "Landroid/view/View;", "setIndicatorActive", "", "indicator", "active", "", "updatePadding", "addView", "removeView", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserIndicatorsView.kt */
public final class UserIndicatorsView extends LinearLayout {
    private Set<? extends Indicator> f20821a;
    private final View f20822b;

    public UserIndicatorsView(Context context) {
        this(context, null, 0, 6, null);
    }

    public UserIndicatorsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ UserIndicatorsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public UserIndicatorsView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f20821a = SetsKt__SetsKt.m26799a();
        setOrientation(null);
        setGravity(16);
        ViewGroupsKt.m24100a(this, C1761R.layout.user_indicators, true);
        Object findViewById = findViewById(C1761R.id.user_indicators_spacing);
        Intrinsics.m26843a(findViewById, "findViewById(R.id.user_indicators_spacing)");
        this.f20822b = findViewById;
        if (isInEditMode() != null) {
            setActiveIndicators(ArraysKt___ArraysKt.m36111k((Object[]) Indicator.values()));
        }
    }

    public final Set<Indicator> getActiveIndicators() {
        return this.f20821a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setActiveIndicators(java.util.Set<? extends com.reddit.frontpage.presentation.listing.ui.view.Indicator> r8) {
        /*
        r7 = this;
        r0 = "value";
        kotlin.jvm.internal.Intrinsics.m26847b(r8, r0);
        r0 = r7.f20821a;
        r0 = (java.lang.Iterable) r0;
        r0 = r0.iterator();
    L_0x000e:
        r1 = r0.hasNext();
        r2 = 0;
        if (r1 == 0) goto L_0x004b;
    L_0x0015:
        r1 = r0.next();
        r1 = (com.reddit.frontpage.presentation.listing.ui.view.Indicator) r1;
        r3 = r7.getChildCount();
        r3 = r3 + -1;
        if (r3 < 0) goto L_0x0041;
    L_0x0023:
        r4 = r7.getChildAt(r2);
        r5 = "child";
        kotlin.jvm.internal.Intrinsics.m26843a(r4, r5);
        r5 = r4.getTag();
        r6 = r1.f20739g;
        r5 = kotlin.jvm.internal.Intrinsics.m26845a(r5, r6);
        if (r5 == 0) goto L_0x003c;
    L_0x0038:
        r7.removeView(r4);
        goto L_0x000e;
    L_0x003c:
        if (r2 == r3) goto L_0x0041;
    L_0x003e:
        r2 = r2 + 1;
        goto L_0x0023;
    L_0x0041:
        r8 = new java.util.NoSuchElementException;
        r0 = "No element matching predicate was found.";
        r8.<init>(r0);
        r8 = (java.lang.Throwable) r8;
        throw r8;
    L_0x004b:
        r8 = (java.lang.Iterable) r8;
        r0 = new com.reddit.frontpage.presentation.listing.ui.view.UserIndicatorsView$activeIndicators$$inlined$sortedBy$1;
        r0.<init>();
        r0 = (java.util.Comparator) r0;
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.m41418a(r8, r0);
        r0 = (java.lang.Iterable) r0;
        r0 = r0.iterator();
    L_0x005e:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0099;
    L_0x0064:
        r1 = r0.next();
        r1 = (com.reddit.frontpage.presentation.listing.ui.view.Indicator) r1;
        r3 = r7.getContext();
        r3 = android.view.LayoutInflater.from(r3);
        r4 = 2131558869; // 0x7f0d01d5 float:1.8743066E38 double:1.0531300093E-314;
        r5 = r7;
        r5 = (android.view.ViewGroup) r5;
        r3 = r3.inflate(r4, r5, r2);
        if (r3 != 0) goto L_0x0086;
    L_0x007e:
        r8 = new kotlin.TypeCastException;
        r0 = "null cannot be cast to non-null type android.widget.ImageView";
        r8.<init>(r0);
        throw r8;
    L_0x0086:
        r4 = r3;
        r4 = (android.widget.ImageView) r4;
        r5 = r1.f20739g;
        r4.setTag(r5);
        r1 = r1.mo4892a();
        r4.setImageResource(r1);
        r7.addView(r3);
        goto L_0x005e;
    L_0x0099:
        r8 = com.google.common.collect.Sets.a(r8);
        r0 = "Sets.immutableEnumSet(value)";
        kotlin.jvm.internal.Intrinsics.m26843a(r8, r0);
        r8 = (java.util.Set) r8;
        r7.f20821a = r8;
        r8 = r7.f20821a;
        r8 = (java.util.Collection) r8;
        r8 = r8.isEmpty();
        r8 = r8 ^ 1;
        if (r8 == 0) goto L_0x00b8;
    L_0x00b2:
        r8 = r7.f20822b;
        com.reddit.frontpage.util.kotlin.ViewsKt.m24107c(r8);
        return;
    L_0x00b8:
        r8 = r7.f20822b;
        com.reddit.frontpage.util.kotlin.ViewsKt.m24109d(r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.presentation.listing.ui.view.UserIndicatorsView.setActiveIndicators(java.util.Set):void");
    }
}
