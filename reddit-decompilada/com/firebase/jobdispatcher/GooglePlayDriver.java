package com.firebase.jobdispatcher;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.firebase.jobdispatcher.JobTrigger.ContentUriTrigger;
import com.firebase.jobdispatcher.JobTrigger.ExecutionWindowTrigger;

public final class GooglePlayDriver implements Driver {
    private final JobValidator f12696a;
    private final Context f12697b;
    private final PendingIntent f12698c;
    private final GooglePlayJobWriter f12699d;
    private final boolean f12700e = true;

    public GooglePlayDriver(Context context) {
        this.f12697b = context;
        this.f12698c = PendingIntent.getBroadcast(context, 0, new Intent(), 0);
        this.f12699d = new GooglePlayJobWriter();
        this.f12696a = new DefaultJobValidator(context);
    }

    public final int mo1241a(Job job) {
        Context context = this.f12697b;
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("scheduler_action", "SCHEDULE_TASK");
        intent.putExtra("app", this.f12698c);
        intent.putExtra("source", 8);
        intent.putExtra("source_version", 1);
        GooglePlayJobWriter googlePlayJobWriter = this.f12699d;
        Bundle extras = intent.getExtras();
        extras.putString("tag", job.mo1249e());
        extras.putBoolean("update_current", job.mo1248d());
        extras.putBoolean("persisted", job.mo1251g() == 2);
        extras.putString("service", GooglePlayReceiver.class.getName());
        GooglePlayJobWriter.m3468b(job, extras);
        GooglePlayJobWriter.m3469c(job, extras);
        GooglePlayJobWriter.m3467a(job, extras);
        Bundle b = job.mo1246b();
        if (b == null) {
            b = new Bundle();
        }
        String str = "extras";
        JobCoder jobCoder = googlePlayJobWriter.f3852a;
        if (b == null) {
            throw new IllegalArgumentException("Unexpected null Bundle provided");
        }
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(jobCoder.f3855b);
        stringBuilder2.append("persistent");
        b.putInt(stringBuilder2.toString(), job.mo1251g());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(jobCoder.f3855b);
        stringBuilder2.append("recurring");
        b.putBoolean(stringBuilder2.toString(), job.mo1252h());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(jobCoder.f3855b);
        stringBuilder2.append("replace_current");
        b.putBoolean(stringBuilder2.toString(), job.mo1248d());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(jobCoder.f3855b);
        stringBuilder2.append("tag");
        b.putString(stringBuilder2.toString(), job.mo1249e());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(jobCoder.f3855b);
        stringBuilder2.append("service");
        b.putString(stringBuilder2.toString(), job.mo1253i());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(jobCoder.f3855b);
        stringBuilder2.append("constraints");
        b.putInt(stringBuilder2.toString(), Constraint.m3451a(job.mo1245a()));
        if (jobCoder.f3854a) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(jobCoder.f3855b);
            stringBuilder2.append("extras");
            b.putBundle(stringBuilder2.toString(), job.mo1246b());
        }
        JobTrigger f = job.mo1250f();
        StringBuilder stringBuilder3;
        if (f == Trigger.f3883a) {
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(jobCoder.f3855b);
            stringBuilder3.append("trigger_type");
            b.putInt(stringBuilder3.toString(), 2);
        } else if (f instanceof ExecutionWindowTrigger) {
            ExecutionWindowTrigger executionWindowTrigger = (ExecutionWindowTrigger) f;
            stringBuilder = new StringBuilder();
            stringBuilder.append(jobCoder.f3855b);
            stringBuilder.append("trigger_type");
            b.putInt(stringBuilder.toString(), 1);
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(jobCoder.f3855b);
            stringBuilder3.append("window_start");
            b.putInt(stringBuilder3.toString(), executionWindowTrigger.f12742a);
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(jobCoder.f3855b);
            stringBuilder3.append("window_end");
            b.putInt(stringBuilder3.toString(), executionWindowTrigger.f12743b);
        } else if (f instanceof ContentUriTrigger) {
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(jobCoder.f3855b);
            stringBuilder3.append("trigger_type");
            b.putInt(stringBuilder3.toString(), 3);
            String a = JobCoder.m3471a(((ContentUriTrigger) f).f12741a);
            stringBuilder = new StringBuilder();
            stringBuilder.append(jobCoder.f3855b);
            stringBuilder.append("observed_uris");
            b.putString(stringBuilder.toString(), a);
        } else {
            throw new IllegalArgumentException("Unsupported trigger.");
        }
        RetryStrategy c = job.mo1247c();
        if (c == null) {
            c = RetryStrategy.f3878a;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(jobCoder.f3855b);
        stringBuilder.append("retry_policy");
        b.putInt(stringBuilder.toString(), c.f3880c);
        stringBuilder = new StringBuilder();
        stringBuilder.append(jobCoder.f3855b);
        stringBuilder.append("initial_backoff_seconds");
        b.putInt(stringBuilder.toString(), c.f3881d);
        stringBuilder = new StringBuilder();
        stringBuilder.append(jobCoder.f3855b);
        stringBuilder.append("maximum_backoff_seconds");
        b.putInt(stringBuilder.toString(), c.f3882e);
        extras.putBundle(str, b);
        intent.putExtras(extras);
        context.sendBroadcast(intent);
        GooglePlayReceiver.m11794a(job);
        return 0;
    }

    public final JobValidator mo1242a() {
        return this.f12696a;
    }
}
