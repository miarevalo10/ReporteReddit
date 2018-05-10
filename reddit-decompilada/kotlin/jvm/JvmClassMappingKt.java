package kotlin.jvm;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a!\u0010\u0018\u001a\u00020\u0019\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\r*\u0006\u0012\u0002\b\u00030\u001aH\u0007¢\u0006\u0002\u0010\u001b\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018GX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\u0002H\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000e\";\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"-\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b\"+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-runtime"}, k = 2, mv = {1, 1, 9})
/* compiled from: JvmClassMapping.kt */
public final class JvmClassMappingKt {
    public static final <T> Class<T> m26829a(KClass<T> kClass) {
        Intrinsics.m26847b(kClass, "$receiver");
        kClass = ((ClassBasedDeclarationContainer) kClass).mo6657a();
        if (kClass != null) {
            return kClass;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }

    public static final <T> Class<T> m26832b(KClass<T> kClass) {
        Intrinsics.m26847b(kClass, "$receiver");
        kClass = ((ClassBasedDeclarationContainer) kClass).mo6657a();
        if (!kClass.isPrimitive()) {
            kClass = kClass.getName();
            if (kClass != null) {
                switch (kClass.hashCode()) {
                    case -2056817302:
                        if (kClass.equals("java.lang.Integer") != null) {
                            return Integer.TYPE;
                        }
                        break;
                    case -527879800:
                        if (kClass.equals("java.lang.Float") != null) {
                            return Float.TYPE;
                        }
                        break;
                    case -515992664:
                        if (kClass.equals("java.lang.Short") != null) {
                            return Short.TYPE;
                        }
                        break;
                    case 155276373:
                        if (kClass.equals("java.lang.Character") != null) {
                            return Character.TYPE;
                        }
                        break;
                    case 344809556:
                        if (kClass.equals("java.lang.Boolean") != null) {
                            return Boolean.TYPE;
                        }
                        break;
                    case 398507100:
                        if (kClass.equals("java.lang.Byte") != null) {
                            return Byte.TYPE;
                        }
                        break;
                    case 398795216:
                        if (kClass.equals("java.lang.Long") != null) {
                            return Long.TYPE;
                        }
                        break;
                    case 399092968:
                        if (kClass.equals("java.lang.Void") != null) {
                            return Void.TYPE;
                        }
                        break;
                    case 761287205:
                        if (kClass.equals("java.lang.Double") != null) {
                            return Double.TYPE;
                        }
                        break;
                    default:
                        break;
                }
            }
            return null;
        } else if (kClass != null) {
            return kClass;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
        }
    }

    public static final <T> Class<T> m26833c(KClass<T> kClass) {
        Intrinsics.m26847b(kClass, "$receiver");
        kClass = ((ClassBasedDeclarationContainer) kClass).mo6657a();
        if (kClass.isPrimitive()) {
            String name = kClass.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            kClass = Double.class;
                            break;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            kClass = Integer.class;
                            break;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            kClass = Byte.class;
                            break;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            kClass = Character.class;
                            break;
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            kClass = Long.class;
                            break;
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            kClass = Void.class;
                            break;
                        }
                        break;
                    case 64711720:
                        if (name.equals("boolean")) {
                            kClass = Boolean.class;
                            break;
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            kClass = Float.class;
                            break;
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            kClass = Short.class;
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            if (kClass != null) {
                return kClass;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
        } else if (kClass != null) {
            return kClass;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
        }
    }

    public static final <T> KClass<T> m26830a(Class<T> cls) {
        Intrinsics.m26847b(cls, "$receiver");
        return Reflection.m26850a((Class) cls);
    }

    public static final <T extends Annotation> KClass<? extends T> m26831a(T t) {
        Intrinsics.m26847b(t, "$receiver");
        Class annotationType = t.annotationType();
        Intrinsics.m26843a((Object) annotationType, "(this as java.lang.annot…otation).annotationType()");
        t = m26830a(annotationType);
        if (t != null) {
            return t;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
    }
}
