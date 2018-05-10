package com.raizlabs.android.dbflow.sql.language.property;

import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;

public class PropertyFactory {
    public static Property<Character> from(char c) {
        StringBuilder stringBuilder = new StringBuilder("'");
        stringBuilder.append(c);
        stringBuilder.append("'");
        return new Property(null, NameAlias.rawBuilder(stringBuilder.toString()).build());
    }

    public static Property<Integer> from(int i) {
        return new Property(null, NameAlias.rawBuilder(String.valueOf(i)).build());
    }

    public static Property<Double> from(double d) {
        return new Property(null, NameAlias.rawBuilder(String.valueOf(d)).build());
    }

    public static Property<Long> from(long j) {
        return new Property(null, NameAlias.rawBuilder(String.valueOf(j)).build());
    }

    public static Property<Float> from(float f) {
        return new Property(null, NameAlias.rawBuilder(String.valueOf(f)).build());
    }

    public static Property<Short> from(short s) {
        return new Property(null, NameAlias.rawBuilder(String.valueOf(s)).build());
    }

    public static Property<Byte> from(byte b) {
        return new Property(null, NameAlias.rawBuilder(String.valueOf(b)).build());
    }

    public static <T> Property<T> from(T t) {
        return new Property(null, NameAlias.rawBuilder(Operator.convertValueToString(t)).build());
    }

    public static <TModel> Property<TModel> from(ModelQueriable<TModel> modelQueriable) {
        Class table = modelQueriable.getTable();
        StringBuilder stringBuilder = new StringBuilder("(");
        stringBuilder.append(String.valueOf(modelQueriable.getQuery()).trim());
        stringBuilder.append(")");
        return from(table, stringBuilder.toString());
    }

    public static <T> Property<T> from(Class<T> cls, String str) {
        return new Property(null, NameAlias.rawBuilder(str).build());
    }
}
