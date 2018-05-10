package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor.Capability;

/* compiled from: MultiTargetPlatform.kt */
public abstract class MultiTargetPlatform implements Comparable<MultiTargetPlatform> {
    public static final Capability<MultiTargetPlatform> f26072a = new Capability("MULTI_TARGET_PLATFORM");
    public static final Companion f26073b = new Companion();

    /* compiled from: MultiTargetPlatform.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: MultiTargetPlatform.kt */
    public static final class Common extends MultiTargetPlatform {
        public static final Common f32931c = null;

        static {
            Common common = new Common();
        }

        private Common() {
            super();
            f32931c = this;
        }

        public final /* synthetic */ int compareTo(Object obj) {
            MultiTargetPlatform multiTargetPlatform = (MultiTargetPlatform) obj;
            Intrinsics.m26847b(multiTargetPlatform, "other");
            return (multiTargetPlatform instanceof Common) != null ? null : -1;
        }
    }

    private MultiTargetPlatform() {
    }
}
