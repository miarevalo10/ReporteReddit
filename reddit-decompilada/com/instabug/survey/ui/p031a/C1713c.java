package com.instabug.survey.ui.p031a;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.core.ui.BaseFragment;
import com.instabug.library.ui.custom.InstabugViewPager;
import com.instabug.library.ui.custom.MaterialMenuDrawable;
import com.instabug.library.ui.custom.MaterialMenuDrawable.IconState;
import com.instabug.library.ui.custom.MaterialMenuDrawable.Stroke;
import com.instabug.library.util.InstabugLogoProvider;
import com.instabug.survey.C0787R;
import com.instabug.survey.network.service.InstabugSurveysSubmitterService;
import com.instabug.survey.p027a.C1412b;
import com.instabug.survey.p027a.C1412b.C0788a;
import com.instabug.survey.p027a.C1413c;
import com.instabug.survey.p029c.C0793b;
import com.instabug.survey.p029c.C0794c;
import com.instabug.survey.p029c.C0796e;
import com.instabug.survey.ui.SurveyActivity;
import com.instabug.survey.ui.SurveyActivity.C08054;
import com.instabug.survey.ui.p031a.C0818d.C1422b;
import com.instabug.survey.ui.p031a.p032b.C1734a;
import com.instabug.survey.ui.p031a.p033c.C1735a;
import com.instabug.survey.ui.p031a.p034d.C1736a;
import com.instabug.survey.ui.p031a.p037a.C1671a;
import com.instabug.survey.ui.p031a.p038f.C1714a;
import com.instabug.survey.ui.p031a.p039e.C1737a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: SurveyFragment */
public class C1713c extends BaseFragment<C1672e> implements OnClickListener, C0806a, C1422b {
    C1413c f19304a;
    private Button f19305b;
    private InstabugViewPager f19306c;
    private C1671a f19307d;
    private ImageView f19308e;
    private TextView f19309f;
    private MaterialMenuDrawable f19310g;
    private int f19311h = -1;
    private String f19312i = "CURRENT_QUESTION_POSITION";

    /* compiled from: SurveyFragment */
    class C08131 implements OnKeyListener {
        final /* synthetic */ C1713c f9984a;

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            return i == 4;
        }

        C08131(C1713c c1713c) {
            this.f9984a = c1713c;
        }
    }

    protected int getLayout() {
        return C0787R.layout.instabug_dialog_survey;
    }

    public static C1713c m20546a(C1413c c1413c) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("survey", c1413c);
        c1413c = new C1713c();
        c1413c.setArguments(bundle);
        return c1413c;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f19304a = (C1413c) getArguments().getSerializable("survey");
        this.presenter = new C1672e(this, this.f19304a);
    }

    protected void initViews(View view, Bundle bundle) {
        view.setOnKeyListener(new C08131(this));
        ((C1672e) this.presenter).m19535b();
        this.f19305b = (Button) view.findViewById(C0787R.id.instabug_btn_submit);
        this.f19305b.setTextColor(Instabug.getPrimaryColor());
        this.f19305b.setOnClickListener(this);
        this.f19306c = (InstabugViewPager) findViewById(C0787R.id.instabug_survey_pager);
        this.f19306c.setSwipeable(null);
        this.f19308e = (ImageView) findViewById(C0787R.id.instabug_ic_survey_close);
        this.f19310g = new MaterialMenuDrawable(getActivity(), ContextCompat.m719c(getActivity(), C0787R.color.instabug_survey_back_icon_color), Stroke.THIN);
        this.f19308e.setImageDrawable(this.f19310g.getCurrent());
        this.f19308e.setOnClickListener(this);
        if (C0794c.m8410a() != null) {
            this.f19310g.setRTLEnabled(true);
        }
        this.f19310g.setIconState(IconState.X);
        this.f19309f = (TextView) findViewById(C0787R.id.instabug_question_count_indicator);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        ((C1672e) this.presenter).m19533a();
        if (!(bundle == null || bundle.getInt(this.f19312i) == -1)) {
            this.f19311h = bundle.getInt(this.f19312i);
            if (((C1412b) this.f19304a.f15573c.get(this.f19311h)).f15569e != null && ((C1412b) this.f19304a.f15573c.get(this.f19311h)).f15569e.isEmpty() == null) {
                m20555a(true);
                return;
            }
        }
        m20555a((boolean) null);
    }

    public final void mo4076a() {
        findViewById(C0787R.id.instabug_pbi_container).setVisibility(0);
        TextView textView = (TextView) findViewById(C0787R.id.text_view_pb);
        ImageView imageView = (ImageView) findViewById(C0787R.id.image_instabug_logo);
        imageView.setImageBitmap(InstabugLogoProvider.getInstabugLogo());
        if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeDark) {
            imageView.setColorFilter(Color.parseColor("#FFFFFF"), Mode.SRC_ATOP);
            textView.setTextColor(ContextCompat.m719c(getActivity(), 17170443));
            return;
        }
        imageView.setColorFilter(ContextCompat.m719c(getActivity(), C0787R.color.instabug_survey_pbi_color), Mode.SRC_ATOP);
        textView.setTextColor(ContextCompat.m719c(getActivity(), C0787R.color.instabug_survey_pbi_color));
    }

    public final void mo4078b() {
        this.rootView.findViewById(C0787R.id.instabug_pbi_container).setVisibility(8);
    }

    private void m20547a(final int i) {
        this.f19306c.postDelayed(new Runnable(this) {
            final /* synthetic */ C1713c f9986b;

            public void run() {
                if (((C1412b) this.f9986b.f19304a.f15573c.get(i)).f15567c == C0788a.TEXT) {
                    C1737a c1737a = (C1737a) this.f9986b.f19307d.m19531c(i);
                    if (c1737a.getActivity() != null) {
                        c1737a.f19766d.requestFocus();
                        C0793b.m8409a(c1737a.getActivity(), c1737a.f19766d);
                    }
                    return;
                }
                C0793b.m8408a(this.f9986b.getActivity());
            }
        }, 200);
    }

    public void onResume() {
        super.onResume();
        m20547a(this.f19306c.getCurrentItem());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(this.f19312i, this.f19311h);
        super.onSaveInstanceState(bundle);
    }

    public final void m20555a(boolean z) {
        if (z) {
            this.f19305b.setEnabled(z);
            this.f19305b.setTextColor(Instabug.getPrimaryColor());
            return;
        }
        this.f19305b.setEnabled(z);
        this.f19305b.setTextColor(ContextCompat.m719c(getActivity(), C0787R.color.instabug_text_color_grey));
    }

    final void m20553a(int i, List<C1412b> list) {
        this.f19309f.setText(getString(C0787R.string.instabug_str_survey_counter, Integer.valueOf(i + 1), Integer.valueOf(list.size())));
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == C0787R.id.instabug_btn_submit) {
            m20551d();
            return;
        }
        if (view == C0787R.id.instabug_ic_survey_close) {
            if ((this.f19306c.getCurrentItem() == null ? 1 : null) != null) {
                C1672e.m19532b(this.f19304a);
                ((SurveyActivity) getActivity()).finishActivity();
                C0796e.m8414c();
                return;
            }
            this.f19306c.setCurrentItem(this.f19306c.getCurrentItem() - 1);
        }
    }

    private void m20551d() {
        int currentItem = this.f19306c.getCurrentItem();
        FragmentManager childFragmentManager = getChildFragmentManager();
        StringBuilder stringBuilder = new StringBuilder("android:switcher:");
        stringBuilder.append(C0787R.id.instabug_survey_pager);
        stringBuilder.append(":");
        stringBuilder.append(currentItem);
        Fragment a = childFragmentManager.mo218a(stringBuilder.toString());
        String a2 = a != null ? ((C1712b) a).mo4346a() : null;
        if (a2 != null) {
            ((C1412b) this.f19304a.f15573c.get(currentItem)).m15475a(a2);
            if (currentItem < this.f19307d.mo3684c() - 1) {
                this.f19306c.setCurrentItem(currentItem + 1, true);
                return;
            }
            C0793b.m8408a(getActivity());
            ((C1672e) this.presenter).m19534a(this.f19304a);
        }
    }

    public final void mo4081c() {
        getContext().startService(new Intent(getContext(), InstabugSurveysSubmitterService.class));
        SurveyActivity surveyActivity = (SurveyActivity) getActivity();
        if (surveyActivity.getSupportFragmentManager().mo216a(C0787R.id.instabug_fragment_container) != null) {
            surveyActivity.getSupportFragmentManager().mo219a().mo193a(0, C0787R.anim.instabug_anim_flyout_to_bottom).mo196a(surveyActivity.getSupportFragmentManager().mo216a(C0787R.id.instabug_fragment_container)).mo203c();
        }
        surveyActivity.getSupportFragmentManager().mo219a().mo193a(C0787R.anim.instabug_anim_pop_in, C0787R.anim.instabug_anim_pop_out).mo201b(C0787R.id.instabug_fragment_container, C1714a.m20562a(), "THANKS_FRAGMENT").mo203c();
        surveyActivity.f19836b = new Handler();
        surveyActivity.f19836b.postDelayed(new C08054(surveyActivity), 3000);
    }

    public final void mo4077a(C1412b c1412b) {
        ((C1412b) this.f19304a.f15573c.get(this.f19306c.getCurrentItem())).m15475a(c1412b.f15569e);
        if (this.f19306c.getCurrentItem() == this.f19307d.mo3684c() - 1) {
            m20555a(true);
        } else {
            m20551d();
        }
    }

    public final void mo4082c(C1412b c1412b) {
        ((C1412b) this.f19304a.f15573c.get(this.f19306c.getCurrentItem())).m15475a(c1412b.f15569e);
        if (this.f19306c.getCurrentItem() == this.f19307d.mo3684c() - 1) {
            m20555a(true);
        } else {
            m20551d();
        }
    }

    public final void mo4080b(final C1413c c1413c) {
        List arrayList = new ArrayList();
        Iterator it = c1413c.f15573c.iterator();
        while (it.hasNext()) {
            C1412b c1412b = (C1412b) it.next();
            if (c1412b.f15567c == C0788a.MCQ) {
                arrayList.add(C1734a.m21346a(c1412b, this));
            } else if (c1412b.f15567c == C0788a.TEXT) {
                arrayList.add(C1737a.m21359a(c1412b, this));
            } else if (c1412b.f15567c == C0788a.STAR_RATE) {
                arrayList.add(C1736a.m21356a(c1412b, this));
            } else if (c1412b.f15567c == C0788a.NPS) {
                this.f19309f.setVisibility(8);
                arrayList.add(C1735a.m21351a(c1412b, this));
            }
        }
        this.f19307d = new C1671a(getChildFragmentManager(), arrayList);
        this.f19306c.setAdapter(this.f19307d);
        if (c1413c.f15573c.size() > 1) {
            this.f19305b.setText(C0787R.string.instabug_str_survey_next);
            m20553a(0, c1413c.f15573c);
            this.f19306c.addOnPageChangeListener(new OnPageChangeListener(this) {
                final /* synthetic */ C1713c f15593b;

                public final void mo118a(int i) {
                }

                public final void mo119a(int i, float f) {
                }

                public final void mo120b(int i) {
                    this.f15593b.f19311h = i;
                    this.f15593b.m20553a(i, c1413c.f15573c);
                    if (i == 0) {
                        this.f15593b.f19310g.animateIconState(IconState.X);
                        this.f15593b.f19305b.setText(C0787R.string.instabug_str_survey_next);
                    } else if (i == this.f15593b.f19307d.mo3684c() - 1) {
                        this.f15593b.f19310g.animateIconState(IconState.ARROW);
                        this.f15593b.f19305b.setText(C0787R.string.instabug_str_action_submit);
                    } else {
                        this.f15593b.f19310g.animateIconState(IconState.ARROW);
                        this.f15593b.f19305b.setText(C0787R.string.instabug_str_survey_next);
                    }
                    if (((C1412b) c1413c.f15573c.get(i)).f15569e == null || ((C1412b) c1413c.f15573c.get(i)).f15569e.isEmpty()) {
                        this.f15593b.m20555a(false);
                    } else {
                        this.f15593b.m20555a(true);
                    }
                    this.f15593b.m20547a(i);
                }
            });
        } else {
            this.f19309f.setVisibility(8);
        }
        m20555a(false);
        this.f19311h = 0;
    }

    public final void mo4079b(C1412b c1412b) {
        if (c1412b.f15569e == null || c1412b.f15569e.length() <= null) {
            m20555a((boolean) null);
        } else {
            m20555a(true);
        }
    }

    public final void mo4083d(C1412b c1412b) {
        if (Integer.parseInt(c1412b.f15569e) > 0) {
            m20555a(true);
            ((C1412b) this.f19304a.f15573c.get(this.f19306c.getCurrentItem())).m15475a(c1412b.f15569e);
            return;
        }
        m20555a((boolean) null);
    }
}
