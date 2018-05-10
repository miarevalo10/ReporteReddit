package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00040\u0003B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006¢\u0006\u0002\u0010\bJ%\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u00022\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0002J-\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00022\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u0002R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/raizlabs/android/dbflow/kotlinextensions/OneToMany;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "", "query", "Lkotlin/Function0;", "Lcom/raizlabs/android/dbflow/sql/queriable/ModelQueriable;", "(Lkotlin/jvm/functions/Function0;)V", "list", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "dbflow-kotlinextensions_release"}, k = 1, mv = {1, 1, 7})
/* compiled from: OneToManyExtensions.kt */
public final class OneToMany<T> implements ReadWriteProperty<Object, List<? extends T>> {
    private List<? extends T> list;
    private final Function0<ModelQueriable<T>> query;

    public OneToMany(Function0<? extends ModelQueriable<T>> function0) {
        Intrinsics.b(function0, "query");
        this.query = function0;
    }

    public final List<T> getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics.b(obj, "thisRef");
        Intrinsics.b(kProperty, "property");
        obj = this.list;
        if (obj == null || obj.isEmpty() != null) {
            this.list = ((ModelQueriable) this.query.invoke()).queryList();
        }
        return this.list;
    }

    public final void setValue(Object obj, KProperty<?> kProperty, List<? extends T> list) {
        Intrinsics.b(obj, "thisRef");
        Intrinsics.b(kProperty, "property");
        this.list = list;
    }
}
