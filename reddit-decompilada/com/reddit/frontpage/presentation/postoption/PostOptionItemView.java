package com.reddit.frontpage.presentation.postoption;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.CustomViewPropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/postoption/PostOptionItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setEnabled", "", "enabled", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PostOptionItemView.kt */
public final class PostOptionItemView extends LinearLayout {
    public static final Companion f20956a = new Companion();
    private HashMap f20957b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/postoption/PostOptionItemView$Companion;", "", "()V", "ALPHA_DISABLED", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: PostOptionItemView.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public PostOptionItemView(Context context) {
        this(context, null, 0, 6, null);
    }

    public PostOptionItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private View m23165a(int i) {
        if (this.f20957b == null) {
            this.f20957b = new HashMap();
        }
        View view = (View) this.f20957b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f20957b.put(Integer.valueOf(i), view);
        return view;
    }

    public /* synthetic */ PostOptionItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public PostOptionItemView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        View.inflate(context, C1761R.layout.post_option_item, this);
        attributeSet = context.getTheme().obtainStyledAttributes(attributeSet, C1761R.styleable.PostOptionItemView, i, 0);
        try {
            Object obj = (TextView) m23165a(C1761R.id.post_option_label);
            Intrinsics.m26843a(obj, "post_option_label");
            obj.setText(attributeSet.getString(1));
            Drawable drawable = attributeSet.getDrawable(0);
            Intrinsics.m26843a((Object) drawable, "array.getDrawable(R.styl…tionItemView_android_src)");
            i = ResourcesUtil.m22721a(context, drawable, (int) C1761R.attr.rdt_nav_icon_color);
            Drawable b = ResourcesUtil.m22724b(context, C1761R.drawable.circle_white, C1761R.attr.rdt_body_color);
            ((ImageView) m23165a(C1761R.id.post_option_icon)).setImageDrawable(i);
            obj = (ImageView) m23165a(C1761R.id.post_option_icon);
            Intrinsics.m26843a(obj, "post_option_icon");
            CustomViewPropertiesKt.m28403a((View) obj, b);
        } finally {
            attributeSet.recycle();
        }
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            Object obj = (TextView) m23165a(C1761R.id.post_option_label);
            Intrinsics.m26843a(obj, "post_option_label");
            obj.setAlpha(0.3f);
            obj = (ImageView) m23165a(C1761R.id.post_option_icon);
            Intrinsics.m26843a(obj, "post_option_icon");
            obj.setAlpha(0.3f);
        }
    }
}
