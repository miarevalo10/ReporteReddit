package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Variance.kt */
public enum Variance {
    ;
    
    public final String f26341d;
    public final boolean f26342e;
    private final boolean f26343g;
    private final int f26344h;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f26335a = null;
        public static final /* synthetic */ int[] f26336b = null;

        static {
            int[] iArr = new int[Variance.values().length];
            f26335a = iArr;
            iArr[Variance.f26338b.ordinal()] = 1;
            f26335a[Variance.f26339c.ordinal()] = 2;
            f26335a[Variance.f26337a.ordinal()] = 3;
            iArr = new int[Variance.values().length];
            f26336b = iArr;
            iArr[Variance.f26337a.ordinal()] = 1;
            f26336b[Variance.f26338b.ordinal()] = 2;
            f26336b[Variance.f26339c.ordinal()] = 3;
        }
    }

    private Variance(String str, boolean z, boolean z2, int i) {
        Intrinsics.m26847b(str, "label");
        this.f26341d = str;
        this.f26343g = z;
        this.f26342e = z2;
        this.f26344h = i;
    }

    public final boolean m28021a(Variance variance) {
        Intrinsics.m26847b(variance, "position");
        switch (WhenMappings.f26335a[variance.ordinal()]) {
            case 1:
                return this.f26343g;
            case 2:
                return this.f26342e;
            case 3:
                return (this.f26343g == null || this.f26342e == null) ? null : true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String toString() {
        return this.f26341d;
    }
}
