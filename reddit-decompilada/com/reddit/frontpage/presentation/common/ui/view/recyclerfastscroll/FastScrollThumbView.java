package com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.animation.DynamicAnimation;
import android.support.animation.FloatPropertyCompat;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollItemIndicator.Icon;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollItemIndicator.Text;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollView.ItemIndicatorSelectedCallback;
import com.reddit.frontpage.util.kotlin.ContextsKt;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.CustomViewPropertiesKt;
import org.jetbrains.anko.Sdk21PropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollThumbView;", "Landroid/support/constraint/ConstraintLayout;", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollView$ItemIndicatorSelectedCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fastScrollView", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollView;", "iconView", "Landroid/widget/ImageView;", "isSetup", "", "()Z", "textView", "Landroid/widget/TextView;", "thumbAnimation", "Landroid/support/animation/SpringAnimation;", "thumbView", "Landroid/view/ViewGroup;", "onItemIndicatorSelected", "", "indicator", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator;", "indicatorCenterY", "itemPosition", "setupWithFastScrollView", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FastScrollThumbView.kt */
public final class FastScrollThumbView extends ConstraintLayout implements ItemIndicatorSelectedCallback {
    private final ViewGroup f28092h;
    private final TextView f28093i;
    private final ImageView f28094j;
    private FastScrollView f28095k;
    private final SpringAnimation f28096l;

    public FastScrollThumbView(Context context) {
        this(context, null, 0, 6, null);
    }

    public FastScrollThumbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ FastScrollThumbView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public FastScrollThumbView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        attributeSet = context.getTheme().obtainStyledAttributes(attributeSet, C1761R.styleable.FastScrollThumbView, i, 0);
        i = attributeSet.getColorStateList(3);
        if (i == 0) {
            i = ResourcesUtil.m22738h(context, (int) C1761R.attr.colorPrimary);
            if (i == 0) {
                Intrinsics.m26842a();
            }
        }
        int resourceId = attributeSet.getResourceId(0, ContextsKt.m24077b(context, 16842804));
        int color = attributeSet.getColor(1, ContextsKt.m24077b(context, 16842809));
        ColorStateList colorStateList = attributeSet.getColorStateList(2);
        if (colorStateList == null) {
            colorStateList = ResourcesUtil.m22738h(context, (int) C1761R.attr.colorAccent);
            if (colorStateList == null) {
                Intrinsics.m26842a();
            }
        }
        attributeSet.recycle();
        ViewGroupsKt.m24100a(this, C1761R.layout.fast_scroll_thumb_view, true);
        Object findViewById = findViewById(C1761R.id.fast_scroll_thumb);
        Intrinsics.m26843a(findViewById, "findViewById(R.id.fast_scroll_thumb)");
        this.f28092h = (ViewGroup) findViewById;
        findViewById = this.f28092h.findViewById(C1761R.id.fast_scroll_thumb_text);
        Intrinsics.m26843a(findViewById, "thumbView.findViewById(R…d.fast_scroll_thumb_text)");
        this.f28093i = (TextView) findViewById;
        findViewById = this.f28092h.findViewById(C1761R.id.fast_scroll_thumb_icon);
        Intrinsics.m26843a(findViewById, "thumbView.findViewById(R…d.fast_scroll_thumb_icon)");
        this.f28094j = (ImageView) findViewById;
        this.f28092h.setBackgroundTintList(i);
        if (VERSION.SDK_INT == 21) {
            context = this.f28092h.getBackground();
            if (context == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
            GradientDrawable gradientDrawable = (GradientDrawable) context;
            gradientDrawable.mutate();
            gradientDrawable.setColor(i);
        }
        CustomViewPropertiesKt.m28404a(this.f28093i, resourceId);
        Sdk21PropertiesKt.m28412a(this.f28093i, color);
        this.f28094j.setImageTintList(colorStateList);
        context = new SpringAnimation(this.f28092h, (FloatPropertyCompat) DynamicAnimation.b);
        attributeSet = new SpringForce();
        attributeSet.a();
        context.a(attributeSet);
        this.f28096l = context;
    }

    public final void mo4795a(FastScrollItemIndicator fastScrollItemIndicator, int i) {
        Intrinsics.m26847b(fastScrollItemIndicator, "indicator");
        this.f28096l.a(((float) i) - ((float) (this.f28092h.getMeasuredHeight() / 2)));
        if ((fastScrollItemIndicator instanceof Text) != 0) {
            ViewsKt.m24103a((View) this.f28093i, true);
            ViewsKt.m24103a((View) this.f28094j, false);
            this.f28093i.setText((CharSequence) ((Text) fastScrollItemIndicator).f28091a);
            return;
        }
        if ((fastScrollItemIndicator instanceof Icon) != 0) {
            ViewsKt.m24103a((View) this.f28093i, false);
            ViewsKt.m24103a((View) this.f28094j, true);
            Sdk21PropertiesKt.m28410a(this.f28094j, ((Icon) fastScrollItemIndicator).f28090a);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void setupWithFastScrollView(FastScrollView fastScrollView) {
        Intrinsics.m26847b(fastScrollView, "fastScrollView");
        if ((this.f28095k != null ? 1 : null) != null) {
            throw ((Throwable) new IllegalStateException("Only set this view's FastScrollView once!"));
        }
        this.f28095k = fastScrollView;
        fastScrollView.getItemIndicatorSelectedCallbacks().add(this);
        fastScrollView.setOnTouchListener(new FastScrollThumbView$setupWithFastScrollView$1(this));
    }
}
