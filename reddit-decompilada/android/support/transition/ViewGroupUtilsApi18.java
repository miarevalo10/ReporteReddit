package android.support.transition;

import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Method;

@RequiresApi(18)
class ViewGroupUtilsApi18 extends ViewGroupUtilsApi14 {
    private static Method f16485a;
    private static boolean f16486b;

    ViewGroupUtilsApi18() {
    }

    public final ViewGroupOverlayImpl mo174a(ViewGroup viewGroup) {
        return new ViewGroupOverlayApi18(viewGroup);
    }

    public final void mo175a(ViewGroup viewGroup, boolean z) {
        if (!f16486b) {
            try {
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});
                f16485a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Throwable e) {
                Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
            }
            f16486b = true;
        }
        if (f16485a != null) {
            try {
                f16485a.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
            } catch (ViewGroup viewGroup2) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", viewGroup2);
            } catch (ViewGroup viewGroup22) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", viewGroup22);
            }
        }
    }
}
