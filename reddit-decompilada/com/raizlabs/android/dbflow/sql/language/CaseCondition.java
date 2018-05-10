package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;

public class CaseCondition<TReturn> implements Query {
    private final Case<TReturn> caze;
    private boolean isThenPropertySet;
    private IProperty property;
    private SQLOperator sqlOperator;
    private IProperty thenProperty;
    private TReturn thenValue;
    private TReturn whenValue;

    CaseCondition(Case<TReturn> caseR, SQLOperator sQLOperator) {
        this.caze = caseR;
        this.sqlOperator = sQLOperator;
    }

    CaseCondition(Case<TReturn> caseR, TReturn tReturn) {
        this.caze = caseR;
        this.whenValue = tReturn;
    }

    CaseCondition(Case<TReturn> caseR, IProperty iProperty) {
        this.caze = caseR;
        this.property = iProperty;
    }

    public Case<TReturn> then(TReturn tReturn) {
        this.thenValue = tReturn;
        return this.caze;
    }

    public Case<TReturn> then(IProperty iProperty) {
        this.thenProperty = iProperty;
        this.isThenPropertySet = true;
        return this.caze;
    }

    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder(" WHEN ");
        if (this.caze.isEfficientCase()) {
            queryBuilder.append(BaseOperator.convertValueToString(this.property != null ? this.property : this.whenValue, false));
        } else {
            this.sqlOperator.appendConditionToQuery(queryBuilder);
        }
        queryBuilder.append(" THEN ").append(BaseOperator.convertValueToString(this.isThenPropertySet ? this.thenProperty : this.thenValue, false));
        return queryBuilder.getQuery();
    }

    public String toString() {
        return getQuery();
    }
}
