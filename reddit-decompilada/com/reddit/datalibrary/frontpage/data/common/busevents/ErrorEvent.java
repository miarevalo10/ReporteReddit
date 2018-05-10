package com.reddit.datalibrary.frontpage.data.common.busevents;

public class ErrorEvent extends BaseEvent {
    public final Exception exception;

    public ErrorEvent(Exception exception) {
        this.exception = exception;
    }

    public ErrorEvent(String str, Exception exception) {
        this.requestId = str;
        this.exception = exception;
    }
}
