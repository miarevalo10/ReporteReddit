package com.instabug.bug.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.instabug.bug.BugPlugin;
import com.instabug.bug.C0465R;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseFragmentActivity;

public class SuccessActivity extends BaseFragmentActivity implements OnClickListener, _InstabugActivity {

    class C04891 implements Runnable {
        final /* synthetic */ SuccessActivity f9155a;

        C04891(SuccessActivity successActivity) {
            this.f9155a = successActivity;
        }

        public void run() {
            this.f9155a.finishActivity();
        }
    }

    public static Intent m21610a(Context context) {
        return new Intent(context, SuccessActivity.class);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new Handler().postDelayed(new C04891(this), 3000);
    }

    protected int getLayout() {
        return C0465R.layout.instabug_activity_bug_reporting;
    }

    public void onClick(View view) {
        finish();
    }

    public void onStart() {
        super.onStart();
        BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (bugPlugin != null) {
            bugPlugin.setState(1);
        }
    }

    public void onStop() {
        super.onStop();
        BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (bugPlugin != null && bugPlugin.getState() != 2) {
            bugPlugin.setState(0);
        }
    }

    protected void initViews() {
        getSupportFragmentManager().mo219a().mo200b(C0465R.id.instabug_fragment_container, new C1708g()).mo203c();
    }
}
