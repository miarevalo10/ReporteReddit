package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;

public class VectorEnabledTintResources extends Resources {
    private final WeakReference<Context> f2662a;

    public static boolean m2359a() {
        return AppCompatDelegate.m1526k() && VERSION.SDK_INT <= 20;
    }

    public VectorEnabledTintResources(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2662a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) throws NotFoundException {
        Context context = (Context) this.f2662a.get();
        if (context == null) {
            return super.getDrawable(i);
        }
        AppCompatDrawableManager a = AppCompatDrawableManager.m1809a();
        Drawable a2 = a.m1817a(context, i);
        if (a2 == null) {
            a2 = super.getDrawable(i);
        }
        if (a2 != null) {
            return a.m1819a(context, i, false, a2);
        }
        return 0;
    }
}
