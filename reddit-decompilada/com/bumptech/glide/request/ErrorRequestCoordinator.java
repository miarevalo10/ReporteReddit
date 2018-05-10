package com.bumptech.glide.request;

public final class ErrorRequestCoordinator implements Request, RequestCoordinator {
    public Request f12655a;
    public Request f12656b;
    private final RequestCoordinator f12657c;

    public ErrorRequestCoordinator(RequestCoordinator requestCoordinator) {
        this.f12657c = requestCoordinator;
    }

    public final void begin() {
        if (!this.f12655a.isRunning()) {
            this.f12655a.begin();
        }
    }

    public final void pause() {
        if (!this.f12655a.isFailed()) {
            this.f12655a.pause();
        }
        if (this.f12656b.isRunning()) {
            this.f12656b.pause();
        }
    }

    public final void clear() {
        this.f12655a.clear();
        if (this.f12656b.isRunning()) {
            this.f12656b.clear();
        }
    }

    public final boolean isPaused() {
        return (this.f12655a.isFailed() ? this.f12656b : this.f12655a).isPaused();
    }

    public final boolean isRunning() {
        return (this.f12655a.isFailed() ? this.f12656b : this.f12655a).isRunning();
    }

    public final boolean isComplete() {
        return (this.f12655a.isFailed() ? this.f12656b : this.f12655a).isComplete();
    }

    public final boolean isResourceSet() {
        return (this.f12655a.isFailed() ? this.f12656b : this.f12655a).isResourceSet();
    }

    public final boolean isCancelled() {
        return (this.f12655a.isFailed() ? this.f12656b : this.f12655a).isCancelled();
    }

    public final boolean isFailed() {
        return this.f12655a.isFailed() && this.f12656b.isFailed();
    }

    public final void recycle() {
        this.f12655a.recycle();
        this.f12656b.recycle();
    }

    public final boolean isEquivalentTo(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        if (!this.f12655a.isEquivalentTo(errorRequestCoordinator.f12655a) || this.f12656b.isEquivalentTo(errorRequestCoordinator.f12656b) == null) {
            return false;
        }
        return true;
    }

    private boolean m11701f(Request request) {
        if (!request.equals(this.f12655a)) {
            if (!this.f12655a.isFailed() || request.equals(this.f12656b) == null) {
                return null;
            }
        }
        return true;
    }

    public final void mo1013d(Request request) {
        if (this.f12657c != null) {
            this.f12657c.mo1013d(this);
        }
    }

    public final void mo1014e(Request request) {
        if (request.equals(this.f12656b) == null) {
            if (this.f12656b.isRunning() == null) {
                this.f12656b.begin();
            }
            return;
        }
        if (this.f12657c != null) {
            this.f12657c.mo1014e(this);
        }
    }

    public final boolean mo1008a(Request request) {
        boolean z;
        if (this.f12657c != null) {
            if (!this.f12657c.mo1008a(this)) {
                z = false;
                return z && m11701f(request) != null;
            }
        }
        z = true;
        if (!z) {
        }
    }

    public final boolean mo1009b(Request request) {
        boolean z;
        if (this.f12657c != null) {
            if (!this.f12657c.mo1009b(this)) {
                z = false;
                return z && m11701f(request) != null;
            }
        }
        z = true;
        if (!z) {
        }
    }

    public final boolean mo1011c(Request request) {
        boolean z;
        if (this.f12657c != null) {
            if (!this.f12657c.mo1011c(this)) {
                z = false;
                return z && m11701f(request) != null;
            }
        }
        z = true;
        if (!z) {
        }
    }

    public final boolean mo1007a() {
        boolean z = this.f12657c != null && this.f12657c.mo1007a();
        if (!z) {
            if (!isResourceSet()) {
                return false;
            }
        }
        return true;
    }
}
