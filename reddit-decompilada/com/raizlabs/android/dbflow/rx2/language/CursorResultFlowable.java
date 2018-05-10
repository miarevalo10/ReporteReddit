package com.raizlabs.android.dbflow.rx2.language;

import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.list.FlowCursorIterator;
import com.raizlabs.android.dbflow.sql.language.CursorResult;
import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class CursorResultFlowable<T> extends Flowable<T> {
    private final RXModelQueriable<T> modelQueriable;

    static class CursorResultObserver<T> implements SingleObserver<CursorResult<T>> {
        private final long count;
        private Disposable disposable;
        private final AtomicLong emitted = new AtomicLong();
        private final AtomicLong requested = new AtomicLong();
        private final Subscriber<? super T> subscriber;

        CursorResultObserver(Subscriber<? super T> subscriber, long j) {
            this.subscriber = subscriber;
            this.count = j;
        }

        public void onSubscribe(Disposable disposable) {
            this.disposable = disposable;
        }

        public void onSuccess(CursorResult<T> cursorResult) {
            int i;
            if (this.count == Long.MAX_VALUE && this.requested.compareAndSet(0, Long.MAX_VALUE)) {
                i = 0;
            } else {
                i = this.emitted.intValue();
            }
            long j = this.count + ((long) i);
            while (j > 0) {
                FlowCursorIterator it = cursorResult.iterator(i, j);
                long j2 = 0;
                while (!this.disposable.b() && it.hasNext()) {
                    try {
                        long j3 = 1 + j2;
                        if (j2 >= j) {
                            j2 = j3;
                            break;
                        } else {
                            this.subscriber.onNext(it.next());
                            j2 = j3;
                        }
                    } catch (Exception e) {
                        j2 = e;
                        FlowLog.logError(j2);
                        this.subscriber.onError(j2);
                    } finally {
                        try {
                            it.close();
                        } catch (Throwable e2) {
                            FlowLog.logError(e2);
                            this.subscriber.onError(e2);
                        }
                    }
                }
                this.emitted.addAndGet(j2);
                if (this.disposable.b() || j2 >= j) {
                    j2 = this.requested.addAndGet(-j);
                    j = j2;
                } else {
                    this.subscriber.onComplete();
                    try {
                        it.close();
                        return;
                    } catch (CursorResult<T> cursorResult2) {
                        FlowLog.logError(cursorResult2);
                        this.subscriber.onError(cursorResult2);
                        return;
                    }
                }
            }
        }

        public void onError(Throwable th) {
            this.subscriber.onError(th);
        }
    }

    public CursorResultFlowable(RXModelQueriable<T> rXModelQueriable) {
        this.modelQueriable = rXModelQueriable;
    }

    protected void subscribeActual(final Subscriber<? super T> subscriber) {
        subscriber.a(new Subscription() {
            public void cancel() {
            }

            public void request(long j) {
                CursorResultFlowable.this.modelQueriable.queryResults().subscribe(new CursorResultObserver(subscriber, j));
            }
        });
    }
}
