package android.support.v7.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder.SupportParentable;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public class AppCompatActivity extends FragmentActivity implements SupportParentable, AppCompatCallback {
    private AppCompatDelegate f19791a;
    private int f19792b = 0;
    private Resources f19793c;

    public void onContentChanged() {
    }

    public void onCreate(Bundle bundle) {
        AppCompatDelegate c = m21499c();
        c.mo3181i();
        c.mo3166a(bundle);
        if (c.mo425j() && this.f19792b != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f19792b, false);
            } else {
                setTheme(this.f19792b);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.f19792b = i;
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m21499c().mo3175c();
    }

    public final ActionBar m21498b() {
        return m21499c().mo417a();
    }

    public final void m21497a(Toolbar toolbar) {
        m21499c().mo3167a(toolbar);
    }

    public MenuInflater getMenuInflater() {
        return m21499c().mo419b();
    }

    public void setContentView(int i) {
        m21499c().mo3172b(i);
    }

    public void setContentView(View view) {
        m21499c().mo3168a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m21499c().mo3169a(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m21499c().mo3173b(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m21499c().mo3165a(configuration);
        if (this.f19793c != null) {
            this.f19793c.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    protected void onPostResume() {
        super.onPostResume();
        m21499c().mo3178f();
    }

    public void onStart() {
        super.onStart();
        m21499c().mo421d();
    }

    public void onStop() {
        super.onStop();
        m21499c().mo423e();
    }

    public <T extends View> T findViewById(int i) {
        return m21499c().mo3164a(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem) != 0) {
            return true;
        }
        i = m21499c().mo417a();
        return (menuItem.getItemId() != 16908332 || i == 0 || (i.mo436a() & 4) == 0) ? false : m21496d();
    }

    public void onDestroy() {
        super.onDestroy();
        m21499c().mo424h();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m21499c().mo418a(charSequence);
    }

    public void supportInvalidateOptionsMenu() {
        m21499c().mo3180g();
    }

    public void invalidateOptionsMenu() {
        m21499c().mo3180g();
    }

    public final Intent w_() {
        return NavUtils.m664a(this);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m21499c().mo420b(bundle);
    }

    public final AppCompatDelegate m21499c() {
        if (this.f19791a == null) {
            this.f19791a = AppCompatDelegate.m1523a((Activity) this, (AppCompatCallback) this);
        }
        return this.f19791a;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar a = m21499c().mo417a();
        if (keyCode == 82 && a != null && a.mo443a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public Resources getResources() {
        if (this.f19793c == null && VectorEnabledTintResources.m2359a()) {
            this.f19793c = new VectorEnabledTintResources(this, super.getResources());
        }
        return this.f19793c == null ? super.getResources() : this.f19793c;
    }

    private boolean m21496d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = android.support.v4.app.NavUtils.m664a(r3);
        if (r0 == 0) goto L_0x004a;
    L_0x0006:
        r1 = android.support.v4.app.NavUtils.m666a(r3, r0);
        if (r1 == 0) goto L_0x0045;
    L_0x000c:
        r0 = android.support.v4.app.TaskStackBuilder.m707a(r3);
        r1 = 0;
        r2 = r3 instanceof android.support.v4.app.TaskStackBuilder.SupportParentable;
        if (r2 == 0) goto L_0x001c;
    L_0x0015:
        r1 = r3;
        r1 = (android.support.v4.app.TaskStackBuilder.SupportParentable) r1;
        r1 = r1.w_();
    L_0x001c:
        if (r1 != 0) goto L_0x0022;
    L_0x001e:
        r1 = android.support.v4.app.NavUtils.m664a(r3);
    L_0x0022:
        if (r1 == 0) goto L_0x003a;
    L_0x0024:
        r2 = r1.getComponent();
        if (r2 != 0) goto L_0x0034;
    L_0x002a:
        r2 = r0.f1179c;
        r2 = r2.getPackageManager();
        r2 = r1.resolveActivity(r2);
    L_0x0034:
        r0.m709a(r2);
        r0.m710a(r1);
    L_0x003a:
        r0.m711a();
        android.support.v4.app.ActivityCompat.m9752a(r3);	 Catch:{ IllegalStateException -> 0x0041 }
        goto L_0x0048;
    L_0x0041:
        r3.finish();
        goto L_0x0048;
    L_0x0045:
        android.support.v4.app.NavUtils.m669b(r3, r0);
    L_0x0048:
        r0 = 1;
        return r0;
    L_0x004a:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatActivity.d():boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        if (!(VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()))) {
            Window window = getWindow();
            if (!(window == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent))) {
                z = true;
                if (z) {
                    return super.onKeyDown(i, keyEvent);
                }
                return true;
            }
        }
        z = false;
        if (z) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void openOptionsMenu() {
        ActionBar a = m21499c().mo417a();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (a == null || !a.mo455g()) {
            super.openOptionsMenu();
        }
    }

    public void closeOptionsMenu() {
        ActionBar a = m21499c().mo417a();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (a == null || !a.mo456h()) {
            super.closeOptionsMenu();
        }
    }
}
