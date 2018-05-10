package com.instabug.bug.view;

import com.instabug.bug.view.C0506b.C1280a;
import com.instabug.bug.view.C0506b.C1281b;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BasePresenter;

/* compiled from: BugReportingPresenter */
public class C1631f extends BasePresenter<C1281b> implements C1280a {
    public C1631f(C1281b c1281b) {
        super(c1281b);
    }

    public final void m19400a(int i) {
        if (this.view != null) {
            C1281b c1281b = (C1281b) this.view.get();
            if (c1281b != null) {
                if (i == 167) {
                    c1281b.mo4431d();
                } else if (i != 169) {
                    switch (i) {
                        case 161:
                            c1281b.mo4430c();
                            return;
                        case 162:
                            c1281b.mo4429b();
                            return;
                        default:
                            break;
                    }
                } else {
                    c1281b.finishActivity();
                }
            }
        }
    }

    public final void m19399a() {
        if (this.view != null) {
            C1281b c1281b = (C1281b) this.view.get();
            if (c1281b != null) {
                if (InstabugCore.getFeatureState(Feature.WHITE_LABELING) == State.ENABLED) {
                    c1281b.mo4428a(false);
                    return;
                }
                c1281b.mo4428a(true);
            }
        }
    }
}
