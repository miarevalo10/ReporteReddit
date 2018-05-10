package com.reddit.frontpage.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/widgets/GeopopularOptionItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "region", "getRegion", "()Ljava/lang/String;", "setRegion", "(Ljava/lang/String;)V", "init", "", "setSelected", "selected", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularOptionItemView.kt */
public final class GeopopularOptionItemView extends LinearLayout {
    private String f21868a;
    private HashMap f21869b;

    private View m24142a(int i) {
        if (this.f21869b == null) {
            this.f21869b = new HashMap();
        }
        View view = (View) this.f21869b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f21869b.put(Integer.valueOf(i), view);
        return view;
    }

    public final String getRegion() {
        return this.f21868a;
    }

    public final void setRegion(String str) {
        Intrinsics.m26847b(str, "value");
        Object obj = (TextView) m24142a(C1761R.id.region_textview);
        Intrinsics.m26843a(obj, "region_textview");
        obj.setText(str);
    }

    public GeopopularOptionItemView(Context context) {
        Intrinsics.m26847b(context, "context");
        this(context, null);
    }

    public GeopopularOptionItemView(Context context, AttributeSet attributeSet) {
        Intrinsics.m26847b(context, "context");
        this(context, attributeSet, 0);
    }

    public GeopopularOptionItemView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f21868a = "";
        View.inflate(context, C1761R.layout.item_geopopular_option, this);
        context = context.getTheme().obtainStyledAttributes(attributeSet, C1761R.styleable.GeopopularOptionItemView, i, 0);
        try {
            Object obj;
            if (context.getBoolean(1, false) != null) {
                obj = (ImageView) m24142a(C1761R.id.drillin_icon);
                Intrinsics.m26843a(obj, "drillin_icon");
                ViewsKt.m24107c((View) obj);
            }
            obj = (CheckedTextView) m24142a(C1761R.id.option);
            Intrinsics.m26843a(obj, "option");
            obj.setText(context.getString(0));
        } finally {
            context.recycle();
        }
    }

    public final void setSelected(boolean z) {
        Object obj = (CheckedTextView) m24142a(C1761R.id.option);
        Intrinsics.m26843a(obj, "option");
        obj.setChecked(z);
    }
}
