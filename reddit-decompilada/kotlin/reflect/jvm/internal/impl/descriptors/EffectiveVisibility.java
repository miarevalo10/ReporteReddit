package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: EffectiveVisibility.kt */
public abstract class EffectiveVisibility {
    private final String name;
    private final boolean privateApi;
    private final boolean publicApi;

    /* compiled from: EffectiveVisibility.kt */
    public enum Permissiveness {
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25487a;

        static {
            int[] iArr = new int[Permissiveness.values().length];
            f25487a = iArr;
            iArr[Permissiveness.f25480b.ordinal()] = 1;
            f25487a[Permissiveness.f25479a.ordinal()] = 2;
            f25487a[Permissiveness.f25481c.ordinal()] = 3;
            f25487a[Permissiveness.f25482d.ordinal()] = 4;
        }
    }

    /* compiled from: EffectiveVisibility.kt */
    public static abstract class InternalOrPackage extends EffectiveVisibility {
        protected InternalOrPackage(boolean z) {
            super(z ? "internal" : "public/*package*/", false, false, 6, null);
        }

        public Permissiveness relation(EffectiveVisibility effectiveVisibility) {
            Intrinsics.m26847b(effectiveVisibility, "other");
            if (Intrinsics.m26845a((Object) effectiveVisibility, Public.f32636a)) {
                return Permissiveness.f25479a;
            }
            if (!(Intrinsics.m26845a((Object) effectiveVisibility, Private.f32633a) || Intrinsics.m26845a((Object) effectiveVisibility, Local.f32632a) || Intrinsics.m26845a((Object) effectiveVisibility, InternalProtectedBound.f32631a))) {
                if (!(effectiveVisibility instanceof InternalProtected)) {
                    if (effectiveVisibility instanceof InternalOrPackage) {
                        return Permissiveness.f25480b;
                    }
                    if (!Intrinsics.m26845a((Object) effectiveVisibility, ProtectedBound.f32635a)) {
                        if ((effectiveVisibility instanceof Protected) == null) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    return Permissiveness.f25482d;
                }
            }
            return Permissiveness.f25481c;
        }

        public EffectiveVisibility lowerBound$kotlin_core(EffectiveVisibility effectiveVisibility) {
            Intrinsics.m26847b(effectiveVisibility, "other");
            if (Intrinsics.m26845a((Object) effectiveVisibility, Public.f32636a)) {
                return this;
            }
            if (!(Intrinsics.m26845a((Object) effectiveVisibility, Private.f32633a) || Intrinsics.m26845a((Object) effectiveVisibility, Local.f32632a) || Intrinsics.m26845a((Object) effectiveVisibility, InternalProtectedBound.f32631a) || (effectiveVisibility instanceof InternalOrPackage))) {
                if (!(effectiveVisibility instanceof InternalProtected)) {
                    if (effectiveVisibility instanceof Protected) {
                        return new InternalProtected(((Protected) effectiveVisibility).f32634a);
                    }
                    if (Intrinsics.m26845a((Object) effectiveVisibility, ProtectedBound.f32635a) != null) {
                        return InternalProtectedBound.f32631a;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
            return effectiveVisibility;
        }
    }

    /* compiled from: EffectiveVisibility.kt */
    public static final class InternalProtected extends EffectiveVisibility {
        final ClassDescriptor f32630a;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] f25477a;
            public static final /* synthetic */ int[] f25478b;

            static {
                int[] iArr = new int[Permissiveness.values().length];
                f25477a = iArr;
                iArr[Permissiveness.f25480b.ordinal()] = 1;
                f25477a[Permissiveness.f25479a.ordinal()] = 2;
                f25477a[Permissiveness.f25482d.ordinal()] = 3;
                f25477a[Permissiveness.f25481c.ordinal()] = 4;
                iArr = new int[Permissiveness.values().length];
                f25478b = iArr;
                iArr[Permissiveness.f25480b.ordinal()] = 1;
                f25478b[Permissiveness.f25481c.ordinal()] = 2;
                f25478b[Permissiveness.f25479a.ordinal()] = 3;
                f25478b[Permissiveness.f25482d.ordinal()] = 4;
            }
        }

        public InternalProtected(ClassDescriptor classDescriptor) {
            super("internal & protected", false, false, 6, null);
            this.f32630a = classDescriptor;
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof InternalProtected) || Intrinsics.m26845a(this.f32630a, ((InternalProtected) obj).f32630a) == null) ? null : true;
        }

        public final int hashCode() {
            ClassDescriptor classDescriptor = this.f32630a;
            return classDescriptor != null ? classDescriptor.hashCode() : 0;
        }

        public final String toString() {
            Name i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append(" (in ");
            ClassDescriptor classDescriptor = this.f32630a;
            if (classDescriptor != null) {
                i = classDescriptor.mo6689i();
                if (i != null) {
                    stringBuilder.append(i);
                    stringBuilder.append(")");
                    return stringBuilder.toString();
                }
            }
            i = Character.valueOf('?');
            stringBuilder.append(i);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public final Permissiveness relation(EffectiveVisibility effectiveVisibility) {
            Intrinsics.m26847b(effectiveVisibility, "other");
            if (!Intrinsics.m26845a((Object) effectiveVisibility, Public.f32636a)) {
                if (!(effectiveVisibility instanceof InternalOrPackage)) {
                    if (!(Intrinsics.m26845a((Object) effectiveVisibility, Private.f32633a) || Intrinsics.m26845a((Object) effectiveVisibility, Local.f32632a))) {
                        if (!Intrinsics.m26845a((Object) effectiveVisibility, InternalProtectedBound.f32631a)) {
                            if (effectiveVisibility instanceof InternalProtected) {
                                return EffectiveVisibilityKt.m27059a(this.f32630a, ((InternalProtected) effectiveVisibility).f32630a);
                            }
                            if (effectiveVisibility instanceof Protected) {
                                switch (WhenMappings.f25477a[EffectiveVisibilityKt.m27059a(this.f32630a, ((Protected) effectiveVisibility).f32634a).ordinal()]) {
                                    case 1:
                                    case 2:
                                        return Permissiveness.f25479a;
                                    case 3:
                                    case 4:
                                        return Permissiveness.f25482d;
                                    default:
                                        throw new NoWhenBranchMatchedException();
                                }
                            } else if (Intrinsics.m26845a((Object) effectiveVisibility, ProtectedBound.f32635a) != null) {
                                return Permissiveness.f25482d;
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                    }
                    return Permissiveness.f25481c;
                }
            }
            return Permissiveness.f25479a;
        }

        public final EffectiveVisibility lowerBound$kotlin_core(EffectiveVisibility effectiveVisibility) {
            Intrinsics.m26847b(effectiveVisibility, "other");
            if (!Intrinsics.m26845a((Object) effectiveVisibility, Public.f32636a)) {
                if (!(effectiveVisibility instanceof InternalOrPackage)) {
                    if (!(Intrinsics.m26845a((Object) effectiveVisibility, Private.f32633a) || Intrinsics.m26845a((Object) effectiveVisibility, Local.f32632a))) {
                        if (!Intrinsics.m26845a((Object) effectiveVisibility, InternalProtectedBound.f32631a)) {
                            if (!(effectiveVisibility instanceof Protected)) {
                                if (!(effectiveVisibility instanceof InternalProtected)) {
                                    if (Intrinsics.m26845a((Object) effectiveVisibility, ProtectedBound.f32635a) != null) {
                                        return InternalProtectedBound.f32631a;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                            switch (WhenMappings.f25478b[relation(effectiveVisibility).ordinal()]) {
                                case 1:
                                case 2:
                                    return this;
                                case 3:
                                    return effectiveVisibility;
                                case 4:
                                    return InternalProtectedBound.f32631a;
                                default:
                                    throw new NoWhenBranchMatchedException();
                            }
                        }
                    }
                    return effectiveVisibility;
                }
            }
            return this;
        }

        public final Visibility toVisibility() {
            return Visibilities.f25504a;
        }
    }

    /* compiled from: EffectiveVisibility.kt */
    public static final class InternalProtectedBound extends EffectiveVisibility {
        public static final InternalProtectedBound f32631a = null;

        static {
            InternalProtectedBound internalProtectedBound = new InternalProtectedBound();
        }

        private InternalProtectedBound() {
            super("internal & protected (in different classes)", false, false, 6, null);
            f32631a = this;
        }

        public final Permissiveness relation(EffectiveVisibility effectiveVisibility) {
            Intrinsics.m26847b(effectiveVisibility, "other");
            if (!(Intrinsics.m26845a((Object) effectiveVisibility, Public.f32636a) || (effectiveVisibility instanceof Protected) || (effectiveVisibility instanceof InternalProtected) || Intrinsics.m26845a((Object) effectiveVisibility, ProtectedBound.f32635a))) {
                if (!(effectiveVisibility instanceof InternalOrPackage)) {
                    if (!Intrinsics.m26845a((Object) effectiveVisibility, Private.f32633a)) {
                        if (!Intrinsics.m26845a((Object) effectiveVisibility, Local.f32632a)) {
                            if (Intrinsics.m26845a((Object) effectiveVisibility, f32631a) != null) {
                                return Permissiveness.f25480b;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    return Permissiveness.f25481c;
                }
            }
            return Permissiveness.f25479a;
        }

        public final Visibility toVisibility() {
            return Visibilities.f25504a;
        }
    }

    /* compiled from: EffectiveVisibility.kt */
    public static final class Local extends EffectiveVisibility {
        public static final Local f32632a = null;

        static {
            Local local = new Local();
        }

        private Local() {
            super("local", false, false, 6, null);
            f32632a = this;
        }

        public final Permissiveness relation(EffectiveVisibility effectiveVisibility) {
            Intrinsics.m26847b(effectiveVisibility, "other");
            if (!Intrinsics.m26845a((Object) this, (Object) effectiveVisibility)) {
                if (Intrinsics.m26845a(Private.f32633a, (Object) effectiveVisibility) == null) {
                    return Permissiveness.f25479a;
                }
            }
            return Permissiveness.f25480b;
        }

        public final Visibility toVisibility() {
            return Visibilities.f25509f;
        }
    }

    /* compiled from: EffectiveVisibility.kt */
    public static final class Private extends EffectiveVisibility {
        public static final Private f32633a = null;

        static {
            Private privateR = new Private();
        }

        private Private() {
            super("private", false, true, 2, null);
            f32633a = this;
        }

        public final Permissiveness relation(EffectiveVisibility effectiveVisibility) {
            Intrinsics.m26847b(effectiveVisibility, "other");
            if (!Intrinsics.m26845a((Object) this, (Object) effectiveVisibility)) {
                if (Intrinsics.m26845a(Local.f32632a, (Object) effectiveVisibility) == null) {
                    return Permissiveness.f25479a;
                }
            }
            return Permissiveness.f25480b;
        }

        public final Visibility toVisibility() {
            return Visibilities.f25504a;
        }
    }

    /* compiled from: EffectiveVisibility.kt */
    public static final class Protected extends EffectiveVisibility {
        final ClassDescriptor f32634a;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] f25484a;
            public static final /* synthetic */ int[] f25485b;
            public static final /* synthetic */ int[] f25486c;

            static {
                int[] iArr = new int[Permissiveness.values().length];
                f25484a = iArr;
                iArr[Permissiveness.f25480b.ordinal()] = 1;
                f25484a[Permissiveness.f25481c.ordinal()] = 2;
                f25484a[Permissiveness.f25482d.ordinal()] = 3;
                f25484a[Permissiveness.f25479a.ordinal()] = 4;
                iArr = new int[Permissiveness.values().length];
                f25485b = iArr;
                iArr[Permissiveness.f25480b.ordinal()] = 1;
                f25485b[Permissiveness.f25481c.ordinal()] = 2;
                f25485b[Permissiveness.f25479a.ordinal()] = 3;
                f25485b[Permissiveness.f25482d.ordinal()] = 4;
                iArr = new int[Permissiveness.values().length];
                f25486c = iArr;
                iArr[Permissiveness.f25479a.ordinal()] = 1;
            }
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof Protected) || Intrinsics.m26845a(this.f32634a, ((Protected) obj).f32634a) == null) ? null : true;
        }

        public final int hashCode() {
            ClassDescriptor classDescriptor = this.f32634a;
            return classDescriptor != null ? classDescriptor.hashCode() : 0;
        }

        public final String toString() {
            Name i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append(" (in ");
            ClassDescriptor classDescriptor = this.f32634a;
            if (classDescriptor != null) {
                i = classDescriptor.mo6689i();
                if (i != null) {
                    stringBuilder.append(i);
                    stringBuilder.append(")");
                    return stringBuilder.toString();
                }
            }
            i = Character.valueOf('?');
            stringBuilder.append(i);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public final Permissiveness relation(EffectiveVisibility effectiveVisibility) {
            Intrinsics.m26847b(effectiveVisibility, "other");
            if (Intrinsics.m26845a((Object) effectiveVisibility, Public.f32636a)) {
                return Permissiveness.f25479a;
            }
            if (!(Intrinsics.m26845a((Object) effectiveVisibility, Private.f32633a) || Intrinsics.m26845a((Object) effectiveVisibility, Local.f32632a) || Intrinsics.m26845a((Object) effectiveVisibility, ProtectedBound.f32635a))) {
                if (!Intrinsics.m26845a((Object) effectiveVisibility, InternalProtectedBound.f32631a)) {
                    if (effectiveVisibility instanceof Protected) {
                        return EffectiveVisibilityKt.m27059a(this.f32634a, ((Protected) effectiveVisibility).f32634a);
                    }
                    if (effectiveVisibility instanceof InternalProtected) {
                        switch (WhenMappings.f25484a[EffectiveVisibilityKt.m27059a(this.f32634a, ((InternalProtected) effectiveVisibility).f32630a).ordinal()]) {
                            case 1:
                            case 2:
                                return Permissiveness.f25481c;
                            case 3:
                            case 4:
                                return Permissiveness.f25482d;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                    } else if ((effectiveVisibility instanceof InternalOrPackage) != null) {
                        return Permissiveness.f25482d;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            return Permissiveness.f25481c;
        }

        public final EffectiveVisibility lowerBound$kotlin_core(EffectiveVisibility effectiveVisibility) {
            Intrinsics.m26847b(effectiveVisibility, "other");
            if (Intrinsics.m26845a((Object) effectiveVisibility, Public.f32636a)) {
                return this;
            }
            if (!(Intrinsics.m26845a((Object) effectiveVisibility, Private.f32633a) || Intrinsics.m26845a((Object) effectiveVisibility, Local.f32632a) || Intrinsics.m26845a((Object) effectiveVisibility, ProtectedBound.f32635a))) {
                if (!Intrinsics.m26845a((Object) effectiveVisibility, InternalProtectedBound.f32631a)) {
                    if (effectiveVisibility instanceof Protected) {
                        switch (WhenMappings.f25485b[relation(effectiveVisibility).ordinal()]) {
                            case 1:
                            case 2:
                                return this;
                            case 3:
                                return effectiveVisibility;
                            case 4:
                                return ProtectedBound.f32635a;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                    } else if (effectiveVisibility instanceof InternalProtected) {
                        return WhenMappings.f25486c[relation(effectiveVisibility).ordinal()] != 1 ? InternalProtectedBound.f32631a : effectiveVisibility;
                    } else if ((effectiveVisibility instanceof InternalOrPackage) != null) {
                        return new InternalProtected(this.f32634a);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            return effectiveVisibility;
        }

        public final Visibility toVisibility() {
            return Visibilities.f25506c;
        }
    }

    /* compiled from: EffectiveVisibility.kt */
    public static final class ProtectedBound extends EffectiveVisibility {
        public static final ProtectedBound f32635a = null;

        static {
            ProtectedBound protectedBound = new ProtectedBound();
        }

        private ProtectedBound() {
            super("protected (in different classes)", true, false, 4, null);
            f32635a = this;
        }

        public final Permissiveness relation(EffectiveVisibility effectiveVisibility) {
            Intrinsics.m26847b(effectiveVisibility, "other");
            if (!Intrinsics.m26845a((Object) effectiveVisibility, Public.f32636a)) {
                if (!(effectiveVisibility instanceof Protected)) {
                    if (!(Intrinsics.m26845a((Object) effectiveVisibility, Private.f32633a) || Intrinsics.m26845a((Object) effectiveVisibility, Local.f32632a))) {
                        if (!Intrinsics.m26845a((Object) effectiveVisibility, InternalProtectedBound.f32631a)) {
                            if (Intrinsics.m26845a((Object) effectiveVisibility, f32635a)) {
                                return Permissiveness.f25480b;
                            }
                            if (!(effectiveVisibility instanceof InternalOrPackage)) {
                                if ((effectiveVisibility instanceof InternalProtected) == null) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                            return Permissiveness.f25482d;
                        }
                    }
                    return Permissiveness.f25481c;
                }
            }
            return Permissiveness.f25479a;
        }

        public final EffectiveVisibility lowerBound$kotlin_core(EffectiveVisibility effectiveVisibility) {
            Intrinsics.m26847b(effectiveVisibility, "other");
            if (!Intrinsics.m26845a((Object) effectiveVisibility, Public.f32636a)) {
                if (!(effectiveVisibility instanceof Protected)) {
                    if (!(Intrinsics.m26845a((Object) effectiveVisibility, Private.f32633a) || Intrinsics.m26845a((Object) effectiveVisibility, Local.f32632a) || Intrinsics.m26845a((Object) effectiveVisibility, f32635a))) {
                        if (!Intrinsics.m26845a((Object) effectiveVisibility, InternalProtectedBound.f32631a)) {
                            if (!(effectiveVisibility instanceof InternalOrPackage)) {
                                if ((effectiveVisibility instanceof InternalProtected) == null) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                            return InternalProtectedBound.f32631a;
                        }
                    }
                    return effectiveVisibility;
                }
            }
            return this;
        }

        public final Visibility toVisibility() {
            return Visibilities.f25506c;
        }
    }

    /* compiled from: EffectiveVisibility.kt */
    public static final class Public extends EffectiveVisibility {
        public static final Public f32636a = null;

        static {
            Public publicR = new Public();
        }

        private Public() {
            super("public", true, false, 4, null);
            f32636a = this;
        }

        public final Permissiveness relation(EffectiveVisibility effectiveVisibility) {
            Intrinsics.m26847b(effectiveVisibility, "other");
            return Intrinsics.m26845a((Public) this, (Object) effectiveVisibility) != null ? Permissiveness.f25480b : Permissiveness.f25481c;
        }

        public final Visibility toVisibility() {
            return Visibilities.f25508e;
        }
    }

    /* compiled from: EffectiveVisibility.kt */
    public static final class Internal extends InternalOrPackage {
        public static final Internal INSTANCE = null;

        static {
            Internal internal = new Internal();
        }

        private Internal() {
            super(true);
            INSTANCE = this;
        }

        public final Visibility toVisibility() {
            return Visibilities.f25507d;
        }
    }

    public abstract Permissiveness relation(EffectiveVisibility effectiveVisibility);

    public abstract Visibility toVisibility();

    private EffectiveVisibility(String str, boolean z, boolean z2) {
        this.name = str;
        this.publicApi = z;
        this.privateApi = z2;
    }

    /* synthetic */ EffectiveVisibility(String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != null) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        this(str, z, z2);
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getPrivateApi() {
        return this.privateApi;
    }

    public final boolean getPublicApi() {
        return this.publicApi;
    }

    public String toString() {
        return this.name;
    }

    public EffectiveVisibility lowerBound$kotlin_core(EffectiveVisibility effectiveVisibility) {
        Intrinsics.m26847b(effectiveVisibility, "other");
        switch (WhenMappings.f25487a[relation(effectiveVisibility).ordinal()]) {
            case 1:
            case 2:
                return this;
            case 3:
                return effectiveVisibility;
            case 4:
                return Private.f32633a;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
