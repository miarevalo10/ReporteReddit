package com.reddit.frontpage.presentation.usermodal;

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
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/usermodal/UserModalItem;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "setText", "title", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserModalItem.kt */
public final class UserModalItem extends LinearLayout {
    private HashMap f20991a;

    public final View m23213a(int i) {
        if (this.f20991a == null) {
            this.f20991a = new HashMap();
        }
        View view = (View) this.f20991a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f20991a.put(Integer.valueOf(i), view);
        return view;
    }

    public UserModalItem(Context context) {
        Intrinsics.m26847b(context, "context");
        this(context, null);
    }

    public UserModalItem(Context context, AttributeSet attributeSet) {
        Intrinsics.m26847b(context, "context");
        this(context, attributeSet, 0);
    }

    public UserModalItem(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        Intrinsics.m26847b(context, "context");
        View.inflate(context, C1761R.layout.item_dialog_user_modal, this);
        attributeSet = context.getTheme().obtainStyledAttributes(attributeSet, C1761R.styleable.ModUsersOptionItemView, i, 0);
        try {
            int color = attributeSet.getColor(0, ResourcesUtil.m22740i(context, C1761R.attr.rdt_body_text_color));
            ImageView imageView = (ImageView) m23213a(C1761R.id.left_icon);
            Drawable drawable = attributeSet.getDrawable(1);
            Intrinsics.m26843a((Object) drawable, "array.getDrawable(R.styl…serModalItem_android_src)");
            imageView.setImageDrawable(ResourcesUtil.m22722a(drawable, color));
            TextView textView = (TextView) m23213a(C1761R.id.text);
            textView.setText(attributeSet.getString(2));
            textView.setTextColor(color);
        } finally {
            attributeSet.recycle();
        }
    }

    public final void setText(String str) {
        Intrinsics.m26847b(str, "title");
        Object obj = (TextView) m23213a(C1761R.id.text);
        Intrinsics.m26843a(obj, "text");
        obj.setText(str);
    }
}
