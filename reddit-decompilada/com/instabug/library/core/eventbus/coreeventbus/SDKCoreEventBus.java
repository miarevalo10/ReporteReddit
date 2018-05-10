package com.instabug.library.core.eventbus.coreeventbus;

import com.instabug.library.core.eventbus.EventBus;

public class SDKCoreEventBus extends EventBus<SDKCoreEvent> {
    private static SDKCoreEventBus instance;

    static SDKCoreEventBus getInstance() {
        if (instance == null) {
            instance = new SDKCoreEventBus();
        }
        return instance;
    }
}
