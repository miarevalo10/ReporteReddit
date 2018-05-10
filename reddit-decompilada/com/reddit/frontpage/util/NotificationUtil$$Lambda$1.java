package com.reddit.frontpage.util;

import com.reddit.frontpage.FrontpageApplication;
import java.util.Map;
import java.util.concurrent.Callable;

final /* synthetic */ class NotificationUtil$$Lambda$1 implements Callable {
    private final String f21771a;
    private final Map f21772b;
    private final FrontpageApplication f21773c;
    private final String f21774d;

    NotificationUtil$$Lambda$1(String str, Map map, FrontpageApplication frontpageApplication, String str2) {
        this.f21771a = str;
        this.f21772b = map;
        this.f21773c = frontpageApplication;
        this.f21774d = str2;
    }

    public final Object call() {
        return NotificationUtil.m23851a(this.f21771a, this.f21772b, this.f21773c, this.f21774d);
    }
}
