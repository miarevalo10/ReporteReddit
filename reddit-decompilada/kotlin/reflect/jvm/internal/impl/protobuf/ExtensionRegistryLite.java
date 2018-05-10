package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;

public class ExtensionRegistryLite {
    private static volatile boolean f25914b = false;
    private static final ExtensionRegistryLite f25915c = new ExtensionRegistryLite((byte) 0);
    final Map<ObjectIntPair, GeneratedExtension<?, ?>> f25916a;

    private static final class ObjectIntPair {
        private final Object f25912a;
        private final int f25913b;

        ObjectIntPair(Object obj, int i) {
            this.f25912a = obj;
            this.f25913b = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f25912a) * 65535) + this.f25913b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            if (this.f25912a == objectIntPair.f25912a && this.f25913b == objectIntPair.f25913b) {
                return true;
            }
            return false;
        }
    }

    public static ExtensionRegistryLite m27503a() {
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite m27504b() {
        return f25915c;
    }

    public final void m27505a(GeneratedExtension<?, ?> generatedExtension) {
        this.f25916a.put(new ObjectIntPair(generatedExtension.f25924a, generatedExtension.f25927d.f32862b), generatedExtension);
    }

    ExtensionRegistryLite() {
        this.f25916a = new HashMap();
    }

    private ExtensionRegistryLite(byte b) {
        this.f25916a = Collections.emptyMap();
    }
}
