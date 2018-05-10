package com.reddit.frontpage.util.kotlin;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.reddit.frontpage.C1761R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJH\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r*\u0002H\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/util/kotlin/AnkoLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lparams", "T", "Landroid/view/View;", "width", "height", "init", "Lkotlin/Function1;", "Landroid/widget/LinearLayout$LayoutParams;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/view/View;IILkotlin/jvm/functions/Function1;)Landroid/view/View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AnkoLinearLayout.kt */
public class AnkoLinearLayout extends LinearLayout {
    private HashMap f21831a;

    public AnkoLinearLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public AnkoLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public View mo5068a(int i) {
        if (this.f21831a == null) {
            this.f21831a = new HashMap();
        }
        View view = (View) this.f21831a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f21831a.put(Integer.valueOf(i), view);
        return view;
    }

    public AnkoLinearLayout(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
    }

    public /* synthetic */ AnkoLinearLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = C1761R.attr.voteViewStyle;
        }
        this(context, attributeSet, i);
    }

    @TargetApi(21)
    public AnkoLinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i, i2);
    }
}
