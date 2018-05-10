package com.reddit.social.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.social.widgets.WidgetKeyboard.Medium;
import com.reddit.social.widgets.WidgetKeyboard.SendListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.anko.Sdk21PropertiesKt;
import org.jetbrains.anko.sdk21.listeners.Sdk21ListenersListenersKt;
import org.jetbrains.anko.sdk21.listeners.__TextWatcher;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e0\u001dJ\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u001bJ\u000e\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020%J\u000e\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020\u00162\b\u0010.\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010/\u001a\u00020\u0016J\u0006\u00100\u001a\u00020\u0016J\u0010\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\tH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/reddit/social/widgets/WidgetKeyboardHeader;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activeMedium", "Lcom/reddit/social/widgets/WidgetKeyboard$Medium;", "mediumContainer", "Landroid/widget/FrameLayout;", "getMediumContainer", "()Landroid/widget/FrameLayout;", "setMediumContainer", "(Landroid/widget/FrameLayout;)V", "mediums", "", "addMedium", "", "medium", "displayMedium", "focusChat", "getText", "", "listenTextChanged", "Lcom/jakewharton/rxbinding2/InitialValueObservable;", "", "kotlin.jvm.PlatformType", "onToggleClick", "onClickListener", "Landroid/view/View$OnClickListener;", "rotate", "expanded", "", "setHint", "hint", "setSendButtonEnabled", "enabled", "setSendOnClickListener", "listener", "Lcom/reddit/social/widgets/WidgetKeyboard$SendListener;", "setText", "text", "showChat", "showMedia", "updateActiveMediumIcon", "activeMediumIndex", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: WidgetKeyboardHeader.kt */
public final class WidgetKeyboardHeader extends LinearLayout {
    public Medium f22512a;
    public final List<Medium> f22513b = ((List) new ArrayList());
    private FrameLayout f22514c;
    private HashMap f22515d;

    public final View m24800a(int i) {
        if (this.f22515d == null) {
            this.f22515d = new HashMap();
        }
        View view = (View) this.f22515d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f22515d.put(Integer.valueOf(i), view);
        return view;
    }

    public final FrameLayout getMediumContainer() {
        return this.f22514c;
    }

    public final void setMediumContainer(FrameLayout frameLayout) {
        this.f22514c = frameLayout;
    }

    public WidgetKeyboardHeader(Context context) {
        Intrinsics.m26847b(context, "context");
        super(context);
        LinearLayout.inflate(getContext(), C1761R.layout.widget_keyboard_header, this);
        RotateButton rotateButton = (RotateButton) m24800a(C1761R.id.toggleExpand);
        Context context2 = getContext();
        Intrinsics.m26843a((Object) context2, "context");
        rotateButton.setImageDrawable(ResourcesUtil.m22734f(context2, (int) C1761R.drawable.ic_icon_add_plus));
        ImageButton imageButton = (ImageButton) m24800a(C1761R.id.sendButton);
        context2 = getContext();
        Intrinsics.m26843a((Object) context2, "context");
        imageButton.setImageDrawable(ResourcesUtil.m22719a(context2, (int) C1761R.drawable.ic_icon_send, (int) C1761R.attr.rdt_active_enabled_else_canvas));
        setSendButtonEnabled(null);
        Object obj = (EditText) m24800a(C1761R.id.chatMessage);
        Intrinsics.m26843a(obj, "chatMessage");
        Sdk21ListenersListenersKt.m28425a((TextView) obj, new Function1<__TextWatcher, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                __TextWatcher org_jetbrains_anko_sdk21_listeners___TextWatcher = (__TextWatcher) obj;
                Intrinsics.m26847b(org_jetbrains_anko_sdk21_listeners___TextWatcher, "$receiver");
                org_jetbrains_anko_sdk21_listeners___TextWatcher.m28426a(new Function4<CharSequence, Integer, Integer, Integer, Unit>() {
                    public final /* synthetic */ Object mo6942a(Object obj, Object obj2, Object obj3, Object obj4) {
                        CharSequence charSequence = (CharSequence) obj;
                        ((Number) obj2).intValue();
                        ((Number) obj3).intValue();
                        ((Number) obj4).intValue();
                        if (charSequence != null) {
                            if (StringsKt__StringsJVMKt.m41943a(charSequence) == null) {
                                obj = null;
                                this.setSendButtonEnabled(obj ^ 1);
                                return Unit.f25273a;
                            }
                        }
                        obj = 1;
                        this.setSendButtonEnabled(obj ^ 1);
                        return Unit.f25273a;
                    }
                });
                return Unit.f25273a;
            }
        });
    }

    public WidgetKeyboardHeader(Context context, AttributeSet attributeSet) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet);
        LinearLayout.inflate(getContext(), C1761R.layout.widget_keyboard_header, this);
        RotateButton rotateButton = (RotateButton) m24800a(C1761R.id.toggleExpand);
        Context context2 = getContext();
        Intrinsics.m26843a((Object) context2, "context");
        rotateButton.setImageDrawable(ResourcesUtil.m22734f(context2, (int) C1761R.drawable.ic_icon_add_plus));
        ImageButton imageButton = (ImageButton) m24800a(C1761R.id.sendButton);
        context2 = getContext();
        Intrinsics.m26843a((Object) context2, "context");
        imageButton.setImageDrawable(ResourcesUtil.m22719a(context2, (int) C1761R.drawable.ic_icon_send, (int) C1761R.attr.rdt_active_enabled_else_canvas));
        setSendButtonEnabled(null);
        Object obj = (EditText) m24800a(C1761R.id.chatMessage);
        Intrinsics.m26843a(obj, "chatMessage");
        Sdk21ListenersListenersKt.m28425a((TextView) obj, (Function1) /* anonymous class already generated */);
    }

    public WidgetKeyboardHeader(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i);
        LinearLayout.inflate(getContext(), C1761R.layout.widget_keyboard_header, this);
        RotateButton rotateButton = (RotateButton) m24800a(C1761R.id.toggleExpand);
        Context context2 = getContext();
        Intrinsics.m26843a((Object) context2, "context");
        rotateButton.setImageDrawable(ResourcesUtil.m22734f(context2, (int) C1761R.drawable.ic_icon_add_plus));
        ImageButton imageButton = (ImageButton) m24800a(C1761R.id.sendButton);
        context2 = getContext();
        Intrinsics.m26843a((Object) context2, "context");
        imageButton.setImageDrawable(ResourcesUtil.m22719a(context2, (int) C1761R.drawable.ic_icon_send, (int) C1761R.attr.rdt_active_enabled_else_canvas));
        setSendButtonEnabled(null);
        Object obj = (EditText) m24800a(C1761R.id.chatMessage);
        Intrinsics.m26843a(obj, "chatMessage");
        Sdk21ListenersListenersKt.m28425a((TextView) obj, (Function1) /* anonymous class already generated */);
    }

    public final void setSendButtonEnabled(boolean z) {
        Object obj = (ImageButton) m24800a(C1761R.id.sendButton);
        Intrinsics.m26843a(obj, "sendButton");
        obj.setEnabled(z);
    }

    public final void m24802a(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "onClickListener");
        ((RotateButton) m24800a(C1761R.id.toggleExpand)).setOnClickListener(onClickListener);
    }

    public final void setSendOnClickListener(SendListener sendListener) {
        Intrinsics.m26847b(sendListener, "listener");
        Object obj = (ImageButton) m24800a(C1761R.id.sendButton);
        Intrinsics.m26843a(obj, "sendButton");
        ((View) obj).setOnClickListener((OnClickListener) new WidgetKeyboardHeader$inlined$sam$OnClickListener$i$7f478c20(new WidgetKeyboardHeader$setSendOnClickListener$1(this, sendListener)));
    }

    public final String getText() {
        Object obj = (EditText) m24800a(C1761R.id.chatMessage);
        Intrinsics.m26843a(obj, "chatMessage");
        return obj.getText().toString();
    }

    public final void setText(String str) {
        ((EditText) m24800a(C1761R.id.chatMessage)).setText(str);
    }

    public final void setHint(String str) {
        Intrinsics.m26847b(str, "hint");
        Object obj = (EditText) m24800a(C1761R.id.chatMessage);
        Intrinsics.m26843a(obj, "chatMessage");
        obj.setHint(str);
    }

    public final void m24801a() {
        FrameLayout frameLayout = this.f22514c;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            Medium medium = this.f22512a;
            if (medium != null) {
                Object context = frameLayout.getContext();
                Intrinsics.m26843a(context, "context");
                Object rootView = frameLayout.getRootView();
                Intrinsics.m26843a(rootView, "rootView");
                View a = medium.mo5207a(context, rootView.getWidth());
                if (a != null) {
                    frameLayout.addView(a);
                }
            }
        }
    }

    public static final /* synthetic */ void m24798a(WidgetKeyboardHeader widgetKeyboardHeader, int i) {
        Iterator it = widgetKeyboardHeader.f22513b.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            it.next();
            int i3 = i2 + 1;
            View childAt = ((LinearLayout) widgetKeyboardHeader.m24800a(C1761R.id.mediaControlContainer)).getChildAt(i2);
            if (childAt == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
            }
            ImageView imageView = (ImageView) childAt;
            if (i2 == i) {
                Sdk21PropertiesKt.m28410a(imageView, (int) C1761R.drawable.snoomojis_active);
            } else {
                Sdk21PropertiesKt.m28410a(imageView, (int) C1761R.drawable.snoomojis);
            }
            i2 = i3;
        }
    }
}
