package com.instabug.survey.ui.p031a.p039e;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.instabug.survey.C0787R;
import com.instabug.survey.p027a.C1412b;
import com.instabug.survey.ui.p031a.C0806a;
import com.instabug.survey.ui.p031a.C1712b;

/* compiled from: TextQuestionFragment */
public class C1737a extends C1712b implements TextWatcher {
    public EditText f19766d;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    protected int getLayout() {
        return C0787R.layout.instabug_dialog_text_survey;
    }

    public static C1737a m21359a(C1412b c1412b, C0806a c0806a) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("survey", c1412b);
        c1412b = new C1737a();
        c1412b.setArguments(bundle);
        c1412b.m20542a(c0806a);
        return c1412b;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.a = (C1412b) getArguments().getSerializable("survey");
    }

    protected void initViews(View view, Bundle bundle) {
        super.initViews(view, bundle);
        this.c = (TextView) view.findViewById(C0787R.id.instabug_text_view_question);
        this.f19766d = (EditText) view.findViewById(C0787R.id.instabug_edit_text_answer);
        m20543b();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.c.setText(this.a.f15566b);
        this.f19766d.setHint(getContext().getString(C0787R.string.instabug_str_hint_enter_your_answer));
        this.f19766d.addTextChangedListener(this);
    }

    public final String mo4346a() {
        if (!this.f19766d.getText().toString().trim().equals("")) {
            return this.f19766d.getText().toString();
        }
        Toast.makeText(getContext(), getString(C0787R.string.instabug_str_error_survey_without_answer), 0).show();
        return null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f19766d.removeTextChangedListener(this);
    }

    public void afterTextChanged(Editable editable) {
        this.a.m15475a(editable.toString());
        this.b.mo4079b(this.a);
    }
}
