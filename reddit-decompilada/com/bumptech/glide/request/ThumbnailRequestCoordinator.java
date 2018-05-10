package com.bumptech.glide.request;

public class ThumbnailRequestCoordinator implements Request, RequestCoordinator {
    private final RequestCoordinator f12658a;
    private Request f12659b;
    private Request f12660c;
    private boolean f12661d;

    ThumbnailRequestCoordinator() {
        this(null);
    }

    public ThumbnailRequestCoordinator(RequestCoordinator requestCoordinator) {
        this.f12658a = requestCoordinator;
    }

    public final void m11709a(Request request, Request request2) {
        this.f12659b = request;
        this.f12660c = request2;
    }

    public final void mo1013d(Request request) {
        if (request.equals(this.f12660c) == null) {
            if (this.f12658a != null) {
                this.f12658a.mo1013d(this);
            }
            if (this.f12660c.isComplete() == null) {
                this.f12660c.clear();
            }
        }
    }

    public final void mo1014e(Request request) {
        if (!(request.equals(this.f12659b) == null || this.f12658a == null)) {
            this.f12658a.mo1014e(this);
        }
    }

    public void begin() {
        this.f12661d = true;
        if (!(this.f12659b.isComplete() || this.f12660c.isRunning())) {
            this.f12660c.begin();
        }
        if (this.f12661d && !this.f12659b.isRunning()) {
            this.f12659b.begin();
        }
    }

    public void pause() {
        this.f12661d = false;
        this.f12659b.pause();
        this.f12660c.pause();
    }

    public void clear() {
        this.f12661d = false;
        this.f12660c.clear();
        this.f12659b.clear();
    }

    public boolean isPaused() {
        return this.f12659b.isPaused();
    }

    public boolean isRunning() {
        return this.f12659b.isRunning();
    }

    public boolean isComplete() {
        if (!this.f12659b.isComplete()) {
            if (!this.f12660c.isComplete()) {
                return false;
            }
        }
        return true;
    }

    public boolean isResourceSet() {
        if (!this.f12659b.isResourceSet()) {
            if (!this.f12660c.isResourceSet()) {
                return false;
            }
        }
        return true;
    }

    public boolean isCancelled() {
        return this.f12659b.isCancelled();
    }

    public boolean isFailed() {
        return this.f12659b.isFailed();
    }

    public void recycle() {
        this.f12659b.recycle();
        this.f12660c.recycle();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEquivalentTo(com.bumptech.glide.request.Request r4) {
        /*
        r3 = this;
        r0 = r4 instanceof com.bumptech.glide.request.ThumbnailRequestCoordinator;
        r1 = 0;
        if (r0 == 0) goto L_0x0030;
    L_0x0005:
        r4 = (com.bumptech.glide.request.ThumbnailRequestCoordinator) r4;
        r0 = r3.f12659b;
        if (r0 != 0) goto L_0x0010;
    L_0x000b:
        r0 = r4.f12659b;
        if (r0 != 0) goto L_0x002f;
    L_0x000f:
        goto L_0x001a;
    L_0x0010:
        r0 = r3.f12659b;
        r2 = r4.f12659b;
        r0 = r0.isEquivalentTo(r2);
        if (r0 == 0) goto L_0x002f;
    L_0x001a:
        r0 = r3.f12660c;
        if (r0 != 0) goto L_0x0023;
    L_0x001e:
        r4 = r4.f12660c;
        if (r4 != 0) goto L_0x002f;
    L_0x0022:
        goto L_0x002d;
    L_0x0023:
        r0 = r3.f12660c;
        r4 = r4.f12660c;
        r4 = r0.isEquivalentTo(r4);
        if (r4 == 0) goto L_0x002f;
    L_0x002d:
        r4 = 1;
        return r4;
    L_0x002f:
        return r1;
    L_0x0030:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.isEquivalentTo(com.bumptech.glide.request.Request):boolean");
    }

    public final boolean mo1008a(Request request) {
        boolean z;
        if (this.f12658a != null) {
            if (!this.f12658a.mo1008a(this)) {
                z = false;
                return z && (request.equals(this.f12659b) != null || this.f12659b.isResourceSet() == null);
            }
        }
        z = true;
        if (!z) {
        }
    }

    public final boolean mo1009b(Request request) {
        boolean z;
        if (this.f12658a != null) {
            if (!this.f12658a.mo1009b(this)) {
                z = false;
                return z && request.equals(this.f12659b) != null && mo1007a() == null;
            }
        }
        z = true;
        if (!z) {
        }
    }

    public final boolean mo1011c(Request request) {
        boolean z;
        if (this.f12658a != null) {
            if (!this.f12658a.mo1011c(this)) {
                z = false;
                return z && request.equals(this.f12659b) != null;
            }
        }
        z = true;
        if (!z) {
        }
    }

    public final boolean mo1007a() {
        boolean z = this.f12658a != null && this.f12658a.mo1007a();
        if (!z) {
            if (!isResourceSet()) {
                return false;
            }
        }
        return true;
    }
}
