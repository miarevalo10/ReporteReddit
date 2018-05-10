package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import java.util.ArrayList;
import java.util.List;

public class Case<TReturn> implements Query {
    private IProperty caseColumn;
    private List<CaseCondition<TReturn>> caseConditions = new ArrayList();
    private String columnName;
    private boolean efficientCase = false;
    private boolean elseSpecified = false;
    private TReturn elseValue;
    private boolean endSpecified = false;

    Case() {
    }

    Case(IProperty iProperty) {
        this.caseColumn = iProperty;
        if (iProperty != null) {
            this.efficientCase = true;
        }
    }

    public CaseCondition<TReturn> when(SQLOperator sQLOperator) {
        if (this.efficientCase) {
            throw new IllegalStateException("When using the efficient CASE method,you must pass in value only, not condition.");
        }
        CaseCondition<TReturn> caseCondition = new CaseCondition(this, sQLOperator);
        this.caseConditions.add(caseCondition);
        return caseCondition;
    }

    public CaseCondition<TReturn> when(TReturn tReturn) {
        if (this.efficientCase) {
            CaseCondition<TReturn> caseCondition = new CaseCondition(this, (Object) tReturn);
            this.caseConditions.add(caseCondition);
            return caseCondition;
        }
        throw new IllegalStateException("When not using the efficient CASE method, you must pass in the SQLOperator as a parameter");
    }

    public CaseCondition<TReturn> when(IProperty iProperty) {
        if (this.efficientCase) {
            CaseCondition<TReturn> caseCondition = new CaseCondition(this, iProperty);
            this.caseConditions.add(caseCondition);
            return caseCondition;
        }
        throw new IllegalStateException("When not using the efficient CASE method, you must pass in the SQLOperator as a parameter");
    }

    public Case<TReturn> _else(TReturn tReturn) {
        this.elseValue = tReturn;
        this.elseSpecified = true;
        return this;
    }

    public Property<Case<TReturn>> end(String str) {
        this.endSpecified = true;
        if (str != null) {
            this.columnName = QueryBuilder.quoteIfNeeded(str);
        }
        return new Property(null, NameAlias.rawBuilder(getQuery()).build());
    }

    public Property<Case<TReturn>> end() {
        return end(null);
    }

    public Operator endAsOperator() {
        return Operator.op(end().getNameAlias());
    }

    boolean isEfficientCase() {
        return this.efficientCase;
    }

    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder(" CASE");
        if (isEfficientCase()) {
            StringBuilder stringBuilder = new StringBuilder(" ");
            stringBuilder.append(BaseOperator.convertValueToString(this.caseColumn, false));
            queryBuilder.append(stringBuilder.toString());
        }
        queryBuilder.append(QueryBuilder.join((CharSequence) "", this.caseConditions));
        if (this.elseSpecified) {
            queryBuilder.append(" ELSE ").append(BaseOperator.convertValueToString(this.elseValue, false));
        }
        if (this.endSpecified) {
            stringBuilder = new StringBuilder(" END ");
            stringBuilder.append(this.columnName != null ? this.columnName : "");
            queryBuilder.append(stringBuilder.toString());
        }
        return queryBuilder.getQuery();
    }
}
