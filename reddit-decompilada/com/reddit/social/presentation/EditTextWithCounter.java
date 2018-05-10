package com.reddit.social.presentation;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.sdk21.listeners.Sdk21ListenersListenersKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010!\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J>\u0010\"\u001a\u00020\u001f26\u0010#\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u0018J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\tH\u0002R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R@\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/reddit/social/presentation/EditTextWithCounter;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "charCounter", "Landroid/widget/TextView;", "getCharCounter", "()Landroid/widget/TextView;", "setCharCounter", "(Landroid/widget/TextView;)V", "editText", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "setEditText", "(Landroid/widget/EditText;)V", "focusChangeListener", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "", "hasFocus", "", "textMaxLength", "init", "onFocusChange", "l", "setMaxLength", "maxLength", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: EditTextWithCounter.kt */
public final class EditTextWithCounter extends LinearLayout {
    public Function2<? super View, ? super Boolean, Unit> f22311a;
    private int f22312b;
    @BindView
    public TextView charCounter;
    @BindView
    public EditText editText;

    public final EditText getEditText() {
        EditText editText = this.editText;
        if (editText == null) {
            Intrinsics.m26844a("editText");
        }
        return editText;
    }

    public final void setEditText(EditText editText) {
        Intrinsics.m26847b(editText, "<set-?>");
        this.editText = editText;
    }

    public final TextView getCharCounter() {
        TextView textView = this.charCounter;
        if (textView == null) {
            Intrinsics.m26844a("charCounter");
        }
        return textView;
    }

    public final void setCharCounter(TextView textView) {
        Intrinsics.m26847b(textView, "<set-?>");
        this.charCounter = textView;
    }

    public EditTextWithCounter(Context context) {
        Intrinsics.m26847b(context, "context");
        this(context, null);
    }

    public EditTextWithCounter(Context context, AttributeSet attributeSet) {
        Intrinsics.m26847b(context, "context");
        this(context, attributeSet, 0);
    }

    public EditTextWithCounter(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f22312b = -1;
        View.inflate(context, C1761R.layout.edit_text_with_counter, this);
        ButterKnife.a(this);
        setOrientation(0);
        context = context.obtainStyledAttributes(attributeSet, C1761R.styleable.EditTextWithCounter);
        attributeSet = context.getInt(3, -1);
        CharSequence text = context.getText(0);
        i = context.getInt(2, -1);
        int i2 = context.getInt(1, 1);
        context.recycle();
        context = this.editText;
        if (context == null) {
            Intrinsics.m26844a("editText");
        }
        context.setHint(text);
        context = this.editText;
        if (context == null) {
            Intrinsics.m26844a("editText");
        }
        context.setMinLines(i);
        context = this.editText;
        if (context == null) {
            Intrinsics.m26844a("editText");
        }
        context.setMaxLines(i2);
        if (i > 1 || i2 > 1) {
            context = this.editText;
            if (context == null) {
                Intrinsics.m26844a("editText");
            }
            i = this.editText;
            if (i == 0) {
                Intrinsics.m26844a("editText");
            }
            context.setInputType(i.getInputType() | 131072);
            context = this.editText;
            if (context == null) {
                Intrinsics.m26844a("editText");
            }
            context.setGravity(48);
            context = this.charCounter;
            if (context == null) {
                Intrinsics.m26844a("charCounter");
            }
            context.setGravity(80);
        }
        if (attributeSet > null) {
            setMaxLength(attributeSet);
            context = this.editText;
            if (context == null) {
                Intrinsics.m26844a("editText");
            }
            Sdk21ListenersListenersKt.m28425a((TextView) context, (Function1) new EditTextWithCounter$init$1(this));
            context = this.editText;
            if (context == null) {
                Intrinsics.m26844a("editText");
            }
            context.setOnFocusChangeListener((OnFocusChangeListener) new EditTextWithCounter$init$2(this));
        }
    }

    private final void setMaxLength(int i) {
        this.f22312b = i;
        EditText editText = this.editText;
        if (editText == null) {
            Intrinsics.m26844a("editText");
        }
        editText.setFilters((InputFilter[]) new LengthFilter[]{new LengthFilter(i)});
        TextView textView = this.charCounter;
        if (textView == null) {
            Intrinsics.m26844a("charCounter");
        }
        textView.setText(Integer.toString(i));
    }
}
