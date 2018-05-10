package com.reddit.frontpage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import com.livefront.bridge.Bridge;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.commons.analytics.outboundlinks.OutboundLinkTracker;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.MenuUtil;
import com.reddit.frontpage.util.PushUtil;
import com.reddit.frontpage.util.UpgradeUtil;
import com.reddit.frontpage.util.Util;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.ArrayList;
import java.util.Iterator;
import timber.log.Timber;

public abstract class BaseActivity extends RedditThemedActivity {
    private static final Subject<Boolean> f40725d = PublishSubject.create();
    Toolbar f40726a;
    public boolean f40727b;
    BroadcastReceiver f40728c = new C17581(this);
    private ArrayList<OnBackPressedListener> f40729h;
    private long f40730i = 0;

    class C17581 extends BroadcastReceiver {
        final /* synthetic */ BaseActivity f19867a;

        C17581(BaseActivity baseActivity) {
            this.f19867a = baseActivity;
        }

        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("com.reddit.extra.is_sign_up", false);
            intent = intent.getBooleanExtra("com.reddit.extra.clear_backstack", false);
            if (booleanExtra) {
                FrontpageSettings a = FrontpageSettings.a();
                SharedPreferences sharedPreferences = FrontpageApplication.f27402a.getSharedPreferences(String.format("com.reddit.frontpage.settings.%s", new Object[]{"a.non.ymous"}), 0);
                a.a(sharedPreferences.getBoolean("com.reddit.mobile.disable_preview_images", false));
                a.a(sharedPreferences.getBoolean("com.reddit.pref.compact_listing_view", false), false);
                a.b(sharedPreferences.getBoolean("com.reddit.pref.night_mode", false));
                a.e(sharedPreferences.getBoolean("com.reddit.pref.blur_nsfw", true));
                a.a(sharedPreferences.getString("com.reddit.pref.autoplay", Util.m24027f((int) C1761R.string.option_value_always)));
                a.d(sharedPreferences.getString("com.reddit.pref.base_uri", Util.m24027f((int) C1761R.string.base_uri_default)));
                a.e(sharedPreferences.getString("com.reddit.pref.gateway_uri", Util.m24027f((int) C1761R.string.gateway_uri_default)));
                a.g(sharedPreferences.getBoolean("com.reddit.pref.dummy_upcoming_event", false));
            }
            this.f19867a.finish();
            if (intent != null) {
                context = IntentUtil.m23751a(context, true);
                context.putExtra("com.reddit.extra.is_sign_up", booleanExtra);
                this.f19867a.setIntent(context);
                this.f19867a.startActivity(context);
                return;
            }
            intent = this.f19867a.getIntent();
            intent.putExtra("com.reddit.extra.is_sign_up", booleanExtra);
            this.f19867a.setIntent(intent);
            IntentUtil.m23755a(context, intent);
        }
    }

    public interface OnBackPressedListener {
        boolean mo4975a();
    }

    public abstract int mo7724d();

    public static Subject<Boolean> m42469e() {
        return f40725d;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(mo7724d());
        this.f40729h = new ArrayList();
        this.f40726a = (Toolbar) findViewById(C1761R.id.toolbar);
        if (this.f40726a != null) {
            a(this.f40726a);
        }
        LocalBroadcastManager.a(this).a(this.f40728c, new IntentFilter("com.reddit.SESSION_CHANGED"));
    }

    protected void onResume() {
        super.onResume();
        this.f40727b = false;
        if (UpgradeUtil.m23947d()) {
            RedditAlertDialog.m23311a((Activity) this).m23323a();
        }
        PushUtil.m23875b();
    }

    protected void onDestroy() {
        LocalBroadcastManager.a(this).a(this.f40728c);
        super.onDestroy();
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuUtil.m23812a(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bridge.b(this, bundle);
    }

    @SuppressLint({"RestrictedApi"})
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3137) {
            OutboundLinkTracker.m21951a();
        }
        SessionManager.b().a(i, i2, intent);
        if (getSupportFragmentManager().f() != null) {
            for (Fragment fragment : getSupportFragmentManager().f()) {
                if (!(fragment == null || fragment.isDetached() || fragment.isRemoving())) {
                    fragment.onActivityResult(i, i2, intent);
                }
            }
        }
    }

    public final void m42470a(OnBackPressedListener onBackPressedListener) {
        this.f40729h.add(onBackPressedListener);
    }

    public final void m42471b(OnBackPressedListener onBackPressedListener) {
        this.f40729h.remove(onBackPressedListener);
    }

    public void onBackPressed() {
        Iterator it = this.f40729h.iterator();
        int i = 0;
        while (it.hasNext()) {
            OnBackPressedListener onBackPressedListener = (OnBackPressedListener) it.next();
            StringBuilder stringBuilder = new StringBuilder("onbackpressed ");
            stringBuilder.append(onBackPressedListener.getClass().getName());
            Timber.b(stringBuilder.toString(), new Object[0]);
            if (onBackPressedListener.mo4975a()) {
                i = 1;
            }
        }
        if (i == 0) {
            Timber.b("super onbackpressed", new Object[0]);
            super.onBackPressed();
            overridePendingTransition(C1761R.anim.fade_in, C1761R.anim.fade_out);
        }
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(C1761R.anim.fade_in, C1761R.anim.fade_out);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(C1761R.anim.fade_in, C1761R.anim.fade_out);
    }

    public void onUserInteraction() {
        this.f40730i = System.currentTimeMillis();
        super.onUserInteraction();
    }

    protected void onUserLeaveHint() {
        long currentTimeMillis = System.currentTimeMillis() - this.f40730i;
        super.onUserLeaveHint();
        if (currentTimeMillis < 100) {
            this.f40727b = true;
            f40725d.onNext(Boolean.valueOf(true));
        }
    }
}
