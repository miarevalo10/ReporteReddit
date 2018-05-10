package com.birbit.android.jobqueue.messaging;

import com.birbit.android.jobqueue.log.JqLog;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.util.concurrent.atomic.AtomicInteger;

public class UnsafeMessageQueue {
    private static final AtomicInteger f3006a = new AtomicInteger(0);
    public Message f3007e = null;
    public Message f3008f = null;
    public final String f3009g;
    public final MessageFactory f3010h;

    public UnsafeMessageQueue(MessageFactory messageFactory, String str) {
        this.f3010h = messageFactory;
        messageFactory = new StringBuilder();
        messageFactory.append(str);
        messageFactory.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        messageFactory.append(f3006a.incrementAndGet());
        this.f3009g = messageFactory.toString();
    }

    final Message m2574c() {
        Message message = this.f3007e;
        JqLog.m2558a("[%s] remove message %s", this.f3009g, message);
        if (message != null) {
            this.f3007e = message.f2986b;
            if (this.f3008f == message) {
                this.f3008f = null;
            }
        }
        return message;
    }

    protected void mo821a(Message message) {
        JqLog.m2558a("[%s] post message %s", this.f3009g, message);
        if (this.f3008f == null) {
            this.f3007e = message;
            this.f3008f = message;
            return;
        }
        this.f3008f.f2986b = message;
        this.f3008f = message;
    }

    public void mo822b() {
        while (this.f3007e != null) {
            Message message = this.f3007e;
            this.f3007e = message.f2986b;
            this.f3010h.m2567a(message);
        }
        this.f3008f = null;
    }
}
