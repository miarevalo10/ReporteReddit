package com.reddit.frontpage.ui.preferences;

import android.content.Context;
import android.support.v7.preference.ListPreference;
import android.util.AttributeSet;
import androidx.content.res.TypedArrayKt;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/ui/preferences/IconListPreference;", "Landroid/support/v7/preference/ListPreference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "entryIcons", "", "getEntryIcons", "()[I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: IconListPreference.kt */
public final class IconListPreference extends ListPreference {
    final int[] f37326C;

    public IconListPreference(Context context) {
        this(context, null, 0, 0, 14, null);
    }

    public IconListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    public IconListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    public /* synthetic */ IconListPreference(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 2) != null) {
            attributeSet = null;
        }
        if ((i3 & 4) != null) {
            i = C1761R.attr.dialogPreferenceStyle;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i, i2);
    }

    public IconListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i, i2);
        Object obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1761R.styleable.IconListPreference, i, i2);
        Intrinsics.m26843a(obtainStyledAttributes, "context.obtainStyledAttr…tr,\n      defStyleRes\n  )");
        i = 0;
        Object obtainTypedArray = context.getResources().obtainTypedArray(obtainStyledAttributes.getResourceId(0, 0));
        Intrinsics.m26843a(obtainTypedArray, "context.resources.obtain…ence_entryIcons, 0)\n    )");
        i2 = obtainTypedArray.length();
        int[] iArr = new int[i2];
        while (i < i2) {
            iArr[i] = TypedArrayKt.a(obtainTypedArray, i);
            i++;
        }
        obtainTypedArray.recycle();
        obtainStyledAttributes.recycle();
        this.f37326C = iArr;
    }
}
