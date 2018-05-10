package com.reddit.frontpage.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/widgets/ModUsersOptionItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModUsersOptionItemView.kt */
public final class ModUsersOptionItemView extends LinearLayout {
    private HashMap f21930a;

    private View m24186a(int i) {
        if (this.f21930a == null) {
            this.f21930a = new HashMap();
        }
        View view = (View) this.f21930a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f21930a.put(Integer.valueOf(i), view);
        return view;
    }

    public ModUsersOptionItemView(Context context) {
        Intrinsics.m26847b(context, "context");
        this(context, null);
    }

    public ModUsersOptionItemView(Context context, AttributeSet attributeSet) {
        Intrinsics.m26847b(context, "context");
        this(context, attributeSet, 0);
    }

    public ModUsersOptionItemView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        View.inflate(context, C1761R.layout.item_modusers_option, this);
        attributeSet = context.getTheme().obtainStyledAttributes(attributeSet, C1761R.styleable.ModUsersOptionItemView, i, 0);
        try {
            i = attributeSet.getColor(0, ResourcesUtil.m22740i(context, C1761R.attr.rdt_body_text_color));
            ImageView imageView = (ImageView) m24186a(C1761R.id.mod_options_left_icon);
            Drawable drawable = attributeSet.getDrawable(1);
            Intrinsics.m26843a((Object) drawable, "array.getDrawable(R.styl…tionItemView_android_src)");
            imageView.setImageDrawable(ResourcesUtil.m22722a(drawable, i));
            TextView textView = (TextView) m24186a(C1761R.id.mod_options_text);
            textView.setText(attributeSet.getString(2));
            textView.setTextColor(i);
            if (attributeSet.getBoolean(4, false) != 0) {
                ImageView imageView2 = (ImageView) m24186a(C1761R.id.mod_options_right_icon);
                Object obj = (ImageView) imageView2.findViewById(C1761R.id.mod_options_right_icon);
                Intrinsics.m26843a(obj, "mod_options_right_icon");
                Drawable drawable2 = obj.getDrawable();
                Intrinsics.m26843a((Object) drawable2, "mod_options_right_icon.drawable");
                imageView2.setImageDrawable(ResourcesUtil.m22733e(context, drawable2));
                ViewsKt.m24107c(imageView2);
            }
            attributeSet.recycle();
        } catch (Throwable th) {
            attributeSet.recycle();
        }
    }
}
