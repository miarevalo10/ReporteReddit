package de.greenrobot.event;

class AsyncPoster implements Runnable {
    final PendingPostQueue f24323a = new PendingPostQueue();
    final EventBus f24324b;

    AsyncPoster(EventBus eventBus) {
        this.f24324b = eventBus;
    }

    public void run() {
        PendingPost a = this.f24323a.m26016a();
        if (a == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f24324b.invokeSubscriber(a);
    }
}
