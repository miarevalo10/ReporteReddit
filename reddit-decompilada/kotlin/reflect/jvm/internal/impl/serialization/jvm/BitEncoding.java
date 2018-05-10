package kotlin.reflect.jvm.internal.impl.serialization.jvm;

public class BitEncoding {
    static final /* synthetic */ boolean f26284a = true;
    private static final boolean f26285b = "true".equals(System.getProperty("kotlin.jvm.serialization.use8to7"));

    private BitEncoding() {
    }

    private static void m27899a(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "addModuloByte"}));
        }
        int length = bArr.length;
        while (i < length) {
            bArr[i] = (byte) ((bArr[i] + 127) & 127);
            i++;
        }
    }

    public static byte[] m27900a(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "decodeBytes"}));
        }
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char charAt = strArr[0].charAt(0);
            if (charAt == '\u0000') {
                return UtfEncodingKt.m27913a(m27902b(strArr));
            }
            if (charAt == '￿') {
                strArr = m27902b(strArr);
            }
        }
        byte[] c = m27903c(strArr);
        m27899a(c);
        return m27901b(c);
    }

    private static String[] m27902b(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "dropMarker"}));
        }
        strArr = (String[]) strArr.clone();
        strArr[0] = strArr[0].substring(1);
        if (strArr != null) {
            return strArr;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "dropMarker"}));
    }

    private static byte[] m27903c(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "combineStringArrayIntoBytes"}));
        }
        int length = strArr.length;
        int i = 0;
        int i2 = i;
        while (i < length) {
            String str = strArr[i];
            if (f26284a || str.length() <= 65535) {
                i2 += str.length();
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder("String is too long: ");
                stringBuilder.append(str.length());
                throw new AssertionError(stringBuilder.toString());
            }
        }
        byte[] bArr = new byte[i2];
        i = strArr.length;
        i2 = 0;
        int i3 = i2;
        while (i2 < i) {
            String str2 = strArr[i2];
            int length2 = str2.length();
            int i4 = i3;
            i3 = 0;
            while (i3 < length2) {
                int i5 = i4 + 1;
                bArr[i4] = (byte) str2.charAt(i3);
                i3++;
                i4 = i5;
            }
            i2++;
            i3 = i4;
        }
        return bArr;
    }

    private static byte[] m27901b(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "decode7to8"}));
        }
        int length = (bArr.length * 7) / 8;
        byte[] bArr2 = new byte[length];
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < length) {
            i2++;
            int i4 = i3 + 1;
            bArr2[i] = (byte) (((bArr[i2] & 255) >>> i3) + ((bArr[i2] & ((1 << i4) - 1)) << (7 - i3)));
            if (i3 == 6) {
                i2++;
                i3 = 0;
            } else {
                i3 = i4;
            }
            i++;
        }
        return bArr2;
    }
}
