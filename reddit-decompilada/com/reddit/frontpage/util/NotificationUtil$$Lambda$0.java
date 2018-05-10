package com.reddit.frontpage.util;

import java.util.concurrent.Callable;

final /* synthetic */ class NotificationUtil$$Lambda$0 implements Callable {
    private final String f21769a;
    private final String f21770b;

    NotificationUtil$$Lambda$0(String str, String str2) {
        this.f21769a = str;
        this.f21770b = str2;
    }

    public final Object call() {
        return NotificationUtil.m23850a(this.f21769a, this.f21770b);
    }
}
