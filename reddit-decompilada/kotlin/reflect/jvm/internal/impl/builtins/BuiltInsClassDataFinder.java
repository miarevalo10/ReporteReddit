package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.ClassDataWithSource;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.serialization.builtins.BuiltInsProtoBuf.BuiltIns;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;

/* compiled from: BuiltInsClassDataFinder.kt */
public final class BuiltInsClassDataFinder implements ClassDataFinder {
    final Map<ClassId, Class> f32615a;
    private final NameResolver f32616b;

    public BuiltInsClassDataFinder(BuiltIns builtIns, NameResolver nameResolver) {
        Intrinsics.m26847b(builtIns, "proto");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        this.f32616b = nameResolver;
        Iterable iterable = (Iterable) builtIns.f39873g;
        Map linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.m32855c(MapsKt__MapsKt.m36115a((int) CollectionsKt__IterablesKt.m32812b(iterable)), 16));
        for (NameResolver nameResolver2 : iterable) {
            linkedHashMap.put(this.f32616b.mo5831c(((Class) nameResolver2).f40316f), nameResolver2);
        }
        this.f32615a = linkedHashMap;
    }

    public final ClassDataWithSource mo5703a(ClassId classId) {
        Intrinsics.m26847b(classId, "classId");
        Class classR = (Class) this.f32615a.get(classId);
        if (classR == null) {
            return null;
        }
        ClassData classData = new ClassData(this.f32616b, classR);
        Object obj = SourceElement.f25498a;
        Intrinsics.m26843a(obj, "SourceElement.NO_SOURCE");
        return new ClassDataWithSource(classData, obj);
    }
}
