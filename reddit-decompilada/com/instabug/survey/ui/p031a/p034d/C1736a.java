package com.instabug.survey.ui.p031a.p034d;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import com.instabug.survey.C0787R;
import com.instabug.survey.p027a.C1412b;
import com.instabug.survey.p029c.C0793b;
import com.instabug.survey.ui.p031a.C0806a;
import com.instabug.survey.ui.p031a.C1712b;

/* compiled from: StarRatingQuestionFragment */
public class C1736a extends C1712b implements OnRatingBarChangeListener {
    RatingBar f19765d;

    /* compiled from: StarRatingQuestionFragment */
    class C08161 implements Runnable {
        final /* synthetic */ C1736a f9988a;

        C08161(C1736a c1736a) {
            this.f9988a = c1736a;
        }

        public void run() {
            this.f9988a.b.mo4083d(this.f9988a.a);
        }
    }

    /* compiled from: StarRatingQuestionFragment */
    class C08172 implements Runnable {
        final /* synthetic */ C1736a f9989a;

        C08172(C1736a c1736a) {
            this.f9989a = c1736a;
        }

        public void run() {
            C0793b.m8408a(this.f9989a.getActivity());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.a = (C1412b) getArguments().getSerializable("survey");
    }

    protected void initViews(View view, Bundle bundle) {
        super.initViews(view, bundle);
        this.c = (TextView) view.findViewById(C0787R.id.instabug_text_view_question);
        this.f19765d = (RatingBar) view.findViewById(C0787R.id.ib_ratingbar);
        this.f19765d.setOnRatingBarChangeListener(this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.c.setText(this.a.f15566b);
    }

    public final String mo4346a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((int) this.f19765d.getRating());
        return stringBuilder.toString();
    }

    protected int getLayout() {
        return C0787R.layout.instabug_star_rating_question;
    }

    public static C1736a m21356a(C1412b c1412b, C0806a c0806a) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("survey", c1412b);
        c1412b = new C1736a();
        c1412b.setArguments(bundle);
        c1412b.m20542a(c0806a);
        return c1412b;
    }

    public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        ratingBar = this.a;
        z = new StringBuilder();
        z.append((int) f);
        ratingBar.m15475a(z.toString());
        new Handler().postDelayed(new C08161(this), 500);
    }

    public void onResume() {
        super.onResume();
        if (getResources().getConfiguration().orientation == 2) {
            new Handler().postDelayed(new C08172(this), 500);
        }
    }
}
