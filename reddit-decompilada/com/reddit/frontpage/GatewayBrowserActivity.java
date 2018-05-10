package com.reddit.frontpage;

import android.os.Bundle;
import com.reddit.frontpage.ui.detail.web.GatewayBrowserFragment;

public class GatewayBrowserActivity extends BaseActivity {
    public final int mo7724d() {
        return C1761R.layout.activity_single_container;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            getSupportFragmentManager().a().a(C1761R.id.container, GatewayBrowserFragment.m37573a(getIntent().getStringExtra("com.reddit.extra.initial_url"), getIntent().getStringExtra("com.reddit.extra.title_override"), getIntent().getIntExtra("com.reddit.extra.color", 0))).c();
        }
    }
}
