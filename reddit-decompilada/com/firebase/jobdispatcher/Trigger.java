package com.firebase.jobdispatcher;

import com.firebase.jobdispatcher.JobTrigger.ContentUriTrigger;
import com.firebase.jobdispatcher.JobTrigger.ExecutionWindowTrigger;
import com.firebase.jobdispatcher.JobTrigger.ImmediateTrigger;
import java.util.List;

public final class Trigger {
    public static final ImmediateTrigger f3883a = new ImmediateTrigger();

    public static ExecutionWindowTrigger m3504a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Window start can't be less than 0");
        } else if (i2 >= i) {
            return new ExecutionWindowTrigger(i, i2);
        } else {
            throw new IllegalArgumentException("Window end can't be less than window start");
        }
    }

    public static ContentUriTrigger m3503a(List<ObservedUri> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                return new ContentUriTrigger(list);
            }
        }
        throw new IllegalArgumentException("Uris must not be null or empty.");
    }
}
