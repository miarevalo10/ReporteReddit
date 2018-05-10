package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinTarget.kt */
public enum KotlinTarget {
    ;
    
    public static final Companion f25558Q = null;
    private static final HashMap<String, KotlinTarget> f25560U = null;
    private static final Set<KotlinTarget> f25561V = null;
    private static final Set<KotlinTarget> f25562W = null;
    private static final Map<AnnotationUseSiteTarget, KotlinTarget> f25563X = null;
    private final String f25590S;
    private final boolean f25591T;

    /* compiled from: KotlinTarget.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    private KotlinTarget(String str, boolean z) {
        Intrinsics.m26847b(str, "description");
        this.f25590S = str;
        this.f25591T = z;
    }

    static {
        f25558Q = new Companion();
        f25560U = new HashMap();
        KotlinTarget[] values = values();
        for (KotlinTarget kotlinTarget : values) {
            f25560U.put(kotlinTarget.name(), kotlinTarget);
        }
        Object[] objArr = (Object[]) values();
        Collection arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (((KotlinTarget) obj).f25591T) {
                arrayList.add(obj);
            }
        }
        f25561V = CollectionsKt___CollectionsKt.m41451p((List) arrayList);
        f25562W = ArraysKt___ArraysKt.m36111k((Object[]) values());
        f25563X = MapsKt__MapsKt.m36121a(TuplesKt.m26780a(AnnotationUseSiteTarget.f25528g, f25570g), TuplesKt.m26780a(AnnotationUseSiteTarget.f25522a, f25568e), TuplesKt.m26780a(AnnotationUseSiteTarget.f25524c, f25567d), TuplesKt.m26780a(AnnotationUseSiteTarget.f25523b, f25577n), TuplesKt.m26780a(AnnotationUseSiteTarget.f25525d, f25573j), TuplesKt.m26780a(AnnotationUseSiteTarget.f25526e, f25574k), TuplesKt.m26780a(AnnotationUseSiteTarget.f25527f, f25570g), TuplesKt.m26780a(AnnotationUseSiteTarget.f25529h, f25570g), TuplesKt.m26780a(AnnotationUseSiteTarget.f25530i, f25568e));
    }
}
