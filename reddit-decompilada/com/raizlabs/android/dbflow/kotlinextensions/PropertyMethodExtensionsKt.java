package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.sql.language.BaseModelQueriable;
import com.raizlabs.android.dbflow.sql.language.IConditional;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.Operator.Between;
import com.raizlabs.android.dbflow.sql.language.Operator.In;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\b\u001a%\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0004\u001a\u0019\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0004\u001a8\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010\n\u001a\u0002H\u0002H\u0004¢\u0006\u0002\u0010\u000b\u001a\u0019\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0004\u001a8\u0010\f\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010\n\u001a\u0002H\u0002H\u0004¢\u0006\u0002\u0010\u000e\u001a%\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\r\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0004\u001a\u0019\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0004\u001a:\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\b\u0010\n\u001a\u0004\u0018\u0001H\u0002H\u0004¢\u0006\u0002\u0010\u000e\u001a%\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\r\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0004\u001a\u0019\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0004\u001a\u0019\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00032\u0006\u0010\n\u001a\u00020\u0011H\u0004\u001a3\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H\u0004\u001a%\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\r\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0004\u001a\u0019\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0004\u001a8\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010\n\u001a\u0002H\u0002H\u0004¢\u0006\u0002\u0010\u000e\u001a%\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\r\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0004\u001a\u0019\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0004\u001a8\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010\n\u001a\u0002H\u0002H\u0004¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0017H\u0004¢\u0006\u0002\u0010\u0018\u001a$\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015*\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u0004¢\u0006\u0002\u0010\u0019\u001a6\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0004¢\u0006\u0002\u0010\u001a\u001a9\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\u0015\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001bH\u0004\u001a%\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\r\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0004\u001a\u0019\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0004\u001a:\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\b\u0010\n\u001a\u0004\u0018\u0001H\u0002H\u0004¢\u0006\u0002\u0010\u000e\u001a%\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\r\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0004\u001a\u0019\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0004\u001a:\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\b\u0010\n\u001a\u0004\u0018\u0001H\u0002H\u0004¢\u0006\u0002\u0010\u000e\u001a%\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\r\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0004\u001a\u0019\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0004\u001a8\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010\n\u001a\u0002H\u0002H\u0004¢\u0006\u0002\u0010\u000e\u001a%\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\r\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0004\u001a\u0019\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0004\u001a8\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010\n\u001a\u0002H\u0002H\u0004¢\u0006\u0002\u0010\u000e\u001a%\u0010 \u001a\u0006\u0012\u0002\b\u00030\r\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0004\u001a\u0019\u0010 \u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0004\u001a\u0019\u0010 \u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00032\u0006\u0010\n\u001a\u00020\u0011H\u0004\u001a3\u0010 \u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H\u0004\u001a%\u0010!\u001a\u0006\u0012\u0002\b\u00030\r\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0004\u001a\u0019\u0010!\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0004\u001a:\u0010!\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\b\u0010\n\u001a\u0004\u0018\u0001H\u0002H\u0004¢\u0006\u0002\u0010\u000e\u001a0\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u0015\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0017H\u0004¢\u0006\u0002\u0010\u0018\u001a$\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u0015*\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u0004¢\u0006\u0002\u0010\u0019\u001a6\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0004¢\u0006\u0002\u0010\u001a\u001a9\u0010\"\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0002H\u00020\u0015\"\b\b\u0000\u0010\u0002*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001bH\u0004¨\u0006#"}, d2 = {"between", "Lcom/raizlabs/android/dbflow/sql/language/Operator$Between;", "T", "Lcom/raizlabs/android/dbflow/sql/language/IConditional;", "baseModelQueriable", "Lcom/raizlabs/android/dbflow/sql/language/BaseModelQueriable;", "conditional", "kotlin.jvm.PlatformType", "", "Lcom/raizlabs/android/dbflow/sql/language/property/Property;", "value", "(Lcom/raizlabs/android/dbflow/sql/language/property/Property;Ljava/lang/Object;)Lcom/raizlabs/android/dbflow/sql/language/Operator$Between;", "concatenate", "Lcom/raizlabs/android/dbflow/sql/language/Operator;", "(Lcom/raizlabs/android/dbflow/sql/language/property/Property;Ljava/lang/Object;)Lcom/raizlabs/android/dbflow/sql/language/Operator;", "eq", "glob", "", "greaterThan", "greaterThanOrEq", "in", "Lcom/raizlabs/android/dbflow/sql/language/Operator$In;", "values", "", "(Lcom/raizlabs/android/dbflow/sql/language/IConditional;[Lcom/raizlabs/android/dbflow/sql/language/BaseModelQueriable;)Lcom/raizlabs/android/dbflow/sql/language/Operator$In;", "(Lcom/raizlabs/android/dbflow/sql/language/IConditional;[Lcom/raizlabs/android/dbflow/sql/language/IConditional;)Lcom/raizlabs/android/dbflow/sql/language/Operator$In;", "(Lcom/raizlabs/android/dbflow/sql/language/property/Property;[Ljava/lang/Object;)Lcom/raizlabs/android/dbflow/sql/language/Operator$In;", "", "is", "isNot", "lessThan", "lessThanOrEq", "like", "notEq", "notIn", "dbflow-kotlinextensions_release"}, k = 2, mv = {1, 1, 7})
/* compiled from: PropertyMethodExtensions.kt */
public final class PropertyMethodExtensionsKt {
    public static final <T> Operator<T> eq(Property<T> property, T t) {
        Intrinsics.b(property, "$receiver");
        return property.eq((Object) t);
    }

    public static final <T> Operator<T> is(Property<T> property, T t) {
        Intrinsics.b(property, "$receiver");
        return property.is((Object) t);
    }

    public static final <T> Operator<T> isNot(Property<T> property, T t) {
        Intrinsics.b(property, "$receiver");
        return property.isNot((Object) t);
    }

    public static final <T> Operator<T> notEq(Property<T> property, T t) {
        Intrinsics.b(property, "$receiver");
        return property.notEq((Object) t);
    }

    public static final <T> Operator<T> like(Property<T> property, String str) {
        Intrinsics.b(property, "$receiver");
        Intrinsics.b(str, "value");
        return property.like(str);
    }

    public static final <T> Operator<T> glob(Property<T> property, String str) {
        Intrinsics.b(property, "$receiver");
        Intrinsics.b(str, "value");
        return property.glob(str);
    }

    public static final <T> Operator<T> greaterThan(Property<T> property, T t) {
        Intrinsics.b(property, "$receiver");
        Intrinsics.b(t, "value");
        return property.greaterThan((Object) t);
    }

    public static final <T> Operator<T> greaterThanOrEq(Property<T> property, T t) {
        Intrinsics.b(property, "$receiver");
        Intrinsics.b(t, "value");
        return property.greaterThanOrEq((Object) t);
    }

    public static final <T> Operator<T> lessThan(Property<T> property, T t) {
        Intrinsics.b(property, "$receiver");
        Intrinsics.b(t, "value");
        return property.lessThan((Object) t);
    }

    public static final <T> Operator<T> lessThanOrEq(Property<T> property, T t) {
        Intrinsics.b(property, "$receiver");
        Intrinsics.b(t, "value");
        return property.lessThanOrEq((Object) t);
    }

    public static final <T> Between<T> between(Property<T> property, T t) {
        Intrinsics.b(property, "$receiver");
        Intrinsics.b(t, "value");
        return property.between((Object) t);
    }

    public static final <T> In<T> in(Property<T> property, T[] tArr) {
        Intrinsics.b(property, "$receiver");
        Intrinsics.b(tArr, "values");
        if (tArr.length != 1) {
            Object obj = tArr[0];
            tArr = ArraysKt.a(tArr, new IntRange(1, tArr.length));
            property = property.in(obj, Arrays.copyOf(tArr, tArr.length));
            Intrinsics.a(property, "this.`in`(values[0], *va…ntRange(1, values.size)))");
            return property;
        }
        property = property.in(tArr[0], new Object[0]);
        Intrinsics.a(property, "`in`(values[0])");
        return property;
    }

    public static final <T> In<T> notIn(Property<T> property, T[] tArr) {
        Intrinsics.b(property, "$receiver");
        Intrinsics.b(tArr, "values");
        if (tArr.length != 1) {
            Object obj = tArr[0];
            tArr = ArraysKt.a(tArr, new IntRange(1, tArr.length));
            property = property.notIn(obj, Arrays.copyOf(tArr, tArr.length));
            Intrinsics.a(property, "this.notIn(values[0], *v…ntRange(1, values.size)))");
            return property;
        }
        property = property.notIn(tArr[0], new Object[0]);
        Intrinsics.a(property, "notIn(values[0])");
        return property;
    }

    public static final <T> In<T> in(Property<T> property, Collection<? extends T> collection) {
        Intrinsics.b(property, "$receiver");
        Intrinsics.b(collection, "values");
        return property.in(collection);
    }

    public static final <T> In<T> notIn(Property<T> property, Collection<? extends T> collection) {
        Intrinsics.b(property, "$receiver");
        Intrinsics.b(collection, "values");
        return property.notIn(collection);
    }

    public static final <T> Operator<T> concatenate(Property<T> property, T t) {
        Intrinsics.b(property, "$receiver");
        Intrinsics.b(t, "value");
        return property.concatenate((Object) t);
    }

    public static final Operator<?> eq(IConditional iConditional, IConditional iConditional2) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditional2, "value");
        iConditional = iConditional.eq(iConditional2);
        Intrinsics.a(iConditional, "this.eq(value)");
        return iConditional;
    }

    public static final Operator<?> is(IConditional iConditional, IConditional iConditional2) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditional2, "conditional");
        iConditional = iConditional.is(iConditional2);
        Intrinsics.a(iConditional, "this.`is`(conditional)");
        return iConditional;
    }

    public static final Operator<?> isNot(IConditional iConditional, IConditional iConditional2) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditional2, "conditional");
        iConditional = iConditional.isNot(iConditional2);
        Intrinsics.a(iConditional, "this.isNot(conditional)");
        return iConditional;
    }

    public static final Operator<?> notEq(IConditional iConditional, IConditional iConditional2) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditional2, "conditional");
        iConditional = iConditional.notEq(iConditional2);
        Intrinsics.a(iConditional, "this.notEq(conditional)");
        return iConditional;
    }

    public static final Operator<?> like(IConditional iConditional, IConditional iConditional2) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditional2, "conditional");
        iConditional = iConditional.like(iConditional2);
        Intrinsics.a(iConditional, "this.like(conditional)");
        return iConditional;
    }

    public static final Operator<?> glob(IConditional iConditional, IConditional iConditional2) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditional2, "conditional");
        iConditional = iConditional.glob(iConditional2);
        Intrinsics.a(iConditional, "this.glob(conditional)");
        return iConditional;
    }

    public static final Operator<?> like(IConditional iConditional, String str) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(str, "value");
        iConditional = iConditional.like(str);
        Intrinsics.a(iConditional, "this.like(value)");
        return iConditional;
    }

    public static final Operator<?> glob(IConditional iConditional, String str) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(str, "value");
        iConditional = iConditional.glob(str);
        Intrinsics.a(iConditional, "this.glob(value)");
        return iConditional;
    }

    public static final Operator<?> greaterThan(IConditional iConditional, IConditional iConditional2) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditional2, "conditional");
        iConditional = iConditional.greaterThan(iConditional2);
        Intrinsics.a(iConditional, "this.greaterThan(conditional)");
        return iConditional;
    }

    public static final Operator<?> greaterThanOrEq(IConditional iConditional, IConditional iConditional2) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditional2, "conditional");
        iConditional = iConditional.greaterThanOrEq(iConditional2);
        Intrinsics.a(iConditional, "this.greaterThanOrEq(conditional)");
        return iConditional;
    }

    public static final Operator<?> lessThan(IConditional iConditional, IConditional iConditional2) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditional2, "conditional");
        iConditional = iConditional.lessThan(iConditional2);
        Intrinsics.a(iConditional, "this.lessThan(conditional)");
        return iConditional;
    }

    public static final Operator<?> lessThanOrEq(IConditional iConditional, IConditional iConditional2) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditional2, "conditional");
        iConditional = iConditional.lessThanOrEq(iConditional2);
        Intrinsics.a(iConditional, "this.lessThanOrEq(conditional)");
        return iConditional;
    }

    public static final Between<?> between(IConditional iConditional, IConditional iConditional2) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditional2, "conditional");
        iConditional = iConditional.between(iConditional2);
        Intrinsics.a(iConditional, "this.between(conditional)");
        return iConditional;
    }

    public static final In<?> in(IConditional iConditional, IConditional[] iConditionalArr) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditionalArr, "values");
        Object[] objArr = (Object[]) iConditionalArr;
        if (objArr.length != 1) {
            IConditional[] iConditionalArr2 = (IConditional[]) ArraysKt.a(objArr, new IntRange(1, objArr.length));
            iConditional = iConditional.in(iConditionalArr[0], (IConditional[]) Arrays.copyOf(iConditionalArr2, iConditionalArr2.length));
            Intrinsics.a(iConditional, "this.`in`(values[0], *va…ntRange(1, values.size)))");
            return iConditional;
        }
        iConditional = iConditional.in(iConditionalArr[0], new IConditional[0]);
        Intrinsics.a(iConditional, "`in`(values[0])");
        return iConditional;
    }

    public static final In<?> notIn(IConditional iConditional, IConditional[] iConditionalArr) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditionalArr, "values");
        Object[] objArr = (Object[]) iConditionalArr;
        if (objArr.length != 1) {
            IConditional[] iConditionalArr2 = (IConditional[]) ArraysKt.a(objArr, new IntRange(1, objArr.length));
            iConditional = iConditional.notIn(iConditionalArr[0], (IConditional[]) Arrays.copyOf(iConditionalArr2, iConditionalArr2.length));
            Intrinsics.a(iConditional, "this.notIn(values[0], *v…ntRange(1, values.size)))");
            return iConditional;
        }
        iConditional = iConditional.notIn(iConditionalArr[0], new IConditional[0]);
        Intrinsics.a(iConditional, "notIn(values[0])");
        return iConditional;
    }

    public static final <T> Operator<?> is(IConditional iConditional, BaseModelQueriable<T> baseModelQueriable) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(baseModelQueriable, "baseModelQueriable");
        iConditional = iConditional.is((BaseModelQueriable) baseModelQueriable);
        Intrinsics.a(iConditional, "this.`is`(baseModelQueriable)");
        return iConditional;
    }

    public static final <T> Operator<?> eq(IConditional iConditional, BaseModelQueriable<T> baseModelQueriable) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(baseModelQueriable, "baseModelQueriable");
        iConditional = iConditional.eq((BaseModelQueriable) baseModelQueriable);
        Intrinsics.a(iConditional, "this.eq(baseModelQueriable)");
        return iConditional;
    }

    public static final <T> Operator<?> isNot(IConditional iConditional, BaseModelQueriable<T> baseModelQueriable) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(baseModelQueriable, "baseModelQueriable");
        iConditional = iConditional.isNot((BaseModelQueriable) baseModelQueriable);
        Intrinsics.a(iConditional, "this.isNot(baseModelQueriable)");
        return iConditional;
    }

    public static final <T> Operator<?> notEq(IConditional iConditional, BaseModelQueriable<T> baseModelQueriable) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(baseModelQueriable, "baseModelQueriable");
        iConditional = iConditional.notEq((BaseModelQueriable) baseModelQueriable);
        Intrinsics.a(iConditional, "this.notEq(baseModelQueriable)");
        return iConditional;
    }

    public static final <T> Operator<?> like(IConditional iConditional, BaseModelQueriable<T> baseModelQueriable) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(baseModelQueriable, "baseModelQueriable");
        iConditional = iConditional.like((BaseModelQueriable) baseModelQueriable);
        Intrinsics.a(iConditional, "this.like(baseModelQueriable)");
        return iConditional;
    }

    public static final <T> Operator<?> glob(IConditional iConditional, BaseModelQueriable<T> baseModelQueriable) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(baseModelQueriable, "baseModelQueriable");
        iConditional = iConditional.glob((BaseModelQueriable) baseModelQueriable);
        Intrinsics.a(iConditional, "this.glob(baseModelQueriable)");
        return iConditional;
    }

    public static final <T> Operator<?> greaterThan(IConditional iConditional, BaseModelQueriable<T> baseModelQueriable) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(baseModelQueriable, "baseModelQueriable");
        iConditional = iConditional.greaterThan((BaseModelQueriable) baseModelQueriable);
        Intrinsics.a(iConditional, "this.greaterThan(baseModelQueriable)");
        return iConditional;
    }

    public static final <T> Operator<?> greaterThanOrEq(IConditional iConditional, BaseModelQueriable<T> baseModelQueriable) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(baseModelQueriable, "baseModelQueriable");
        iConditional = iConditional.greaterThanOrEq((BaseModelQueriable) baseModelQueriable);
        Intrinsics.a(iConditional, "this.greaterThanOrEq(baseModelQueriable)");
        return iConditional;
    }

    public static final <T> Operator<?> lessThan(IConditional iConditional, BaseModelQueriable<T> baseModelQueriable) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(baseModelQueriable, "baseModelQueriable");
        iConditional = iConditional.lessThan((BaseModelQueriable) baseModelQueriable);
        Intrinsics.a(iConditional, "this.lessThan(baseModelQueriable)");
        return iConditional;
    }

    public static final <T> Operator<?> lessThanOrEq(IConditional iConditional, BaseModelQueriable<T> baseModelQueriable) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(baseModelQueriable, "baseModelQueriable");
        iConditional = iConditional.lessThanOrEq((BaseModelQueriable) baseModelQueriable);
        Intrinsics.a(iConditional, "this.lessThanOrEq(baseModelQueriable)");
        return iConditional;
    }

    public static final <T> Between<?> between(IConditional iConditional, BaseModelQueriable<T> baseModelQueriable) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(baseModelQueriable, "baseModelQueriable");
        iConditional = iConditional.between((BaseModelQueriable) baseModelQueriable);
        Intrinsics.a(iConditional, "this.between(baseModelQueriable)");
        return iConditional;
    }

    public static final <T> In<?> in(IConditional iConditional, BaseModelQueriable<T>[] baseModelQueriableArr) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(baseModelQueriableArr, "values");
        Object[] objArr = (Object[]) baseModelQueriableArr;
        if (objArr.length != 1) {
            BaseModelQueriable[] baseModelQueriableArr2 = (BaseModelQueriable[]) ArraysKt.a(objArr, new IntRange(1, objArr.length));
            iConditional = iConditional.in(baseModelQueriableArr[0], (BaseModelQueriable[]) Arrays.copyOf(baseModelQueriableArr2, baseModelQueriableArr2.length));
            Intrinsics.a(iConditional, "this.`in`(values[0], *va…ntRange(1, values.size)))");
            return iConditional;
        }
        iConditional = iConditional.in(baseModelQueriableArr[0], new BaseModelQueriable[0]);
        Intrinsics.a(iConditional, "`in`(values[0])");
        return iConditional;
    }

    public static final <T> In<?> notIn(IConditional iConditional, BaseModelQueriable<T>[] baseModelQueriableArr) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(baseModelQueriableArr, "values");
        Object[] objArr = (Object[]) baseModelQueriableArr;
        if (objArr.length != 1) {
            BaseModelQueriable[] baseModelQueriableArr2 = (BaseModelQueriable[]) ArraysKt.a(objArr, new IntRange(1, objArr.length));
            iConditional = iConditional.notIn(baseModelQueriableArr[0], (BaseModelQueriable[]) Arrays.copyOf(baseModelQueriableArr2, baseModelQueriableArr2.length));
            Intrinsics.a(iConditional, "this.notIn(values[0], *v…ntRange(1, values.size)))");
            return iConditional;
        }
        iConditional = iConditional.notIn(baseModelQueriableArr[0], new BaseModelQueriable[0]);
        Intrinsics.a(iConditional, "notIn(values[0])");
        return iConditional;
    }

    public static final Operator<?> concatenate(IConditional iConditional, IConditional iConditional2) {
        Intrinsics.b(iConditional, "$receiver");
        Intrinsics.b(iConditional2, "conditional");
        iConditional = iConditional.concatenate(iConditional2);
        Intrinsics.a(iConditional, "this.concatenate(conditional)");
        return iConditional;
    }
}
