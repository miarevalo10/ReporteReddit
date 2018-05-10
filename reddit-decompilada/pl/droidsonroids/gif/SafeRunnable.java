package pl.droidsonroids.gif;

import java.lang.Thread.UncaughtExceptionHandler;

abstract class SafeRunnable implements Runnable {
    final GifDrawable f41204c;

    abstract void mo7874a();

    SafeRunnable(GifDrawable gifDrawable) {
        this.f41204c = gifDrawable;
    }

    public final void run() {
        try {
            if (!this.f41204c.f41153f.m43264j()) {
                mo7874a();
            }
        } catch (Throwable th) {
            UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
