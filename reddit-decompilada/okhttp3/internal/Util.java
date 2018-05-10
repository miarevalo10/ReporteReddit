package okhttp3.internal;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final RequestBody EMPTY_REQUEST = RequestBody.create(null, EMPTY_BYTE_ARRAY);
    public static final ResponseBody EMPTY_RESPONSE = ResponseBody.create(null, EMPTY_BYTE_ARRAY);
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Comparator<String> NATURAL_ORDER = new C21771();
    public static final TimeZone UTC = TimeZone.getTimeZone("GMT");
    private static final Charset UTF_16_BE = Charset.forName("UTF-16BE");
    private static final ByteString UTF_16_BE_BOM = ByteString.m28271c("feff");
    private static final Charset UTF_16_LE = Charset.forName("UTF-16LE");
    private static final ByteString UTF_16_LE_BOM = ByteString.m28271c("fffe");
    private static final Charset UTF_32_BE = Charset.forName("UTF-32BE");
    private static final ByteString UTF_32_BE_BOM = ByteString.m28271c("0000ffff");
    private static final Charset UTF_32_LE = Charset.forName("UTF-32LE");
    private static final ByteString UTF_32_LE_BOM = ByteString.m28271c("ffff0000");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final ByteString UTF_8_BOM = ByteString.m28271c("efbbbf");
    private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    class C21771 implements Comparator<String> {
        C21771() {
        }

        public final int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    class C21782 implements ThreadFactory {
        final /* synthetic */ boolean val$daemon;
        final /* synthetic */ String val$name;

        C21782(String str, boolean z) {
            this.val$name = str;
            this.val$daemon = z;
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.val$name);
            thread.setDaemon(this.val$daemon);
            return thread;
        }
    }

    public static int decodeHexDigit(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    private Util() {
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) >= 0 && j2 <= j) {
            if (j - j2 >= j3) {
                return;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    public static void closeQuietly(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0008;
    L_0x0002:
        r0.close();	 Catch:{ RuntimeException -> 0x0006, Exception -> 0x0008 }
        return;
    L_0x0006:
        r0 = move-exception;
        throw r0;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.closeQuietly(java.io.Closeable):void");
    }

    public static void closeQuietly(java.net.Socket r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r1 == 0) goto L_0x0011;
    L_0x0002:
        r1.close();	 Catch:{ AssertionError -> 0x0008, RuntimeException -> 0x0006, Exception -> 0x0011 }
        return;
    L_0x0006:
        r1 = move-exception;
        throw r1;
    L_0x0008:
        r1 = move-exception;
        r0 = isAndroidGetsocknameError(r1);
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        throw r1;
    L_0x0010:
        return;
    L_0x0011:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.closeQuietly(java.net.Socket):void");
    }

    public static void closeQuietly(java.net.ServerSocket r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0008;
    L_0x0002:
        r0.close();	 Catch:{ RuntimeException -> 0x0006, Exception -> 0x0008 }
        return;
    L_0x0006:
        r0 = move-exception;
        throw r0;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.closeQuietly(java.net.ServerSocket):void");
    }

    public static boolean discard(okio.Source r0, int r1, java.util.concurrent.TimeUnit r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = skipAll(r0, r1, r2);	 Catch:{ IOException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.discard(okio.Source, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static boolean skipAll(okio.Source r11, int r12, java.util.concurrent.TimeUnit r13) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.System.nanoTime();
        r2 = r11.timeout();
        r2 = r2.hasDeadline();
        r3 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        if (r2 == 0) goto L_0x001d;
    L_0x0013:
        r2 = r11.timeout();
        r5 = r2.deadlineNanoTime();
        r5 = r5 - r0;
        goto L_0x001e;
    L_0x001d:
        r5 = r3;
    L_0x001e:
        r2 = r11.timeout();
        r7 = (long) r12;
        r12 = r13.toNanos(r7);
        r12 = java.lang.Math.min(r5, r12);
        r12 = r12 + r0;
        r2.deadlineNanoTime(r12);
        r12 = new okio.Buffer;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r12.<init>();	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
    L_0x0034:
        r7 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r7 = r11.read(r12, r7);	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r9 = -1;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        if (r13 == 0) goto L_0x0044;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
    L_0x0040:
        r12.m36539t();	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        goto L_0x0034;
    L_0x0044:
        r12 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r12 != 0) goto L_0x0050;
    L_0x0048:
        r11 = r11.timeout();
        r11.clearDeadline();
        goto L_0x0058;
    L_0x0050:
        r11 = r11.timeout();
        r0 = r0 + r5;
        r11.deadlineNanoTime(r0);
    L_0x0058:
        r11 = 1;
        return r11;
    L_0x005a:
        r12 = move-exception;
        r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r13 != 0) goto L_0x0067;
    L_0x005f:
        r11 = r11.timeout();
        r11.clearDeadline();
        goto L_0x006f;
    L_0x0067:
        r11 = r11.timeout();
        r0 = r0 + r5;
        r11.deadlineNanoTime(r0);
    L_0x006f:
        throw r12;
    L_0x0070:
        r12 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r12 != 0) goto L_0x007c;
    L_0x0074:
        r11 = r11.timeout();
        r11.clearDeadline();
        goto L_0x0084;
    L_0x007c:
        r11 = r11.timeout();
        r0 = r0 + r5;
        r11.deadlineNanoTime(r0);
    L_0x0084:
        r11 = 0;
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.skipAll(okio.Source, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static <T> List<T> immutableList(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> immutableList(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory threadFactory(String str, boolean z) {
        return new C21782(str, z);
    }

    public static String[] intersect(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        List arrayList = new ArrayList();
        for (Object obj : strArr) {
            for (Object compare : strArr2) {
                if (comparator.compare(obj, compare) == 0) {
                    arrayList.add(obj);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean nonEmptyIntersection(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0)) {
            if (strArr2.length != 0) {
                for (Object obj : strArr) {
                    for (Object compare : strArr2) {
                        if (comparator.compare(obj, compare) == 0) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static String hostHeader(HttpUrl httpUrl, boolean z) {
        String stringBuilder;
        if (httpUrl.host().contains(":")) {
            StringBuilder stringBuilder2 = new StringBuilder("[");
            stringBuilder2.append(httpUrl.host());
            stringBuilder2.append("]");
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = httpUrl.host();
        }
        if (!z) {
            if (httpUrl.port() == HttpUrl.defaultPort(httpUrl.scheme())) {
                return stringBuilder;
            }
        }
        z = new StringBuilder();
        z.append(stringBuilder);
        z.append(":");
        z.append(httpUrl.port());
        return z.toString();
    }

    public static String toHumanReadableAscii(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt > 31) {
                if (codePointAt < 127) {
                    i += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            buffer.m36483a(str, 0, i);
            while (i < length) {
                int codePointAt2 = str.codePointAt(i);
                int i2 = (codePointAt2 <= 31 || codePointAt2 >= 127) ? 63 : codePointAt2;
                buffer.m36481a(i2);
                i += Character.charCount(codePointAt2);
            }
            return buffer.m36535p();
        }
        return str;
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || assertionError.getMessage().contains("getsockname failed") == null) ? null : true;
    }

    public static int indexOf(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String[] concat(String[] strArr, String str) {
        Object obj = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        obj[obj.length - 1] = str;
        return obj;
    }

    public static int skipLeadingAsciiWhitespace(String str, int i, int i2) {
        while (i < i2) {
            switch (str.charAt(i)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i++;
                default:
                    return i;
            }
        }
        return i2;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i, int i2) {
        i2--;
        while (i2 >= i) {
            switch (str.charAt(i2)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i2--;
                default:
                    return i2 + 1;
            }
        }
        return i;
    }

    public static String trimSubstring(String str, int i, int i2) {
        i = skipLeadingAsciiWhitespace(str, i, i2);
        return str.substring(i, skipTrailingAsciiWhitespace(str, i, i2));
    }

    public static int delimiterOffset(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int delimiterOffset(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static java.lang.String canonicalizeHost(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = ":";
        r0 = r3.contains(r0);
        r1 = 0;
        if (r0 == 0) goto L_0x0057;
    L_0x0009:
        r0 = "[";
        r0 = r3.startsWith(r0);
        if (r0 == 0) goto L_0x0024;
    L_0x0011:
        r0 = "]";
        r0 = r3.endsWith(r0);
        if (r0 == 0) goto L_0x0024;
    L_0x0019:
        r0 = r3.length();
        r2 = 1;
        r0 = r0 - r2;
        r0 = decodeIpv6(r3, r2, r0);
        goto L_0x002d;
    L_0x0024:
        r0 = 0;
        r2 = r3.length();
        r0 = decodeIpv6(r3, r0, r2);
    L_0x002d:
        if (r0 != 0) goto L_0x0030;
    L_0x002f:
        return r1;
    L_0x0030:
        r0 = r0.getAddress();
        r1 = r0.length;
        r2 = 16;
        if (r1 != r2) goto L_0x003e;
    L_0x0039:
        r3 = inet6AddressToAscii(r0);
        return r3;
    L_0x003e:
        r0 = new java.lang.AssertionError;
        r1 = new java.lang.StringBuilder;
        r2 = "Invalid IPv6 address: '";
        r1.<init>(r2);
        r1.append(r3);
        r3 = "'";
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
    L_0x0057:
        r3 = java.net.IDN.toASCII(r3);	 Catch:{ IllegalArgumentException -> 0x0070 }
        r0 = java.util.Locale.US;	 Catch:{ IllegalArgumentException -> 0x0070 }
        r3 = r3.toLowerCase(r0);	 Catch:{ IllegalArgumentException -> 0x0070 }
        r0 = r3.isEmpty();	 Catch:{ IllegalArgumentException -> 0x0070 }
        if (r0 == 0) goto L_0x0068;	 Catch:{ IllegalArgumentException -> 0x0070 }
    L_0x0067:
        return r1;	 Catch:{ IllegalArgumentException -> 0x0070 }
    L_0x0068:
        r0 = containsInvalidHostnameAsciiCodes(r3);	 Catch:{ IllegalArgumentException -> 0x0070 }
        if (r0 == 0) goto L_0x006f;
    L_0x006e:
        return r1;
    L_0x006f:
        return r3;
    L_0x0070:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.canonicalizeHost(java.lang.String):java.lang.String");
    }

    private static boolean containsInvalidHostnameAsciiCodes(String str) {
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt > '\u001f') {
                if (charAt < '') {
                    if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                        return true;
                    }
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    public static int indexOfControlOrNonAscii(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt > '\u001f') {
                if (charAt < '') {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }

    public static boolean verifyAsIpAddress(String str) {
        return VERIFY_AS_IP_ADDRESS.matcher(str).matches();
    }

    public static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset bomAwareCharset(BufferedSource bufferedSource, Charset charset) throws IOException {
        if (bufferedSource.mo6766c(UTF_8_BOM)) {
            bufferedSource.mo6779i((long) UTF_8_BOM.mo6166h());
            return UTF_8;
        } else if (bufferedSource.mo6766c(UTF_16_BE_BOM)) {
            bufferedSource.mo6779i((long) UTF_16_BE_BOM.mo6166h());
            return UTF_16_BE;
        } else if (bufferedSource.mo6766c(UTF_16_LE_BOM)) {
            bufferedSource.mo6779i((long) UTF_16_LE_BOM.mo6166h());
            return UTF_16_LE;
        } else if (bufferedSource.mo6766c(UTF_32_BE_BOM)) {
            bufferedSource.mo6779i((long) UTF_32_BE_BOM.mo6166h());
            return UTF_32_BE;
        } else if (!bufferedSource.mo6766c(UTF_32_LE_BOM)) {
            return charset;
        } else {
            bufferedSource.mo6779i((long) UTF_32_LE_BOM.mo6166h());
            return UTF_32_LE;
        }
    }

    public static int checkDuration(String str, long j, TimeUnit timeUnit) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        StringBuilder stringBuilder;
        if (i < 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" < 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        } else {
            j = timeUnit.toMillis(j);
            if (j > 2147483647L) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" too large.");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (j != 0 || i <= 0) {
                return (int) j;
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" too small.");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    public static AssertionError assertionError(String str, Exception exception) {
        return (AssertionError) new AssertionError(str).initCause(exception);
    }

    private static java.net.InetAddress decodeIpv6(java.lang.String r11, int r12, int r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 16;
        r1 = new byte[r0];
        r2 = -1;
        r3 = 0;
        r5 = r2;
        r6 = r5;
        r4 = r3;
    L_0x0009:
        r7 = 0;
        if (r12 >= r13) goto L_0x007a;
    L_0x000c:
        if (r4 != r0) goto L_0x000f;
    L_0x000e:
        return r7;
    L_0x000f:
        r8 = r12 + 2;
        if (r8 > r13) goto L_0x0028;
    L_0x0013:
        r9 = "::";
        r10 = 2;
        r9 = r11.regionMatches(r12, r9, r3, r10);
        if (r9 == 0) goto L_0x0028;
    L_0x001c:
        if (r5 == r2) goto L_0x001f;
    L_0x001e:
        return r7;
    L_0x001f:
        r4 = r4 + 2;
        if (r8 != r13) goto L_0x0025;
    L_0x0023:
        r5 = r4;
        goto L_0x007a;
    L_0x0025:
        r5 = r4;
        r6 = r8;
        goto L_0x004c;
    L_0x0028:
        if (r4 == 0) goto L_0x004b;
    L_0x002a:
        r8 = ":";
        r9 = 1;
        r8 = r11.regionMatches(r12, r8, r3, r9);
        if (r8 == 0) goto L_0x0036;
    L_0x0033:
        r12 = r12 + 1;
        goto L_0x004b;
    L_0x0036:
        r8 = ".";
        r12 = r11.regionMatches(r12, r8, r3, r9);
        if (r12 == 0) goto L_0x004a;
    L_0x003e:
        r12 = r4 + -2;
        r11 = decodeIpv4Suffix(r11, r6, r13, r1, r12);
        if (r11 != 0) goto L_0x0047;
    L_0x0046:
        return r7;
    L_0x0047:
        r4 = r4 + 2;
        goto L_0x007a;
    L_0x004a:
        return r7;
    L_0x004b:
        r6 = r12;
    L_0x004c:
        r8 = r3;
        r12 = r6;
    L_0x004e:
        if (r12 >= r13) goto L_0x0060;
    L_0x0050:
        r9 = r11.charAt(r12);
        r9 = decodeHexDigit(r9);
        if (r9 == r2) goto L_0x0060;
    L_0x005a:
        r8 = r8 << 4;
        r8 = r8 + r9;
        r12 = r12 + 1;
        goto L_0x004e;
    L_0x0060:
        r9 = r12 - r6;
        if (r9 == 0) goto L_0x0079;
    L_0x0064:
        r10 = 4;
        if (r9 <= r10) goto L_0x0068;
    L_0x0067:
        goto L_0x0079;
    L_0x0068:
        r7 = r4 + 1;
        r9 = r8 >>> 8;
        r9 = r9 & 255;
        r9 = (byte) r9;
        r1[r4] = r9;
        r4 = r7 + 1;
        r8 = r8 & 255;
        r8 = (byte) r8;
        r1[r7] = r8;
        goto L_0x0009;
    L_0x0079:
        return r7;
    L_0x007a:
        if (r4 == r0) goto L_0x008b;
    L_0x007c:
        if (r5 != r2) goto L_0x007f;
    L_0x007e:
        return r7;
    L_0x007f:
        r11 = r4 - r5;
        r12 = 16 - r11;
        java.lang.System.arraycopy(r1, r5, r1, r12, r11);
        r0 = r0 - r4;
        r0 = r0 + r5;
        java.util.Arrays.fill(r1, r5, r0, r3);
    L_0x008b:
        r11 = java.net.InetAddress.getByAddress(r1);	 Catch:{ UnknownHostException -> 0x0090 }
        return r11;
    L_0x0090:
        r11 = new java.lang.AssertionError;
        r11.<init>();
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    private static boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if (i6 == 0 && i != i5) {
                    return false;
                } else {
                    i6 = ((i6 * 10) + charAt) - 48;
                    if (i6 > 255) {
                        return false;
                    }
                    i5++;
                }
            }
            if (i5 - i == 0) {
                return false;
            }
            i = i4 + 1;
            bArr[i4] = (byte) i6;
            i4 = i;
            i = i5;
        }
        if (i4 != i3 + 4) {
            return false;
        }
        return true;
    }

    private static String inet6AddressToAscii(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = i2;
        while (i4 < bArr.length) {
            int i5 = i4;
            while (i5 < 16 && bArr[i5] == (byte) 0 && bArr[i5 + 1] == (byte) 0) {
                i5 += 2;
            }
            int i6 = i5 - i4;
            if (i6 > i2 && i6 >= 4) {
                i3 = i4;
                i2 = i6;
            }
            i4 = i5 + 2;
        }
        Buffer buffer = new Buffer();
        while (i < bArr.length) {
            if (i == i3) {
                buffer.m36493b(58);
                i += i2;
                if (i == 16) {
                    buffer.m36493b(58);
                }
            } else {
                if (i > 0) {
                    buffer.m36493b(58);
                }
                buffer.m36528l((long) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                i += 2;
            }
        }
        return buffer.m36535p();
    }
}
