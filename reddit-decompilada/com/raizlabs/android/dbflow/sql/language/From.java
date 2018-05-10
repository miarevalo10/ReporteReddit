package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.Join.JoinType;
import com.raizlabs.android.dbflow.sql.language.NameAlias.Builder;
import com.raizlabs.android.dbflow.sql.language.property.IndexProperty;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.structure.BaseModel.Action;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class From<TModel> extends BaseTransformable<TModel> {
    private final List<Join> joins = new ArrayList();
    private Query queryBase;
    private NameAlias tableAlias;

    private NameAlias getTableAlias() {
        if (this.tableAlias == null) {
            this.tableAlias = new Builder(FlowManager.getTableName(getTable())).build();
        }
        return this.tableAlias;
    }

    public From(Query query, Class<TModel> cls) {
        super(cls);
        this.queryBase = query;
    }

    public From<TModel> as(String str) {
        this.tableAlias = getTableAlias().newBuilder().as(str).build();
        return this;
    }

    public <TJoin> Join<TJoin, TModel> join(Class<TJoin> cls, JoinType joinType) {
        Join<TJoin, TModel> join = new Join(this, (Class) cls, joinType);
        this.joins.add(join);
        return join;
    }

    public <TJoin> Join<TJoin, TModel> join(ModelQueriable<TJoin> modelQueriable, JoinType joinType) {
        Join<TJoin, TModel> join = new Join(this, joinType, (ModelQueriable) modelQueriable);
        this.joins.add(join);
        return join;
    }

    public <TJoin> Join<TJoin, TModel> crossJoin(Class<TJoin> cls) {
        return join((Class) cls, JoinType.CROSS);
    }

    public <TJoin> Join<TJoin, TModel> crossJoin(ModelQueriable<TJoin> modelQueriable) {
        return join((ModelQueriable) modelQueriable, JoinType.CROSS);
    }

    public <TJoin> Join<TJoin, TModel> innerJoin(Class<TJoin> cls) {
        return join((Class) cls, JoinType.INNER);
    }

    public <TJoin> Join<TJoin, TModel> innerJoin(ModelQueriable<TJoin> modelQueriable) {
        return join((ModelQueriable) modelQueriable, JoinType.INNER);
    }

    public <TJoin> Join<TJoin, TModel> leftOuterJoin(Class<TJoin> cls) {
        return join((Class) cls, JoinType.LEFT_OUTER);
    }

    public <TJoin> Join<TJoin, TModel> leftOuterJoin(ModelQueriable<TJoin> modelQueriable) {
        return join((ModelQueriable) modelQueriable, JoinType.LEFT_OUTER);
    }

    public <TJoin> Join<TJoin, TModel> naturalJoin(Class<TJoin> cls) {
        return join((Class) cls, JoinType.NATURAL);
    }

    public <TJoin> Join<TJoin, TModel> naturalJoin(ModelQueriable<TJoin> modelQueriable) {
        return join((ModelQueriable) modelQueriable, JoinType.NATURAL);
    }

    public IndexedBy<TModel> indexedBy(IndexProperty<TModel> indexProperty) {
        return new IndexedBy(indexProperty, this);
    }

    public Action getPrimaryAction() {
        return this.queryBase instanceof Delete ? Action.DELETE : Action.CHANGE;
    }

    public String getQuery() {
        QueryBuilder append = new QueryBuilder().append(this.queryBase.getQuery());
        if (!(this.queryBase instanceof Update)) {
            append.append("FROM ");
        }
        append.append(getTableAlias());
        if (this.queryBase instanceof Select) {
            if (!this.joins.isEmpty()) {
                append.appendSpace();
            }
            for (Join query : this.joins) {
                append.append(query.getQuery());
            }
        } else {
            append.appendSpace();
        }
        return append.getQuery();
    }

    public Query getQueryBuilderBase() {
        return this.queryBase;
    }

    public Set<Class<?>> getAssociatedTables() {
        Set<Class<?>> linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(getTable());
        for (Join table : this.joins) {
            linkedHashSet.add(table.getTable());
        }
        return linkedHashSet;
    }
}
