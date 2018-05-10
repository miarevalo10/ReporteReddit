package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;

public class SQLite {
    public static Select select(IProperty... iPropertyArr) {
        return new Select(iPropertyArr);
    }

    public static Select selectCountOf(IProperty... iPropertyArr) {
        return new Select(Method.count(iPropertyArr));
    }

    public static <TModel> Update<TModel> update(Class<TModel> cls) {
        return new Update(cls);
    }

    public static <TModel> Insert<TModel> insert(Class<TModel> cls) {
        return new Insert(cls);
    }

    public static Delete delete() {
        return new Delete();
    }

    public static <TModel> From<TModel> delete(Class<TModel> cls) {
        return delete().from(cls);
    }

    public static <TModel> Index<TModel> index(String str) {
        return new Index(str);
    }

    public static Trigger createTrigger(String str) {
        return Trigger.create(str);
    }

    public static <TReturn> CaseCondition<TReturn> caseWhen(SQLOperator sQLOperator) {
        return new Case().when(sQLOperator);
    }

    public static <TReturn> Case<TReturn> _case(Property<TReturn> property) {
        return new Case(property);
    }

    public static <TReturn> Case<TReturn> _case(IProperty iProperty) {
        return new Case(iProperty);
    }
}
