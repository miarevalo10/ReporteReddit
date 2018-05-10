package com.google.android.gms.internal;

import java.io.IOException;

public class zzfge extends IOException {
    zzfhe f7422a = null;

    public zzfge(String str) {
        super(str);
    }

    static zzfge m6020a() {
        return new zzfge("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzfge m6021b() {
        return new zzfge("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzfge m6022c() {
        return new zzfge("CodedInputStream encountered a malformed varint.");
    }

    static zzfge m6023d() {
        return new zzfge("Protocol message contained an invalid tag (zero).");
    }

    static zzfge m6024e() {
        return new zzfge("Protocol message end-group tag did not match expected tag.");
    }

    static zzfgf m6025f() {
        return new zzfgf("Protocol message tag had invalid wire type.");
    }

    static zzfge m6026g() {
        return new zzfge("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static zzfge m6027h() {
        return new zzfge("Protocol message had invalid UTF-8.");
    }
}
