package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.annotation.Collate;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.converter.TypeConverter;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Operator<T> extends BaseOperator implements IOperator<T> {
    private boolean convertToDB;
    private TypeConverter typeConverter;

    public static class Operation {
        public static final String AND = "AND";
        public static final String BETWEEN = "BETWEEN";
        public static final String CONCATENATE = "||";
        public static final String DIVISION = "/";
        public static final String EMPTY_PARAM = "?";
        public static final String EQUALS = "=";
        public static final String GLOB = "GLOB";
        public static final String GREATER_THAN = ">";
        public static final String GREATER_THAN_OR_EQUALS = ">=";
        public static final String IN = "IN";
        public static final String IS_NOT_NULL = "IS NOT NULL";
        public static final String IS_NULL = "IS NULL";
        public static final String LESS_THAN = "<";
        public static final String LESS_THAN_OR_EQUALS = "<=";
        public static final String LIKE = "LIKE";
        public static final String MINUS = "-";
        public static final String MOD = "%";
        public static final String MULTIPLY = "*";
        public static final String NOT_EQUALS = "!=";
        public static final String NOT_IN = "NOT IN";
        public static final String NOT_LIKE = "NOT LIKE";
        public static final String OR = "OR";
        public static final String PLUS = "+";
    }

    public static class Between<T> extends BaseOperator implements Query {
        private T secondValue;

        private Between(Operator<T> operator, T t) {
            super(operator.nameAlias);
            this.operation = String.format(" %1s ", new Object[]{Operation.BETWEEN});
            this.value = t;
            this.isValueSet = true;
            this.postArg = operator.postArgument();
        }

        public Between<T> and(T t) {
            this.secondValue = t;
            return this;
        }

        public T secondValue() {
            return this.secondValue;
        }

        public void appendConditionToQuery(QueryBuilder queryBuilder) {
            queryBuilder.append(columnName()).append(operation()).append(convertObjectToString(value(), true)).appendSpaceSeparated(Operation.AND).append(convertObjectToString(secondValue(), true)).appendSpace().appendOptional(postArgument());
        }

        public String getQuery() {
            QueryBuilder queryBuilder = new QueryBuilder();
            appendConditionToQuery(queryBuilder);
            return queryBuilder.getQuery();
        }
    }

    public static class In<T> extends BaseOperator implements Query {
        private List<T> inArguments;

        @SafeVarargs
        private In(Operator<T> operator, T t, boolean z, T... tArr) {
            super(operator.columnAlias());
            this.inArguments = new ArrayList();
            this.inArguments.add(t);
            Collections.addAll(this.inArguments, tArr);
            operator = " %1s ";
            t = new Object[1];
            t[null] = z ? Operation.IN : Operation.NOT_IN;
            this.operation = String.format(operator, t);
        }

        private In(Operator<T> operator, Collection<T> collection, boolean z) {
            super(operator.columnAlias());
            this.inArguments = new ArrayList();
            this.inArguments.addAll(collection);
            operator = " %1s ";
            collection = new Object[1];
            collection[0] = z ? Operation.IN : Operation.NOT_IN;
            this.operation = String.format(operator, collection);
        }

        public In<T> and(T t) {
            this.inArguments.add(t);
            return this;
        }

        public void appendConditionToQuery(QueryBuilder queryBuilder) {
            queryBuilder.append(columnName()).append(operation()).append("(").append(BaseOperator.joinArguments(",", this.inArguments, this)).append(")");
        }

        public String getQuery() {
            QueryBuilder queryBuilder = new QueryBuilder();
            appendConditionToQuery(queryBuilder);
            return queryBuilder.getQuery();
        }
    }

    public static String convertValueToString(Object obj) {
        return BaseOperator.convertValueToString(obj, false);
    }

    public static <T> Operator<T> op(NameAlias nameAlias) {
        return new Operator(nameAlias);
    }

    public static <T> Operator<T> op(NameAlias nameAlias, TypeConverter typeConverter, boolean z) {
        return new Operator(nameAlias, typeConverter, z);
    }

    Operator(NameAlias nameAlias) {
        super(nameAlias);
    }

    Operator(NameAlias nameAlias, TypeConverter typeConverter, boolean z) {
        super(nameAlias);
        this.typeConverter = typeConverter;
        this.convertToDB = z;
    }

    Operator(Operator operator) {
        super(operator.nameAlias);
        this.typeConverter = operator.typeConverter;
        this.convertToDB = operator.convertToDB;
        this.value = operator.value;
    }

    public void appendConditionToQuery(QueryBuilder queryBuilder) {
        queryBuilder.append(columnName()).append(operation());
        if (this.isValueSet) {
            queryBuilder.append(convertObjectToString(value(), true));
        }
        if (postArgument() != null) {
            queryBuilder.appendSpace().append(postArgument());
        }
    }

    public Operator<T> is(T t) {
        this.operation = Operation.EQUALS;
        return value(t);
    }

    public Operator<T> eq(T t) {
        return is((Object) t);
    }

    public Operator<T> isNot(T t) {
        this.operation = Operation.NOT_EQUALS;
        return value(t);
    }

    public Operator<T> notEq(T t) {
        return isNot((Object) t);
    }

    public Operator<T> like(String str) {
        this.operation = String.format(" %1s ", new Object[]{Operation.LIKE});
        return value(str);
    }

    public Operator<T> notLike(String str) {
        this.operation = String.format(" %1s ", new Object[]{Operation.NOT_LIKE});
        return value(str);
    }

    public Operator<T> glob(String str) {
        this.operation = String.format(" %1s ", new Object[]{Operation.GLOB});
        return value(str);
    }

    public Operator<T> value(Object obj) {
        this.value = obj;
        this.isValueSet = true;
        return this;
    }

    public Operator<T> greaterThan(T t) {
        this.operation = Operation.GREATER_THAN;
        return value(t);
    }

    public Operator<T> greaterThanOrEq(T t) {
        this.operation = Operation.GREATER_THAN_OR_EQUALS;
        return value(t);
    }

    public Operator<T> lessThan(T t) {
        this.operation = Operation.LESS_THAN;
        return value(t);
    }

    public Operator<T> lessThanOrEq(T t) {
        this.operation = Operation.LESS_THAN_OR_EQUALS;
        return value(t);
    }

    public Operator<T> plus(T t) {
        return assignValueOp(t, Operation.PLUS);
    }

    public Operator<T> minus(T t) {
        return assignValueOp(t, Operation.MINUS);
    }

    public Operator<T> div(T t) {
        return assignValueOp(t, Operation.DIVISION);
    }

    public Operator<T> times(T t) {
        return assignValueOp(t, Operation.MULTIPLY);
    }

    public Operator<T> rem(T t) {
        return assignValueOp(t, Operation.MOD);
    }

    public Operator<T> operation(String str) {
        this.operation = str;
        return this;
    }

    public Operator<T> collate(String str) {
        StringBuilder stringBuilder = new StringBuilder("COLLATE ");
        stringBuilder.append(str);
        this.postArg = stringBuilder.toString();
        return this;
    }

    public Operator<T> collate(Collate collate) {
        if (collate.equals(Collate.NONE)) {
            this.postArg = null;
        } else {
            collate(collate.name());
        }
        return this;
    }

    public Operator<T> postfix(String str) {
        this.postArg = str;
        return this;
    }

    public Operator<T> isNull() {
        this.operation = String.format(" %1s ", new Object[]{Operation.IS_NULL});
        return this;
    }

    public Operator<T> isNotNull() {
        this.operation = String.format(" %1s ", new Object[]{Operation.IS_NOT_NULL});
        return this;
    }

    public Operator<T> separator(String str) {
        this.separator = str;
        return this;
    }

    public Operator is(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.EQUALS);
    }

    public Operator eq(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.EQUALS);
    }

    public Operator isNot(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.NOT_EQUALS);
    }

    public Operator notEq(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.NOT_EQUALS);
    }

    public Operator<T> like(IConditional iConditional) {
        return like(iConditional.getQuery());
    }

    public Operator<T> glob(IConditional iConditional) {
        return glob(iConditional.getQuery());
    }

    public Operator<T> greaterThan(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.GREATER_THAN);
    }

    public Operator<T> greaterThanOrEq(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.GREATER_THAN_OR_EQUALS);
    }

    public Operator<T> lessThan(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.LESS_THAN);
    }

    public Operator<T> lessThanOrEq(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.LESS_THAN_OR_EQUALS);
    }

    public Between between(IConditional iConditional) {
        return new Between(iConditional);
    }

    public In in(IConditional iConditional, IConditional... iConditionalArr) {
        return new In(iConditional, true, iConditionalArr);
    }

    public In notIn(IConditional iConditional, IConditional... iConditionalArr) {
        return new In(iConditional, false, iConditionalArr);
    }

    public In notIn(BaseModelQueriable baseModelQueriable, BaseModelQueriable[] baseModelQueriableArr) {
        return new In(baseModelQueriable, false, (Object[]) baseModelQueriableArr);
    }

    public Operator is(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.EQUALS);
    }

    public Operator eq(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.EQUALS);
    }

    public Operator isNot(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.NOT_EQUALS);
    }

    public Operator notEq(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.NOT_EQUALS);
    }

    public Operator<T> like(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.LIKE);
    }

    public Operator notLike(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.NOT_LIKE);
    }

    public Operator notLike(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.NOT_LIKE);
    }

    public Operator<T> glob(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.GLOB);
    }

    public Operator<T> greaterThan(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.GREATER_THAN);
    }

    public Operator<T> greaterThanOrEq(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.GREATER_THAN_OR_EQUALS);
    }

    public Operator<T> lessThan(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.LESS_THAN);
    }

    public Operator<T> lessThanOrEq(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.LESS_THAN_OR_EQUALS);
    }

    public Operator plus(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.PLUS);
    }

    public Operator minus(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.MINUS);
    }

    public Operator div(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.DIVISION);
    }

    public Operator times(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.MULTIPLY);
    }

    public Operator rem(IConditional iConditional) {
        return assignValueOp(iConditional, Operation.MOD);
    }

    public Operator plus(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.PLUS);
    }

    public Operator minus(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.MINUS);
    }

    public Operator div(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.DIVISION);
    }

    public Operator times(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.MULTIPLY);
    }

    public Operator rem(BaseModelQueriable baseModelQueriable) {
        return assignValueOp(baseModelQueriable, Operation.MOD);
    }

    public Between between(BaseModelQueriable baseModelQueriable) {
        return new Between(baseModelQueriable);
    }

    public In in(BaseModelQueriable baseModelQueriable, BaseModelQueriable... baseModelQueriableArr) {
        return new In(baseModelQueriable, true, baseModelQueriableArr);
    }

    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder();
        appendConditionToQuery(queryBuilder);
        return queryBuilder.getQuery();
    }

    public Operator<T> concatenate(Object obj) {
        this.operation = new QueryBuilder(Operation.EQUALS).append(columnName()).toString();
        TypeConverter typeConverter = this.typeConverter;
        if (typeConverter == null && obj != null) {
            typeConverter = FlowManager.getTypeConverterForClass(obj.getClass());
        }
        if (typeConverter != null && this.convertToDB) {
            obj = typeConverter.getDBValue(obj);
        }
        if (!((obj instanceof String) || (obj instanceof IOperator))) {
            if (!(obj instanceof Character)) {
                if (obj instanceof Number) {
                    this.operation = String.format("%1s %1s ", new Object[]{this.operation, Operation.PLUS});
                    this.value = obj;
                    this.isValueSet = true;
                    return this;
                }
                String str = "Cannot concatenate the %1s";
                Object[] objArr = new Object[1];
                if (obj != null) {
                    obj = obj.getClass();
                } else {
                    obj = "null";
                }
                objArr[0] = obj;
                throw new IllegalArgumentException(String.format(str, objArr));
            }
        }
        this.operation = String.format("%1s %1s ", new Object[]{this.operation, Operation.CONCATENATE});
        this.value = obj;
        this.isValueSet = true;
        return this;
    }

    public Operator<T> concatenate(IConditional iConditional) {
        return concatenate((Object) iConditional);
    }

    public Between<T> between(T t) {
        return new Between(t);
    }

    @SafeVarargs
    public final In<T> in(T t, T... tArr) {
        return new In(t, true, tArr);
    }

    @SafeVarargs
    public final In<T> notIn(T t, T... tArr) {
        return new In(t, false, tArr);
    }

    public In<T> in(Collection<T> collection) {
        return new In((Collection) collection, true);
    }

    public In<T> notIn(Collection<T> collection) {
        return new In((Collection) collection, false);
    }

    public java.lang.String convertObjectToString(java.lang.Object r4, boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = r3.typeConverter;
        if (r0 == 0) goto L_0x002e;
    L_0x0004:
        r0 = r3.convertToDB;	 Catch:{ ClassCastException -> 0x0010 }
        if (r0 == 0) goto L_0x0028;	 Catch:{ ClassCastException -> 0x0010 }
    L_0x0008:
        r0 = r3.typeConverter;	 Catch:{ ClassCastException -> 0x0010 }
        r0 = r0.getDBValue(r4);	 Catch:{ ClassCastException -> 0x0010 }
        r4 = r0;
        goto L_0x0028;
    L_0x0010:
        r0 = com.raizlabs.android.dbflow.config.FlowLog.Level.I;
        r1 = new java.lang.StringBuilder;
        r2 = "Value passed to operation is not valid type for TypeConverter in the column. Preserving value ";
        r1.<init>(r2);
        r1.append(r4);
        r2 = " to be used as is.";
        r1.append(r2);
        r1 = r1.toString();
        com.raizlabs.android.dbflow.config.FlowLog.log(r0, r1);
    L_0x0028:
        r0 = 0;
        r4 = com.raizlabs.android.dbflow.sql.language.BaseOperator.convertValueToString(r4, r5, r0);
        return r4;
    L_0x002e:
        r4 = super.convertObjectToString(r4, r5);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.raizlabs.android.dbflow.sql.language.Operator.convertObjectToString(java.lang.Object, boolean):java.lang.String");
    }

    private Operator<T> assignValueOp(Object obj, String str) {
        this.operation = str;
        return value(obj);
    }
}
