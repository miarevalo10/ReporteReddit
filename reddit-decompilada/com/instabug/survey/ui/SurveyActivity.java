package com.instabug.survey.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import com.instabug.library.Instabug;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseFragmentActivity;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.C0787R;
import com.instabug.survey.C1414a;
import com.instabug.survey.SurveyPlugin;
import com.instabug.survey.p027a.C1413c;
import com.instabug.survey.p029c.C0795d;
import com.instabug.survey.p029c.C0796e;
import com.instabug.survey.ui.p031a.C1713c;
import com.instabug.survey.ui.p031a.p035g.C1715a;

public class SurveyActivity extends BaseFragmentActivity implements _InstabugActivity {
    boolean f19835a = false;
    public Handler f19836b;

    class C08032 implements Runnable {
        final /* synthetic */ SurveyActivity f9970a;

        C08032(SurveyActivity surveyActivity) {
            this.f9970a = surveyActivity;
        }

        public void run() {
            this.f9970a.finish();
        }
    }

    class C08043 implements Runnable {
        final /* synthetic */ SurveyActivity f9971a;

        C08043(SurveyActivity surveyActivity) {
            this.f9971a = surveyActivity;
        }

        public void run() {
            this.f9971a.finish();
            C0796e.m8414c();
        }
    }

    class C08054 implements Runnable {
        final /* synthetic */ SurveyActivity f9972a;

        public C08054(SurveyActivity surveyActivity) {
            this.f9972a = surveyActivity;
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = r2.f9972a;	 Catch:{ Exception -> 0x0006 }
            r0.m21621a();	 Catch:{ Exception -> 0x0006 }
            return;
        L_0x0006:
            r0 = r2.f9972a;
            r0 = r0.getSupportFragmentManager();
            r0.mo226c();
            r0 = r2.f9972a;
            r0.finish();
            r0 = r2.f9972a;
            r1 = "ThanksFragment couldn't save it's state";
            com.instabug.library.util.InstabugSDKLogger.m8357e(r0, r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.ui.SurveyActivity.4.run():void");
        }
    }

    protected void initViews() {
    }

    public void onBackPressed() {
    }

    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        setTheme(C0795d.m8411a(Instabug.getTheme()));
        setContentView(C0787R.layout.instabug_activity);
        getWindow().getDecorView().setBackgroundColor(ContextCompat.m719c(this, C0787R.color.instabug_dialog_bg_color));
        findViewById(C0787R.id.instabug_fragment_container).postDelayed(new Runnable(this) {
            final /* synthetic */ SurveyActivity f9969b;

            public void run() {
                if (InstabugCore.getStartedActivitiesCount() <= 1) {
                    this.f9969b.finish();
                    return;
                }
                try {
                    if (!this.f9969b.isFinishing() && this.f9969b.f19835a) {
                        C1413c c1413c = (C1413c) this.f9969b.getIntent().getSerializableExtra("survey");
                        if (bundle == null) {
                            if (c1413c.f15572b != null) {
                                if (!String.valueOf(c1413c.f15572b).equals("null")) {
                                    this.f9969b.getSupportFragmentManager().mo219a().mo193a(C0787R.anim.instabug_anim_flyin_from_bottom, C0787R.anim.instabug_anim_flyout_to_bottom).mo200b(C0787R.id.instabug_fragment_container, C1713c.m20546a(c1413c)).mo203c();
                                }
                            }
                            this.f9969b.getSupportFragmentManager().mo219a().mo193a(C0787R.anim.instabug_anim_flyin_from_bottom, C0787R.anim.instabug_anim_flyout_to_bottom).mo200b(C0787R.id.instabug_fragment_container, C1715a.m20563a(c1413c)).mo203c();
                        }
                    }
                } catch (Exception e) {
                    StringBuilder stringBuilder = new StringBuilder("Survey has not been shown due to this error: ");
                    stringBuilder.append(e.getMessage());
                    InstabugSDKLogger.m8357e(SurveyActivity.class, stringBuilder.toString());
                }
            }
        }, 500);
    }

    protected void onResume() {
        super.onResume();
        this.f19835a = true;
        C1414a.m15478a((Context) this).f15586c = true;
        SurveyPlugin surveyPlugin = (SurveyPlugin) InstabugCore.getXPlugin(SurveyPlugin.class);
        if (surveyPlugin != null) {
            surveyPlugin.setState(1);
        }
        m21621a();
    }

    protected void onPause() {
        this.f19835a = false;
        super.onPause();
        if (this.f19836b != null) {
            this.f19836b.removeCallbacksAndMessages(null);
        }
    }

    protected int getLayout() {
        return C0787R.layout.instabug_activity;
    }

    public void finishActivity() {
        if (getSupportFragmentManager().mo216a(C0787R.id.instabug_fragment_container) != null) {
            getSupportFragmentManager().mo219a().mo193a(0, C0787R.anim.instabug_anim_flyout_to_bottom).mo196a(getSupportFragmentManager().mo216a(C0787R.id.instabug_fragment_container)).mo203c();
        }
        new Handler().postDelayed(new C08032(this), 400);
    }

    private void m21621a() {
        if (getSupportFragmentManager().mo218a("THANKS_FRAGMENT") != null) {
            getSupportFragmentManager().mo219a().mo193a(0, C0787R.anim.instabug_anim_flyout_to_bottom).mo196a(getSupportFragmentManager().mo218a("THANKS_FRAGMENT")).mo203c();
            new Handler().postDelayed(new C08043(this), 400);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C1414a.m15478a((Context) this).f15586c = false;
        SurveyPlugin surveyPlugin = (SurveyPlugin) InstabugCore.getXPlugin(SurveyPlugin.class);
        if (surveyPlugin != null) {
            surveyPlugin.setState(0);
        }
    }
}
