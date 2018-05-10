package com.twitter.sdk.android.core;

public class TwitterAuthException extends TwitterException {
    public TwitterAuthException(String str) {
        super(str);
    }

    public TwitterAuthException(String str, Throwable th) {
        super(str, th);
    }
}
