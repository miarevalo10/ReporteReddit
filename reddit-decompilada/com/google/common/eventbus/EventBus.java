package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventBus {
    private static final Logger logger = Logger.getLogger(EventBus.class.getName());
    private final Dispatcher dispatcher;
    private final SubscriberExceptionHandler exceptionHandler;
    private final Executor executor;
    private final String identifier;
    private final SubscriberRegistry subscribers;

    static final class LoggingHandler implements SubscriberExceptionHandler {
        static final LoggingHandler f14940a = new LoggingHandler();

        LoggingHandler() {
        }

        public final void mo2428a(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(EventBus.class.getName());
            stringBuilder.append(".");
            stringBuilder.append(subscriberExceptionContext.f8495a.identifier());
            Logger logger = Logger.getLogger(stringBuilder.toString());
            if (logger.isLoggable(Level.SEVERE)) {
                Level level = Level.SEVERE;
                Method method = subscriberExceptionContext.f8498d;
                StringBuilder stringBuilder2 = new StringBuilder("Exception thrown by subscriber method ");
                stringBuilder2.append(method.getName());
                stringBuilder2.append('(');
                stringBuilder2.append(method.getParameterTypes()[0].getName());
                stringBuilder2.append(')');
                stringBuilder2.append(" on subscriber ");
                stringBuilder2.append(subscriberExceptionContext.f8497c);
                stringBuilder2.append(" when dispatching event: ");
                stringBuilder2.append(subscriberExceptionContext.f8496b);
                logger.log(level, stringBuilder2.toString(), th);
            }
        }
    }

    public EventBus() {
        this("default");
    }

    public EventBus(String str) {
        this(str, MoreExecutors.m7338a(), Dispatcher.m7266a(), LoggingHandler.f14940a);
    }

    public EventBus(SubscriberExceptionHandler subscriberExceptionHandler) {
        this("default", MoreExecutors.m7338a(), Dispatcher.m7266a(), subscriberExceptionHandler);
    }

    EventBus(String str, Executor executor, Dispatcher dispatcher, SubscriberExceptionHandler subscriberExceptionHandler) {
        this.subscribers = new SubscriberRegistry(this);
        this.identifier = (String) Preconditions.m6908a((Object) str);
        this.executor = (Executor) Preconditions.m6908a((Object) executor);
        this.dispatcher = (Dispatcher) Preconditions.m6908a((Object) dispatcher);
        this.exceptionHandler = (SubscriberExceptionHandler) Preconditions.m6908a((Object) subscriberExceptionHandler);
    }

    public final String identifier() {
        return this.identifier;
    }

    final Executor executor() {
        return this.executor;
    }

    void handleSubscriberException(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
        Preconditions.m6908a((Object) th);
        Preconditions.m6908a((Object) subscriberExceptionContext);
        try {
            this.exceptionHandler.mo2428a(th, subscriberExceptionContext);
        } catch (SubscriberExceptionContext subscriberExceptionContext2) {
            logger.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", new Object[]{subscriberExceptionContext2, th}), subscriberExceptionContext2);
        }
    }

    public void register(Object obj) {
        SubscriberRegistry subscriberRegistry = this.subscribers;
        for (Entry entry : subscriberRegistry.m7277a(obj).mo2388f().entrySet()) {
            Class cls = (Class) entry.getKey();
            Collection collection = (Collection) entry.getValue();
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) subscriberRegistry.f8503a.get(cls);
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = new CopyOnWriteArraySet();
                copyOnWriteArraySet = (CopyOnWriteArraySet) MoreObjects.m6895a(subscriberRegistry.f8503a.putIfAbsent(cls, copyOnWriteArraySet), copyOnWriteArraySet);
            }
            copyOnWriteArraySet.addAll(collection);
        }
    }

    public void unregister(Object obj) {
        SubscriberRegistry subscriberRegistry = this.subscribers;
        for (Entry entry : subscriberRegistry.m7277a(obj).mo2388f().entrySet()) {
            Class cls = (Class) entry.getKey();
            Collection collection = (Collection) entry.getValue();
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) subscriberRegistry.f8503a.get(cls);
            if (copyOnWriteArraySet != null) {
                if (!copyOnWriteArraySet.removeAll(collection)) {
                }
            }
            StringBuilder stringBuilder = new StringBuilder("missing event subscriber for an annotated method. Is ");
            stringBuilder.append(obj);
            stringBuilder.append(" registered?");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public void post(Object obj) {
        SubscriberRegistry subscriberRegistry = this.subscribers;
        ImmutableSet a = SubscriberRegistry.m7275a(obj.getClass());
        List a2 = Lists.m7160a(a.size());
        Iterator a3 = a.mo2397a();
        while (a3.hasNext()) {
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) subscriberRegistry.f8503a.get((Class) a3.next());
            if (copyOnWriteArraySet != null) {
                a2.add(copyOnWriteArraySet.iterator());
            }
        }
        Iterator d = Iterators.m7156d(a2.iterator());
        if (d.hasNext()) {
            this.dispatcher.mo2427a(obj, d);
            return;
        }
        if (!(obj instanceof DeadEvent)) {
            post(new DeadEvent(this, obj));
        }
    }

    public String toString() {
        return MoreObjects.m6894a(this).m6890a(this.identifier).toString();
    }
}
