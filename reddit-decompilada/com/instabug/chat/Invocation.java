package com.instabug.chat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Invocation {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ChatInvocationMode {
    }
}
