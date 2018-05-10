package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;

final class ResultObservable<T> extends Observable<Result<T>> {
    private final Observable<Response<T>> f41861a;

    private static class ResultObserver<R> implements Observer<Response<R>> {
        private final Observer<? super Result<R>> f41632a;

        public /* synthetic */ void onNext(Object obj) {
            this.f41632a.onNext(Result.m43357a((Response) obj));
        }

        ResultObserver(Observer<? super Result<R>> observer) {
            this.f41632a = observer;
        }

        public void onSubscribe(Disposable disposable) {
            this.f41632a.onSubscribe(disposable);
        }

        public void onError(Throwable th) {
            try {
                this.f41632a.onNext(Result.m43356a(th));
                this.f41632a.onComplete();
            } catch (Throwable th2) {
                Exceptions.b(th2);
                RxJavaPlugins.a(new CompositeException(new Throwable[]{th, th2}));
            }
        }

        public void onComplete() {
            this.f41632a.onComplete();
        }
    }

    ResultObservable(Observable<Response<T>> observable) {
        this.f41861a = observable;
    }

    protected final void subscribeActual(Observer<? super Result<T>> observer) {
        this.f41861a.subscribe(new ResultObserver(observer));
    }
}
