package com.reddit.frontpage.presentation.common.ui.view;

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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/BottomSheetOptionItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BottomSheetOptionItemView.kt */
public final class BottomSheetOptionItemView extends LinearLayout {
    private HashMap f20388a;

    private View m22747a(int i) {
        if (this.f20388a == null) {
            this.f20388a = new HashMap();
        }
        View view = (View) this.f20388a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f20388a.put(Integer.valueOf(i), view);
        return view;
    }

    public BottomSheetOptionItemView(Context context) {
        Intrinsics.m26847b(context, "context");
        this(context, null);
    }

    public BottomSheetOptionItemView(Context context, AttributeSet attributeSet) {
        Intrinsics.m26847b(context, "context");
        this(context, attributeSet, 0);
    }

    public BottomSheetOptionItemView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        View.inflate(context, C1761R.layout.bottomsheet_option_item, this);
        Object obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1761R.styleable.BottomSheetOptionItemView, i, 0);
        Intrinsics.m26843a(obtainStyledAttributes, "context.theme.obtainStyl…ew, defStyleAttr, 0\n    )");
        Object obj = (TextView) m22747a(C1761R.id.option_label);
        Intrinsics.m26843a(obj, "option_label");
        obj.setText(obtainStyledAttributes.getString(1));
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        ImageView imageView = (ImageView) m22747a(C1761R.id.icon);
        Intrinsics.m26843a((Object) drawable, "drawable");
        imageView.setImageDrawable(ResourcesUtil.m22720a(context, drawable));
        context = Unit.f25273a;
        obtainStyledAttributes.recycle();
    }
}
