package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.firebase.jobdispatcher.JobTrigger.ContentUriTrigger;
import com.firebase.jobdispatcher.JobTrigger.ExecutionWindowTrigger;

final class GooglePlayJobWriter {
    final JobCoder f3852a = new JobCoder("com.firebase.jobdispatcher.", false);

    GooglePlayJobWriter() {
    }

    static void m3467a(JobParameters jobParameters, Bundle bundle) {
        jobParameters = jobParameters.mo1247c();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("retry_policy", jobParameters.f3880c != 2 ? 0 : 1);
        bundle2.putInt("initial_backoff_seconds", jobParameters.f3881d);
        bundle2.putInt("maximum_backoff_seconds", jobParameters.f3882e);
        bundle.putBundle("retryStrategy", bundle2);
    }

    static void m3468b(JobParameters jobParameters, Bundle bundle) {
        JobTrigger f = jobParameters.mo1250f();
        if (f == Trigger.f3883a) {
            bundle.putInt("trigger_type", 2);
            bundle.putLong("window_start", 0);
            bundle.putLong("window_end", 1);
        } else if (f instanceof ExecutionWindowTrigger) {
            ExecutionWindowTrigger executionWindowTrigger = (ExecutionWindowTrigger) f;
            bundle.putInt("trigger_type", 1);
            if (jobParameters.mo1252h() != null) {
                bundle.putLong("period", (long) executionWindowTrigger.f12743b);
                bundle.putLong("period_flex", (long) (executionWindowTrigger.f12743b - executionWindowTrigger.f12742a));
                return;
            }
            bundle.putLong("window_start", (long) executionWindowTrigger.f12742a);
            bundle.putLong("window_end", (long) executionWindowTrigger.f12743b);
        } else if ((f instanceof ContentUriTrigger) != null) {
            ContentUriTrigger contentUriTrigger = (ContentUriTrigger) f;
            bundle.putInt("trigger_type", 3);
            jobParameters = contentUriTrigger.f12741a.size();
            int[] iArr = new int[jobParameters];
            Parcelable[] parcelableArr = new Uri[jobParameters];
            for (int i = 0; i < jobParameters; i++) {
                ObservedUri observedUri = (ObservedUri) contentUriTrigger.f12741a.get(i);
                iArr[i] = observedUri.f3876b;
                parcelableArr[i] = observedUri.f3875a;
            }
            bundle.putIntArray("content_uri_flags_array", iArr);
            bundle.putParcelableArray("content_uri_array", parcelableArr);
        } else {
            bundle = new StringBuilder("Unknown trigger: ");
            bundle.append(f.getClass());
            throw new IllegalArgumentException(bundle.toString());
        }
    }

    static void m3469c(JobParameters jobParameters, Bundle bundle) {
        jobParameters = Constraint.m3451a(jobParameters.mo1245a());
        bundle.putBoolean("requiresCharging", (jobParameters & 4) == 4);
        bundle.putBoolean("requiresIdle", (jobParameters & 8) == 8);
        String str = "requiredNetwork";
        int i = 2;
        if ((jobParameters & 2) == 2) {
            i = 0;
        }
        if ((jobParameters & 1) == 1) {
            i = 1;
        }
        bundle.putInt(str, i);
    }
}
