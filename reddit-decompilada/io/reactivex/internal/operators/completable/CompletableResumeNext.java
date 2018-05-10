package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class CompletableResumeNext extends Completable {
    final CompletableSource f34774a;
    final Function<? super Throwable, ? extends CompletableSource> f34775b;

    final class ResumeNext implements CompletableObserver {
        final CompletableObserver f31224a;
        final SequentialDisposable f31225b;
        final /* synthetic */ CompletableResumeNext f31226c;

        final class OnErrorObserver implements CompletableObserver {
            final /* synthetic */ ResumeNext f31223a;

            OnErrorObserver(ResumeNext resumeNext) {
                this.f31223a = resumeNext;
            }

            public final void onComplete() {
                this.f31223a.f31224a.onComplete();
            }

            public final void onError(Throwable th) {
                this.f31223a.f31224a.onError(th);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32091a(this.f31223a.f31225b, disposable);
            }
        }

        ResumeNext(CompletableResumeNext completableResumeNext, CompletableObserver completableObserver, SequentialDisposable sequentialDisposable) {
            this.f31226c = completableResumeNext;
            this.f31224a = completableObserver;
            this.f31225b = sequentialDisposable;
        }

        public final void onComplete() {
            this.f31224a.onComplete();
        }

        public final void onError(Throwable th) {
            Throwable nullPointerException;
            try {
                CompletableSource completableSource = (CompletableSource) this.f31226c.f34775b.apply(th);
                if (completableSource == null) {
                    nullPointerException = new NullPointerException("The CompletableConsumable returned is null");
                    nullPointerException.initCause(th);
                    this.f31224a.onError(nullPointerException);
                    return;
                }
                completableSource.subscribe(new OnErrorObserver(this));
            } catch (Throwable nullPointerException2) {
                Exceptions.m26521b(nullPointerException2);
                this.f31224a.onError(new CompositeException(nullPointerException2, th));
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32091a(this.f31225b, disposable);
        }
    }

    public CompletableResumeNext(CompletableSource completableSource, Function<? super Throwable, ? extends CompletableSource> function) {
        this.f34774a = completableSource;
        this.f34775b = function;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        Object sequentialDisposable = new SequentialDisposable();
        completableObserver.onSubscribe(sequentialDisposable);
        this.f34774a.subscribe(new ResumeNext(this, completableObserver, sequentialDisposable));
    }
}
