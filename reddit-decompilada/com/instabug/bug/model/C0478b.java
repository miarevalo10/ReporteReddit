package com.instabug.bug.model;

import java.io.Serializable;

/* compiled from: ReportType */
public enum C0478b implements Serializable {
    BUG("bug"),
    FEEDBACK("feedback"),
    NOT_AVAILABLE("not-available");
    
    private final String f9113d;

    private C0478b(String str) {
        this.f9113d = str;
    }

    public final String toString() {
        return this.f9113d;
    }
}
