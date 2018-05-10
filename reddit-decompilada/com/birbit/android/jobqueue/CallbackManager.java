package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.MessageFactory;
import com.birbit.android.jobqueue.messaging.MessageQueueConsumer;
import com.birbit.android.jobqueue.messaging.SafeMessageQueue;
import com.birbit.android.jobqueue.messaging.Type;
import com.birbit.android.jobqueue.messaging.message.CallbackMessage;
import com.birbit.android.jobqueue.messaging.message.CommandMessage;
import com.birbit.android.jobqueue.timer.Timer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class CallbackManager {
    final SafeMessageQueue f2834a;
    final MessageFactory f2835b;
    private final CopyOnWriteArrayList<Object> f2836c;
    private final AtomicInteger f2837d = new AtomicInteger(0);
    private final Timer f2838e;
    private final AtomicBoolean f2839f = new AtomicBoolean(false);

    class C02472 implements Runnable {
        final /* synthetic */ CallbackManager f2833a;

        class C10411 extends MessageQueueConsumer {
            long f12139a = Long.MIN_VALUE;
            final /* synthetic */ C02472 f12140b;

            public final void mo799a() {
            }

            C10411(C02472 c02472) {
                this.f12140b = c02472;
            }

            public final void mo800a(Message message) {
                if (message.f2985a == Type.f2990a) {
                    CallbackManager.m2474a(this.f12140b.f2833a, (CallbackMessage) message);
                    this.f12139a = this.f12140b.f2833a.f2838e.mo829a();
                } else if (message.f2985a == Type.f2991b) {
                    this.f12140b.f2833a.m2477a();
                    this.f12139a = this.f12140b.f2833a.f2838e.mo829a();
                } else if (message.f2985a == Type.f2993d) {
                    CommandMessage commandMessage = (CommandMessage) message;
                    int i = commandMessage.f12194d;
                    if (i == 1) {
                        this.f12140b.f2833a.f2834a.m11062a();
                        this.f12140b.f2833a.f2839f.set(false);
                        return;
                    }
                    if (i == 3) {
                        commandMessage.f12195e.run();
                    }
                } else {
                    message = Type.f2994e;
                }
            }
        }

        C02472(CallbackManager callbackManager) {
            this.f2833a = callbackManager;
        }

        public void run() {
            this.f2833a.f2834a.m11064a(new C10411(this));
        }
    }

    public CallbackManager(MessageFactory messageFactory, Timer timer) {
        this.f2838e = timer;
        this.f2834a = new SafeMessageQueue(timer, messageFactory, "jq_callback");
        this.f2836c = new CopyOnWriteArrayList();
        this.f2835b = messageFactory;
    }

    final void m2477a() {
        if (!this.f2839f.getAndSet(true)) {
            new Thread(new C02472(this), "job-manager-callbacks").start();
        }
    }

    final boolean m2480b() {
        return this.f2837d.get() > 0;
    }

    public final void m2479a(Job job, boolean z, Throwable th) {
        if (m2480b()) {
            Message message = (CallbackMessage) this.f2835b.m2566a(CallbackMessage.class);
            message.f12184d = 3;
            message.f12186f = z;
            message.f12187g = job;
            message.f12188h = th;
            this.f2834a.mo821a(message);
        }
    }

    public final void m2478a(Job job) {
        if (m2480b()) {
            Message message = (CallbackMessage) this.f2835b.m2566a(CallbackMessage.class);
            message.m11068a(job, 4);
            this.f2834a.mo821a(message);
        }
    }

    static /* synthetic */ void m2474a(CallbackManager callbackManager, CallbackMessage callbackMessage) {
        switch (callbackMessage.f12184d) {
            case 1:
                callbackManager = callbackManager.f2836c.iterator();
                while (callbackManager.hasNext() != null) {
                    callbackManager.next();
                }
                return;
            case 2:
                callbackManager = callbackManager.f2836c.iterator();
                while (callbackManager.hasNext() != null) {
                    callbackManager.next();
                }
                break;
            case 3:
                callbackManager = callbackManager.f2836c.iterator();
                while (callbackManager.hasNext() != null) {
                    callbackManager.next();
                }
                return;
            case 4:
                callbackManager = callbackManager.f2836c.iterator();
                while (callbackManager.hasNext() != null) {
                    callbackManager.next();
                }
                return;
            case 5:
                callbackManager = callbackManager.f2836c.iterator();
                while (callbackManager.hasNext() != null) {
                    callbackManager.next();
                }
                return;
            default:
                break;
        }
    }
}
