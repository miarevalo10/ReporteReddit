package de.greenrobot.event;

final class Subscription {
    final Object f24367a;
    final SubscriberMethod f24368b;
    final int f24369c;
    volatile boolean f24370d = true;

    Subscription(Object obj, SubscriberMethod subscriberMethod, int i) {
        this.f24367a = obj;
        this.f24368b = subscriberMethod;
        this.f24369c = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        if (this.f24367a != subscription.f24367a || this.f24368b.equals(subscription.f24368b) == null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f24367a.hashCode() + this.f24368b.f24364d.hashCode();
    }
}
