package com.instabug.survey.ui.p031a.p032b;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import com.instabug.library.util.OrientationUtils;
import com.instabug.survey.C0787R;
import com.instabug.survey.p027a.C1412b;
import com.instabug.survey.p029c.C0793b;
import com.instabug.survey.ui.p031a.C0806a;
import com.instabug.survey.ui.p031a.C1712b;
import com.instabug.survey.ui.p031a.p032b.C0812b.C0810a;

/* compiled from: MCQQuestionFragment */
public class C1734a extends C1712b implements C0810a {
    C0812b f19762d;
    GridView f19763e;

    /* compiled from: MCQQuestionFragment */
    class C08081 implements Runnable {
        final /* synthetic */ C1734a f9974a;

        C08081(C1734a c1734a) {
            this.f9974a = c1734a;
        }

        public void run() {
            this.f9974a.b.mo4077a(this.f9974a.a);
        }
    }

    protected int getLayout() {
        return C0787R.layout.instabug_dialog_mcq_survey;
    }

    public static C1734a m21346a(C1412b c1412b, C0806a c0806a) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("survey", c1412b);
        c1412b = new C1734a();
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
        this.f19763e = (GridView) view.findViewById(C0787R.id.instabug_survey_mcq_grid_view);
        m20543b();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        view = this.a;
        this.c.setText(view.f15566b);
        if (OrientationUtils.isInLandscape(getActivity())) {
            this.f19763e.setNumColumns(2);
        }
        if (view.f15568d.size() % 3 != 0) {
            if (view.f15568d.size() != 1) {
                for (int i = 0; i < view.f15568d.size(); i++) {
                    if (((String) view.f15568d.get(i)).length() > 60) {
                        this.f19763e.setNumColumns(1);
                    }
                }
                this.f19762d = new C0812b(getActivity(), view, this);
                this.f19763e.setAdapter(this.f19762d);
            }
        }
        this.f19763e.setNumColumns(1);
        this.f19762d = new C0812b(getActivity(), view, this);
        this.f19763e.setAdapter(this.f19762d);
    }

    public final String mo4346a() {
        C0793b.m8408a(getActivity());
        if (this.f19762d != null && this.f19762d.m8438a() != null) {
            return this.f19762d.m8438a();
        }
        Toast.makeText(getContext(), getString(C0787R.string.instabug_str_error_survey_without_answer), 0).show();
        return null;
    }

    public final void mo4347a(String str) {
        this.a.m15475a(str);
        new Handler().postDelayed(new C08081(this), 500);
    }
}
