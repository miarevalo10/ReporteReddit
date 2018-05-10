package kotlin.jvm.internal;

import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableIterable;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableSet;

public class TypeIntrinsics {
    private static void m26871a(Object obj, String str) {
        obj = obj == null ? "null" : obj.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(obj);
        stringBuilder.append(" cannot be cast to ");
        stringBuilder.append(str);
        throw m26868a(new ClassCastException(stringBuilder.toString()));
    }

    public static Iterable m26869a(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableIterable)) {
            m26871a(obj, "kotlin.collections.MutableIterable");
        }
        return m26874d(obj);
    }

    private static Iterable m26874d(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e) {
            throw m26868a(e);
        }
    }

    public static List m26872b(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableList)) {
            m26871a(obj, "kotlin.collections.MutableList");
        }
        return m26875e(obj);
    }

    private static List m26875e(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw m26868a(e);
        }
    }

    public static Set m26873c(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableSet)) {
            m26871a(obj, "kotlin.collections.MutableSet");
        }
        return m26876f(obj);
    }

    private static Set m26876f(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e) {
            throw m26868a(e);
        }
    }

    private static ClassCastException m26868a(ClassCastException classCastException) {
        throw ((ClassCastException) Intrinsics.m26841a((Throwable) classCastException, TypeIntrinsics.class.getName()));
    }

    public static Object m26870a(Object obj, int i) {
        if (obj != null) {
            StringBuilder stringBuilder;
            Object obj2 = 1;
            if (obj instanceof Function) {
                int arity = obj instanceof FunctionBase ? ((FunctionBase) obj).getArity() : obj instanceof Function0 ? 0 : obj instanceof Function1 ? 1 : obj instanceof Function2 ? 2 : obj instanceof Function3 ? 3 : obj instanceof Function4 ? 4 : obj instanceof Function5 ? 5 : obj instanceof Function6 ? 6 : obj instanceof Function7 ? 7 : obj instanceof Function8 ? 8 : obj instanceof Function9 ? 9 : obj instanceof Function10 ? 10 : obj instanceof Function11 ? 11 : obj instanceof Function12 ? 12 : obj instanceof Function13 ? 13 : obj instanceof Function14 ? 14 : obj instanceof Function15 ? 15 : obj instanceof Function16 ? 16 : obj instanceof Function17 ? 17 : obj instanceof Function18 ? 18 : obj instanceof Function19 ? 19 : obj instanceof Function20 ? 20 : obj instanceof Function21 ? 21 : obj instanceof Function22 ? 22 : -1;
                if (arity == i) {
                    if (obj2 == null) {
                        stringBuilder = new StringBuilder("kotlin.jvm.functions.Function");
                        stringBuilder.append(i);
                        m26871a(obj, stringBuilder.toString());
                    }
                }
            }
            obj2 = null;
            if (obj2 == null) {
                stringBuilder = new StringBuilder("kotlin.jvm.functions.Function");
                stringBuilder.append(i);
                m26871a(obj, stringBuilder.toString());
            }
        }
        return obj;
    }
}
