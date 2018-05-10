package com.reddit.frontpage;

import android.os.Bundle;
import android.view.MenuItem;
import com.reddit.frontpage.ui.AcknowledgementsFragment;

public class AcknowledgementsActivity extends BaseActivity {
    public final int mo7724d() {
        return C1761R.layout.activity_single_container_toolbar;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c().a().b(true);
        c().a().a(true);
        if (bundle == null) {
            getSupportFragmentManager().a().a(C1761R.id.container, AcknowledgementsFragment.m34892a(), "acknowledgements").c();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
