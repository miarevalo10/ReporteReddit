package com.reddit.frontpage;

import android.os.Bundle;
import com.reddit.frontpage.ui.detail.web.WebBrowserFragment;

public class WebBrowserActivity extends BaseActivity {
    public final int mo7724d() {
        return C1761R.layout.activity_single_container;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("com.reddit.extra.initial_url");
        int intExtra = getIntent().getIntExtra("com.reddit.extra.color", 0);
        if (bundle == null) {
            getSupportFragmentManager().a().a(C1761R.id.container, WebBrowserFragment.m34989a(stringExtra, intExtra)).c();
        }
    }
}
