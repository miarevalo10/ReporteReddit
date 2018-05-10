package com.birbit.android.jobqueue.messaging;

import com.birbit.android.jobqueue.messaging.message.AddJobMessage;
import com.birbit.android.jobqueue.messaging.message.CallbackMessage;
import com.birbit.android.jobqueue.messaging.message.CancelMessage;
import com.birbit.android.jobqueue.messaging.message.CancelResultMessage;
import com.birbit.android.jobqueue.messaging.message.CommandMessage;
import com.birbit.android.jobqueue.messaging.message.ConstraintChangeMessage;
import com.birbit.android.jobqueue.messaging.message.JobConsumerIdleMessage;
import com.birbit.android.jobqueue.messaging.message.PublicQueryMessage;
import com.birbit.android.jobqueue.messaging.message.RunJobMessage;
import com.birbit.android.jobqueue.messaging.message.RunJobResultMessage;
import com.birbit.android.jobqueue.messaging.message.SchedulerMessage;
import java.util.HashMap;
import java.util.Map;

public enum Type {
    CALLBACK(CallbackMessage.class, 0),
    CANCEL_RESULT_CALLBACK(CancelResultMessage.class, 0),
    RUN_JOB(RunJobMessage.class, 0),
    COMMAND(CommandMessage.class, 0),
    PUBLIC_QUERY(PublicQueryMessage.class, 0),
    JOB_CONSUMER_IDLE(JobConsumerIdleMessage.class, 0),
    ADD_JOB(AddJobMessage.class, 1),
    CANCEL(CancelMessage.class, 1),
    CONSTRAINT_CHANGE(ConstraintChangeMessage.class, 2),
    RUN_JOB_RESULT(RunJobResultMessage.class, 3),
    SCHEDULER(SchedulerMessage.class, 4);
    
    static final Map<Class<? extends Message>, Type> f3001m = null;
    public static final int f3002o = 0;
    final Class<? extends Message> f3004l;
    final int f3005n;

    static {
        f3001m = new HashMap();
        Type[] values = values();
        int length = values.length;
        int i = 0;
        int i2;
        while (i2 < length) {
            Type type = values[i2];
            f3001m.put(type.f3004l, type);
            if (type.f3005n > i) {
                i = type.f3005n;
            }
            i2++;
        }
        f3002o = i;
    }

    private Type(Class<? extends Message> cls, int i) {
        this.f3004l = cls;
        this.f3005n = i;
    }
}
