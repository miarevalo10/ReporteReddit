package com.instabug.library.core.eventbus;

import com.instabug.library.tracking.ActivityLifeCycleEvent;

public class CurrentActivityLifeCycleEventBus extends EventBus<ActivityLifeCycleEvent> {
    private static CurrentActivityLifeCycleEventBus instance;

    public static CurrentActivityLifeCycleEventBus getInstance() {
        if (instance == null) {
            instance = new CurrentActivityLifeCycleEventBus();
        }
        return instance;
    }
}
