package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfjr extends IOException {
    public zzfjr(String str) {
        super(str);
    }

    static zzfjr m6199a() {
        return new zzfjr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzfjr m6200b() {
        return new zzfjr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzfjr m6201c() {
        return new zzfjr("CodedInputStream encountered a malformed varint.");
    }

    static zzfjr m6202d() {
        return new zzfjr("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
