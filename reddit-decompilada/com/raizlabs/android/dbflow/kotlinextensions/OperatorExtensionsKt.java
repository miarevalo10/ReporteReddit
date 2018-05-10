package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.annotation.Collate;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.Operator.Between;
import com.raizlabs.android.dbflow.sql.language.Operator.In;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\u0004¢\u0006\u0002\u0010\u0006\u001a:\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\u0004¢\u0006\u0002\u0010\b\u001a%\u0010\u0000\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0004\u001a\u0015\u0010\u0000\u001a\u00020\t*\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0004\u001a\u0015\u0010\u0000\u001a\u00020\t*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0004\u001a+\u0010\r\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0004\u001a\n\u0010\u000f\u001a\u00020\t*\u00020\f\u001a3\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0004\u001a3\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0013H\u0004\u001a\"\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0004*\u00020\u0015\u001a\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0004*\u00020\u0013\u001a%\u0010\u0016\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0004\u001a\u0015\u0010\u0016\u001a\u00020\t*\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0004\u001a\u0015\u0010\u0016\u001a\u00020\t*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0004\u001a+\u0010\u0017\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0004\u001a3\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0013H\u0004¨\u0006\u0019"}, d2 = {"and", "Lcom/raizlabs/android/dbflow/sql/language/Operator$Between;", "T", "kotlin.jvm.PlatformType", "", "value", "(Lcom/raizlabs/android/dbflow/sql/language/Operator$Between;Ljava/lang/Object;)Lcom/raizlabs/android/dbflow/sql/language/Operator$Between;", "Lcom/raizlabs/android/dbflow/sql/language/Operator$In;", "(Lcom/raizlabs/android/dbflow/sql/language/Operator$In;Ljava/lang/Object;)Lcom/raizlabs/android/dbflow/sql/language/Operator$In;", "Lcom/raizlabs/android/dbflow/sql/language/OperatorGroup;", "Lcom/raizlabs/android/dbflow/sql/language/Operator;", "sqlOperator", "Lcom/raizlabs/android/dbflow/sql/language/SQLOperator;", "andAll", "", "clause", "collate", "collation", "Lcom/raizlabs/android/dbflow/annotation/Collate;", "", "op", "Lcom/raizlabs/android/dbflow/sql/language/NameAlias;", "or", "orAll", "postfix", "dbflow-kotlinextensions_release"}, k = 2, mv = {1, 1, 7})
/* compiled from: OperatorExtensions.kt */
public final class OperatorExtensionsKt {
    public static final OperatorGroup clause(SQLOperator sQLOperator) {
        Intrinsics.b(sQLOperator, "$receiver");
        return OperatorGroup.clause(sQLOperator);
    }

    public static final <T> Operator<T> op(NameAlias nameAlias) {
        Intrinsics.b(nameAlias, "$receiver");
        return Operator.op(nameAlias);
    }

    public static final <T> Operator<T> op(String str) {
        Intrinsics.b(str, "$receiver");
        str = op(NameAliasExtensionsKt.getNameAlias(str));
        Intrinsics.a(str, "nameAlias.op<T>()");
        return str;
    }

    public static final <T> Operator<T> collate(Operator<T> operator, Collate collate) {
        Intrinsics.b(operator, "$receiver");
        Intrinsics.b(collate, "collation");
        return operator.collate(collate);
    }

    public static final <T> Operator<T> collate(Operator<T> operator, String str) {
        Intrinsics.b(operator, "$receiver");
        Intrinsics.b(str, "collation");
        return operator.collate(str);
    }

    public static final <T> Operator<T> postfix(Operator<T> operator, String str) {
        Intrinsics.b(operator, "$receiver");
        Intrinsics.b(str, "collation");
        return operator.postfix(str);
    }

    public static final <T> Between<T> and(Between<T> between, T t) {
        Intrinsics.b(between, "$receiver");
        return between.and(t);
    }

    public static final <T> In<T> and(In<T> in, T t) {
        Intrinsics.b(in, "$receiver");
        return in.and(t);
    }

    public static final <T> OperatorGroup and(Operator<T> operator, SQLOperator sQLOperator) {
        Intrinsics.b(operator, "$receiver");
        Intrinsics.b(sQLOperator, "sqlOperator");
        return OperatorGroup.clause(operator).and(sQLOperator);
    }

    public static final <T> OperatorGroup or(Operator<T> operator, SQLOperator sQLOperator) {
        Intrinsics.b(operator, "$receiver");
        Intrinsics.b(sQLOperator, "sqlOperator");
        return OperatorGroup.clause(operator).or(sQLOperator);
    }

    public static final <T> OperatorGroup andAll(Operator<T> operator, Collection<? extends SQLOperator> collection) {
        Intrinsics.b(operator, "$receiver");
        Intrinsics.b(collection, "sqlOperator");
        return OperatorGroup.clause(operator).andAll((Collection) collection);
    }

    public static final <T> OperatorGroup orAll(Operator<T> operator, Collection<? extends SQLOperator> collection) {
        Intrinsics.b(operator, "$receiver");
        Intrinsics.b(collection, "sqlOperator");
        return OperatorGroup.clause(operator).orAll((Collection) collection);
    }

    public static final OperatorGroup and(OperatorGroup operatorGroup, SQLOperator sQLOperator) {
        Intrinsics.b(operatorGroup, "$receiver");
        Intrinsics.b(sQLOperator, "sqlOperator");
        return operatorGroup.and(sQLOperator);
    }

    public static final OperatorGroup or(OperatorGroup operatorGroup, SQLOperator sQLOperator) {
        Intrinsics.b(operatorGroup, "$receiver");
        Intrinsics.b(sQLOperator, "sqlOperator");
        return operatorGroup.or(sQLOperator);
    }

    public static final OperatorGroup and(OperatorGroup operatorGroup, OperatorGroup operatorGroup2) {
        Intrinsics.b(operatorGroup, "$receiver");
        Intrinsics.b(operatorGroup2, "sqlOperator");
        return clause(operatorGroup).and(operatorGroup2);
    }

    public static final OperatorGroup or(OperatorGroup operatorGroup, OperatorGroup operatorGroup2) {
        Intrinsics.b(operatorGroup, "$receiver");
        Intrinsics.b(operatorGroup2, "sqlOperator");
        return clause(operatorGroup).or(operatorGroup2);
    }
}
