package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.preference.Preference.BaseSavedState;
import android.text.TextUtils;
import android.util.AttributeSet;

public class ListPreference extends DialogPreference {
    private String f16573C;
    private boolean f16574D;
    public CharSequence[] f16575g;
    CharSequence[] f16576h;
    String f16577i;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C01681();
        String f11629a;

        static class C01681 implements Creator<SavedState> {
            C01681() {
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
            this.f11629a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f11629a);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0177R.styleable.ListPreference, i, i2);
        this.f16575g = TypedArrayUtils.m791e(obtainStyledAttributes, C0177R.styleable.ListPreference_entries, C0177R.styleable.ListPreference_android_entries);
        this.f16576h = TypedArrayUtils.m791e(obtainStyledAttributes, C0177R.styleable.ListPreference_entryValues, C0177R.styleable.ListPreference_android_entryValues);
        obtainStyledAttributes.recycle();
        context = context.obtainStyledAttributes(attributeSet, C0177R.styleable.Preference, i, i2);
        this.f16573C = TypedArrayUtils.m789c(context, C0177R.styleable.Preference_summary, C0177R.styleable.Preference_android_summary);
        context.recycle();
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m776a(context, C0177R.attr.dialogPreferenceStyle, 16842897));
    }

    public ListPreference(Context context) {
        this(context, null);
    }

    public final CharSequence[] mo488f() {
        return this.f16575g;
    }

    public final CharSequence[] mo3186g() {
        return this.f16576h;
    }

    public final void mo3184a(String str) {
        int equals = TextUtils.equals(this.f16577i, str) ^ 1;
        if (equals != 0 || !this.f16574D) {
            this.f16577i = str;
            this.f16574D = true;
            m1609c(str);
            if (equals != 0) {
                mo3849c();
            }
        }
    }

    public final void mo3185a(CharSequence charSequence) {
        super.mo3185a(charSequence);
        if (charSequence != null || this.f16573C == null) {
            if (!(charSequence == null || charSequence.equals(this.f16573C))) {
                this.f16573C = charSequence.toString();
            }
            return;
        }
        this.f16573C = null;
    }

    public void mo3848a(int i) {
        if (this.f16576h != null) {
            mo3184a(this.f16576h[i].toString());
        }
    }

    public final String m16788i() {
        return this.f16577i;
    }

    public final int m16783b(String str) {
        if (!(str == null || this.f16576h == null)) {
            for (int length = this.f16576h.length - 1; length >= 0; length--) {
                if (this.f16576h[length].equals(str)) {
                    return length;
                }
            }
        }
        return -1;
    }

    protected final Object mo498a(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    protected final void mo501a(boolean z, Object obj) {
        mo3184a(z ? m1610d((String) this.f16577i) : (String) obj);
    }

    protected final Parcelable mo502e() {
        Parcelable e = super.mo502e();
        if (this.f1902u) {
            return e;
        }
        Parcelable savedState = new SavedState(e);
        savedState.f11629a = this.f16577i;
        return savedState;
    }

    protected final void mo499a(Parcelable parcelable) {
        if (parcelable != null) {
            if (parcelable.getClass().equals(SavedState.class)) {
                SavedState savedState = (SavedState) parcelable;
                super.mo499a(savedState.getSuperState());
                mo3184a(savedState.f11629a);
                return;
            }
        }
        super.mo499a(parcelable);
    }

    public final CharSequence mo3187h() {
        int b = m16783b(this.f16577i);
        String str = (b < 0 || this.f16575g == null) ? null : this.f16575g[b];
        if (this.f16573C == null) {
            return super.mo3187h();
        }
        String str2 = this.f16573C;
        Object[] objArr = new Object[1];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        return String.format(str2, objArr);
    }
}
