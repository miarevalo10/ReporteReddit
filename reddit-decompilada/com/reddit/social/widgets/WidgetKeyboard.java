package com.reddit.social.widgets;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.frontpage.C1761R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00029:B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u0006\u0010 \u001a\u00020\u001bJ\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010\"\u001a\u00020#J\b\u0010\u0012\u001a\u00020\u001bH\u0002J\u0006\u0010$\u001a\u00020\u0015J\u0006\u0010%\u001a\u00020\u001bJ\b\u0010&\u001a\u00020\u0015H\u0002J\u0014\u0010'\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0(J\b\u0010+\u001a\u00020\u001bH\u0014J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.H\u0002J\u000e\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020#J\u000e\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u00010#J\b\u00106\u001a\u00020\u001bH\u0002J\b\u00107\u001a\u00020\u001bH\u0002J\b\u00108\u001a\u00020\u001bH\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/reddit/social/widgets/WidgetKeyboard;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ANIMATION_DURATION", "", "customKeyboardHeight", "getCustomKeyboardHeight", "()I", "setCustomKeyboardHeight", "(I)V", "hideCustomKeyboard", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "isExpanded", "", "keyboardHeight", "originalHeight", "updateKeyboardHeight", "wasKeyboardShowing", "addMedium", "", "medium", "Lcom/reddit/social/widgets/WidgetKeyboard$Medium;", "calculateCustomKeyboardHeight", "calculateKeyboardHeight", "disableSendButton", "enableSendButton", "getText", "", "hideCustomKeyboardIfVisible", "hideKeyboard", "isKeyboardShowing", "listenTextChanged", "Lcom/jakewharton/rxbinding2/InitialValueObservable;", "", "kotlin.jvm.PlatformType", "onDetachedFromWindow", "refreshChildLayouts", "view", "Landroid/view/ViewGroup;", "setHint", "hint", "setSendOnClickListener", "listener", "Lcom/reddit/social/widgets/WidgetKeyboard$SendListener;", "setText", "text", "showCustomKeyboard", "showKeyboard", "toggleCustomKeyboard", "Medium", "SendListener", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: WidgetKeyboard.kt */
public final class WidgetKeyboard extends LinearLayout {
    public boolean f22502a;
    private final long f22503b = 200;
    private int f22504c;
    private int f22505d;
    private int f22506e;
    private boolean f22507f;
    private OnGlobalLayoutListener f22508g;
    private OnGlobalLayoutListener f22509h;
    private HashMap f22510i;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/reddit/social/widgets/WidgetKeyboard$Medium;", "", "activeIcon", "", "content", "Landroid/view/View;", "context", "Landroid/content/Context;", "screenWidth", "icon", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: WidgetKeyboard.kt */
    public interface Medium {
        View mo5207a(Context context, int i);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/reddit/social/widgets/WidgetKeyboard$SendListener;", "", "onClick", "", "text", "Landroid/text/Editable;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: WidgetKeyboard.kt */
    public interface SendListener {
        void mo5200a(Editable editable);
    }

    public final View m24794a(int i) {
        if (this.f22510i == null) {
            this.f22510i = new HashMap();
        }
        View view = (View) this.f22510i.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f22510i.put(Integer.valueOf(i), view);
        return view;
    }

    public final int getCustomKeyboardHeight() {
        return this.f22506e;
    }

    public final void setCustomKeyboardHeight(int i) {
        this.f22506e = i;
    }

    public WidgetKeyboard(Context context) {
        Intrinsics.m26847b(context, "context");
        super(context);
        setOrientation(1);
        View.inflate(getContext(), C1761R.layout.widget_keyboard, this);
        this.f22509h = (OnGlobalLayoutListener) new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                String str;
                Object[] objArr;
                ViewParent parent;
                if (this.m24786e()) {
                    str = "keyboard is showing, hide the custom kb (%d)";
                    objArr = new Object[1];
                    parent = this.getParent();
                    if (parent == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
                    }
                    objArr[0] = Integer.valueOf(((RelativeLayout) parent).getHeight());
                    Timber.b(str, objArr);
                    Object obj = (FrameLayout) this.m24794a(C1761R.id.keyboardMediumContainer);
                    Intrinsics.m26843a(obj, "keyboardMediumContainer");
                    obj.getLayoutParams().height = 0;
                    ViewParent parent2 = this.getParent();
                    if (parent2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
                    }
                    ((RelativeLayout) parent2).getViewTreeObserver().removeOnGlobalLayoutListener(this.f22509h);
                    ((FrameLayout) this.m24794a(C1761R.id.keyboardMediumContainer)).requestLayout();
                    return;
                }
                str = "keyboard isn't showing yet (%d)";
                objArr = new Object[1];
                parent = this.getParent();
                if (parent == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
                }
                objArr[0] = Integer.valueOf(((RelativeLayout) parent).getHeight());
                Timber.b(str, objArr);
            }
        };
        this.f22508g = (OnGlobalLayoutListener) new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                if (this.f22502a) {
                    WidgetKeyboard.m24788f(this);
                } else {
                    WidgetKeyboard.m24789g(this);
                }
                ViewParent parent = this.getParent();
                if (parent == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
                }
                ((RelativeLayout) parent).getViewTreeObserver().removeOnGlobalLayoutListener(this.f22508g);
            }
        };
        ((WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader)).m24802a((OnClickListener) new OnClickListener() {
            public final void onClick(View view) {
                this.m24795a();
            }
        });
        ((WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader)).setMediumContainer((FrameLayout) m24794a(C1761R.id.keyboardMediumContainer));
        Timber.b("init", new Object[0]);
        post((Runnable) new Runnable() {
            public final void run() {
                Timber.b(Kind.POST, new Object[0]);
                WidgetKeyboard.m24792j(this);
                WidgetKeyboard.m24785d(this);
                this.m24784d();
                this.m24796b();
            }
        });
    }

    public WidgetKeyboard(Context context, AttributeSet attributeSet) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet);
        setOrientation(1);
        View.inflate(getContext(), C1761R.layout.widget_keyboard, this);
        this.f22509h = (OnGlobalLayoutListener) /* anonymous class already generated */;
        this.f22508g = (OnGlobalLayoutListener) /* anonymous class already generated */;
        ((WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader)).m24802a((OnClickListener) /* anonymous class already generated */);
        ((WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader)).setMediumContainer((FrameLayout) m24794a(C1761R.id.keyboardMediumContainer));
        Timber.b("init", new Object[null]);
        post((Runnable) /* anonymous class already generated */);
    }

    public WidgetKeyboard(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i);
        setOrientation(1);
        View.inflate(getContext(), C1761R.layout.widget_keyboard, this);
        this.f22509h = (OnGlobalLayoutListener) /* anonymous class already generated */;
        this.f22508g = (OnGlobalLayoutListener) /* anonymous class already generated */;
        ((WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader)).m24802a((OnClickListener) /* anonymous class already generated */);
        ((WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader)).setMediumContainer((FrameLayout) m24794a(C1761R.id.keyboardMediumContainer));
        Timber.b("init", new Object[null]);
        post((Runnable) /* anonymous class already generated */);
    }

    public final void m24795a() {
        RotateButton rotateButton = (RotateButton) ((WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader)).m24800a(C1761R.id.toggleExpand);
        ViewPropertyAnimator animate;
        if (this.f22502a) {
            animate = rotateButton.animate();
            animate.rotation((float) rotateButton.f34600a);
            animate.setDuration((long) rotateButton.f34602c);
        } else {
            animate = rotateButton.animate();
            animate.rotation((float) rotateButton.f34601b);
            animate.setDuration((long) rotateButton.f34602c);
        }
        this.f22502a ^= 1;
        WidgetKeyboardHeader widgetKeyboardHeader;
        Object obj;
        Object obj2;
        if (this.f22502a) {
            widgetKeyboardHeader = (WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader);
            obj = (LinearLayout) widgetKeyboardHeader.m24800a(C1761R.id.chatContainer);
            Intrinsics.m26843a(obj, "chatContainer");
            obj.setVisibility(8);
            obj2 = (LinearLayout) widgetKeyboardHeader.m24800a(C1761R.id.mediaControlContainer);
            Intrinsics.m26843a(obj2, "mediaControlContainer");
            obj2.setVisibility(8);
            m24796b();
        } else {
            widgetKeyboardHeader = (WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader);
            obj = (LinearLayout) widgetKeyboardHeader.m24800a(C1761R.id.chatContainer);
            Intrinsics.m26843a(obj, "chatContainer");
            obj.setVisibility(0);
            obj2 = (LinearLayout) widgetKeyboardHeader.m24800a(C1761R.id.mediaControlContainer);
            Intrinsics.m26843a(obj2, "mediaControlContainer");
            obj2.setVisibility(8);
        }
        ViewParent parent = getParent();
        if (parent == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
        }
        ((RelativeLayout) parent).getViewTreeObserver().addOnGlobalLayoutListener(this.f22508g);
    }

    private final void m24784d() {
        if (m24786e()) {
            ViewParent parent = getParent();
            if (parent == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
            }
            int height = ((RelativeLayout) parent).getHeight();
            Object obj = (WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader);
            Intrinsics.m26843a(obj, "keyboardHeader");
            int height2 = obj.getHeight();
            Timber.b("new height = %d", new Object[]{Integer.valueOf(height)});
            Timber.b("kb header height = %d", new Object[]{Integer.valueOf(height2)});
            height = Math.abs(this.f22505d - height);
            if (height > ModuleDescriptor.MODULE_VERSION) {
                this.f22504c = height;
            }
            Timber.b("kb height = %d", new Object[]{Integer.valueOf(this.f22504c)});
        }
    }

    public final void m24796b() {
        Object systemService = getContext().getSystemService("input_method");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    private final boolean m24786e() {
        ViewParent parent = getParent();
        if (parent != null) {
            return ((RelativeLayout) parent).getHeight() < this.f22505d;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
        }
    }

    private final void m24779a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    m24779a((ViewGroup) childAt);
                }
                childAt.requestLayout();
                childAt.invalidate();
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void setSendOnClickListener(SendListener sendListener) {
        Intrinsics.m26847b(sendListener, "listener");
        ((WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader)).setSendOnClickListener(sendListener);
    }

    public final InitialValueObservable<CharSequence> m24797c() {
        return RxTextView.a((EditText) ((WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader)).m24800a(C1761R.id.chatMessage));
    }

    public final String getText() {
        return ((WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader)).getText();
    }

    public final void setText(String str) {
        ((WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader)).setText(str);
    }

    public final void setHint(String str) {
        Intrinsics.m26847b(str, "hint");
        ((WidgetKeyboardHeader) m24794a(C1761R.id.keyboardHeader)).setHint(str);
    }

    protected final void onDetachedFromWindow() {
        m24796b();
        super.onDetachedFromWindow();
    }

    public static final /* synthetic */ void m24785d(WidgetKeyboard widgetKeyboard) {
        Object systemService = widgetKeyboard.getContext().getSystemService("input_method");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        widgetKeyboard = widgetKeyboard.getParent();
        if (widgetKeyboard == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
        }
        inputMethodManager.showSoftInput((RelativeLayout) widgetKeyboard, 0);
    }

    public static final /* synthetic */ void m24788f(WidgetKeyboard widgetKeyboard) {
        widgetKeyboard.f22507f = widgetKeyboard.m24786e();
        widgetKeyboard.m24784d();
        int i = widgetKeyboard.m24786e() ? widgetKeyboard.f22504c : 0;
        Object obj = (FrameLayout) widgetKeyboard.m24794a(C1761R.id.keyboardMediumContainer);
        Intrinsics.m26843a(obj, "keyboardMediumContainer");
        obj.getLayoutParams().height = i;
        widgetKeyboard.m24796b();
        ((WidgetKeyboardHeader) widgetKeyboard.m24794a(C1761R.id.keyboardHeader)).m24801a();
        obj = (FrameLayout) widgetKeyboard.m24794a(C1761R.id.keyboardMediumContainer);
        Intrinsics.m26843a(obj, "keyboardMediumContainer");
        obj.setVisibility(8);
        ValueAnimator ofInt = ObjectAnimator.ofInt(new int[]{i, widgetKeyboard.f22506e});
        ofInt.addUpdateListener(new WidgetKeyboard$showCustomKeyboard$$inlined$apply$lambda$1(widgetKeyboard));
        ofInt.setDuration(widgetKeyboard.f22503b);
        ofInt.start();
    }

    public static final /* synthetic */ void m24789g(WidgetKeyboard widgetKeyboard) {
        int[] iArr = new int[2];
        Object obj = (FrameLayout) widgetKeyboard.m24794a(C1761R.id.keyboardMediumContainer);
        Intrinsics.m26843a(obj, "keyboardMediumContainer");
        iArr[0] = obj.getLayoutParams().height;
        iArr[1] = 0;
        ValueAnimator ofInt = ObjectAnimator.ofInt(iArr);
        ofInt.addUpdateListener(new WidgetKeyboard$hideCustomKeyboard$$inlined$apply$lambda$1(widgetKeyboard));
        ofInt.addListener(new WidgetKeyboard$hideCustomKeyboard$$inlined$apply$lambda$2(widgetKeyboard));
        ofInt.setDuration(widgetKeyboard.f22503b);
        ofInt.start();
    }

    public static final /* synthetic */ void m24792j(WidgetKeyboard widgetKeyboard) {
        ViewParent parent = widgetKeyboard.getParent();
        if (parent == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
        }
        widgetKeyboard.f22505d = ((RelativeLayout) parent).getHeight();
        Timber.b("original height = %d", new Object[]{Integer.valueOf(widgetKeyboard.f22505d)});
    }
}
