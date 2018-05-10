package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b \u0018\u0000 ;2\u00020\u0001:\u0003;<=B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u001c\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J(\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011J \u0010#\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010$\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020!0\u00042\u0006\u0010\u001e\u001a\u00020&H&J\"\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0\u00042\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0004J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u001e\u001a\u00020&H&J\u001a\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0/2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u00100\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00101\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002J<\u00105\u001a\u0014\u0012\u000e\b\u0001\u0012\n 7*\u0004\u0018\u00010606\u0018\u00010\u0019*\u0006\u0012\u0002\b\u00030\t2\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0/2\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J@\u00109\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001e\u001a\u00020\u00112\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0/2\n\u0010:\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001a\u001a\u00020\u0013H\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006>"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "createProperty", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "declared", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "getFunctions", "Lorg/jetbrains/kotlin/name/Name;", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "", "end", "tryGetConstructor", "", "kotlin.jvm.PlatformType", "parameterTypes", "tryGetMethod", "returnType", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: KDeclarationContainerImpl.kt */
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    private static final Class<?> f36032a = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
    public static final Companion f36033c = new Companion();

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "getDEFAULT_CONSTRUCTOR_MARKER", "()Ljava/lang/Class;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: KDeclarationContainerImpl.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lorg/jetbrains/kotlin/load/kotlin/reflect/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/load/kotlin/reflect/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: KDeclarationContainerImpl.kt */
    public abstract class Data {
        static final /* synthetic */ KProperty[] f25329i = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/load/kotlin/reflect/RuntimeModuleData;"))};
        private final LazySoftVal f25330a = ReflectProperties.m26919b((Function0) new KDeclarationContainerImpl$Data$moduleData$2(this));
        final /* synthetic */ KDeclarationContainerImpl f25331j;

        public Data(KDeclarationContainerImpl kDeclarationContainerImpl) {
            this.f25331j = kDeclarationContainerImpl;
        }

        public final RuntimeModuleData m26910d() {
            return (RuntimeModuleData) this.f25330a.mo5694a();
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: KDeclarationContainerImpl.kt */
    protected enum MemberBelonginess {
    }

    public abstract Collection<PropertyDescriptor> mo7069a(Name name);

    public abstract Collection<ConstructorDescriptor> mo7070b();

    public abstract Collection<FunctionDescriptor> mo7071b(Name name);

    protected Class<?> mo7072f() {
        return mo6657a();
    }

    protected final Collection<KCallableImpl<?>> m36170a(MemberScope memberScope, MemberBelonginess memberBelonginess) {
        Intrinsics.m26847b(memberScope, "scope");
        Intrinsics.m26847b(memberBelonginess, "belonginess");
        KDeclarationContainerImpl$getMembers$visitor$1 kDeclarationContainerImpl$getMembers$visitor$1 = new KDeclarationContainerImpl$getMembers$visitor$1(this);
        Collection arrayList = new ArrayList();
        for (DeclarationDescriptor declarationDescriptor : DefaultImpls.m27789a(memberScope, null, null, 3)) {
            Object obj;
            if (declarationDescriptor instanceof CallableMemberDescriptor) {
                CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) declarationDescriptor;
                int i = 1;
                if ((Intrinsics.m26845a(callableMemberDescriptor.mo7257j(), Visibilities.f25511h) ^ 1) != 0) {
                    Intrinsics.m26847b(callableMemberDescriptor, "member");
                    if (callableMemberDescriptor.mo7760t().m27041a() != Intrinsics.m26845a((Object) memberBelonginess, MemberBelonginess.f25332a)) {
                        i = 0;
                    }
                    if (i != 0) {
                        obj = (KCallableImpl) declarationDescriptor.mo7078a(kDeclarationContainerImpl$getMembers$visitor$1, Unit.f25273a);
                        if (obj != null) {
                            arrayList.add(obj);
                        }
                    }
                }
            }
            obj = null;
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.m28089a((Collection) (List) arrayList);
    }

    private static java.lang.reflect.Method m36161a(java.lang.Class<?> r5, java.lang.String r6, java.util.List<? extends java.lang.Class<?>> r7, java.lang.Class<?> r8, boolean r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r7 = (java.util.Collection) r7;	 Catch:{ NoSuchMethodException -> 0x0093 }
        if (r7 != 0) goto L_0x000d;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x0005:
        r5 = new kotlin.TypeCastException;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r6 = "null cannot be cast to non-null type java.util.Collection<T>";	 Catch:{ NoSuchMethodException -> 0x0093 }
        r5.<init>(r6);	 Catch:{ NoSuchMethodException -> 0x0093 }
        throw r5;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x000d:
        r7 = (java.util.Collection) r7;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r1 = r7.size();	 Catch:{ NoSuchMethodException -> 0x0093 }
        r1 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0093 }
        r7 = r7.toArray(r1);	 Catch:{ NoSuchMethodException -> 0x0093 }
        if (r7 != 0) goto L_0x0023;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x001b:
        r5 = new kotlin.TypeCastException;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r6 = "null cannot be cast to non-null type kotlin.Array<T>";	 Catch:{ NoSuchMethodException -> 0x0093 }
        r5.<init>(r6);	 Catch:{ NoSuchMethodException -> 0x0093 }
        throw r5;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x0023:
        r7 = (java.lang.Object[]) r7;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r7 = (java.lang.Class[]) r7;	 Catch:{ NoSuchMethodException -> 0x0093 }
        if (r9 == 0) goto L_0x0035;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x0029:
        r1 = r7.length;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r1 = java.util.Arrays.copyOf(r7, r1);	 Catch:{ NoSuchMethodException -> 0x0093 }
        r1 = (java.lang.Class[]) r1;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r1 = r5.getDeclaredMethod(r6, r1);	 Catch:{ NoSuchMethodException -> 0x0093 }
        goto L_0x0040;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x0035:
        r1 = r7.length;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r1 = java.util.Arrays.copyOf(r7, r1);	 Catch:{ NoSuchMethodException -> 0x0093 }
        r1 = (java.lang.Class[]) r1;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r1 = r5.getMethod(r6, r1);	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x0040:
        r2 = r1.getReturnType();	 Catch:{ NoSuchMethodException -> 0x0093 }
        r2 = kotlin.jvm.internal.Intrinsics.m26845a(r2, r8);	 Catch:{ NoSuchMethodException -> 0x0093 }
        if (r2 == 0) goto L_0x004c;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x004a:
        r0 = r1;	 Catch:{ NoSuchMethodException -> 0x0093 }
        goto L_0x0093;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x004c:
        if (r9 == 0) goto L_0x0053;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x004e:
        r5 = r5.getDeclaredMethods();	 Catch:{ NoSuchMethodException -> 0x0093 }
        goto L_0x0057;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x0053:
        r5 = r5.getMethods();	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x0057:
        r5 = (java.lang.Object[]) r5;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r9 = 0;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r1 = r9;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x005b:
        r2 = r5.length;	 Catch:{ NoSuchMethodException -> 0x0093 }
        if (r1 >= r2) goto L_0x008f;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x005e:
        r2 = r5[r1];	 Catch:{ NoSuchMethodException -> 0x0093 }
        r3 = r2;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r3 = (java.lang.reflect.Method) r3;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r4 = r3.getName();	 Catch:{ NoSuchMethodException -> 0x0093 }
        r4 = kotlin.jvm.internal.Intrinsics.m26845a(r4, r6);	 Catch:{ NoSuchMethodException -> 0x0093 }
        if (r4 == 0) goto L_0x0088;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x006d:
        r4 = r3.getReturnType();	 Catch:{ NoSuchMethodException -> 0x0093 }
        r4 = kotlin.jvm.internal.Intrinsics.m26845a(r4, r8);	 Catch:{ NoSuchMethodException -> 0x0093 }
        if (r4 == 0) goto L_0x0088;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x0077:
        r3 = r3.getParameterTypes();	 Catch:{ NoSuchMethodException -> 0x0093 }
        r3 = (java.lang.Object[]) r3;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r4 = r7;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r4 = (java.lang.Object[]) r4;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r3 = java.util.Arrays.equals(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0093 }
        if (r3 == 0) goto L_0x0088;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x0086:
        r3 = 1;	 Catch:{ NoSuchMethodException -> 0x0093 }
        goto L_0x0089;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x0088:
        r3 = r9;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x0089:
        if (r3 == 0) goto L_0x008c;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x008b:
        goto L_0x0090;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x008c:
        r1 = r1 + 1;	 Catch:{ NoSuchMethodException -> 0x0093 }
        goto L_0x005b;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x008f:
        r2 = r0;	 Catch:{ NoSuchMethodException -> 0x0093 }
    L_0x0090:
        r2 = (java.lang.reflect.Method) r2;	 Catch:{ NoSuchMethodException -> 0x0093 }
        r0 = r2;
    L_0x0093:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.a(java.lang.Class, java.lang.String, java.util.List, java.lang.Class, boolean):java.lang.reflect.Method");
    }

    static java.lang.reflect.Constructor<? extends java.lang.Object> m36160a(java.lang.Class<?> r0, java.util.List<? extends java.lang.Class<?>> r1, boolean r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r2 == 0) goto L_0x0034;
    L_0x0002:
        r1 = (java.util.Collection) r1;	 Catch:{ NoSuchMethodException -> 0x0066 }
        if (r1 != 0) goto L_0x000e;	 Catch:{ NoSuchMethodException -> 0x0066 }
    L_0x0006:
        r0 = new kotlin.TypeCastException;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r1 = "null cannot be cast to non-null type java.util.Collection<T>";	 Catch:{ NoSuchMethodException -> 0x0066 }
        r0.<init>(r1);	 Catch:{ NoSuchMethodException -> 0x0066 }
        throw r0;	 Catch:{ NoSuchMethodException -> 0x0066 }
    L_0x000e:
        r1 = (java.util.Collection) r1;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r2 = r1.size();	 Catch:{ NoSuchMethodException -> 0x0066 }
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0066 }
        r1 = r1.toArray(r2);	 Catch:{ NoSuchMethodException -> 0x0066 }
        if (r1 != 0) goto L_0x0024;	 Catch:{ NoSuchMethodException -> 0x0066 }
    L_0x001c:
        r0 = new kotlin.TypeCastException;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r1 = "null cannot be cast to non-null type kotlin.Array<T>";	 Catch:{ NoSuchMethodException -> 0x0066 }
        r0.<init>(r1);	 Catch:{ NoSuchMethodException -> 0x0066 }
        throw r0;	 Catch:{ NoSuchMethodException -> 0x0066 }
    L_0x0024:
        r1 = (java.lang.Object[]) r1;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r1 = (java.lang.Class[]) r1;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r2 = r1.length;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r1 = java.util.Arrays.copyOf(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0066 }
        r1 = (java.lang.Class[]) r1;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r0 = r0.getDeclaredConstructor(r1);	 Catch:{ NoSuchMethodException -> 0x0066 }
        goto L_0x0067;	 Catch:{ NoSuchMethodException -> 0x0066 }
    L_0x0034:
        r1 = (java.util.Collection) r1;	 Catch:{ NoSuchMethodException -> 0x0066 }
        if (r1 != 0) goto L_0x0040;	 Catch:{ NoSuchMethodException -> 0x0066 }
    L_0x0038:
        r0 = new kotlin.TypeCastException;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r1 = "null cannot be cast to non-null type java.util.Collection<T>";	 Catch:{ NoSuchMethodException -> 0x0066 }
        r0.<init>(r1);	 Catch:{ NoSuchMethodException -> 0x0066 }
        throw r0;	 Catch:{ NoSuchMethodException -> 0x0066 }
    L_0x0040:
        r1 = (java.util.Collection) r1;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r2 = r1.size();	 Catch:{ NoSuchMethodException -> 0x0066 }
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0066 }
        r1 = r1.toArray(r2);	 Catch:{ NoSuchMethodException -> 0x0066 }
        if (r1 != 0) goto L_0x0056;	 Catch:{ NoSuchMethodException -> 0x0066 }
    L_0x004e:
        r0 = new kotlin.TypeCastException;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r1 = "null cannot be cast to non-null type kotlin.Array<T>";	 Catch:{ NoSuchMethodException -> 0x0066 }
        r0.<init>(r1);	 Catch:{ NoSuchMethodException -> 0x0066 }
        throw r0;	 Catch:{ NoSuchMethodException -> 0x0066 }
    L_0x0056:
        r1 = (java.lang.Object[]) r1;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r1 = (java.lang.Class[]) r1;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r2 = r1.length;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r1 = java.util.Arrays.copyOf(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0066 }
        r1 = (java.lang.Class[]) r1;	 Catch:{ NoSuchMethodException -> 0x0066 }
        r0 = r0.getConstructor(r1);	 Catch:{ NoSuchMethodException -> 0x0066 }
        goto L_0x0067;
    L_0x0066:
        r0 = 0;
    L_0x0067:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.a(java.lang.Class, java.util.List, boolean):java.lang.reflect.Constructor<? extends java.lang.Object>");
    }

    public final Method m36167a(String str, String str2, boolean z) {
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(str2, "desc");
        if (Intrinsics.m26845a((Object) str, (Object) "<init>")) {
            return null;
        }
        return m36161a(mo7072f(), str, m36162a(str2), m36164b(str2), z);
    }

    public final Method m36168a(String str, String str2, boolean z, boolean z2) {
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(str2, "desc");
        if (Intrinsics.m26845a((Object) str, (Object) "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(mo6657a());
        }
        List list = arrayList;
        m36171a(list, str2, false);
        z = mo7072f();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("$default");
        return m36161a(z, stringBuilder.toString(), list, m36164b(str2), z2);
    }

    public final Constructor<?> m36166a(String str, boolean z) {
        Intrinsics.m26847b(str, "desc");
        return m36160a(mo6657a(), m36162a(str), z);
    }

    final void m36171a(List<Class<?>> list, String str, boolean z) {
        str = m36162a(str);
        list.addAll((Collection) str);
        str = (((str.size() + 32) - 1) / 32) - 1;
        if (str >= null) {
            int i = 0;
            while (true) {
                Object obj = Integer.TYPE;
                Intrinsics.m26843a(obj, "Integer.TYPE");
                list.add(obj);
                if (i == str) {
                    break;
                }
                i++;
            }
        }
        Object a = z ? f36032a : Object.class;
        Intrinsics.m26843a(a, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(a);
    }

    private final List<Class<?>> m36162a(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (str.charAt(i) != ')') {
            int i2 = i;
            while (str.charAt(i2) == '[') {
                i2++;
            }
            char charAt = str.charAt(i2);
            if (StringsKt__StringsKt.m42460b((CharSequence) "VZCBSIFJD", charAt)) {
                i2++;
            } else if (charAt == 'L') {
                i2 = StringsKt__StringsKt.m42439a((CharSequence) str, ';', i, 4) + 1;
            } else {
                StringBuilder stringBuilder = new StringBuilder("Unknown type prefix in the method signature: ");
                stringBuilder.append(str);
                throw new KotlinReflectionInternalError(stringBuilder.toString());
            }
            arrayList.add(m36159a(str, i, i2));
            i = i2;
        }
        return arrayList;
    }

    private final Class<?> m36159a(String str, int i, int i2) {
        Object substring;
        switch (str.charAt(i)) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            case 'F':
                return Float.TYPE;
            case 'I':
                return Integer.TYPE;
            case 'J':
                return Long.TYPE;
            case 'L':
                ClassLoader a = ReflectClassUtilKt.m27239a(mo6657a());
                i++;
                i2--;
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                substring = str.substring(i, i2);
                Intrinsics.m26843a(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                substring = a.loadClass(StringsKt__StringsJVMKt.m41941a((String) substring, (char) 47, (char) 46));
                Intrinsics.m26843a(substring, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
                return substring;
            case 'S':
                return Short.TYPE;
            case 'V':
                substring = Void.TYPE;
                Intrinsics.m26843a(substring, "Void.TYPE");
                return substring;
            case 'Z':
                return Boolean.TYPE;
            case '[':
                return ReflectClassUtilKt.m27246g(m36159a(str, i + 1, i2));
            default:
                i2 = new StringBuilder("Unknown type prefix in the method signature: ");
                i2.append(str);
                throw ((Throwable) new KotlinReflectionInternalError(i2.toString()));
        }
    }

    private final Class<?> m36164b(String str) {
        return m36159a(str, StringsKt__StringsKt.m42439a((CharSequence) str, ')', 0, 6) + 1, str.length());
    }

    public static final /* synthetic */ KPropertyImpl m36163a(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        int i = 0;
        int i2 = propertyDescriptor.mo7756e() != null ? 1 : 0;
        if (propertyDescriptor.mo7755d() != null) {
            i = 1;
        }
        i2 += i;
        if (propertyDescriptor.mo7807y()) {
            switch (i2) {
                case 0:
                    return new KMutableProperty0Impl(kDeclarationContainerImpl, propertyDescriptor);
                case 1:
                    return new KMutableProperty1Impl(kDeclarationContainerImpl, propertyDescriptor);
                default:
                    return new KMutableProperty2Impl(kDeclarationContainerImpl, propertyDescriptor);
            }
        }
        switch (i2) {
            case 0:
                return new KProperty0Impl(kDeclarationContainerImpl, propertyDescriptor);
            case 1:
                return new KProperty1Impl(kDeclarationContainerImpl, propertyDescriptor);
            default:
                return new KProperty2Impl(kDeclarationContainerImpl, propertyDescriptor);
        }
    }
}
