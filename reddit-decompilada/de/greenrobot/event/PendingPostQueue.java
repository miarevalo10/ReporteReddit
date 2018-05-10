package de.greenrobot.event;

final class PendingPostQueue {
    private PendingPost f24355a;
    private PendingPost f24356b;

    PendingPostQueue() {
    }

    final synchronized void m26017a(PendingPost pendingPost) {
        if (pendingPost == null) {
            throw new NullPointerException("null cannot be enqueued");
        }
        if (this.f24356b != null) {
            this.f24356b.f24354c = pendingPost;
            this.f24356b = pendingPost;
        } else if (this.f24355a == null) {
            this.f24356b = pendingPost;
            this.f24355a = pendingPost;
        } else {
            throw new IllegalStateException("Head present, but no tail");
        }
        notifyAll();
    }

    final synchronized PendingPost m26016a() {
        PendingPost pendingPost;
        pendingPost = this.f24355a;
        if (this.f24355a != null) {
            this.f24355a = this.f24355a.f24354c;
            if (this.f24355a == null) {
                this.f24356b = null;
            }
        }
        return pendingPost;
    }

    final synchronized PendingPost m26018b() throws InterruptedException {
        if (this.f24355a == null) {
            wait(1000);
        }
        return m26016a();
    }
}
