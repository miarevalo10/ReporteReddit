package io.reactivex.disposables;

final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    protected final /* synthetic */ void mo6608a(Object obj) {
        ((Runnable) obj).run();
    }

    RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RunnableDisposable(disposed=");
        stringBuilder.append(mo5627b());
        stringBuilder.append(", ");
        stringBuilder.append(get());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
