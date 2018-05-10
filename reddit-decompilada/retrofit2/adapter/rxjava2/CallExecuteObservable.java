package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Response;

final class CallExecuteObservable<T> extends Observable<Response<T>> {
    private final Call<T> f41860a;

    private static final class CallDisposable implements Disposable {
        private final Call<?> f41631a;

        CallDisposable(Call<?> call) {
            this.f41631a = call;
        }

        public final void m43784a() {
            this.f41631a.mo7885b();
        }

        public final boolean m43785b() {
            return this.f41631a.mo7886c();
        }
    }

    CallExecuteObservable(Call<T> call) {
        this.f41860a = call;
    }

    protected final void subscribeActual(Observer<? super Response<T>> observer) {
        Throwable th;
        int i;
        Call d = this.f41860a.mo7887d();
        observer.onSubscribe(new CallDisposable(d));
        try {
            Response a = d.mo7883a();
            if (!d.mo7886c()) {
                observer.onNext(a);
            }
            if (!d.mo7886c()) {
                try {
                    observer.onComplete();
                } catch (Throwable th2) {
                    th = th2;
                    i = 1;
                    Exceptions.b(th);
                    if (i == 0) {
                        RxJavaPlugins.a(th);
                    }
                    if (!d.mo7886c()) {
                        try {
                            observer.onError(th);
                        } catch (Observer<? super Response<T>> observer2) {
                            Exceptions.b(observer2);
                            RxJavaPlugins.a(new CompositeException(new Throwable[]{th, observer2}));
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            i = 0;
            Exceptions.b(th);
            if (i == 0) {
                if (d.mo7886c()) {
                    observer2.onError(th);
                }
            }
            RxJavaPlugins.a(th);
        }
    }
}
