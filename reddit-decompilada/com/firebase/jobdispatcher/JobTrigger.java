package com.firebase.jobdispatcher;

import java.util.List;

public class JobTrigger {

    public static final class ContentUriTrigger extends JobTrigger {
        final List<ObservedUri> f12741a;

        ContentUriTrigger(List<ObservedUri> list) {
            this.f12741a = list;
        }
    }

    public static final class ExecutionWindowTrigger extends JobTrigger {
        final int f12742a;
        final int f12743b;

        ExecutionWindowTrigger(int i, int i2) {
            this.f12742a = i;
            this.f12743b = i2;
        }
    }

    public static final class ImmediateTrigger extends JobTrigger {
        ImmediateTrigger() {
        }
    }
}
