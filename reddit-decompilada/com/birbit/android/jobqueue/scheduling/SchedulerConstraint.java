package com.birbit.android.jobqueue.scheduling;

public class SchedulerConstraint {
    public String f3077a;
    public long f3078b;
    public int f3079c;
    public Long f3080d;
    private Object f3081e;

    public SchedulerConstraint(String str) {
        this.f3077a = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SchedulerConstraint{uuid='");
        stringBuilder.append(this.f3077a);
        stringBuilder.append('\'');
        stringBuilder.append(", delayInMs=");
        stringBuilder.append(this.f3078b);
        stringBuilder.append(", networkStatus=");
        stringBuilder.append(this.f3079c);
        stringBuilder.append(", overrideDeadlineInMs=");
        stringBuilder.append(this.f3080d);
        stringBuilder.append(", data=");
        stringBuilder.append(this.f3081e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
