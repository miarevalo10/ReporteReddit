package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: TypeMappingMode.kt */
public final class TypeMappingMode {
    public static final TypeMappingMode f25814f = new TypeMappingMode(false, false, false, null, null, null, 127);
    public static final TypeMappingMode f25815g = new TypeMappingMode(false, false, false, f25814f, null, null, 110);
    public static final TypeMappingMode f25816h = new TypeMappingMode(false, false, true, f25814f, null, null, 107);
    public static final TypeMappingMode f25817i = new TypeMappingMode(false, true, false, new TypeMappingMode(false, true, false, f25814f, null, null, 109), null, null, 108);
    public static final Companion f25818j = new Companion();
    final boolean f25819a;
    final boolean f25820b;
    final TypeMappingMode f25821c;
    final TypeMappingMode f25822d;
    final TypeMappingMode f25823e;
    private final boolean f25824k;
    private final boolean f25825l;

    /* compiled from: TypeMappingMode.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25813a;

        static {
            int[] iArr = new int[Variance.values().length];
            f25813a = iArr;
            iArr[Variance.f26338b.ordinal()] = 1;
            f25813a[Variance.f26337a.ordinal()] = 2;
        }
    }

    private TypeMappingMode(boolean z, boolean z2, boolean z3, TypeMappingMode typeMappingMode, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3) {
        this.f25819a = z;
        this.f25820b = z2;
        this.f25824k = z3;
        this.f25825l = false;
        this.f25821c = typeMappingMode;
        this.f25822d = typeMappingMode2;
        this.f25823e = typeMappingMode3;
    }

    private /* synthetic */ TypeMappingMode(boolean z, boolean z2, boolean z3, TypeMappingMode typeMappingMode, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, int i) {
        if ((i & 1) != 0) {
            z = true;
        }
        boolean z4 = z;
        boolean z5 = i & 2 ? false : z2;
        boolean z6 = i & 4 ? false : z3;
        if (i & 16) {
            typeMappingMode = null;
        }
        TypeMappingMode typeMappingMode4 = typeMappingMode;
        this(z4, z5, z6, typeMappingMode4, i & 32 ? typeMappingMode4 : typeMappingMode2, i & 64 ? typeMappingMode4 : typeMappingMode3);
    }
}
