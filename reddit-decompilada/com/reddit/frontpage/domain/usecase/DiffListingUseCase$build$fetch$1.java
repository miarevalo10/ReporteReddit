package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.repository.LinkRepository;
import io.reactivex.Maybe;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b2\u0017\u0010\t\u001a\u0013\u0018\u00010\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "Lio/reactivex/Maybe;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "p1", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "Lkotlin/ParameterName;", "name", "sort", "p2", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "sortTimeFrame", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: DiffListingUseCase.kt */
final class DiffListingUseCase$build$fetch$1 extends FunctionReference implements Function2<SortType, SortTimeFrame, Maybe<Listing<? extends Link>>> {
    DiffListingUseCase$build$fetch$1(LinkRepository linkRepository) {
        super(2, linkRepository);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(LinkRepository.class);
    }

    public final String mo5687b() {
        return "getAllLocalFrontpageLinks";
    }

    public final String mo6932c() {
        return "getAllLocalFrontpageLinks(Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)Lio/reactivex/Maybe;";
    }

    public final /* bridge */ /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        return ((LinkRepository) this.b).m22414a((SortType) obj, (SortTimeFrame) obj2);
    }
}
