package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

abstract class Dispatcher {

    private static final class LegacyAsyncDispatcher extends Dispatcher {
        private final ConcurrentLinkedQueue<EventWithSubscriber> f14937a;

        private static final class EventWithSubscriber {
            private final Object f8483a;
            private final Subscriber f8484b;

            private EventWithSubscriber(Object obj, Subscriber subscriber) {
                this.f8483a = obj;
                this.f8484b = subscriber;
            }
        }

        private LegacyAsyncDispatcher() {
            this.f14937a = Queues.m7251b();
        }

        final void mo2427a(Object obj, Iterator<Subscriber> it) {
            Preconditions.m6908a(obj);
            while (it.hasNext()) {
                this.f14937a.add(new EventWithSubscriber(obj, (Subscriber) it.next()));
            }
            while (true) {
                EventWithSubscriber eventWithSubscriber = (EventWithSubscriber) this.f14937a.poll();
                if (eventWithSubscriber != null) {
                    eventWithSubscriber.f8484b.m7272a(eventWithSubscriber.f8483a);
                } else {
                    return;
                }
            }
        }
    }

    private static final class PerThreadQueuedDispatcher extends Dispatcher {
        private final ThreadLocal<Queue<Event>> f14938a;
        private final ThreadLocal<Boolean> f14939b;

        class C04461 extends ThreadLocal<Queue<Event>> {
            final /* synthetic */ PerThreadQueuedDispatcher f8485a;

            C04461(PerThreadQueuedDispatcher perThreadQueuedDispatcher) {
                this.f8485a = perThreadQueuedDispatcher;
            }

            protected /* synthetic */ Object initialValue() {
                return Queues.m7250a();
            }
        }

        class C04472 extends ThreadLocal<Boolean> {
            final /* synthetic */ PerThreadQueuedDispatcher f8486a;

            C04472(PerThreadQueuedDispatcher perThreadQueuedDispatcher) {
                this.f8486a = perThreadQueuedDispatcher;
            }

            protected /* synthetic */ Object initialValue() {
                return Boolean.valueOf(false);
            }
        }

        private static final class Event {
            private final Object f8487a;
            private final Iterator<Subscriber> f8488b;

            private Event(Object obj, Iterator<Subscriber> it) {
                this.f8487a = obj;
                this.f8488b = it;
            }
        }

        private PerThreadQueuedDispatcher() {
            this.f14938a = new C04461(this);
            this.f14939b = new C04472(this);
        }

        final void mo2427a(java.lang.Object r4, java.util.Iterator<com.google.common.eventbus.Subscriber> r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            com.google.common.base.Preconditions.m6908a(r4);
            com.google.common.base.Preconditions.m6908a(r5);
            r0 = r3.f14938a;
            r0 = r0.get();
            r0 = (java.util.Queue) r0;
            r1 = new com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event;
            r2 = 0;
            r1.<init>(r4, r5);
            r0.offer(r1);
            r4 = r3.f14939b;
            r4 = r4.get();
            r4 = (java.lang.Boolean) r4;
            r4 = r4.booleanValue();
            if (r4 != 0) goto L_0x006a;
        L_0x0025:
            r4 = r3.f14939b;
            r5 = 1;
            r5 = java.lang.Boolean.valueOf(r5);
            r4.set(r5);
        L_0x002f:
            r4 = r0.poll();	 Catch:{ all -> 0x005e }
            r4 = (com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event) r4;	 Catch:{ all -> 0x005e }
            if (r4 == 0) goto L_0x0053;	 Catch:{ all -> 0x005e }
        L_0x0037:
            r5 = r4.f8488b;	 Catch:{ all -> 0x005e }
            r5 = r5.hasNext();	 Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x002f;	 Catch:{ all -> 0x005e }
        L_0x0041:
            r5 = r4.f8488b;	 Catch:{ all -> 0x005e }
            r5 = r5.next();	 Catch:{ all -> 0x005e }
            r5 = (com.google.common.eventbus.Subscriber) r5;	 Catch:{ all -> 0x005e }
            r1 = r4.f8487a;	 Catch:{ all -> 0x005e }
            r5.m7272a(r1);	 Catch:{ all -> 0x005e }
            goto L_0x0037;
        L_0x0053:
            r4 = r3.f14939b;
            r4.remove();
            r4 = r3.f14938a;
            r4.remove();
            return;
        L_0x005e:
            r4 = move-exception;
            r5 = r3.f14939b;
            r5.remove();
            r5 = r3.f14938a;
            r5.remove();
            throw r4;
        L_0x006a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.a(java.lang.Object, java.util.Iterator):void");
        }
    }

    abstract void mo2427a(Object obj, Iterator<Subscriber> it);

    Dispatcher() {
    }

    static Dispatcher m7266a() {
        return new PerThreadQueuedDispatcher();
    }

    static Dispatcher m7267b() {
        return new LegacyAsyncDispatcher();
    }
}
