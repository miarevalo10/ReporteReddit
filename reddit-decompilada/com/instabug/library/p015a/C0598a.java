package com.instabug.library.p015a;

import com.instabug.library.C0645b;
import com.instabug.library.C0662e;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.internal.video.InternalAutoScreenRecorderHelper;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: InstabugUncaughtExceptionHandler */
public class C0598a implements UncaughtExceptionHandler {
    UncaughtExceptionHandler f9396a = Thread.getDefaultUncaughtExceptionHandler();

    public void uncaughtException(Thread thread, Throwable th) {
        if (InternalAutoScreenRecorderHelper.getInstance().isEnabled()) {
            InternalAutoScreenRecorderHelper.getInstance().setCrashOccurred(true);
        }
        C0662e a = C0662e.m8164a();
        if (C0645b.m8104a().m8113b(Feature.INSTABUG) == State.ENABLED) {
            a.m8171b();
        }
        this.f9396a.uncaughtException(thread, th);
    }
}
