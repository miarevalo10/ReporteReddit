package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.BinaryVersion;

/* compiled from: JvmMetadataVersion.kt */
public final class JvmMetadataVersion extends BinaryVersion {
    public static final JvmMetadataVersion f32810a = new JvmMetadataVersion(1, 1, 5);
    public static final JvmMetadataVersion f32811b = new JvmMetadataVersion(new int[0]);
    public static final Companion f32812c = new Companion();
    private static boolean f32813g;

    /* compiled from: JvmMetadataVersion.kt */
    public static final class Companion {
        private Companion() {
        }

        public static boolean m27317a() {
            return JvmMetadataVersion.f32813g;
        }
    }

    public JvmMetadataVersion(int... iArr) {
        Intrinsics.m26847b(iArr, "numbers");
        super(Arrays.copyOf(iArr, iArr.length));
    }

    public final boolean m33204a() {
        if (!Companion.m27317a()) {
            if (this.f26213d != 1 || this.f26214e != 1) {
                return false;
            }
        }
        return true;
    }
}
