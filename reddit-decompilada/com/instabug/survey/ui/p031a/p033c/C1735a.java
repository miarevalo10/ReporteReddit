package com.instabug.survey.ui.p031a.p033c;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.instabug.survey.C0787R;
import com.instabug.survey.p027a.C1412b;
import com.instabug.survey.ui.custom.NPSLayout;
import com.instabug.survey.ui.custom.NPSLayout.C0821a;
import com.instabug.survey.ui.p031a.C0806a;
import com.instabug.survey.ui.p031a.C1712b;

/* compiled from: NPSQuestionFragment */
public class C1735a extends C1712b implements C0821a {
    private NPSLayout f19764d;

    /* compiled from: NPSQuestionFragment */
    class C08151 implements Runnable {
        final /* synthetic */ C1735a f9987a;

        C08151(C1735a c1735a) {
            this.f9987a = c1735a;
        }

        public void run() {
            this.f9987a.b.mo4082c(this.f9987a.a);
        }
    }

    public static C1735a m21351a(C1412b c1412b, C0806a c0806a) {
        C1735a c1735a = new C1735a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("survey", c1412b);
        c1735a.setArguments(bundle);
        c1735a.m20542a(c0806a);
        return c1735a;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.a = (C1412b) getArguments().getSerializable("survey");
    }

    protected int getLayout() {
        return C0787R.layout.instabug_dialog_nps_survey;
    }

    protected void initViews(View view, Bundle bundle) {
        super.initViews(view, bundle);
        this.c = (TextView) view.findViewById(C0787R.id.instabug_text_view_question);
        this.f19764d = (NPSLayout) view.findViewById(C0787R.id.instabug_survey_nps_layout);
        this.f19764d.setNPSClickListener(this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view = this.a;
        this.c.setText(view.f15566b);
        if (view.f15569e != null && view.f15569e.length() > null) {
            this.f19764d.setSelectedAnswer(view.f15569e);
        }
    }

    public final String mo4346a() {
        return this.a.f15569e;
    }

    public final void mo4348a(int i) {
        this.a.m15475a(String.valueOf(i));
        new Handler().postDelayed(new C08151(this), 200);
    }
}
