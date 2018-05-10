package com.reddit.frontpage.ui.onboard;

import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.LoginEnhancements;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ClickEventBuilder;
import com.reddit.frontpage.sync.routine.AppConfigSyncRoutine;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.util.BottomCrop;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.ViewUtils;

public class WelcomeFragment extends BaseFrontpageFragment {
    @BindView
    ImageView background;
    @BindView
    View facebookButton;
    @BindView
    ProgressBar facebookProgress;
    @BindView
    View googleButton;
    @BindView
    ProgressBar googleProgress;
    @BindView
    Button loginButton;
    @BindView
    Button signupButton;
    @BindView
    TextView skipText;
    @BindView
    TextView terms;

    public String getAnalyticsScreenName() {
        return "welcome";
    }

    public final int mo7160h() {
        return C1761R.layout.fragment_welcome;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        layoutInflater = Util.m23950a((int) C1761R.color.rdt_white);
        viewGroup = Util.m23950a((int) C1761R.color.rdt_facebook_blue);
        GlideApp.a(getContext()).b(Integer.valueOf(C1761R.drawable.intro_bg)).transform(new BottomCrop()).into(this.background);
        bundle = FrontpageSettings.a().t().experiments;
        if (bundle.login_enhancements == null) {
            bundle.login_enhancements = LoginEnhancements.a();
        }
        bundle = bundle.login_enhancements;
        if (bundle.show_fb) {
            this.facebookButton.setVisibility(0);
            this.facebookButton.getBackground().setColorFilter(viewGroup, Mode.MULTIPLY);
            this.facebookProgress.getIndeterminateDrawable().setColorFilter(layoutInflater, Mode.MULTIPLY);
            m39349a(this.facebookButton, this.facebookProgress, (int) C1761R.string.error_facebook, "facebook");
        }
        if (bundle.show_google != null) {
            this.googleButton.setVisibility(0);
            this.googleButton.getBackground().setColorFilter(layoutInflater, Mode.MULTIPLY);
            m39349a(this.googleButton, this.googleProgress, (int) C1761R.string.error_google, AppConfigSyncRoutine.f28851c);
        }
        this.loginButton.setOnClickListener(new WelcomeFragment$$Lambda$0(this));
        this.signupButton.setOnClickListener(new WelcomeFragment$$Lambda$1(this));
        if (bundle.show_skip != null) {
            this.skipText.setVisibility(0);
            this.skipText.setOnClickListener(new WelcomeFragment$$Lambda$2(this));
        }
        if (!(bundle.show_google == null && bundle.show_fb == null)) {
            layoutInflater = (bundle.show_google == null || bundle.show_fb == null) ? bundle.show_fb != null ? C1761R.string.label_login_terms_facebook : C1761R.string.label_login_terms_google : C1761R.string.label_login_terms_facebook_or_google;
            this.terms.setVisibility(0);
            this.terms.setText(Html.fromHtml(getString(C1761R.string.fmt_login_terms_enhancement, new Object[]{getString(layoutInflater)})));
            this.terms.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return this.e;
    }

    private void m39349a(View view, View view2, int i, String str) {
        view.setOnClickListener(new WelcomeFragment$$Lambda$3(this, str, view2, view, i));
    }

    final /* synthetic */ void m39351a(String str, View view, View view2, int i) {
        ClickEventBuilder b = AppAnalytics.m21858b();
        b.f19954a = getAnalyticsScreenName();
        b.f19955b = str;
        b.m21825a();
        view.setVisibility(0);
        view2.setClickable(false);
        this.e.postDelayed(new WelcomeFragment$$Lambda$4(this, view, view2, i), 1000);
    }

    final /* synthetic */ void m39350a(View view, View view2, int i) {
        view.setVisibility(4);
        view2.setClickable(true);
        ViewUtils.m24059a(this.e, i, -1).a();
    }
}
