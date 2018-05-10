package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.appcompat.C0164R;
import android.view.LayoutInflater;

public class ContextThemeWrapper extends ContextWrapper {
    public int f1962a;
    private Theme f1963b;
    private LayoutInflater f1964c;
    private Configuration f1965d;
    private Resources f1966e;

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context context, int i) {
        super(context);
        this.f1962a = i;
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void setTheme(int i) {
        if (this.f1962a != i) {
            this.f1962a = i;
            m1692a();
        }
    }

    public Theme getTheme() {
        if (this.f1963b != null) {
            return this.f1963b;
        }
        if (this.f1962a == 0) {
            this.f1962a = C0164R.style.Theme_AppCompat_Light;
        }
        m1692a();
        return this.f1963b;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1964c == null) {
            this.f1964c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1964c;
    }

    private void m1692a() {
        if (this.f1963b == null) {
            this.f1963b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1963b.setTo(theme);
            }
        }
        this.f1963b.applyStyle(this.f1962a, true);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        if (this.f1966e == null) {
            if (this.f1965d == null) {
                this.f1966e = super.getResources();
            } else if (VERSION.SDK_INT >= 17) {
                this.f1966e = createConfigurationContext(this.f1965d).getResources();
            }
        }
        return this.f1966e;
    }
}
