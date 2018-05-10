package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ForwardingTimeout extends Timeout {
    public Timeout f33185a;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f33185a = timeout;
    }

    public Timeout timeout(long j, TimeUnit timeUnit) {
        return this.f33185a.timeout(j, timeUnit);
    }

    public long timeoutNanos() {
        return this.f33185a.timeoutNanos();
    }

    public boolean hasDeadline() {
        return this.f33185a.hasDeadline();
    }

    public long deadlineNanoTime() {
        return this.f33185a.deadlineNanoTime();
    }

    public Timeout deadlineNanoTime(long j) {
        return this.f33185a.deadlineNanoTime(j);
    }

    public Timeout clearTimeout() {
        return this.f33185a.clearTimeout();
    }

    public Timeout clearDeadline() {
        return this.f33185a.clearDeadline();
    }

    public void throwIfReached() throws IOException {
        this.f33185a.throwIfReached();
    }
}
