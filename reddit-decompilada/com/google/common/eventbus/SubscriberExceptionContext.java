package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.Method;

public class SubscriberExceptionContext {
    final EventBus f8495a;
    final Object f8496b;
    final Object f8497c;
    final Method f8498d;

    SubscriberExceptionContext(EventBus eventBus, Object obj, Object obj2, Method method) {
        this.f8495a = (EventBus) Preconditions.m6908a((Object) eventBus);
        this.f8496b = Preconditions.m6908a(obj);
        this.f8497c = Preconditions.m6908a(obj2);
        this.f8498d = (Method) Preconditions.m6908a((Object) method);
    }
}
