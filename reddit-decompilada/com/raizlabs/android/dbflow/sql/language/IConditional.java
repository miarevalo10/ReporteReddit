package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.language.Operator.Between;
import com.raizlabs.android.dbflow.sql.language.Operator.In;

public interface IConditional extends Query {
    Between between(BaseModelQueriable baseModelQueriable);

    Between between(IConditional iConditional);

    Operator concatenate(IConditional iConditional);

    Operator div(BaseModelQueriable baseModelQueriable);

    Operator eq(BaseModelQueriable baseModelQueriable);

    Operator eq(IConditional iConditional);

    Operator glob(BaseModelQueriable baseModelQueriable);

    Operator glob(IConditional iConditional);

    Operator glob(String str);

    Operator greaterThan(BaseModelQueriable baseModelQueriable);

    Operator greaterThan(IConditional iConditional);

    Operator greaterThanOrEq(BaseModelQueriable baseModelQueriable);

    Operator greaterThanOrEq(IConditional iConditional);

    In in(BaseModelQueriable baseModelQueriable, BaseModelQueriable... baseModelQueriableArr);

    In in(IConditional iConditional, IConditional... iConditionalArr);

    Operator is(BaseModelQueriable baseModelQueriable);

    Operator is(IConditional iConditional);

    Operator isNot(BaseModelQueriable baseModelQueriable);

    Operator isNot(IConditional iConditional);

    Operator isNotNull();

    Operator isNull();

    Operator lessThan(BaseModelQueriable baseModelQueriable);

    Operator lessThan(IConditional iConditional);

    Operator lessThanOrEq(BaseModelQueriable baseModelQueriable);

    Operator lessThanOrEq(IConditional iConditional);

    Operator like(BaseModelQueriable baseModelQueriable);

    Operator like(IConditional iConditional);

    Operator like(String str);

    Operator minus(BaseModelQueriable baseModelQueriable);

    Operator notEq(BaseModelQueriable baseModelQueriable);

    Operator notEq(IConditional iConditional);

    In notIn(BaseModelQueriable baseModelQueriable, BaseModelQueriable... baseModelQueriableArr);

    In notIn(IConditional iConditional, IConditional... iConditionalArr);

    Operator notLike(BaseModelQueriable baseModelQueriable);

    Operator notLike(IConditional iConditional);

    Operator notLike(String str);

    Operator plus(BaseModelQueriable baseModelQueriable);

    Operator rem(BaseModelQueriable baseModelQueriable);

    Operator times(BaseModelQueriable baseModelQueriable);
}
