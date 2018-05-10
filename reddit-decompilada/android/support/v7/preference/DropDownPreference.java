package android.support.v7.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DropDownPreference extends ListPreference {
    private final Context f18855C;
    private final ArrayAdapter f18856D;
    private Spinner f18857E;
    private final OnItemSelectedListener f18858F;

    class C01661 implements OnItemSelectedListener {
        final /* synthetic */ DropDownPreference f1865a;

        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        C01661(DropDownPreference dropDownPreference) {
            this.f1865a = dropDownPreference;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                adapterView = this.f1865a.f16576h[i].toString();
                if (adapterView.equals(this.f1865a.f16577i) == null && this.f1865a.m1600a((Object) adapterView) != null) {
                    this.f1865a.mo3184a((String) adapterView);
                }
            }
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0177R.attr.dropdownPreferenceStyle);
    }

    private DropDownPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private DropDownPreference(Context context, AttributeSet attributeSet, int i, byte b) {
        super(context, attributeSet, i, (byte) 0);
        this.f18858F = new C01661(this);
        this.f18855C = context;
        this.f18856D = new ArrayAdapter(this.f18855C, 17367049);
        m19944o();
    }

    protected final void mo482b() {
        this.f18857E.performClick();
    }

    private void m19944o() {
        this.f18856D.clear();
        if (this.f16575g != null) {
            for (CharSequence charSequence : this.f16575g) {
                this.f18856D.add(charSequence.toString());
            }
        }
    }

    protected final void mo3849c() {
        super.mo3849c();
        this.f18856D.notifyDataSetChanged();
    }

    public final void mo500a(PreferenceViewHolder preferenceViewHolder) {
        int length;
        this.f18857E = (Spinner) preferenceViewHolder.c.findViewById(C0177R.id.spinner);
        this.f18857E.setAdapter(this.f18856D);
        this.f18857E.setOnItemSelectedListener(this.f18858F);
        Spinner spinner = this.f18857E;
        String str = this.f16577i;
        CharSequence[] charSequenceArr = this.f16576h;
        if (!(str == null || charSequenceArr == null)) {
            length = charSequenceArr.length - 1;
            while (length >= 0) {
                if (charSequenceArr[length].equals(str)) {
                    break;
                }
                length--;
            }
        }
        length = -1;
        spinner.setSelection(length);
        super.mo500a(preferenceViewHolder);
    }

    public final void mo3848a(int i) {
        mo3184a((String) this.f16576h[i].toString());
    }
}
