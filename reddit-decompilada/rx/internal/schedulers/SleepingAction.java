package rx.internal.schedulers;

import rx.Scheduler.Worker;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

class SleepingAction implements Action0 {
    private final Action0 f41761a;
    private final Worker f41762b;
    private final long f41763c;

    public SleepingAction(Action0 action0, Worker worker, long j) {
        this.f41761a = action0;
        this.f41762b = worker;
        this.f41763c = j;
    }

    public final void mo7898a() {
        if (!this.f41762b.mo7894d()) {
            long b = this.f41763c - Worker.m43804b();
            if (b > 0) {
                try {
                    Thread.sleep(b);
                } catch (Throwable e) {
                    Thread.currentThread().interrupt();
                    Exceptions.m43430a(e);
                }
            }
            if (!this.f41762b.mo7894d()) {
                this.f41761a.mo7898a();
            }
        }
    }
}
