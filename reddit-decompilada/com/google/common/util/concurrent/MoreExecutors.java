package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

public final class MoreExecutors {

    private enum DirectExecutor implements Executor {
        ;

        public final String toString() {
            return "MoreExecutors.directExecutor()";
        }

        private DirectExecutor(String str) {
        }

        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor m7338a() {
        return DirectExecutor.f8583a;
    }

    static Executor m7339a(final Executor executor, final AbstractFuture<?> abstractFuture) {
        Preconditions.m6908a((Object) executor);
        Preconditions.m6908a((Object) abstractFuture);
        return executor == DirectExecutor.f8583a ? executor : new Executor() {
            boolean f8580a = true;

            public final void execute(final Runnable runnable) {
                try {
                    executor.execute(new Runnable(this) {
                        final /* synthetic */ C04545 f8579b;

                        public void run() {
                            this.f8579b.f8580a = false;
                            runnable.run();
                        }
                    });
                } catch (Throwable e) {
                    if (this.f8580a) {
                        abstractFuture.mo4400a(e);
                    }
                }
            }
        };
    }
}
