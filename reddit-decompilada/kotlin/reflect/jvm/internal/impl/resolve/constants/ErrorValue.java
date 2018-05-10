package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public abstract class ErrorValue extends ConstantValue<Unit> {
    public static final Companion f32940a = new Companion();

    /* compiled from: constantValues.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ErrorValue m27732a(String str) {
            Intrinsics.m26847b(str, "message");
            return new ErrorValueWithMessage(str);
        }
    }

    /* compiled from: constantValues.kt */
    public static final class ErrorValueWithMessage extends ErrorValue {
        private final SimpleType f36145b = ErrorUtils.m27943c(this.f36146c);
        private final String f36146c;

        public ErrorValueWithMessage(String str) {
            Intrinsics.m26847b(str, "message");
            this.f36146c = str;
        }

        public final String toString() {
            return this.f36146c;
        }

        public final /* bridge */ /* synthetic */ KotlinType mo5917a() {
            return this.f36145b;
        }
    }

    public ErrorValue() {
        super(Unit.f25273a);
    }

    public final /* synthetic */ Object mo5919b() {
        throw new UnsupportedOperationException();
    }
}
