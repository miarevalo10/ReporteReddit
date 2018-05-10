package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class TintResources extends ResourcesWrapper {
    private final WeakReference<Context> f12084a;

    public TintResources(Context context, Resources resources) {
        super(resources);
        this.f12084a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) throws NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f12084a.get();
        if (!(drawable == null || context == null)) {
            AppCompatDrawableManager.m1809a();
            AppCompatDrawableManager.m1813a(context, i, drawable);
        }
        return drawable;
    }
}
