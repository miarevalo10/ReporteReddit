package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.language.Operator.Between;
import com.raizlabs.android.dbflow.sql.language.Operator.In;
import java.util.Collection;

public interface IOperator<T> extends Query, IConditional {
    Between<T> between(T t);

    Operator<T> concatenate(T t);

    Operator<T> div(T t);

    Operator<T> eq(T t);

    Operator<T> greaterThan(T t);

    Operator<T> greaterThanOrEq(T t);

    In<T> in(T t, T... tArr);

    In<T> in(Collection<T> collection);

    Operator<T> is(T t);

    Operator<T> isNot(T t);

    Operator<T> lessThan(T t);

    Operator<T> lessThanOrEq(T t);

    Operator<T> minus(T t);

    Operator<T> notEq(T t);

    In<T> notIn(T t, T... tArr);

    In<T> notIn(Collection<T> collection);

    Operator<T> plus(T t);

    Operator<T> rem(T t);

    Operator<T> times(T t);
}
