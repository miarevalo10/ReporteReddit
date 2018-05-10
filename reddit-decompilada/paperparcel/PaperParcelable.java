package paperparcel;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002J\u0014\u0010\u0007\u001a\u00020\b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lpaperparcel/PaperParcelable;", "Landroid/os/Parcelable;", "describeContents", "", "findAnnotatedClass", "Ljava/lang/Class;", "type", "implementationName", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Cache", "paperparcel-kotlin_release"}, k = 1, mv = {1, 1, 7})
/* compiled from: PaperParcelable.kt */
public interface PaperParcelable extends Parcelable {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lpaperparcel/PaperParcelable$Cache;", "", "()V", "writeMethods", "", "Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "getWriteMethods", "()Ljava/util/Map;", "paperparcel-kotlin_release"}, k = 1, mv = {1, 1, 7})
    /* compiled from: PaperParcelable.kt */
    private static final class Cache {
        public static final Cache f41122a = null;
        private static final Map<Class<?>, Method> f41123b = null;

        static {
            Cache cache = new Cache();
        }

        private Cache() {
            f41122a = this;
            f41123b = new LinkedHashMap();
        }

        public static Map<Class<?>, Method> m43238a() {
            return f41123b;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 7})
    /* compiled from: PaperParcelable.kt */
    public static final class DefaultImpls {
        public static void writeToParcel(PaperParcelable paperParcelable, Parcel parcel, int i) {
            Intrinsics.b(parcel, "dest");
            Cache cache = Cache.f41122a;
            if (!Cache.m43238a().containsKey(paperParcelable.getClass())) {
                Class cls = paperParcelable.getClass();
                while (!cls.isAnnotationPresent(PaperParcel.class)) {
                    if (Intrinsics.a(cls, Object.class)) {
                        i = new StringBuilder("Cannot find @");
                        i.append(PaperParcel.class.getSimpleName());
                        i.append(" on ");
                        i.append(paperParcelable.getClass().getName());
                        i.append('.');
                        throw ((Throwable) new IllegalArgumentException(i.toString()));
                    }
                    cls = cls.getSuperclass();
                    Intrinsics.a(cls, "type.superclass");
                }
                String name = cls.getPackage().getName();
                String name2 = cls.getName();
                int length = name.length() + 1;
                if (name2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                name2 = name2.substring(length);
                Intrinsics.a(name2, "(this as java.lang.String).substring(startIndex)");
                name2 = StringsKt.a(name2, '$', '_');
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(name);
                stringBuilder.append(".PaperParcel");
                stringBuilder.append(name2);
                Class[] clsArr = (Class[]) ((Object[]) new Class[]{cls, Parcel.class, JvmClassMappingKt.b(Reflection.a(Integer.TYPE))});
                Method declaredMethod = Class.forName(stringBuilder.toString()).getDeclaredMethod("writeToParcel", (Class[]) Arrays.copyOf(clsArr, clsArr.length));
                declaredMethod.setAccessible(true);
                Cache cache2 = Cache.f41122a;
                Map a = Cache.m43238a();
                Class cls2 = paperParcelable.getClass();
                Intrinsics.a(declaredMethod, "writeMethod");
                a.put(cls2, declaredMethod);
            }
            cache = Cache.f41122a;
            Object obj = Cache.m43238a().get(paperParcelable.getClass());
            if (obj == null) {
                Intrinsics.a();
            }
            ((Method) obj).invoke(null, new Object[]{paperParcelable, parcel, Integer.valueOf(i)});
        }
    }
}
