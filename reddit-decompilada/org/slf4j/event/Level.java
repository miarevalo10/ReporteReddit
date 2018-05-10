package org.slf4j.event;

import io.fabric.sdk.android.services.network.HttpRequest;

public enum Level {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, HttpRequest.METHOD_TRACE);
    
    private int f27223f;
    private String f27224g;

    private Level(int i, String str) {
        this.f27223f = i;
        this.f27224g = str;
    }

    public final String toString() {
        return this.f27224g;
    }
}
