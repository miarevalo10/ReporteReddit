package android.support.v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.app.AppCompatDelegateImplV9.C01615;
import android.support.v7.app.AppCompatDelegateImplV9.C15906;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.StandaloneActionMode;
import android.support.v7.view.SupportActionModeWrapper.CallbackWrapper;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ViewStubCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdRequest;

@RequiresApi(14)
class AppCompatDelegateImplV14 extends AppCompatDelegateImplV11 {
    private AutoNightModeManager f19469A;
    boolean f19470p = true;
    private int f19471y = -100;
    private boolean f19472z;

    final class AutoNightModeManager {
        TwilightManager f1807a;
        boolean f1808b;
        BroadcastReceiver f1809c;
        IntentFilter f1810d;
        final /* synthetic */ AppCompatDelegateImplV14 f1811e;

        class C01591 extends BroadcastReceiver {
            final /* synthetic */ AutoNightModeManager f1806a;

            C01591(AutoNightModeManager autoNightModeManager) {
                this.f1806a = autoNightModeManager;
            }

            public void onReceive(Context context, Intent intent) {
                context = this.f1806a;
                intent = context.f1807a.m1566a();
                if (intent != context.f1808b) {
                    context.f1808b = intent;
                    context.f1811e.mo425j();
                }
            }
        }

        AutoNightModeManager(AppCompatDelegateImplV14 appCompatDelegateImplV14, TwilightManager twilightManager) {
            this.f1811e = appCompatDelegateImplV14;
            this.f1807a = twilightManager;
            this.f1808b = twilightManager.m1566a();
        }

        final void m1549a() {
            if (this.f1809c != null) {
                this.f1811e.b.unregisterReceiver(this.f1809c);
                this.f1809c = null;
            }
        }
    }

    class AppCompatWindowCallbackV14 extends AppCompatWindowCallbackBase {
        final /* synthetic */ AppCompatDelegateImplV14 f16539c;

        AppCompatWindowCallbackV14(AppCompatDelegateImplV14 appCompatDelegateImplV14, Callback callback) {
            this.f16539c = appCompatDelegateImplV14;
            super(appCompatDelegateImplV14, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (this.f16539c.f19470p) {
                return m16719a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final ActionMode m16719a(ActionMode.Callback callback) {
            Object callbackWrapper = new CallbackWrapper(this.f16539c.b, callback);
            callback = this.f16539c;
            if (callback.f16559q != null) {
                callback.f16559q.mo469c();
            }
            android.support.v7.view.ActionMode.Callback actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callback, callbackWrapper);
            ActionBar a = callback.mo417a();
            if (a != null) {
                callback.f16559q = a.mo475a(actionModeCallbackWrapperV9);
            }
            if (callback.f16559q == null) {
                Context contextThemeWrapper;
                callback.m16763o();
                if (callback.f16559q != null) {
                    callback.f16559q.mo469c();
                }
                boolean z = true;
                if (callback.f16560r == null) {
                    if (callback.l) {
                        TypedValue typedValue = new TypedValue();
                        Theme theme = callback.b.getTheme();
                        theme.resolveAttribute(C0164R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Theme newTheme = callback.b.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            contextThemeWrapper = new ContextThemeWrapper(callback.b, 0);
                            contextThemeWrapper.getTheme().setTo(newTheme);
                        } else {
                            contextThemeWrapper = callback.b;
                        }
                        callback.f16560r = new ActionBarContextView(contextThemeWrapper);
                        callback.f16561s = new PopupWindow(contextThemeWrapper, null, C0164R.attr.actionModePopupWindowStyle);
                        PopupWindowCompat.m1415a(callback.f16561s, 2);
                        callback.f16561s.setContentView(callback.f16560r);
                        callback.f16561s.setWidth(-1);
                        contextThemeWrapper.getTheme().resolveAttribute(C0164R.attr.actionBarSize, typedValue, true);
                        callback.f16560r.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, contextThemeWrapper.getResources().getDisplayMetrics()));
                        callback.f16561s.setHeight(-2);
                        callback.f16562t = new C01615(callback);
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) callback.f16564v.findViewById(C0164R.id.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(callback.m10240m()));
                            callback.f16560r = (ActionBarContextView) viewStubCompat.m2388a();
                        }
                    }
                }
                if (callback.f16560r != null) {
                    callback.m16763o();
                    callback.f16560r.m10521b();
                    contextThemeWrapper = callback.f16560r.getContext();
                    ActionBarContextView actionBarContextView = callback.f16560r;
                    if (callback.f16561s != null) {
                        z = false;
                    }
                    android.support.v7.view.ActionMode standaloneActionMode = new StandaloneActionMode(contextThemeWrapper, actionBarContextView, actionModeCallbackWrapperV9, z);
                    if (actionModeCallbackWrapperV9.mo431a(standaloneActionMode, standaloneActionMode.mo466b())) {
                        standaloneActionMode.mo470d();
                        callback.f16560r.m10519a(standaloneActionMode);
                        callback.f16559q = standaloneActionMode;
                        if (callback.m16762n()) {
                            callback.f16560r.setAlpha(0.0f);
                            callback.f16563u = ViewCompat.m1254o(callback.f16560r).m1291a(1.0f);
                            callback.f16563u.m1293a(new C15906(callback));
                        } else {
                            callback.f16560r.setAlpha(1.0f);
                            callback.f16560r.setVisibility(0);
                            callback.f16560r.sendAccessibilityEvent(32);
                            if (callback.f16560r.getParent() instanceof View) {
                                ViewCompat.m1264y((View) callback.f16560r.getParent());
                            }
                        }
                        if (callback.f16561s != null) {
                            callback.c.getDecorView().post(callback.f16562t);
                        }
                    } else {
                        callback.f16559q = null;
                    }
                }
                callback.f16559q = callback.f16559q;
            }
            callback = callback.f16559q;
            if (callback != null) {
                return callbackWrapper.m10424b(callback);
            }
            return null;
        }
    }

    AppCompatDelegateImplV14(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    public final void mo3166a(Bundle bundle) {
        super.mo3166a(bundle);
        if (bundle != null && this.f19471y == -100) {
            this.f19471y = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    Callback mo4224a(Callback callback) {
        return new AppCompatWindowCallbackV14(this, callback);
    }

    public final void mo421d() {
        super.mo421d();
        mo425j();
    }

    public final void mo423e() {
        super.mo423e();
        if (this.f19469A != null) {
            this.f19469A.m1549a();
        }
    }

    public final void mo422d(int i) {
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
                if (this.f19471y != i) {
                    this.f19471y = i;
                    if (this.f19472z != 0) {
                        mo425j();
                        return;
                    }
                }
                break;
            default:
                Log.i("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
                break;
        }
    }

    int mo4225g(int i) {
        if (i == -100) {
            return -1;
        }
        if (i != 0) {
            return i;
        }
        m20735r();
        i = this.f19469A;
        i.f1808b = i.f1807a.m1566a();
        return i.f1808b != 0 ? 2 : 1;
    }

    public final void mo420b(Bundle bundle) {
        super.mo420b(bundle);
        if (this.f19471y != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f19471y);
        }
    }

    public final void mo424h() {
        super.mo424h();
        if (this.f19469A != null) {
            this.f19469A.m1549a();
        }
    }

    private void m20735r() {
        if (this.f19469A == null) {
            this.f19469A = new AutoNightModeManager(this, TwilightManager.m1565a(this.b));
        }
    }

    private boolean m20736s() {
        if (!this.f19472z || !(this.b instanceof Activity)) {
            return false;
        }
        try {
            if ((this.b.getPackageManager().getActivityInfo(new ComponentName(this.b, this.b.getClass()), 0).configChanges & AdRequest.MAX_CONTENT_URL_LENGTH) == 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }

    public final boolean mo425j() {
        int i = this.f19471y != -100 ? this.f19471y : AppCompatDelegate.f1803a;
        int g = mo4225g(i);
        boolean z = false;
        if (g != -1) {
            Resources resources = this.b.getResources();
            Configuration configuration = resources.getConfiguration();
            int i2 = configuration.uiMode & 48;
            g = g == 2 ? 32 : 16;
            if (i2 != g) {
                if (m20736s()) {
                    ((Activity) this.b).recreate();
                } else {
                    Configuration configuration2 = new Configuration(configuration);
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    configuration2.uiMode = g | (configuration2.uiMode & -49);
                    resources.updateConfiguration(configuration2, displayMetrics);
                    if (VERSION.SDK_INT < 26) {
                        ResourcesFlusher.m1557a(resources);
                    }
                }
                z = true;
            }
        }
        if (i == 0) {
            m20735r();
            AutoNightModeManager autoNightModeManager = this.f19469A;
            autoNightModeManager.m1549a();
            if (autoNightModeManager.f1809c == null) {
                autoNightModeManager.f1809c = new C01591(autoNightModeManager);
            }
            if (autoNightModeManager.f1810d == null) {
                autoNightModeManager.f1810d = new IntentFilter();
                autoNightModeManager.f1810d.addAction("android.intent.action.TIME_SET");
                autoNightModeManager.f1810d.addAction("android.intent.action.TIMEZONE_CHANGED");
                autoNightModeManager.f1810d.addAction("android.intent.action.TIME_TICK");
            }
            autoNightModeManager.f1811e.b.registerReceiver(autoNightModeManager.f1809c, autoNightModeManager.f1810d);
        }
        this.f19472z = true;
        return z;
    }
}
