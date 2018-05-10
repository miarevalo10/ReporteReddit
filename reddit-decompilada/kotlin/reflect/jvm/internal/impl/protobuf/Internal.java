package kotlin.reflect.jvm.internal.impl.protobuf;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

public class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;

    public interface EnumLite {
        int mo5922a();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T mo5921a(int i);
    }

    public static int hashBoolean(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int hashLong(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static String stringDefaultValue(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (String str2) {
            throw new IllegalStateException("Java VM does not support a standard character set.", str2);
        }
    }

    public static ByteString bytesDefaultValue(String str) {
        try {
            return ByteString.m27454a(str.getBytes("ISO-8859-1"));
        } catch (String str2) {
            throw new IllegalStateException("Java VM does not support a standard character set.", str2);
        }
    }

    public static byte[] byteArrayDefaultValue(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (String str2) {
            throw new IllegalStateException("Java VM does not support a standard character set.", str2);
        }
    }

    public static ByteBuffer byteBufferDefaultValue(String str) {
        return ByteBuffer.wrap(byteArrayDefaultValue(str));
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        byteBuffer = byteBuffer.duplicate();
        byteBuffer.clear();
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
        allocate.put(byteBuffer);
        allocate.clear();
        return allocate;
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.mo5875f();
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.m27574a(bArr);
    }

    public static byte[] toByteArray(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (String str2) {
            throw new RuntimeException("UTF-8 not supported?", str2);
        }
    }

    public static String toStringUtf8(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (byte[] bArr2) {
            throw new RuntimeException("UTF-8 not supported?", bArr2);
        }
    }

    public static int hashEnum(EnumLite enumLite) {
        return enumLite.mo5922a();
    }

    public static int hashEnumList(List<? extends EnumLite> list) {
        int i = 1;
        for (EnumLite hashEnum : list) {
            i = hashEnum(hashEnum) + (31 * i);
        }
        return i;
    }

    public static boolean equals(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCode(List<byte[]> list) {
        int i = 1;
        for (byte[] hashCode : list) {
            i = hashCode(hashCode) + (31 * i);
        }
        return i;
    }

    public static int hashCode(byte[] bArr) {
        return LiteralByteString.m33295b(bArr);
    }

    public static boolean equalsByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() != byteBuffer2.capacity()) {
            return null;
        }
        return byteBuffer.duplicate().clear().equals(byteBuffer2.duplicate().clear());
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> list, List<ByteBuffer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!equalsByteBuffer((ByteBuffer) list.get(i), (ByteBuffer) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        int i = 1;
        for (ByteBuffer hashCodeByteBuffer : list) {
            i = hashCodeByteBuffer(hashCodeByteBuffer) + (31 * i);
        }
        return i;
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            byteBuffer = LiteralByteString.m33294a(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (byteBuffer == null) {
                return 1;
            }
            return byteBuffer;
        }
        int i = 4096;
        if (byteBuffer.capacity() <= 4096) {
            i = byteBuffer.capacity();
        }
        byte[] bArr = new byte[i];
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        int capacity = byteBuffer.capacity();
        while (duplicate.remaining() > 0) {
            int remaining = duplicate.remaining() <= i ? duplicate.remaining() : i;
            duplicate.get(bArr, 0, remaining);
            capacity = LiteralByteString.m33294a(capacity, bArr, 0, remaining);
        }
        if (capacity == 0) {
            return 1;
        }
        return capacity;
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
    }
}
