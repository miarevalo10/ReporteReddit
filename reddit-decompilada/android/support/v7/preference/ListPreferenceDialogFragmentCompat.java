package android.support.v7.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AlertDialog.Builder;
import java.util.ArrayList;

public class ListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private int f19475j;
    private CharSequence[] f19476k;
    private CharSequence[] f19477l;

    class C01691 implements OnClickListener {
        final /* synthetic */ ListPreferenceDialogFragmentCompat f1866a;

        C01691(ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat) {
            this.f1866a = listPreferenceDialogFragmentCompat;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1866a.f19475j = i;
            this.f1866a.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    public static ListPreferenceDialogFragmentCompat m20751a(String str) {
        ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat = new ListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        listPreferenceDialogFragmentCompat.setArguments(bundle);
        return listPreferenceDialogFragmentCompat;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            ListPreference listPreference = (ListPreference) m19954d();
            if (listPreference.f16575g != null) {
                if (listPreference.f16576h != null) {
                    this.f19475j = listPreference.m16783b(listPreference.f16577i);
                    this.f19476k = listPreference.f16575g;
                    this.f19477l = listPreference.f16576h;
                    return;
                }
            }
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f19475j = bundle.getInt("ListPreferenceDialogFragment.index", 0);
        this.f19476k = m20753a(bundle, "ListPreferenceDialogFragment.entries");
        this.f19477l = m20753a(bundle, "ListPreferenceDialogFragment.entryValues");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f19475j);
        m20752a(bundle, "ListPreferenceDialogFragment.entries", this.f19476k);
        m20752a(bundle, "ListPreferenceDialogFragment.entryValues", this.f19477l);
    }

    private static void m20752a(Bundle bundle, String str, CharSequence[] charSequenceArr) {
        ArrayList arrayList = new ArrayList(charSequenceArr.length);
        for (CharSequence charSequence : charSequenceArr) {
            arrayList.add(charSequence.toString());
        }
        bundle.putStringArrayList(str, arrayList);
    }

    private static CharSequence[] m20753a(Bundle bundle, String str) {
        bundle = bundle.getStringArrayList(str);
        if (bundle == null) {
            return null;
        }
        return (CharSequence[]) bundle.toArray(new CharSequence[bundle.size()]);
    }

    protected final void mo4229a(Builder builder) {
        super.mo4229a(builder);
        CharSequence[] charSequenceArr = this.f19476k;
        int i = this.f19475j;
        OnClickListener c01691 = new C01691(this);
        builder.f1801a.f1749s = charSequenceArr;
        builder.f1801a.f1751u = c01691;
        builder.f1801a.f1724F = i;
        builder.f1801a.f1723E = true;
        builder.m1514a(null, null);
    }

    public final void mo4227b(boolean z) {
        ListPreference listPreference = (ListPreference) m19954d();
        if (z && this.f19475j < false) {
            String charSequence = this.f19477l[this.f19475j].toString();
            if (listPreference.m1600a((Object) charSequence)) {
                listPreference.mo3184a(charSequence);
            }
        }
    }
}
