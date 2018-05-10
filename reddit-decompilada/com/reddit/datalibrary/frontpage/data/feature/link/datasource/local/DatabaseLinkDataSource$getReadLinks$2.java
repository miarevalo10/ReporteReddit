package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "list", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseLinkDataSource.kt */
final class DatabaseLinkDataSource$getReadLinks$2<T, R> implements Function<T, R> {
    public static final DatabaseLinkDataSource$getReadLinks$2 f16026a = new DatabaseLinkDataSource$getReadLinks$2();

    DatabaseLinkDataSource$getReadLinks$2() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.b(list, "list");
        return new Listing(list, null, null, null, 14, null);
    }
}
