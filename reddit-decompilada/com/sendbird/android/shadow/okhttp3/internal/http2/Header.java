package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okio.ByteString;

public final class Header {
    public static final ByteString f23436a = ByteString.m25595a(":");
    public static final ByteString f23437b = ByteString.m25595a(":status");
    public static final ByteString f23438c = ByteString.m25595a(":method");
    public static final ByteString f23439d = ByteString.m25595a(":path");
    public static final ByteString f23440e = ByteString.m25595a(":scheme");
    public static final ByteString f23441f = ByteString.m25595a(":authority");
    public final ByteString f23442g;
    public final ByteString f23443h;
    final int f23444i;

    public Header(String str, String str2) {
        this(ByteString.m25595a(str), ByteString.m25595a(str2));
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.m25595a(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.f23442g = byteString;
        this.f23443h = byteString2;
        this.f23444i = (32 + byteString.mo5405h()) + byteString2.mo5405h();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        if (!this.f23442g.equals(header.f23442g) || this.f23443h.equals(header.f23443h) == null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (31 * (527 + this.f23442g.hashCode())) + this.f23443h.hashCode();
    }

    public final String toString() {
        return Util.m25360a("%s: %s", this.f23442g.mo5394a(), this.f23443h.mo5394a());
    }
}
