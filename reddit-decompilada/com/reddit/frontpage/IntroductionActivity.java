package com.reddit.frontpage;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.frontpage.ui.onboard.WelcomeFragment;
import timber.log.Timber;

public class IntroductionActivity extends BaseActivity {
    public final int mo7724d() {
        return C1761R.layout.activity_single_container;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Timber.b("IntroductionActivity", new Object[0]);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setSharedElementsUseOverlay(false);
        }
        InternalSettings.a().a(true);
        if (bundle == null) {
            getSupportFragmentManager().a().a(C1761R.id.container, new WelcomeFragment(), "onboard").c();
        }
    }
}
