package android.support.v7.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.preference.internal.AbstractMultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MultiSelectListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private Set<String> f19478j = new HashSet();
    private boolean f19479k;
    private CharSequence[] f19480l;
    private CharSequence[] f19481m;

    class C01701 implements OnMultiChoiceClickListener {
        final /* synthetic */ MultiSelectListPreferenceDialogFragmentCompat f1867a;

        C01701(MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat) {
            this.f1867a = multiSelectListPreferenceDialogFragmentCompat;
        }

        public void onClick(DialogInterface dialogInterface, int i, boolean z) {
            if (z) {
                this.f1867a.f19479k = this.f1867a.f19478j.add(this.f1867a.f19481m[i].toString()) | this.f1867a.f19479k;
                return;
            }
            this.f1867a.f19479k = this.f1867a.f19478j.remove(this.f1867a.f19481m[i].toString()) | this.f1867a.f19479k;
        }
    }

    public static MultiSelectListPreferenceDialogFragmentCompat m20756a(String str) {
        MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = new MultiSelectListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragmentCompat.setArguments(bundle);
        return multiSelectListPreferenceDialogFragmentCompat;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            AbstractMultiSelectListPreference abstractMultiSelectListPreference = (AbstractMultiSelectListPreference) m19954d();
            if (abstractMultiSelectListPreference.mo488f() != null) {
                if (abstractMultiSelectListPreference.m16810i() != null) {
                    this.f19478j.clear();
                    this.f19478j.addAll(abstractMultiSelectListPreference.mo3186g());
                    this.f19479k = false;
                    this.f19480l = abstractMultiSelectListPreference.mo488f();
                    this.f19481m = abstractMultiSelectListPreference.m16810i();
                    return;
                }
            }
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.f19478j.clear();
        this.f19478j.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.f19479k = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.f19480l = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.f19481m = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList(this.f19478j));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f19479k);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f19480l);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.f19481m);
    }

    protected final void mo4229a(Builder builder) {
        super.mo4229a(builder);
        int length = this.f19481m.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.f19478j.contains(this.f19481m[i].toString());
        }
        CharSequence[] charSequenceArr = this.f19480l;
        OnMultiChoiceClickListener c01701 = new C01701(this);
        builder.f1801a.f1749s = charSequenceArr;
        builder.f1801a.f1725G = c01701;
        builder.f1801a.f1721C = zArr;
        builder.f1801a.f1722D = true;
    }

    public final void mo4227b(boolean z) {
        AbstractMultiSelectListPreference abstractMultiSelectListPreference = (AbstractMultiSelectListPreference) m19954d();
        if (z && this.f19479k) {
            abstractMultiSelectListPreference.m1600a((Object) this.f19478j);
        }
        this.f19479k = false;
    }
}
