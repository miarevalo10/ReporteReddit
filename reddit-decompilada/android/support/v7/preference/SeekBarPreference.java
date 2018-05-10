package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.preference.Preference.BaseSavedState;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.OnKeyListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekBarPreference extends Preference {
    private OnSeekBarChangeListener f11659C;
    private OnKeyListener f11660D;
    private int f11661a;
    private int f11662b;
    private int f11663c;
    private int f11664d;
    private boolean f11665e;
    private SeekBar f11666f;
    private TextView f11667g;
    private boolean f11668h;
    private boolean f11669i;

    class C01781 implements OnSeekBarChangeListener {
        final /* synthetic */ SeekBarPreference f1935a;

        C01781(SeekBarPreference seekBarPreference) {
            this.f1935a = seekBarPreference;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z && this.f1935a.f11665e == 0) {
                SeekBarPreference.m10371a(this.f1935a, seekBar);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            this.f1935a.f11665e = true;
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f1935a.f11665e = false;
            if (seekBar.getProgress() + this.f1935a.f11662b != this.f1935a.f11661a) {
                SeekBarPreference.m10371a(this.f1935a, seekBar);
            }
        }
    }

    class C01792 implements OnKeyListener {
        final /* synthetic */ SeekBarPreference f1936a;

        C01792(SeekBarPreference seekBarPreference) {
            this.f1936a = seekBarPreference;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onKey(android.view.View r2, int r3, android.view.KeyEvent r4) {
            /*
            r1 = this;
            r2 = r4.getAction();
            r0 = 0;
            if (r2 == 0) goto L_0x0008;
        L_0x0007:
            return r0;
        L_0x0008:
            r2 = r1.f1936a;
            r2 = r2.f11668h;
            if (r2 != 0) goto L_0x0019;
        L_0x0010:
            r2 = 21;
            if (r3 == r2) goto L_0x0018;
        L_0x0014:
            r2 = 22;
            if (r3 != r2) goto L_0x0019;
        L_0x0018:
            return r0;
        L_0x0019:
            r2 = 23;
            if (r3 == r2) goto L_0x003d;
        L_0x001d:
            r2 = 66;
            if (r3 != r2) goto L_0x0022;
        L_0x0021:
            goto L_0x003d;
        L_0x0022:
            r2 = r1.f1936a;
            r2 = r2.f11666f;
            if (r2 != 0) goto L_0x0032;
        L_0x002a:
            r2 = "SeekBarPreference";
            r3 = "SeekBar view is null and hence cannot be adjusted.";
            android.util.Log.e(r2, r3);
            return r0;
        L_0x0032:
            r2 = r1.f1936a;
            r2 = r2.f11666f;
            r2 = r2.onKeyDown(r3, r4);
            return r2;
        L_0x003d:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.preference.SeekBarPreference.2.onKey(android.view.View, int, android.view.KeyEvent):boolean");
        }
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C01801();
        int f11656a;
        int f11657b;
        int f11658c;

        static class C01801 implements Creator<SavedState> {
            C01801() {
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
            this.f11656a = parcel.readInt();
            this.f11657b = parcel.readInt();
            this.f11658c = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f11656a);
            parcel.writeInt(this.f11657b);
            parcel.writeInt(this.f11658c);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private SeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        this.f11659C = new C01781(this);
        this.f11660D = new C01792(this);
        context = context.obtainStyledAttributes(attributeSet, C0177R.styleable.SeekBarPreference, i, 0);
        this.f11662b = context.getInt(C0177R.styleable.SeekBarPreference_min, 0);
        attributeSet = context.getInt(C0177R.styleable.SeekBarPreference_android_max, 100);
        if (attributeSet < this.f11662b) {
            attributeSet = this.f11662b;
        }
        if (attributeSet != this.f11663c) {
            this.f11663c = attributeSet;
            mo3849c();
        }
        attributeSet = context.getInt(C0177R.styleable.SeekBarPreference_seekBarIncrement, 0);
        if (attributeSet != this.f11664d) {
            this.f11664d = Math.min(this.f11663c - this.f11662b, Math.abs(attributeSet));
            mo3849c();
        }
        this.f11668h = context.getBoolean(C0177R.styleable.SeekBarPreference_adjustable, true);
        this.f11669i = context.getBoolean(C0177R.styleable.SeekBarPreference_showSeekBarValue, true);
        context.recycle();
    }

    private SeekBarPreference(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, attributeSet, i);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0177R.attr.seekBarPreferenceStyle, (byte) 0);
    }

    public final void mo500a(PreferenceViewHolder preferenceViewHolder) {
        super.mo500a(preferenceViewHolder);
        preferenceViewHolder.c.setOnKeyListener(this.f11660D);
        this.f11666f = (SeekBar) preferenceViewHolder.m10369a(C0177R.id.seekbar);
        this.f11667g = (TextView) preferenceViewHolder.m10369a(C0177R.id.seekbar_value);
        if (this.f11669i != null) {
            this.f11667g.setVisibility(0);
        } else {
            this.f11667g.setVisibility(8);
            this.f11667g = null;
        }
        if (this.f11666f == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        this.f11666f.setOnSeekBarChangeListener(this.f11659C);
        this.f11666f.setMax(this.f11663c - this.f11662b);
        if (this.f11664d != null) {
            this.f11666f.setKeyProgressIncrement(this.f11664d);
        } else {
            this.f11664d = this.f11666f.getKeyProgressIncrement();
        }
        this.f11666f.setProgress(this.f11661a - this.f11662b);
        if (this.f11667g != null) {
            this.f11667g.setText(String.valueOf(this.f11661a));
        }
        this.f11666f.setEnabled(mo3190j());
    }

    protected final void mo501a(boolean z, Object obj) {
        int e;
        if (z) {
            e = m1614e((int) this.f11661a);
        } else {
            e = ((Integer) obj).intValue();
        }
        m10370a(e, true);
    }

    protected final Object mo498a(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    private void m10370a(int i, boolean z) {
        if (i < this.f11662b) {
            i = this.f11662b;
        }
        if (i > this.f11663c) {
            i = this.f11663c;
        }
        if (i != this.f11661a) {
            this.f11661a = i;
            if (this.f11667g != null) {
                this.f11667g.setText(String.valueOf(this.f11661a));
            }
            m1612d(i);
            if (z) {
                mo3849c();
            }
        }
    }

    protected final Parcelable mo502e() {
        Parcelable e = super.mo502e();
        if (this.f1902u) {
            return e;
        }
        Parcelable savedState = new SavedState(e);
        savedState.f11656a = this.f11661a;
        savedState.f11657b = this.f11662b;
        savedState.f11658c = this.f11663c;
        return savedState;
    }

    protected final void mo499a(Parcelable parcelable) {
        if (parcelable.getClass().equals(SavedState.class)) {
            SavedState savedState = (SavedState) parcelable;
            super.mo499a(savedState.getSuperState());
            this.f11661a = savedState.f11656a;
            this.f11662b = savedState.f11657b;
            this.f11663c = savedState.f11658c;
            mo3849c();
            return;
        }
        super.mo499a(parcelable);
    }

    static /* synthetic */ void m10371a(SeekBarPreference seekBarPreference, SeekBar seekBar) {
        int progress = seekBarPreference.f11662b + seekBar.getProgress();
        if (progress != seekBarPreference.f11661a) {
            if (seekBarPreference.m1600a((Object) Integer.valueOf(progress))) {
                seekBarPreference.m10370a(progress, (boolean) null);
                return;
            }
            seekBar.setProgress(seekBarPreference.f11661a - seekBarPreference.f11662b);
        }
    }
}
