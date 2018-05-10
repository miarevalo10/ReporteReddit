package com.raizlabs.android.dbflow.sql.language.property;

import com.raizlabs.android.dbflow.sql.language.NameAlias;

public class WrapperProperty<T, V> extends Property<V> {
    private WrapperProperty<V, T> databaseProperty;

    public WrapperProperty(Class<?> cls, NameAlias nameAlias) {
        super((Class) cls, nameAlias);
    }

    public WrapperProperty(Class<?> cls, String str) {
        super((Class) cls, str);
    }

    public Property<T> invertProperty() {
        if (this.databaseProperty == null) {
            this.databaseProperty = new WrapperProperty(this.table, this.nameAlias);
        }
        return this.databaseProperty;
    }
}
