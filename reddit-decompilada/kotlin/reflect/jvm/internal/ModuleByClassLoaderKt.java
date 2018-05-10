package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.RuntimeModuleData.Companion;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0006H\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lorg/jetbrains/kotlin/load/kotlin/reflect/RuntimeModuleData;", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 1, 5})
/* compiled from: moduleByClassLoader.kt */
public final class ModuleByClassLoaderKt {
    private static final ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> f25337a = new ConcurrentHashMap();

    public static final RuntimeModuleData m26913a(Class<?> cls) {
        RuntimeModuleData weakReference;
        Intrinsics.m26847b(cls, "$receiver");
        cls = ReflectClassUtilKt.m27239a((Class) cls);
        WeakClassLoaderBox weakClassLoaderBox = new WeakClassLoaderBox(cls);
        WeakReference weakReference2 = (WeakReference) f25337a.get(weakClassLoaderBox);
        if (weakReference2 != null) {
            RuntimeModuleData runtimeModuleData = (RuntimeModuleData) weakReference2.get();
            if (runtimeModuleData != null) {
                Object obj = runtimeModuleData;
                Intrinsics.m26843a(obj, "it");
                return obj;
            }
            f25337a.remove(weakClassLoaderBox, weakReference2);
        }
        Companion companion = RuntimeModuleData.f25847c;
        cls = Companion.m27392a(cls);
        while (true) {
            ConcurrentMap concurrentMap = f25337a;
            weakReference = new WeakReference(cls);
            WeakReference weakReference3 = (WeakReference) concurrentMap.putIfAbsent(weakClassLoaderBox, weakReference);
            if (weakReference3 == null) {
                weakClassLoaderBox.f25345a = null;
                return cls;
            }
            weakReference = (RuntimeModuleData) weakReference3.get();
            if (weakReference != null) {
                break;
            }
            try {
                weakReference = f25337a;
                weakReference.remove(weakClassLoaderBox, weakReference3);
            } finally {
                weakClassLoaderBox.f25345a = null;
            }
        }
        return weakReference;
    }
}
