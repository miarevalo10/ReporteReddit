package com.raizlabs.android.dbflow.sql.language;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import com.raizlabs.android.dbflow.structure.BaseModel.Action;

public class Set<TModel> extends BaseTransformable<TModel> implements WhereBase<TModel> {
    private OperatorGroup operatorGroup = OperatorGroup.nonGroupingClause().setAllCommaSeparated(true);
    private Query update;

    public Set(Query query, Class<TModel> cls) {
        super(cls);
        this.update = query;
    }

    public Set<TModel> conditions(SQLOperator... sQLOperatorArr) {
        this.operatorGroup.andAll(sQLOperatorArr);
        return this;
    }

    public Set<TModel> conditionValues(ContentValues contentValues) {
        SqlUtils.addContentValues(contentValues, this.operatorGroup);
        return this;
    }

    public String getQuery() {
        return new QueryBuilder(this.update.getQuery()).append("SET ").append(this.operatorGroup.getQuery()).appendSpace().getQuery();
    }

    public Query getQueryBuilderBase() {
        return this.update;
    }

    public Action getPrimaryAction() {
        return Action.UPDATE;
    }
}
