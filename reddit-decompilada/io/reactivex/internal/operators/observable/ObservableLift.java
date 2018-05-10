package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableLift<R, T> extends AbstractObservableWithUpstream<T, R> {
    final ObservableOperator<? extends R, ? super T> f38024a;

    public ObservableLift(ObservableSource<T> observableSource, ObservableOperator<? extends R, ? super T> observableOperator) {
        super(observableSource);
        this.f38024a = observableOperator;
    }

    public final void subscribeActual(Observer<? super R> observer) {
        try {
            Object a = this.f38024a.m26492a();
            StringBuilder stringBuilder = new StringBuilder("Operator ");
            stringBuilder.append(this.f38024a);
            stringBuilder.append(" returned a null Observer");
            this.source.subscribe((Observer) ObjectHelper.m26573a(a, stringBuilder.toString()));
        } catch (Observer<? super R> observer2) {
            throw observer2;
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            RxJavaPlugins.m26757a(th);
            new NullPointerException("Actually not, but can't throw other exceptions due to RS").initCause(th);
        }
    }
}
