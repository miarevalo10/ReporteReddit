package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.config.Configuration;
import com.birbit.android.jobqueue.log.JqLog;
import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.MessageFactory;
import com.birbit.android.jobqueue.messaging.MessagePredicate;
import com.birbit.android.jobqueue.messaging.MessageQueue;
import com.birbit.android.jobqueue.messaging.MessageQueueConsumer;
import com.birbit.android.jobqueue.messaging.SafeMessageQueue;
import com.birbit.android.jobqueue.messaging.Type;
import com.birbit.android.jobqueue.messaging.message.CommandMessage;
import com.birbit.android.jobqueue.messaging.message.JobConsumerIdleMessage;
import com.birbit.android.jobqueue.messaging.message.RunJobMessage;
import com.birbit.android.jobqueue.messaging.message.RunJobResultMessage;
import com.birbit.android.jobqueue.timer.Timer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadFactory;

class ConsumerManager {
    List<Consumer> f2865a = new ArrayList();
    final List<Consumer> f2866b = new ArrayList();
    final Timer f2867c;
    final MessageFactory f2868d;
    final Map<String, JobHolder> f2869e;
    final RunningJobSet f2870f;
    final CopyOnWriteArrayList<Runnable> f2871g = new CopyOnWriteArrayList();
    private final int f2872h;
    private final int f2873i;
    private final long f2874j;
    private final int f2875k;
    private final int f2876l;
    private final ThreadGroup f2877m;
    private final JobManagerThread f2878n;
    private final ThreadFactory f2879o;

    static class Consumer implements Runnable {
        static final MessagePredicate f2857g = new C10421();
        final SafeMessageQueue f2858a;
        final MessageQueue f2859b;
        final MessageFactory f2860c;
        final Timer f2861d;
        boolean f2862e;
        long f2863f;
        final MessageQueueConsumer f2864h = new C10432(this);

        static class C10421 implements MessagePredicate {
            C10421() {
            }

            public final boolean mo801a(Message message) {
                return (message.f2985a == Type.COMMAND && ((CommandMessage) message).f12194d == 2) ? true : null;
            }
        }

        class C10432 extends MessageQueueConsumer {
            final /* synthetic */ Consumer f12141a;

            C10432(Consumer consumer) {
                this.f12141a = consumer;
            }

            public final void mo800a(Message message) {
                switch (message.f2985a) {
                    case RUN_JOB:
                        Consumer.m2488a(this.f12141a, (RunJobMessage) message);
                        this.f12141a.f2863f = this.f12141a.f2861d.mo829a();
                        Consumer.m2486a(this.f12141a);
                        return;
                    case COMMAND:
                        Consumer.m2487a(this.f12141a, (CommandMessage) message);
                        break;
                    default:
                        break;
                }
            }

            public final void mo799a() {
                JqLog.m2558a("consumer manager on idle", new Object[0]);
                JobConsumerIdleMessage jobConsumerIdleMessage = (JobConsumerIdleMessage) this.f12141a.f2860c.m2566a(JobConsumerIdleMessage.class);
                jobConsumerIdleMessage.f12197d = this.f12141a;
                jobConsumerIdleMessage.f12198e = this.f12141a.f2863f;
                this.f12141a.f2859b.mo821a(jobConsumerIdleMessage);
            }
        }

        public Consumer(MessageQueue messageQueue, SafeMessageQueue safeMessageQueue, MessageFactory messageFactory, Timer timer) {
            this.f2858a = safeMessageQueue;
            this.f2860c = messageFactory;
            this.f2859b = messageQueue;
            this.f2861d = timer;
            this.f2863f = timer.mo829a();
        }

        public void run() {
            this.f2858a.m11064a(this.f2864h);
        }

        static /* synthetic */ void m2488a(Consumer consumer, RunJobMessage runJobMessage) {
            JqLog.m2558a("running job %s", runJobMessage.f12202d.getClass().getSimpleName());
            runJobMessage = runJobMessage.f12202d;
            int a = runJobMessage.f2921m.m2494a(runJobMessage, runJobMessage.f2914f, consumer.f2861d);
            RunJobResultMessage runJobResultMessage = (RunJobResultMessage) consumer.f2860c.m2566a(RunJobResultMessage.class);
            runJobResultMessage.f12203d = runJobMessage;
            runJobResultMessage.f12205f = a;
            runJobResultMessage.f12204e = consumer;
            consumer.f2859b.mo821a(runJobResultMessage);
        }

        static /* synthetic */ void m2486a(Consumer consumer) {
            consumer = consumer.f2858a;
            MessagePredicate messagePredicate = f2857g;
            synchronized (consumer.f12177a) {
                Message message = consumer.f3007e;
                Message message2 = null;
                Message message3 = null;
                while (message != null) {
                    if (messagePredicate.mo801a(message)) {
                        Message message4 = message.f2986b;
                        if (consumer.f3008f == message) {
                            consumer.f3008f = message3;
                        }
                        if (message3 == null) {
                            consumer.f3007e = message.f2986b;
                        } else {
                            message3.f2986b = message.f2986b;
                        }
                        consumer.f3010h.m2567a(message);
                        message = message4;
                    } else {
                        message3 = message;
                        message = message.f2986b;
                    }
                }
                consumer = consumer.f12179c;
                message = consumer.f2983a;
                while (message != null) {
                    boolean a = messagePredicate.mo801a(message);
                    message4 = message.f2986b;
                    if (a) {
                        if (message2 == null) {
                            consumer.f2983a = message.f2986b;
                        } else {
                            message2.f2986b = message.f2986b;
                        }
                        consumer.f2984b.m2567a(message);
                    } else {
                        message2 = message;
                    }
                    message = message4;
                }
            }
        }

        static /* synthetic */ void m2487a(Consumer consumer, CommandMessage commandMessage) {
            switch (commandMessage.f12194d) {
                case 1:
                    consumer.f2858a.m11062a();
                    return;
                case 2:
                    JqLog.m2558a("Consumer has been poked.", new Object[null]);
                    break;
                default:
                    break;
            }
        }
    }

    ConsumerManager(JobManagerThread jobManagerThread, Timer timer, MessageFactory messageFactory, Configuration configuration) {
        this.f2878n = jobManagerThread;
        this.f2867c = timer;
        this.f2868d = messageFactory;
        this.f2876l = configuration.f2968e;
        this.f2873i = configuration.f2966c;
        this.f2872h = configuration.f2965b;
        this.f2874j = ((long) (configuration.f2967d * 1000)) * 1000000;
        this.f2875k = configuration.f2978o;
        this.f2879o = configuration.f2980q;
        this.f2869e = new HashMap();
        this.f2870f = new RunningJobSet(timer);
        this.f2877m = new ThreadGroup("JobConsumers");
    }

    final boolean m2490a() {
        return m2493a(true);
    }

    final boolean m2493a(boolean z) {
        JqLog.m2558a("considering adding a new consumer. Should poke all waiting? %s isRunning? %s waiting workers? %d", Boolean.valueOf(z), Boolean.valueOf(this.f2878n.f12153i), Integer.valueOf(this.f2865a.size()));
        if (!this.f2878n.f12153i) {
            JqLog.m2558a("jobqueue is not running, no consumers will be added", new Object[0]);
            return false;
        } else if (this.f2865a.size() > 0) {
            JqLog.m2558a("there are waiting workers, will poke them instead", new Object[0]);
            for (r0 = this.f2865a.size() - 1; r0 >= 0; r0--) {
                Consumer consumer = (Consumer) this.f2865a.remove(r0);
                Message message = (CommandMessage) this.f2868d.m2566a(CommandMessage.class);
                message.f12194d = 2;
                consumer.f2858a.mo821a(message);
                if (!z) {
                    break;
                }
            }
            JqLog.m2558a("there were waiting workers, poked them and I'm done", new Object[0]);
            return true;
        } else {
            boolean z2;
            z = this.f2866b.size();
            if (z >= this.f2872h) {
                JqLog.m2558a("too many consumers, clearly above load factor %s", Integer.valueOf(z));
                z2 = false;
            } else {
                JobManagerThread jobManagerThread = this.f2878n;
                boolean a = jobManagerThread.m11020a(jobManagerThread.m11024b()) + this.f2869e.size();
                if (this.f2876l * z >= a) {
                    if (z >= this.f2873i || z >= a) {
                        z2 = false;
                        JqLog.m2558a("check above load factor: totalCons:%s minCons:%s maxConsCount: %s, loadFactor %s remainingJobs: %s running holders: %s. isAbove:%s", Integer.valueOf(z), Integer.valueOf(this.f2873i), Integer.valueOf(this.f2872h), Integer.valueOf(this.f2876l), Integer.valueOf(r0), Integer.valueOf(r2), Boolean.valueOf(z2));
                    }
                }
                z2 = true;
                JqLog.m2558a("check above load factor: totalCons:%s minCons:%s maxConsCount: %s, loadFactor %s remainingJobs: %s running holders: %s. isAbove:%s", Integer.valueOf(z), Integer.valueOf(this.f2873i), Integer.valueOf(this.f2872h), Integer.valueOf(this.f2876l), Integer.valueOf(r0), Integer.valueOf(r2), Boolean.valueOf(z2));
            }
            JqLog.m2558a("nothing has been poked. are we above load factor? %s", Boolean.valueOf(z2));
            if (!z2) {
                return false;
            }
            Thread newThread;
            JqLog.m2558a("adding another consumer", new Object[0]);
            z = new Consumer(this.f2878n.f12154j, new SafeMessageQueue(this.f2867c, this.f2868d, "consumer"), this.f2868d, this.f2867c);
            if (this.f2879o != null) {
                newThread = this.f2879o.newThread(z);
            } else {
                ThreadGroup threadGroup = this.f2877m;
                StringBuilder stringBuilder = new StringBuilder("job-queue-worker-");
                stringBuilder.append(UUID.randomUUID());
                newThread = new Thread(threadGroup, z, stringBuilder.toString());
                newThread.setPriority(this.f2875k);
            }
            this.f2866b.add(z);
            newThread.start();
            return true;
        }
    }

    final Set<String> m2489a(TagConstraint tagConstraint, String[] strArr, boolean z) {
        Set<String> hashSet = new HashSet();
        for (JobHolder jobHolder : this.f2869e.values()) {
            JqLog.m2558a("checking job tag %s. tags of job: %s", jobHolder.f2921m, jobHolder.f2921m.f2884e);
            if (jobHolder.m2519c() && !jobHolder.f2923o && tagConstraint.m2545a(strArr, jobHolder.m2514a())) {
                hashSet.add(jobHolder.f2910b);
                if (z) {
                    jobHolder.f2924p = true;
                    jobHolder.m2518b();
                } else {
                    jobHolder.m2518b();
                }
            }
        }
        return hashSet;
    }

    final boolean m2492a(String str) {
        return this.f2869e.get(str) != null ? true : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean m2491a(com.birbit.android.jobqueue.messaging.message.JobConsumerIdleMessage r13) {
        /*
        r12 = this;
        r0 = r13.f12197d;
        r0 = (com.birbit.android.jobqueue.ConsumerManager.Consumer) r0;
        r1 = r0.f2862e;
        r2 = 1;
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        return r2;
    L_0x000a:
        r1 = r12.f2878n;
        r1 = r1.f12153i;
        r3 = 0;
        r4 = 0;
        if (r1 == 0) goto L_0x009e;
    L_0x0012:
        r5 = r12.f2878n;
        r6 = r12.f2870f;
        r6 = r6.m2541a();
        r7 = r5.f12153i;
        if (r7 != 0) goto L_0x0020;
    L_0x001e:
        goto L_0x009e;
    L_0x0020:
        r7 = r3;
    L_0x0021:
        if (r7 != 0) goto L_0x009d;
    L_0x0023:
        r7 = r5.m11024b();
        r8 = "looking for next job";
        r9 = new java.lang.Object[r4];
        com.birbit.android.jobqueue.log.JqLog.m2562c(r8, r9);
        r8 = r5.f12151g;
        r8.m2483a();
        r8 = r5.f12145a;
        r8 = r8.mo829a();
        r10 = r5.f12151g;
        r10.f2855h = r8;
        r10 = r5.f12151g;
        r10.f2848a = r7;
        r7 = r5.f12151g;
        r7.m2484a(r6);
        r7 = r5.f12151g;
        r7.f2853f = r2;
        r7 = r5.f12151g;
        r10 = java.lang.Long.valueOf(r8);
        r7.f2854g = r10;
        r7 = r5.f12148d;
        r10 = r5.f12151g;
        r7 = r7.mo810b(r10);
        r10 = "non persistent result %s";
        r11 = new java.lang.Object[r2];
        r11[r4] = r7;
        com.birbit.android.jobqueue.log.JqLog.m2562c(r10, r11);
        if (r7 != 0) goto L_0x0076;
    L_0x0065:
        r7 = r5.f12147c;
        r10 = r5.f12151g;
        r7 = r7.mo810b(r10);
        r10 = "persistent result %s";
        r11 = new java.lang.Object[r2];
        r11[r4] = r7;
        com.birbit.android.jobqueue.log.JqLog.m2562c(r10, r11);
    L_0x0076:
        if (r7 != 0) goto L_0x0079;
    L_0x0078:
        goto L_0x009e;
    L_0x0079:
        r10 = r5.f12146b;
        r7.m2517a(r10);
        r10 = r7.f2919k;
        r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r10 > 0) goto L_0x0086;
    L_0x0084:
        r10 = r2;
        goto L_0x0087;
    L_0x0086:
        r10 = r4;
    L_0x0087:
        r11 = r7.f2921m;
        r11.f2891l = r10;
        r10 = r7.f2919k;
        r8 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r8 > 0) goto L_0x0021;
    L_0x0091:
        r8 = r7.f2920l;
        if (r8 == 0) goto L_0x0021;
    L_0x0095:
        r8 = 7;
        r5.m11023a(r7, r8);
        r5.m11022a(r7);
        goto L_0x0020;
    L_0x009d:
        r3 = r7;
    L_0x009e:
        if (r3 == 0) goto L_0x00cf;
    L_0x00a0:
        r0.f2862e = r2;
        r13 = r12.f2870f;
        r1 = r3.f2913e;
        r13.m2542a(r1);
        r13 = r12.f2868d;
        r1 = com.birbit.android.jobqueue.messaging.message.RunJobMessage.class;
        r13 = r13.m2566a(r1);
        r13 = (com.birbit.android.jobqueue.messaging.message.RunJobMessage) r13;
        r13.f12202d = r3;
        r1 = r12.f2869e;
        r4 = r3.f2921m;
        r4 = r4.f2880a;
        r1.put(r4, r3);
        r1 = r3.f2913e;
        if (r1 == 0) goto L_0x00c9;
    L_0x00c2:
        r1 = r12.f2870f;
        r3 = r3.f2913e;
        r1.m2542a(r3);
    L_0x00c9:
        r0 = r0.f2858a;
        r0.mo821a(r13);
        return r2;
    L_0x00cf:
        r5 = r13.f12198e;
        r7 = r12.f2874j;
        r5 = r5 + r7;
        r13 = "keep alive: %s";
        r3 = new java.lang.Object[r2];
        r7 = java.lang.Long.valueOf(r5);
        r3[r4] = r7;
        com.birbit.android.jobqueue.log.JqLog.m2558a(r13, r3);
        r13 = r12.f2866b;
        r13 = r13.size();
        r3 = r12.f2873i;
        if (r13 <= r3) goto L_0x00ed;
    L_0x00eb:
        r13 = r2;
        goto L_0x00ee;
    L_0x00ed:
        r13 = r4;
    L_0x00ee:
        if (r1 == 0) goto L_0x00ff;
    L_0x00f0:
        if (r13 == 0) goto L_0x00fd;
    L_0x00f2:
        r3 = r12.f2867c;
        r7 = r3.mo829a();
        r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r3 >= 0) goto L_0x00fd;
    L_0x00fc:
        goto L_0x00ff;
    L_0x00fd:
        r3 = r4;
        goto L_0x0100;
    L_0x00ff:
        r3 = r2;
    L_0x0100:
        r7 = "Consumer idle, will kill? %s . isRunning: %s";
        r8 = 2;
        r9 = new java.lang.Object[r8];
        r10 = java.lang.Boolean.valueOf(r3);
        r9[r4] = r10;
        r1 = java.lang.Boolean.valueOf(r1);
        r9[r2] = r1;
        com.birbit.android.jobqueue.log.JqLog.m2558a(r7, r9);
        if (r3 == 0) goto L_0x0166;
    L_0x0116:
        r13 = r12.f2868d;
        r1 = com.birbit.android.jobqueue.messaging.message.CommandMessage.class;
        r13 = r13.m2566a(r1);
        r13 = (com.birbit.android.jobqueue.messaging.message.CommandMessage) r13;
        r13.f12194d = r2;
        r1 = r0.f2858a;
        r1.mo821a(r13);
        r13 = r12.f2865a;
        r13.remove(r0);
        r13 = r12.f2866b;
        r13.remove(r0);
        r13 = "killed consumers. remaining consumers %d";
        r0 = new java.lang.Object[r2];
        r1 = r12.f2866b;
        r1 = r1.size();
        r1 = java.lang.Integer.valueOf(r1);
        r0[r4] = r1;
        com.birbit.android.jobqueue.log.JqLog.m2558a(r13, r0);
        r13 = r12.f2866b;
        r13 = r13.isEmpty();
        if (r13 == 0) goto L_0x01b5;
    L_0x014c:
        r13 = r12.f2871g;
        if (r13 == 0) goto L_0x01b5;
    L_0x0150:
        r13 = r12.f2871g;
        r13 = r13.iterator();
    L_0x0156:
        r0 = r13.hasNext();
        if (r0 == 0) goto L_0x01b5;
    L_0x015c:
        r0 = r13.next();
        r0 = (java.lang.Runnable) r0;
        r0.run();
        goto L_0x0156;
    L_0x0166:
        r1 = r12.f2865a;
        r1 = r1.contains(r0);
        if (r1 != 0) goto L_0x0173;
    L_0x016e:
        r1 = r12.f2865a;
        r1.add(r0);
    L_0x0173:
        if (r13 != 0) goto L_0x017d;
    L_0x0175:
        r1 = r12.f2878n;
        r1 = r1.f12149e;
        r1 = r1 instanceof com.birbit.android.jobqueue.network.NetworkEventProvider;
        if (r1 != 0) goto L_0x01b5;
    L_0x017d:
        r1 = r12.f2868d;
        r3 = com.birbit.android.jobqueue.messaging.message.CommandMessage.class;
        r1 = r1.m2566a(r3);
        r1 = (com.birbit.android.jobqueue.messaging.message.CommandMessage) r1;
        r1.f12194d = r8;
        if (r13 != 0) goto L_0x0194;
    L_0x018b:
        r13 = r12.f2867c;
        r5 = r13.mo829a();
        r7 = r12.f2874j;
        r5 = r5 + r7;
    L_0x0194:
        r13 = r0.f2858a;
        r0 = r13.f12177a;
        monitor-enter(r0);
        r13.f12180d = r2;	 Catch:{ all -> 0x01b6 }
        r3 = r13.f12179c;	 Catch:{ all -> 0x01b6 }
        r3.m2564a(r1, r5);	 Catch:{ all -> 0x01b6 }
        r1 = r13.f12178b;	 Catch:{ all -> 0x01b6 }
        r13 = r13.f12177a;	 Catch:{ all -> 0x01b6 }
        r1.mo832b(r13);	 Catch:{ all -> 0x01b6 }
        monitor-exit(r0);	 Catch:{ all -> 0x01b6 }
        r13 = "poke consumer manager at %s";
        r0 = new java.lang.Object[r2];
        r1 = java.lang.Long.valueOf(r5);
        r0[r4] = r1;
        com.birbit.android.jobqueue.log.JqLog.m2558a(r13, r0);
    L_0x01b5:
        return r4;
    L_0x01b6:
        r13 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x01b6 }
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.birbit.android.jobqueue.ConsumerManager.a(com.birbit.android.jobqueue.messaging.message.JobConsumerIdleMessage):boolean");
    }
}
