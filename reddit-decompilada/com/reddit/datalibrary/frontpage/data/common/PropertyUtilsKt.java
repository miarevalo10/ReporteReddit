package com.reddit.datalibrary.frontpage.data.common;

import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"eqOrIsNull", "Lcom/raizlabs/android/dbflow/sql/language/Operator;", "T", "Lcom/raizlabs/android/dbflow/sql/language/property/Property;", "value", "(Lcom/raizlabs/android/dbflow/sql/language/property/Property;Ljava/lang/Object;)Lcom/raizlabs/android/dbflow/sql/language/Operator;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: PropertyUtils.kt */
public final class PropertyUtilsKt {
    public static final <T> Operator<T> m8755a(Property<T> property, T t) {
        Intrinsics.b(property, "$receiver");
        if (t == null) {
            property = property.isNull();
            if (property != null) {
                return property;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.raizlabs.android.dbflow.sql.language.Operator<T>");
        }
        property = property.eq((Object) t);
        Intrinsics.a(property, "this.eq(value)");
        return property;
    }
}
