package android.support.transition;

import android.support.annotation.RequiresApi;
import java.lang.reflect.Method;

@RequiresApi(21)
class ViewUtilsApi21 extends ViewUtilsApi19 {
    private static Method f19464a;
    private static boolean f19465b;
    private static Method f19466c;
    private static boolean f19467d;

    ViewUtilsApi21() {
    }

    public final void mo181a(android.view.View r7, android.graphics.Matrix r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = f19465b;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x0024;
    L_0x0006:
        r0 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x001a }
        r3 = "transformMatrixToGlobal";	 Catch:{ NoSuchMethodException -> 0x001a }
        r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x001a }
        r5 = android.graphics.Matrix.class;	 Catch:{ NoSuchMethodException -> 0x001a }
        r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x001a }
        r0 = r0.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x001a }
        f19464a = r0;	 Catch:{ NoSuchMethodException -> 0x001a }
        r0.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x001a }
        goto L_0x0022;
    L_0x001a:
        r0 = move-exception;
        r3 = "ViewUtilsApi21";
        r4 = "Failed to retrieve transformMatrixToGlobal method";
        android.util.Log.i(r3, r4, r0);
    L_0x0022:
        f19465b = r2;
    L_0x0024:
        r0 = f19464a;
        if (r0 == 0) goto L_0x003e;
    L_0x0028:
        r0 = f19464a;	 Catch:{ IllegalAccessException -> 0x003d, InvocationTargetException -> 0x0032 }
        r2 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x003d, InvocationTargetException -> 0x0032 }
        r2[r1] = r8;	 Catch:{ IllegalAccessException -> 0x003d, InvocationTargetException -> 0x0032 }
        r0.invoke(r7, r2);	 Catch:{ IllegalAccessException -> 0x003d, InvocationTargetException -> 0x0032 }
        return;
    L_0x0032:
        r7 = move-exception;
        r8 = new java.lang.RuntimeException;
        r7 = r7.getCause();
        r8.<init>(r7);
        throw r8;
    L_0x003d:
        return;
    L_0x003e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi21.a(android.view.View, android.graphics.Matrix):void");
    }

    public final void mo183b(android.view.View r7, android.graphics.Matrix r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = f19467d;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x0024;
    L_0x0006:
        r0 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x001a }
        r3 = "transformMatrixToLocal";	 Catch:{ NoSuchMethodException -> 0x001a }
        r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x001a }
        r5 = android.graphics.Matrix.class;	 Catch:{ NoSuchMethodException -> 0x001a }
        r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x001a }
        r0 = r0.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x001a }
        f19466c = r0;	 Catch:{ NoSuchMethodException -> 0x001a }
        r0.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x001a }
        goto L_0x0022;
    L_0x001a:
        r0 = move-exception;
        r3 = "ViewUtilsApi21";
        r4 = "Failed to retrieve transformMatrixToLocal method";
        android.util.Log.i(r3, r4, r0);
    L_0x0022:
        f19467d = r2;
    L_0x0024:
        r0 = f19466c;
        if (r0 == 0) goto L_0x003e;
    L_0x0028:
        r0 = f19466c;	 Catch:{ IllegalAccessException -> 0x003d, InvocationTargetException -> 0x0032 }
        r2 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x003d, InvocationTargetException -> 0x0032 }
        r2[r1] = r8;	 Catch:{ IllegalAccessException -> 0x003d, InvocationTargetException -> 0x0032 }
        r0.invoke(r7, r2);	 Catch:{ IllegalAccessException -> 0x003d, InvocationTargetException -> 0x0032 }
        return;
    L_0x0032:
        r7 = move-exception;
        r8 = new java.lang.RuntimeException;
        r7 = r7.getCause();
        r8.<init>(r7);
        throw r8;
    L_0x003d:
        return;
    L_0x003e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi21.b(android.view.View, android.graphics.Matrix):void");
    }
}
