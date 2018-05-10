package com.instabug.library.ui.promptoptions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.instabug.library.C0593R;
import com.instabug.library.OnSdkDismissedCallback;
import com.instabug.library.OnSdkDismissedCallback.DismissType;
import com.instabug.library._InstabugActivity;
import com.instabug.library.bugreporting.model.Bug.Type;
import com.instabug.library.core.ui.BaseFragmentActivity;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.ui.promptoptions.C1711c.C0768a;

public class PromptOptionsActivity extends BaseFragmentActivity implements _InstabugActivity, C0768a {
    private boolean f19834a = false;

    public static Intent m21619a(Context context, Uri uri) {
        Intent intent = new Intent(context, PromptOptionsActivity.class);
        intent.putExtra("screenshotUri", uri);
        return intent;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (SettingsManager.getInstance().getOnSdkInvokedCallback() != null) {
            SettingsManager.getInstance().getOnSdkInvokedCallback().onSdkInvoked();
        }
    }

    protected void onResume() {
        super.onResume();
        SettingsManager.getInstance().setPromptOptionsScreenShown(true);
    }

    protected void onPause() {
        super.onPause();
        SettingsManager.getInstance().setPromptOptionsScreenShown(false);
    }

    protected int getLayout() {
        return C0593R.layout.instabug_activity;
    }

    public void finish() {
        super.finish();
        OnSdkDismissedCallback onSdkDismissedCallback = SettingsManager.getInstance().getOnSdkDismissedCallback();
        if (onSdkDismissedCallback != null && !this.f19834a) {
            onSdkDismissedCallback.onSdkDismissed(DismissType.CANCEL, Type.NOT_AVAILABLE);
        }
    }

    public final void mo4444a() {
        this.f19834a = true;
    }

    protected void initViews() {
        getSupportFragmentManager().mo219a().mo201b(C0593R.id.instabug_fragment_container, C1711c.m20533a((Uri) getIntent().getParcelableExtra("screenshotUri")), "prompt_options_fragment").mo203c();
    }
}
