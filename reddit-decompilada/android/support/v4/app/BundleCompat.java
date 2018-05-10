package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.Method;

public final class BundleCompat {

    static class BundleCompatBaseImpl {
        private static Method f952a;
        private static boolean f953b;
        private static Method f954c;
        private static boolean f955d;

        public static IBinder m524a(Bundle bundle, String str) {
            if (!f953b) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f952a = method;
                    method.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e);
                }
                f953b = true;
            }
            if (f952a != null) {
                try {
                    return (IBinder) f952a.invoke(bundle, new Object[]{str});
                } catch (Bundle bundle2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", bundle2);
                    f952a = null;
                }
            }
            return null;
        }

        public static void m525b(Bundle bundle, String str) {
            if (!f955d) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    f954c = method;
                    method.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e);
                }
                f955d = true;
            }
            if (f954c != null) {
                try {
                    f954c.invoke(bundle, new Object[]{str, null});
                } catch (Bundle bundle2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", bundle2);
                    f954c = null;
                }
            }
        }
    }

    public static IBinder m526a(Bundle bundle, String str) {
        if (VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return BundleCompatBaseImpl.m524a(bundle, str);
    }

    public static void m527b(Bundle bundle, String str) {
        if (VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, null);
        } else {
            BundleCompatBaseImpl.m525b(bundle, str);
        }
    }
}
