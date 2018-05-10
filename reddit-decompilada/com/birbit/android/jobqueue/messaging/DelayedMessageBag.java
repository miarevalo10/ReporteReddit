package com.birbit.android.jobqueue.messaging;

import com.birbit.android.jobqueue.log.JqLog;

public class DelayedMessageBag {
    public Message f2983a = null;
    public final MessageFactory f2984b;

    DelayedMessageBag(MessageFactory messageFactory) {
        this.f2984b = messageFactory;
    }

    final Long m2563a(long j, MessageQueue messageQueue) {
        JqLog.m2558a("flushing messages at time %s", Long.valueOf(j));
        while (this.f2983a != null && this.f2983a.f2987c <= j) {
            Message message = this.f2983a;
            this.f2983a = message.f2986b;
            message.f2986b = null;
            messageQueue.mo821a(message);
        }
        if (this.f2983a == null) {
            return null;
        }
        JqLog.m2558a("returning next ready at %d ns", Long.valueOf(this.f2983a.f2987c - j));
        return Long.valueOf(this.f2983a.f2987c);
    }

    public final void m2564a(Message message, long j) {
        JqLog.m2558a("add delayed message %s at time %s", message, Long.valueOf(j));
        message.f2987c = j;
        if (this.f2983a == null) {
            this.f2983a = message;
            return;
        }
        Message message2 = null;
        Message message3 = this.f2983a;
        while (true) {
            Message message4 = message3;
            message3 = message2;
            message2 = message4;
            if (message2 != null && message2.f2987c <= j) {
                message3 = message2.f2986b;
            } else if (message3 != null) {
                message.f2986b = this.f2983a;
                this.f2983a = message;
            } else {
                message3.f2986b = message;
                message.f2986b = message2;
                return;
            }
        }
        if (message3 != null) {
            message3.f2986b = message;
            message.f2986b = message2;
            return;
        }
        message.f2986b = this.f2983a;
        this.f2983a = message;
    }
}
