package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure.EnrichedProjectionKind;

/* compiled from: VarianceChecker.kt */
public final class VarianceCheckerKt {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f26345a;

        static {
            int[] iArr = new int[EnrichedProjectionKind.values().length];
            f26345a = iArr;
            iArr[EnrichedProjectionKind.OUT.ordinal()] = 1;
            f26345a[EnrichedProjectionKind.f26361a.ordinal()] = 2;
            f26345a[EnrichedProjectionKind.INV.ordinal()] = 3;
            f26345a[EnrichedProjectionKind.STAR.ordinal()] = 4;
        }
    }

    public static final <D extends TypeHolder<? extends D>> boolean m28022a(D d, Variance variance, Function3<? super TypeParameterDescriptor, ? super D, ? super Variance, Unit> function3, Function1<? super TypeParameterDescriptor, ? extends Variance> function1) {
        Intrinsics.m26847b(d, "$receiver");
        Intrinsics.m26847b(variance, "position");
        Intrinsics.m26847b(function3, "reportError");
        Intrinsics.m26847b(function1, "customVariance");
        Pair a = d.mo5845a();
        if (a != null) {
            a = a;
            return m28022a((TypeHolder) a.f25267a, variance, function3, function1) & m28022a((TypeHolder) a.f25268b, variance, function3, function1);
        }
        ClassifierDescriptor c = d.mo5847c().mo6743g().mo5724c();
        if (c instanceof TypeParameterDescriptor) {
            function1 = (Variance) function1.mo6492a(c);
            if (function1 == null) {
                function1 = ((TypeParameterDescriptor) c).mo7716k();
                Intrinsics.m26843a((Object) function1, "classifierDescriptor.variance");
            }
            if (!function1.m28021a(variance)) {
                Annotations q = d.mo5847c().mo5718q();
                Object obj = KotlinBuiltIns.f25420j.f25362I;
                Intrinsics.m26843a(obj, "org.jetbrains.kotlin.bui…s.FQ_NAMES.unsafeVariance");
                if (!q.mo6682b(obj)) {
                    function3.mo6509a(c, d, variance);
                }
            }
            return function1.m28021a(variance);
        }
        boolean z = true;
        for (TypeHolderArgument typeHolderArgument : d.mo5846b()) {
            if (!(typeHolderArgument == null || typeHolderArgument.mo5843b() == null)) {
                if (!typeHolderArgument.mo5842a().mo6734a()) {
                    Variance variance2;
                    TypeParameterDescriptor b = typeHolderArgument.mo5843b();
                    if (b == null) {
                        Intrinsics.m26842a();
                    }
                    EnrichedProjectionKind a2 = TypeCheckingProcedure.m28045a(b, typeHolderArgument.mo5842a());
                    if (a2 == null) {
                        Intrinsics.m26842a();
                    }
                    switch (WhenMappings.f26345a[a2.ordinal()]) {
                        case 1:
                            variance2 = variance;
                            break;
                        case 2:
                            switch (kotlin.reflect.jvm.internal.impl.types.Variance.WhenMappings.f26336b[variance.ordinal()]) {
                                case 1:
                                    variance2 = Variance.f26337a;
                                    break;
                                case 2:
                                    variance2 = Variance.f26339c;
                                    break;
                                case 3:
                                    variance2 = Variance.f26338b;
                                    break;
                                default:
                                    throw new NoWhenBranchMatchedException();
                            }
                        case 3:
                            variance2 = Variance.f26337a;
                            break;
                        case 4:
                            variance2 = null;
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    if (variance2 != null) {
                        z &= m28022a(typeHolderArgument.mo5844c(), variance2, function3, function1);
                    }
                }
            }
        }
        return z;
    }
}
