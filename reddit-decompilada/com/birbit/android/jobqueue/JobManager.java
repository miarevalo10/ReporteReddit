package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.config.Configuration;
import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.MessageFactory;
import com.birbit.android.jobqueue.messaging.PriorityMessageQueue;
import com.birbit.android.jobqueue.messaging.message.AddJobMessage;
import com.birbit.android.jobqueue.messaging.message.CancelMessage;
import com.birbit.android.jobqueue.scheduling.Scheduler;
import com.birbit.android.jobqueue.scheduling.Scheduler.Callback;
import java.util.concurrent.TimeUnit;

public class JobManager {
    public static final long f2927a = TimeUnit.MILLISECONDS.toNanos(10000);
    final JobManagerThread f2928b;
    private final PriorityMessageQueue f2929c;
    private final MessageFactory f2930d = new MessageFactory();
    private Thread f2931e;
    private Scheduler f2932f;

    class C10441 implements Callback {
        final /* synthetic */ JobManager f12143a;

        C10441(JobManager jobManager) {
            this.f12143a = jobManager;
        }
    }

    public JobManager(Configuration configuration) {
        this.f2929c = new PriorityMessageQueue(configuration.f2974k, this.f2930d);
        this.f2928b = new JobManagerThread(configuration, this.f2929c, this.f2930d);
        this.f2931e = new Thread(this.f2928b, "job-manager");
        if (configuration.f2975l != null) {
            this.f2932f = configuration.f2975l;
            configuration.f2975l.mo796a(configuration.f2969f, new C10441(this));
        }
        this.f2931e.start();
    }

    public final void m2521a(Job job) {
        Message message = (AddJobMessage) this.f2930d.m2566a(AddJobMessage.class);
        message.f12183d = job;
        this.f2929c.mo821a(message);
    }

    public final void m2522a(TagConstraint tagConstraint, String... strArr) {
        if (tagConstraint == null) {
            throw new IllegalArgumentException("must provide a TagConstraint");
        }
        Message message = (CancelMessage) this.f2930d.m2566a(CancelMessage.class);
        message.f12191f = null;
        message.f12189d = tagConstraint;
        message.f12190e = strArr;
        this.f2929c.mo821a(message);
    }
}
