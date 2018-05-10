package kotlin.reflect.jvm.internal.impl.protobuf;

final class Utf8 {
    private static int m27571a(int i, int i2) {
        if (i <= -12) {
            if (i2 <= -65) {
                return i ^ (i2 << 8);
            }
        }
        return -1;
    }

    private static int m27572a(int i, int i2, int i3) {
        if (i <= -12 && i2 <= -65) {
            if (i3 <= -65) {
                return (i ^ (i2 << 8)) ^ (i3 << 16);
            }
        }
        return -1;
    }

    public static int m27573a(int r1, byte[] r2, int r3, int r4) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: kotlin.reflect.jvm.internal.impl.protobuf.Utf8.a(int, byte[], int, int):int
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 7 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.Utf8.a(int, byte[], int, int):int");
    }

    public static boolean m27574a(byte[] bArr) {
        return m27575a(bArr, 0, bArr.length);
    }

    public static boolean m27575a(byte[] bArr, int i, int i2) {
        return m27576b(bArr, i, i2) == null ? 1 : null;
    }

    private static int m27576b(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] >= (byte) 0) {
            i++;
        }
        if (i >= i2) {
            return 0;
        }
        while (i < i2) {
            int i3 = i + 1;
            i = bArr[i];
            if (i < 0) {
                if (i < -32) {
                    if (i3 >= i2) {
                        return i;
                    }
                    if (i >= -62) {
                        i = i3 + 1;
                        if (bArr[i3] > (byte) -65) {
                        }
                    }
                    return -1;
                } else if (i < -16) {
                    if (i3 >= i2 - 1) {
                        return m27577c(bArr, i3, i2);
                    }
                    int i4 = i3 + 1;
                    r1 = bArr[i3];
                    if (r1 <= (byte) -65 && ((i != -32 || r1 >= (byte) -96) && (i != -19 || r1 < (byte) -96))) {
                        i = i4 + 1;
                        if (bArr[i4] > (byte) -65) {
                        }
                    }
                    return -1;
                } else if (i3 >= i2 - 2) {
                    return m27577c(bArr, i3, i2);
                } else {
                    int i5 = i3 + 1;
                    r1 = bArr[i3];
                    if (r1 <= (byte) -65 && (((i << 28) + (r1 + 112)) >> 30) == 0) {
                        i = i5 + 1;
                        if (bArr[i5] <= (byte) -65) {
                            i3 = i + 1;
                            if (bArr[i] > -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
            i = i3;
        }
        return 0;
    }

    private static int m27577c(byte[] bArr, int i, int i2) {
        int i3 = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return i3 > -12 ? -1 : i3;
            case 1:
                return m27571a(i3, bArr[i]);
            case 2:
                return m27572a(i3, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }
}
