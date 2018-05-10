package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

public class CancellationTokenSource implements Closeable {
    final Object f2702a;
    final List<CancellationTokenRegistration> f2703b;
    private ScheduledFuture<?> f2704c;
    private boolean f2705d;
    private boolean f2706e;

    public final boolean m2402a() {
        boolean z;
        synchronized (this.f2702a) {
            m2403b();
            z = this.f2705d;
        }
        return z;
    }

    public void close() {
        synchronized (this.f2702a) {
            if (this.f2706e) {
                return;
            }
            if (this.f2704c != null) {
                this.f2704c.cancel(true);
                this.f2704c = null;
            }
            for (CancellationTokenRegistration close : this.f2703b) {
                close.close();
            }
            this.f2703b.clear();
            this.f2706e = true;
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(m2402a())});
    }

    final void m2403b() {
        if (this.f2706e) {
            throw new IllegalStateException("Object already closed");
        }
    }
}
