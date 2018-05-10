package de.greenrobot.event;

public final class SubscriberExceptionEvent {
    public final EventBus f24357a;
    public final Throwable f24358b;
    public final Object f24359c;
    public final Object f24360d;

    public SubscriberExceptionEvent(EventBus eventBus, Throwable th, Object obj, Object obj2) {
        this.f24357a = eventBus;
        this.f24358b = th;
        this.f24359c = obj;
        this.f24360d = obj2;
    }
}
