package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableOperator;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableLift<R, T> extends AbstractFlowableWithUpstream<T, R> {
    final FlowableOperator<? extends R, ? super T> f37752a;

    public FlowableLift(Flowable<T> flowable, FlowableOperator<? extends R, ? super T> flowableOperator) {
        super(flowable);
        this.f37752a = flowableOperator;
    }

    public final void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            Subscriber a = this.f37752a.m26475a();
            if (a == null) {
                StringBuilder stringBuilder = new StringBuilder("Operator ");
                stringBuilder.append(this.f37752a);
                stringBuilder.append(" returned a null Subscriber");
                throw new NullPointerException(stringBuilder.toString());
            }
            this.source.subscribe(a);
        } catch (Subscriber<? super R> subscriber2) {
            throw subscriber2;
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            RxJavaPlugins.m26757a(th);
            new NullPointerException("Actually not, but can't throw other exceptions due to RS").initCause(th);
        }
    }
}
