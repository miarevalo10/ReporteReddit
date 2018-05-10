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

public class EditTextPreference extends DialogPreference {
    String f16572g;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C01671();
        String f11628a;

        static class C01671 implements Creator<SavedState> {
            C01671() {
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
            this.f11628a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f11628a);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
    }

    private EditTextPreference(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, attributeSet, i);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m776a(context, C0177R.attr.editTextPreferenceStyle, 16842898), (byte) 0);
    }

    public final void mo3184a(String str) {
        boolean d = mo503d();
        this.f16572g = str;
        m1609c(str);
        str = mo503d();
        if (str != d) {
            mo487b((boolean) str);
        }
    }

    protected final Object mo498a(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    protected final void mo501a(boolean z, Object obj) {
        mo3184a(z ? m1610d((String) this.f16572g) : (String) obj);
    }

    public final boolean mo503d() {
        if (!TextUtils.isEmpty(this.f16572g)) {
            if (!super.mo503d()) {
                return false;
            }
        }
        return true;
    }

    protected final Parcelable mo502e() {
        Parcelable e = super.mo502e();
        if (this.f1902u) {
            return e;
        }
        Parcelable savedState = new SavedState(e);
        savedState.f11628a = this.f16572g;
        return savedState;
    }

    protected final void mo499a(Parcelable parcelable) {
        if (parcelable != null) {
            if (parcelable.getClass().equals(SavedState.class)) {
                SavedState savedState = (SavedState) parcelable;
                super.mo499a(savedState.getSuperState());
                mo3184a(savedState.f11628a);
                return;
            }
        }
        super.mo499a(parcelable);
    }
}
