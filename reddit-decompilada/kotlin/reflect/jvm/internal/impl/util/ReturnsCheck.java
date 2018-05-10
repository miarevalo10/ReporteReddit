package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.util.Check.DefaultImpls;

/* compiled from: modifierChecks.kt */
public abstract class ReturnsCheck implements Check {
    private final String f33095a;
    private final String f33096b;
    private final Function1<KotlinBuiltIns, KotlinType> f33097c;

    /* compiled from: modifierChecks.kt */
    public static final class ReturnsBoolean extends ReturnsCheck {
        public static final ReturnsBoolean f36182a = null;

        /* compiled from: modifierChecks.kt */
        static final class C30101 extends Lambda implements Function1<KotlinBuiltIns, SimpleType> {
            public static final C30101 f38957a = new C30101();

            C30101() {
                super(1);
            }

            public final /* synthetic */ Object mo6492a(Object obj) {
                KotlinBuiltIns kotlinBuiltIns = (KotlinBuiltIns) obj;
                Intrinsics.m26847b(kotlinBuiltIns, "$receiver");
                obj = kotlinBuiltIns.m27025w();
                Intrinsics.m26843a(obj, "booleanType");
                return obj;
            }
        }

        static {
            ReturnsBoolean returnsBoolean = new ReturnsBoolean();
        }

        private ReturnsBoolean() {
            super("Boolean", C30101.f38957a);
            f36182a = this;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class ReturnsInt extends ReturnsCheck {
        public static final ReturnsInt f36183a = null;

        /* compiled from: modifierChecks.kt */
        static final class C30111 extends Lambda implements Function1<KotlinBuiltIns, SimpleType> {
            public static final C30111 f38958a = new C30111();

            C30111() {
                super(1);
            }

            public final /* synthetic */ Object mo6492a(Object obj) {
                KotlinBuiltIns kotlinBuiltIns = (KotlinBuiltIns) obj;
                Intrinsics.m26847b(kotlinBuiltIns, "$receiver");
                obj = kotlinBuiltIns.m27020r();
                Intrinsics.m26843a(obj, "intType");
                return obj;
            }
        }

        static {
            ReturnsInt returnsInt = new ReturnsInt();
        }

        private ReturnsInt() {
            super("Int", C30111.f38958a);
            f36183a = this;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class ReturnsUnit extends ReturnsCheck {
        public static final ReturnsUnit f36184a = null;

        /* compiled from: modifierChecks.kt */
        static final class C30121 extends Lambda implements Function1<KotlinBuiltIns, SimpleType> {
            public static final C30121 f38959a = new C30121();

            C30121() {
                super(1);
            }

            public final /* synthetic */ Object mo6492a(Object obj) {
                KotlinBuiltIns kotlinBuiltIns = (KotlinBuiltIns) obj;
                Intrinsics.m26847b(kotlinBuiltIns, "$receiver");
                obj = kotlinBuiltIns.m27026x();
                Intrinsics.m26843a(obj, "unitType");
                return obj;
            }
        }

        static {
            ReturnsUnit returnsUnit = new ReturnsUnit();
        }

        private ReturnsUnit() {
            super("Unit", C30121.f38959a);
            f36184a = this;
        }
    }

    private ReturnsCheck(String str, Function1<? super KotlinBuiltIns, ? extends KotlinType> function1) {
        this.f33096b = str;
        this.f33097c = function1;
        str = new StringBuilder("must return ");
        str.append(this.f33096b);
        this.f33095a = str.toString();
    }

    public final String mo5945b(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
        return DefaultImpls.m28076a(this, functionDescriptor);
    }

    public final String mo5943a() {
        return this.f33095a;
    }

    public final boolean mo5944a(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
        return Intrinsics.m26845a(functionDescriptor.aN_(), (KotlinType) this.f33097c.mo6492a(DescriptorUtilsKt.m27745d(functionDescriptor)));
    }
}
