package com.instabug.survey.ui.p031a;

import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.survey.cache.SurveysCacheManager;
import com.instabug.survey.p027a.C1413c;
import com.instabug.survey.p028b.C0790b;
import com.instabug.survey.ui.p031a.C0818d.C1421a;
import com.instabug.survey.ui.p031a.C0818d.C1422b;

/* compiled from: SurveyFragmentPresenter */
public class C1672e extends BasePresenter<C1422b> implements C1421a {
    private C1413c f18592a;

    public C1672e(C1422b c1422b, C1413c c1413c) {
        super(c1422b);
        this.f18592a = c1413c;
    }

    public final void m19533a() {
        ((C1422b) this.view.get()).mo4080b(this.f18592a);
    }

    public final void m19535b() {
        if (this.view != null) {
            C1422b c1422b = (C1422b) this.view.get();
            if (c1422b != null) {
                if (InstabugCore.getFeatureState(Feature.WHITE_LABELING) == State.ENABLED) {
                    c1422b.mo4078b();
                    return;
                }
                c1422b.mo4076a();
            }
        }
    }

    public static void m19532b(C1413c c1413c) {
        c1413c.m15477a();
        SurveysCacheManager.addSurvey(c1413c);
        SurveysCacheManager.saveCacheToDisk();
    }

    public final void m19534a(C1413c c1413c) {
        c1413c.f15578h = true;
        SurveysCacheManager.addSurvey(c1413c);
        SurveysCacheManager.saveCacheToDisk();
        C0790b.m8396a().m8398a(System.currentTimeMillis());
        ((C1422b) this.view.get()).mo4081c();
    }
}
