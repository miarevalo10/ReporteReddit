package com.reddit.frontpage.auth;

public class KeyUtil {
    public static native String decryptSigningKey(String str);

    static {
        System.loadLibrary("reddit-ndk");
    }
}
