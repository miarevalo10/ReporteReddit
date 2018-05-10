package com.reddit.frontpage.ui.preferences;

import android.os.Bundle;
import android.view.MenuItem;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.IntentUtil;

public class PreferencesActivity extends BaseActivity {
    public final int mo7724d() {
        return C1761R.layout.activity_single_container_toolbar;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c().a().b(true);
        c().a().a(true);
        if (m42744f() == null) {
            getSupportFragmentManager().a().a(C1761R.id.container, new PreferencesFragment()).e();
        }
    }

    private PreferencesFragment m42744f() {
        return (PreferencesFragment) getSupportFragmentManager().a(C1761R.id.container);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void finish() {
        PreferencesFragment f = m42744f();
        if (f != null) {
            setResult(f.m37743d());
        }
        startService(IntentUtil.m23765c(this));
        super.finish();
    }
}
