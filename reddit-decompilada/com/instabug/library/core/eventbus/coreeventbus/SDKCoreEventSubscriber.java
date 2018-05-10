package com.instabug.library.core.eventbus.coreeventbus;

import rx.Subscription;
import rx.functions.Action1;

public class SDKCoreEventSubscriber {
    public static Subscription subscribe(Action1<SDKCoreEvent> action1) {
        return SDKCoreEventBus.getInstance().subscribe(action1);
    }
}
