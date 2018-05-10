package bolts;

public class TaskCompletionSource<TResult> {
    final Task<TResult> f2730a = new Task();

    public final void m2423a() {
        if (!this.f2730a.m2422g()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public final void m2425a(TResult tResult) {
        if (this.f2730a.m2416a((Object) tResult) == null) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public final void m2424a(Exception exception) {
        if (this.f2730a.m2415a(exception) == null) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
