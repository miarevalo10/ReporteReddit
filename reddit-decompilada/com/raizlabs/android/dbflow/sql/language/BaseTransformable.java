package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.List;

public abstract class BaseTransformable<TModel> extends BaseModelQueriable<TModel> implements Transformable<TModel>, WhereBase<TModel> {
    protected BaseTransformable(Class<TModel> cls) {
        super(cls);
    }

    public Where<TModel> where(SQLOperator... sQLOperatorArr) {
        return new Where(this, sQLOperatorArr);
    }

    public FlowCursor query() {
        return where(new SQLOperator[0]).query();
    }

    public FlowCursor query(DatabaseWrapper databaseWrapper) {
        return where(new SQLOperator[0]).query(databaseWrapper);
    }

    public Where<TModel> groupBy(NameAlias... nameAliasArr) {
        return where(new SQLOperator[0]).groupBy(nameAliasArr);
    }

    public Where<TModel> groupBy(IProperty... iPropertyArr) {
        return where(new SQLOperator[0]).groupBy(iPropertyArr);
    }

    public Where<TModel> orderBy(NameAlias nameAlias, boolean z) {
        return where(new SQLOperator[0]).orderBy(nameAlias, z);
    }

    public Where<TModel> orderBy(IProperty iProperty, boolean z) {
        return where(new SQLOperator[0]).orderBy(iProperty, z);
    }

    public Where<TModel> orderByAll(List<OrderBy> list) {
        return where(new SQLOperator[0]).orderByAll(list);
    }

    public Where<TModel> orderBy(OrderBy orderBy) {
        return where(new SQLOperator[0]).orderBy(orderBy);
    }

    public Where<TModel> limit(int i) {
        return where(new SQLOperator[0]).limit(i);
    }

    public Where<TModel> offset(int i) {
        return where(new SQLOperator[0]).offset(i);
    }

    public Where<TModel> having(SQLOperator... sQLOperatorArr) {
        return where(new SQLOperator[0]).having(sQLOperatorArr);
    }

    public List<TModel> queryList() {
        checkSelect("query");
        return super.queryList();
    }

    public TModel querySingle() {
        checkSelect("query");
        limit(1);
        return super.querySingle();
    }

    private void checkSelect(String str) {
        if (!(getQueryBuilderBase() instanceof Select)) {
            StringBuilder stringBuilder = new StringBuilder("Please use ");
            stringBuilder.append(str);
            stringBuilder.append("(). The beginning is not a Select");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
