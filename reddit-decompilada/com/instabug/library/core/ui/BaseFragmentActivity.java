package com.instabug.library.core.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import com.instabug.library.C0593R;
import com.instabug.library.Instabug;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.ui.BaseContract.Presenter;
import com.instabug.library.core.ui.BaseContract.View;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.InstabugThemeResolver;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.StatusBarUtils;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({"UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD"})
public abstract class BaseFragmentActivity<P extends Presenter> extends FragmentActivity implements _InstabugActivity, View<FragmentActivity> {
    protected P presenter;

    public abstract int getLayout();

    public FragmentActivity getViewContext() {
        return this;
    }

    public abstract void initViews();

    public void onCreate(Bundle bundle) {
        InstabugSDKLogger.m8359i(this, "onCreate called");
        StatusBarUtils.setStatusBar(this);
        LocaleUtils.setLocale(this, Instabug.getLocale(this));
        super.onCreate(bundle);
        setTheme(InstabugThemeResolver.resolveTheme(SettingsManager.getInstance().getTheme()));
        setContentView(getLayout());
        initViews();
        getWindow().getDecorView().setId(C0593R.id.instabug_decor_view);
    }

    public void onStart() {
        InstabugSDKLogger.m8359i(this, "onStart called");
        super.onStart();
    }

    public void onResume() {
        super.onResume();
        InstabugSDKLogger.m8356d(this, "onResume(),  SDK Invoking State Changed: true");
        Intent intent = new Intent();
        intent.setAction("SDK invoked");
        intent.putExtra("SDK invoking state", true);
        LocalBroadcastManager.m744a((Context) this).m748a(intent);
    }

    public void onPause() {
        super.onPause();
        InstabugSDKLogger.m8356d(this, "onPause(),  SDK Invoking State Changed: false");
        Intent intent = new Intent();
        intent.setAction("SDK invoked");
        intent.putExtra("SDK invoking state", false);
        LocalBroadcastManager.m744a((Context) this).m748a(intent);
    }

    public void onStop() {
        InstabugSDKLogger.m8359i(this, "onStop called");
        super.onStop();
    }

    public void onDestroy() {
        InstabugSDKLogger.m8359i(this, "onDestroy called");
        super.onDestroy();
    }

    public void finishActivity() {
        finish();
    }
}
