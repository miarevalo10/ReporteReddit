package com.birbit.android.jobqueue.messaging;

import com.birbit.android.jobqueue.log.JqLog;
import java.util.Arrays;

public class MessageFactory {
    Message[] f2988a = new Message[Type.values().length];
    int[] f2989b = new int[this.f2988a.length];

    public MessageFactory() {
        Arrays.fill(this.f2989b, 0);
    }

    public final <T extends Message> T m2566a(Class<T> cls) {
        StringBuilder stringBuilder;
        Type type = (Type) Type.f3001m.get(cls);
        synchronized (type) {
            T t = this.f2988a[type.ordinal()];
            if (t != null) {
                this.f2988a[type.ordinal()] = t.f2986b;
                cls = this.f2989b;
                int ordinal = type.ordinal();
                cls[ordinal] = cls[ordinal] - 1;
                t.f2986b = null;
                return t;
            }
            try {
                Message message = (Message) cls.newInstance();
                return message;
            } catch (Throwable e) {
                stringBuilder = new StringBuilder("Cannot create an instance of ");
                stringBuilder.append(cls);
                stringBuilder.append(". Make sure it has a empty constructor.");
                JqLog.m2559a(e, stringBuilder.toString(), new Object[0]);
                return null;
            } catch (Throwable e2) {
                stringBuilder = new StringBuilder("Cannot create an instance of ");
                stringBuilder.append(cls);
                stringBuilder.append(". Make sure it has a public empty constructor.");
                JqLog.m2559a(e2, stringBuilder.toString(), new Object[0]);
                return null;
            }
        }
    }

    public final void m2567a(Message message) {
        Type type = message.f2985a;
        message.f2986b = null;
        message.f2987c = Long.MIN_VALUE;
        message.mo823a();
        synchronized (type) {
            if (this.f2989b[type.ordinal()] < 20) {
                message.f2986b = this.f2988a[type.ordinal()];
                this.f2988a[type.ordinal()] = message;
                message = this.f2989b;
                int ordinal = type.ordinal();
                message[ordinal] = message[ordinal] + 1;
            }
        }
    }
}
