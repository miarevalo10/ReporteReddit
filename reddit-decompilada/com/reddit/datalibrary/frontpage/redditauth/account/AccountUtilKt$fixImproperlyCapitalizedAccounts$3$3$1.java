package com.reddit.datalibrary.frontpage.redditauth.account;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\u000e\b\u0001\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00040\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "", "it", "", "", "kotlin.jvm.PlatformType", "apply", "([Ljava/lang/Object;)Ljava/util/List;"}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountUtilKt.kt */
final class AccountUtilKt$fixImproperlyCapitalizedAccounts$3$3$1<T, R> implements Function<Object[], R> {
    public static final AccountUtilKt$fixImproperlyCapitalizedAccounts$3$3$1 f16283a = new AccountUtilKt$fixImproperlyCapitalizedAccounts$3$3$1();

    AccountUtilKt$fixImproperlyCapitalizedAccounts$3$3$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Object[] objArr = (Object[]) obj;
        Intrinsics.b(objArr, "it");
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj2 : objArr) {
            if (obj2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            arrayList.add((String) obj2);
        }
        return (List) arrayList;
    }
}
