package android.support.v7.preference;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditTextPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private EditText f19473j;
    private CharSequence f19474k;

    protected final boolean mo4228c() {
        return true;
    }

    public static EditTextPreferenceDialogFragmentCompat m20746a(String str) {
        EditTextPreferenceDialogFragmentCompat editTextPreferenceDialogFragmentCompat = new EditTextPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        editTextPreferenceDialogFragmentCompat.setArguments(bundle);
        return editTextPreferenceDialogFragmentCompat;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f19474k = ((EditTextPreference) m19954d()).f16572g;
        } else {
            this.f19474k = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f19474k);
    }

    protected final void mo4226a(View view) {
        super.mo4226a(view);
        this.f19473j = (EditText) view.findViewById(16908291);
        if (this.f19473j == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        this.f19473j.setText(this.f19474k);
    }

    public final void mo4227b(boolean z) {
        if (z) {
            String obj = this.f19473j.getText().toString();
            if (((EditTextPreference) m19954d()).m1600a((Object) obj)) {
                ((EditTextPreference) m19954d()).mo3184a(obj);
            }
        }
    }
}
