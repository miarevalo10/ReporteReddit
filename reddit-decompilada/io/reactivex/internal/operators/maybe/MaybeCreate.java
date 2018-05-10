package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCreate<T> extends Maybe<T> {
    final MaybeOnSubscribe<T> f35557a;

    static final class Emitter<T> extends AtomicReference<Disposable> implements MaybeEmitter<T>, Disposable {
        final MaybeObserver<? super T> f31412a;

        public final void az_() {
            /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.get();
            r1 = io.reactivex.internal.disposables.DisposableHelper.f31095a;
            if (r0 == r1) goto L_0x0026;
        L_0x0008:
            r0 = io.reactivex.internal.disposables.DisposableHelper.f31095a;
            r0 = r2.getAndSet(r0);
            r0 = (io.reactivex.disposables.Disposable) r0;
            r1 = io.reactivex.internal.disposables.DisposableHelper.f31095a;
            if (r0 == r1) goto L_0x0026;
        L_0x0014:
            r1 = r2.f31412a;	 Catch:{ all -> 0x001f }
            r1.onComplete();	 Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0026;
        L_0x001b:
            r0.mo5626a();
            return;
        L_0x001f:
            r1 = move-exception;
            if (r0 == 0) goto L_0x0025;
        L_0x0022:
            r0.mo5626a();
        L_0x0025:
            throw r1;
        L_0x0026:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.maybe.MaybeCreate.Emitter.az_():void");
        }

        Emitter(MaybeObserver<? super T> maybeObserver) {
            this.f31412a = maybeObserver;
        }

        public final void mo5655a(T t) {
            if (get() != DisposableHelper.f31095a) {
                Disposable disposable = (Disposable) getAndSet(DisposableHelper.f31095a);
                if (disposable != DisposableHelper.f31095a) {
                    if (t == null) {
                        try {
                            this.f31412a.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                        } catch (Throwable th) {
                            if (disposable != null) {
                                disposable.mo5626a();
                            }
                        }
                    } else {
                        this.f31412a.onSuccess(t);
                    }
                    if (disposable != null) {
                        disposable.mo5626a();
                    }
                }
            }
        }

        public final void mo5656a(Throwable th) {
            if (!m32243b(th)) {
                RxJavaPlugins.m26757a(th);
            }
        }

        private boolean m32243b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (get() != DisposableHelper.f31095a) {
                Disposable disposable = (Disposable) getAndSet(DisposableHelper.f31095a);
                if (disposable != DisposableHelper.f31095a) {
                    try {
                        this.f31412a.onError(th);
                        return true;
                    } finally {
                        if (disposable != null) {
                            disposable.mo5626a();
                        }
                    }
                }
            }
            return null;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public MaybeCreate(MaybeOnSubscribe<T> maybeOnSubscribe) {
        this.f35557a = maybeOnSubscribe;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Emitter emitter = new Emitter(maybeObserver);
        maybeObserver.onSubscribe(emitter);
        try {
            this.f35557a.m26480a(emitter);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            emitter.mo5656a(th);
        }
    }
}
