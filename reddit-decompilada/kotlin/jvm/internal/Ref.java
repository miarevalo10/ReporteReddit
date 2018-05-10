package kotlin.jvm.internal;

import java.io.Serializable;

public class Ref {

    public static final class BooleanRef implements Serializable {
        public boolean f25288a;

        public final String toString() {
            return String.valueOf(this.f25288a);
        }
    }

    public static final class FloatRef implements Serializable {
        public float f25289a;

        public final String toString() {
            return String.valueOf(this.f25289a);
        }
    }

    public static final class IntRef implements Serializable {
        public int f25290a;

        public final String toString() {
            return String.valueOf(this.f25290a);
        }
    }

    public static final class ObjectRef<T> implements Serializable {
        public T f25291a;

        public final String toString() {
            return String.valueOf(this.f25291a);
        }
    }
}
