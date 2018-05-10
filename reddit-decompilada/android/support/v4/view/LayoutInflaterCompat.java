package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

public final class LayoutInflaterCompat {
    static final LayoutInflaterCompatBaseImpl f1438a;
    private static Field f1439b;
    private static boolean f1440c;

    static class LayoutInflaterCompatBaseImpl {
        LayoutInflaterCompatBaseImpl() {
        }

        public void mo368a(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2) {
                LayoutInflaterCompat.m1099a(layoutInflater, (Factory2) factory);
            } else {
                LayoutInflaterCompat.m1099a(layoutInflater, factory2);
            }
        }
    }

    @RequiresApi(21)
    static class LayoutInflaterCompatApi21Impl extends LayoutInflaterCompatBaseImpl {
        LayoutInflaterCompatApi21Impl() {
        }

        public final void mo368a(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    static void m1099a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f1440c) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f1439b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder("forceSetFactory2 Could not find field 'mFactory2' on class ");
                stringBuilder.append(LayoutInflater.class.getName());
                stringBuilder.append("; inflation may have unexpected results.");
                Log.e("LayoutInflaterCompatHC", stringBuilder.toString(), e);
            }
            f1440c = true;
        }
        if (f1439b != null) {
            try {
                f1439b.set(layoutInflater, factory2);
            } catch (Factory2 factory22) {
                StringBuilder stringBuilder2 = new StringBuilder("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
                stringBuilder2.append(layoutInflater);
                stringBuilder2.append("; inflation may have unexpected results.");
                Log.e("LayoutInflaterCompatHC", stringBuilder2.toString(), factory22);
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1438a = new LayoutInflaterCompatApi21Impl();
        } else {
            f1438a = new LayoutInflaterCompatBaseImpl();
        }
    }

    public static void m1100b(LayoutInflater layoutInflater, Factory2 factory2) {
        f1438a.mo368a(layoutInflater, factory2);
    }
}
