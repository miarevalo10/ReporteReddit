package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.CancelResult.AsyncCancelCallback;
import com.birbit.android.jobqueue.log.JqLog;
import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.message.CancelResultMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

class CancelHandler {
    Set<String> f2840a;
    final TagConstraint f2841b;
    final String[] f2842c;
    final Collection<JobHolder> f2843d = new ArrayList();
    final Collection<JobHolder> f2844e = new ArrayList();
    private final AsyncCancelCallback f2845f;

    CancelHandler(TagConstraint tagConstraint, String[] strArr, AsyncCancelCallback asyncCancelCallback) {
        this.f2841b = tagConstraint;
        this.f2842c = strArr;
        this.f2845f = asyncCancelCallback;
    }

    final void m2481a(JobManagerThread jobManagerThread) {
        for (JobHolder jobHolder : this.f2843d) {
            try {
                jobHolder.m2515a(3);
            } catch (Throwable th) {
                JqLog.m2559a(th, "job's on cancel has thrown an exception. Ignoring...", new Object[0]);
            }
            if (jobHolder.f2921m.f2883d) {
                jobManagerThread.f12147c.mo814c(jobHolder);
            }
        }
        if (this.f2845f != null) {
            Collection arrayList = new ArrayList(this.f2843d.size());
            Collection arrayList2 = new ArrayList(this.f2844e.size());
            for (JobHolder jobHolder2 : this.f2843d) {
                arrayList.add(jobHolder2.f2921m);
            }
            for (JobHolder jobHolder22 : this.f2844e) {
                arrayList2.add(jobHolder22.f2921m);
            }
            CancelResult cancelResult = new CancelResult(arrayList, arrayList2);
            CallbackManager callbackManager = jobManagerThread.f12152h;
            Message message = (CancelResultMessage) callbackManager.f2835b.m2566a(CancelResultMessage.class);
            message.f12192d = this.f2845f;
            message.f12193e = cancelResult;
            callbackManager.f2834a.mo821a(message);
            callbackManager.m2477a();
        }
        for (JobHolder jobHolder3 : this.f2843d) {
            jobManagerThread.f12152h.m2479a(jobHolder3.f2921m, true, jobHolder3.f2926r);
        }
    }

    final boolean m2482a() {
        return this.f2840a.isEmpty();
    }
}
