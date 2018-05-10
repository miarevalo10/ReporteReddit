package com.raizlabs.android.dbflow.sql.language.property;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.BaseModelQueriable;
import com.raizlabs.android.dbflow.sql.language.IConditional;
import com.raizlabs.android.dbflow.sql.language.IOperator;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.NameAlias.Builder;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.Operator.Between;
import com.raizlabs.android.dbflow.sql.language.Operator.In;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.raizlabs.android.dbflow.sql.language.OrderBy;
import java.util.Collection;

public class Property<T> implements IConditional, IOperator<T>, IProperty<Property<T>> {
    public static final Property<String> ALL_PROPERTY = new Property(null, NameAlias.rawBuilder(Operation.MULTIPLY).build());
    public static final Property<?> WILDCARD = new Property(null, NameAlias.rawBuilder(Operation.EMPTY_PARAM).build());
    protected NameAlias nameAlias;
    final Class<?> table;

    public static Property<String> allProperty(Class<?> cls) {
        return new Property((Class) cls, NameAlias.rawBuilder(Operation.MULTIPLY).build()).withTable();
    }

    public Property(Class<?> cls, NameAlias nameAlias) {
        this.table = cls;
        this.nameAlias = nameAlias;
    }

    public Property(Class<?> cls, String str) {
        this.table = cls;
        if (str != null) {
            this.nameAlias = new Builder(str).build();
        }
    }

    public Property(Class<?> cls, String str, String str2) {
        this((Class) cls, NameAlias.builder(str).as(str2).build());
    }

    public Property<T> withTable() {
        return withTable(new Builder(FlowManager.getTableName(this.table)).build());
    }

    public NameAlias getNameAlias() {
        return this.nameAlias;
    }

    public String getQuery() {
        return getNameAlias().getQuery();
    }

    public String getCursorKey() {
        return getNameAlias().getQuery();
    }

    public String getDefinition() {
        return getNameAlias().getFullQuery();
    }

    public String toString() {
        return getNameAlias().toString();
    }

    public Operator is(IConditional iConditional) {
        return getCondition().is(iConditional);
    }

    public Operator eq(IConditional iConditional) {
        return getCondition().eq(iConditional);
    }

    public Operator isNot(IConditional iConditional) {
        return getCondition().isNot(iConditional);
    }

    public Operator notEq(IConditional iConditional) {
        return getCondition().notEq(iConditional);
    }

    public Operator like(IConditional iConditional) {
        return getCondition().like(iConditional);
    }

    public Operator glob(IConditional iConditional) {
        return getCondition().glob(iConditional);
    }

    public Operator<T> like(String str) {
        return getCondition().like(str);
    }

    public Operator<T> notLike(String str) {
        return getCondition().notLike(str);
    }

    public Operator<T> glob(String str) {
        return getCondition().glob(str);
    }

    public Operator greaterThan(IConditional iConditional) {
        return getCondition().greaterThan(iConditional);
    }

    public Operator greaterThanOrEq(IConditional iConditional) {
        return getCondition().greaterThanOrEq(iConditional);
    }

    public Operator lessThan(IConditional iConditional) {
        return getCondition().lessThan(iConditional);
    }

    public Operator lessThanOrEq(IConditional iConditional) {
        return getCondition().lessThanOrEq(iConditional);
    }

    public Between between(IConditional iConditional) {
        return getCondition().between(iConditional);
    }

    public In in(IConditional iConditional, IConditional... iConditionalArr) {
        return getCondition().in(iConditional, iConditionalArr);
    }

    public In notIn(IConditional iConditional, IConditional... iConditionalArr) {
        return getCondition().notIn(iConditional, iConditionalArr);
    }

    public Operator is(BaseModelQueriable baseModelQueriable) {
        return getCondition().is(baseModelQueriable);
    }

    public Operator isNull() {
        return getCondition().isNull();
    }

    public Operator eq(BaseModelQueriable baseModelQueriable) {
        return getCondition().eq(baseModelQueriable);
    }

    public Operator isNot(BaseModelQueriable baseModelQueriable) {
        return getCondition().isNot(baseModelQueriable);
    }

    public Operator isNotNull() {
        return getCondition().isNotNull();
    }

    public Operator notEq(BaseModelQueriable baseModelQueriable) {
        return getCondition().notEq(baseModelQueriable);
    }

    public Operator like(BaseModelQueriable baseModelQueriable) {
        return getCondition().like(baseModelQueriable);
    }

    public Operator notLike(IConditional iConditional) {
        return getCondition().notLike(iConditional);
    }

    public Operator notLike(BaseModelQueriable baseModelQueriable) {
        return getCondition().notLike(baseModelQueriable);
    }

    public Operator glob(BaseModelQueriable baseModelQueriable) {
        return getCondition().glob(baseModelQueriable);
    }

    public Operator greaterThan(BaseModelQueriable baseModelQueriable) {
        return getCondition().greaterThan(baseModelQueriable);
    }

    public Operator greaterThanOrEq(BaseModelQueriable baseModelQueriable) {
        return getCondition().greaterThanOrEq(baseModelQueriable);
    }

    public Operator lessThan(BaseModelQueriable baseModelQueriable) {
        return getCondition().lessThan(baseModelQueriable);
    }

    public Operator lessThanOrEq(BaseModelQueriable baseModelQueriable) {
        return getCondition().lessThanOrEq(baseModelQueriable);
    }

    public Between between(BaseModelQueriable baseModelQueriable) {
        return getCondition().between(baseModelQueriable);
    }

    public In in(BaseModelQueriable baseModelQueriable, BaseModelQueriable... baseModelQueriableArr) {
        return getCondition().in(baseModelQueriable, baseModelQueriableArr);
    }

    public In notIn(BaseModelQueriable baseModelQueriable, BaseModelQueriable... baseModelQueriableArr) {
        return getCondition().notIn(baseModelQueriable, baseModelQueriableArr);
    }

    public Operator concatenate(IConditional iConditional) {
        return getCondition().concatenate(iConditional);
    }

    public Operator plus(BaseModelQueriable baseModelQueriable) {
        return getCondition().plus(baseModelQueriable);
    }

    public Operator minus(BaseModelQueriable baseModelQueriable) {
        return getCondition().minus(baseModelQueriable);
    }

    public Operator div(BaseModelQueriable baseModelQueriable) {
        return getCondition().div(baseModelQueriable);
    }

    public Operator times(BaseModelQueriable baseModelQueriable) {
        return getCondition().times(baseModelQueriable);
    }

    public Operator rem(BaseModelQueriable baseModelQueriable) {
        return getCondition().rem(baseModelQueriable);
    }

    public Class<?> getTable() {
        return this.table;
    }

    public Property<T> plus(IProperty iProperty) {
        return new Property(this.table, NameAlias.joinNames(Operation.PLUS, this.nameAlias.fullName(), iProperty.toString()));
    }

    public Property<T> minus(IProperty iProperty) {
        return new Property(this.table, NameAlias.joinNames(Operation.MINUS, this.nameAlias.fullName(), iProperty.toString()));
    }

    public Property<T> div(IProperty iProperty) {
        return new Property(this.table, NameAlias.joinNames(Operation.DIVISION, this.nameAlias.fullName(), iProperty.toString()));
    }

    public Property<T> times(IProperty iProperty) {
        return new Property(this.table, NameAlias.joinNames(Operation.MULTIPLY, this.nameAlias.fullName(), iProperty.toString()));
    }

    public Property<T> rem(IProperty iProperty) {
        return new Property(this.table, NameAlias.joinNames(Operation.MOD, this.nameAlias.fullName(), iProperty.toString()));
    }

    public Property<T> concatenate(IProperty iProperty) {
        return new Property(this.table, NameAlias.joinNames(Operation.CONCATENATE, this.nameAlias.fullName(), iProperty.toString()));
    }

    public Property<T> as(String str) {
        return new Property(this.table, getNameAlias().newBuilder().as(str).build());
    }

    public Property<T> distinct() {
        return new Property(this.table, getDistinctAliasName());
    }

    public Property<T> withTable(NameAlias nameAlias) {
        return new Property(this.table, getNameAlias().newBuilder().withTable(nameAlias.getQuery()).build());
    }

    public Operator<T> is(T t) {
        return getCondition().is((Object) t);
    }

    public Operator<T> eq(T t) {
        return getCondition().eq((Object) t);
    }

    public Operator<T> isNot(T t) {
        return getCondition().isNot((Object) t);
    }

    public Operator<T> notEq(T t) {
        return getCondition().notEq((Object) t);
    }

    public Operator<T> greaterThan(T t) {
        return getCondition().greaterThan((Object) t);
    }

    public Operator<T> greaterThanOrEq(T t) {
        return getCondition().greaterThanOrEq((Object) t);
    }

    public Operator<T> lessThan(T t) {
        return getCondition().lessThan((Object) t);
    }

    public Operator<T> lessThanOrEq(T t) {
        return getCondition().lessThanOrEq((Object) t);
    }

    public Between<T> between(T t) {
        return getCondition().between((Object) t);
    }

    public In<T> in(T t, T... tArr) {
        return getCondition().in((Object) t, (Object[]) tArr);
    }

    public In<T> notIn(T t, T... tArr) {
        return getCondition().notIn((Object) t, (Object[]) tArr);
    }

    public In<T> in(Collection<T> collection) {
        return getCondition().in(collection);
    }

    public In<T> notIn(Collection<T> collection) {
        return getCondition().notIn(collection);
    }

    public Operator<T> concatenate(T t) {
        return getCondition().concatenate((Object) t);
    }

    public Operator<T> plus(T t) {
        return getCondition().plus((Object) t);
    }

    public Operator<T> minus(T t) {
        return getCondition().minus((Object) t);
    }

    public Operator<T> div(T t) {
        return getCondition().div((Object) t);
    }

    public Operator<T> times(T t) {
        return getCondition().times((Object) t);
    }

    public Operator<T> rem(T t) {
        return getCondition().rem((Object) t);
    }

    public OrderBy asc() {
        return OrderBy.fromProperty(this).ascending();
    }

    public OrderBy desc() {
        return OrderBy.fromProperty(this).descending();
    }

    protected NameAlias getDistinctAliasName() {
        return getNameAlias().newBuilder().distinct().build();
    }

    protected Operator<T> getCondition() {
        return Operator.op(getNameAlias());
    }
}
