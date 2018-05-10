package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.AnnotationConstructorCaller.CallMode;
import kotlin.reflect.jvm.internal.AnnotationConstructorCaller.Origin;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.BuiltInFunction;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaMethod;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Member;", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KFunctionImpl.kt */
final class KFunctionImpl$caller$2 extends Lambda implements Function0<FunctionCaller<? extends Member>> {
    final /* synthetic */ KFunctionImpl f38248a;

    KFunctionImpl$caller$2(KFunctionImpl kFunctionImpl) {
        this.f38248a = kFunctionImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object a;
        RuntimeTypeMapper runtimeTypeMapper = RuntimeTypeMapper.f25343a;
        JvmFunctionSignature a2 = RuntimeTypeMapper.m26928a(this.f38248a.m38251d());
        Collection arrayList;
        if (a2 instanceof KotlinConstructor) {
            if (this.f38248a.m32889h()) {
                Class a3 = this.f38248a.f38253a.mo6657a();
                Iterable<KParameter> g = this.f38248a.m32888g();
                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(g));
                for (KParameter a4 : g) {
                    String a5 = a4.mo5692a();
                    if (a5 == null) {
                        Intrinsics.m26842a();
                    }
                    arrayList.add(a5);
                }
                return new AnnotationConstructorCaller(a3, (List) arrayList, CallMode.f25310b, Origin.f25313b);
            }
            a = this.f38248a.f38253a.m36166a(((KotlinConstructor) a2).m32876b(), KFunctionImpl.m38241b(this.f38248a));
        } else if (a2 instanceof KotlinFunction) {
            KotlinFunction kotlinFunction = (KotlinFunction) a2;
            a = this.f38248a.f38253a.m36167a(kotlinFunction.m32878b(), kotlinFunction.m32879c(), KFunctionImpl.m38241b(this.f38248a));
        } else if (a2 instanceof JavaMethod) {
            a = ((JavaMethod) a2).f32556a;
        } else if (a2 instanceof JavaConstructor) {
            a = ((JavaConstructor) a2).f32555a;
        } else if (a2 instanceof FakeJavaAnnotationConstructor) {
            List list = ((FakeJavaAnnotationConstructor) a2).f32553a;
            Class a6 = this.f38248a.f38253a.mo6657a();
            Iterable<Method> iterable = list;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (Method name : iterable) {
                arrayList.add(name.getName());
            }
            return new AnnotationConstructorCaller(a6, (List) arrayList, CallMode.f25310b, Origin.f25312a, list);
        } else if (a2 instanceof BuiltInFunction) {
            a = ((BuiltInFunction) a2).mo6673a(this.f38248a.f38253a);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (a instanceof Constructor) {
            return KFunctionImpl.m38239a(this.f38248a, (Constructor) a);
        }
        if (a instanceof Method) {
            FunctionCaller.Method a7;
            Method method = (Method) a;
            if (!Modifier.isStatic(method.getModifiers())) {
                a7 = KFunctionImpl.m38238a(this.f38248a, method);
            } else if (this.f38248a.m38251d().mo5718q().mo6679a(UtilKt.m26935a()) != null) {
                a7 = KFunctionImpl.m38240b(this.f38248a, method);
            } else {
                a7 = KFunctionImpl.m38242c(this.f38248a, method);
            }
            return a7;
        }
        StringBuilder stringBuilder = new StringBuilder("Call is not yet supported for this function: ");
        stringBuilder.append(this.f38248a.m38251d());
        stringBuilder.append(" (member = ");
        stringBuilder.append(a);
        stringBuilder.append(")");
        throw new KotlinReflectionInternalError(stringBuilder.toString());
    }
}
