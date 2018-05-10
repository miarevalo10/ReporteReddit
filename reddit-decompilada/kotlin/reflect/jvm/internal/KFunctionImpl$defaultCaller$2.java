package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.AnnotationConstructorCaller.CallMode;
import kotlin.reflect.jvm.internal.AnnotationConstructorCaller.Origin;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Member;", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KFunctionImpl.kt */
final class KFunctionImpl$defaultCaller$2 extends Lambda implements Function0<FunctionCaller<? extends Member>> {
    final /* synthetic */ KFunctionImpl f38249a;

    KFunctionImpl$defaultCaller$2(KFunctionImpl kFunctionImpl) {
        this.f38249a = kFunctionImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Member a;
        RuntimeTypeMapper runtimeTypeMapper = RuntimeTypeMapper.f25343a;
        JvmFunctionSignature a2 = RuntimeTypeMapper.m26928a(this.f38249a.m38251d());
        KDeclarationContainerImpl kDeclarationContainerImpl;
        String b;
        String c;
        if (a2 instanceof KotlinFunction) {
            kDeclarationContainerImpl = this.f38249a.f38253a;
            KotlinFunction kotlinFunction = (KotlinFunction) a2;
            b = kotlinFunction.m32878b();
            c = kotlinFunction.m32879c();
            Member member = this.f38249a.mo6677c().f25323a;
            if (member == null) {
                Intrinsics.m26842a();
            }
            a = kDeclarationContainerImpl.m36168a(b, c, true ^ Modifier.isStatic(member.getModifiers()), KFunctionImpl.m38241b(this.f38249a));
        } else if (a2 instanceof KotlinConstructor) {
            if (this.f38249a.m32889h()) {
                Class a3 = this.f38249a.f38253a.mo6657a();
                Iterable<KParameter> g = this.f38249a.m32888g();
                r3 = new ArrayList(CollectionsKt__IterablesKt.m32812b(g));
                for (KParameter a4 : g) {
                    b = a4.mo5692a();
                    if (b == null) {
                        Intrinsics.m26842a();
                    }
                    r3.add(b);
                }
                return new AnnotationConstructorCaller(a3, (List) r3, CallMode.f25309a, Origin.f25313b);
            }
            kDeclarationContainerImpl = this.f38249a.f38253a;
            c = ((KotlinConstructor) a2).m32876b();
            boolean b2 = KFunctionImpl.m38241b(this.f38249a);
            Intrinsics.m26847b(c, "desc");
            List arrayList = new ArrayList();
            kDeclarationContainerImpl.m36171a(arrayList, c, true);
            a = KDeclarationContainerImpl.m36160a(kDeclarationContainerImpl.mo6657a(), arrayList, b2);
        } else if (a2 instanceof FakeJavaAnnotationConstructor) {
            List list = ((FakeJavaAnnotationConstructor) a2).f32553a;
            Class a5 = this.f38249a.f38253a.mo6657a();
            Iterable<Method> iterable = list;
            r3 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (Method name : iterable) {
                r3.add(name.getName());
            }
            return new AnnotationConstructorCaller(a5, (List) r3, CallMode.f25309a, Origin.f25312a, list);
        } else {
            a = null;
        }
        if (a instanceof Constructor) {
            return KFunctionImpl.m38239a(this.f38249a, (Constructor) a);
        }
        if (!(a instanceof Method)) {
            return null;
        }
        FunctionCaller.Method b3;
        if (this.f38249a.m38251d().mo5718q().mo6679a(UtilKt.m26935a()) != null) {
            DeclarationDescriptor aD_ = this.f38249a.m38251d().aD_();
            if (aD_ == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            } else if (!((ClassDescriptor) aD_).mo7772k()) {
                b3 = KFunctionImpl.m38240b(this.f38249a, (Method) a);
                return b3;
            }
        }
        b3 = KFunctionImpl.m38242c(this.f38249a, (Method) a);
        return b3;
    }
}
