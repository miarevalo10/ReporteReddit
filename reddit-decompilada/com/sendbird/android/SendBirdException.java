package com.sendbird.android;

public final class SendBirdException extends Exception {
    protected int f22851a;

    public SendBirdException(String str) {
        super(str);
        this.f22851a = null;
    }

    public SendBirdException(String str, int i) {
        super(str);
        this.f22851a = i;
    }
}
