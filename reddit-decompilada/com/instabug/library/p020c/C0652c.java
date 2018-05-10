package com.instabug.library.p020c;

import android.content.Context;
import com.instabug.library.C0660d;
import java.lang.reflect.Method;

/* compiled from: InstabugCrash */
public class C0652c {
    public static void m8145a(Context context, Throwable th, String str) {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.crash.InstabugCrash"), "reportCaughtException");
            if (a != null) {
                a.invoke(null, new Object[]{context, th, str});
            }
        } catch (Context context2) {
            context2.printStackTrace();
        } catch (Context context22) {
            context22.printStackTrace();
        } catch (Context context222) {
            context222.printStackTrace();
        }
    }

    public static void m8146a(Runnable runnable) throws IllegalStateException {
        try {
            Method a = C0660d.m8162a(Class.forName("com.instabug.crash.InstabugCrash"), "setPreSendingRunnable");
            if (a != null) {
                a.invoke(null, new Object[]{runnable});
            }
        } catch (Runnable runnable2) {
            runnable2.printStackTrace();
        } catch (Runnable runnable22) {
            runnable22.printStackTrace();
        } catch (Runnable runnable222) {
            runnable222.printStackTrace();
        }
    }
}
