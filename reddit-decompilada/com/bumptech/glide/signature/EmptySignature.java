package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

public final class EmptySignature implements Key {
    private static final EmptySignature f12669b = new EmptySignature();

    public final void mo893a(MessageDigest messageDigest) {
    }

    public final String toString() {
        return "EmptySignature";
    }

    public static EmptySignature m11730a() {
        return f12669b;
    }

    private EmptySignature() {
    }
}
