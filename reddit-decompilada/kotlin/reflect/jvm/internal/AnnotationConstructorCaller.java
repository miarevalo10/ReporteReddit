package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u0016\u0017B?\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0016¢\u0006\u0002\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: AnnotationConstructorCaller.kt */
public final class AnnotationConstructorCaller extends FunctionCaller {
    private final List<Class<?>> f32543e;
    private final List<Object> f32544f;
    private final Class<?> f32545g;
    private final List<String> f32546h;
    private final CallMode f32547i;
    private final List<Method> f32548j;

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$CallMode;", "", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: AnnotationConstructorCaller.kt */
    public enum CallMode {
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$Origin;", "", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: AnnotationConstructorCaller.kt */
    public enum Origin {
    }

    public AnnotationConstructorCaller(Class<?> cls, List<String> list, CallMode callMode, Origin origin, List<Method> list2) {
        Intrinsics.m26847b(cls, "jClass");
        Intrinsics.m26847b(list, "parameterNames");
        Intrinsics.m26847b(callMode, "callMode");
        Intrinsics.m26847b(origin, "origin");
        Intrinsics.m26847b(list2, "methods");
        Type type = cls;
        Iterable<Method> iterable = list2;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Method genericReturnType : iterable) {
            arrayList.add(genericReturnType.getGenericReturnType());
        }
        arrayList = (List) arrayList;
        Object[] toArray = arrayList.toArray(new Type[arrayList.size()]);
        if (toArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        super(null, type, null, (Type[]) toArray);
        this.f32545g = cls;
        this.f32546h = list;
        this.f32547i = callMode;
        this.f32548j = list2;
        Iterable<Method> iterable2 = (Iterable) this.f32548j;
        Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable2));
        for (Method returnType : iterable2) {
            callMode = returnType.getReturnType();
            list2 = ReflectClassUtilKt.m27243d(callMode);
            if (list2 != null) {
                callMode = list2;
            }
            arrayList2.add((Class) callMode);
        }
        this.f32543e = (List) arrayList2;
        iterable2 = (Iterable) this.f32548j;
        arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable2));
        for (Method returnType2 : iterable2) {
            arrayList2.add(returnType2.getDefaultValue());
        }
        this.f32544f = (List) arrayList2;
        if (Intrinsics.m26845a(this.f32547i, CallMode.f25310b) != null && Intrinsics.m26845a((Object) origin, Origin.f25312a) != null && (CollectionsKt___CollectionsKt.m41422b((Iterable) this.f32546h, (Object) "value").isEmpty() ^ 1) != null) {
            throw ((Throwable) new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead."));
        }
    }

    public /* synthetic */ AnnotationConstructorCaller(Class cls, List list, CallMode callMode, Origin origin) {
        Iterable<String> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (String declaredMethod : iterable) {
            arrayList.add(cls.getDeclaredMethod(declaredMethod, new Class[0]));
        }
        this(cls, list, callMode, origin, (List) arrayList);
    }

    public final Object mo5688a(Object[] objArr) {
        Intrinsics.m26847b(objArr, "args");
        mo5689b(objArr);
        int i = 0;
        Collection arrayList = new ArrayList(objArr.length);
        int i2 = 0;
        while (i < objArr.length) {
            Object obj = objArr[i];
            int i3 = i2 + 1;
            if (obj == null && Intrinsics.m26845a(this.f32547i, CallMode.f25309a)) {
                obj = this.f32544f.get(i2);
            } else {
                obj = AnnotationConstructorCallerKt.m26892a(obj, (Class) this.f32543e.get(i2));
            }
            if (obj == null) {
                AnnotationConstructorCallerKt.m26893a(i2, (String) this.f32546h.get(i2), (Class) this.f32543e.get(i2));
                throw null;
            }
            arrayList.add(obj);
            i++;
            i2 = i3;
        }
        return AnnotationConstructorCallerKt.m26891a(this.f32545g, this.f32548j, MapsKt__MapsKt.m36117a((Iterable) CollectionsKt___CollectionsKt.m41417a((Iterable) this.f32546h, (Iterable) (List) arrayList)));
    }
}
