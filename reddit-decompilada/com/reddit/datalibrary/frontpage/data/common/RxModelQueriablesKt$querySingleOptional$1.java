package com.reddit.datalibrary.frontpage.data.common;

import com.google.common.base.Optional;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010 \n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00022(\u0010\u0004\u001a$\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/google/common/base/Optional;", "T", "kotlin.jvm.PlatformType", "list", "", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RxModelQueriables.kt */
final class RxModelQueriablesKt$querySingleOptional$1<T, R> implements Function<T, R> {
    public static final RxModelQueriablesKt$querySingleOptional$1 f15722a = new RxModelQueriablesKt$querySingleOptional$1();

    RxModelQueriablesKt$querySingleOptional$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.b(list, "list");
        if ((list.size() <= 1 ? 1 : 0) != 0) {
            return (((Collection) list).isEmpty() ^ 1) != 0 ? Optional.m6896b(list.get(0)) : Optional.m6898e();
        } else {
            throw new IllegalArgumentException("Non-unique result returned".toString());
        }
    }
}
