package com.raizlabs.android.dbflow.sql.language.property;

import com.raizlabs.android.dbflow.converter.TypeConverter;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Operator;

public class TypeConvertedProperty<T, V> extends Property<V> {
    private boolean convertToDB;
    private TypeConvertedProperty<V, T> databaseProperty;
    private final TypeConverterGetter getter;

    public interface TypeConverterGetter {
        TypeConverter getTypeConverter(Class<?> cls);
    }

    class C14691 implements TypeConverterGetter {
        C14691() {
        }

        public TypeConverter getTypeConverter(Class<?> cls) {
            return TypeConvertedProperty.this.getter.getTypeConverter(cls);
        }
    }

    public TypeConvertedProperty(Class<?> cls, NameAlias nameAlias, boolean z, TypeConverterGetter typeConverterGetter) {
        super((Class) cls, nameAlias);
        this.convertToDB = z;
        this.getter = typeConverterGetter;
    }

    public TypeConvertedProperty(Class<?> cls, String str, boolean z, TypeConverterGetter typeConverterGetter) {
        super((Class) cls, str);
        this.convertToDB = z;
        this.getter = typeConverterGetter;
    }

    protected Operator<V> getCondition() {
        return Operator.op(getNameAlias(), this.getter.getTypeConverter(this.table), this.convertToDB);
    }

    public Property<T> invertProperty() {
        if (this.databaseProperty == null) {
            this.databaseProperty = new TypeConvertedProperty(this.table, this.nameAlias, this.convertToDB ^ 1, new C14691());
        }
        return this.databaseProperty;
    }

    public Property<V> withTable(NameAlias nameAlias) {
        return new TypeConvertedProperty(getTable(), getNameAlias().newBuilder().withTable(nameAlias.getQuery()).build(), this.convertToDB, this.getter);
    }
}
