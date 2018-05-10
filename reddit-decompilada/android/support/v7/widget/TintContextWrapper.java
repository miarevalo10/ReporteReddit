package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TintContextWrapper extends ContextWrapper {
    private static final Object f2586a = new Object();
    private static ArrayList<WeakReference<TintContextWrapper>> f2587b;
    private final Resources f2588c;
    private final Theme f2589d;

    private TintContextWrapper(Context context) {
        super(context);
        if (VectorEnabledTintResources.m2359a()) {
            this.f2588c = new VectorEnabledTintResources(this, context.getResources());
            this.f2589d = this.f2588c.newTheme();
            this.f2589d.setTo(context.getTheme());
            return;
        }
        this.f2588c = new TintResources(this, context.getResources());
        this.f2589d = null;
    }

    public Theme getTheme() {
        return this.f2589d == null ? super.getTheme() : this.f2589d;
    }

    public void setTheme(int i) {
        if (this.f2589d == null) {
            super.setTheme(i);
        } else {
            this.f2589d.applyStyle(i, true);
        }
    }

    public Resources getResources() {
        return this.f2588c;
    }

    public AssetManager getAssets() {
        return this.f2588c.getAssets();
    }

    public static Context m2304a(Context context) {
        int i = 0;
        if (!((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources))) {
            if (!(context.getResources() instanceof VectorEnabledTintResources)) {
                if (VERSION.SDK_INT < 21 || VectorEnabledTintResources.m2359a()) {
                    i = 1;
                }
            }
        }
        if (i == 0) {
            return context;
        }
        synchronized (f2586a) {
            if (f2587b == null) {
                f2587b = new ArrayList();
            } else {
                for (i = f2587b.size() - 1; i >= 0; i--) {
                    WeakReference weakReference = (WeakReference) f2587b.get(i);
                    if (weakReference == null || weakReference.get() == null) {
                        f2587b.remove(i);
                    }
                }
                i = f2587b.size() - 1;
                while (i >= 0) {
                    WeakReference weakReference2 = (WeakReference) f2587b.get(i);
                    Context context2 = weakReference2 != null ? (TintContextWrapper) weakReference2.get() : null;
                    if (context2 == null || context2.getBaseContext() != context) {
                        i--;
                    } else {
                        return context2;
                    }
                }
            }
            Context tintContextWrapper = new TintContextWrapper(context);
            f2587b.add(new WeakReference(tintContextWrapper));
            return tintContextWrapper;
        }
    }
}
