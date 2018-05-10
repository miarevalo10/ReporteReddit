package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.BinaryVersion;

/* compiled from: JvmBytecodeBinaryVersion.kt */
public final class JvmBytecodeBinaryVersion extends BinaryVersion {
    public static final JvmBytecodeBinaryVersion f32695a = new JvmBytecodeBinaryVersion(1, 0, 1);
    public static final JvmBytecodeBinaryVersion f32696b = new JvmBytecodeBinaryVersion(new int[0]);
    public static final Companion f32697c = new Companion();

    /* compiled from: JvmBytecodeBinaryVersion.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public JvmBytecodeBinaryVersion(int... iArr) {
        Intrinsics.m26847b(iArr, "numbers");
        super(Arrays.copyOf(iArr, iArr.length));
    }
}
