package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.preference.Preference.BaseSavedState;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public abstract class TwoStatePreference extends Preference {
    protected boolean f11671a;
    boolean f11672b;
    private CharSequence f11673c;
    private CharSequence f11674d;
    private boolean f11675e;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C01811();
        boolean f11670a;

        static class C01811 implements Creator<SavedState> {
            C01811() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f11670a = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f11670a);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
    }

    private TwoStatePreference(Context context, AttributeSet attributeSet, byte b) {
        this(context, attributeSet, (int) (byte) 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    protected final void mo482b() {
        super.mo482b();
        boolean z = this.f11671a ^ 1;
        if (m1600a((Object) Boolean.valueOf(z))) {
            mo504f(z);
        }
    }

    public final void mo504f(boolean z) {
        boolean z2 = this.f11671a != z;
        if (z2 || !this.f11675e) {
            this.f11671a = z;
            this.f11675e = true;
            m1613d(z);
            if (z2) {
                mo487b(mo503d());
                mo3849c();
            }
        }
    }

    public final boolean mo481a() {
        return this.f11671a;
    }

    public final boolean mo503d() {
        boolean z = this.f11672b ? this.f11671a : !this.f11671a;
        if (!z) {
            if (!super.mo503d()) {
                return false;
            }
        }
        return true;
    }

    public final void m10390c(CharSequence charSequence) {
        this.f11673c = charSequence;
        if (this.f11671a != null) {
            mo3849c();
        }
    }

    public final void m10391d(CharSequence charSequence) {
        this.f11674d = charSequence;
        if (this.f11671a == null) {
            mo3849c();
        }
    }

    protected final Object mo498a(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    protected final void mo501a(boolean z, Object obj) {
        if (z) {
            z = m1616e(this.f11671a);
        } else {
            z = ((Boolean) obj).booleanValue();
        }
        mo504f(z);
    }

    protected final void m10388b(PreferenceViewHolder preferenceViewHolder) {
        m10389b(preferenceViewHolder.m10369a(16908304));
    }

    protected final void m10389b(View view) {
        if (view instanceof TextView) {
            CharSequence h;
            int i;
            TextView textView = (TextView) view;
            Object obj = 1;
            if (!this.f11671a || TextUtils.isEmpty(this.f11673c)) {
                if (!(this.f11671a || TextUtils.isEmpty(this.f11674d))) {
                    textView.setText(this.f11674d);
                }
                if (obj != null) {
                    h = mo3187h();
                    if (!TextUtils.isEmpty(h)) {
                        textView.setText(h);
                        obj = null;
                    }
                }
                i = 8;
                if (obj == null) {
                    i = 0;
                }
                if (i != textView.getVisibility()) {
                    textView.setVisibility(i);
                }
            }
            textView.setText(this.f11673c);
            obj = null;
            if (obj != null) {
                h = mo3187h();
                if (TextUtils.isEmpty(h)) {
                    textView.setText(h);
                    obj = null;
                }
            }
            i = 8;
            if (obj == null) {
                i = 0;
            }
            if (i != textView.getVisibility()) {
                textView.setVisibility(i);
            }
        }
    }

    protected final Parcelable mo502e() {
        Parcelable e = super.mo502e();
        if (this.f1902u) {
            return e;
        }
        Parcelable savedState = new SavedState(e);
        savedState.f11670a = this.f11671a;
        return savedState;
    }

    protected final void mo499a(Parcelable parcelable) {
        if (parcelable != null) {
            if (parcelable.getClass().equals(SavedState.class)) {
                SavedState savedState = (SavedState) parcelable;
                super.mo499a(savedState.getSuperState());
                mo504f(savedState.f11670a);
                return;
            }
        }
        super.mo499a(parcelable);
    }
}
