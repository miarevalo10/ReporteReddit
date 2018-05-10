package com.instabug.chat.eventbus;

import com.instabug.library.core.eventbus.EventBus;

public class ChatTriggeringEventBus extends EventBus<C0543a> {
    private static ChatTriggeringEventBus instance;

    public static ChatTriggeringEventBus getInstance() {
        if (instance == null) {
            instance = new ChatTriggeringEventBus();
        }
        return instance;
    }
}
