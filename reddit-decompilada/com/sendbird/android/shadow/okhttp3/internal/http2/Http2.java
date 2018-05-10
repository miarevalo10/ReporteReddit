package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okio.ByteString;
import java.io.IOException;

public final class Http2 {
    static final ByteString f23465a = ByteString.m25595a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    static final String[] f23466b = new String[64];
    static final String[] f23467c = new String[256];
    private static final String[] f23468d = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        int i = 0;
        for (int i2 = 0; i2 < f23467c.length; i2++) {
            f23467c[i2] = Util.m25360a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
        }
        f23466b[0] = "";
        f23466b[1] = "END_STREAM";
        int[] iArr = new int[]{1};
        f23466b[8] = "PADDED";
        for (int i3 = 0; i3 <= 0; i3++) {
            int i4 = iArr[i3];
            String[] strArr = f23466b;
            int i5 = i4 | 8;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f23466b[i4]);
            stringBuilder.append("|PADDED");
            strArr[i5] = stringBuilder.toString();
        }
        f23466b[4] = "END_HEADERS";
        f23466b[32] = "PRIORITY";
        f23466b[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = new int[]{4, 32, 36};
        for (i4 = 0; i4 < 3; i4++) {
            int i6 = iArr2[i4];
            for (i5 = 0; i5 <= 0; i5++) {
                int i7 = iArr[i5];
                String[] strArr2 = f23466b;
                int i8 = i7 | i6;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(f23466b[i7]);
                stringBuilder2.append('|');
                stringBuilder2.append(f23466b[i6]);
                strArr2[i8] = stringBuilder2.toString();
                strArr2 = f23466b;
                i8 |= 8;
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(f23466b[i7]);
                stringBuilder2.append('|');
                stringBuilder2.append(f23466b[i6]);
                stringBuilder2.append("|PADDED");
                strArr2[i8] = stringBuilder2.toString();
            }
        }
        while (i < f23466b.length) {
            if (f23466b[i] == null) {
                f23466b[i] = f23467c[i];
            }
            i++;
        }
    }

    private Http2() {
    }

    static IllegalArgumentException m25463a(String str, Object... objArr) {
        throw new IllegalArgumentException(Util.m25360a(str, objArr));
    }

    static IOException m25465b(String str, Object... objArr) throws IOException {
        throw new IOException(Util.m25360a(str, objArr));
    }

    static String m25464a(boolean z, int i, int i2, byte b, byte b2) {
        String a = b < f23468d.length ? f23468d[b] : Util.m25360a("0x%02x", Byte.valueOf(b));
        if (b2 != (byte) 0) {
            switch (b) {
                case (byte) 2:
                case (byte) 3:
                case (byte) 7:
                case (byte) 8:
                    b = f23467c[b2];
                    break;
                case (byte) 4:
                case (byte) 6:
                    if (b2 != (byte) 1) {
                        b = f23467c[b2];
                        break;
                    }
                    b = "ACK";
                    break;
                default:
                    String str;
                    if (b2 < f23466b.length) {
                        str = f23466b[b2];
                    } else {
                        str = f23467c[b2];
                    }
                    if (b != (byte) 5 || (b2 & 4) == 0) {
                        if (b == (byte) 0 && (b2 & 32) != (byte) 0) {
                            b = str.replace("PRIORITY", "COMPRESSED");
                            break;
                        }
                        b = str;
                        break;
                    }
                    b = str.replace("HEADERS", "PUSH_PROMISE");
                    break;
                    break;
            }
        }
        b = "";
        String str2 = "%s 0x%08x %5d %-13s %s";
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[true] = Integer.valueOf(i2);
        objArr[true] = a;
        objArr[true] = b;
        return Util.m25360a(str2, objArr);
    }
}
