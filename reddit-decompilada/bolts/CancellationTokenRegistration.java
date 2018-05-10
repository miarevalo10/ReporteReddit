package bolts;

import java.io.Closeable;

public class CancellationTokenRegistration implements Closeable {
    private final Object f2698a;
    private CancellationTokenSource f2699b;
    private Runnable f2700c;
    private boolean f2701d;

    public void close() {
        synchronized (this.f2698a) {
            if (this.f2701d) {
                return;
            }
            this.f2701d = true;
            CancellationTokenSource cancellationTokenSource = this.f2699b;
            synchronized (cancellationTokenSource.f2702a) {
                cancellationTokenSource.m2403b();
                cancellationTokenSource.f2703b.remove(this);
            }
            this.f2699b = null;
            this.f2700c = null;
        }
    }
}
