package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;

public class LibraryLoader {
    @SuppressLint({"StaticFieldLeak"})
    private static Context f41201a;

    private static Context m43279b() {
        if (f41201a == null) {
            try {
                f41201a = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable e) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
            }
        }
        return f41201a;
    }

    static void m43278a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "pl_droidsonroids_gif";	 Catch:{ UnsatisfiedLinkError -> 0x0006 }
        java.lang.System.loadLibrary(r0);	 Catch:{ UnsatisfiedLinkError -> 0x0006 }
        return;
    L_0x0006:
        r0 = m43279b();
        pl.droidsonroids.gif.ReLinker.m43283a(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.LibraryLoader.a():void");
    }
}
