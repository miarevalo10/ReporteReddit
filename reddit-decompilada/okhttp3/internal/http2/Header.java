package okhttp3.internal.http2;

import okhttp3.internal.Util;
import okio.ByteString;

public final class Header {
    public static final ByteString PSEUDO_PREFIX = ByteString.m28267a(":");
    public static final ByteString RESPONSE_STATUS = ByteString.m28267a(":status");
    public static final ByteString TARGET_AUTHORITY = ByteString.m28267a(":authority");
    public static final ByteString TARGET_METHOD = ByteString.m28267a(":method");
    public static final ByteString TARGET_PATH = ByteString.m28267a(":path");
    public static final ByteString TARGET_SCHEME = ByteString.m28267a(":scheme");
    final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    public Header(String str, String str2) {
        this(ByteString.m28267a(str), ByteString.m28267a(str2));
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.m28267a(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = (32 + byteString.mo6166h()) + byteString2.mo6166h();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        if (!this.name.equals(header.name) || this.value.equals(header.value) == null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (31 * (527 + this.name.hashCode())) + this.value.hashCode();
    }

    public final String toString() {
        return Util.format("%s: %s", this.name.mo6154a(), this.value.mo6154a());
    }
}
