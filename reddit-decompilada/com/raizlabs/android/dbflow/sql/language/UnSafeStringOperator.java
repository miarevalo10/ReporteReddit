package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.StringUtils;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;

public class UnSafeStringOperator implements Query, SQLOperator {
    private final String conditionString;
    private String separator = "";

    public String columnName() {
        return "";
    }

    public String operation() {
        return "";
    }

    public Object value() {
        return "";
    }

    public UnSafeStringOperator(String str, String[] strArr) {
        if (str != null) {
            for (String replaceFirst : strArr) {
                str = str.replaceFirst("\\?", replaceFirst);
            }
        }
        this.conditionString = str;
    }

    public void appendConditionToQuery(QueryBuilder queryBuilder) {
        queryBuilder.append(this.conditionString);
    }

    public String separator() {
        return this.separator;
    }

    public SQLOperator separator(String str) {
        this.separator = str;
        return this;
    }

    public boolean hasSeparator() {
        return StringUtils.isNotNullOrEmpty(this.separator);
    }

    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder();
        appendConditionToQuery(queryBuilder);
        return queryBuilder.getQuery();
    }
}
