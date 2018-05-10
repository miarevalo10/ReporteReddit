package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.language.property.PropertyFactory;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\b\u001aC\u0010\u001a\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00190\u0019 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u00010\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u001bH\b\"/\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004*\u0004\u0018\u0001H\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"3\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\b\"#\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\t0\t0\u0001*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\n\"#\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u000b0\u000b0\u0001*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\f\"#\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\r0\r0\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u000e\"#\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u000f0\u000f0\u0001*\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0010\"#\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00110\u00110\u0001*\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0012\"#\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00130\u00130\u0001*\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0014\"#\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00150\u00150\u0001*\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0016¨\u0006\u001c"}, d2 = {"property", "Lcom/raizlabs/android/dbflow/sql/language/property/Property;", "T", "kotlin.jvm.PlatformType", "", "getProperty", "(Ljava/lang/Object;)Lcom/raizlabs/android/dbflow/sql/language/property/Property;", "Lcom/raizlabs/android/dbflow/sql/queriable/ModelQueriable;", "(Lcom/raizlabs/android/dbflow/sql/queriable/ModelQueriable;)Lcom/raizlabs/android/dbflow/sql/language/property/Property;", "", "(B)Lcom/raizlabs/android/dbflow/sql/language/property/Property;", "", "(C)Lcom/raizlabs/android/dbflow/sql/language/property/Property;", "", "(D)Lcom/raizlabs/android/dbflow/sql/language/property/Property;", "", "(F)Lcom/raizlabs/android/dbflow/sql/language/property/Property;", "", "(I)Lcom/raizlabs/android/dbflow/sql/language/property/Property;", "", "(J)Lcom/raizlabs/android/dbflow/sql/language/property/Property;", "", "(S)Lcom/raizlabs/android/dbflow/sql/language/property/Property;", "propertyString", "stringRepresentation", "", "allProperty", "Lkotlin/reflect/KClass;", "dbflow-kotlinextensions_release"}, k = 2, mv = {1, 1, 7})
/* compiled from: PropertyExtensions.kt */
public final class PropertyExtensionsKt {
    public static final Property<Integer> getProperty(int i) {
        return PropertyFactory.from(i);
    }

    public static final Property<Character> getProperty(char c) {
        return PropertyFactory.from(c);
    }

    public static final Property<Double> getProperty(double d) {
        return PropertyFactory.from(d);
    }

    public static final Property<Long> getProperty(long j) {
        return PropertyFactory.from(j);
    }

    public static final Property<Float> getProperty(float f) {
        return PropertyFactory.from(f);
    }

    public static final Property<Short> getProperty(short s) {
        return PropertyFactory.from(s);
    }

    public static final Property<Byte> getProperty(byte b) {
        return PropertyFactory.from(b);
    }

    public static final <T> Property<T> getProperty(T t) {
        return PropertyFactory.from((Object) t);
    }

    public static final <T> Property<T> getProperty(ModelQueriable<T> modelQueriable) {
        Intrinsics.b(modelQueriable, "$receiver");
        return PropertyFactory.from((ModelQueriable) modelQueriable);
    }

    private static final <T> Property<T> propertyString(String str) {
        Intrinsics.b();
        return PropertyFactory.from(Object.class, str);
    }

    private static final <T> Property<String> allProperty(KClass<T> kClass) {
        return Property.allProperty(JvmClassMappingKt.a(kClass));
    }
}
