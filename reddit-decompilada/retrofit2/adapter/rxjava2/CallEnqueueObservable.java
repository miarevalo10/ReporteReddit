package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

final class CallEnqueueObservable<T> extends Observable<Response<T>> {
    private final Call<T> f41859a;

    private static final class CallCallback<T> implements Disposable, Callback<T> {
        boolean f41628a = false;
        private final Call<?> f41629b;
        private final Observer<? super Response<T>> f41630c;

        CallCallback(Call<?> call, Observer<? super Response<T>> observer) {
            this.f41629b = call;
            this.f41630c = observer;
        }

        public final void mo7882a(Call<T> call, Response<T> response) {
            if (!call.mo7886c()) {
                try {
                    this.f41630c.onNext(response);
                    if (call.mo7886c() == null) {
                        this.f41628a = true;
                        this.f41630c.onComplete();
                    }
                } catch (Call<T> call2) {
                    Exceptions.b(call2);
                    RxJavaPlugins.a(new CompositeException(new Throwable[]{response, call2}));
                }
            }
        }

        public final void mo7881a(Call<T> call, Throwable th) {
            if (call.mo7886c() == null) {
                try {
                    this.f41630c.onError(th);
                } catch (Call<T> call2) {
                    Exceptions.b(call2);
                    RxJavaPlugins.a(new CompositeException(new Throwable[]{th, call2}));
                }
            }
        }

        public final void m43780a() {
            this.f41629b.mo7885b();
        }

        public final boolean m43783b() {
            return this.f41629b.mo7886c();
        }
    }

    CallEnqueueObservable(Call<T> call) {
        this.f41859a = call;
    }

    protected final void subscribeActual(Observer<? super Response<T>> observer) {
        Call d = this.f41859a.mo7887d();
        Object callCallback = new CallCallback(d, observer);
        observer.onSubscribe(callCallback);
        d.mo7884a(callCallback);
    }
}
