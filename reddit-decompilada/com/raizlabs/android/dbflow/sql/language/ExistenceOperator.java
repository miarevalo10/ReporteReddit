package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;

public class ExistenceOperator implements Query, SQLOperator {
    private Where innerWhere;

    public boolean hasSeparator() {
        return false;
    }

    public String operation() {
        return "";
    }

    public void appendConditionToQuery(QueryBuilder queryBuilder) {
        StringBuilder stringBuilder = new StringBuilder("(");
        stringBuilder.append(this.innerWhere.getQuery().trim());
        stringBuilder.append(")");
        queryBuilder.appendQualifier("EXISTS", stringBuilder.toString());
    }

    public String columnName() {
        throw new RuntimeException("Method not valid for ExistenceOperator");
    }

    public String separator() {
        throw new RuntimeException("Method not valid for ExistenceOperator");
    }

    public SQLOperator separator(String str) {
        throw new RuntimeException("Method not valid for ExistenceOperator");
    }

    public Object value() {
        return this.innerWhere;
    }

    public ExistenceOperator where(Where where) {
        this.innerWhere = where;
        return this;
    }

    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder();
        appendConditionToQuery(queryBuilder);
        return queryBuilder.getQuery();
    }
}
