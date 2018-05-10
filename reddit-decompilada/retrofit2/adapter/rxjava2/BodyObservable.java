package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;

final class BodyObservable<T> extends Observable<T> {
    private final Observable<Response<T>> f41858a;

    private static class BodyObserver<R> implements Observer<Response<R>> {
        private final Observer<? super R> f41626a;
        private boolean f41627b;

        public /* synthetic */ void onNext(Object obj) {
            Response response = (Response) obj;
            if (response.f41225a.isSuccessful()) {
                this.f41626a.onNext(response.f41226b);
                return;
            }
            this.f41627b = true;
            try {
                this.f41626a.onError(new HttpException(response));
            } catch (Object obj2) {
                Exceptions.b(obj2);
                RxJavaPlugins.a(new CompositeException(new Throwable[]{r1, obj2}));
            }
        }

        BodyObserver(Observer<? super R> observer) {
            this.f41626a = observer;
        }

        public void onSubscribe(Disposable disposable) {
            this.f41626a.onSubscribe(disposable);
        }

        public void onComplete() {
            if (!this.f41627b) {
                this.f41626a.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f41627b) {
                Throwable assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
                assertionError.initCause(th);
                RxJavaPlugins.a(assertionError);
                return;
            }
            this.f41626a.onError(th);
        }
    }

    BodyObservable(Observable<Response<T>> observable) {
        this.f41858a = observable;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.f41858a.subscribe(new BodyObserver(observer));
    }
}
