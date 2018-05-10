package com.instabug.survey.ui.p031a.p035g;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.core.ui.BaseFragment;
import com.instabug.library.util.InstabugLogoProvider;
import com.instabug.survey.C0787R;
import com.instabug.survey.cache.SurveysCacheManager;
import com.instabug.survey.p027a.C1413c;
import com.instabug.survey.p029c.C0796e;
import com.instabug.survey.ui.SurveyActivity;
import com.instabug.survey.ui.p031a.C1713c;
import com.instabug.survey.ui.p031a.p035g.C0819b.C1424b;

/* compiled from: WelcomeFragment */
public class C1715a extends BaseFragment<C1673c> implements OnClickListener, C1424b {
    private TextView f19313a;
    private Button f19314b;
    private Button f19315c;
    private C1413c f19316d;

    public static C1715a m20563a(C1413c c1413c) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("survey", c1413c);
        c1413c = new C1715a();
        c1413c.setArguments(bundle);
        return c1413c;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19316d = (C1413c) getArguments().getSerializable("survey");
        this.presenter = new C1673c(this);
    }

    protected int getLayout() {
        return C0787R.layout.instabug_survey_fragment_welcome_dialog;
    }

    protected void initViews(View view, Bundle bundle) {
        this.f19313a = (TextView) findViewById(C0787R.id.ib_welcome_survey_text);
        this.f19314b = (Button) findViewById(C0787R.id.ib_welcome_survey_dismiss);
        this.f19315c = (Button) findViewById(C0787R.id.ib_welcome_survey_take_survey);
        this.f19314b.setOnClickListener(this);
        this.f19315c.setOnClickListener(this);
        this.f19315c.setBackgroundColor(Instabug.getPrimaryColor());
        this.f19315c.setTextColor(ContextCompat.m719c(getActivity(), 17170443));
        this.f19313a.setText(getString(C0787R.string.instabug_str_welcome_feedback_msg));
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((C1673c) this.presenter).m19536a();
    }

    public final void mo4084a() {
        this.rootView.findViewById(C0787R.id.instabug_pbi_container).setVisibility(8);
    }

    public final void mo4085b() {
        findViewById(C0787R.id.instabug_pbi_container).setVisibility(0);
        TextView textView = (TextView) findViewById(C0787R.id.text_view_pb);
        ImageView imageView = (ImageView) findViewById(C0787R.id.image_instabug_logo);
        if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeDark) {
            imageView.setImageBitmap(InstabugLogoProvider.getInstabugLogo());
            imageView.setColorFilter(Color.parseColor("#FFFFFF"), Mode.SRC_ATOP);
            textView.setTextColor(ContextCompat.m719c(getActivity(), 17170443));
            return;
        }
        imageView.setImageBitmap(InstabugLogoProvider.getInstabugLogo());
        imageView.setColorFilter(ContextCompat.m719c(getActivity(), C0787R.color.instabug_survey_pbi_color), Mode.SRC_ATOP);
        textView.setTextColor(ContextCompat.m719c(getActivity(), C0787R.color.instabug_survey_pbi_color));
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == C0787R.id.ib_welcome_survey_dismiss) {
            this.f19316d.m15477a();
            SurveysCacheManager.addSurvey(this.f19316d);
            SurveysCacheManager.saveCacheToDisk();
            ((SurveyActivity) getActivity()).finishActivity();
            C0796e.m8414c();
            return;
        }
        if (view == C0787R.id.ib_welcome_survey_take_survey) {
            Fragment a = getActivity().getSupportFragmentManager().mo216a(C0787R.id.instabug_fragment_container);
            if (a != null) {
                getActivity().getSupportFragmentManager().mo219a().mo193a(0, C0787R.anim.instabug_anim_slide_out_to_right).mo196a(a).mo203c();
            }
            getActivity().getSupportFragmentManager().mo219a().mo193a(C0787R.anim.instabug_anim_slide_from_right, 17432579).mo200b(C0787R.id.instabug_fragment_container, C1713c.m20546a(this.f19316d)).mo203c();
        }
    }
}
