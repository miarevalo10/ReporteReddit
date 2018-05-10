package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

class RenderTask extends SafeRunnable {
    RenderTask(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    public final void mo7874a() {
        long a = this.c.f41153f.m43254a(this.c.f41152e);
        if (a >= 0) {
            this.c.f41150c = SystemClock.uptimeMillis() + a;
            if (this.c.isVisible() && this.c.f41149b && !this.c.f41155h) {
                this.c.f41148a.remove(this);
                this.c.f41157j = this.c.f41148a.schedule(this, a, TimeUnit.MILLISECONDS);
            }
            if (!this.c.f41154g.isEmpty() && this.c.f41153f.m43262h() == this.c.f41153f.m43268n() - 1) {
                InvalidationHandler invalidationHandler = this.c.f41156i;
                GifDrawable gifDrawable = this.c;
                int i = gifDrawable.f41153f.m43263i();
                if (i != 0) {
                    if (i >= gifDrawable.f41153f.m43258d()) {
                        i--;
                    }
                }
                invalidationHandler.sendEmptyMessageAtTime(i, this.c.f41150c);
            }
        } else {
            this.c.f41150c = Long.MIN_VALUE;
            this.c.f41149b = false;
        }
        if (this.c.isVisible() && !this.c.f41156i.hasMessages(-1)) {
            this.c.f41156i.sendEmptyMessageAtTime(-1, 0);
        }
    }
}
