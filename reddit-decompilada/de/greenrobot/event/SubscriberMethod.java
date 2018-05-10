package de.greenrobot.event;

import java.lang.reflect.Method;

final class SubscriberMethod {
    final Method f24361a;
    final ThreadMode f24362b;
    final Class<?> f24363c;
    String f24364d;

    SubscriberMethod(Method method, ThreadMode threadMode, Class<?> cls) {
        this.f24361a = method;
        this.f24362b = threadMode;
        this.f24363c = cls;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SubscriberMethod)) {
            return null;
        }
        m26019a();
        SubscriberMethod subscriberMethod = (SubscriberMethod) obj;
        subscriberMethod.m26019a();
        return this.f24364d.equals(subscriberMethod.f24364d);
    }

    private synchronized void m26019a() {
        if (this.f24364d == null) {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append(this.f24361a.getDeclaringClass().getName());
            stringBuilder.append('#');
            stringBuilder.append(this.f24361a.getName());
            stringBuilder.append('(');
            stringBuilder.append(this.f24363c.getName());
            this.f24364d = stringBuilder.toString();
        }
    }

    public final int hashCode() {
        return this.f24361a.hashCode();
    }
}
