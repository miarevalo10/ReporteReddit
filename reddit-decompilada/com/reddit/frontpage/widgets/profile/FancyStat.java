package com.reddit.frontpage.widgets.profile;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.Sdk21PropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010 \u001a\n \"*\u0004\u0018\u00010!0!H\u0002R$\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R$\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017¨\u0006#"}, d2 = {"Lcom/reddit/frontpage/widgets/profile/FancyStat;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "drawableResId", "statIcon", "getStatIcon", "()I", "setStatIcon", "(I)V", "unit", "", "statUnit", "getStatUnit", "()Ljava/lang/String;", "setStatUnit", "(Ljava/lang/String;)V", "color", "statUnitColor", "getStatUnitColor", "setStatUnitColor", "value", "statValue", "getStatValue", "setStatValue", "init", "Landroid/view/View;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FancyStat.kt */
public final class FancyStat extends RelativeLayout {
    private HashMap f22025a;

    public FancyStat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private View m24226a(int i) {
        if (this.f22025a == null) {
            this.f22025a = new HashMap();
        }
        View view = (View) this.f22025a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f22025a.put(Integer.valueOf(i), view);
        return view;
    }

    public final String getStatValue() {
        Object obj = (TextView) m24226a(C1761R.id.primary_text);
        Intrinsics.m26843a(obj, "primary_text");
        return obj.getText().toString();
    }

    public final void setStatValue(String str) {
        Intrinsics.m26847b(str, "value");
        Object obj = (TextView) m24226a(C1761R.id.primary_text);
        Intrinsics.m26843a(obj, "primary_text");
        obj.setText(str);
    }

    public final String getStatUnit() {
        Object obj = (TextView) m24226a(C1761R.id.sub_text);
        Intrinsics.m26843a(obj, "sub_text");
        return obj.getText().toString();
    }

    public final void setStatUnit(String str) {
        Intrinsics.m26847b(str, "unit");
        Object obj = (TextView) m24226a(C1761R.id.sub_text);
        Intrinsics.m26843a(obj, "sub_text");
        obj.setText(str);
    }

    public final int getStatUnitColor() {
        throw new UnsupportedOperationException("Not allowed");
    }

    public final void setStatUnitColor(int i) {
        TextView textView = (TextView) m24226a(C1761R.id.sub_text);
        Intrinsics.m26843a((Object) textView, "sub_text");
        Sdk21PropertiesKt.m28412a(textView, i);
    }

    public final int getStatIcon() {
        throw new UnsupportedOperationException("Not allowed");
    }

    public final void setStatIcon(int i) {
        ImageView imageView = (ImageView) m24226a(C1761R.id.info_icon);
        Object context = getContext();
        Intrinsics.m26843a(context, "context");
        imageView.setImageDrawable(ResourcesUtil.m22724b(context, i, C1761R.attr.rdt_active_color));
    }

    public FancyStat(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i);
        m24225a();
    }

    public /* synthetic */ FancyStat(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    @TargetApi(21)
    public FancyStat(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
        m24225a();
    }

    private final View m24225a() {
        return RelativeLayout.inflate(getContext(), C1761R.layout.widget_fancy_stat, this);
    }
}
