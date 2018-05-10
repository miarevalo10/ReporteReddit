package kotlin.reflect.jvm.internal.impl.protobuf;

public final class WireFormat {
    static final int f25997a = 11;
    static final int f25998b = 12;
    static final int f25999c = 16;
    static final int f26000d = 26;

    public enum FieldType {
        DOUBLE(JavaType.DOUBLE, 1),
        FLOAT(JavaType.FLOAT, 5),
        INT64(JavaType.LONG, 0),
        UINT64(JavaType.LONG, 0),
        INT32(JavaType.INT, 0),
        FIXED64(JavaType.LONG, 1),
        FIXED32(JavaType.INT, 5),
        BOOL(JavaType.BOOLEAN, 0),
        STRING {
            public final boolean mo5883a() {
                return false;
            }
        },
        GROUP {
            public final boolean mo5883a() {
                return false;
            }
        },
        MESSAGE {
            public final boolean mo5883a() {
                return false;
            }
        },
        BYTES {
            public final boolean mo5883a() {
                return false;
            }
        },
        UINT32(JavaType.INT, 0),
        ENUM(JavaType.ENUM, 0),
        SFIXED32(JavaType.INT, 5),
        SFIXED64(JavaType.LONG, 1),
        SINT32(JavaType.INT, 0),
        SINT64(JavaType.LONG, 0);
        
        final JavaType f25984s;
        final int f25985t;

        public boolean mo5883a() {
            return true;
        }

        private FieldType(JavaType javaType, int i) {
            this.f25984s = javaType;
            this.f25985t = i;
        }
    }

    public enum JavaType {
        INT(Integer.valueOf(0)),
        LONG(Long.valueOf(0)),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.valueOf(false)),
        STRING(""),
        BYTE_STRING(ByteString.f25891b),
        ENUM(null),
        MESSAGE(null);
        
        private final Object f25996j;

        private JavaType(Object obj) {
            this.f25996j = obj;
        }
    }

    static int m27579a(int i) {
        return i & 7;
    }

    public static int m27580b(int i) {
        return i >>> 3;
    }

    static int m27581c(int i) {
        return (i << 3) | 4;
    }
}
