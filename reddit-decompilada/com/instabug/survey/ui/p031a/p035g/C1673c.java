package com.instabug.survey.ui.p031a.p035g;

import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.survey.ui.p031a.p035g.C0819b.C1423a;
import com.instabug.survey.ui.p031a.p035g.C0819b.C1424b;

/* compiled from: WelcomeFragmentPresenter */
class C1673c extends BasePresenter<C1424b> implements C1423a {
    public C1673c(C1424b c1424b) {
        super(c1424b);
    }

    public final void m19536a() {
        if (this.view != null) {
            C1424b c1424b = (C1424b) this.view.get();
            if (c1424b != null) {
                if (InstabugCore.getFeatureState(Feature.WHITE_LABELING) == State.ENABLED) {
                    c1424b.mo4084a();
                    return;
                }
                c1424b.mo4085b();
            }
        }
    }
}
