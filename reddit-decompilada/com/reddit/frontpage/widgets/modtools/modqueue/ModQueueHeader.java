package com.reddit.frontpage.widgets.modtools.modqueue;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.anko.Sdk21PropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0017\u0010\u000e¨\u0006$"}, d2 = {"Lcom/reddit/frontpage/widgets/modtools/modqueue/ModQueueHeader;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "filterView", "Landroid/widget/ImageView;", "getFilterView", "()Landroid/widget/ImageView;", "filterView$delegate", "Lkotlin/Lazy;", "selectedButton", "Landroid/widget/Button;", "getSelectedButton", "()Landroid/widget/Button;", "selectedButton$delegate", "viewModeButton", "getViewModeButton", "viewModeButton$delegate", "applyColorFilter", "", "keyColor", "setOnFilterViewClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnSelectButtonClicked", "setSubredditName", "name", "", "setViewModeClickListener", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModQueueHeader.kt */
public final class ModQueueHeader extends LinearLayout {
    static final /* synthetic */ KProperty[] f22005a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModQueueHeader.class), "selectedButton", "getSelectedButton()Landroid/widget/Button;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModQueueHeader.class), "filterView", "getFilterView()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModQueueHeader.class), "viewModeButton", "getViewModeButton()Landroid/widget/ImageView;"))};
    private final Lazy f22006b;
    private final Lazy f22007c;
    private final Lazy f22008d;
    private HashMap f22009e;

    public ModQueueHeader(Context context) {
        this(context, null, 0, 6, null);
    }

    public ModQueueHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final View m24222a(int i) {
        if (this.f22009e == null) {
            this.f22009e = new HashMap();
        }
        View view = (View) this.f22009e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f22009e.put(Integer.valueOf(i), view);
        return view;
    }

    public final ImageView getFilterView() {
        return (ImageView) this.f22007c.mo5678b();
    }

    public final Button getSelectedButton() {
        return (Button) this.f22006b.mo5678b();
    }

    public final ImageView getViewModeButton() {
        return (ImageView) this.f22008d.mo5678b();
    }

    public /* synthetic */ ModQueueHeader(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public ModQueueHeader(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f22006b = LazyKt.m26777a((Function0) new ModQueueHeader$selectedButton$2(this));
        this.f22007c = LazyKt.m26777a((Function0) new ModQueueHeader$filterView$2(this));
        this.f22008d = LazyKt.m26777a((Function0) new ModQueueHeader$viewModeButton$2(this));
        View.inflate(getContext(), C1761R.layout.mod_queue_header, this);
        Object context2 = getContext();
        Intrinsics.m26843a(context2, "context");
        Sdk21PropertiesKt.m28409a((View) this, ResourcesUtil.m22740i(context2, C1761R.attr.rdt_canvas_color));
        setGravity(16);
        setOrientation(null);
    }

    @TargetApi(21)
    public ModQueueHeader(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i, i2);
        this.f22006b = LazyKt.m26777a((Function0) new ModQueueHeader$selectedButton$2(this));
        this.f22007c = LazyKt.m26777a((Function0) new ModQueueHeader$filterView$2(this));
        this.f22008d = LazyKt.m26777a((Function0) new ModQueueHeader$viewModeButton$2(this));
        View.inflate(getContext(), C1761R.layout.mod_queue_header, this);
        Object context2 = getContext();
        Intrinsics.m26843a(context2, "context");
        Sdk21PropertiesKt.m28409a((View) this, ResourcesUtil.m22740i(context2, C1761R.attr.rdt_canvas_color));
        setGravity(16);
        setOrientation(null);
    }

    public final void setSubredditName(String str) {
        Intrinsics.m26847b(str, "name");
        getSelectedButton().setText(str);
    }

    public final void setOnFilterViewClickListener(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "listener");
        getFilterView().setOnClickListener(onClickListener);
    }

    public final void setViewModeClickListener(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "listener");
        getViewModeButton().setOnClickListener(onClickListener);
    }

    public final void setOnSelectButtonClicked(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "listener");
        getSelectedButton().setOnClickListener(onClickListener);
    }
}
