package android.support.v7.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.preference.DialogPreference.TargetFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public abstract class PreferenceDialogFragmentCompat extends DialogFragment implements OnClickListener {
    private DialogPreference f18859j;
    private CharSequence f18860k;
    private CharSequence f18861l;
    private CharSequence f18862m;
    private CharSequence f18863n;
    private int f18864o;
    private BitmapDrawable f18865p;
    private int f18866q;

    protected void mo4229a(Builder builder) {
    }

    public abstract void mo4227b(boolean z);

    protected boolean mo4228c() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment targetFragment = getTargetFragment();
        if (targetFragment instanceof TargetFragment) {
            TargetFragment targetFragment2 = (TargetFragment) targetFragment;
            CharSequence string = getArguments().getString("key");
            if (bundle == null) {
                this.f18859j = (DialogPreference) targetFragment2.mo3191a(string);
                this.f18860k = this.f18859j.f11622a;
                this.f18861l = this.f18859j.f11625d;
                this.f18862m = this.f18859j.f11626e;
                this.f18863n = this.f18859j.f11623b;
                this.f18864o = this.f18859j.f11627f;
                bundle = this.f18859j.f11624c;
                if (bundle != null) {
                    if (!(bundle instanceof BitmapDrawable)) {
                        Bitmap createBitmap = Bitmap.createBitmap(bundle.getIntrinsicWidth(), bundle.getIntrinsicHeight(), Config.ARGB_8888);
                        Canvas canvas = new Canvas(createBitmap);
                        bundle.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                        bundle.draw(canvas);
                        this.f18865p = new BitmapDrawable(getResources(), createBitmap);
                        return;
                    }
                }
                this.f18865p = (BitmapDrawable) bundle;
                return;
            }
            this.f18860k = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f18861l = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f18862m = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f18863n = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f18864o = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f18865p = new BitmapDrawable(getResources(), bitmap);
            }
            return;
        }
        throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f18860k);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f18861l);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f18862m);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f18863n);
        bundle.putInt("PreferenceDialogFragment.layout", this.f18864o);
        if (this.f18865p != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", this.f18865p.getBitmap());
        }
    }

    public Dialog mo3846a() {
        Context activity = getActivity();
        this.f18866q = -2;
        Builder b = new Builder(activity).m1513a(this.f18860k).m1511a(this.f18865p).m1514a(this.f18861l, (OnClickListener) this).m1520b(this.f18862m, (OnClickListener) this);
        int i = this.f18864o;
        View view = null;
        if (i != 0) {
            view = LayoutInflater.from(activity).inflate(i, null);
        }
        if (view != null) {
            mo4226a(view);
            b.m1512a(view);
        } else {
            b.m1519b(this.f18863n);
        }
        mo4229a(b);
        Dialog b2 = b.m1521b();
        if (mo4228c()) {
            b2.getWindow().setSoftInputMode(5);
        }
        return b2;
    }

    public final DialogPreference m19954d() {
        if (this.f18859j == null) {
            this.f18859j = (DialogPreference) ((TargetFragment) getTargetFragment()).mo3191a(getArguments().getString("key"));
        }
        return this.f18859j;
    }

    protected void mo4226a(View view) {
        view = view.findViewById(16908299);
        if (view != null) {
            CharSequence charSequence = this.f18863n;
            int i = 8;
            if (!TextUtils.isEmpty(charSequence)) {
                if (view instanceof TextView) {
                    ((TextView) view).setText(charSequence);
                }
                i = 0;
            }
            if (view.getVisibility() != i) {
                view.setVisibility(i);
            }
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f18866q = i;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        mo4227b(this.f18866q == -1 ? true : null);
    }
}
