package com.instabug.library.ui.promptoptions;

import android.os.Handler;
import android.support.v4.app.Fragment;
import com.instabug.library.C0593R;
import com.instabug.library.C0645b;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.invocation.C1381b;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.ui.promptoptions.C0767b.C1399a;
import com.instabug.library.ui.promptoptions.C0767b.C1400b;
import com.instabug.library.util.PlaceHolderUtils;

/* compiled from: PromptOptionsPresenter */
public class C1668d extends BasePresenter<C1400b> implements C1399a {
    private Handler f18586a;

    /* compiled from: PromptOptionsPresenter */
    class C07691 implements Runnable {
        final /* synthetic */ C1668d f9894a;

        C07691(C1668d c1668d) {
            this.f9894a = c1668d;
        }

        public void run() {
            ((C1400b) this.f9894a.view.get()).finishActivity();
        }
    }

    C1668d(C1400b c1400b) {
        super(c1400b);
    }

    public final void m19523a() {
        if (this.view != null) {
            C1400b c1400b = (C1400b) this.view.get();
            if (c1400b != null) {
                if (this.view != null) {
                    C1400b c1400b2 = (C1400b) this.view.get();
                    if (c1400b2 != null) {
                        c1400b2.mo4073a(PlaceHolderUtils.getPlaceHolder(Key.INVOCATION_HEADER, ((Fragment) c1400b2.getViewContext()).getContext().getString(C0593R.string.instabug_str_invocation_dialog_title)));
                    }
                }
                c1400b.mo4072a();
                if ((C0645b.m8104a().m8113b(Feature.WHITE_LABELING) != State.ENABLED ? 1 : null) != null) {
                    c1400b.mo4074b();
                } else {
                    c1400b.mo4075c();
                }
            }
        }
        if (C1381b.m15431c().f15517b == InstabugInvocationEvent.SHAKE) {
            this.f18586a = new Handler();
            this.f18586a.postDelayed(new C07691(this), 10000);
        }
    }

    final void m19524b() {
        if (this.f18586a != null) {
            this.f18586a.removeCallbacksAndMessages(null);
        }
    }

    public static void m19522c() {
        if (SettingsManager.getInstance().getPreInvocationRunnable() != null) {
            SettingsManager.getInstance().getPreInvocationRunnable().run();
        }
    }
}
