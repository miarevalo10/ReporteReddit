package com.birbit.android.jobqueue;

import android.content.Context;
import com.birbit.android.jobqueue.JobHolder.Builder;
import com.birbit.android.jobqueue.config.Configuration;
import com.birbit.android.jobqueue.di.DependencyInjector;
import com.birbit.android.jobqueue.log.JqLog;
import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.MessageFactory;
import com.birbit.android.jobqueue.messaging.MessageQueueConsumer;
import com.birbit.android.jobqueue.messaging.PriorityMessageQueue;
import com.birbit.android.jobqueue.messaging.SafeMessageQueue;
import com.birbit.android.jobqueue.messaging.Type;
import com.birbit.android.jobqueue.messaging.UnsafeMessageQueue;
import com.birbit.android.jobqueue.messaging.message.AddJobMessage;
import com.birbit.android.jobqueue.messaging.message.CallbackMessage;
import com.birbit.android.jobqueue.messaging.message.CancelMessage;
import com.birbit.android.jobqueue.messaging.message.CommandMessage;
import com.birbit.android.jobqueue.messaging.message.ConstraintChangeMessage;
import com.birbit.android.jobqueue.messaging.message.JobConsumerIdleMessage;
import com.birbit.android.jobqueue.messaging.message.PublicQueryMessage;
import com.birbit.android.jobqueue.messaging.message.RunJobResultMessage;
import com.birbit.android.jobqueue.messaging.message.SchedulerMessage;
import com.birbit.android.jobqueue.network.NetworkEventProvider;
import com.birbit.android.jobqueue.network.NetworkEventProvider.Listener;
import com.birbit.android.jobqueue.network.NetworkUtil;
import com.birbit.android.jobqueue.scheduling.Scheduler;
import com.birbit.android.jobqueue.scheduling.SchedulerConstraint;
import com.birbit.android.jobqueue.timer.Timer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

class JobManagerThread implements Listener, Runnable {
    final Timer f12145a;
    final Context f12146b;
    final JobQueue f12147c;
    final JobQueue f12148d;
    final NetworkUtil f12149e;
    final ConsumerManager f12150f;
    final Constraint f12151g = new Constraint();
    final CallbackManager f12152h;
    boolean f12153i = true;
    final PriorityMessageQueue f12154j;
    Scheduler f12155k;
    private final long f12156l;
    private final DependencyInjector f12157m;
    private final MessageFactory f12158n;
    private List<CancelHandler> f12159o;
    private List<SchedulerConstraint> f12160p;
    private boolean f12161q = false;
    private boolean f12162r = true;

    class C10451 extends MessageQueueConsumer {
        final /* synthetic */ JobManagerThread f12144a;

        C10451(JobManagerThread jobManagerThread) {
            this.f12144a = jobManagerThread;
        }

        public final void mo800a(Message message) {
            boolean z = true;
            this.f12144a.f12162r = true;
            switch (message.f2985a) {
                case ADD_JOB:
                    JobManagerThread.m11005a(this.f12144a, (AddJobMessage) message);
                    return;
                case JOB_CONSUMER_IDLE:
                    if (this.f12144a.f12150f.m2491a((JobConsumerIdleMessage) message) == null) {
                        JobManagerThread.m11004a(this.f12144a);
                        return;
                    }
                    break;
                case RUN_JOB_RESULT:
                    JobManagerThread.m11009a(this.f12144a, (RunJobResultMessage) message);
                    return;
                case CONSTRAINT_CHANGE:
                    boolean a = this.f12144a.f12150f.m2493a(true);
                    ConstraintChangeMessage constraintChangeMessage = (ConstraintChangeMessage) message;
                    JobManagerThread jobManagerThread = this.f12144a;
                    if (!a) {
                        if (constraintChangeMessage.f12196d != null) {
                            z = false;
                        }
                    }
                    jobManagerThread.f12162r = z;
                    return;
                case CANCEL:
                    JobManagerThread.m11006a(this.f12144a, (CancelMessage) message);
                    return;
                case PUBLIC_QUERY:
                    JobManagerThread.m11008a(this.f12144a, (PublicQueryMessage) message);
                    return;
                case COMMAND:
                    JobManagerThread.m11007a(this.f12144a, (CommandMessage) message);
                    return;
                case SCHEDULER:
                    JobManagerThread.m11010a(this.f12144a, (SchedulerMessage) message);
                    break;
                default:
                    break;
            }
        }

        public final void mo799a() {
            JqLog.m2562c("joq idle. running:? %s", Boolean.valueOf(this.f12144a.f12153i));
            if (!this.f12144a.f12153i) {
                return;
            }
            if (this.f12144a.f12162r) {
                Long l;
                JobManagerThread jobManagerThread = this.f12144a;
                RunningJobSet runningJobSet = jobManagerThread.f12150f.f2870f;
                if (runningJobSet.f2954a == Long.MAX_VALUE) {
                    l = null;
                } else {
                    l = Long.valueOf(runningJobSet.f2954a);
                }
                int b = jobManagerThread.m11024b();
                Collection a = jobManagerThread.f12150f.f2870f.m2541a();
                jobManagerThread.f12151g.m2483a();
                jobManagerThread.f12151g.f2855h = jobManagerThread.f12145a.mo829a();
                jobManagerThread.f12151g.f2848a = b;
                jobManagerThread.f12151g.m2484a(a);
                jobManagerThread.f12151g.f2853f = true;
                Long c = jobManagerThread.f12148d.mo813c(jobManagerThread.f12151g);
                Long c2 = jobManagerThread.f12147c.mo813c(jobManagerThread.f12151g);
                if (l == null) {
                    l = null;
                }
                if (c != null) {
                    l = Long.valueOf(l == null ? c.longValue() : Math.min(c.longValue(), l.longValue()));
                }
                if (c2 != null) {
                    l = Long.valueOf(l == null ? c2.longValue() : Math.min(c2.longValue(), l.longValue()));
                }
                if (!(jobManagerThread.f12149e instanceof NetworkEventProvider)) {
                    long a2 = jobManagerThread.f12145a.mo829a() + JobManager.f2927a;
                    if (l != null) {
                        a2 = Math.min(a2, l.longValue());
                    }
                    l = Long.valueOf(a2);
                }
                JqLog.m2558a("Job queue idle. next job at: %s", l);
                if (l != null) {
                    Message message = (ConstraintChangeMessage) this.f12144a.f12158n.m2566a(ConstraintChangeMessage.class);
                    message.f12196d = true;
                    PriorityMessageQueue priorityMessageQueue = this.f12144a.f12154j;
                    long longValue = l.longValue();
                    synchronized (priorityMessageQueue.f12170a) {
                        priorityMessageQueue.f12175f = true;
                        priorityMessageQueue.f12172c.m2564a(message, longValue);
                        priorityMessageQueue.f12173d.mo832b(priorityMessageQueue.f12170a);
                    }
                    return;
                }
                if (this.f12144a.f12155k != null && this.f12144a.f12161q && this.f12144a.f12147c.mo805a() == 0) {
                    this.f12144a.f12161q = false;
                    this.f12144a.f12155k.mo795a();
                }
                return;
            }
            JqLog.m2562c("skipping scheduling a new idle callback because looks like last one did not do anything", new Object[0]);
        }
    }

    JobManagerThread(Configuration configuration, PriorityMessageQueue priorityMessageQueue, MessageFactory messageFactory) {
        this.f12154j = priorityMessageQueue;
        if (configuration.f2973j != null) {
            JqLog.m2557a(configuration.f2973j);
        }
        this.f12158n = messageFactory;
        this.f12145a = configuration.f2974k;
        this.f12146b = configuration.f2969f;
        this.f12156l = this.f12145a.mo829a();
        this.f12155k = configuration.f2975l;
        if (!(this.f12155k == null || configuration.f2979p == null || (this.f12155k instanceof BatchingScheduler) != null)) {
            this.f12155k = new BatchingScheduler(this.f12155k, this.f12145a);
        }
        this.f12147c = configuration.f2970g.mo803a(configuration, this.f12156l);
        this.f12148d = configuration.f2970g.mo802a(this.f12156l);
        this.f12149e = configuration.f2972i;
        this.f12157m = configuration.f2971h;
        if ((this.f12149e instanceof NetworkEventProvider) != null) {
            ((NetworkEventProvider) this.f12149e).mo825a(this);
        }
        this.f12150f = new ConsumerManager(this, this.f12145a, messageFactory, configuration);
        this.f12152h = new CallbackManager(messageFactory, this.f12145a);
    }

    public void run() {
        PriorityMessageQueue priorityMessageQueue = this.f12154j;
        MessageQueueConsumer c10451 = new C10451(this);
        if (priorityMessageQueue.f12174e.getAndSet(true)) {
            throw new IllegalStateException("only 1 consumer per MQ");
        }
        while (priorityMessageQueue.f12174e.get()) {
            Message a = priorityMessageQueue.m11059a(c10451);
            if (a != null) {
                JqLog.m2558a("[%s] consuming message of type %s", "priority_mq", a.f2985a);
                c10451.mo800a(a);
                priorityMessageQueue.f12176g.m2567a(a);
            }
        }
    }

    private boolean m11012a(SchedulerConstraint schedulerConstraint) {
        boolean z;
        for (JobHolder jobHolder : this.f12150f.f2869e.values()) {
            if (jobHolder.f2921m.f2883d && schedulerConstraint.f3079c >= jobHolder.f2918j) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            return true;
        }
        this.f12151g.m2483a();
        this.f12151g.f2855h = this.f12145a.mo829a();
        this.f12151g.f2848a = schedulerConstraint.f3079c;
        return this.f12147c.mo806a(this.f12151g) > null;
    }

    private void m11014b(SchedulerConstraint schedulerConstraint) {
        List list = this.f12160p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (((SchedulerConstraint) list.get(size)).f3077a.equals(schedulerConstraint.f3077a)) {
                    list.remove(size);
                }
            }
        }
        if (this.f12155k != null && m11012a(schedulerConstraint)) {
            this.f12155k.mo797a(schedulerConstraint);
        }
    }

    final void m11023a(JobHolder jobHolder, int i) {
        try {
            jobHolder.m2515a(i);
        } catch (int i2) {
            JqLog.m2559a(i2, "job's onCancel did throw an exception, ignoring...", new Object[0]);
        }
        this.f12152h.m2479a(jobHolder.f2921m, false, jobHolder.f2926r);
    }

    public final void mo804a() {
        this.f12154j.mo821a((ConstraintChangeMessage) this.f12158n.m2566a(ConstraintChangeMessage.class));
    }

    final int m11020a(int i) {
        Collection a = this.f12150f.f2870f.m2541a();
        this.f12151g.m2483a();
        this.f12151g.f2855h = this.f12145a.mo829a();
        this.f12151g.f2848a = i;
        this.f12151g.m2484a(a);
        this.f12151g.f2853f = true;
        this.f12151g.f2854g = Long.valueOf(this.f12145a.mo829a());
        return (0 + this.f12148d.mo806a(this.f12151g)) + this.f12147c.mo806a(this.f12151g);
    }

    final int m11024b() {
        return this.f12149e == null ? 2 : this.f12149e.mo824a(this.f12146b);
    }

    private void m11013b(JobHolder jobHolder) {
        if (jobHolder.f2923o) {
            StringBuilder stringBuilder = new StringBuilder("not re-adding cancelled job ");
            stringBuilder.append(jobHolder);
            JqLog.m2558a(stringBuilder.toString(), new Object[0]);
        } else if (jobHolder.f2921m.f2883d) {
            this.f12147c.mo812b(jobHolder);
        } else {
            this.f12148d.mo812b(jobHolder);
        }
    }

    final void m11022a(JobHolder jobHolder) {
        if (jobHolder.f2921m.f2883d) {
            this.f12147c.mo814c(jobHolder);
        } else {
            this.f12148d.mo814c(jobHolder);
        }
        this.f12152h.m2478a(jobHolder.f2921m);
    }

    static /* synthetic */ void m11005a(JobManagerThread jobManagerThread, AddJobMessage addJobMessage) {
        JobHolder jobHolder;
        boolean z;
        JobQueue jobQueue;
        CallbackManager callbackManager;
        Job job;
        Message message;
        int i;
        long j;
        int i2;
        Long valueOf;
        boolean z2;
        SchedulerConstraint schedulerConstraint;
        JobManagerThread jobManagerThread2 = jobManagerThread;
        Job job2 = addJobMessage.f12183d;
        long a = jobManagerThread2.f12145a.mo829a();
        long j2 = job2.f2886g > 0 ? (job2.f2886g * 1000000) + a : Long.MIN_VALUE;
        long j3 = job2.f2887h > 0 ? (job2.f2887h * 1000000) + a : Long.MAX_VALUE;
        Builder a2 = new Builder().m2502a(job2.f2885f).m2505a(job2).m2506a(job2.f2882c).m2503a(a).m2511b(j2).m2512b(job2.f2880a).m2507a(job2.f2884e).m2508a(job2.f2883d);
        boolean z3 = false;
        a2.f2894a = 0;
        JobHolder a3 = a2.m2504a(j3, job2.f2888i).m2510b(job2.f2881b).m2513c(Long.MIN_VALUE).m2509a();
        if (job2.m2500d() != null) {
            jobManagerThread2.f12151g.m2483a();
            jobManagerThread2.f12151g.m2485a(new String[]{r6});
            jobManagerThread2.f12151g.f2849b = TagConstraint.ANY;
            jobManagerThread2.f12151g.f2848a = 2;
            Set<JobHolder> d = jobManagerThread2.f12148d.mo815d(jobManagerThread2.f12151g);
            d.addAll(jobManagerThread2.f12147c.mo815d(jobManagerThread2.f12151g));
            if (!d.isEmpty()) {
                for (JobHolder jobHolder2 : d) {
                    if (!jobManagerThread2.f12150f.m2492a(jobHolder2.f2910b)) {
                        jobHolder = jobHolder2;
                        break;
                    }
                }
                jobHolder = (JobHolder) d.iterator().next();
                if (jobHolder != null) {
                    if (jobManagerThread2.f12150f.m2492a(jobHolder.f2910b)) {
                        z = false;
                        if (z) {
                            JqLog.m2558a("another job with same singleId: %s was already queued", job2.m2500d());
                        } else {
                            jobQueue = job2.f2883d ? jobManagerThread2.f12147c : jobManagerThread2.f12148d;
                            if (jobHolder == null) {
                                jobManagerThread2.f12150f.m2489a(TagConstraint.ANY, new String[]{job2.m2500d()}, true);
                                jobQueue.mo808a(a3, jobHolder);
                            } else {
                                jobQueue.mo809a(a3);
                            }
                            JqLog.m2560a();
                        }
                        a3.m2517a(jobManagerThread2.f12146b);
                        a3.f2921m.mo3017a();
                        callbackManager = jobManagerThread2.f12152h;
                        job = a3.f2921m;
                        if (callbackManager.m2480b()) {
                            message = (CallbackMessage) callbackManager.f2835b.m2566a(CallbackMessage.class);
                            message.m11068a(job, 1);
                            callbackManager.f2834a.mo821a(message);
                        }
                        if (z) {
                            jobManagerThread2.m11023a(a3, 1);
                            jobManagerThread2.f12152h.m2478a(a3.f2921m);
                        } else {
                            jobManagerThread2.f12150f.m2493a(false);
                            if (job2.f2883d && jobManagerThread2.f12155k != null) {
                                i = a3.f2918j;
                                j3 = a3.f2915g;
                                j = a3.f2919k;
                                i2 = (j3 > a ? 1 : (j3 == a ? 0 : -1));
                                j3 = i2 <= 0 ? TimeUnit.NANOSECONDS.toMillis(j3 - a) : 0;
                                valueOf = j == Long.MAX_VALUE ? Long.valueOf(TimeUnit.NANOSECONDS.toMillis(j - a)) : null;
                                z2 = i2 <= 0 && j3 >= 30000;
                                if (valueOf != null && valueOf.longValue() >= 30000) {
                                    z3 = true;
                                }
                                if (i != 0 || z2 || r5) {
                                    schedulerConstraint = new SchedulerConstraint(UUID.randomUUID().toString());
                                    schedulerConstraint.f3079c = i;
                                    schedulerConstraint.f3078b = j3;
                                    schedulerConstraint.f3080d = valueOf;
                                    jobManagerThread2.f12155k.mo797a(schedulerConstraint);
                                    jobManagerThread2.f12161q = true;
                                }
                            }
                        }
                    }
                }
                z = true;
                if (z) {
                    JqLog.m2558a("another job with same singleId: %s was already queued", job2.m2500d());
                } else {
                    if (job2.f2883d) {
                    }
                    if (jobHolder == null) {
                        jobQueue.mo809a(a3);
                    } else {
                        jobManagerThread2.f12150f.m2489a(TagConstraint.ANY, new String[]{job2.m2500d()}, true);
                        jobQueue.mo808a(a3, jobHolder);
                    }
                    JqLog.m2560a();
                }
                a3.m2517a(jobManagerThread2.f12146b);
                a3.f2921m.mo3017a();
                callbackManager = jobManagerThread2.f12152h;
                job = a3.f2921m;
                if (callbackManager.m2480b()) {
                    message = (CallbackMessage) callbackManager.f2835b.m2566a(CallbackMessage.class);
                    message.m11068a(job, 1);
                    callbackManager.f2834a.mo821a(message);
                }
                if (z) {
                    jobManagerThread2.m11023a(a3, 1);
                    jobManagerThread2.f12152h.m2478a(a3.f2921m);
                } else {
                    jobManagerThread2.f12150f.m2493a(false);
                    i = a3.f2918j;
                    j3 = a3.f2915g;
                    j = a3.f2919k;
                    i2 = (j3 > a ? 1 : (j3 == a ? 0 : -1));
                    if (i2 <= 0) {
                    }
                    if (j == Long.MAX_VALUE) {
                    }
                    if (i2 <= 0) {
                    }
                    z3 = true;
                    schedulerConstraint = new SchedulerConstraint(UUID.randomUUID().toString());
                    schedulerConstraint.f3079c = i;
                    schedulerConstraint.f3078b = j3;
                    schedulerConstraint.f3080d = valueOf;
                    jobManagerThread2.f12155k.mo797a(schedulerConstraint);
                    jobManagerThread2.f12161q = true;
                }
            }
        }
        jobHolder = null;
        if (jobHolder != null) {
            if (jobManagerThread2.f12150f.m2492a(jobHolder.f2910b)) {
                z = false;
                if (z) {
                    if (job2.f2883d) {
                    }
                    if (jobHolder == null) {
                        jobManagerThread2.f12150f.m2489a(TagConstraint.ANY, new String[]{job2.m2500d()}, true);
                        jobQueue.mo808a(a3, jobHolder);
                    } else {
                        jobQueue.mo809a(a3);
                    }
                    JqLog.m2560a();
                } else {
                    JqLog.m2558a("another job with same singleId: %s was already queued", job2.m2500d());
                }
                a3.m2517a(jobManagerThread2.f12146b);
                a3.f2921m.mo3017a();
                callbackManager = jobManagerThread2.f12152h;
                job = a3.f2921m;
                if (callbackManager.m2480b()) {
                    message = (CallbackMessage) callbackManager.f2835b.m2566a(CallbackMessage.class);
                    message.m11068a(job, 1);
                    callbackManager.f2834a.mo821a(message);
                }
                if (z) {
                    jobManagerThread2.f12150f.m2493a(false);
                    i = a3.f2918j;
                    j3 = a3.f2915g;
                    j = a3.f2919k;
                    i2 = (j3 > a ? 1 : (j3 == a ? 0 : -1));
                    if (i2 <= 0) {
                    }
                    if (j == Long.MAX_VALUE) {
                    }
                    if (i2 <= 0) {
                    }
                    z3 = true;
                    schedulerConstraint = new SchedulerConstraint(UUID.randomUUID().toString());
                    schedulerConstraint.f3079c = i;
                    schedulerConstraint.f3078b = j3;
                    schedulerConstraint.f3080d = valueOf;
                    jobManagerThread2.f12155k.mo797a(schedulerConstraint);
                    jobManagerThread2.f12161q = true;
                }
                jobManagerThread2.m11023a(a3, 1);
                jobManagerThread2.f12152h.m2478a(a3.f2921m);
            }
        }
        z = true;
        if (z) {
            JqLog.m2558a("another job with same singleId: %s was already queued", job2.m2500d());
        } else {
            if (job2.f2883d) {
            }
            if (jobHolder == null) {
                jobQueue.mo809a(a3);
            } else {
                jobManagerThread2.f12150f.m2489a(TagConstraint.ANY, new String[]{job2.m2500d()}, true);
                jobQueue.mo808a(a3, jobHolder);
            }
            JqLog.m2560a();
        }
        a3.m2517a(jobManagerThread2.f12146b);
        a3.f2921m.mo3017a();
        callbackManager = jobManagerThread2.f12152h;
        job = a3.f2921m;
        if (callbackManager.m2480b()) {
            message = (CallbackMessage) callbackManager.f2835b.m2566a(CallbackMessage.class);
            message.m11068a(job, 1);
            callbackManager.f2834a.mo821a(message);
        }
        if (z) {
            jobManagerThread2.m11023a(a3, 1);
            jobManagerThread2.f12152h.m2478a(a3.f2921m);
        } else {
            jobManagerThread2.f12150f.m2493a(false);
            i = a3.f2918j;
            j3 = a3.f2915g;
            j = a3.f2919k;
            i2 = (j3 > a ? 1 : (j3 == a ? 0 : -1));
            if (i2 <= 0) {
            }
            if (j == Long.MAX_VALUE) {
            }
            if (i2 <= 0) {
            }
            z3 = true;
            schedulerConstraint = new SchedulerConstraint(UUID.randomUUID().toString());
            schedulerConstraint.f3079c = i;
            schedulerConstraint.f3078b = j3;
            schedulerConstraint.f3080d = valueOf;
            jobManagerThread2.f12155k.mo797a(schedulerConstraint);
            jobManagerThread2.f12161q = true;
        }
    }

    static /* synthetic */ void m11004a(JobManagerThread jobManagerThread) {
        if (!(jobManagerThread.f12155k == null || jobManagerThread.f12160p == null || jobManagerThread.f12160p.isEmpty())) {
            ConsumerManager consumerManager = jobManagerThread.f12150f;
            if ((consumerManager.f2865a.size() == consumerManager.f2866b.size() ? 1 : 0) != 0) {
                for (int size = jobManagerThread.f12160p.size() - 1; size >= 0; size--) {
                    SchedulerConstraint schedulerConstraint = (SchedulerConstraint) jobManagerThread.f12160p.remove(size);
                    jobManagerThread.f12155k.mo798a(schedulerConstraint, jobManagerThread.m11012a(schedulerConstraint));
                }
            }
        }
    }

    static /* synthetic */ void m11009a(JobManagerThread jobManagerThread, RunJobResultMessage runJobResultMessage) {
        int i = runJobResultMessage.f12205f;
        JobHolder jobHolder = runJobResultMessage.f12203d;
        CallbackManager callbackManager = jobManagerThread.f12152h;
        Job job = jobHolder.f2921m;
        if (callbackManager.m2480b()) {
            Message message = (CallbackMessage) callbackManager.f2835b.m2566a(CallbackMessage.class);
            message.m11069a(job, 2, i);
            callbackManager.f2834a.mo821a(message);
        }
        RetryConstraint retryConstraint = null;
        int i2 = 0;
        switch (i) {
            case 1:
                jobManagerThread.m11022a(jobHolder);
                break;
            case 2:
                jobManagerThread.m11023a(jobHolder, 2);
                jobManagerThread.m11022a(jobHolder);
                break;
            case 3:
                JqLog.m2558a("running job failed and cancelled, doing nothing. Will be removed after it's onCancel is called by the CancelHandler", new Object[0]);
                break;
            case 4:
                retryConstraint = jobHolder.f2925q;
                RetryConstraint retryConstraint2 = jobHolder.f2925q;
                if (retryConstraint2 != null) {
                    if (retryConstraint2.f2952e != null) {
                        jobHolder.f2912d = retryConstraint2.f2952e.intValue();
                        jobHolder.f2921m.f2885f = jobHolder.f2912d;
                    }
                    long j = -1;
                    if (retryConstraint2.f2951d != null) {
                        j = retryConstraint2.f2951d.longValue();
                    }
                    jobHolder.f2915g = j > 0 ? jobManagerThread.f12145a.mo829a() + (j * 1000000) : Long.MIN_VALUE;
                    jobManagerThread.m11013b(jobHolder);
                    break;
                }
                jobManagerThread.m11013b(jobHolder);
                break;
            case 5:
                jobManagerThread.m11023a(jobHolder, 5);
                jobManagerThread.m11022a(jobHolder);
                break;
            case 6:
                jobManagerThread.m11023a(jobHolder, 6);
                jobManagerThread.m11022a(jobHolder);
                break;
            case 7:
                jobManagerThread.m11023a(jobHolder, 7);
                jobManagerThread.m11022a(jobHolder);
                break;
            default:
                throw new IllegalArgumentException("unknown job holder result");
        }
        ConsumerManager consumerManager = jobManagerThread.f12150f;
        Consumer consumer = (Consumer) runJobResultMessage.f12204e;
        if (consumer.f2862e) {
            consumer.f2862e = false;
            consumerManager.f2869e.remove(jobHolder.f2921m.f2880a);
            if (jobHolder.f2913e != null) {
                consumerManager.f2870f.m2544b(jobHolder.f2913e);
                if (!(retryConstraint == null || retryConstraint.f2953f == null || retryConstraint.f2951d.longValue() <= 0)) {
                    consumerManager.f2870f.m2543a(jobHolder.f2913e, consumerManager.f2867c.mo829a() + (retryConstraint.f2951d.longValue() * 1000000));
                }
            }
            runJobResultMessage = jobManagerThread.f12152h;
            Job job2 = jobHolder.f2921m;
            if (runJobResultMessage.m2480b()) {
                Message message2 = (CallbackMessage) runJobResultMessage.f2835b.m2566a(CallbackMessage.class);
                message2.m11069a(job2, 5, i);
                runJobResultMessage.f2834a.mo821a(message2);
            }
            if (jobManagerThread.f12159o != null) {
                runJobResultMessage = jobManagerThread.f12159o.size();
                while (i2 < runJobResultMessage) {
                    CancelHandler cancelHandler = (CancelHandler) jobManagerThread.f12159o.get(i2);
                    if (cancelHandler.f2840a.remove(jobHolder.f2910b)) {
                        if (i == 3) {
                            cancelHandler.f2843d.add(jobHolder);
                        } else {
                            cancelHandler.f2844e.add(jobHolder);
                        }
                    }
                    if (cancelHandler.m2482a()) {
                        cancelHandler.m2481a(jobManagerThread);
                        jobManagerThread.f12159o.remove(i2);
                        i2--;
                        runJobResultMessage--;
                    }
                    i2++;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("this worker should not have a job");
    }

    static /* synthetic */ void m11006a(JobManagerThread jobManagerThread, CancelMessage cancelMessage) {
        CancelHandler cancelHandler = new CancelHandler(cancelMessage.f12189d, cancelMessage.f12190e, cancelMessage.f12191f);
        cancelHandler.f2840a = jobManagerThread.f12150f.m2489a(cancelHandler.f2841b, cancelHandler.f2842c, false);
        Constraint constraint = jobManagerThread.f12151g;
        constraint.m2483a();
        constraint.f2855h = jobManagerThread.f12145a.mo829a();
        constraint.f2849b = cancelHandler.f2841b;
        Collection collection = cancelHandler.f2840a;
        constraint.f2852e.clear();
        if (collection != null) {
            constraint.f2852e.addAll(collection);
        }
        constraint.m2485a(cancelHandler.f2842c);
        constraint.f2853f = true;
        constraint.f2848a = 2;
        Set<JobHolder> d = jobManagerThread.f12148d.mo815d(constraint);
        CancelMessage<JobHolder> d2 = jobManagerThread.f12147c.mo815d(constraint);
        for (JobHolder jobHolder : d) {
            jobHolder.m2518b();
            cancelHandler.f2843d.add(jobHolder);
            jobManagerThread.f12148d.mo816d(jobHolder);
        }
        for (JobHolder jobHolder2 : d2) {
            jobHolder2.m2518b();
            cancelHandler.f2843d.add(jobHolder2);
            jobManagerThread.f12147c.mo816d(jobHolder2);
        }
        if (cancelHandler.m2482a() != null) {
            cancelHandler.m2481a(jobManagerThread);
            return;
        }
        if (jobManagerThread.f12159o == null) {
            jobManagerThread.f12159o = new ArrayList();
        }
        jobManagerThread.f12159o.add(cancelHandler);
    }

    static /* synthetic */ void m11008a(JobManagerThread jobManagerThread, PublicQueryMessage publicQueryMessage) {
        int i = publicQueryMessage.f12200e;
        if (i != 101) {
            switch (i) {
                case 0:
                    jobManagerThread.f12147c.mo805a();
                    jobManagerThread.f12148d.mo805a();
                    return;
                case 1:
                    jobManagerThread.m11020a(jobManagerThread.m11024b());
                    return;
                case 2:
                    JqLog.m2558a("handling start request...", new Object[0]);
                    if (jobManagerThread.f12153i == null) {
                        jobManagerThread.f12153i = true;
                        jobManagerThread.f12150f.m2493a(true);
                        return;
                    }
                    break;
                case 3:
                    JqLog.m2558a("handling stop request...", new Object[0]);
                    jobManagerThread.f12153i = false;
                    jobManagerThread = jobManagerThread.f12150f;
                    for (Consumer consumer : jobManagerThread.f2866b) {
                        SafeMessageQueue safeMessageQueue = consumer.f2858a;
                        Message message = (CommandMessage) jobManagerThread.f2868d.m2566a(CommandMessage.class);
                        message.f12194d = 2;
                        safeMessageQueue.mo821a(message);
                    }
                    if (jobManagerThread.f2866b.isEmpty() != null) {
                        jobManagerThread = jobManagerThread.f2871g.iterator();
                        while (jobManagerThread.hasNext() != null) {
                            ((Runnable) jobManagerThread.next()).run();
                        }
                    }
                    return;
                case 4:
                    String str = publicQueryMessage.f12201f;
                    if (jobManagerThread.f12150f.m2492a(str)) {
                        jobManagerThread = JobStatus.RUNNING;
                    } else {
                        JobHolder a = jobManagerThread.f12148d.mo807a(str);
                        if (a == null) {
                            a = jobManagerThread.f12147c.mo807a(str);
                        }
                        if (a == null) {
                            jobManagerThread = JobStatus.UNKNOWN;
                        } else {
                            publicQueryMessage = jobManagerThread.m11024b();
                            long a2 = jobManagerThread.f12145a.mo829a();
                            if (publicQueryMessage < a.f2918j) {
                                jobManagerThread = JobStatus.WAITING_NOT_READY;
                            } else if (a.f2915g > a2) {
                                jobManagerThread = JobStatus.WAITING_NOT_READY;
                            } else {
                                jobManagerThread = JobStatus.WAITING_READY;
                            }
                        }
                    }
                    jobManagerThread.ordinal();
                    return;
                case 5:
                    jobManagerThread.f12148d.mo811b();
                    jobManagerThread.f12147c.mo811b();
                    if (publicQueryMessage.f12199d != null) {
                        return;
                    }
                    break;
                case 6:
                    jobManagerThread.f12150f.f2866b.size();
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder("cannot handle public query with type ");
                    stringBuilder.append(publicQueryMessage.f12200e);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    static /* synthetic */ void m11007a(JobManagerThread jobManagerThread, CommandMessage commandMessage) {
        if (commandMessage.f12194d == 1) {
            commandMessage = jobManagerThread.f12154j;
            commandMessage.f12174e.set(false);
            synchronized (commandMessage.f12170a) {
                commandMessage.f12173d.mo832b(commandMessage.f12170a);
            }
            jobManagerThread = jobManagerThread.f12154j;
            synchronized (jobManagerThread.f12170a) {
                for (int i = Type.f3002o; i >= 0; i--) {
                    UnsafeMessageQueue unsafeMessageQueue = jobManagerThread.f12171b[i];
                    if (unsafeMessageQueue != null) {
                        unsafeMessageQueue.mo822b();
                    }
                }
            }
        }
    }

    static /* synthetic */ void m11010a(JobManagerThread jobManagerThread, SchedulerMessage schedulerMessage) {
        int i = schedulerMessage.f12206d;
        if (i == 1) {
            SchedulerConstraint schedulerConstraint = schedulerMessage.f12207e;
            if (!jobManagerThread.f12153i) {
                if (jobManagerThread.f12155k != null) {
                    jobManagerThread.f12155k.mo798a(schedulerConstraint, true);
                }
            } else if (jobManagerThread.m11012a(schedulerConstraint)) {
                if (jobManagerThread.f12160p == null) {
                    jobManagerThread.f12160p = new ArrayList();
                }
                jobManagerThread.f12160p.add(schedulerConstraint);
                jobManagerThread.f12150f.m2490a();
            } else {
                if (jobManagerThread.f12155k != null) {
                    jobManagerThread.f12155k.mo798a(schedulerConstraint, false);
                }
            }
        } else if (i == 2) {
            jobManagerThread.m11014b(schedulerMessage.f12207e);
        } else {
            schedulerMessage = new StringBuilder("Unknown scheduler message with what ");
            schedulerMessage.append(i);
            throw new IllegalArgumentException(schedulerMessage.toString());
        }
    }
}
