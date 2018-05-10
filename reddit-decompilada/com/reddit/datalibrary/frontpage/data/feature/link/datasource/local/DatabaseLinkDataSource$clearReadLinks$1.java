package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.model.LinkMutationsDataModel;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "linkId", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseLinkDataSource.kt */
final class DatabaseLinkDataSource$clearReadLinks$1<T, R> implements Function<String, CompletableSource> {
    final /* synthetic */ DatabaseLinkDataSource f16016a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/reddit/datalibrary/frontpage/data/model/LinkMutationsDataModel;", "invoke"}, k = 3, mv = {1, 1, 9})
    /* compiled from: DatabaseLinkDataSource.kt */
    static final class C17191 extends Lambda implements Function1<LinkMutationsDataModel, Unit> {
        public static final C17191 f19364a = new C17191();

        C17191() {
            super(1);
        }

        public final /* synthetic */ Object m20623a(Object obj) {
            LinkMutationsDataModel linkMutationsDataModel = (LinkMutationsDataModel) obj;
            Intrinsics.b(linkMutationsDataModel, "$receiver");
            linkMutationsDataModel.setRead(false);
            return Unit.a;
        }
    }

    DatabaseLinkDataSource$clearReadLinks$1(DatabaseLinkDataSource databaseLinkDataSource) {
        this.f16016a = databaseLinkDataSource;
    }

    public final /* synthetic */ Object apply(Object obj) {
        String str = (String) obj;
        Intrinsics.b(str, "linkId");
        return this.f16016a.m15956a(new LinkMutationsDataModel(str, false, 0, false, false, 30, null), (Function1) C17191.f19364a);
    }
}
