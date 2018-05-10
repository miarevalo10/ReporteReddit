package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;

public abstract class DialogPreference extends Preference {
    CharSequence f11622a;
    CharSequence f11623b;
    Drawable f11624c;
    CharSequence f11625d;
    CharSequence f11626e;
    int f11627f;

    public interface TargetFragment {
        Preference mo3191a(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0177R.styleable.DialogPreference, i, i2);
        this.f11622a = TypedArrayUtils.m789c(obtainStyledAttributes, C0177R.styleable.DialogPreference_dialogTitle, C0177R.styleable.DialogPreference_android_dialogTitle);
        if (this.f11622a == null) {
            this.f11622a = this.f1897p;
        }
        this.f11623b = TypedArrayUtils.m789c(obtainStyledAttributes, C0177R.styleable.DialogPreference_dialogMessage, C0177R.styleable.DialogPreference_android_dialogMessage);
        this.f11624c = TypedArrayUtils.m781a(obtainStyledAttributes, C0177R.styleable.DialogPreference_dialogIcon, C0177R.styleable.DialogPreference_android_dialogIcon);
        this.f11625d = TypedArrayUtils.m789c(obtainStyledAttributes, C0177R.styleable.DialogPreference_positiveButtonText, C0177R.styleable.DialogPreference_android_positiveButtonText);
        this.f11626e = TypedArrayUtils.m789c(obtainStyledAttributes, C0177R.styleable.DialogPreference_negativeButtonText, C0177R.styleable.DialogPreference_android_negativeButtonText);
        this.f11627f = TypedArrayUtils.m777a(obtainStyledAttributes, C0177R.styleable.DialogPreference_dialogLayout, C0177R.styleable.DialogPreference_android_dialogLayout, 0);
        obtainStyledAttributes.recycle();
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m776a(context, C0177R.attr.dialogPreferenceStyle, 16842897));
    }

    public DialogPreference(Context context) {
        this(context, null);
    }

    public final CharSequence mo481a() {
        return this.f11622a;
    }

    protected void mo482b() {
        PreferenceManager preferenceManager = this.f1892k;
        if (preferenceManager.f1926f != null) {
            preferenceManager.f1926f.mo3194b(this);
        }
    }
}
